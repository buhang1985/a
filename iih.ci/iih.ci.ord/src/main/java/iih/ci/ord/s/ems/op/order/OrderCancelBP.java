package iih.ci.ord.s.ems.op.order;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.MOdOrdsrv4PresBP;
import iih.ci.ord.s.bp.OpLatelySessionOrsGetBP;
import iih.ci.ord.s.bp.UseBtContainsBuValidateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.bp.event.FireOpOrCancelEvent4IeBP;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeDataDelValidate;
import iih.ci.ord.s.bp.orsms.ris.mergesheet.ImageTextReportDelValidate;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.mp.nr.splitplan.i.IResponseOrderHandelService;
import iih.sc.apt.out.i.ISc4CiCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医嘱作废
 * 
 * @author Young
 *
 */
public class OrderCancelBP implements IOrderCancelBP {

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ctx);
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();
		FMap2 map = arg.getExtension();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		List<String> lstIdors = new ArrayList<String>();
		for (Object obj : paramList) {
			if (CiOrdUtils.isEmpty(obj))
				continue;
			lstIdors.add(obj.toString());
		}
		if (lstIdors.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		// 1、判断容器费撤回时，存不存在检验医嘱
		MergeTubeDataDelValidate.DiriveDataDelValide(lstIdors);
		// 1、判断图文报告费撤回时，存不存在检查医嘱
		ImageTextReportDelValidate.DiriveDataDelValideRis(lstIdors);
		// 获得医嘱集合
		CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().findByBIds(lstIdors.toArray(new String[lstIdors.size()]),
				FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(ciors)) {
			throw new BizException("没有符合操作的数据，刷新列表后请重试！");
		}

		Hashtable<String, String> htors8ieevent = new Hashtable<String, String>(); // 参数定义
		//FireOpOrCancelEvent4IeBP bp = new FireOpOrCancelEvent4IeBP();

		// 医嘱数据分组组织
		//int signcnt = bp.orGrpHandle4IeEvent(htors8ieevent, ciors);
		// 设置就诊号
		htors8ieevent.put(ICiIEEventConst.EVENT_IE_ID_ENT, ciors[0].getId_en());

		// 发布IE门诊医嘱撤销事件
		//bp.fireEvent4Ie(htors8ieevent);
		
		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		lstIdors.clear();
		for (CiOrderDO cior : ciors) {
			if (!cior.getSd_su_or().equals(map.get(cior.getId_or()))) {
				throw new BizException("医嘱状态已经发生变化，刷新列表后请重试！");
			}

			if (FBoolean.TRUE.equals(cior.getFg_sign()) && FBoolean.FALSE.equals(cior.getFg_canc())
					&& FBoolean.FALSE.equals(cior.getFg_uncancelable())
					&& (ICiDictCodeConst.SD_SU_BL_NONE.equals(cior.getSd_su_bl())
							|| ICiDictCodeConst.SD_SU_BL_REFOUND.equals(cior.getSd_su_bl()))) {
				lstCiOrderDOs.add(cior);
				lstIdors.add(cior.getId_or());
			}
		}

		if (lstCiOrderDOs.size() < 1) {
			throw new BizException("所选的医嘱已经执行或已经收费，不能作废！");
		}

		ciors = lstCiOrderDOs.toArray(new CiOrderDO[lstCiOrderDOs.size()]);

		UseBtContainsBuValidateBP btbp = new UseBtContainsBuValidateBP();
		if (btbp.exec(ciors)) {
			throw new BizException("备血医嘱已关联用血，请确认！");
		}

		// 对应会话区间撤销状态信息修改
		OpLatelySessionOrsGetBP bpOpLatelySession = new OpLatelySessionOrsGetBP();
		bpOpLatelySession.exec(ciors[0].getId_en(), lstIdors.toArray(new String[lstIdors.size()]));

		// 清医嘱项目中处方标识
		MOdOrdsrv4PresBP bpMOdOrdsrv = new MOdOrdsrv4PresBP();
		bpMOdOrdsrv.exec(lstIdors.toArray(new String[lstIdors.size()]));

		// 清除打印数据
		OrderRstDTO rst = clearPrintData(lstIdors.toArray(new String[lstIdors.size()]), arg);
		if (rst != null && rst.getExtension() != null && rst.getExtension().containsKey("SampColPri")) {
			rst.setIsSuccess(FBoolean.TRUE);
			return rst;
		}
		// 更新医嘱状态
		updateOrderStatus(ciors);

		// 备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(ciors, false);
		// Runnable r = new OrderDeleteDataRunnable(lstIdors.toArray(new
		// String[lstIdors.size()]), ciors);
		// ExecutorUtil.startRunnable(r);
		OrdBizLogger.info(ctx, "OrderCancelBP:医嘱单作废撤回模式，更改状态，如果有检验医嘱，则调用执行域删除标本");
		revertMergeTubeSendToMP(ciors);
		// 集成平台消息发送
		// CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID,
		// IEventType.TYPE_UPDATE_AFTER, ciors);
		// 调用预约接口向预约发送撤回的手术信息
		sendSugInfo4ScAptAppl(ctx, ciors);
		// 发送消息通知其他域医嘱已经撤回
		CiOrdUtils.fireBDEvent(IOrdEventSources.OP_REVERT_ENTER, IEventType.TYPE_UPDATE_AFTER, ciors);//门诊撤回会入口-集成平台
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciors);
		rstDTO.setIsSuccess(FBoolean.TRUE);
		rstDTO.setMessageInfo("医嘱作废成功");
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
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);// 医嘱状态
			order.setSd_su_or(ICiDictCodeConst.SD_SU_CANCEL);
			order.setId_emp_canc(order.getId_emp_sign());// 作废人信息，只有签署的可作废，只有签署人才可作废本人签署的医嘱
			order.setId_dep_canc(order.getId_dep_sign());// 作废科室信息
			order.setFg_canc(FBoolean.TRUE);// 作废标识
			order.setDt_canc(dt);// 作废日期
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}

	/**
	 * 删除打印数据
	 * 
	 * @param ids
	 * @throws BizException
	 */
	private OrderRstDTO clearPrintData(String[] ids, OrderOperateDTO arg) throws BizException {
		ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
		OrderRstDTO rst = service.DeleteAppLisRelData(ids, arg);
		if (rst != null && rst.getExtension() != null && rst.getExtension().containsKey("SampColPri")) {
			return rst;
		}
		service.DeleteAppRisData(ids);
		service.DeleteAppPathgyData(ids);
		service.DeleteFeeBillsData(ids);
		service.DeleteTreateExecData(ids);
		service.DeleteAppBtData(ids);
		service.DeleteAppBuData(ids);
		return null;
	}

	/**
	 * 调用SC接口向sc回写手术申请撤回信息
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void sendSugInfo4ScAptAppl(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		if (CiOrdUtils.isEmpty(ciors))
			return;
		ISc4CiCmdService isc4cicmdservice = ServiceFinder.find(ISc4CiCmdService.class);
		for (CiOrderDO ciOrderDO : ciors) {
			if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)
					|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS) 
					|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
				isc4cicmdservice.cancScAptAppl(ciOrderDO.getId_or(), ctx.getId_psndoc(),
						CiOrdAppUtils.getServerDateTime(),ciOrderDO.getSd_su_or());
			}
		}
	}
	/**
	 * 通知执行域，检验医嘱被撤回了
	 * 
	 * @param idors
	 * @throws BizException
	 */
	private void revertMergeTubeSendToMP(CiOrderDO[] ciors) throws BizException {
		if (ciors == null || ciors.length == 0) {
			return;
		}
		List<String> labors = new ArrayList<String>();
		for(CiOrderDO order : ciors){
			if(!StringUtils.isEmpty(order.getSd_srvtp())&&order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
				labors.add(order.getId_or());
			}
		}
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "OrderCancelBP:医嘱单作废撤回模式，更改状态，检验医嘱的数量："+labors.size());
		if(labors.size()>0&&FBoolean.TRUE.equals(isSendToMp())){
			IResponseOrderHandelService service = ServiceFinder.find(IResponseOrderHandelService.class);
			service.responseOpOrCancel(labors.toArray(new String[0]));
		}
	}

	private FBoolean isSendToMp() {
		try {
			return ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_MERGETBUSENDTOMP);
		} catch (Exception ex) {
			return FBoolean.FALSE;
		}

	}
}
