package iih.ci.mr.cimrafterchido.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrafterchido.d.CiMrAfterChiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 产程图数据维护服务
*/
public interface ICimrafterchidoCudService {
	/**
	*  产程图数据真删除
	*/
    public abstract void delete(CiMrAfterChiDO[] aggdos) throws BizException;
    
    /**
	*  产程图数据插入保存
	*/
	public abstract CiMrAfterChiDO[] insert(CiMrAfterChiDO[] aggdos) throws BizException;
	
    /**
	*  产程图数据保存
	*/
	public abstract CiMrAfterChiDO[] save(CiMrAfterChiDO[] aggdos) throws BizException;
	
    /**
	*  产程图数据更新
	*/
	public abstract CiMrAfterChiDO[] update(CiMrAfterChiDO[] aggdos) throws BizException;
	
	/**
	*  产程图数据逻辑删除
	*/
	public abstract void logicDelete(CiMrAfterChiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrAfterChiDO[] enableWithoutFilter(CiMrAfterChiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrAfterChiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrAfterChiDO[] disableVOWithoutFilter(CiMrAfterChiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrAfterChiDO[] dos) throws BizException ;
}
