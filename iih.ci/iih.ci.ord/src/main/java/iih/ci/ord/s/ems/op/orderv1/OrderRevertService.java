package iih.ci.ord.s.ems.op.orderv1;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderRevertBP;
import iih.ci.ord.s.ems.op.orderv1.bp.OrderRevertBP;
import xap.mw.core.data.BizException;

public class OrderRevertService implements IOrderRevertBP {

	private IOrderRevertBP orderRevertBP = new OrderRevertBP();
	@Override
	public OrderRstDTO revert(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertBP.revert(ctx, arg);
	}

}
