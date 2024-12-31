package iih.nm.nhr.nmnurduty.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurduty.d.NmNurDutyDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员职务数据维护服务
*/
public interface INmnurdutyCudService {
	/**
	*  人员职务数据真删除
	*/
    public abstract void delete(NmNurDutyDO[] aggdos) throws BizException;
    
    /**
	*  人员职务数据插入保存
	*/
	public abstract NmNurDutyDO[] insert(NmNurDutyDO[] aggdos) throws BizException;
	
    /**
	*  人员职务数据保存
	*/
	public abstract NmNurDutyDO[] save(NmNurDutyDO[] aggdos) throws BizException;
	
    /**
	*  人员职务数据更新
	*/
	public abstract NmNurDutyDO[] update(NmNurDutyDO[] aggdos) throws BizException;
	
	/**
	*  人员职务数据逻辑删除
	*/
	public abstract void logicDelete(NmNurDutyDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurDutyDO[] enableWithoutFilter(NmNurDutyDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurDutyDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurDutyDO[] disableVOWithoutFilter(NmNurDutyDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurDutyDO[] dos) throws BizException ;
}
