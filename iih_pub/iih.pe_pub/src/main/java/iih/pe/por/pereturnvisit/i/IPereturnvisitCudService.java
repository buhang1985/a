package iih.pe.por.pereturnvisit.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pereturnvisit.d.PeReturnVisitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检客户回访数据维护服务
*/
public interface IPereturnvisitCudService {
	/**
	*  体检客户回访数据真删除
	*/
    public abstract void delete(PeReturnVisitDO[] aggdos) throws BizException;
    
    /**
	*  体检客户回访数据插入保存
	*/
	public abstract PeReturnVisitDO[] insert(PeReturnVisitDO[] aggdos) throws BizException;
	
    /**
	*  体检客户回访数据保存
	*/
	public abstract PeReturnVisitDO[] save(PeReturnVisitDO[] aggdos) throws BizException;
	
    /**
	*  体检客户回访数据更新
	*/
	public abstract PeReturnVisitDO[] update(PeReturnVisitDO[] aggdos) throws BizException;
	
	/**
	*  体检客户回访数据逻辑删除
	*/
	public abstract void logicDelete(PeReturnVisitDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeReturnVisitDO[] enableWithoutFilter(PeReturnVisitDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeReturnVisitDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeReturnVisitDO[] disableVOWithoutFilter(PeReturnVisitDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeReturnVisitDO[] dos) throws BizException ;
}