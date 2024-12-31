package iih.bd.res.bizgrp.i;

import xap.mw.core.data.BizException;
import iih.bd.res.bizgrp.d.BizGrpEmpsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 业务组数据维护服务
*/
public interface IBizGrpEmpsDOCudService {
	/**
	*  业务组数据真删除
	*/
    public abstract void delete(BizGrpEmpsDO[] aggdos) throws BizException;
    
    /**
	*  业务组数据插入保存
	*/
	public abstract BizGrpEmpsDO[] insert(BizGrpEmpsDO[] aggdos) throws BizException;
	
    /**
	*  业务组数据保存
	*/
	public abstract BizGrpEmpsDO[] save(BizGrpEmpsDO[] aggdos) throws BizException;
	
    /**
	*  业务组数据更新
	*/
	public abstract BizGrpEmpsDO[] update(BizGrpEmpsDO[] aggdos) throws BizException;
	
	/**
	*  业务组数据逻辑删除
	*/
	public abstract void logicDelete(BizGrpEmpsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BizGrpEmpsDO[] enableWithoutFilter(BizGrpEmpsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BizGrpEmpsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BizGrpEmpsDO[] disableVOWithoutFilter(BizGrpEmpsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BizGrpEmpsDO[] aggdos) throws BizException ;
	
}
