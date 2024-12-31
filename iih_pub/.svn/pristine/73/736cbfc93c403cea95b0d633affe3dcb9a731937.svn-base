package iih.sc.scbd.schedulechl.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班预约渠道数据维护服务
*/
public interface ISchedulechlMDOCudService {
	/**
	*  排班预约渠道数据真删除
	*/
    public abstract void delete(SchedulechlDO[] aggdos) throws BizException;
    
    /**
	*  排班预约渠道数据插入保存
	*/
	public abstract SchedulechlDO[] insert(SchedulechlDO[] aggdos) throws BizException;
	
    /**
	*  排班预约渠道数据保存
	*/
	public abstract SchedulechlDO[] save(SchedulechlDO[] aggdos) throws BizException;
	
    /**
	*  排班预约渠道数据更新
	*/
	public abstract SchedulechlDO[] update(SchedulechlDO[] aggdos) throws BizException;
	
	/**
	*  排班预约渠道数据逻辑删除
	*/
	public abstract void logicDelete(SchedulechlDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SchedulechlDO[] enableWithoutFilter(SchedulechlDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SchedulechlDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SchedulechlDO[] disableVOWithoutFilter(SchedulechlDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SchedulechlDO[] aggdos) throws BizException ;
	
}
