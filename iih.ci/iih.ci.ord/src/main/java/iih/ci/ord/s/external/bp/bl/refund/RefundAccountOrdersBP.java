package iih.ci.ord.s.external.bp.bl.refund;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.i.IBlOutCmdService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 门诊预付费销账-按医嘱
 * @author zhangwq
 *
 */
public class RefundAccountOrdersBP {
	
	private IBlOutCmdService blOutCmdService;
	
	public RefundAccountOrdersBP(){
		blOutCmdService = ServiceFinder.find(IBlOutCmdService.class);
	}

	public OrderRstDTO exec(CiEnContextDTO ctx, List<CiOrderDO> orderList) {
		
		OrderRstDTO orderRst = new OrderRstDTO();
		orderRst.setIsSuccess(FBoolean.TRUE);
		if(orderList.size() ==0){
			orderRst.setIsSuccess(FBoolean.FALSE);
			return orderRst;
		}
		
		List<String> idOrList = new ArrayList<String>();
		for(CiOrderDO order : orderList){
			idOrList.add(order.getId_or());
		}
		
		try {
			blOutCmdService.refundForOpIdOrs(ctx.getId_en(), ctx.getId_psndoc(), idOrList.toArray(new String[idOrList.size()]));
		} catch ( BizException e){
			orderRst.setIsSuccess(FBoolean.FALSE);
			orderRst.setMessageInfo(e.getMessage());
		}
		
		return orderRst;
	}
}
