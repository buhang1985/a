package iih.nm.nhr.nmnhrsigrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrsigrp.d.NhrSigrpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班分组数据维护服务
*/
public interface INmnhrsigrpMDOCudService {
	/**
	*  排班分组数据真删除
	*/
    public abstract void delete(NhrSigrpDO[] aggdos) throws BizException;
    
    /**
	*  排班分组数据插入保存
	*/
	public abstract NhrSigrpDO[] insert(NhrSigrpDO[] aggdos) throws BizException;
	
    /**
	*  排班分组数据保存
	*/
	public abstract NhrSigrpDO[] save(NhrSigrpDO[] aggdos) throws BizException;
	
    /**
	*  排班分组数据更新
	*/
	public abstract NhrSigrpDO[] update(NhrSigrpDO[] aggdos) throws BizException;
	
	/**
	*  排班分组数据逻辑删除
	*/
	public abstract void logicDelete(NhrSigrpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NhrSigrpDO[] enableWithoutFilter(NhrSigrpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NhrSigrpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NhrSigrpDO[] disableVOWithoutFilter(NhrSigrpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NhrSigrpDO[] aggdos) throws BizException ;
	
}
