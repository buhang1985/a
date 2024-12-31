package iih.bd.mm.dataimpt;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 物品仓库关系数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class MmWhDataImptServiceImpl extends BDBaseDataImport<WarehouseInfoDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WarehouseInfoDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WarehouseInfoDO.ID_MMWH, WarehouseInfoDO.ID_GRP, WarehouseInfoDO.ID_ORG,
				WarehouseInfoDO.ID_WH, WarehouseInfoDO.ID_MM, WarehouseInfoDO.MAXSTNUM, WarehouseInfoDO.LOWSTNUM,
				WarehouseInfoDO.FG_ACTIVE, WarehouseInfoDO.FG_OUT, WarehouseInfoDO.FG_BASE };
	}

	@Override
	protected void insertToDB(WarehouseInfoDO[] importDatas) throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(importDatas);
//		ServiceFinder.find(IWarehouseinfoCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WarehouseInfoDO[] importDatas) throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.updateDOs(importDatas);
//		ServiceFinder.find(IWarehouseinfoCudService.class).update(importDatas);
	}

	@Override
	protected void checkImportData(WarehouseInfoDO[] importDatas) throws BizException {
		checkValue(importDatas);
	}

	@Override
	protected void updateImportNewData(WarehouseInfoDO[] importDatas) throws BizException {
		setMmpkgu(importDatas);
	}

	private void setMmpkgu(WarehouseInfoDO[] dOS) throws BizException {

		IMMPackageUnitDORService mmpkgSrv = ServiceFinder.find(IMMPackageUnitDORService.class);
		MMPackageUnitDO[] pkgDoList = mmpkgSrv.find(" SD_MMPKGUPRO = '" + IBdMmDictCodeConst.SD_MMPKGUPRO_SELL + "'",
				"", FBoolean.TRUE);

		if (pkgDoList == null || pkgDoList.length <= 0) {
			throw new BizException("包装单位没有记录。");
		}
		Map<String, String> pkgDoListMap = new HashMap<String, String>();
		for (MMPackageUnitDO mmPackageUnitDO : pkgDoList) {
			pkgDoListMap.put(mmPackageUnitDO.getId_mm(), mmPackageUnitDO.getId_mmpkgu());
		}

		for (WarehouseInfoDO DO : dOS) {
			DO.setMaxuinum(DO.getMaxstnum());
			DO.setLowuinum(DO.getLowstnum());
			if (pkgDoListMap.get(DO.getId_mm()) == null)
				throw new BizException("根据 WarehouseInfoDO.getId_mm()=" + DO.getId_mm() + "获取包装单位失败。");
			DO.setId_mmpkgu_ui(pkgDoListMap.get(DO.getId_mm()));
		}
	}

	private void checkValue(WarehouseInfoDO[] dOS) throws BizException {
		for (WarehouseInfoDO DO : dOS) {
			int i = 0;
			for (WarehouseInfoDO dO : dOS) {
				if (DO.getId_wh().equals(dO.getId_wh()) && DO.getId_mm().equals(dO.getId_mm())) {
					i = i + 1;
				}
			}

			if (i > 1) {
				String error = String.format("(bd_mm_wh)仓库(id_wh)%s下有重复的物品(id_mm)%s", DO.getId_wh(), DO.getId_mm());
				throw new BizException(error);
			}
		}
	}

}
