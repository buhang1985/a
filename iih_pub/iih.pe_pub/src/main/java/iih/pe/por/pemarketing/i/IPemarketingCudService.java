package iih.pe.por.pemarketing.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pemarketing.d.PeMarketingDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检市场营销活动数据维护服务
*/
public interface IPemarketingCudService {
	/**
	*  体检市场营销活动数据真删除
	*/
    public abstract void delete(PeMarketingDO[] aggdos) throws BizException;
    
    /**
	*  体检市场营销活动数据插入保存
	*/
	public abstract PeMarketingDO[] insert(PeMarketingDO[] aggdos) throws BizException;
	
    /**
	*  体检市场营销活动数据保存
	*/
	public abstract PeMarketingDO[] save(PeMarketingDO[] aggdos) throws BizException;
	
    /**
	*  体检市场营销活动数据更新
	*/
	public abstract PeMarketingDO[] update(PeMarketingDO[] aggdos) throws BizException;
	
	/**
	*  体检市场营销活动数据逻辑删除
	*/
	public abstract void logicDelete(PeMarketingDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeMarketingDO[] enableWithoutFilter(PeMarketingDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeMarketingDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeMarketingDO[] disableVOWithoutFilter(PeMarketingDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeMarketingDO[] dos) throws BizException ;
}
