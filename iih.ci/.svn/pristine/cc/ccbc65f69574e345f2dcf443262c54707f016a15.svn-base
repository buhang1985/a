package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderStopRevertBP;
import xap.mw.core.data.BizException;

/**
 * 住院医生站医嘱列表数据取消停止逻辑
 * @author Young
 *
 */
public class OrderStopRevertAction implements IOrderStopRevertBP {

	private IOrderStopRevertBP stoprevertbp;
	
	public OrderStopRevertAction() {
		stoprevertbp = new OrderStopRevertBP();
	}
	
	@Override
	public OrderRstDTO stoprevert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return stoprevertbp.stoprevert(ctx,arg);
	}

}
