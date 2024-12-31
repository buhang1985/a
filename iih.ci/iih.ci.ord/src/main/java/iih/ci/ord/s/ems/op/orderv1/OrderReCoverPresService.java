package iih.ci.ord.s.ems.op.orderv1;

import xap.mw.core.data.BizException;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderReCoverPresBP;
import iih.ci.ord.s.ems.op.orderv1.bp.OrderReCoverPresBP;

public class OrderReCoverPresService implements IOrderReCoverPresBP {

	private IOrderReCoverPresBP orderReCoverPresBP = new OrderReCoverPresBP();
	@Override
	public OrderRstDTO recoverpres(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderReCoverPresBP.recoverpres(ctx, arg);
	}

}
