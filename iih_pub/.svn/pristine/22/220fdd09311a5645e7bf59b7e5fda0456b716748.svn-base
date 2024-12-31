package iih.ci.ord.cons.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cons.d.CiConsActInviteDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 会诊申请单数据维护服务
*/
public interface ICiConsActInviteDOCudService {
	/**
	*  会诊申请单数据真删除
	*/
    public abstract void delete(CiConsActInviteDO[] aggdos) throws BizException;
    
    /**
	*  会诊申请单数据插入保存
	*/
	public abstract CiConsActInviteDO[] insert(CiConsActInviteDO[] aggdos) throws BizException;
	
    /**
	*  会诊申请单数据保存
	*/
	public abstract CiConsActInviteDO[] save(CiConsActInviteDO[] aggdos) throws BizException;
	
    /**
	*  会诊申请单数据更新
	*/
	public abstract CiConsActInviteDO[] update(CiConsActInviteDO[] aggdos) throws BizException;
	
	/**
	*  会诊申请单数据逻辑删除
	*/
	public abstract void logicDelete(CiConsActInviteDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiConsActInviteDO[] enableWithoutFilter(CiConsActInviteDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiConsActInviteDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiConsActInviteDO[] disableVOWithoutFilter(CiConsActInviteDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiConsActInviteDO[] aggdos) throws BizException ;
	
}
