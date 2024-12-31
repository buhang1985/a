package iih.bd.res.goodslocation.i;

import xap.mw.core.data.BizException;
import iih.bd.res.goodslocation.d.GoodslocationDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 货位数据维护服务
*/
public interface IGoodslocationCudService {
	/**
	*  货位数据真删除
	*/
    public abstract void delete(GoodslocationDO[] aggdos) throws BizException;
    
    /**
	*  货位数据插入保存
	*/
	public abstract GoodslocationDO[] insert(GoodslocationDO[] aggdos) throws BizException;
	
    /**
	*  货位数据保存
	*/
	public abstract GoodslocationDO[] save(GoodslocationDO[] aggdos) throws BizException;
	
    /**
	*  货位数据更新
	*/
	public abstract GoodslocationDO[] update(GoodslocationDO[] aggdos) throws BizException;
	
	/**
	*  货位数据逻辑删除
	*/
	public abstract void logicDelete(GoodslocationDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public GoodslocationDO[] enableWithoutFilter(GoodslocationDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(GoodslocationDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public GoodslocationDO[] disableVOWithoutFilter(GoodslocationDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(GoodslocationDO[] dos) throws BizException ;
}
