package iih.bd.res.warehouse.s.rule;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.s.bp.WarehouseSaveAfterBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 仓库新增规则
 * @author dj.zhang
 *
 */
public class WarehouseSaveRule implements IRule<WarehouseDO> {

	@Override
	public void process(WarehouseDO... dos) throws BizException {
		WarehouseSaveAfterBp bp = new WarehouseSaveAfterBp();
		for (WarehouseDO wareHouseDO : dos) {
			bp.exec(wareHouseDO);
		}
	}

}
