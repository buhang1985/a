package iih.ci.ord.s.ems.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;
import xap.mw.core.data.BizException;

public class OrderCopyAction implements IOrderCopyBP {

	private IOrderCopyBP orderCopyBp = new OrderCopyBP();

	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		if(OrderOperateDTO.FULLCOPY.equals(arg.getFuncCode())){
			return new iih.ci.ord.s.ems.copy.op.OrderCopyBP().copy(ctx, arg);
		}
		return orderCopyBp.copy(ctx,arg);
	}

	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
