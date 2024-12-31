package iih.bd.res.warehouse.s.rule;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.s.bp.WarehouseUpdateCheckBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 仓库删除规则
 * 
 * @author hao_wu
 *
 */
public class WarehouseUpdateRule implements IRule<WarehouseDO> {

	@Override
	public void process(WarehouseDO... dos) throws BizException {
		WarehouseUpdateCheckBp bp = new WarehouseUpdateCheckBp();
		for (WarehouseDO wareHouseDO : dos) {
			bp.Exec(wareHouseDO);
		}
	}

}
