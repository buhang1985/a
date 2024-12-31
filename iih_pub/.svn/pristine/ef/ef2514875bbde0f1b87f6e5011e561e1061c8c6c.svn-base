package iih.pe.por.pecoupon.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pecoupon.d.PeCouponPieceDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检卷数据维护服务
*/
public interface IPeCouponPieceDOCudService {
	/**
	*  体检卷数据真删除
	*/
    public abstract void delete(PeCouponPieceDO[] aggdos) throws BizException;
    
    /**
	*  体检卷数据插入保存
	*/
	public abstract PeCouponPieceDO[] insert(PeCouponPieceDO[] aggdos) throws BizException;
	
    /**
	*  体检卷数据保存
	*/
	public abstract PeCouponPieceDO[] save(PeCouponPieceDO[] aggdos) throws BizException;
	
    /**
	*  体检卷数据更新
	*/
	public abstract PeCouponPieceDO[] update(PeCouponPieceDO[] aggdos) throws BizException;
	
	/**
	*  体检卷数据逻辑删除
	*/
	public abstract void logicDelete(PeCouponPieceDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCouponPieceDO[] enableWithoutFilter(PeCouponPieceDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCouponPieceDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCouponPieceDO[] disableVOWithoutFilter(PeCouponPieceDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCouponPieceDO[] aggdos) throws BizException ;
	
}
