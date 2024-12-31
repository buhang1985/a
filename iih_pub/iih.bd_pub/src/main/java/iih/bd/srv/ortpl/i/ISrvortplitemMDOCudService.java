package iih.bd.srv.ortpl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ortpl.d.OrTplItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医嘱模板项目数据维护服务
*/
public interface ISrvortplitemMDOCudService {
	/**
	*  医嘱模板项目数据真删除
	*/
    public abstract void delete(OrTplItmDO[] aggdos) throws BizException;
    
    /**
	*  医嘱模板项目数据插入保存
	*/
	public abstract OrTplItmDO[] insert(OrTplItmDO[] aggdos) throws BizException;
	
    /**
	*  医嘱模板项目数据保存
	*/
	public abstract OrTplItmDO[] save(OrTplItmDO[] aggdos) throws BizException;
	
    /**
	*  医嘱模板项目数据更新
	*/
	public abstract OrTplItmDO[] update(OrTplItmDO[] aggdos) throws BizException;
	
	/**
	*  医嘱模板项目数据逻辑删除
	*/
	public abstract void logicDelete(OrTplItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrTplItmDO[] enableWithoutFilter(OrTplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrTplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrTplItmDO[] disableVOWithoutFilter(OrTplItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrTplItmDO[] aggdos) throws BizException ;
	
}
