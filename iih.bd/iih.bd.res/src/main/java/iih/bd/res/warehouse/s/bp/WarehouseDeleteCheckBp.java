package iih.bd.res.warehouse.s.bp;

import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
/**
 * 仓库删除检查
 * @author hao_wu
 *
 */
public class WarehouseDeleteCheckBp {
	public void Exec(WarehouseDO wareHouseDO) throws BizException {
		// 是否有下级仓库
		CheckChildWhBp bp = new CheckChildWhBp();
		Boolean hadChildWh = bp.Exec(wareHouseDO);
		if (hadChildWh) {
			throw new BizException("存在下级仓库，不允许删除。");
		}

		// 是否有期初数据
		CheckStockPerInitBp checkStockPerInitBp = new CheckStockPerInitBp();
		Boolean hadStockPerInit = checkStockPerInitBp.Exec(wareHouseDO);
		if (hadStockPerInit) {
			throw new BizException("存在期初数据，不允许删除。");
		}

		// 是否已期初记账
		CheckStockPerAccBp stockPerAccBp = new CheckStockPerAccBp();
		Boolean hadStockPerAcc = stockPerAccBp.Exec(wareHouseDO);
		if (hadStockPerAcc) {
			throw new BizException("已期初记账，不允许删除。");
		}

		// 是否有仓库物品关系
		CheckMmRelBp checkMmRelBp = new CheckMmRelBp();
		Boolean hadMmRel = checkMmRelBp.Exec(wareHouseDO);
		if (hadMmRel) {
			throw new BizException("存在仓库物品关系，不允许删除。");
		}

		// 是否有仓库单位类型
		CheckPckTypeRelBp checkPckTypeRelBp = new CheckPckTypeRelBp();
		Boolean hadPckTypeRel = checkPckTypeRelBp.Exec(wareHouseDO);
		if (hadPckTypeRel) {
			throw new BizException("存在仓库单位类型关系，不允许删除。");
		}

		// 是否有仓库货位
		CheckLocRelBp checkLocRelBp = new CheckLocRelBp();
		Boolean hadLocRel = checkLocRelBp.Exec(wareHouseDO);
		if (hadLocRel) {
			throw new BizException("存在仓库货位关系，不允许删除。");
		}
	}
}
