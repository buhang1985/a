package iih.pe.pqn.peevalnutrition.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalnutrition.d.PeEvalNutritionClsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估-营养评估定义数据维护服务
*/
public interface IPeEvalNutritionClsDOCudService {
	/**
	*  健康评估-营养评估定义数据真删除
	*/
    public abstract void delete(PeEvalNutritionClsDO[] aggdos) throws BizException;
    
    /**
	*  健康评估-营养评估定义数据插入保存
	*/
	public abstract PeEvalNutritionClsDO[] insert(PeEvalNutritionClsDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-营养评估定义数据保存
	*/
	public abstract PeEvalNutritionClsDO[] save(PeEvalNutritionClsDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-营养评估定义数据更新
	*/
	public abstract PeEvalNutritionClsDO[] update(PeEvalNutritionClsDO[] aggdos) throws BizException;
	
	/**
	*  健康评估-营养评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeEvalNutritionClsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeEvalNutritionClsDO[] enableWithoutFilter(PeEvalNutritionClsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeEvalNutritionClsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeEvalNutritionClsDO[] disableVOWithoutFilter(PeEvalNutritionClsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeEvalNutritionClsDO[] aggdos) throws BizException ;
	
}
