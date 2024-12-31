package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderStopBP;
import xap.mw.core.data.BizException;

/**
 * 住院医生站医嘱列表数据停止逻辑
 * @author Young
 *
 */
public class OrderStopAction implements IOrderStopBP {
	
	private IOrderStopBP stopbp;
	
	public OrderStopAction() {
		stopbp = new OrderStopBP();
	}

	@Override
	public OrderRstDTO stop(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return stopbp.stop(ctx,arg);
	}
}
