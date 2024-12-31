package iih.ci.ord.s.ems.mdsstation.order;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.mdsstation.order.bp.MdsCancelBP;
import iih.ci.ord.s.ems.mdsstation.order.bp.MdsCancelChkBP;
import iih.mp.nr.foreign.i.IForeignService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医技医生站医嘱作废操作
 * @author zhangwq
 *
 */
public class MdsStationCancelAction {
	public OrderRstDTO cancel(OrderOperateDTO operateDTO) throws BizException{
		OrderRstDTO rst = new OrderRstDTO();
		FArrayList idlist = operateDTO.getDocument();
		String[] idArrs = (String[])idlist.toArray(new String[0]);
		if(idArrs == null || idArrs.length == 0){
			return rst;
		}
		CiOrderDO[] orders=CiOrdAppUtils.getOrQryService().findByIds(idArrs, new FBoolean(false));
		orders = new MdsCancelChkBP().exec(new MdsCancelBP().exec(orders));
		//调用执行域接口
		IForeignService mpService = ServiceFinder.find(IForeignService.class);
		mpService.techCancel(idArrs);
		return rst;
	}
}
