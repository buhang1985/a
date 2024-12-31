package iih.pe.pqry.pelogcatlog.i;

import xap.mw.core.data.BizException;
import iih.pe.pqry.pelogcatlog.d.PeLogCatlogDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检项目变更日志数据维护服务
*/
public interface IPelogcatlogCudService {
	/**
	*  体检项目变更日志数据真删除
	*/
    public abstract void delete(PeLogCatlogDO[] aggdos) throws BizException;
    
    /**
	*  体检项目变更日志数据插入保存
	*/
	public abstract PeLogCatlogDO[] insert(PeLogCatlogDO[] aggdos) throws BizException;
	
    /**
	*  体检项目变更日志数据保存
	*/
	public abstract PeLogCatlogDO[] save(PeLogCatlogDO[] aggdos) throws BizException;
	
    /**
	*  体检项目变更日志数据更新
	*/
	public abstract PeLogCatlogDO[] update(PeLogCatlogDO[] aggdos) throws BizException;
	
	/**
	*  体检项目变更日志数据逻辑删除
	*/
	public abstract void logicDelete(PeLogCatlogDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeLogCatlogDO[] enableWithoutFilter(PeLogCatlogDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeLogCatlogDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeLogCatlogDO[] disableVOWithoutFilter(PeLogCatlogDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeLogCatlogDO[] dos) throws BizException ;
}
