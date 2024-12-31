package iih.sc.apt.scapt.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.scapt.d.AptOthDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 计划排班-预约-其他数据维护服务
*/
public interface IAptothCudService {
	/**
	*  计划排班-预约-其他数据真删除
	*/
    public abstract void delete(AptOthDO[] aggdos) throws BizException;
    
    /**
	*  计划排班-预约-其他数据插入保存
	*/
	public abstract AptOthDO[] insert(AptOthDO[] aggdos) throws BizException;
	
    /**
	*  计划排班-预约-其他数据保存
	*/
	public abstract AptOthDO[] save(AptOthDO[] aggdos) throws BizException;
	
    /**
	*  计划排班-预约-其他数据更新
	*/
	public abstract AptOthDO[] update(AptOthDO[] aggdos) throws BizException;
	
	/**
	*  计划排班-预约-其他数据逻辑删除
	*/
	public abstract void logicDelete(AptOthDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AptOthDO[] enableWithoutFilter(AptOthDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AptOthDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AptOthDO[] disableVOWithoutFilter(AptOthDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AptOthDO[] dos) throws BizException ;
}
