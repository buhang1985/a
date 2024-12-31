package iih.ci.ord.s.ems.op.orderv1;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderDeleteHBIBP;
import iih.ci.ord.s.ems.op.orderv1.bp.OrderDeleteHBIBP;
import xap.mw.core.data.BizException;

public class OrderDeleteHBIService implements IOrderDeleteHBIBP {
	
	private IOrderDeleteHBIBP orderDeleteHBIBP = new OrderDeleteHBIBP();
	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteHBIBP.delete(ctx, arg);
	}

}
