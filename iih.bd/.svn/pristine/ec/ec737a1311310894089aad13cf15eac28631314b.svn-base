package iih.bd.mm.meterial.s.rule;

import iih.bd.mm.meterial.bp.MaterialDeBeforeBp;
import iih.bd.mm.meterial.d.MeterialAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品基本信息删除前规则
 * 
 * @author hao_wu
 *
 */
public class MeterialAggBeforeDeleteRule implements IRule<MeterialAggDO> {

	@Override
	public void process(MeterialAggDO... mmAggDOS) throws BizException {
		// 检查是否允许删除
		MaterialDeBeforeBp bp = new MaterialDeBeforeBp();

		bp.exec(mmAggDOS);
	}
}
