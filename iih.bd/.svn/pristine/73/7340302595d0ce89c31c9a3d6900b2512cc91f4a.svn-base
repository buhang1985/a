package iih.bd.mm.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 仓库数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class WhDataImptServiceImpl extends BDBaseDataImport<WarehouseDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WarehouseDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WarehouseDO.ID_WH, WarehouseDO.NAME, WarehouseDO.CODE, WarehouseDO.ID_WHTP,
				WarehouseDO.SD_WHTP, WarehouseDO.ID_DEP_BELONG, WarehouseDO.FG_ACCTUNIT, WarehouseDO.FG_ACTIVE,
				WarehouseDO.FG_LAST, WarehouseDO.FG_LOC };
	}

	@Override
	protected void insertToDB(WarehouseDO[] importDatas) throws BizException {
		ServiceFinder.find(IWarehouseCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WarehouseDO[] importDatas) throws BizException {
		ServiceFinder.find(IWarehouseCudService.class).update(importDatas);
	}

	@Override
	protected void checkImportData(WarehouseDO[] importDatas) throws BizException {
		super.checkImportData(importDatas);
		checkValue(importDatas);
	}

	private void checkValue(WarehouseDO[] dOS) throws BizException {

		for (WarehouseDO DO : dOS) {

			if (DO.getFg_last().booleanValue()) {

				for (WarehouseDO dO : dOS) {

					if (DO.getId_wh().equals(dO.getId_parent())) {

						String error = String.format("(bd_wh)仓库(id_wh)%s为末级仓库(FG_LAST为true)，不允许有子仓库", DO.getName());
						throw new BizException(error);
					}
				}
			}
		}
	}
}
