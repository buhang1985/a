package iih.pe.phm.pehmfollowup.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmfollowup.d.PeHmFollowupRiskDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康管理随访记录数据维护服务
*/
public interface IPeHmFollowupRiskDOCudService {
	/**
	*  健康管理随访记录数据真删除
	*/
    public abstract void delete(PeHmFollowupRiskDO[] aggdos) throws BizException;
    
    /**
	*  健康管理随访记录数据插入保存
	*/
	public abstract PeHmFollowupRiskDO[] insert(PeHmFollowupRiskDO[] aggdos) throws BizException;
	
    /**
	*  健康管理随访记录数据保存
	*/
	public abstract PeHmFollowupRiskDO[] save(PeHmFollowupRiskDO[] aggdos) throws BizException;
	
    /**
	*  健康管理随访记录数据更新
	*/
	public abstract PeHmFollowupRiskDO[] update(PeHmFollowupRiskDO[] aggdos) throws BizException;
	
	/**
	*  健康管理随访记录数据逻辑删除
	*/
	public abstract void logicDelete(PeHmFollowupRiskDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeHmFollowupRiskDO[] enableWithoutFilter(PeHmFollowupRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeHmFollowupRiskDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeHmFollowupRiskDO[] disableVOWithoutFilter(PeHmFollowupRiskDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeHmFollowupRiskDO[] aggdos) throws BizException ;
	
}
