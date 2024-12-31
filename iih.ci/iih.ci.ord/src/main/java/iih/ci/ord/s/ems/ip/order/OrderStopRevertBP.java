package iih.ci.ord.s.ems.ip.order;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.RefuseCheckTp;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.ems.itf.bp.IOrderStopRevertBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱取消停止
 * @author Young
 *
 */
public class OrderStopRevertBP implements IOrderStopRevertBP {

	@Override
	public OrderRstDTO stoprevert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
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
			if(FBoolean.FALSE.equals(orderDO.getFg_stop())
				|| FBoolean.TRUE.equals(orderDO.getFg_chk_stop())
				|| FBoolean.TRUE.equals(orderDO.getFg_canc())){
				FMap2 scene = new FMap2();
				scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
				rstDTO.setExtension(scene);
				rstDTO.setIsSuccess(FBoolean.FALSE);
				return rstDTO;
			}
		}
		
		this.updateOrderStatus(orderDOs);
		
		//备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(orderDOs, true);
		
		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 更新医嘱停止状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.FG_STOP, CiOrderDO.DT_STOP, 
				CiOrderDO.DT_END, CiOrderDO.ID_DEP_STOP, CiOrderDO.ID_EMP_STOP,
				CiOrderDO.EU_REFUSECHECKTP, CiOrderDO.FG_REFUSECHECK, 
				CiOrderDO.ID_EMP_REFUSECHECK, CiOrderDO.DT_REFUSECHECK, 
				CiOrderDO.ERROR_LEVEL, CiOrderDO.ERROR_DES };
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);
			order.setFg_stop(FBoolean.FALSE);
			order.setDt_stop(new FDateTime("2099-01-01 00:00:00"));
			order.setDt_end(new FDateTime("2099-01-01 00:00:00"));
			order.setId_dep_stop(null);
			order.setId_emp_stop(null);
			
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
}
