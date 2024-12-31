package iih.ci.ord.s.ems.ip.order;

import xap.mw.core.data.BizException;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelBP;

/**
 * 住院医生站医嘱列表数据作废逻辑
 * @author Young
 *
 */
public class OrderCancelAction implements IOrderCancelBP {

	private IOrderCancelBP cancelbp;
	
	public OrderCancelAction() {
		cancelbp = new OrderCancelBP();
	}
	
	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return cancelbp.cancel(ctx,arg);
	}

}
