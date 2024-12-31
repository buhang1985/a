package iih.pe.phm.pekinematics.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pekinematics.d.PeKinematicsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 健康管理运动状态数据维护服务
*/
public interface IPekinematicsCudService {
	/**
	*  健康管理运动状态数据真删除
	*/
    public abstract void delete(PeKinematicsDO[] aggdos) throws BizException;
    
    /**
	*  健康管理运动状态数据插入保存
	*/
	public abstract PeKinematicsDO[] insert(PeKinematicsDO[] aggdos) throws BizException;
	
    /**
	*  健康管理运动状态数据保存
	*/
	public abstract PeKinematicsDO[] save(PeKinematicsDO[] aggdos) throws BizException;
	
    /**
	*  健康管理运动状态数据更新
	*/
	public abstract PeKinematicsDO[] update(PeKinematicsDO[] aggdos) throws BizException;
	
	/**
	*  健康管理运动状态数据逻辑删除
	*/
	public abstract void logicDelete(PeKinematicsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeKinematicsDO[] enableWithoutFilter(PeKinematicsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeKinematicsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeKinematicsDO[] disableVOWithoutFilter(PeKinematicsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeKinematicsDO[] dos) throws BizException ;
}
