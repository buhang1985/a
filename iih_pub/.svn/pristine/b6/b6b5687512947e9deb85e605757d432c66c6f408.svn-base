package iih.pe.pwf.pehealthplatform.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pehealthplatform.d.PeEmrPhysicalReportDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检健康平台接口山东数据维护服务
*/
public interface IPehealthplatformMDOCudService {
	/**
	*  体检健康平台接口山东数据真删除
	*/
    public abstract void delete(PeEmrPhysicalReportDO[] aggdos) throws BizException;
    
    /**
	*  体检健康平台接口山东数据插入保存
	*/
	public abstract PeEmrPhysicalReportDO[] insert(PeEmrPhysicalReportDO[] aggdos) throws BizException;
	
    /**
	*  体检健康平台接口山东数据保存
	*/
	public abstract PeEmrPhysicalReportDO[] save(PeEmrPhysicalReportDO[] aggdos) throws BizException;
	
    /**
	*  体检健康平台接口山东数据更新
	*/
	public abstract PeEmrPhysicalReportDO[] update(PeEmrPhysicalReportDO[] aggdos) throws BizException;
	
	/**
	*  体检健康平台接口山东数据逻辑删除
	*/
	public abstract void logicDelete(PeEmrPhysicalReportDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeEmrPhysicalReportDO[] enableWithoutFilter(PeEmrPhysicalReportDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeEmrPhysicalReportDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeEmrPhysicalReportDO[] disableVOWithoutFilter(PeEmrPhysicalReportDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeEmrPhysicalReportDO[] aggdos) throws BizException ;
	
}
