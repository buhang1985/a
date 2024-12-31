package iih.bd.res.dayslot.i;

import xap.mw.core.data.BizException;
import iih.bd.res.dayslot.d.DayslotSecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 日期分组数据维护服务
*/
public interface IDayslotSecDOCudService {
	/**
	*  日期分组数据真删除
	*/
    public abstract void delete(DayslotSecDO[] aggdos) throws BizException;
    
    /**
	*  日期分组数据插入保存
	*/
	public abstract DayslotSecDO[] insert(DayslotSecDO[] aggdos) throws BizException;
	
    /**
	*  日期分组数据保存
	*/
	public abstract DayslotSecDO[] save(DayslotSecDO[] aggdos) throws BizException;
	
    /**
	*  日期分组数据更新
	*/
	public abstract DayslotSecDO[] update(DayslotSecDO[] aggdos) throws BizException;
	
	/**
	*  日期分组数据逻辑删除
	*/
	public abstract void logicDelete(DayslotSecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DayslotSecDO[] enableWithoutFilter(DayslotSecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DayslotSecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DayslotSecDO[] disableVOWithoutFilter(DayslotSecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DayslotSecDO[] aggdos) throws BizException ;
	
}
