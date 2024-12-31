package iih.ci.ord.s.ems.op.orderv1.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.ope.OrderLoadOperateBP;
import xap.mw.core.data.BizException;

/**
 * 医嘱加载操作
 * 
 * @author Young
 *
 */
public class OrderLoadBP implements IOrderLoadBP {

	private IOrderOperateBP loadBP = new OrderLoadOperateBP();
	@Override
	public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return loadBP.exec(null, ctx, arg.getExtension());
	}
}
