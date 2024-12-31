package iih.ci.ord.cirptlabhis.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cirptlabhis.d.CiRptLabItmHISDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 检验报告单历史数据维护服务
*/
public interface ICiRptLabItmHISDOCudService {
	/**
	*  检验报告单历史数据真删除
	*/
    public abstract void delete(CiRptLabItmHISDO[] aggdos) throws BizException;
    
    /**
	*  检验报告单历史数据插入保存
	*/
	public abstract CiRptLabItmHISDO[] insert(CiRptLabItmHISDO[] aggdos) throws BizException;
	
    /**
	*  检验报告单历史数据保存
	*/
	public abstract CiRptLabItmHISDO[] save(CiRptLabItmHISDO[] aggdos) throws BizException;
	
    /**
	*  检验报告单历史数据更新
	*/
	public abstract CiRptLabItmHISDO[] update(CiRptLabItmHISDO[] aggdos) throws BizException;
	
	/**
	*  检验报告单历史数据逻辑删除
	*/
	public abstract void logicDelete(CiRptLabItmHISDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiRptLabItmHISDO[] enableWithoutFilter(CiRptLabItmHISDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiRptLabItmHISDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiRptLabItmHISDO[] disableVOWithoutFilter(CiRptLabItmHISDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiRptLabItmHISDO[] aggdos) throws BizException ;
	
}
