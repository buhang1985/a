package iih.pe.pitm.peitfdiags.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.peitfdiags.d.PeItfDiagsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检接口_诊断数据维护服务
*/
public interface IPeitfdiagsCudService {
	/**
	*  体检接口_诊断数据真删除
	*/
    public abstract void delete(PeItfDiagsDO[] aggdos) throws BizException;
    
    /**
	*  体检接口_诊断数据插入保存
	*/
	public abstract PeItfDiagsDO[] insert(PeItfDiagsDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_诊断数据保存
	*/
	public abstract PeItfDiagsDO[] save(PeItfDiagsDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_诊断数据更新
	*/
	public abstract PeItfDiagsDO[] update(PeItfDiagsDO[] aggdos) throws BizException;
	
	/**
	*  体检接口_诊断数据逻辑删除
	*/
	public abstract void logicDelete(PeItfDiagsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeItfDiagsDO[] enableWithoutFilter(PeItfDiagsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeItfDiagsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeItfDiagsDO[] disableVOWithoutFilter(PeItfDiagsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeItfDiagsDO[] dos) throws BizException ;
}
