package iih.pe.papt.pereserve.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pereserve.d.PeReserveDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检预定数据维护服务
*/
public interface IPereserveCudService {
	/**
	*  体检预定数据真删除
	*/
    public abstract void delete(PeReserveDO[] aggdos) throws BizException;
    
    /**
	*  体检预定数据插入保存
	*/
	public abstract PeReserveDO[] insert(PeReserveDO[] aggdos) throws BizException;
	
    /**
	*  体检预定数据保存
	*/
	public abstract PeReserveDO[] save(PeReserveDO[] aggdos) throws BizException;
	
    /**
	*  体检预定数据更新
	*/
	public abstract PeReserveDO[] update(PeReserveDO[] aggdos) throws BizException;
	
	/**
	*  体检预定数据逻辑删除
	*/
	public abstract void logicDelete(PeReserveDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeReserveDO[] enableWithoutFilter(PeReserveDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeReserveDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeReserveDO[] disableVOWithoutFilter(PeReserveDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeReserveDO[] dos) throws BizException ;
}
