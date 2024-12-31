package iih.ci.ord.s.ems.op.orderv1.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.itf.bp.IOrderReCoverPresBP;
import iih.ci.ord.s.ems.op.orderv1.bp.ope.OrderReCoverPresOperateBP;
import xap.mw.core.data.BizException;

public class OrderReCoverPresBP implements IOrderReCoverPresBP {

	private IOrderOperateBP recoverpresBP = new OrderReCoverPresOperateBP();
	@Override
	public OrderRstDTO recoverpres(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return recoverpresBP.exec(null, ctx, null);
	}

}
