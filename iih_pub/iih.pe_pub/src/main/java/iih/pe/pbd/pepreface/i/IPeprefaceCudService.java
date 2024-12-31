package iih.pe.pbd.pepreface.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pepreface.d.PePrefaceDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检报告卷首语数据维护服务
*/
public interface IPeprefaceCudService {
	/**
	*  体检报告卷首语数据真删除
	*/
    public abstract void delete(PePrefaceDO[] aggdos) throws BizException;
    
    /**
	*  体检报告卷首语数据插入保存
	*/
	public abstract PePrefaceDO[] insert(PePrefaceDO[] aggdos) throws BizException;
	
    /**
	*  体检报告卷首语数据保存
	*/
	public abstract PePrefaceDO[] save(PePrefaceDO[] aggdos) throws BizException;
	
    /**
	*  体检报告卷首语数据更新
	*/
	public abstract PePrefaceDO[] update(PePrefaceDO[] aggdos) throws BizException;
	
	/**
	*  体检报告卷首语数据逻辑删除
	*/
	public abstract void logicDelete(PePrefaceDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PePrefaceDO[] enableWithoutFilter(PePrefaceDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PePrefaceDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PePrefaceDO[] disableVOWithoutFilter(PePrefaceDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PePrefaceDO[] dos) throws BizException ;
}
