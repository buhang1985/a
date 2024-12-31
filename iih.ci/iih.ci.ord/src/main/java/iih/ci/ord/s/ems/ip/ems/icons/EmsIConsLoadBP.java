package iih.ci.ord.s.ems.ip.ems.icons;

import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.dws.ip.ems.d.EmsConsItemViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsConsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsIConsLoadBP extends BaseIpEmsLoadBP{
	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx,args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		OrderPackageInfo[] szOrderPackageInfo = this.orderPakageInfoArrayFrom(new String[] { arg.getId_or() });
		if (CiOrdUtils.isEmpty(szOrderPackageInfo)) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取医疗单信息失败！");
			rst.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { rst };
		}
		OrderPackageInfo opInfo = szOrderPackageInfo[0];
		EmsConsViewDTO ems = modelFrom(ctx, opInfo);
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto=(OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, ems);
		}
		ems.setFg_selfpay(FBoolean.TRUE.equals(ems.getFg_orhp())?FBoolean.FALSE:FBoolean.TRUE);
		//医疗单驱动
		ems.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		rst.setDocument(this.handleReturnDocument(ems));
		return rsts;
	}

	public EmsConsViewDTO modelFrom(CiEnContextDTO ctx, OrderPackageInfo opInfo) throws BizException {

		EmsConsViewDTO emsconsdto = new EmsConsViewDTO();
		emsconsdto.setStatus(DOStatus.UPDATED);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsconsdto);
		MedSrvConsDO srvcons = getMedSrvConsDO(opInfo.getOrderInfo().getId_srv());
		CiorappconsultAggDO ciOrAppConsultAggInfo = (CiorappconsultAggDO) opInfo.getOrderAppSheetList().get(0);
		emsconsdto.setDt_plan(ciOrAppConsultAggInfo.getParentDO().getDt_plan());//
		emsconsdto.setDes_psp(ciOrAppConsultAggInfo.getParentDO().getDes_psp()); // 会诊目的
		emsconsdto.setDes_emr(ciOrAppConsultAggInfo.getParentDO().getDes_emr()); // 病历摘要
		emsconsdto.setPlace(ciOrAppConsultAggInfo.getParentDO().getPlace()); // 会诊地点
		emsconsdto.setSv(opInfo.getOrderInfo().getSv()); // sv
		emsconsdto.setFg_inorg(srvcons.getFg_inorg());
		emsconsdto.setFg_deps(srvcons.getFg_deps());
		emsconsdto.setFg_emptitlelimit(srvcons.getFg_emptitlelimit());
		emsconsdto.setId_emptitle(srvcons.getId_emptitle());
		emsconsdto.setSd_emptitle(srvcons.getSd_emptitle());
		emsconsdto.setNo_applyform(ciOrAppConsultAggInfo.getParentDO().getNo_applyform());
		constructConsEmpInfo(emsconsdto, ciOrAppConsultAggInfo.getCiordInviteConsDO());

		return emsconsdto;
	}

	/**
	 * 构建会诊人员信息
	 * 
	 * @param ems
	 * @param agg
	 */
	private void constructConsEmpInfo(EmsConsViewDTO emsconsdto, CiordInviteConsDO[] inviteConsdtos) {
		if (inviteConsdtos == null)
			return;
		FArrayList listEmsConsItemViewDTO = new FArrayList();
		StringBuilder inventmsg=new StringBuilder();
		for (CiordInviteConsDO item : inviteConsdtos) {
			EmsConsItemViewDTO consitemdto = new EmsConsItemViewDTO();

			consitemdto.setId_dep(item.getId_dep());
			consitemdto.setName_dep(item.getName_dep());
			consitemdto.setId_emp(item.getId_emp());
			consitemdto.setName_emp(item.getName_emp());
			consitemdto.setId_emp_title(item.getId_emp_title());
			consitemdto.setSd_emp_title(item.getSd_emp_title());
			consitemdto.setId_invitecons(item.getId_invitecons());

			listEmsConsItemViewDTO.add(consitemdto);
			inventmsg.append(","+item.getName_dep());
		}
		// emsconsdto.setDep_invitors(inviteConsdtos[0].getId_dep()); //受邀方

		emsconsdto.setExtInfoList(listEmsConsItemViewDTO);
		if(inventmsg.length()>0){
			emsconsdto.setInventmsg(inventmsg.substring(1));
		}
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

}
