package iih.bd.mm.warehouseinfo.s.ds;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.warehouseinfo.bp.CalStockNumValueBp;
import iih.bd.mm.warehouseinfo.bp.InitWhmmByMmcaBp;
import iih.bd.mm.warehouseinfo.bp.UpdateWhmmBp;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.ds.IWarehouseInfoService;
import xap.mw.core.data.BizException;

public class WarehouseInfoServiceImpl implements IWarehouseInfoService {

	@Override
	public WarehouseInfoDO[] disable(WarehouseInfoDO[] wareHouseInfoList) throws BizException {
		
		UpdateWhmmBp bp = new UpdateWhmmBp();
		
		return bp.Disable(wareHouseInfoList);
	}

	@Override
	public void initWareHouseInfo(MMCategoryDO[] mmCategoryList, WarehouseInfoDO wareHouseInfoDO, String pkgTypeID) throws BizException {
		
		InitWhmmByMmcaBp bp = new InitWhmmByMmcaBp();
		
		bp.exec(mmCategoryList, wareHouseInfoDO, pkgTypeID);
	}
	
	@Override
	public void reCalStockNumValue(String[] id_whs, String[] id_mms) throws BizException {
		
		CalStockNumValueBp bp = new CalStockNumValueBp();
		
		bp.exec(id_whs, id_mms);
	}
}
