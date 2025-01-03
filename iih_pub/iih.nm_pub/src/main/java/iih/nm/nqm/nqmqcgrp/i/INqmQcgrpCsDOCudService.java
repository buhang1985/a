package iih.nm.nqm.nqmqcgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmqcgrp.d.NqmQcgrpCsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 质控组数据维护服务
*/
public interface INqmQcgrpCsDOCudService {
	/**
	*  质控组数据真删除
	*/
    public abstract void delete(NqmQcgrpCsDO[] aggdos) throws BizException;
    
    /**
	*  质控组数据插入保存
	*/
	public abstract NqmQcgrpCsDO[] insert(NqmQcgrpCsDO[] aggdos) throws BizException;
	
    /**
	*  质控组数据保存
	*/
	public abstract NqmQcgrpCsDO[] save(NqmQcgrpCsDO[] aggdos) throws BizException;
	
    /**
	*  质控组数据更新
	*/
	public abstract NqmQcgrpCsDO[] update(NqmQcgrpCsDO[] aggdos) throws BizException;
	
	/**
	*  质控组数据逻辑删除
	*/
	public abstract void logicDelete(NqmQcgrpCsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NqmQcgrpCsDO[] enableWithoutFilter(NqmQcgrpCsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NqmQcgrpCsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NqmQcgrpCsDO[] disableVOWithoutFilter(NqmQcgrpCsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NqmQcgrpCsDO[] aggdos) throws BizException ;
	
}
