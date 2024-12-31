package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.MOdOrdsrv4PresBP;
import iih.ci.ord.s.bp.OpLatelySessionOrsGetBP;
import iih.ci.ord.s.bp.UseBtContainsBuValidateBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.qry.GetCiOrderDOs4CancelQry;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱作废逻辑
 * 
 * @author Young
 *
 */
public class OrderCancelOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ciEnContextDTO,
			FMap2 extension) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		if (idors == null || idors.length <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		String strIdors = "";
		for (String idor : idors) {
			strIdors += ",'" + idor + "'";
		}
		strIdors = strIdors.substring(1);
		
		// 获得医嘱集合
		ITransQry qry = new GetCiOrderDOs4CancelQry(strIdors);
		CiOrderDO[] ciors = (CiOrderDO[]) AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);

		if (ciors == null || ciors.length < 1) {
			FMap2 scene = new FMap2();
			scene.put("checkResult", STR_ERROR_OREXEC_CANCEL);
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		String[] idors_cancel = new String[ciors.length];
		int i = 0;
		for (CiOrderDO cior : ciors) {
			idors_cancel[i] = cior.getId_or();
			i++;
		}
		
		UseBtContainsBuValidateBP btbp=new UseBtContainsBuValidateBP();
		if(btbp.exec(ciors)){
			FMap2 scene = new FMap2();
			scene.put("checkResult", STR_ERROR_BUBT_CANCEL);
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		// 对应会话区间撤销状态信息修改
		OpLatelySessionOrsGetBP bpOpLatelySession = new OpLatelySessionOrsGetBP();
		bpOpLatelySession.exec(ciEnContextDTO.getId_en(), idors_cancel);

		// 清医嘱项目中处方标识
		MOdOrdsrv4PresBP bpMOdOrdsrv = new MOdOrdsrv4PresBP();
		bpMOdOrdsrv.exec(idors_cancel);

		// 更新医嘱状态
		updateOrderStatus(ciors);

		// 删除打印数据
		clearPrintData(idors_cancel);

		//		Runnable r = new OrderDeleteDataRunnable(lstIdors.toArray(new String[lstIdors.size()]), ciors);
		//		ExecutorUtil.startRunnable(r);

		//集成平台消息发送
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 更新医嘱状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, CiOrderDO.ID_EMP_CANC,
				CiOrderDO.ID_DEP_CANC, CiOrderDO.FG_CANC, CiOrderDO.DT_CANC };
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		for (CiOrderDO order : orders) {
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);//医嘱状态
			order.setSd_su_or(ICiDictCodeConst.SD_SU_CANCEL);
			order.setId_emp_canc(order.getId_emp_sign());//作废人信息，只有签署的可作废，只有签署人才可作废本人签署的医嘱
			order.setId_dep_canc(order.getId_dep_sign());//作废科室信息
			order.setFg_canc(FBoolean.TRUE);//作废标识
			order.setDt_canc(dt);//作废日期
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 删除打印数据
	 * 
	 * @param ids
	 * @throws BizException
	 */
	private void clearPrintData(String[] ids) throws BizException {
		ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
		service.DeleteAppLisData(ids);
		service.DeleteAppRisData(ids);
		service.DeleteAppPathgyData(ids);
		service.DeleteFeeBillsData(ids);
		service.DeleteTreateExecData(ids);
		service.DeleteAppBtData(ids);
		service.DeleteAppBuData(ids);
	}
}
