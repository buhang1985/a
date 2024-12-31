package iih.bd.mm.warehouseinfo.i.ds;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BizException;

public interface IWarehouseInfoService {
	
	/**
	 * 仓库物品关系停用 
	 * @param wareHouseInfoList 仓库ID
	 */
	public WarehouseInfoDO[] disable(WarehouseInfoDO[] wareHouseInfoList) throws BizException;
	
	/**
	 * 批量生成仓库物品关系
	 * @param mmCategoryList 所选分类列表
	 * @param wareHouseInfoDO 仓库与物品关系模板
	 * @param pkgTypeID 包装单位类型
	 * @throws BizException
	 */
	public void initWareHouseInfo(MMCategoryDO[] mmCategoryList, WarehouseInfoDO wareHouseInfoDO, String pkgTypeID) throws BizException;
	
	/**
	 * 重新计算仓库最高最低储值
	 * @param id_whs 仓库ID
	 */
	public void reCalStockNumValue(String[] id_whs, String[] id_mms) throws BizException;
}
