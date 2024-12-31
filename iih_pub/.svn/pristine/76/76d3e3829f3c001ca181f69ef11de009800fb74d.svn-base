package iih.ci.ord.pub.listener;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 执行确认类医嘱，护士核对停止侦听器
 * （停止核对时执行完成状态判断及修改的逻辑）
 * 非护理等级、营养、病情等类型的
 * 非  OrMpStatusModTimerGenListener 中情形
 * @version xuxing_2019年6月27日16:23:59，核停监听，营养类医嘱的定义为（营养类并且是持续类频次的）
 * 
 */
public class MpConfirmOrStopChkListener extends AbstractOrStopCheckListener {
	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为非护理等级、营养、病情医嘱判断
		//OrMpStatusModTimerGenListener 中的  医嘱判断条件
		//if (!(CiOrderTypeEnum.NSGRADEORDER
		//		.equals(CiOrPubUtils.getCiOrderType(or))
		//		|| CiOrderTypeEnum.NUTRIONDIETORDER.equals(CiOrPubUtils
		//				.getCiOrderType(or))
		//		|| CiOrderTypeEnum.ILLSTATEORDER.equals(CiOrPubUtils
		//				.getCiOrderType(or))))
		//	return true;
		//return false;
		Integer orTp = CiOrPubUtils.getCiOrderType(or);
		if (CiOrderTypeEnum.NSGRADEORDER == orTp)
			return false;
		if (CiOrderTypeEnum.NUTRIONDIETORDER == orTp && IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS.equals(or.getId_freq()))
			return false;
		if (CiOrderTypeEnum.ILLSTATEORDER == orTp)
			return false;
		return true;
	}
}
