package iih.nmr.common.hecptp.i;

import xap.mw.core.data.BizException;
import iih.nmr.common.hecptp.d.HeduPlanRelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康教育计划单据类型数据维护服务
*/
public interface IHeduPlanRelDOCudService {
	/**
	*  健康教育计划单据类型数据真删除
	*/
    public abstract void delete(HeduPlanRelDO[] aggdos) throws BizException;
    
    /**
	*  健康教育计划单据类型数据插入保存
	*/
	public abstract HeduPlanRelDO[] insert(HeduPlanRelDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划单据类型数据保存
	*/
	public abstract HeduPlanRelDO[] save(HeduPlanRelDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划单据类型数据更新
	*/
	public abstract HeduPlanRelDO[] update(HeduPlanRelDO[] aggdos) throws BizException;
	
	/**
	*  健康教育计划单据类型数据逻辑删除
	*/
	public abstract void logicDelete(HeduPlanRelDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HeduPlanRelDO[] enableWithoutFilter(HeduPlanRelDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HeduPlanRelDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HeduPlanRelDO[] disableVOWithoutFilter(HeduPlanRelDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HeduPlanRelDO[] aggdos) throws BizException ;
	
}
