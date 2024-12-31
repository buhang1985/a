package iih.bd.srv.freqdef.s.rule;

import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.s.rule.bp.FreqdefAggFiledValueChangCheckBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 字段值变更检查规则
 * 
 * @author hao_wu
 *
 */
public class FreqdefAggFiledValueChangCheckRule implements ICompareRule<FreqdefAggDO> {

	@Override
	public void process(FreqdefAggDO[] arg0, FreqdefAggDO[] arg1) throws BizException {
		FreqdefAggFiledValueChangCheckBp bp = new FreqdefAggFiledValueChangCheckBp();
		for (int i = 0; i < arg0.length; i++) {
			FreqdefAggDO newData = arg0[i];
			FreqdefAggDO oldData = arg1[i];
			bp.exec(newData, oldData);
		}
	}

}
