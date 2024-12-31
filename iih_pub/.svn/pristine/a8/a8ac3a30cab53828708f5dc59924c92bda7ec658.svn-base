package iih.pe.phm.peexerciseplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peexerciseplan.d.PeExerciseListDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检运动计划数据维护服务
*/
public interface IPeExerciseListDOCudService {
	/**
	*  体检运动计划数据真删除
	*/
    public abstract void delete(PeExerciseListDO[] aggdos) throws BizException;
    
    /**
	*  体检运动计划数据插入保存
	*/
	public abstract PeExerciseListDO[] insert(PeExerciseListDO[] aggdos) throws BizException;
	
    /**
	*  体检运动计划数据保存
	*/
	public abstract PeExerciseListDO[] save(PeExerciseListDO[] aggdos) throws BizException;
	
    /**
	*  体检运动计划数据更新
	*/
	public abstract PeExerciseListDO[] update(PeExerciseListDO[] aggdos) throws BizException;
	
	/**
	*  体检运动计划数据逻辑删除
	*/
	public abstract void logicDelete(PeExerciseListDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeExerciseListDO[] enableWithoutFilter(PeExerciseListDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeExerciseListDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeExerciseListDO[] disableVOWithoutFilter(PeExerciseListDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeExerciseListDO[] aggdos) throws BizException ;
	
}
