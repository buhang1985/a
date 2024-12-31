package iih.sc.scbd.scdeptparam.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班科室参数数据维护服务
*/
public interface IScDeptParamDsDOCudService {
	/**
	*  排班科室参数数据真删除
	*/
    public abstract void delete(ScDeptParamDsDO[] aggdos) throws BizException;
    
    /**
	*  排班科室参数数据插入保存
	*/
	public abstract ScDeptParamDsDO[] insert(ScDeptParamDsDO[] aggdos) throws BizException;
	
    /**
	*  排班科室参数数据保存
	*/
	public abstract ScDeptParamDsDO[] save(ScDeptParamDsDO[] aggdos) throws BizException;
	
    /**
	*  排班科室参数数据更新
	*/
	public abstract ScDeptParamDsDO[] update(ScDeptParamDsDO[] aggdos) throws BizException;
	
	/**
	*  排班科室参数数据逻辑删除
	*/
	public abstract void logicDelete(ScDeptParamDsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScDeptParamDsDO[] enableWithoutFilter(ScDeptParamDsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScDeptParamDsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScDeptParamDsDO[] disableVOWithoutFilter(ScDeptParamDsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScDeptParamDsDO[] aggdos) throws BizException ;
	
}
