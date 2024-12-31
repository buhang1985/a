package iih.en.er.pre.i;

import xap.mw.core.data.BizException;
import iih.en.er.pre.d.EnErPreScoreDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 急诊预检_分级数据维护服务
*/
public interface IEnerprescoredoCudService {
	/**
	*  急诊预检_分级数据真删除
	*/
    public abstract void delete(EnErPreScoreDO[] aggdos) throws BizException;
    
    /**
	*  急诊预检_分级数据插入保存
	*/
	public abstract EnErPreScoreDO[] insert(EnErPreScoreDO[] aggdos) throws BizException;
	
    /**
	*  急诊预检_分级数据保存
	*/
	public abstract EnErPreScoreDO[] save(EnErPreScoreDO[] aggdos) throws BizException;
	
    /**
	*  急诊预检_分级数据更新
	*/
	public abstract EnErPreScoreDO[] update(EnErPreScoreDO[] aggdos) throws BizException;
	
	/**
	*  急诊预检_分级数据逻辑删除
	*/
	public abstract void logicDelete(EnErPreScoreDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnErPreScoreDO[] enableWithoutFilter(EnErPreScoreDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnErPreScoreDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnErPreScoreDO[] disableVOWithoutFilter(EnErPreScoreDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnErPreScoreDO[] dos) throws BizException ;
}
