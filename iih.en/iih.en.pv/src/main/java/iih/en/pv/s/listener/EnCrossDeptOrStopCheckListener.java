package iih.en.pv.s.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.CrossDeptOrStopCheckListener;
import iih.en.pv.s.bp.mt.HandleEntCrossDeptBP;
import xap.mw.core.data.BizException;

/**
 * 跨科医嘱停止确认监听器
 * 
 * @author liubin
 *
 */
public class EnCrossDeptOrStopCheckListener extends CrossDeptOrStopCheckListener {
	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		HandleEntCrossDeptBP handleBP = new HandleEntCrossDeptBP();
		handleBP.delEntCrossDept(ors);
	}
}
