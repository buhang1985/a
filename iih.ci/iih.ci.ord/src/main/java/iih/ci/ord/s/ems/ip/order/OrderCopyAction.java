package iih.ci.ord.s.ems.ip.order;

import xap.mw.core.data.BizException;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;

/**
 * 住院医生站医嘱列表数据复制逻辑
 * @author Young
 *
 */
public class OrderCopyAction implements IOrderCopyBP {

	private IOrderCopyBP copybp;
	
	public OrderCopyAction() {
		copybp = new OrderCopyBP();
	}
	
	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		return copybp.copy(ctx,arg);
	}

	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		return copybp.addExtra(ctx, arg);
	}

}
