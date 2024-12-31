package iih.mm.qy.saleprice.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.saleprice.d.SalePriceView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 零售价查询数据维护服务
*/
public interface ISalepriceCudService {
	/**
	*  零售价查询数据真删除
	*/
    public abstract void delete(SalePriceView[] aggdos) throws BizException;
    
    /**
	*  零售价查询数据插入保存
	*/
	public abstract SalePriceView[] insert(SalePriceView[] aggdos) throws BizException;
	
    /**
	*  零售价查询数据保存
	*/
	public abstract SalePriceView[] save(SalePriceView[] aggdos) throws BizException;
	
    /**
	*  零售价查询数据更新
	*/
	public abstract SalePriceView[] update(SalePriceView[] aggdos) throws BizException;
	
	/**
	*  零售价查询数据逻辑删除
	*/
	public abstract void logicDelete(SalePriceView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SalePriceView[] enableWithoutFilter(SalePriceView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SalePriceView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SalePriceView[] disableVOWithoutFilter(SalePriceView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SalePriceView[] dos) throws BizException ;
}
