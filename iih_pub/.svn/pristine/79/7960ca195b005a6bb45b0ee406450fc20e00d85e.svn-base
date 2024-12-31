package iih.pe.pitm.peexercise.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.peexercise.d.PeExerciseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检运动种类定义数据维护服务
*/
public interface IPeexerciseCudService {
	/**
	*  体检运动种类定义数据真删除
	*/
    public abstract void delete(PeExerciseDO[] aggdos) throws BizException;
    
    /**
	*  体检运动种类定义数据插入保存
	*/
	public abstract PeExerciseDO[] insert(PeExerciseDO[] aggdos) throws BizException;
	
    /**
	*  体检运动种类定义数据保存
	*/
	public abstract PeExerciseDO[] save(PeExerciseDO[] aggdos) throws BizException;
	
    /**
	*  体检运动种类定义数据更新
	*/
	public abstract PeExerciseDO[] update(PeExerciseDO[] aggdos) throws BizException;
	
	/**
	*  体检运动种类定义数据逻辑删除
	*/
	public abstract void logicDelete(PeExerciseDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeExerciseDO[] enableWithoutFilter(PeExerciseDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeExerciseDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeExerciseDO[] disableVOWithoutFilter(PeExerciseDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeExerciseDO[] dos) throws BizException ;
}
