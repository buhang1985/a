package iih.ci.ord.s.external.thirdws.op.lis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.i.ICiapplissheetCudService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisOrdDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisPrintDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisSrvDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EntWsLisDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeSendToMPBP;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.ci.ord.s.external.thirdws.utils.BdDiDefUtils;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.xbd.udi.d.UdidocDO;

public class EmsLisSaveAction extends OpCommonSaveAction{
	/**
	 * 初始化检验过程状态  
	 */
	private static String ID_SU_LAB = "@@@@Z81000000011R04M";
	private static String SD_SU_LAB = "0";
	/**
	 * *                 父                                子                                         孙                                   曾孙
	 * @code 数据重组      EntWsLisDTO EmsLisPringDTO EmsLisOrdDTO EmsLisSrvDTO
	 * @author LiYue
	 * @date 2019年6月18日,上午9:23:54
	 * @param this.getEntdo()
	 * @return
	 * @throws BizException 
	 */
	@Override
	public String save(EntWsDTO entdto) throws BizException {
		super.save(entdto);
		EntWsLisDTO entlisdto = (EntWsLisDTO)entdto;
		//设置Agg容器
		List<CiorderAggDO> ciorderAggDOList = new ArrayList<>();
		List<CiapplissheetAggDO> ciapplissheetAggList = new ArrayList<>();
		List<OrdApLabDO> lisLabList = new ArrayList<>();
		//获取打印list
		List<EmsLisPrintDTO> printList = entlisdto.getPrintList();
		for (EmsLisPrintDTO emsLisPrintDTO : printList) {
			String[] id_sheet = new DBUtil().getOIDs(1);
			//组装打印数据
			CiAppLisSheetDO lisSheetDo = assembleLisSheet(emsLisPrintDTO,id_sheet,emsLisPrintDTO.getOrdList().get(0));
			List<CiAppLisSheetOrDO> lisOrList = new ArrayList<>();
			//获取医嘱list
			for (EmsLisOrdDTO lisOrdDTO : emsLisPrintDTO.getOrdList()) {
				CiorderAggDO aggdo = assebleOrderAgg(lisOrdDTO);
				//生成主键和申请单主键
				String[] Id_orlab = new DBUtil().getOIDs(2);
				aggdo.getParentDO().setId_or(Id_orlab[1]);
				CiOrderDO orderDO = aggdo.getParentDO();
				assebleLisOrder(orderDO,lisOrdDTO,aggdo);
				aggdo.setParent(orderDO);
				
				//检验申请单
				OrdApLabDO ordApLabDO = assebleOrdApLabDO(orderDO,Id_orlab[0], lisSheetDo, lisOrdDTO);
				orderDO.setApplyno(ordApLabDO.getNo_applyform());
				for (OrdSrvDO srv : aggdo.getOrdSrvDO()) {
					srv.setId_or(orderDO.getId_or());
					assebleSrvDO(srv);
				}
				//打印子表
				CiAppLisSheetOrDO lisOrDo = new CiAppLisSheetOrDO();
				//设置子表价格
				assebleCiAppLisSheetOrDO(aggdo.getOrdSrvDO(),orderDO,lisOrdDTO,lisOrDo);
				lisOrDo.setStatus(DOStatus.NEW);
				lisOrDo.setId_orlab(Id_orlab[0]);
				lisOrDo.setId_ciapplissheet(id_sheet[0]);
				lisOrDo.setId_or(orderDO.getId_or());
				lisOrList.add(lisOrDo);
				
				//打印补充
				lisSheetDo.setId_di(orderDO.getId_didef());
				lisSheetDo.setId_diitm(orderDO.getId_didef());
				lisSheetDo.setName_diag(orderDO.getName_didef());
				//计算总金额 将子表叠加
				FDouble price_total = FDouble.ZERO_DBL;
				for (CiAppLisSheetOrDO Sheet : lisOrList) {
					price_total.add(Sheet.getAmt_app());
				}
				lisSheetDo.setAmt_app_total(price_total);
				lisLabList.add(ordApLabDO);
				ciorderAggDOList.add(aggdo);
			}
			//打印数据放入集合
			CiapplissheetAggDO ciapplissheetAggDO = new CiapplissheetAggDO();
			ciapplissheetAggDO.setParent(lisSheetDo);
			ciapplissheetAggDO.setCiAppLisSheetOrDO(lisOrList.toArray(new CiAppLisSheetOrDO[0]));
			ciapplissheetAggList.add(ciapplissheetAggDO);
			
		}
		CiorderAggDO[] CiAggDo = ciorderAggDOList.toArray(new CiorderAggDO[0]);
		CiapplissheetAggDO[] lisAggDo = ciapplissheetAggList.toArray(new CiapplissheetAggDO[0]);
		//保存方法
		EmsRstDTO rstDTO= save(CiAggDo,lisAggDo,lisLabList.toArray(new OrdApLabDO[0]));
		ConvertDTOs2XmlUtils util = new ConvertDTOs2XmlUtils();
		//返回XML
		return util.exec(new EmsRstDTO[]{rstDTO}, "root", "");
	}
	/*
	 *  计算价格
	 */
	private void assebleCiAppLisSheetOrDO(OrdSrvDO[] ordSrvDO, CiOrderDO orderDO, EmsLisOrdDTO lisOrdDTO, CiAppLisSheetOrDO lisOrDo) {
        //总金额
		FDouble price_total = FDouble.ZERO_DBL;
		for (OrdSrvDO srv : ordSrvDO) {
			if(FDoubleUtils.isNullOrZero(srv.getPri()) || FBoolean.FALSE.equals(srv.getFg_bl()))
				continue;
			// 单价
			FDouble pri = new FDouble(srv.getPri());
			// 次数
			FDouble Times_cur = new FDouble(orderDO.getTimes_cur());
			// 单次数量
			FDouble quan_medu_or = new FDouble(lisOrdDTO.getQuan_medu_or());
			
			if (FDoubleUtils.isNotNullOrZero(pri) && FDoubleUtils.isNotNullOrZero(Times_cur)
					&& FDoubleUtils.isNotNullOrZero(quan_medu_or)) {
				price_total.add(pri.multiply(Times_cur).multiply(quan_medu_or));
			}
		}
		lisOrDo.setAmt_app(price_total);
	}
	private void assebleSrvDO(OrdSrvDO srv) {
		srv.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
		srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		srv.setId_en(this.getEntdo().getId_ent());
		srv.setId_pat(this.getEntdo().getId_pat());
		srv.setId_entp(this.getEntdo().getId_entp());
		srv.setCode_entp(this.getEntdo().getCode_entp());
		srv.setEu_sourcemd(0);
	}
	private void assebleLisOrder(CiOrderDO orderDO, EmsLisOrdDTO lisOrdDTO, CiorderAggDO aggdo) throws BizException {
		//医嘱拼接
		orderDO.setContent_or(CiOrContentUtils
				.create(orderDO.getSd_srvtp(), aggdo.getOrdSrvDO()[0].getName(), orderDO.getRoute_name(), orderDO.getFg_urgent())
				.toString());
		orderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		orderDO.setId_dep_or(getDep(lisOrdDTO.getCode_dep_or()).getId_dep());
		orderDO.setDt_effe(new FDateTime(lisOrdDTO.getDt_plan()));
		orderDO.setId_srvca(aggdo.getOrdSrvDO()[0].getId_srvca());
		orderDO.setId_srvtp(aggdo.getOrdSrvDO()[0].getId_srvtp());
		orderDO.setId_dep_mp(getDep(lisOrdDTO.getCode_dep_mp_or()).getId_dep());
		orderDO.setApplyno(lisOrdDTO.getNo_applyform());
		//诊断
		if(StringUtils.isNotEmpty(lisOrdDTO.getCode_diag())){
			DiagDefDO didef = BdDiDefUtils.getDiagDefDOByCode(lisOrdDTO.getCode_diag());
			if(didef!=null){
				LogUtils.Logger("传入的诊断编码编码在his中不存在："+lisOrdDTO.getCode_diag());
				orderDO.setId_didef(didef.getId_didef());
				orderDO.setCode_didef(didef.getCode());
				orderDO.setName_didef(didef.getName());
			}
		}
		
	}
	//组装申请单
	private OrdApLabDO assebleOrdApLabDO(CiOrderDO orderDO, String id_orlab, CiAppLisSheetDO lisSheetDo, EmsLisOrdDTO lisOrdDTO) throws BizException {
		//标本
		UdidocDO biaoben = UdidocUtils.getUdidocByCode("BD.SRV.0555", lisOrdDTO.getSd_samptp());
				//标本采集时间
		UdidocDO biaobenTime = UdidocUtils.getUdidocByCode("BD.BC.0600", lisOrdDTO.getSd_sampcollecttimetp());
				
		OrdApLabDO ordApLabDO = new OrdApLabDO();
		ordApLabDO.setStatus(DOStatus.NEW);
		ordApLabDO.setId_or(orderDO.getId_or());
		ordApLabDO.setId_orlab(id_orlab);
		ordApLabDO.setId_samptp(biaoben.getId_udidoc());
//		ordApLabDO.setId_sampcoltime(biaobenTime.getId_udidoc());
//		ordApLabDO.setSd_sampcoltime(lisOrdDTO.getSd_sampcollecttimetp());
		ordApLabDO.setId_sampcollecttimetp(biaobenTime.getId_udidoc());
		//检验申请补充
		ordApLabDO.setId_di(orderDO.getId_didef());
		ordApLabDO.setId_diitm(orderDO.getId_didef());
		ordApLabDO.setName_diag(orderDO.getName_didef());
		ordApLabDO.setStr_id_diitm(orderDO.getId_didef());
		ordApLabDO.setStr_name_di(orderDO.getName_didef());
		ordApLabDO.setStr_code_di(orderDO.getCode_didef());
		ordApLabDO.setNo_applyform(CiOrdUtils.getApplyNo(orderDO.getSd_srvtp()));
		ordApLabDO.setId_su_lab(ID_SU_LAB);
		ordApLabDO.setSd_su_lab(SD_SU_LAB);
		ordApLabDO.setSd_samptp(lisOrdDTO.getSd_samptp());
		
		ordApLabDO.setSd_sampcollecttimetp(lisOrdDTO.getSd_sampcollecttimetp());
		ordApLabDO.setDt_plan(new FDateTime(lisOrdDTO.getDt_plan()));
		//0179265: 急诊系统接口增加两个参数，容器类型的code和id [南大象湖]
		ordApLabDO.setId_contp(lisOrdDTO.getId_contp());
		ordApLabDO.setSd_contp(lisOrdDTO.getSd_contp());
		return ordApLabDO;
	}
	//保存入库
	public EmsRstDTO save(CiorderAggDO[] CiAggDo , CiapplissheetAggDO[] lisAggDo , OrdApLabDO[] LablisDO) throws BizException {
		EmsRstDTO retdto = new EmsRstDTO();
		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
		ICiapplissheetCudService lisService = ServiceFinder.find(ICiapplissheetCudService.class);
		ICiorapplisCudService LablisService = ServiceFinder.find(ICiorapplisCudService.class);
		try {
			CiAggDo = service.save(CiAggDo);
			lisService.save(lisAggDo);
			LablisService.save(LablisDO);
			retdto.setResultcode("0");
			retdto.setResultmsg("检验保存成功！");
			LogUtils.Logger("检验保存成功----------");
			this.fireSignEvent(CiAggDo);
			//检验合单
			LogUtils.Logger("检验签署后操作----------");
			getMergeTubeSendToMPBP(lisAggDo,CiAggDo[0].getParentDO().getId_org());
		} catch (Exception e) {
			retdto.setResultcode("1");
			retdto.setResultmsg(e.toString());
			throw new BizException(e);
		}
		return retdto;
	}
	
