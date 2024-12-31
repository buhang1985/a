package iih.nm.nca.nmncatmpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nca.nmncatmpl.d.NmNcaTmplItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 满意度问卷模板数据维护服务
*/
public interface INmNcaTmplItmDOCudService {
	/**
	*  满意度问卷模板数据真删除
	*/
    public abstract void delete(NmNcaTmplItmDO[] aggdos) throws BizException;
    
    /**
	*  满意度问卷模板数据插入保存
	*/
	public abstract NmNcaTmplItmDO[] insert(NmNcaTmplItmDO[] aggdos) throws BizException;
	
    /**
	*  满意度问卷模板数据保存
	*/
	public abstract NmNcaTmplItmDO[] save(NmNcaTmplItmDO[] aggdos) throws BizException;
	
    /**
	*  满意度问卷模板数据更新
	*/
	public abstract NmNcaTmplItmDO[] update(NmNcaTmplItmDO[] aggdos) throws BizException;
	
	/**
	*  满意度问卷模板数据逻辑删除
	*/
	public abstract void logicDelete(NmNcaTmplItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNcaTmplItmDO[] enableWithoutFilter(NmNcaTmplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNcaTmplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNcaTmplItmDO[] disableVOWithoutFilter(NmNcaTmplItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNcaTmplItmDO[] aggdos) throws BizException ;
	
}
