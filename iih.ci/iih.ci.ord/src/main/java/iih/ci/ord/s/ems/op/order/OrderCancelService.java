package iih.ci.ord.s.ems.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelBP;
import xap.mw.core.data.BizException;

public class OrderCancelService implements IOrderCancelBP {

	private IOrderCancelBP bp = new OrderCancelBP();

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return bp.cancel(ctx,arg);
	}

}
