package iih.ci.ord.s.ems.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderDeleteBP;
import xap.mw.core.data.BizException;

public class OrderDeleteService implements IOrderDeleteBP {

	private IOrderDeleteBP orderDeleteBP = new OrderDeleteBP();

	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteBP.delete(ctx,arg);
	}

}
