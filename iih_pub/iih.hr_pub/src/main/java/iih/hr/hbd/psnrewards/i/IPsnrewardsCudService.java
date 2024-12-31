package iih.hr.hbd.psnrewards.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psnrewards.d.HbdPsnRewardsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员奖惩数据维护服务
*/
public interface IPsnrewardsCudService {
	/**
	*  人员奖惩数据真删除
	*/
    public abstract void delete(HbdPsnRewardsDO[] aggdos) throws BizException;
    
    /**
	*  人员奖惩数据插入保存
	*/
	public abstract HbdPsnRewardsDO[] insert(HbdPsnRewardsDO[] aggdos) throws BizException;
	
    /**
	*  人员奖惩数据保存
	*/
	public abstract HbdPsnRewardsDO[] save(HbdPsnRewardsDO[] aggdos) throws BizException;
	
    /**
	*  人员奖惩数据更新
	*/
	public abstract HbdPsnRewardsDO[] update(HbdPsnRewardsDO[] aggdos) throws BizException;
	
	/**
	*  人员奖惩数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnRewardsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnRewardsDO[] enableWithoutFilter(HbdPsnRewardsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnRewardsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnRewardsDO[] disableVOWithoutFilter(HbdPsnRewardsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnRewardsDO[] dos) throws BizException ;
}
