package iih.ci.ord.s.external.thirdws.op.ris;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.d.CiapprissheetAggDO;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisOrdDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisPrintDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EmsRisSrvDTO;
import iih.ci.ord.i.external.thirdws.ris.d.EntWsRisDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.ci.ord.s.external.thirdws.utils.BdDiDefUtils;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.xbd.udi.d.UdidocDO;

public class EmsRisSaveAction extends OpCommonSaveAction{
	public static final String  sd_su_obs="0";
	public static final String id_su_obs="@@@@AA1000000006JVIO";
	public static final String id_udidoclist_code="BD.SRV.1010";//检查部位list编码
	
	@Override
	public String save(EntWsDTO entwsdto) throws BizException {

		super.save(entwsdto);
		EntWsRisDTO  entWsRisDTO = (EntWsRisDTO)entwsdto;
		//获取就诊信息
		PatiVisitDO entdto = getEntDO(entWsRisDTO.getCode_en());
		//设置Agg容器
		List<CiorderAggDO> ciorderAggDOList = new ArrayList<>();
		//设置检查申请单容器
		List<CiapprissheetAggDO> CiapprissheetAggDOList = new ArrayList<>();
		List<OrdApObsDO> OrdApObsDOlist = new ArrayList<>();
		//获取打印list
		List<EmsRisPrintDTO> emsRisPrintDTOList = entWsRisDTO.getPrintList();
		
		for (EmsRisPrintDTO emsRisPrintDTO : emsRisPrintDTOList) {
			//组装打印数据
			CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
			List<CiAppRisSheetOrDO> ciAppRisSheetOrDOList = new ArrayList<>();
			
			ciAppRisSheetDO=assmbleRisSheet(emsRisPrintDTO);
			String[] id_sheet = new DBUtil().getOIDs(1);
			ciAppRisSheetDO.setId_ciapprissheet(id_sheet[0]);
			
			FDouble amt_app_all =FDouble.ZERO_DBL;
			List<EmsRisOrdDTO> ordList = emsRisPrintDTO.getOrdList();
			for (EmsRisOrdDTO emsRisOrdDTO : ordList) {
				
				//aggdo赋值
				CiorderAggDO aggdo = assebleOrderAgg(emsRisOrdDTO);
				//拼接医嘱内容
				CiOrderDO orderDO = aggdo.getParentDO();
				//
				UdidocDO udidoc = UdidocUtils.getUdidocByCode(id_udidoclist_code, emsRisOrdDTO.getSd_body());
				orderDO.setContent_or(CiOrContentUtils
						.create(orderDO.getSd_srvtp(),emsRisOrdDTO.getName_srv_or(), udidoc.getName(),FBoolean.FALSE)
						.toString());
				//生成主键
				String[] id_or = new DBUtil().getOIDs(2);
				//orderDO.setId_or(id_or[0]);
				assebleRisOrder(orderDO,emsRisOrdDTO,aggdo);
				assembleordSrvDO(aggdo,entdto,orderDO);
				

				ciorderAggDOList.add(aggdo);
				
				//打印子表
				CiAppRisSheetOrDO ciAppRisSheetOrDO = new CiAppRisSheetOrDO();
				ciAppRisSheetOrDO.setId_ciapprissheet(id_sheet[0]);
				//ciAppRisSheetOrDO.setAmt_app(new FDouble(ciAppRisSheetDO.getAmt_app()));
				
				ciAppRisSheetOrDO.setId_or(orderDO.getId_or());
				ciAppRisSheetOrDO.setId_orobs(id_or[1]);
				ciAppRisSheetOrDO.setId_srv(orderDO.getId_srv());
				ciAppRisSheetOrDO.setName_or(emsRisOrdDTO.getName_srv_or());
				ciAppRisSheetOrDO.setId_dep_app(orderDO.getId_dep_mp());
				ciAppRisSheetOrDO.setId_dep_mp(orderDO.getId_dep_mp());
				ciAppRisSheetOrDO.setId_emp_app(orderDO.getId_emp_or());
				ciAppRisSheetOrDO.setDt_app(orderDO.getDt_entry());
				ciAppRisSheetOrDO.setSd_pps(emsRisOrdDTO.getSd_pps());
				ciAppRisSheetOrDO.setId_pps(udidoc.getId_udidoc());
				ciAppRisSheetOrDO.setStatus(DOStatus.NEW);
				
				
				
				//打印补充
				ciAppRisSheetDO.setClinicalzztz(emsRisOrdDTO.getClinicalzztz());
				ciAppRisSheetDO.setSd_pps(emsRisOrdDTO.getSd_pps());
				ciAppRisSheetDO.setId_pps(udidoc.getId_udidoc());
				ciAppRisSheetDO.setSd_body(emsRisOrdDTO.getSd_body());
				ciAppRisSheetDO.setDt_plan(new FDateTime(emsRisOrdDTO.getDt_plan()));
				ciAppRisSheetDO.setNo_applyform(emsRisOrdDTO.getNo_applyform());
				ciAppRisSheetDO.setFg_hecominsur(new FBoolean(entWsRisDTO.getFg_hecominsur()));
				ciAppRisSheetDO.setFg_vip(new FBoolean(entWsRisDTO.getFg_vip()));
				ciAppRisSheetDO.setId_pat(entdto.getId_pat());
				ciAppRisSheetDO.setId_entp(entdto.getId_entp());
				ciAppRisSheetDO.setCode_entp(entdto.getCode_entp());
				ciAppRisSheetDO.setId_en(entdto.getId_ent());
				ciAppRisSheetDO.setId_grp(entdto.getId_grp());
				ciAppRisSheetDO.setId_org(entdto.getId_org());
				ciAppRisSheetDO.setId_dep_app(orderDO.getId_dep_mp());
				//ciAppRisSheetDO.setId_dep_app(orderDO.getId_dep_or());
				ciAppRisSheetDO.setId_emp_app(orderDO.getId_emp_or());
				ciAppRisSheetDO.setDt_app(orderDO.getDt_entry());
				
				//计算打印子表金额
				OrdSrvDO[] ordSrvDO = aggdo.getOrdSrvDO();
				FDouble amt_app = FDouble.ZERO_DBL;
				for (OrdSrvDO ordSrvDO2 : ordSrvDO) {
					if(FDoubleUtils.isNullOrZero(ordSrvDO2.getPri()) || FBoolean.FALSE.equals(ordSrvDO2.getFg_bl()))
						continue;
					//单次价格
					FDouble pri = ordSrvDO2.getPri();
					//次数
					Integer times_cur = orderDO.getTimes_cur();
					FDouble time_cur1=new FDouble(times_cur);
					//单次数量
					FDouble quan_medu = ordSrvDO2.getQuan_medu();
					if (time_cur1!=null) {
						FDouble amt_app_srv=time_cur1.multiply(quan_medu).multiply(pri);
						amt_app=amt_app_srv.add(amt_app);
					}
					
				}
				amt_app_all =amt_app.add(amt_app_all);
				ciAppRisSheetOrDO.setOr_total_pri(amt_app);
				ciAppRisSheetDO.setName_app(emsRisOrdDTO.getName_srv_or());
				
				ciAppRisSheetOrDOList.add(ciAppRisSheetOrDO);		
				//组装检验申请单
				OrdApObsDO ordApObsDO =assembleOrdApObs(emsRisOrdDTO,orderDO);
				orderDO.setApplyno(ordApObsDO.getNo_applyform());
				OrdApObsDOlist.add(ordApObsDO);
					
			}
			//打印主表金额
			ciAppRisSheetDO.setAmt_app(amt_app_all);
			//获取医嘱信息
			//打印数据放入集合
			CiapprissheetAggDO ciapprissheetAggDO = new CiapprissheetAggDO();
			ciapprissheetAggDO.setParent(ciAppRisSheetDO);
			ciapprissheetAggDO.setCiAppRisSheetOrDO(ciAppRisSheetOrDOList.toArray(new CiAppRisSheetOrDO[0]));
			CiapprissheetAggDOList.add(ciapprissheetAggDO);
			
			
		}
		//保存 医嘱，打印单，申请单信息
		String result=saveRisOrder(ciorderAggDOList.toArray(new CiorderAggDO[ciorderAggDOList.size()]),CiapprissheetAggDOList.toArray(new CiapprissheetAggDO[CiapprissheetAggDOList.size()]),OrdApObsDOlist.toArray(new OrdApObsDO[OrdApObsDOlist.size()]));
		//ConvertDTOs2XmlUtils util = new ConvertDTOs2XmlUtils();
		//返回XML
		//return util.exec(new EmsRstDTO[]{emsRstDTO}, "root", "");
		return result;
	
	}
	private String saveRisOrder(CiorderAggDO[] CiAggDo, CiapprissheetAggDO[] risAggDo, OrdApObsDO[] apObsDo) throws BizException {
		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
		ICiapprissheetCudService service1 = ServiceFinder.find(ICiapprissheetCudService.class);
		ICiorapprisCudService service2=ServiceFinder.find(ICiorapprisCudService.class);
		String result="";
		try {			
				service.save(CiAggDo);
				service1.save(risAggDo);
				service2.save(apObsDo);
				this.fireSignEvent(CiAggDo);
				
				result =getoutformMsg("0","检查医嘱信息保存成功");
		} catch (Exception e) {
			result =getoutformMsg("1",e.toString());
			throw new BizException(e);
		}
		return result;
	}

