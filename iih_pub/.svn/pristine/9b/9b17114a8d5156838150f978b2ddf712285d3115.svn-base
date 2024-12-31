package iih.bd.srv.diagdef.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.diagdef.d.DiagCompDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务_疾病诊断定义数据维护服务
*/
public interface IDiagCompDOCudService {
	/**
	*  医疗服务_疾病诊断定义数据真删除
	*/
    public abstract void delete(DiagCompDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务_疾病诊断定义数据插入保存
	*/
	public abstract DiagCompDO[] insert(DiagCompDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_疾病诊断定义数据保存
	*/
	public abstract DiagCompDO[] save(DiagCompDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_疾病诊断定义数据更新
	*/
	public abstract DiagCompDO[] update(DiagCompDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务_疾病诊断定义数据逻辑删除
	*/
	public abstract void logicDelete(DiagCompDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DiagCompDO[] enableWithoutFilter(DiagCompDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DiagCompDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DiagCompDO[] disableVOWithoutFilter(DiagCompDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DiagCompDO[] aggdos) throws BizException ;
	
}
