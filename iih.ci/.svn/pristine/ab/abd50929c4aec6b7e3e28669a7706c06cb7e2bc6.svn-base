package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderLoadBP;
import xap.mw.core.data.BizException;

/**
 * 住院医生站医嘱列表数据加载逻辑
 * @author wangqingzhu
 *
 */
public class OrderLoadAction implements IOrderLoadBP{

	private  IOrderLoadBP laodBP;
	
	public OrderLoadAction(){
		laodBP = new OrderLoadBP();
	}
	
	@Override
	public OrderRstDTO load(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return laodBP.load(ctx,arg);
	}

}
