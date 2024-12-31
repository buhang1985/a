package iih.bd.res.empdep.i;

import xap.mw.core.data.BizException;
import iih.bd.res.empdep.d.EmpDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 科室员工关系维护数据维护服务
*/
public interface IEmpdepCudService {
	/**
	*  科室员工关系维护数据真删除
	*/
    public abstract void delete(EmpDepDO[] aggdos) throws BizException;
    
    /**
	*  科室员工关系维护数据插入保存
	*/
	public abstract EmpDepDO[] insert(EmpDepDO[] aggdos) throws BizException;
	
    /**
	*  科室员工关系维护数据保存
	*/
	public abstract EmpDepDO[] save(EmpDepDO[] aggdos) throws BizException;
	
    /**
	*  科室员工关系维护数据更新
	*/
	public abstract EmpDepDO[] update(EmpDepDO[] aggdos) throws BizException;
	
	/**
	*  科室员工关系维护数据逻辑删除
	*/
	public abstract void logicDelete(EmpDepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmpDepDO[] enableWithoutFilter(EmpDepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmpDepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmpDepDO[] disableVOWithoutFilter(EmpDepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmpDepDO[] dos) throws BizException ;
}
