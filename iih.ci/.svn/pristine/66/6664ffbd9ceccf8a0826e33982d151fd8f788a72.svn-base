package iih.ci.ord.s.ems.ip.order;

import xap.mw.core.data.BizException;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderDeleteBP;

/**
 * 住院医生站医嘱列表数据删除逻辑
 * @author Young
 *
 */
public class OrderDeleteAction implements IOrderDeleteBP {

	private IOrderDeleteBP deletebp;
	
	public OrderDeleteAction() {
		deletebp = new OrderDeleteBP();
	}
	
	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return deletebp.delete(ctx,arg);
	}

}
