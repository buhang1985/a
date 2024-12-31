package iih.bd.srv.emrterm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历辅助录入病历事件数据维护服务
*/
public interface IEmrevent4termCudService {
	/**
	*  病历辅助录入病历事件数据真删除
	*/
    public abstract void delete(EmrEvent4TermDO[] aggdos) throws BizException;
    
    /**
	*  病历辅助录入病历事件数据插入保存
	*/
	public abstract EmrEvent4TermDO[] insert(EmrEvent4TermDO[] aggdos) throws BizException;
	
    /**
	*  病历辅助录入病历事件数据保存
	*/
	public abstract EmrEvent4TermDO[] save(EmrEvent4TermDO[] aggdos) throws BizException;
	
    /**
	*  病历辅助录入病历事件数据更新
	*/
	public abstract EmrEvent4TermDO[] update(EmrEvent4TermDO[] aggdos) throws BizException;
	
	/**
	*  病历辅助录入病历事件数据逻辑删除
	*/
	public abstract void logicDelete(EmrEvent4TermDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmrEvent4TermDO[] enableWithoutFilter(EmrEvent4TermDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmrEvent4TermDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmrEvent4TermDO[] disableVOWithoutFilter(EmrEvent4TermDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmrEvent4TermDO[] dos) throws BizException ;
}
