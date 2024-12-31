package iih.ci.ord.s.ems.ip.order;

import xap.mw.core.data.BizException;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderRevertBP;

/**
 * 住院医生站医嘱列表数据撤回逻辑
 * @author Young
 *
 */
public class OrderRevertAction implements IOrderRevertBP {
	
	private IOrderRevertBP revertbp;
	
	public OrderRevertAction() {
		revertbp = new OrderRevertBP();
	}

	@Override
	public OrderRstDTO revert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return revertbp.revert(ctx,arg);
	}

}
