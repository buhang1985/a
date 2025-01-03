package iih.bd.srv.srvortpl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvortpl.d.SrvOrdTplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗服务医嘱模板数据维护服务
*/
public interface ISrvortplMDOCudService {
	/**
	*  医疗服务医嘱模板数据删除
	*/
    public abstract void delete(SrvOrdTplDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务医嘱模板数据插入保存
	*/
	public abstract SrvOrdTplDO[] insert(SrvOrdTplDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务医嘱模板数据保存
	*/
	public abstract SrvOrdTplDO[] save(SrvOrdTplDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务医嘱模板数据更新
	*/
	public abstract SrvOrdTplDO[] update(SrvOrdTplDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务医嘱模板数据真删
	*/
	public abstract void logicDelete(SrvOrdTplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvOrdTplDO[] enableWithoutFilter(SrvOrdTplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvOrdTplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvOrdTplDO[] disableVOWithoutFilter(SrvOrdTplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvOrdTplDO[] aggdos) throws BizException ;
	
}
