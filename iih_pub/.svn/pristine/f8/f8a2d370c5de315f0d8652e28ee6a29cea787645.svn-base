package iih.cssd.dpp.stz.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpp.stz.d.CssddfpstzDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 包灭菌数据维护服务
*/
public interface IStzMDOCudService {
	/**
	*  包灭菌数据真删除
	*/
    public abstract void delete(CssddfpstzDO[] aggdos) throws BizException;
    
    /**
	*  包灭菌数据插入保存
	*/
	public abstract CssddfpstzDO[] insert(CssddfpstzDO[] aggdos) throws BizException;
	
    /**
	*  包灭菌数据保存
	*/
	public abstract CssddfpstzDO[] save(CssddfpstzDO[] aggdos) throws BizException;
	
    /**
	*  包灭菌数据更新
	*/
	public abstract CssddfpstzDO[] update(CssddfpstzDO[] aggdos) throws BizException;
	
	/**
	*  包灭菌数据逻辑删除
	*/
	public abstract void logicDelete(CssddfpstzDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CssddfpstzDO[] enableWithoutFilter(CssddfpstzDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CssddfpstzDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CssddfpstzDO[] disableVOWithoutFilter(CssddfpstzDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CssddfpstzDO[] aggdos) throws BizException ;
	
}
