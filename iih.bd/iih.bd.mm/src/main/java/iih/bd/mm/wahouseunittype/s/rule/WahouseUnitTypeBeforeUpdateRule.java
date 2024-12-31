package iih.bd.mm.wahouseunittype.s.rule;

import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.s.bp.UpdateOperaterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 仓库包装单位类型更新前规则
 * 
 * @author hao_wu
 *
 */
public class WahouseUnitTypeBeforeUpdateRule implements IRule<WahouseUnitTypeDO> {

	@Override
	public void process(WahouseUnitTypeDO... arg0) throws BizException {
		UpdateOperaterBp bp = new UpdateOperaterBp();
		bp.exec(arg0);
	}
}
