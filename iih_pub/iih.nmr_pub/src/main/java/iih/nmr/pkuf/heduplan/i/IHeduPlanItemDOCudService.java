package iih.nmr.pkuf.heduplan.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.heduplan.d.HeduPlanItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康教育计划数据维护服务
*/
public interface IHeduPlanItemDOCudService {
	/**
	*  健康教育计划数据真删除
	*/
    public abstract void delete(HeduPlanItemDO[] aggdos) throws BizException;
    
    /**
	*  健康教育计划数据插入保存
	*/
	public abstract HeduPlanItemDO[] insert(HeduPlanItemDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划数据保存
	*/
	public abstract HeduPlanItemDO[] save(HeduPlanItemDO[] aggdos) throws BizException;
	
    /**
	*  健康教育计划数据更新
	*/
	public abstract HeduPlanItemDO[] update(HeduPlanItemDO[] aggdos) throws BizException;
	
	/**
	*  健康教育计划数据逻辑删除
	*/
	public abstract void logicDelete(HeduPlanItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HeduPlanItemDO[] enableWithoutFilter(HeduPlanItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HeduPlanItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HeduPlanItemDO[] disableVOWithoutFilter(HeduPlanItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HeduPlanItemDO[] aggdos) throws BizException ;
	
}