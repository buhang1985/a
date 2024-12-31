package iih.bd.res.place.i;

import xap.mw.core.data.BizException;
import iih.bd.res.place.d.PlaceDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 地点数据维护服务
*/
public interface IPlaceCudService {
	/**
	*  地点数据真删除
	*/
    public abstract void delete(PlaceDO[] aggdos) throws BizException;
    
    /**
	*  地点数据插入保存
	*/
	public abstract PlaceDO[] insert(PlaceDO[] aggdos) throws BizException;
	
    /**
	*  地点数据保存
	*/
	public abstract PlaceDO[] save(PlaceDO[] aggdos) throws BizException;
	
    /**
	*  地点数据更新
	*/
	public abstract PlaceDO[] update(PlaceDO[] aggdos) throws BizException;
	
	/**
	*  地点数据逻辑删除
	*/
	public abstract void logicDelete(PlaceDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PlaceDO[] enableWithoutFilter(PlaceDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PlaceDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PlaceDO[] disableVOWithoutFilter(PlaceDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PlaceDO[] dos) throws BizException ;
}
