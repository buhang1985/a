package iih.en.pv.s.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.CrossDeptOrCancelCheckListener;
import iih.en.pv.s.bp.mt.HandleEntCrossDeptBP;
import xap.mw.core.data.BizException;

/**
 * 跨科医嘱取消确认监听器
 * 
 * @author liubin
 *
 */
public class EnCrossDeptOrCancelCheckListener extends CrossDeptOrCancelCheckListener {
	@Override
	protected void doYourActionAfterOrCancelCheck(CiOrderDO[] ors) throws BizException {
		HandleEntCrossDeptBP handleBP = new HandleEntCrossDeptBP();
		handleBP.delEntCrossDept(ors);
	}
}
