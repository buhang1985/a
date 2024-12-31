package iih.ci.ord.s.ems.ip.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderResearchBP;
import xap.mw.core.data.BizException;

/**
 * 住院医生站医嘱科研确认逻辑
 * @author Young
 *
 */
public class OrderResearchAction implements IOrderResearchBP {

	private IOrderResearchBP researchbp;
	
	public OrderResearchAction() {
		researchbp = new OrderResearchBp();
	}
	
	@Override
	public OrderRstDTO research(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return researchbp.research(ctx,arg);
	}

}
