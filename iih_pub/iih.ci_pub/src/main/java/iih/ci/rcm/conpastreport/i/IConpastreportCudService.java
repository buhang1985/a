package iih.ci.rcm.conpastreport.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.conpastreport.d.ConPastReportDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 既往已报数据维护服务
*/
public interface IConpastreportCudService {
	/**
	*  既往已报数据真删除
	*/
    public abstract void delete(ConPastReportDO[] aggdos) throws BizException;
    
    /**
	*  既往已报数据插入保存
	*/
	public abstract ConPastReportDO[] insert(ConPastReportDO[] aggdos) throws BizException;
	
    /**
	*  既往已报数据保存
	*/
	public abstract ConPastReportDO[] save(ConPastReportDO[] aggdos) throws BizException;
	
    /**
	*  既往已报数据更新
	*/
	public abstract ConPastReportDO[] update(ConPastReportDO[] aggdos) throws BizException;
	
	/**
	*  既往已报数据逻辑删除
	*/
	public abstract void logicDelete(ConPastReportDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ConPastReportDO[] enableWithoutFilter(ConPastReportDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ConPastReportDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ConPastReportDO[] disableVOWithoutFilter(ConPastReportDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ConPastReportDO[] dos) throws BizException ;
}
