package iih.ci.mrfp.cimrfp.i;

import xap.mw.core.data.BizException;
import iih.ci.mrfp.cimrfp.d.CiMrFpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 住院病案首页数据维护服务
*/
public interface ICimrfpCudService {
	/**
	*  住院病案首页数据真删除
	*/
    public abstract void delete(CiMrFpDO[] aggdos) throws BizException;
    
    /**
	*  住院病案首页数据插入保存
	*/
	public abstract CiMrFpDO[] insert(CiMrFpDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页数据保存
	*/
	public abstract CiMrFpDO[] save(CiMrFpDO[] aggdos) throws BizException;
	
    /**
	*  住院病案首页数据更新
	*/
	public abstract CiMrFpDO[] update(CiMrFpDO[] aggdos) throws BizException;
	
	/**
	*  住院病案首页数据逻辑删除
	*/
	public abstract void logicDelete(CiMrFpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrFpDO[] enableWithoutFilter(CiMrFpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrFpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrFpDO[] disableVOWithoutFilter(CiMrFpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrFpDO[] dos) throws BizException ;
}