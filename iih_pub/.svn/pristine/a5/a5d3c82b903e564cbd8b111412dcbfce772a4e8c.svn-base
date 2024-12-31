package iih.ci.ord.pub.listener;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;

/**
 * 营养膳食医嘱签署护士核对侦听器抽象类
 * @version xuxing_2019年6月27日16:26:17，营养类医嘱的定义为（营养类并且是持续类频次的）
 */
public class NutrionDietOrCheckListener extends AbstractOrCheckListener {
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现

	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为营养膳食医嘱判断
		//if (CiOrderTypeEnum.NUTRIONDIETORDER.equals(CiOrPubUtils
		//		.getCiOrderType(or)))
		//	return true;
		//return false;
		if (CiOrderTypeEnum.NUTRIONDIETORDER.equals(CiOrPubUtils.getCiOrderType(or)) && IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS.equals(or.getId_freq()))
			return true;
		return false;
	}
}
