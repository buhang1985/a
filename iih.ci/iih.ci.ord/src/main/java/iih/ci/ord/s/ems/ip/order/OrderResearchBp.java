package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.meta.RscProjParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.ems.itf.bp.IOrderResearchBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱科研确认
 * @author Young
 *
 */
public class OrderResearchBp implements IOrderResearchBP {

	@Override
	public OrderRstDTO research(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		StringList lstIdors = new StringList(paramList);
		if (lstIdors.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		Context.get().setAttribute("CiEnContextDTO", ctx);
		RscProjParamDTO param = (RscProjParamDTO)arg.getExtension().get("RscProjParamDTO");
		String strIdors = "";
		for (Object obj : paramList) {
			strIdors += ",'" + obj.toString() + "'";
		}
		strIdors = strIdors.substring(1);
		
		//获得医嘱聚集数据集合
		CiOrderDO[] orderDOs = CiOrdAppUtils.getOrQryService().findByIds(lstIdors.asArray(), FBoolean.FALSE);
		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(OrdSrvDO.ID_OR + " in (" + strIdors + ")", "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(orderDOs)) {
			FMap2 scene = new FMap2();
			scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		this.updateOrders(param, orderDOs);
		this.updateOrsrvs(param, ordSrvDOs);
		
		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 更新医嘱科研信息
	 * @param param
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrders(RscProjParamDTO param, CiOrderDO[] orders) throws BizException {
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_RESEARCHPROJECT, CiOrderDO.CODE_RESEARCHPROJECT, 
				CiOrderDO.FG_RESEARCH, CiOrderDO.EU_HPINDICJUDGE, CiOrderDO.FG_ORHP };
		for (CiOrderDO order : orders) {
			order.setId_researchproject(CiOrdUtils.isEmpty(param.getId_researchproject()) ? "" : param.getId_researchproject());
			order.setCode_researchproject(CiOrdUtils.isEmpty(param.getCode_researchproject()) ? "" : param.getCode_researchproject());
			order.setFg_research(param.getFg_research());
			if(CiEnContextUtil.IsHpPat(context)){
				order.setFg_orhp(FBoolean.FALSE);
				if (FBoolean.TRUE.equals(param.getFg_research()) ) {
					order.setEu_hpindicjudge(HpIndicJudgeRstEnum.NEVER_JUDGE);
				}else{
					order.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
				}	
			}
			
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}
	
	/**
	 * 更新医嘱服务科研信息
	 * @param param
	 * @param ordSrvDOs
	 * @throws BizException
	 */
	private void updateOrsrvs(RscProjParamDTO param, OrdSrvDO[] ordSrvDOs) throws BizException {
		
		CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		String[] arrayFieldNames = new String[] { OrdSrvDO.ID_RESEARCHPROJECT, OrdSrvDO.CODE_RESEARCHPROJECT, 
				OrdSrvDO.FG_RESEARCH, OrdSrvDO.FG_SELFPAY, OrdSrvDO.FG_INDIC ,OrdSrvDO.EU_HPINDICJUDGE,OrdSrvDO.DES_HPLIMIT};
		for (OrdSrvDO srv : ordSrvDOs) {
			srv.setId_researchproject(CiOrdUtils.isEmpty(param.getId_researchproject()) ? "" : param.getId_researchproject());
			srv.setCode_researchproject(CiOrdUtils.isEmpty(param.getCode_researchproject()) ? "" : param.getCode_researchproject());
			srv.setFg_research(param.getFg_research());
			
			srv.setFg_selfpay(FBoolean.TRUE);
			srv.setFg_indic(null);
			
			if(CiEnContextUtil.IsHpPat(ctx)){
				
				if (FBoolean.TRUE.equals(param.getFg_research()) ) {
					
					srv.setEu_hpindicjudge(HpIndicJudgeRstEnum.NEVER_JUDGE);				
					srv.setDes_hplimit("科研项目不判断医保！");
				}else{
					
					srv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);				
					srv.setDes_hplimit("医生选择自费开立医嘱！");
				}	
			}
			
			
		}
		new DAFacade().updateDOArray(ordSrvDOs, arrayFieldNames);
	}
}
