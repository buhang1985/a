package iih.pe.pqn.peqaca.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peqaca.d.PeQaCaItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检问卷组套数据维护服务
*/
public interface IPeQaCaItmDOCudService {
	/**
	*  体检问卷组套数据真删除
	*/
    public abstract void delete(PeQaCaItmDO[] aggdos) throws BizException;
    
    /**
	*  体检问卷组套数据插入保存
	*/
	public abstract PeQaCaItmDO[] insert(PeQaCaItmDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷组套数据保存
	*/
	public abstract PeQaCaItmDO[] save(PeQaCaItmDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷组套数据更新
	*/
	public abstract PeQaCaItmDO[] update(PeQaCaItmDO[] aggdos) throws BizException;
	
	/**
	*  体检问卷组套数据逻辑删除
	*/
	public abstract void logicDelete(PeQaCaItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeQaCaItmDO[] enableWithoutFilter(PeQaCaItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeQaCaItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeQaCaItmDO[] disableVOWithoutFilter(PeQaCaItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeQaCaItmDO[] aggdos) throws BizException ;
	
}
