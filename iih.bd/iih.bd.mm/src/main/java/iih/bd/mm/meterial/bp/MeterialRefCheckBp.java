package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.common.MmSQLHelper;
import iih.bd.mm.custcategoryitem.d.CustCategoryItemRelDO;
import iih.bd.mm.custcategoryitem.i.ICustCategoryItemRelDORService;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.supplierprotocol.d.ProtocolGoodsDO;
import iih.bd.mm.supplierprotocol.i.IProtocolGoodsDORService;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import iih.mm.bl.stockbl.d.StockBlDO;
import iih.mm.bl.stockbl.i.IStockblRService;
import iih.mm.mc.stockperinit.d.StockPerInitItemDO;
import iih.mm.mc.stockperinit.i.IStockPerInitItemDORService;
import iih.mm.st.stockin.d.StockInItemDO;
import iih.mm.st.stockin.i.IStockInItemDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MeterialRefCheckBp {

	/**
	 * 判断物品是否有库存记录
	 * 
	 * @param meterialDO
	 *            物品
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	public boolean isStockExist(String[] meterialIds) throws BizException {
		
		IStockblRService blRSrv = ServiceFinder.find(IStockblRService.class);
		
		StockBlDO[] blDOS = blRSrv.findByAttrValStrings(StockBlDO.ID_MM, meterialIds);
		if(blDOS == null || blDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	/**
	 * 判断物品是否有库存记录(指定仓库)
	 * 
	 * @param meterialDO
	 *            物品
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	public boolean isStockExistByWh(String whouseID, String meterialId) throws BizException {
		
		IStockblRService blRSrv = ServiceFinder.find(IStockblRService.class);
		
		String whrStr = String.format("id_wh = '%s' and id_mm = '%s'", whouseID, meterialId);
		StockBlDO[] blDOS = blRSrv.find(whrStr, "", FBoolean.TRUE);
		if(blDOS == null || blDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	/**
	 * 判断物品是否有期初记录
	 * 
	 * @param meterialDO
	 *            物品
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	public boolean isStockPerInitExist(String[] meterialIds) throws BizException {
		
		IStockPerInitItemDORService initItemRSrv = ServiceFinder.find(IStockPerInitItemDORService.class);
		
		StockPerInitItemDO[] initItemDOS = initItemRSrv.findByAttrValStrings(StockPerInitItemDO.ID_MM, meterialIds);
		if(initItemDOS == null || initItemDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	/**
	 * 判断物品是否有入库记录
	 * 
	 * @param meterialDO
	 *            物品
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	public boolean isStockIn(String[] meterialIds) throws BizException {
		
		IStockInItemDORService inItemRSrv = ServiceFinder.find(IStockInItemDORService.class);
		
		StockInItemDO[] inItemDOS = inItemRSrv.findByAttrValStrings(StockInItemDO.ID_MM, meterialIds);
		if(inItemDOS == null || inItemDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	/**
	 * 判断物品是否被自定义分类引用
	 * 
	 * @param meterialDO
	 *            物品
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	public boolean isRefByCustCategory(MeterialDO[] meterialDOs) throws BizException {
		
		List<String> mmIdList = new ArrayList<String>();
		for(MeterialDO mmDO : meterialDOs) {
			
			mmIdList.add(mmDO.getId_mm());
		}
		
		return this.isRefByCustCategory(mmIdList.toArray(new String[mmIdList.size()]));
	}
	
	public boolean isRefByCustCategory(String[] meterialIds) throws BizException {
		
		ICustCategoryItemRelDORService relRSrv = ServiceFinder.find(ICustCategoryItemRelDORService.class);
		
		CustCategoryItemRelDO[] caItemRelDOS = relRSrv.findByAttrValStrings(CustCategoryItemRelDO.ID_MMORCA, meterialIds);
		if(caItemRelDOS == null || caItemRelDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}

	/**
	 * 判断物品是否有供应商关系及协议信息
	 * 
	 * @param meterialDO
	 *            物品
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	public boolean isSupplierprotocolExist(String[] meterialIds) throws BizException {
		
		IProtocolGoodsDORService proMmRSrv = ServiceFinder.find(IProtocolGoodsDORService.class);
		
		ProtocolGoodsDO[] proGoodsDOS = proMmRSrv.findByAttrValStrings(ProtocolGoodsDO.ID_MM, meterialIds);
		if(proGoodsDOS == null || proGoodsDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}

	/**
	 * 判断物品是否有仓库与物品关系信息
	 * 
	 * @param meterialDO
	 *            物品
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	public boolean isWarehouseExist(String[] meterialIds) throws BizException {
		
		IWarehouseinfoRService whMmRSrv = ServiceFinder.find(IWarehouseinfoRService.class);
		
		String mmCondition = MmSQLHelper.initInCondition(WarehouseInfoDO.ID_MM, meterialIds);
		String whrStr = String.format(" %s and fg_base = 'N'", mmCondition);
		WarehouseInfoDO[] whMmDOS = whMmRSrv.find(whrStr, "", FBoolean.TRUE);
		if(whMmDOS == null || whMmDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
	public boolean isDepartmentExist(String[] meterialIds) throws BizException {
		
		IWarehouseinfoRService whMmRSrv = ServiceFinder.find(IWarehouseinfoRService.class);
		
		String mmCondition = MmSQLHelper.initInCondition(WarehouseInfoDO.ID_MM, meterialIds);
		String whrStr = String.format(" %s and fg_base = 'Y'", mmCondition);
		WarehouseInfoDO[] whMmDOS = whMmRSrv.find(whrStr, "", FBoolean.TRUE);
		if(whMmDOS == null || whMmDOS.length <= 0) {
			
			return false;
		} else {
			
			return true;
		}
	}
}
