package iih.pe.pwf.pereportbi.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pereportbi.d.PeReportBiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检报告二进制格式数据维护服务
*/
public interface IPereportbiCudService {
	/**
	*  体检报告二进制格式数据真删除
	*/
    public abstract void delete(PeReportBiDO[] aggdos) throws BizException;
    
    /**
	*  体检报告二进制格式数据插入保存
	*/
	public abstract PeReportBiDO[] insert(PeReportBiDO[] aggdos) throws BizException;
	
    /**
	*  体检报告二进制格式数据保存
	*/
	public abstract PeReportBiDO[] save(PeReportBiDO[] aggdos) throws BizException;
	
    /**
	*  体检报告二进制格式数据更新
	*/
	public abstract PeReportBiDO[] update(PeReportBiDO[] aggdos) throws BizException;
	
	/**
	*  体检报告二进制格式数据逻辑删除
	*/
	public abstract void logicDelete(PeReportBiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeReportBiDO[] enableWithoutFilter(PeReportBiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeReportBiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeReportBiDO[] disableVOWithoutFilter(PeReportBiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeReportBiDO[] dos) throws BizException ;
}
