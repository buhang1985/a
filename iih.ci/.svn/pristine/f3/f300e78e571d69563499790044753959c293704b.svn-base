package iih.ci.ord.s.ems.ip.assi.tpl.opr;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrtmplMDORService;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsOprViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.assi.base.BaseIpTplSaveBP;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术模板保存
 * @author Young
 *
 */
public class TplOprSaveBP extends BaseIpTplSaveBP {
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		EmsSaveDTO tpl = szEms[0];
		FArrayList oprList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(oprList))
			return null;
		for (Object object : oprList) {
//			String code_or = CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			OrTplNItmDO ortplnitmdo = (OrTplNItmDO) object;
			OrTmplDO ortmpldo = ServiceFinder.find(IOrtmplMDORService.class).findById(ortplnitmdo.getId_ortmpl());
			MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ortplnitmdo.getId_srv());
			EmsOprViewDTO opr = new EmsOprViewDTO();
			this.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, tpl.getDriverInfo(), opr, code_or, 1);
			// 计算物资流向科室
			this.setOrWfDeptInfo(ctx, medSrvInfo, opr);
			FArrayList docmuent = new FArrayList();
			docmuent.append(opr);
			EmsSaveDTO save = super.getEmsSaveDTO(docmuent, tpl.getDriverInfo());
			// 反射调用医疗单加载方法
			return ReflClassUtils.ReflCallWith(save.getDriverInfo().getEmsBackendDriver(), "save", ctx,
					EmsSaveDTO[].class, new EmsSaveDTO[] { save });
		}
		
		return null;
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, OrTmplDO ortmpldo, OrTplNItmDO ortplnitmdo, MedSrvDO medSrvInfo, 
			EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index) throws BizException {
		super.setEmsViewInfo(ctx, ortmpldo, ortplnitmdo, medSrvInfo, driverinfo, orderListViewDTO, code_or, index);
		MedSrvOpDO[] medSrvOpDOs = ServiceFinder.find(IMedSrvOpDORService.class).find(String.format("a3.id_srv='%s'", medSrvInfo.getId_srv()), "", FBoolean.FALSE);
		MedSrvOpDO medSrvOpDO = medSrvOpDOs[0];

		EmsOprViewDTO opr = (EmsOprViewDTO) orderListViewDTO;
		opr.setId_datelimittype(ICiDictCodeConst.ID_OPDATE_LIMITTP_ZQ);;//手术时限
		opr.setSd_datelimittype(ICiDictCodeConst.SD_OPDATE_LIMITTP_ZQ);//手术时限
		opr.setName_datelimittype(ICiDictCodeConst.NAME_OPDATE_LIMITTP_ZQ);//手术时限
		opr.setDt_plan(opr.getDt_effe());//计划手术时间
		opr.setNo_applyform(CiOrdUtils.getApplyNo(medSrvInfo.getSd_srvtp()));//手术单号
		opr.setId_lvlsug(medSrvOpDO.getId_opclass());//手术级别ID
		opr.setSd_lvlsug(medSrvOpDO.getSd_opclass());//手术级别编码
		opr.setName_lvlsug(medSrvOpDO.getName_opclass());//手术级别
		opr.setFg_patho(FBoolean.TRUE);//冰冻处理标识
		opr.setFg_allergy(FBoolean.FALSE);//药物过敏标识
		opr.setTimes_cur(1);
	}
	
	/**
	 * 获取动态指标集合
	 * @param ctx
	 * @param id_srvof
	 * @return
	 * @throws BizException
	 */
	protected FArrayList getOrdApSugViewItemDOs(CiEnContextDTO ctx, String id_srvof) 
			throws BizException {
		EmsregistryAggDO emsRegAggDO = ServiceFinder.find(IEmsregistryRService.class).findById(id_srvof);
		if (emsRegAggDO == null || emsRegAggDO.getParentDO() == null){
			return null;
		}

		EmsDynamicParamDTO paramDTO = new EmsDynamicParamDTO();
		paramDTO.setId_ems(id_srvof);
		paramDTO.setId_ent(ctx.getId_en());
		paramDTO.setId_pat(ctx.getId_pat());
		paramDTO.setFg_dyncitm_en(emsRegAggDO.getParentDO().getFg_dyncitm_crossentp().booleanValue());
		paramDTO.setEu_dyncitmunit(emsRegAggDO.getParentDO().getEu_dyncitmunit());
		paramDTO.setDyncitmunitct (emsRegAggDO.getParentDO().getCnt_dyncitmunit());

		EmsDynamicIndexDTO[] dtos = ServiceFinder.find(IBdSrvQryService.class).getEmsDynamicIndexInfos(paramDTO);
		FArrayList rstList = new FArrayList();
		for (EmsDynamicIndexDTO dto : dtos) {
			OrdApSugViewItemDO item = new OrdApSugViewItemDO();
			item.setVal_rstrptla(dto.getIndexval() == null ? "" : dto.getIndexval());
			item.setVal_restrptlab(dto.getEnumvalues() == null ? "" : "|" + dto.getEnumvalues().replace(',', '|'));
			item.setSd_restrptlabtp(dto.getDatatype());
			item.setId_srv(dto.getId_srv());
			item.setName_srv(dto.getShowname());
			item.setId_unit(dto.getId_unit());
			item.setName_unit(dto.getUnitname());
			item.setStatus(DOStatus.NEW);
			rstList.append(item);
		}

		return rstList;
	}
}
