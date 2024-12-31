package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.external.obtain.bp.bl.GetArrearageCheckBP;
import xap.mw.core.data.BizException;

/**
 * 医嘱复制
 * @author Young
 *
 */
public class OrderCopyBP extends iih.ci.ord.s.ems.op.order.OrderCopyBP {
	public OrderCopyBP(){
		this.factory  = new iih.ci.ord.s.ems.ip.order.copy.OrderCopyFactory();
	}

	@Override
	protected void arrearageCheck(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		GetArrearageCheckBP arrearageCheckBP = new GetArrearageCheckBP();
		arrearageCheckBP.openCheckedArrearage(ctx, ciors);
	}
	
}
