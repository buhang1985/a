package iih.bd.mm.mmcategory.bp;

import iih.bd.mm.custcategoryitem.d.CustCategoryItemRelDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.mmcategory.bp.qry.CheckMmcaRefSql;
import iih.bd.mm.mmcategory.bp.qry.CheckStockDataSql;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.IMmcategoryRService;
import iih.mm.bl.stockbl.d.StockBlDO;
import iih.mm.mc.stockperinit.d.StockPerInitItemDO;
import iih.mm.st.stockin.d.StockInItemDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;


/*
 * 提供医疗物品基本分类是否已被使用的检测方法。
 * 
 */
public class CategoryRefCheckBp {
	
	public void checkCanUpdate(MMCategoryDO mmcaDO) throws BizException {
		
		//基本分类和子分类下物品是否有期初数据
		CheckStockDataSql Sql = new CheckStockDataSql((new StockPerInitItemDO()).getTableName(), mmcaDO.getInnercode());
		StockPerInitItemDO[] initItemList = (StockPerInitItemDO[]) AppFwUtil.getDORstWithDao(Sql, StockPerInitItemDO.class);
		if(initItemList != null && initItemList.length > 0) {
			
			throw new BizException(String.format("基本分类【%s】或其子分类下物品有期初数据，不允许修改价格管理信息。", mmcaDO.getName()));
		}
		//是否有入库数据
		Sql = new CheckStockDataSql((new StockInItemDO()).getTableName(), mmcaDO.getInnercode());
		StockInItemDO[] inItemList = (StockInItemDO[]) AppFwUtil.getDORstWithDao(Sql, StockInItemDO.class);
		if(inItemList != null && inItemList.length > 0) {
			
			throw new BizException(String.format("基本分类【%s】或其子分类下物品有入库数据，不允许修改价格管理信息。", mmcaDO.getName()));
		}
		//是否有结存数据
		Sql = new CheckStockDataSql((new StockBlDO()).getTableName(), mmcaDO.getInnercode());
		StockBlDO[] blList = (StockBlDO[]) AppFwUtil.getDORstWithDao(Sql, StockBlDO.class);
		if(blList != null && blList.length > 0) {
			
			throw new BizException(String.format("基本分类【%s】或其子分类下物品有结存数据，不允许修改价格管理信息。", mmcaDO.getName()));
		}
	}
	
	public void checkCanDelete(MMCategoryDO[] mmcaDOS) throws BizException {
		
		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);
		
		for(MMCategoryDO mmcaDO : mmcaDOS) {
			
			//分类是否有子分类
			String whrStr = String.format("innercode like '%s%%' and innercode <> '%s'", 
					mmcaDO.getInnercode(), mmcaDO.getInnercode());
			MMCategoryDO[] mmcaList = mmcaRSrv.find(whrStr, "", FBoolean.TRUE);
			if(mmcaList != null && mmcaList.length > 0) {
				
				throw new BizException(String.format("物品基本分类【%s】下有子分类，不允许删除。", mmcaDO.getName()));
			}
			//分类下是否有物品
			CheckMmcaRefSql Sql = new CheckMmcaRefSql((new MeterialDO()).getTableName(), mmcaDO.getInnercode());
			MeterialDO[] mmList = (MeterialDO[]) AppFwUtil.getDORstWithDao(Sql, MeterialDO.class);
			if(mmList != null && mmList.length > 0) {
				
				throw new BizException(String.format("基本分类【%s】或其子分类有关联物品，不允许删除，", mmcaDO.getName()));
			}
			//分类下是否有分类自定义项目
			Sql = new CheckMmcaRefSql((new CustCategoryItemRelDO()).getTableName(), mmcaDO.getInnercode());
			CustCategoryItemRelDO[] custCaList = (CustCategoryItemRelDO[]) AppFwUtil.getDORstWithDao(Sql, CustCategoryItemRelDO.class);
			if(custCaList != null && custCaList.length > 0) {
				
				throw new BizException(String.format("基本分类【%s】或其子分类有自定义分类项目，不允许删除，", mmcaDO.getName()));
			}
		}
	}
}
