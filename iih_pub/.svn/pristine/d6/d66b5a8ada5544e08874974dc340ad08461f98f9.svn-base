package iih.pe.pwf.perstpatghy.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.perstpatghy.d.PeRstPatghyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检病理结果数据维护服务
*/
public interface IPerstpatghyCudService {
	/**
	*  体检病理结果数据真删除
	*/
    public abstract void delete(PeRstPatghyDO[] aggdos) throws BizException;
    
    /**
	*  体检病理结果数据插入保存
	*/
	public abstract PeRstPatghyDO[] insert(PeRstPatghyDO[] aggdos) throws BizException;
	
    /**
	*  体检病理结果数据保存
	*/
	public abstract PeRstPatghyDO[] save(PeRstPatghyDO[] aggdos) throws BizException;
	
    /**
	*  体检病理结果数据更新
	*/
	public abstract PeRstPatghyDO[] update(PeRstPatghyDO[] aggdos) throws BizException;
	
	/**
	*  体检病理结果数据逻辑删除
	*/
	public abstract void logicDelete(PeRstPatghyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstPatghyDO[] enableWithoutFilter(PeRstPatghyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstPatghyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstPatghyDO[] disableVOWithoutFilter(PeRstPatghyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstPatghyDO[] dos) throws BizException ;
}
