package iih.pe.pbd.pelockerroom.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pelockerroom.d.PeLockerRoomDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检中心更衣室维护数据维护服务
*/
public interface IPelockerroomCudService {
	/**
	*  体检中心更衣室维护数据真删除
	*/
    public abstract void delete(PeLockerRoomDO[] aggdos) throws BizException;
    
    /**
	*  体检中心更衣室维护数据插入保存
	*/
	public abstract PeLockerRoomDO[] insert(PeLockerRoomDO[] aggdos) throws BizException;
	
    /**
	*  体检中心更衣室维护数据保存
	*/
	public abstract PeLockerRoomDO[] save(PeLockerRoomDO[] aggdos) throws BizException;
	
    /**
	*  体检中心更衣室维护数据更新
	*/
	public abstract PeLockerRoomDO[] update(PeLockerRoomDO[] aggdos) throws BizException;
	
	/**
	*  体检中心更衣室维护数据逻辑删除
	*/
	public abstract void logicDelete(PeLockerRoomDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeLockerRoomDO[] enableWithoutFilter(PeLockerRoomDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeLockerRoomDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeLockerRoomDO[] disableVOWithoutFilter(PeLockerRoomDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeLockerRoomDO[] dos) throws BizException ;
}
