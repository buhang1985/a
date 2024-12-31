package iih.mp.dg.sheetexchek.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.sheetexchek.d.SheetExcCheckDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药单异常校验类型配置数据维护服务
*/
public interface ISheetexchekCudService {
	/**
	*  药单异常校验类型配置数据真删除
	*/
    public abstract void delete(SheetExcCheckDO[] aggdos) throws BizException;
    
    /**
	*  药单异常校验类型配置数据插入保存
	*/
	public abstract SheetExcCheckDO[] insert(SheetExcCheckDO[] aggdos) throws BizException;
	
    /**
	*  药单异常校验类型配置数据保存
	*/
	public abstract SheetExcCheckDO[] save(SheetExcCheckDO[] aggdos) throws BizException;
	
    /**
	*  药单异常校验类型配置数据更新
	*/
	public abstract SheetExcCheckDO[] update(SheetExcCheckDO[] aggdos) throws BizException;
	
	/**
	*  药单异常校验类型配置数据逻辑删除
	*/
	public abstract void logicDelete(SheetExcCheckDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SheetExcCheckDO[] enableWithoutFilter(SheetExcCheckDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SheetExcCheckDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SheetExcCheckDO[] disableVOWithoutFilter(SheetExcCheckDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SheetExcCheckDO[] dos) throws BizException ;
}
