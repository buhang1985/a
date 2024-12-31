package iih.bd.mm.warehouseinfo.s.rule;

import iih.bd.mm.warehouseinfo.bp.WhmmCuBeforeBp;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品与仓库关系更新前规则
 * 
 * @author hao_wu
 *
 */
public class WarehouseInfoBeforeUpdateRule implements IRule<WarehouseInfoDO> {

	@Override
	public void process(WarehouseInfoDO... dos) throws BizException {
		// 计算[基数库存_基本单位]
		WhmmCuBeforeBp cudBp = new WhmmCuBeforeBp();

		cudBp.exec(dos);
	}
}
