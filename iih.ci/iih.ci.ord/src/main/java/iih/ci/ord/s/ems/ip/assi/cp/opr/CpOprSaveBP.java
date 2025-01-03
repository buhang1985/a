package iih.ci.ord.s.ems.ip.assi.cp.opr;

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
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.dws.ip.ems.d.EmsOprViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseCpSaveBP;
import iih.hp.cp.docinfodto.d.DocSrvinfoDTO;
import iih.hp.cp.docinfodto.d.DocinfoDTO;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import iih.hp.cp.ele.i.IHpCpElemOrderDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class CpOprSaveBP  extends BaseCpSaveBP {
	
	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		EmsSaveDTO tpl = ems[0];
		FArrayList labList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(labList))
			return null;
		DocinfoDTO docinfo = (DocinfoDTO) labList.get(0);		
		FArrayList srvinfoList = docinfo.getRefeleitems();
		for (Object object : srvinfoList) {
			FArrayList document = new FArrayList();
			String code_or=CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			DocSrvinfoDTO srv=(DocSrvinfoDTO) object;
			HpCpElemOrderDO[] ords=ServiceFinder.find(IHpCpElemOrderDORService.class).find(" id_ele='"+srv.getId_ele()+"'","",FBoolean.FALSE);
			if(ords!=null&&ords.length>0) {
				// 获取主服务信息
				MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(srv.getId_srv());
				// 拼装医疗单ui
				EmsOprViewDTO opr = new EmsOprViewDTO();
				setEmsViewInfo( ctx,  medSrvInfo, tpl.getDriverInfo(),
						opr,  code_or,  1,  ords[0]);
				// 计算物资流向科室
				this.setOrWfDeptInfo(ctx, medSrvInfo, opr);
				document.add(opr);
				EmsSaveDTO save = super.getEmsSaveDTO(document, tpl.getDriverInfo());
				return new EmsOprSave4CP().save(ctx, new EmsSaveDTO[] {save});
			}				
		}
		return null;
	}
	
	@Override
	protected void setEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo,
			OrderListViewDTO orderListViewDTO, String code_or, int index, HpCpElemOrderDO eleord) throws BizException {
		// TODO Auto-generated method stub		
		super.setEmsViewInfo(ctx, medSrvInfo, driverinfo, orderListViewDTO, code_or, index,eleord);
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
		opr.setExtInfoList(this.getOrdApSugViewItemDOs(ctx, driverinfo.getId_ems()));
		opr.setQuan_med((CiOrdUtils.isTrue(medSrvInfo.getIsmuldose()) ? eleord.getDosage() : new FDouble(1)));// 剂量
		opr.setDays_or(1);
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
