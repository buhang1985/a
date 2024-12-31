package iih.bd.mm.ctr.s.rule;

import iih.bd.mm.ctr.d.MmUseStrategyDO;
import iih.bd.mm.ctr.s.bp.UseStragyCuAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品使用策略插入或更新后策略
 * 
 * @author hao_wu
 *
 */
public class MmUseStrategyAfterInsertOrUpdateRule implements IRule<MmUseStrategyDO> {

	@Override
	public void process(MmUseStrategyDO... useStrategyDOS) throws BizException {
		UseStragyCuAfterBp bp = new UseStragyCuAfterBp();

		bp.exec(useStrategyDOS);
	}

}
