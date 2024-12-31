package iih.en.pv.s.listener;

import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.listener.AbstractOrCancelCheckListener;
import iih.en.pv.s.listener.bp.EnIpTransDeptOrCancelCheckListenerBP;
import xap.mw.core.data.BizException;


/**
 * 就诊转科医嘱作废确认监听器
 * 
 * @author liubin
 *
 */
public class EnIpTransDeptOrCancelCheckListener extends
		AbstractOrCancelCheckListener {
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为转科医嘱判断
		if (CiOrderTypeEnum.DEPT2DEPTORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
	@Override
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
	    EnIpTransDeptOrCancelCheckListenerBP bp = new EnIpTransDeptOrCancelCheckListenerBP();
	    bp.exec(ors);
	}
}
