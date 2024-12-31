package iih.bd.res.warehouse.s.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseRService;
import iih.mc.common.params.McParams;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;

/**
 * 仓库更新检查
 * 
 * @author hao_wu
 *
 */
public class WarehouseUpdateCheckBp {

	public void Exec(WarehouseDO wareHouseDO) throws BizException {
		IWarehouseRService iWarehouseRService = ServiceFinder.find(IWarehouseRService.class);
		WarehouseDO oldWareHouseDO = iWarehouseRService.findById(wareHouseDO.getId_wh());
		if (oldWareHouseDO == null) {
			throw new BizException("数据已被他人删除，请刷新页面.");
		}

		// 末级仓库改为非末级仓库时
		if (oldWareHouseDO.getFg_last().booleanValue() && !wareHouseDO.getFg_last().booleanValue()) {
			// 是否有期初数据
			CheckStockPerInitBp checkStockPerInitBp = new CheckStockPerInitBp();
			Boolean hadStockPerInit = checkStockPerInitBp.Exec(wareHouseDO);
			if (hadStockPerInit) {
				throw new BizException("存在期初数据，不允许改为非末级仓库。");
			}

			// 是否已期初记账
			CheckStockPerAccBp stockPerAccBp = new CheckStockPerAccBp();
			Boolean hadStockPerAcc = stockPerAccBp.Exec(wareHouseDO);
			if (hadStockPerAcc) {
				throw new BizException("已期初记账，不允许改为非末级仓库。");
			}

			// 是否有仓库物品关系
			CheckMmRelBp checkMmRelBp = new CheckMmRelBp();
			Boolean hadMmRel = checkMmRelBp.Exec(wareHouseDO);
			if (hadMmRel) {
				throw new BizException("存在仓库物品关系，不允许改为非末级仓库。");
			}

			// 是否有仓库单位类型
			CheckPckTypeRelBp checkPckTypeRelBp = new CheckPckTypeRelBp();
			Boolean hadPckTypeRel = checkPckTypeRelBp.Exec(wareHouseDO);
			if (hadPckTypeRel) {
				throw new BizException("存在仓库单位类型关系，不允许改为非末级仓库。");
			}

			// 是否有仓库货位
			CheckLocRelBp checkLocRelBp = new CheckLocRelBp();
			Boolean hadLocRel = checkLocRelBp.Exec(wareHouseDO);
			if (hadLocRel) {
				throw new BizException("存在仓库货位关系，不允许改为非末级仓库。");
			}
		}

		// 非末级仓库改为末级仓库时
		if (!oldWareHouseDO.getFg_last().booleanValue() && wareHouseDO.getFg_last().booleanValue()) {
			// 是否有下级仓库
			CheckChildWhBp bp = new CheckChildWhBp();
			Boolean hadChildWh = bp.Exec(wareHouseDO);
			if (hadChildWh) {
				throw new BizException("存在下级仓库，不能修改该仓库为末级仓库。");
			}
		}
		
		//如果是高值耗材 组织参数里设置了是正式库 验证代销库是否勾选 
		if(IBdResDictCodeConst.SD_WHTP_HVHAOCAI.equals(wareHouseDO.getSd_whtp())){
			String whCode = McParams.MCHV0001();
			if(StringUtils.isNotBlank(whCode) && whCode.equals(wareHouseDO.getCode()) && wareHouseDO.getFg_escrow().booleanValue()){
				throw new BizException("该仓库为正式库，不能设为代销库，如需变更正式库请修改组织级参数 MCHV0001！");
			}
		}
		
	}
}
