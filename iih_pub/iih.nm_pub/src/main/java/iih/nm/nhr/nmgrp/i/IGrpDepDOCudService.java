package iih.nm.nhr.nmgrp.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmgrp.d.GrpDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理小组数据维护服务
*/
public interface IGrpDepDOCudService {
	/**
	*  护理小组数据真删除
	*/
    public abstract void delete(GrpDepDO[] aggdos) throws BizException;
    
    /**
	*  护理小组数据插入保存
	*/
	public abstract GrpDepDO[] insert(GrpDepDO[] aggdos) throws BizException;
	
    /**
	*  护理小组数据保存
	*/
	public abstract GrpDepDO[] save(GrpDepDO[] aggdos) throws BizException;
	
    /**
	*  护理小组数据更新
	*/
	public abstract GrpDepDO[] update(GrpDepDO[] aggdos) throws BizException;
	
	/**
	*  护理小组数据逻辑删除
	*/
	public abstract void logicDelete(GrpDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public GrpDepDO[] enableWithoutFilter(GrpDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(GrpDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public GrpDepDO[] disableVOWithoutFilter(GrpDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(GrpDepDO[] aggdos) throws BizException ;
	
}
