package iih.bd.mm.warehouseinfo.i;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BizException;

/**
 * 物品与仓库关系扩展CUD服务
 * 
 * @author hao_wu
 *
 */
public interface IWarehouseInfoExtCudService {
	/**
	 * 开放物品与仓库关系
	 * 
	 * @param warehouseInfos
	 * @return
	 * @throws BizException
	 */
	public abstract WarehouseInfoDO[] Open(WarehouseInfoDO[] warehouseInfos) throws BizException;

	/**
	 * 停开物品与仓库关系
	 * 
	 * @param warehouseInfos
	 * @return
	 * @throws BizException
	 */
	public abstract WarehouseInfoDO[] Close(WarehouseInfoDO[] warehouseInfos) throws BizException;

	/**
	 * 在所有仓库中开放指定物品
	 * 
	 * @param materialIds
	 * @return
	 * @throws BizException
	 */
	public abstract void OpenByMaterialIds(String[] materialIds) throws BizException;

	/**
	 * 在所有仓库中停开指定物品
	 * 
	 * @param materialIds
	 * @return
	 * @throws BizException
	 */
	public abstract void CloseByMaterialIds(String[] materialIds) throws BizException;
}
