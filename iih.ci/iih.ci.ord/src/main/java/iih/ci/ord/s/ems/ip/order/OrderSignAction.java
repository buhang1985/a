package iih.ci.ord.s.ems.ip.order;

import xap.mw.core.data.BizException;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderSignBP;

/**
 * 住院医生站医嘱列表数据签署逻辑
 * @author Young
 *
 */
public class OrderSignAction implements IOrderSignBP {

	private IOrderSignBP signbp;
	
	public OrderSignAction(){
		signbp = new OrderSignBP();
	}
	
	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return signbp.sign(ctx,arg);
	}

}
