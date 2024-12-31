package iih.pe.pqc.peqcchart.i;

import xap.mw.core.data.BizException;
import iih.pe.pqc.peqcchart.d.PeQcChartDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检质控图数据维护服务
*/
public interface IPeqcchartMDOCudService {
	/**
	*  体检质控图数据真删除
	*/
    public abstract void delete(PeQcChartDO[] aggdos) throws BizException;
    
    /**
	*  体检质控图数据插入保存
	*/
	public abstract PeQcChartDO[] insert(PeQcChartDO[] aggdos) throws BizException;
	
    /**
	*  体检质控图数据保存
	*/
	public abstract PeQcChartDO[] save(PeQcChartDO[] aggdos) throws BizException;
	
    /**
	*  体检质控图数据更新
	*/
	public abstract PeQcChartDO[] update(PeQcChartDO[] aggdos) throws BizException;
	
	/**
	*  体检质控图数据逻辑删除
	*/
	public abstract void logicDelete(PeQcChartDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeQcChartDO[] enableWithoutFilter(PeQcChartDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeQcChartDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeQcChartDO[] disableVOWithoutFilter(PeQcChartDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeQcChartDO[] aggdos) throws BizException ;
	
}
