package iih.nm.nhr.nmnhrschedlv.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员请假申请数据维护服务
*/
public interface INmnhrschedlvCudService {
	/**
	*  人员请假申请数据真删除
	*/
    public abstract void delete(NmNhrSchedLvDO[] aggdos) throws BizException;
    
    /**
	*  人员请假申请数据插入保存
	*/
	public abstract NmNhrSchedLvDO[] insert(NmNhrSchedLvDO[] aggdos) throws BizException;
	
    /**
	*  人员请假申请数据保存
	*/
	public abstract NmNhrSchedLvDO[] save(NmNhrSchedLvDO[] aggdos) throws BizException;
	
    /**
	*  人员请假申请数据更新
	*/
	public abstract NmNhrSchedLvDO[] update(NmNhrSchedLvDO[] aggdos) throws BizException;
	
	/**
	*  人员请假申请数据逻辑删除
	*/
	public abstract void logicDelete(NmNhrSchedLvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNhrSchedLvDO[] enableWithoutFilter(NmNhrSchedLvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNhrSchedLvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNhrSchedLvDO[] disableVOWithoutFilter(NmNhrSchedLvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNhrSchedLvDO[] dos) throws BizException ;
}
