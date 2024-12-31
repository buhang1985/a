package iih.bd.res.warehouse.s.rule;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.s.bp.WarehouseDeleteCheckBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 仓库删除规则
 * 
 * @author hao_wu
 *
 */
public class WarehouseDeleteRule implements IRule<WarehouseDO> {

	@Override
	public void process(WarehouseDO... dos) throws BizException {
		WarehouseDeleteCheckBp bp = new WarehouseDeleteCheckBp();
		for (WarehouseDO wareHouseDO : dos) {
			bp.Exec(wareHouseDO);
		}
	}
}
