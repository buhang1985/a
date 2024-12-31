package iih.mm.qy.priceadjust.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.priceadjust.d.PriceAdjustView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 调价查询数据维护服务
*/
public interface IPriceadjustCudService {
	/**
	*  调价查询数据真删除
	*/
    public abstract void delete(PriceAdjustView[] aggdos) throws BizException;
    
    /**
	*  调价查询数据插入保存
	*/
	public abstract PriceAdjustView[] insert(PriceAdjustView[] aggdos) throws BizException;
	
    /**
	*  调价查询数据保存
	*/
	public abstract PriceAdjustView[] save(PriceAdjustView[] aggdos) throws BizException;
	
    /**
	*  调价查询数据更新
	*/
	public abstract PriceAdjustView[] update(PriceAdjustView[] aggdos) throws BizException;
	
	/**
	*  调价查询数据逻辑删除
	*/
	public abstract void logicDelete(PriceAdjustView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PriceAdjustView[] enableWithoutFilter(PriceAdjustView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PriceAdjustView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PriceAdjustView[] disableVOWithoutFilter(PriceAdjustView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PriceAdjustView[] dos) throws BizException ;
}
