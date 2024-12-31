package iih.bd.srv.freqdef.s.rule;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.s.rule.bp.FreqdefFiledValueChangCheckBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 频次字段值变更检查规则
 * 
 * @author hao_wu
 *
 */
public class FreqdefFiledValueChangCheckRule implements ICompareRule<FreqDefDO> {

	@Override
	public void process(FreqDefDO[] arg0, FreqDefDO[] arg1) throws BizException {
		FreqdefFiledValueChangCheckBp bp = new FreqdefFiledValueChangCheckBp();
		for (int i = 0; i < arg0.length; i++) {
			FreqDefDO newData = arg0[i];
			FreqDefDO oldData = arg1[i];
			bp.exec(newData, oldData);
		}

	}

}
