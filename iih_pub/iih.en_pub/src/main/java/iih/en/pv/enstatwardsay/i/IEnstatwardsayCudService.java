package iih.en.pv.enstatwardsay.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enstatwardsay.d.EnStatWardDay;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* enstatwardday数据维护服务
*/
public interface IEnstatwardsayCudService {
	/**
	*  enstatwardday数据真删除
	*/
    public abstract void delete(EnStatWardDay[] aggdos) throws BizException;
    
    /**
	*  enstatwardday数据插入保存
	*/
	public abstract EnStatWardDay[] insert(EnStatWardDay[] aggdos) throws BizException;
	
    /**
	*  enstatwardday数据保存
	*/
	public abstract EnStatWardDay[] save(EnStatWardDay[] aggdos) throws BizException;
	
    /**
	*  enstatwardday数据更新
	*/
	public abstract EnStatWardDay[] update(EnStatWardDay[] aggdos) throws BizException;
	
	/**
	*  enstatwardday数据逻辑删除
	*/
	public abstract void logicDelete(EnStatWardDay[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnStatWardDay[] enableWithoutFilter(EnStatWardDay[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnStatWardDay[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnStatWardDay[] disableVOWithoutFilter(EnStatWardDay[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnStatWardDay[] dos) throws BizException ;
}
