package iih.bl.st.blpaypatip.s.rule;

import iih.bl.st.blpaypatip.bp.BlPaypatItmLogBP;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 住院收付款表保存后插入日志数据
 * 
 * @author LIM
 * @since 2019-11-06
 */
public class BlPayPatItemIpInsertAfterRule implements IRule<BlPayItmPatIpDO> {

	@Override
	public void process(BlPayItmPatIpDO... BlPayItmPatIpDOArr) throws BizException {
		if (!ArrayUtil.isEmpty(BlPayItmPatIpDOArr)) {
			BlPaypatItmLogBP bp = new BlPaypatItmLogBP();
			bp.exec(BlPayItmPatIpDOArr);
		}
	}

}
