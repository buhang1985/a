package iih.bd.mm.packageunit.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗物品_包装单位类型数据维护服务
*/
public interface IPackageunitCudService {
	/**
	*  医疗物品_包装单位类型数据真删除
	*/
    public abstract void delete(PackageUnitDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品_包装单位类型数据插入保存
	*/
	public abstract PackageUnitDO[] insert(PackageUnitDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_包装单位类型数据保存
	*/
	public abstract PackageUnitDO[] save(PackageUnitDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_包装单位类型数据更新
	*/
	public abstract PackageUnitDO[] update(PackageUnitDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品_包装单位类型数据逻辑删除
	*/
	public abstract void logicDelete(PackageUnitDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PackageUnitDO[] enableWithoutFilter(PackageUnitDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PackageUnitDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PackageUnitDO[] disableVOWithoutFilter(PackageUnitDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PackageUnitDO[] dos) throws BizException ;
}
