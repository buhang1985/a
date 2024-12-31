package iih.ci.ord.s.ems.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderSaveAsBP;
import xap.mw.core.data.BizException;

public class OrderSaveAsAction implements IOrderSaveAsBP {

	private IOrderSaveAsBP orderSaveAsBP = new OrderSaveAsBP();

	@Override
	public OrderRstDTO saveAs(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSaveAsBP.saveAs(ctx, arg);
	}

}
