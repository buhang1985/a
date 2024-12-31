package iih.bd.srv.emrtpl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗记录模板数据维护服务
*/
public interface IEmrtplMDOCudService {
	/**
	*  医疗记录模板数据真删除
	*/
    public abstract void delete(EmrTplDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录模板数据插入保存
	*/
	public abstract EmrTplDO[] insert(EmrTplDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板数据保存
	*/
	public abstract EmrTplDO[] save(EmrTplDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板数据更新
	*/
	public abstract EmrTplDO[] update(EmrTplDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录模板数据逻辑删除
	*/
	public abstract void logicDelete(EmrTplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmrTplDO[] enableWithoutFilter(EmrTplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmrTplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmrTplDO[] disableVOWithoutFilter(EmrTplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmrTplDO[] aggdos) throws BizException ;
	
}
