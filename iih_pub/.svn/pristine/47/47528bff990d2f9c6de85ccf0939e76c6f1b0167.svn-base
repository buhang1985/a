package iih.sfda.aer.sfdaaerevfeedback.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevfeedback.d.SfdaAerEvFeedBackDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 不良上报反馈数据维护服务
*/
public interface ISfdaaerevfeedbackCudService {
	/**
	*  不良上报反馈数据真删除
	*/
    public abstract void delete(SfdaAerEvFeedBackDO[] aggdos) throws BizException;
    
    /**
	*  不良上报反馈数据插入保存
	*/
	public abstract SfdaAerEvFeedBackDO[] insert(SfdaAerEvFeedBackDO[] aggdos) throws BizException;
	
    /**
	*  不良上报反馈数据保存
	*/
	public abstract SfdaAerEvFeedBackDO[] save(SfdaAerEvFeedBackDO[] aggdos) throws BizException;
	
    /**
	*  不良上报反馈数据更新
	*/
	public abstract SfdaAerEvFeedBackDO[] update(SfdaAerEvFeedBackDO[] aggdos) throws BizException;
	
	/**
	*  不良上报反馈数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvFeedBackDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvFeedBackDO[] enableWithoutFilter(SfdaAerEvFeedBackDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvFeedBackDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvFeedBackDO[] disableVOWithoutFilter(SfdaAerEvFeedBackDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvFeedBackDO[] dos) throws BizException ;
}
