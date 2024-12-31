package iih.pe.pwf.pewfroom.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pewfroom.d.PeWfRoomDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检流程诊间数据维护服务
*/
public interface IPewfroomCudService {
	/**
	*  体检流程诊间数据真删除
	*/
    public abstract void delete(PeWfRoomDO[] aggdos) throws BizException;
    
    /**
	*  体检流程诊间数据插入保存
	*/
	public abstract PeWfRoomDO[] insert(PeWfRoomDO[] aggdos) throws BizException;
	
    /**
	*  体检流程诊间数据保存
	*/
	public abstract PeWfRoomDO[] save(PeWfRoomDO[] aggdos) throws BizException;
	
    /**
	*  体检流程诊间数据更新
	*/
	public abstract PeWfRoomDO[] update(PeWfRoomDO[] aggdos) throws BizException;
	
	/**
	*  体检流程诊间数据逻辑删除
	*/
	public abstract void logicDelete(PeWfRoomDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeWfRoomDO[] enableWithoutFilter(PeWfRoomDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeWfRoomDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeWfRoomDO[] disableVOWithoutFilter(PeWfRoomDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeWfRoomDO[] dos) throws BizException ;
}
