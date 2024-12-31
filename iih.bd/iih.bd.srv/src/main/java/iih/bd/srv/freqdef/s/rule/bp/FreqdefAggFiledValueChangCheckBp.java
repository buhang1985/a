package iih.bd.srv.freqdef.s.rule.bp;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import xap.mw.core.data.BizException;

/**
 * 频次字段值变更检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FreqdefAggFiledValueChangCheckBp {

	public void exec(FreqdefAggDO newData, FreqdefAggDO oldData) throws BizException {

		FreqDefDO newParentData = newData.getParentDO();
		FreqDefDO oldParentData = oldData.getParentDO();

		FreqdefFiledValueChangCheckBp bp = new FreqdefFiledValueChangCheckBp();
		bp.exec(newParentData, oldParentData);
	}
}
