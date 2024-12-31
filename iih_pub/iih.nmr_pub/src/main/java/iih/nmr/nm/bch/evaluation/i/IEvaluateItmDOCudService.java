package iih.nmr.nm.bch.evaluation.i;

import xap.mw.core.data.BizException;
import iih.nmr.nm.bch.evaluation.d.EvaluateItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者和家属健康教育计划表数据维护服务
*/
public interface IEvaluateItmDOCudService {
	/**
	*  患者和家属健康教育计划表数据真删除
	*/
    public abstract void delete(EvaluateItmDO[] aggdos) throws BizException;
    
    /**
	*  患者和家属健康教育计划表数据插入保存
	*/
	public abstract EvaluateItmDO[] insert(EvaluateItmDO[] aggdos) throws BizException;
	
    /**
	*  患者和家属健康教育计划表数据保存
	*/
	public abstract EvaluateItmDO[] save(EvaluateItmDO[] aggdos) throws BizException;
	
    /**
	*  患者和家属健康教育计划表数据更新
	*/
	public abstract EvaluateItmDO[] update(EvaluateItmDO[] aggdos) throws BizException;
	
	/**
	*  患者和家属健康教育计划表数据逻辑删除
	*/
	public abstract void logicDelete(EvaluateItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EvaluateItmDO[] enableWithoutFilter(EvaluateItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EvaluateItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EvaluateItmDO[] disableVOWithoutFilter(EvaluateItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EvaluateItmDO[] aggdos) throws BizException ;
	
}
