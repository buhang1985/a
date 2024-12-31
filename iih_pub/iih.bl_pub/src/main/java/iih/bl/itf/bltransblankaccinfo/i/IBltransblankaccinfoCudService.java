package iih.bl.itf.bltransblankaccinfo.i;

import xap.mw.core.data.BizException;
import iih.bl.itf.bltransblankaccinfo.d.BlTransBlankAccInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 转账信息表数据维护服务
*/
public interface IBltransblankaccinfoCudService {
	/**
	*  转账信息表数据真删除
	*/
    public abstract void delete(BlTransBlankAccInfoDO[] aggdos) throws BizException;
    
    /**
	*  转账信息表数据插入保存
	*/
	public abstract BlTransBlankAccInfoDO[] insert(BlTransBlankAccInfoDO[] aggdos) throws BizException;
	
    /**
	*  转账信息表数据保存
	*/
	public abstract BlTransBlankAccInfoDO[] save(BlTransBlankAccInfoDO[] aggdos) throws BizException;
	
    /**
	*  转账信息表数据更新
	*/
	public abstract BlTransBlankAccInfoDO[] update(BlTransBlankAccInfoDO[] aggdos) throws BizException;
	
	/**
	*  转账信息表数据逻辑删除
	*/
	public abstract void logicDelete(BlTransBlankAccInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BlTransBlankAccInfoDO[] enableWithoutFilter(BlTransBlankAccInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BlTransBlankAccInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BlTransBlankAccInfoDO[] disableVOWithoutFilter(BlTransBlankAccInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BlTransBlankAccInfoDO[] dos) throws BizException ;
}
