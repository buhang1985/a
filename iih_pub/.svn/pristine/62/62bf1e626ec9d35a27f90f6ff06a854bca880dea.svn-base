package iih.bd.bs.holiday.i;

import xap.mw.core.data.BizException;
import iih.bd.bs.holiday.d.HolidayDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 假日定义数据维护服务
*/
public interface IHolidayCudService {
	/**
	*  假日定义数据真删除
	*/
    public abstract void delete(HolidayDO[] aggdos) throws BizException;
    
    /**
	*  假日定义数据插入保存
	*/
	public abstract HolidayDO[] insert(HolidayDO[] aggdos) throws BizException;
	
    /**
	*  假日定义数据保存
	*/
	public abstract HolidayDO[] save(HolidayDO[] aggdos) throws BizException;
	
    /**
	*  假日定义数据更新
	*/
	public abstract HolidayDO[] update(HolidayDO[] aggdos) throws BizException;
	
	/**
	*  假日定义数据逻辑删除
	*/
	public abstract void logicDelete(HolidayDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HolidayDO[] enableWithoutFilter(HolidayDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HolidayDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HolidayDO[] disableVOWithoutFilter(HolidayDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HolidayDO[] dos) throws BizException ;
}
