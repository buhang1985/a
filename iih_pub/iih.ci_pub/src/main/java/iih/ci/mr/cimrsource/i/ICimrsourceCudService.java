package iih.ci.mr.cimrsource.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历源内容数据维护服务
*/
public interface ICimrsourceCudService {
	/**
	*  病历源内容数据真删除
	*/
    public abstract void delete(CiMrSourceDO[] aggdos) throws BizException;
    
    /**
	*  病历源内容数据插入保存
	*/
	public abstract CiMrSourceDO[] insert(CiMrSourceDO[] aggdos) throws BizException;
	
    /**
	*  病历源内容数据保存
	*/
	public abstract CiMrSourceDO[] save(CiMrSourceDO[] aggdos) throws BizException;
	
    /**
	*  病历源内容数据更新
	*/
	public abstract CiMrSourceDO[] update(CiMrSourceDO[] aggdos) throws BizException;
	
	/**
	*  病历源内容数据逻辑删除
	*/
	public abstract void logicDelete(CiMrSourceDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrSourceDO[] enableWithoutFilter(CiMrSourceDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrSourceDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrSourceDO[] disableVOWithoutFilter(CiMrSourceDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrSourceDO[] dos) throws BizException ;
}
