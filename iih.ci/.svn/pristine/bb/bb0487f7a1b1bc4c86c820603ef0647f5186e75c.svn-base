package iih.ci.ord.s.ems.ip.order;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.RefuseCheckTp;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.MOdOrdsrv4PresBP;
import iih.ci.ord.s.bp.UseBtContainsBuValidateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.ems.itf.bp.IOrderRevertBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.specanti.d.SpecAntiConsDO;
import iih.ci.ord.specanti.d.SpecAntiInvitesDO;
import iih.ci.ord.specanti.d.SpecAntiReviewDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱撤回
 * @author Young
 *
 */
public class OrderRevertBP implements IOrderRevertBP {

	@Override
	public OrderRstDTO revert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
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
		
		//获得医嘱聚集数据集合
		CiOrderDO[] orderDOs = CiOrdAppUtils.getOrQryService().findByIds(lstIdors.asArray(), FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(orderDOs)) {
			FMap2 scene = new FMap2();
			scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		for (CiOrderDO orderDO : orderDOs) {
			if(!orderDO.getFg_sign().isValue() || orderDO.getFg_chk().isValue()){
				FMap2 scene = new FMap2();
				scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
				rstDTO.setExtension(scene);
				rstDTO.setIsSuccess(FBoolean.FALSE);
				return rstDTO;
			}
		}
		//备血医嘱撤回校验
		UseBtContainsBuValidateBP btbp=new UseBtContainsBuValidateBP();
		if(btbp.exec(orderDOs)){
			FMap2 scene = new FMap2();
			scene.put(OrderUtils.KYE_MESSAGE, "备血医嘱已关联用血，请确认！");
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		//判断医嘱是否存在已提交的抗菌药会诊申请
		// TODO: 需要合并国际代码
//		CheckSpecAntiCons4OrRevertBP bp = new CheckSpecAntiCons4OrRevertBP();
//		if (!bp.exec(lstIdors.asArray()).isValue()) {
//			FMap2 scene = new FMap2();
//			scene.put(OrderUtils.KYE_MESSAGE, "医嘱存在已提交的特殊级抗菌药会诊申请，不可撤回！");
//			rstDTO.setExtension(scene);
//			rstDTO.setIsSuccess(FBoolean.FALSE);
//			return rstDTO;
//		}
		
		this.updateOrderStatus(orderDOs);
		
		// 清医嘱项目中处方标识
		MOdOrdsrv4PresBP bpMOdOrdsrv = new MOdOrdsrv4PresBP();
		bpMOdOrdsrv.exec(lstIdors.asArray());
				
		//备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(orderDOs, false);
		
		//删除特殊级抗菌药会诊申请数据
		this.clearSpecAntiConsData(lstIdors.asArray());
		
		// 清除打印数据
		this.clearPrintData(lstIdors.asArray());
		
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, orderDOs);
		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 更新医嘱停止状态
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, 
				CiOrderDO.FG_SIGN, CiOrderDO.DT_SIGN,
				CiOrderDO.ID_DEP_SIGN, CiOrderDO.ID_EMP_SIGN,
				CiOrderDO.EU_REFUSECHECKTP, CiOrderDO.FG_REFUSECHECK, 
				CiOrderDO.ID_EMP_REFUSECHECK, CiOrderDO.DT_REFUSECHECK, 
				CiOrderDO.ERROR_LEVEL, CiOrderDO.ERROR_DES };
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
			order.setFg_sign(FBoolean.FALSE);
			order.setDt_sign(null);
			order.setId_dep_sign(null);
			order.setId_emp_sign(null);
			
			if (RefuseCheckTp.REFUSE_SIGN_CHECK.equals(order.getEu_refusechecktp())) {
				order.setEu_refusechecktp(null);
				order.setFg_refusecheck(FBoolean.FALSE);
				order.setId_emp_refusecheck(null);
				order.setDt_refusecheck(null);
				order.setError_level(null);
				order.setError_des(null);
			}
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}
	
	/**
	 * 删除特殊级抗菌药会诊申请数据
	 * @param idors
	 * @throws DAException
	 */
	private void clearSpecAntiConsData(String[] idors) throws DAException{
		String strWhereIdors = "";
		for (String idor : idors) {
			strWhereIdors += ",'" + idor + "'";
		}
		strWhereIdors = strWhereIdors.substring(1);
		new DAFacade().deleteByWhere(SpecAntiConsDO.class, SpecAntiConsDO.ID_OR + " in (" + strWhereIdors + ")");
		new DAFacade().deleteByWhere(SpecAntiInvitesDO.class, SpecAntiInvitesDO.ID_OR + " in (" + strWhereIdors + ")");
		new DAFacade().deleteByWhere(SpecAntiReviewDO.class, SpecAntiReviewDO.ID_OR + " in (" + strWhereIdors + ")");
	}
	
	/**
	 * 删除打印数据
	 * @param ids
	 * @throws BizException
	 */
	private void clearPrintData(String[] ids) throws BizException {
		ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
		service.DeleteAppRisData(ids);
		service.DeleteAppBtData(ids);
		service.DeleteAppBuData(ids);
	}
}
