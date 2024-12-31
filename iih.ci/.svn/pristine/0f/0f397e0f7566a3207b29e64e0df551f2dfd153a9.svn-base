package iih.ci.ord.s.bp.operableords;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱停止撤回判断
 * @author zhangwq
 *
 */
public class JudgeRevertStopOrdersStatusBP extends JudgeStopOrderStatusBP {

	@Override
	protected void orStatusValidat(CiOrderDO[] orders) throws BizException {
		String[] idors = new String[orders.length];
		for (int i=0;i<orders.length;i++) {
			idors[i] = orders[i].getId_or();
		}
		CiOrderDO[] ordersDb =  CiOrdAppUtils.getOrQryService().findByIds(idors,FBoolean.FALSE);
		String errorOr = "";
		for(CiOrderDO orderdo : ordersDb){
			if(!(orderdo.getFg_stop().booleanValue()&&!orderdo.getFg_chk_stop().booleanValue()&&orderdo.getFg_long().booleanValue())){
				errorOr+=orderdo.getName_or()+",";
			}
		}
		if(!CiOrdUtils.isEmpty(errorOr)){
			errorOr = errorOr.substring(0, errorOr.length()-1);
			new BizException("医嘱"+errorOr+"的医嘱状态已改变，请刷新界面重试！");
		}
	}
}
