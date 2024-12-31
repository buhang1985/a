package iih.en.pv.s.listener;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.CrossDeptOrCheckListener;
import iih.en.pv.s.bp.mt.HandleEntCrossDeptBP;
import xap.mw.core.data.BizException;

/**
 * 跨科医嘱签署确认监听器
 * @author liubin
 *
 */
public class EnCrossDeptOrCheckListener extends CrossDeptOrCheckListener{
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors) throws BizException{
		HandleEntCrossDeptBP handleBP = new HandleEntCrossDeptBP();
		handleBP.addEntCrossDept(ors);
	}
}
