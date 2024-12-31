package iih.bd.srv.deptstd2diag.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.deptstd2diag.d.DeptStdDiagDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 科室常用诊断数据维护服务
*/
public interface IDeptstddiagCudService {
	/**
	*  科室常用诊断数据真删除
	*/
    public abstract void delete(DeptStdDiagDO[] aggdos) throws BizException;
    
    /**
	*  科室常用诊断数据插入保存
	*/
	public abstract DeptStdDiagDO[] insert(DeptStdDiagDO[] aggdos) throws BizException;
	
    /**
	*  科室常用诊断数据保存
	*/
	public abstract DeptStdDiagDO[] save(DeptStdDiagDO[] aggdos) throws BizException;
	
    /**
	*  科室常用诊断数据更新
	*/
	public abstract DeptStdDiagDO[] update(DeptStdDiagDO[] aggdos) throws BizException;
	
	/**
	*  科室常用诊断数据逻辑删除
	*/
	public abstract void logicDelete(DeptStdDiagDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DeptStdDiagDO[] enableWithoutFilter(DeptStdDiagDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DeptStdDiagDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DeptStdDiagDO[] disableVOWithoutFilter(DeptStdDiagDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DeptStdDiagDO[] dos) throws BizException ;
}
