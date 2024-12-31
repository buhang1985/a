package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelRevertBP;
import xap.mw.core.data.BizException;

/**
 * 住院医生站医嘱列表数据取消作废逻辑
 * @author Young
 *
 */
public class OrderCancelRevertAction implements IOrderCancelRevertBP {

	private IOrderCancelRevertBP cancelrevertbp;
	
	public OrderCancelRevertAction() {
		cancelrevertbp = new OrderCancelRevertBP();
	}
	
	@Override
	public OrderRstDTO calcelrevert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return cancelrevertbp.calcelrevert(ctx,arg);
	}

}
