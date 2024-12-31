package iih.bl.st.blpaypatip.s.rule;

import iih.bl.st.blpaypatip.bp.BlPaypatItmLogBP;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 住院收付款表保存后插入日志数据
 * 
 * @author LIM
 * @since 2019-11-06
 */
public class BlpaypatipAggDOInsertAfterRule implements IRule<BlpaypatipAggDO> {

	/**
	 * 住院收付款表保存后插入日志数据
	 */
	@Override
	public void process(BlpaypatipAggDO... aggDos) throws BizException {
		BlPaypatItmLogBP bp = new BlPaypatItmLogBP();
		for (BlpaypatipAggDO aggDO : aggDos) {
			BlPayItmPatIpDO[] BlPayItmPatIpDOArr = aggDO.getBlPayItmPatIpDO();
			if (!ArrayUtil.isEmpty(BlPayItmPatIpDOArr))
				bp.exec(BlPayItmPatIpDOArr);
		}
	}

}
