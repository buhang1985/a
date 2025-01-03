package iih.ci.ord.s.ems.op.orderv1;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.op.orderv1.bp.OrderCopyBP;
import xap.mw.core.data.BizException;

public class OrderCopyService implements IOrderCopyBP {

	private IOrderCopyBP orderCopyBp = new OrderCopyBP();
	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyBp.copy(ctx, arg);
	}
	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyBp.addExtra(ctx, arg);
	}
}
