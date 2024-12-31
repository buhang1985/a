package iih.bd.mm.warehouseinfo.s.rule;

import iih.bd.mm.warehouseinfo.bp.WhmmDeBeforBp;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品与仓库关系删除前规则
 * 
 * @author hao_wu
 *
 */
public class WarehouseInfoBeforeDeleteRule implements IRule<WarehouseInfoDO> {

	@Override
	public void process(WarehouseInfoDO... dos) throws BizException {
		// 检查是否允许删除
		WhmmDeBeforBp bp = new WhmmDeBeforBp();

		bp.exec(dos);
	}

}
