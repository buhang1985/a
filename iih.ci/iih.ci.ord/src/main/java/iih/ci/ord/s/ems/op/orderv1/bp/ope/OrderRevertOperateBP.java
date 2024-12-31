package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
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
import iih.ci.ord.s.ems.op.orderv1.bp.qry.GetCiOrderDOs4RevertQry;

/**
 * 医嘱撤回逻辑
 * @author Young
 *
 */
public class OrderRevertOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ciEnContextDTO, FMap2 extension) 
			throws BizException {
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
		ITransQry qry = new GetCiOrderDOs4RevertQry(strIdors);
		CiOrderDO[] ciors = (CiOrderDO[]) AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);
		
		if (ciors == null || ciors.length < 1) {
			FMap2 scene = new FMap2();
			scene.put("checkResult", STR_ERROR_OREXEC_REVERT);
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		String[] idors_revert = new String[ciors.length];
		int i = 0;
		for (CiOrderDO cior : ciors) {
			idors_revert[i] = cior.getId_or();
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
		bpOpLatelySession.exec(ciEnContextDTO.getId_en(), idors_revert);

		// 清医嘱项目中处方标识
		MOdOrdsrv4PresBP bpMOdOrdsrv = new MOdOrdsrv4PresBP();
		bpMOdOrdsrv.exec(idors_revert);

		// 医嘱状态修改
		this.updateOrderStatus(ciors);

		// 撤回时，如果存在服务已经判断过特殊病标志，应该将特殊病标志设置为N未判断状态
		this.resetSpecil(idors_revert);

		// 清除打印数据
		this.clearPrintData(idors_revert);

		//		Runnable r = new OrderDeleteDataRunnable(lstIdors.toArray(new String[lstIdors.size()]), ciors);
		//		ExecutorUtil.startRunnable(r);

		// 集成平台消息发送
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
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, CiOrderDO.FG_SIGN,
				CiOrderDO.DT_SIGN, CiOrderDO.ID_DEP_SIGN, CiOrderDO.ID_EMP_SIGN, CiOrderDO.DT_LAST_BL,
				CiOrderDO.ID_SU_BL, CiOrderDO.SD_SU_BL, CiOrderDO.FG_FLUSH2MR };
		for (CiOrderDO order : orders) {
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);//医嘱状态
			order.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
			order.setFg_sign(new FBoolean(false));//签署标识
			order.setDt_sign(null);//签署日期
			order.setId_dep_sign(null);//签署科室
			order.setId_emp_sign(null);//签署医生
			order.setDt_last_bl(order.getDt_effe());//最新计费日期
			order.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);//计费状态
			order.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			order.setFg_flush2mr(FBoolean.FALSE);//写回病历标识
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 重置特殊病标志
	 * 
	 * @param id_ors_temp
	 * @throws BizException
	 */
	private void resetSpecil(String[] id_ors_temp) throws BizException {
		if (CiOrdUtils.isEmpty(id_ors_temp))
			return;
		StringBuffer sb = new StringBuffer();
		for (String id : id_ors_temp) {
			sb.append(",'" + id + "'");
		}
		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(
				String.format("id_or in (%s) and fg_specill='Y'", sb.toString().substring(1)), "", FBoolean.FALSE);

		if (ordSrvDOs.length > 0) {
			for (OrdSrvDO srv : ordSrvDOs) {
				srv.setFg_specill(FBoolean.FALSE);
			}
			//			CiOrdAppUtils.getOrSrvService().update(ordSrvDOs);
			new DAFacade().updateDOArray(ordSrvDOs, new String[] { OrdSrvDO.FG_SPECILL });
		}
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
