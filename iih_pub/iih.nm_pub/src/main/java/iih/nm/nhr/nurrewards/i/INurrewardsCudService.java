package iih.nm.nhr.nurrewards.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nurrewards.d.NmNurRewardsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员奖惩数据维护服务
*/
public interface INurrewardsCudService {
	/**
	*  人员奖惩数据真删除
	*/
    public abstract void delete(NmNurRewardsDO[] aggdos) throws BizException;
    
    /**
	*  人员奖惩数据插入保存
	*/
	public abstract NmNurRewardsDO[] insert(NmNurRewardsDO[] aggdos) throws BizException;
	
    /**
	*  人员奖惩数据保存
	*/
	public abstract NmNurRewardsDO[] save(NmNurRewardsDO[] aggdos) throws BizException;
	
    /**
	*  人员奖惩数据更新
	*/
	public abstract NmNurRewardsDO[] update(NmNurRewardsDO[] aggdos) throws BizException;
	
	/**
	*  人员奖惩数据逻辑删除
	*/
	public abstract void logicDelete(NmNurRewardsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurRewardsDO[] enableWithoutFilter(NmNurRewardsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurRewardsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurRewardsDO[] disableVOWithoutFilter(NmNurRewardsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurRewardsDO[] dos) throws BizException ;
}
