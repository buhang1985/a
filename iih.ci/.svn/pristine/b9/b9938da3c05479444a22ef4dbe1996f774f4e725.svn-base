package iih.ci.ord.s.ems.ip.ems.icons;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsConsItemViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsConsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultConsCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSingleSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.ConsOrContentParam;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsIConsSaveBP extends BaseIpEmsSingleSaveBP {

	public EmsIConsSaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsIConsValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultConsCreateOrderInfo());
	}

	public EmsIConsSaveBP(IEmsValidate emsValidate) {

		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultConsCreateOrderInfo());
	}

	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		EmsSaveRstInfo emsSaveRstInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList()) ) {
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				if (objAppSheetInfo instanceof CiorappconsultAggDO) { // 会诊申请单保存
					((CiorappconsultAggDO)objAppSheetInfo).getParentDO().setId_or(opInfo.getOrderInfo().getId_or());
					CiOrdAppUtils.getOrappconsultService().save(
							opInfo.getOrderAppSheetList().toArray(new CiorappconsultAggDO[opInfo.getOrderAppSheetList().size()]));
				} 
			}
		}
		return emsSaveRstInfo;
	}

	
	/**
	 * 合并申请单
	 * @param ctx
	 * @param appSheetList
	 * @param extInfoList
	 * @param uiModel
	 * @throws BizException
	 */
	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)throws BizException{
		EmsConsViewDTO emsConsDto=(EmsConsViewDTO)uiModel;

		for(Object obj:appSheetList){
			CiorappconsultAggDO aggdo=(CiorappconsultAggDO)obj;
			ordApInfoFrom(emsConsDto,aggdo.getParentDO());
			List<CiordInviteConsDO> invitecons=new ArrayList<CiordInviteConsDO>();
			if(!CiOrdUtils.isEmpty(emsConsDto.getExtInfoList())){
				for(Object itemdo:emsConsDto.getExtInfoList()){
					EmsConsItemViewDTO consitem=(EmsConsItemViewDTO)itemdo;
					invitecons.add(consItemInfoFrom(consitem));
				}
			}
			if(invitecons.size()>0){
				aggdo.setCiordInviteConsDO(invitecons.toArray(new CiordInviteConsDO[invitecons.size()]));
			}
		}
	}

	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{

		return null;
	}

	/**
	 * 会诊申请单映射
	 * @param emsConsDto
	 * @return
	 * @throws BizException 
	 */
	private void ordApInfoFrom(OrderListViewDTO viewDTO,OrdApConsDO consdo) throws BizException{
		//		consdo.setId_apcons();
		//			consdo.setId_or(emsConsDto.getId_or());
		consdo.setNo_applyform(viewDTO.getNo_applyform());
		consdo.setDt_ap(CiOrdAppUtils.getServerDateTime());	
		//		consdo.setTel(emsConsDto.getTel());

		consdo.setFg_urgent(viewDTO.getFg_urgent());
		consdo.setDt_plan(viewDTO.getDt_effe());
		MedSrvConsDO srvcons=getMedSrvConsDO(viewDTO.getId_srv());
		if(FBoolean.TRUE.equals(consdo.getFg_urgent())){
			consdo.setDt_constimelimit(OrderUtils.getConsTimeLimit(srvcons.getId_unit_urg(),srvcons.getQuan_urg_constimelimit(),viewDTO.getDt_effe()));
		}else{
			if(!CiOrdUtils.isEmpty(srvcons.getId_unit()) && !CiOrdUtils.isEmpty(srvcons.getQuan_constimelimit())){
				consdo.setDt_constimelimit(OrderUtils.getConsTimeLimit(srvcons.getId_unit(),srvcons.getQuan_constimelimit(),viewDTO.getDt_effe()));
			}
			
		}
		if(CiOrdUtils.isTrue(srvcons.getFg_audit_clidep())){
			consdo.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSSP);
			consdo.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSSP);
		}else if(CiOrdUtils.isTrue(srvcons.getFg_audit_admdep())){
			consdo.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DYWSP);
			consdo.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DYWSP);
		}else{
			consdo.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSYD);
			consdo.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSYD);
		}
		if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
			EmsConsViewDTO emsConsDto=(EmsConsViewDTO)viewDTO;
			consdo.setDes_emr(emsConsDto.getDes_emr());
			consdo.setDt_plan(emsConsDto.getDt_plan());
			consdo.setPlace(emsConsDto.getPlace());	
			consdo.setDes_psp(emsConsDto.getDes_psp());
		}
	}



	/**
	 * 会诊受邀对象映射
	 * @param consitems
	 * @return
	 */
	private CiordInviteConsDO consItemInfoFrom(EmsConsItemViewDTO consitem){
		CiordInviteConsDO item=new CiordInviteConsDO();
		//			item.setId_invitecons();
		//			item.setId_apcons();
		item.setId_org(consitem.getId_org());
		item.setId_dep(consitem.getId_dep());
		item.setId_emp(consitem.getId_emp());	
		item.setSd_emp_title(consitem.getSd_emp_title());	
		item.setId_emp_title(consitem.getId_emp_title());
		item.setStatus(DOStatus.NEW);
		//			item.setFg_response();
		//			item.setDt_response();
		//			item.setId_emp_response();	
		//			item.setFg_join_cons();	
		//			item.setJudgcons();
		return item;
	}

	/**
	 * 获取会诊服务DO
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvConsDO getMedSrvConsDO(String id_srv) throws BizException {
		MedSrvConsDO[] conslist = ServiceFinder.find(IMedSrvConsDORService.class).find(" id_srv='" + id_srv + "'", null,
				FBoolean.FALSE);
		if (conslist == null || conslist.length == 0)
			return null;
		return conslist[0];
	}
	/**
	 * 医嘱内容拼接
	 * @param ctx
	 * @param uiModel
	 * @return
	 */
	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx,Object uiModel){
		OrderListViewDTO uiDto=(OrderListViewDTO)uiModel;
		ConsOrContentParam param=new ConsOrContentParam();
		param.setName_srv(uiDto.getName_srv());
		param.setPri(uiDto.getPri());
		param.setIsmuldose(uiDto.getIsmuldose());
		param.setIsmulexec(uiDto.getIsmulexec());
		param.setSd_srvtp(uiDto.getSd_srvtp());
		param.setSd_nodispense(uiDto.getSd_nodispense());
		String invates="";
		if(!CiOrdUtils.isEmpty(uiDto.getExtInfoList()) && uiDto.getExtInfoList().size()>0){
			for(Object obj:uiDto.getExtInfoList()){
				invates+=",";
				EmsConsItemViewDTO consItem=(EmsConsItemViewDTO)obj;
				if(!CiOrdUtils.isEmpty(consItem.getName_dep())){
					invates+=consItem.getName_dep();
				}
				if(!CiOrdUtils.isEmpty(consItem.getName_emp())){
					invates+=consItem.getName_emp();
				}
			}
		}

		if(invates.length()>0){
			param.setStr_invate(invates.substring(1));
		}
		return CiOrContentUtils.create(param);
	}
}
