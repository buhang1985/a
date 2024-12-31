package iih.bd.fc.wf.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.wf.d.WfDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 流程配置_医嘱流向数据维护服务
*/
public interface IWfDepDOCudService {
	/**
	*  流程配置_医嘱流向数据真删除
	*/
    public abstract void delete(WfDepDO[] aggdos) throws BizException;
    
    /**
	*  流程配置_医嘱流向数据插入保存
	*/
	public abstract WfDepDO[] insert(WfDepDO[] aggdos) throws BizException;
	
    /**
	*  流程配置_医嘱流向数据保存
	*/
	public abstract WfDepDO[] save(WfDepDO[] aggdos) throws BizException;
	
    /**
	*  流程配置_医嘱流向数据更新
	*/
	public abstract WfDepDO[] update(WfDepDO[] aggdos) throws BizException;
	
	/**
	*  流程配置_医嘱流向数据逻辑删除
	*/
	public abstract void logicDelete(WfDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public WfDepDO[] enableWithoutFilter(WfDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(WfDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public WfDepDO[] disableVOWithoutFilter(WfDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(WfDepDO[] aggdos) throws BizException ;
	
}
