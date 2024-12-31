package iih.bd.mm.meterial.s.rule;

import iih.bd.mm.meterial.bp.MaterialCuAfterBp;
import iih.bd.mm.meterial.d.MeterialAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品基本信息插入或更新后规则
 * 
 * @author hao_wu
 *
 */
public class MeterialAggAfterInsertOrUpdateRule implements IRule<MeterialAggDO> {

	@Override
	public void process(MeterialAggDO... meterialAggDOS) throws BizException {
		MaterialCuAfterBp bp = new MaterialCuAfterBp();

		bp.exec(meterialAggDOS);
	}
}
