package iih.pe.pqn.peevalkinematics.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalkinematics.d.PeEvalKinematicsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估-运动评估定义数据维护服务
*/
public interface IPeevalkinematicsMDOCudService {
	/**
	*  健康评估-运动评估定义数据真删除
	*/
    public abstract void delete(PeEvalKinematicsDO[] aggdos) throws BizException;
    
    /**
	*  健康评估-运动评估定义数据插入保存
	*/
	public abstract PeEvalKinematicsDO[] insert(PeEvalKinematicsDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-运动评估定义数据保存
	*/
	public abstract PeEvalKinematicsDO[] save(PeEvalKinematicsDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-运动评估定义数据更新
	*/
	public abstract PeEvalKinematicsDO[] update(PeEvalKinematicsDO[] aggdos) throws BizException;
	
	/**
	*  健康评估-运动评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeEvalKinematicsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeEvalKinematicsDO[] enableWithoutFilter(PeEvalKinematicsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeEvalKinematicsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeEvalKinematicsDO[] disableVOWithoutFilter(PeEvalKinematicsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeEvalKinematicsDO[] aggdos) throws BizException ;
	
}
