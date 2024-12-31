package iih.bd.mm.meterial.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗物品数据维护服务
*/
public interface IMMPackageUnitDOCudService {
	/**
	*  医疗物品数据真删除
	*/
    public abstract void delete(MMPackageUnitDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品数据插入保存
	*/
	public abstract MMPackageUnitDO[] insert(MMPackageUnitDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品数据保存
	*/
	public abstract MMPackageUnitDO[] save(MMPackageUnitDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品数据更新
	*/
	public abstract MMPackageUnitDO[] update(MMPackageUnitDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品数据逻辑删除
	*/
	public abstract void logicDelete(MMPackageUnitDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MMPackageUnitDO[] enableWithoutFilter(MMPackageUnitDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MMPackageUnitDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MMPackageUnitDO[] disableVOWithoutFilter(MMPackageUnitDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MMPackageUnitDO[] aggdos) throws BizException ;
	
}
