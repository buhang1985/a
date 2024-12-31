package iih.bd.mm.warehouseinfo.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗物品_与仓库关系数据维护服务
*/
public interface IWarehouseinfoCudService {
	/**
	*  医疗物品_与仓库关系数据真删除
	*/
    public abstract void delete(WarehouseInfoDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品_与仓库关系数据插入保存
	*/
	public abstract WarehouseInfoDO[] insert(WarehouseInfoDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_与仓库关系数据保存
	*/
	public abstract WarehouseInfoDO[] save(WarehouseInfoDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_与仓库关系数据更新
	*/
	public abstract WarehouseInfoDO[] update(WarehouseInfoDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品_与仓库关系数据逻辑删除
	*/
	public abstract void logicDelete(WarehouseInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public WarehouseInfoDO[] enableWithoutFilter(WarehouseInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(WarehouseInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public WarehouseInfoDO[] disableVOWithoutFilter(WarehouseInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(WarehouseInfoDO[] dos) throws BizException ;
}
