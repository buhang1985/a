package iih.ci.ord.s.bp.operableords;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取允许作废撤回的医嘱
 * @author ZHANGWQ
 *
 */
public class JudgeRevertCancelOrderStatusBP extends JudgeBackOrderStatusBP{

	@Override
	protected List<CiOrderDO> getAllowdOrds(CiOrderDO[] orders) {

		List<CiOrderDO> orderList = new ArrayList<CiOrderDO>();
		
		for (CiOrderDO order : orders) {
			// 护士已经作废，未作废确认的医嘱
			if(FBoolean.TRUE.equals(order.getFg_chk()) &&  FBoolean.TRUE.equals(order.getFg_canc()) &&  FBoolean.FALSE.equals(order.getFg_chk_canc())){
				orderList.add(order);
			}
		}

		return orderList;
	}
}
