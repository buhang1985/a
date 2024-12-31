package iih.bd.srv.mropgrouplevel.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mropgrouplevel.d.MrOpGroupLevelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 操作层级数据维护服务
*/
public interface IMropgrouplevelCudService {
	/**
	*  操作层级数据真删除
	*/
    public abstract void delete(MrOpGroupLevelDO[] aggdos) throws BizException;
    
    /**
	*  操作层级数据插入保存
	*/
	public abstract MrOpGroupLevelDO[] insert(MrOpGroupLevelDO[] aggdos) throws BizException;
	
    /**
	*  操作层级数据保存
	*/
	public abstract MrOpGroupLevelDO[] save(MrOpGroupLevelDO[] aggdos) throws BizException;
	
    /**
	*  操作层级数据更新
	*/
	public abstract MrOpGroupLevelDO[] update(MrOpGroupLevelDO[] aggdos) throws BizException;
	
	/**
	*  操作层级数据逻辑删除
	*/
	public abstract void logicDelete(MrOpGroupLevelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrOpGroupLevelDO[] enableWithoutFilter(MrOpGroupLevelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrOpGroupLevelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrOpGroupLevelDO[] disableVOWithoutFilter(MrOpGroupLevelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrOpGroupLevelDO[] dos) throws BizException ;
}
