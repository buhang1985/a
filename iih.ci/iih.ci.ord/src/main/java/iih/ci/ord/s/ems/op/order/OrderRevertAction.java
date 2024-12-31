package iih.ci.ord.s.ems.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderRevertBP;
import xap.mw.core.data.BizException;

public class OrderRevertAction implements IOrderRevertBP {

	private IOrderRevertBP orderRevertBP = new OrderRevertBP();

	@Override
	public OrderRstDTO revert(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertBP.revert(ctx,arg);
	}

}
