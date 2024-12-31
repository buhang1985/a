package iih.ci.ord.s.ems.ip.order;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.RefuseCheckTp;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.OrConfirmBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.itf.bp.IOrderStopBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;

/**
 * 医嘱停止
 * @author Young
 *
 */
public class OrderStopBP implements IOrderStopBP {

	@Override
	public OrderRstDTO stop(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FDateTime dt_stop = (FDateTime)(arg.getExtension().get(OrderUtils.OrderStopTime));
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0 || dt_stop == null) {
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
		
		FDateTime dt_now = CiOrdAppUtils.getServerDateTime();
		for (CiOrderDO orderDO : orderDOs) {
			if(FBoolean.TRUE.equals(orderDO.getFg_chk_stop())
				|| FBoolean.TRUE.equals(orderDO.getFg_canc())){
				FMap2 scene = new FMap2();
				scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
				rstDTO.setExtension(scene);
				rstDTO.setIsSuccess(FBoolean.FALSE);
				return rstDTO;
			}
			if (dt_stop.before(orderDO.getDt_effe())
				|| (orderDO.getDt_last_mp() != null && dt_stop.before(orderDO.getDt_last_mp()))) {
				FMap2 scene = new FMap2();
				scene.put(OrderUtils.KYE_MESSAGE, "停止时间有误，请确认！");
				rstDTO.setExtension(scene);
				rstDTO.setIsSuccess(FBoolean.FALSE);
				return rstDTO;
			}
		}
		
		this.updateOrderStatus(ctx, orderDOs, dt_stop, dt_now);
		
		//备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(orderDOs, false);
		
		//删除检查打印数据
//		ServiceFinder.find(ICiprintExtService.class).DeleteAppRisData(lstIdors.asArray());
		
		//执行域响应医嘱停止操作
		CiOrdAppUtils.getIResponseOrderHandelService().responseOrStop(lstIdors.asArray());
		
//		FMap2 scene = new FMap2();
//		scene.put("ciors", CiOrdUtils.array2FArrayList(ciors));
//		rstDTO.setExtension(scene);
		// 护嘱停止确认
		handleNurOrderStopInfo(ctx,orderDOs);
		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}
	
	/**
	 * 更新医嘱停止状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiEnContextDTO enContext, CiOrderDO[] orders, FDateTime dt_stop, FDateTime dt_now) 
			throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.FG_STOP, CiOrderDO.DT_STOP, 
				CiOrderDO.DT_END, CiOrderDO.ID_DEP_STOP, CiOrderDO.ID_EMP_STOP,
				CiOrderDO.EU_REFUSECHECKTP, CiOrderDO.FG_REFUSECHECK, 
				CiOrderDO.ID_EMP_REFUSECHECK, CiOrderDO.DT_REFUSECHECK, 
				CiOrderDO.ERROR_LEVEL, CiOrderDO.ERROR_DES };
		String id_dep = enContext.getId_dep_or();
		String id_emp = enContext.getId_emp_or();
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);
			order.setFg_stop(FBoolean.TRUE);
			order.setDt_stop(dt_now);
			order.setDt_end(dt_stop);
			order.setId_dep_stop(id_dep);
			order.setId_emp_stop(id_emp);
			
			if (RefuseCheckTp.REFUSE_STOP_CHECK.equals(order.getEu_refusechecktp())) {
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
	 * 【护嘱医生站】医技医嘱签署后，自动化流程触发
	 * @param ctx
	 * @param ciors
	 * @throws BizException
	 */
	private void handleNurOrderStopInfo(CiEnContextDTO ctx,CiOrderDO[] ciors) throws BizException{
		if(ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())){
			// 过滤当前医嘱的执行科室必须为本科室(是否需要 限定服务类型？？)
			List<CiOrderDO> orderInfoList = new ArrayList<CiOrderDO>();
			for(CiOrderDO orderInfo : ciors){
				if(orderInfo.getId_dep_mp()!=null && orderInfo.getId_dep_mp().equals(ctx.getId_dep_or())){
					orderInfoList.add(orderInfo);
				}
			}
			
			if(orderInfoList.size() > 0){
				// 护嘱确认
				OrConfirmBP confirmBP = new OrConfirmBP();
				String errorMsg = confirmBP.runNurOrderStopConfirm(orderInfoList.toArray(new CiOrderDO[orderInfoList.size()]));
				if(!StringUtils.isNullOrEmpty(errorMsg)){
					throw new BizException (errorMsg); 
				}
			}
			
		}
	}
}
