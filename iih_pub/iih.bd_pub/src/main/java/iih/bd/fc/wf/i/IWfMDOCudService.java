package iih.bd.fc.wf.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.wf.d.WfDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 流程配置_医嘱流向数据维护服务
*/
public interface IWfMDOCudService {
	/**
	*  流程配置_医嘱流向数据真删除
	*/
    public abstract void delete(WfDO[] aggdos) throws BizException;
    
    /**
	*  流程配置_医嘱流向数据插入保存
	*/
	public abstract WfDO[] insert(WfDO[] aggdos) throws BizException;
	
    /**
	*  流程配置_医嘱流向数据保存
	*/
	public abstract WfDO[] save(WfDO[] aggdos) throws BizException;
	
    /**
	*  流程配置_医嘱流向数据更新
	*/
	public abstract WfDO[] update(WfDO[] aggdos) throws BizException;
	
	/**
	*  流程配置_医嘱流向数据逻辑删除
	*/
	public abstract void logicDelete(WfDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public WfDO[] enableWithoutFilter(WfDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(WfDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public WfDO[] disableVOWithoutFilter(WfDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(WfDO[] aggdos) throws BizException ;
	
}
