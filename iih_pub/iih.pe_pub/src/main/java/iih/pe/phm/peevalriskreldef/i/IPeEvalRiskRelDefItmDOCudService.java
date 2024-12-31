package iih.pe.phm.peevalriskreldef.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peevalriskreldef.d.PeEvalRiskRelDefItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估-危险因素关系定义数据维护服务
*/
public interface IPeEvalRiskRelDefItmDOCudService {
	/**
	*  健康评估-危险因素关系定义数据真删除
	*/
    public abstract void delete(PeEvalRiskRelDefItmDO[] aggdos) throws BizException;
    
    /**
	*  健康评估-危险因素关系定义数据插入保存
	*/
	public abstract PeEvalRiskRelDefItmDO[] insert(PeEvalRiskRelDefItmDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-危险因素关系定义数据保存
	*/
	public abstract PeEvalRiskRelDefItmDO[] save(PeEvalRiskRelDefItmDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-危险因素关系定义数据更新
	*/
	public abstract PeEvalRiskRelDefItmDO[] update(PeEvalRiskRelDefItmDO[] aggdos) throws BizException;
	
	/**
	*  健康评估-危险因素关系定义数据逻辑删除
	*/
	public abstract void logicDelete(PeEvalRiskRelDefItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeEvalRiskRelDefItmDO[] enableWithoutFilter(PeEvalRiskRelDefItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeEvalRiskRelDefItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeEvalRiskRelDefItmDO[] disableVOWithoutFilter(PeEvalRiskRelDefItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeEvalRiskRelDefItmDO[] aggdos) throws BizException ;
	
}