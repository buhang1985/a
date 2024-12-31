package iih.ci.ord.s.ems.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderSignBP;
import xap.mw.core.data.BizException;

public class OrderSignService implements IOrderSignBP {

	private IOrderSignBP orderSignBP = new OrderSignBP();

	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSignBP.sign(ctx, arg);
	}

}