	private void getMergeTubeSendToMPBP(CiapplissheetAggDO[] lisAggDo,String id_org) throws BizException {
		LogUtils.Logger("检验签署后调用执行域同步合管数据:组织id_org="+id_org+"----------");
		MergeTubeSendToMPBP MPbp = new MergeTubeSendToMPBP();
		CiEnContextDTO ctx = new CiEnContextDTO();
		ctx.setId_org(id_org);
		MPbp.exec(ctx, lisAggDo);
		
	}
	//组装打印
	public CiAppLisSheetDO assembleLisSheet(EmsLisPrintDTO emsLisPrintDTO, String[] id_sheet,EmsLisOrdDTO lisOrdDTO) throws BizException {
		//标本
		UdidocDO biaoben = UdidocUtils.getUdidocByCode("BD.SRV.0555", lisOrdDTO.getSd_samptp());
		//标本采集时间
		UdidocDO biaobenTime = UdidocUtils.getUdidocByCode("BD.BC.0600", lisOrdDTO.getSd_sampcollecttimetp());
		
		CiAppLisSheetDO lisSheetDo = new CiAppLisSheetDO();
		lisSheetDo.setStatus(DOStatus.NEW);
//		lisSheetDo.setAmt_app_total(new FDouble(emsLisPrintDTO.getAmt_app())); 后面会计算金额
		lisSheetDo.setCode_app(emsLisPrintDTO.getCode_app());
		lisSheetDo.setId_ciapplissheet(id_sheet[0]);
		lisSheetDo.setId_org(this.getEntdo().getId_org());
		lisSheetDo.setSd_samptp(lisOrdDTO.getSd_samptp());
		if(biaoben!=null)
		lisSheetDo.setId_samptp(biaoben.getId_udidoc());
		if(biaobenTime!=null)
		lisSheetDo.setId_sampcollecttimetp(biaobenTime.getId_udidoc());
		lisSheetDo.setSd_sampcollecttimetp(lisOrdDTO.getSd_sampcollecttimetp());
		lisSheetDo.setDt_plan(new FDateTime(lisOrdDTO.getDt_plan()));
		lisSheetDo.setId_sampcoltime(lisSheetDo.getId_sampcollecttimetp());
		lisSheetDo.setId_sampcollecttimetp(lisSheetDo.getId_sampcollecttimetp());
		lisSheetDo.setSd_sampcollecttimetp(lisSheetDo.getSd_sampcollecttimetp());
		lisSheetDo.setLen_sampcoltime(lisSheetDo.getLen_sampcoltime());
		lisSheetDo.setId_unit_sampcoltime(lisSheetDo.getId_unit_sampcoltime());
		lisSheetDo.setId_en(this.getEntdo().getId_ent());
		lisSheetDo.setId_pat(this.getEntdo().getId_pat());
		lisSheetDo.setId_entp(this.getEntdo().getId_entp());
		lisSheetDo.setCode_entp(this.getEntdo().getCode_entp());
	
		return lisSheetDo;
	}
	@Override
	public OrdSrvDO assembleSrv(BaseDTO srvdto) throws BizException {
		OrdSrvDO srvDo = super.assembleSrv(srvdto);
		EmsLisSrvDTO  lisSrvDTO = (EmsLisSrvDTO) srvdto;
		srvDo.setQuan_medu(new FDouble(lisSrvDTO.getQuan_medu_srv()));
		srvDo.setQuan_total_medu(new FDouble(lisSrvDTO.getQuan_medu_srv()));
		return srvDo;
	}
}
