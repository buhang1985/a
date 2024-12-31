package iih.bd.res.warehouse.s.rule;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.s.bp.DeptUniqueRuleBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 仓库所属部门唯一性规则
 * 
 * @author hao_wu
 *
 */
public class DeptUniqueRule implements IRule<WarehouseDO> {

	@Override
	public void process(WarehouseDO... arg0) throws BizException {
		if (arg0 == null || arg0.length <= 0) {
			return;
		}
		DeptUniqueRuleBp bp = new DeptUniqueRuleBp();
		bp.exec(arg0);
	}
}
