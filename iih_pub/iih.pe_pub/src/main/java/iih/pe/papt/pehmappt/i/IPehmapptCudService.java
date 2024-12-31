package iih.pe.papt.pehmappt.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pehmappt.d.PeHmApptDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 健康管理服务预约数据维护服务
*/
public interface IPehmapptCudService {
	/**
	*  健康管理服务预约数据真删除
	*/
    public abstract void delete(PeHmApptDO[] aggdos) throws BizException;
    
    /**
	*  健康管理服务预约数据插入保存
	*/
	public abstract PeHmApptDO[] insert(PeHmApptDO[] aggdos) throws BizException;
	
    /**
	*  健康管理服务预约数据保存
	*/
	public abstract PeHmApptDO[] save(PeHmApptDO[] aggdos) throws BizException;
	
    /**
	*  健康管理服务预约数据更新
	*/
	public abstract PeHmApptDO[] update(PeHmApptDO[] aggdos) throws BizException;
	
	/**
	*  健康管理服务预约数据逻辑删除
	*/
	public abstract void logicDelete(PeHmApptDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeHmApptDO[] enableWithoutFilter(PeHmApptDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeHmApptDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeHmApptDO[] disableVOWithoutFilter(PeHmApptDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeHmApptDO[] dos) throws BizException ;
}
