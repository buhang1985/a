package iih.ci.ord.s.ems.ip.order;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.RefuseCheckTp;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.bp.ciprn.CiprnSaveAppRisDataBP;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelRevertBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱取消作废
 * @author Young
 *
 */
public class OrderCancelRevertBP implements IOrderCancelRevertBP {

	@Override
	public OrderRstDTO calcelrevert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
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
			if(FBoolean.FALSE.equals(orderDO.getFg_canc())
				|| FBoolean.TRUE.equals(orderDO.getFg_chk_canc())){
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
		
		//保存检查打印数据  
		CiprnSaveAppRisDataBP bpRis = new CiprnSaveAppRisDataBP();
		bpRis.exec(ctx, orderDOs, null);
				
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
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, 
				CiOrderDO.FG_CANC, CiOrderDO.DT_CANC, 
				CiOrderDO.ID_DEP_CANC, CiOrderDO.ID_EMP_CANC,
				CiOrderDO.EU_REFUSECHECKTP, CiOrderDO.FG_REFUSECHECK, 
				CiOrderDO.ID_EMP_REFUSECHECK, CiOrderDO.DT_REFUSECHECK, 
				CiOrderDO.ERROR_LEVEL, CiOrderDO.ERROR_DES };
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKTHROUGH);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
			order.setFg_canc(FBoolean.FALSE);
			order.setDt_canc(null);
			order.setId_dep_canc(null);
			order.setId_emp_canc(null);
			
			if (RefuseCheckTp.REFUSE_CANC_CHECK.equals(order.getEu_refusechecktp())) {
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
