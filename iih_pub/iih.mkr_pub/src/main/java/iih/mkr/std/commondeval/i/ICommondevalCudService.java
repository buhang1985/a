package iih.mkr.std.commondeval.i;

import xap.mw.core.data.BizException;
import iih.mkr.std.commondeval.d.DataElementValDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 数据元值数据维护服务
*/
public interface ICommondevalCudService {
	/**
	*  数据元值数据真删除
	*/
    public abstract void delete(DataElementValDO[] aggdos) throws BizException;
    
    /**
	*  数据元值数据插入保存
	*/
	public abstract DataElementValDO[] insert(DataElementValDO[] aggdos) throws BizException;
	
    /**
	*  数据元值数据保存
	*/
	public abstract DataElementValDO[] save(DataElementValDO[] aggdos) throws BizException;
	
    /**
	*  数据元值数据更新
	*/
	public abstract DataElementValDO[] update(DataElementValDO[] aggdos) throws BizException;
	
	/**
	*  数据元值数据逻辑删除
	*/
	public abstract void logicDelete(DataElementValDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DataElementValDO[] enableWithoutFilter(DataElementValDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DataElementValDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DataElementValDO[] disableVOWithoutFilter(DataElementValDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DataElementValDO[] dos) throws BizException ;
}
