package iih.sc.scbd.scdeptparam.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 排班科室参数数据维护服务
*/
public interface IScdeptparamMDOCudService {
	/**
	*  排班科室参数数据真删除
	*/
    public abstract void delete(ScDeptParamDO[] aggdos) throws BizException;
    
    /**
	*  排班科室参数数据插入保存
	*/
	public abstract ScDeptParamDO[] insert(ScDeptParamDO[] aggdos) throws BizException;
	
    /**
	*  排班科室参数数据保存
	*/
	public abstract ScDeptParamDO[] save(ScDeptParamDO[] aggdos) throws BizException;
	
    /**
	*  排班科室参数数据更新
	*/
	public abstract ScDeptParamDO[] update(ScDeptParamDO[] aggdos) throws BizException;
	
	/**
	*  排班科室参数数据逻辑删除
	*/
	public abstract void logicDelete(ScDeptParamDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScDeptParamDO[] enableWithoutFilter(ScDeptParamDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScDeptParamDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScDeptParamDO[] disableVOWithoutFilter(ScDeptParamDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScDeptParamDO[] aggdos) throws BizException ;
	
}
