package iih.ci.ord.bloodbadreaction.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 输血不良反应回报单数据维护服务
*/
public interface ICibloodadversereactionCudService {
	/**
	*  输血不良反应回报单数据真删除
	*/
    public abstract void delete(CiBloodAdverseReactionDO[] aggdos) throws BizException;
    
    /**
	*  输血不良反应回报单数据插入保存
	*/
	public abstract CiBloodAdverseReactionDO[] insert(CiBloodAdverseReactionDO[] aggdos) throws BizException;
	
    /**
	*  输血不良反应回报单数据保存
	*/
	public abstract CiBloodAdverseReactionDO[] save(CiBloodAdverseReactionDO[] aggdos) throws BizException;
	
    /**
	*  输血不良反应回报单数据更新
	*/
	public abstract CiBloodAdverseReactionDO[] update(CiBloodAdverseReactionDO[] aggdos) throws BizException;
	
	/**
	*  输血不良反应回报单数据逻辑删除
	*/
	public abstract void logicDelete(CiBloodAdverseReactionDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiBloodAdverseReactionDO[] enableWithoutFilter(CiBloodAdverseReactionDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiBloodAdverseReactionDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiBloodAdverseReactionDO[] disableVOWithoutFilter(CiBloodAdverseReactionDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiBloodAdverseReactionDO[] dos) throws BizException ;
}
