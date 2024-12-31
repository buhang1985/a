package iih.bd.mm.meterial.s.rule;

import iih.bd.mm.meterial.bp.MaterialCuBeforeBp;
import iih.bd.mm.meterial.d.MeterialAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品基本信息插入前规则
 * 
 * @author hao_wu
 *
 */
public class MeterialAggBeforeInsertRule implements IRule<MeterialAggDO> {

	@Override
	public void process(MeterialAggDO... mmAggDOS) throws BizException {
		MaterialCuBeforeBp bp = new MaterialCuBeforeBp();

		bp.exec(mmAggDOS, null);
	}
}