	public  String getoutformMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		sqlStr.append("<root>                                   \n");
		sqlStr.append(" 		<resultcode>" + code + "</resultcode>          \n");
		sqlStr.append(" 		<resultmsg>" + msg + "</resultmsg>     \n");
		sqlStr.append("</root>                                  \n");
		return sqlStr.toString();
	}

	private OrdApObsDO assembleOrdApObs(EmsRisOrdDTO emsRisOrdDTO,CiOrderDO orderDO) throws BizException {
		OrdApObsDO ordApObsDO = new OrdApObsDO();
		String[] id_or = new DBUtil().getOIDs(2);
		ordApObsDO.setStatus(DOStatus.NEW);
		ordApObsDO.setId_or(orderDO.getId_or());
		ordApObsDO.setId_orobs(id_or[1]);
		ordApObsDO.setId_di(orderDO.getId_didef());
		ordApObsDO.setNo_applyform(CiOrdUtils.getApplyNo(orderDO.getSd_srvtp()));
		ordApObsDO.setDt_plan(new FDateTime(emsRisOrdDTO.getDt_plan()));
		ordApObsDO.setName_diag(emsRisOrdDTO.getName_diag());
		ordApObsDO.setClinicalzztz(emsRisOrdDTO.getClinicalzztz());
		ordApObsDO.setSd_pps(emsRisOrdDTO.getSd_pps());
		UdidocDO udidoc = UdidocUtils.getUdidocByCode(id_udidoclist_code, emsRisOrdDTO.getSd_body());
		if(udidoc!=null){
			LogUtils.Logger("传入的检查部位编码在his中不存在"+emsRisOrdDTO.getSd_body());
			ordApObsDO.setId_pps(udidoc.getId_udidoc());
		}
		ordApObsDO.setFg_urgent(new FBoolean(emsRisOrdDTO.getFg_urgent()));
		ordApObsDO.setCreatedby(emsRisOrdDTO.getCode_emp_or());
		ordApObsDO.setCreatedtime(new FDateTime(emsRisOrdDTO.getDt_entry_or()));
		ordApObsDO.setSd_su_obs(sd_su_obs);
		ordApObsDO.setId_su_obs(id_su_obs);
		return ordApObsDO;
	}

	private CiAppRisSheetDO assmbleRisSheet(EmsRisPrintDTO emsRisPrintDTO) {
		CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
		ciAppRisSheetDO.setStatus(DOStatus.NEW);
		ciAppRisSheetDO.setCode_app(emsRisPrintDTO.getCode_app());
		
		//ciAppRisSheetDO.setAmt_app(new FDouble(emsRisPrintDTO.getAmt_app()));
		
		return ciAppRisSheetDO;
	}

	/*@Override
	public CiOrderDO assembleOrder(BaseDTO orddto) throws BizException {
		EmsRisOrdDTO lisOrdDTO = (EmsRisOrdDTO) orddto;
		CiOrderDO orderDO = new CiOrderDO();
		
		orderDO.setStatus(DOStatus.NEW);
		orderDO.setFg_sign(FBoolean.TRUE);
		orderDO.setSortno(new Integer(lisOrdDTO.getSortno_or()));
		orderDO.setCode_or(lisOrdDTO.getCode_or());
		orderDO.setName_or(lisOrdDTO.getName_srv_or());
		orderDO.setId_srv(lisOrdDTO.getCode_srv_or());
		
		orderDO.setFg_urgent(new FBoolean(lisOrdDTO.getFg_urgent()));
		orderDO.setQuan_medu(new FDouble(lisOrdDTO.getQuan_medu_or()));
		orderDO.setFg_pay_unit(new FBoolean(lisOrdDTO.getFg_pay_unit()));
		
		orderDO.setDes_or(lisOrdDTO.getDes_or());
	
		try {
			//orderDO.setId_org_or(getDep(lisOrdDTO.getCode_org_or()).getId_dep());
			orderDO.setId_dep_mp(getDep(lisOrdDTO.getCode_dep_mp_or()).getId_dep());
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO---需要转id------------
		orderDO.setId_dep_chk(lisOrdDTO.getCode_dep_or());
		orderDO.setId_emp_or(lisOrdDTO.getCode_emp_or());
		if(StringUtils.isNotEmpty(lisOrdDTO.getCode_diag())){
			DiagDefDO didef = BdDiDefUtils.getDiagDefDOByCode(lisOrdDTO.getCode_diag());
			orderDO.setId_didef(didef.getId_didef());
		}

		//--------
		//orderDO.setDt_entry(new FDateTime(lisOrdDTO.getDt_entry_or()));
		orderDO.setCode_didef(lisOrdDTO.getCode_diag());
		orderDO.setName_didef(lisOrdDTO.getName_diag());
		return orderDO;
	}*/

	@Override
	public OrdSrvDO assembleSrv(BaseDTO srvdto) throws BizException {
		OrdSrvDO srvDo = super.assembleSrv(srvdto);
		EmsRisSrvDTO  lisSrvDTO = (EmsRisSrvDTO) srvdto;
		srvDo.setQuan_medu(new FDouble(lisSrvDTO.getQuan_medu_srv()));
		srvDo.setQuan_total_medu(new FDouble(lisSrvDTO.getQuan_medu_srv()));
		return srvDo;
	}
	
	private void assebleRisOrder(CiOrderDO orderDO, EmsRisOrdDTO lisOrdDTO, CiorderAggDO aggdo) throws BizException {
		//医嘱拼接
		orderDO.setContent_or(CiOrContentUtils
				.create(orderDO.getSd_srvtp(), aggdo.getOrdSrvDO()[0].getName(), orderDO.getRoute_name(), orderDO.getFg_urgent())
				.toString());
		orderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		orderDO.setId_dep_or(getDep(lisOrdDTO.getCode_dep_or()).getId_dep());
		orderDO.setDt_sign(new FDateTime());
		orderDO.setId_srvca(aggdo.getOrdSrvDO()[0].getId_srvca());
		orderDO.setId_srvca(aggdo.getOrdSrvDO()[0].getId_srvtp());
		orderDO.setDt_effe(new FDateTime(lisOrdDTO.getDt_plan()));
		orderDO.setId_dep_mp(getDep(lisOrdDTO.getCode_dep_mp_or()).getId_dep());
		orderDO.setApplyno(lisOrdDTO.getNo_applyform());
		//诊断
		if(StringUtils.isNotEmpty(lisOrdDTO.getCode_diag())){
			DiagDefDO didef = BdDiDefUtils.getDiagDefDOByCode(lisOrdDTO.getCode_diag());
			if(didef!=null){
				orderDO.setId_didef(didef.getId_didef());
				orderDO.setCode_didef(didef.getCode());
				orderDO.setName_didef(didef.getName());
			}
		}
	}
	
	private OrdSrvDO[] assembleordSrvDO(CiorderAggDO aggdo,PatiVisitDO entdto,CiOrderDO orderDO) {
		OrdSrvDO[] ordSrvDO = aggdo.getOrdSrvDO();
		for (OrdSrvDO srv : ordSrvDO) {
			srv.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
			srv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			srv.setId_en(entdto.getId_ent());
			srv.setId_pat(entdto.getId_pat());
			srv.setId_entp(entdto.getId_entp());
			srv.setCode_entp(entdto.getCode_entp());
			srv.setId_or(orderDO.getId_or());
			srv.setEu_sourcemd(0);
		}
		return ordSrvDO;
	}
	
}
