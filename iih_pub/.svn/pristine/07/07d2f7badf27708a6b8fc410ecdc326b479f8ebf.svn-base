package iih.pe.por.pecoupon.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pecoupon.d.PeCouponDO;
import iih.pe.por.pecoupon.d.PecouponAggDO;

/**
* 体检卷数据维护服务
*/
public interface IPecouponCudService {
	/**
	*  体检卷数据真删除
	*/
    public abstract void delete(PecouponAggDO[] aggdos) throws BizException;
    
    /**
	*  体检卷数据插入保存
	*/
	public abstract PecouponAggDO[] insert(PecouponAggDO[] aggdos) throws BizException;
	
    /**
	*  体检卷数据保存
	*/
	public abstract PecouponAggDO[] save(PecouponAggDO[] aggdos) throws BizException;
	
    /**
	*  体检卷数据更新
	*/
	public abstract PecouponAggDO[] update(PecouponAggDO[] aggdos) throws BizException;
	
	/**
	*  体检卷数据逻辑删除
	*/
	public abstract void logicDelete(PecouponAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检卷数据真删除
	 */
	public abstract void deleteByParentDO(PeCouponDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检卷数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeCouponDO[] mainDos) throws BizException;
}
