package iih.bd.mm.meterial.s.rule;

import iih.bd.mm.meterial.bp.MaterialCuBeforeBp;
import iih.bd.mm.meterial.d.MeterialAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 物品基本信息更新前规则
 * 
 * @author hao_wu
 *
 */
public class MeterialAggBeforeUpdateRule implements ICompareRule<MeterialAggDO> {

	@Override
	public void process(MeterialAggDO[] mmAggDOS, MeterialAggDO[] originvos) throws BizException {
		MaterialCuBeforeBp bp = new MaterialCuBeforeBp();

		bp.exec(mmAggDOS, originvos);
	}
}
