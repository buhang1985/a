package iih.nm.nqm.nqmcstmplgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nqmcstmplgrp.d.NqmcstmplgrpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 质控标准模板组数据维护服务
*/
public interface INqmcstmplgrpCudService {
	/**
	*  质控标准模板组数据真删除
	*/
    public abstract void delete(NqmcstmplgrpDO[] aggdos) throws BizException;
    
    /**
	*  质控标准模板组数据插入保存
	*/
	public abstract NqmcstmplgrpDO[] insert(NqmcstmplgrpDO[] aggdos) throws BizException;
	
    /**
	*  质控标准模板组数据保存
	*/
	public abstract NqmcstmplgrpDO[] save(NqmcstmplgrpDO[] aggdos) throws BizException;
	
    /**
	*  质控标准模板组数据更新
	*/
	public abstract NqmcstmplgrpDO[] update(NqmcstmplgrpDO[] aggdos) throws BizException;
	
	/**
	*  质控标准模板组数据逻辑删除
	*/
	public abstract void logicDelete(NqmcstmplgrpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NqmcstmplgrpDO[] enableWithoutFilter(NqmcstmplgrpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NqmcstmplgrpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NqmcstmplgrpDO[] disableVOWithoutFilter(NqmcstmplgrpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NqmcstmplgrpDO[] dos) throws BizException ;
}
