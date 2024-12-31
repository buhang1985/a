package iih.bd.srv.dividelevel.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.dividelevel.d.DivideLevelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 评分等级数据维护服务
*/
public interface IDividelevelCudService {
	/**
	*  评分等级数据真删除
	*/
    public abstract void delete(DivideLevelDO[] aggdos) throws BizException;
    
    /**
	*  评分等级数据插入保存
	*/
	public abstract DivideLevelDO[] insert(DivideLevelDO[] aggdos) throws BizException;
	
    /**
	*  评分等级数据保存
	*/
	public abstract DivideLevelDO[] save(DivideLevelDO[] aggdos) throws BizException;
	
    /**
	*  评分等级数据更新
	*/
	public abstract DivideLevelDO[] update(DivideLevelDO[] aggdos) throws BizException;
	
	/**
	*  评分等级数据逻辑删除
	*/
	public abstract void logicDelete(DivideLevelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DivideLevelDO[] enableWithoutFilter(DivideLevelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DivideLevelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DivideLevelDO[] disableVOWithoutFilter(DivideLevelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DivideLevelDO[] dos) throws BizException ;
}
