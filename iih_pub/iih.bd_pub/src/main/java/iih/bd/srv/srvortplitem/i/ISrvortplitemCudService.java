package iih.bd.srv.srvortplitem.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvortplitem.d.SrvOrTplItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗服务_医嘱模板项目数据维护服务
*/
public interface ISrvortplitemCudService {
	/**
	*  医疗服务_医嘱模板项目数据删除
	*/
    public abstract void delete(SrvOrTplItemDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务_医嘱模板项目数据插入保存
	*/
	public abstract SrvOrTplItemDO[] insert(SrvOrTplItemDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_医嘱模板项目数据保存
	*/
	public abstract SrvOrTplItemDO[] save(SrvOrTplItemDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_医嘱模板项目数据更新
	*/
	public abstract SrvOrTplItemDO[] update(SrvOrTplItemDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务_医嘱模板项目数据真删
	*/
	public abstract void logicDelete(SrvOrTplItemDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvOrTplItemDO[] enableWithoutFilter(SrvOrTplItemDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvOrTplItemDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvOrTplItemDO[] disableVOWithoutFilter(SrvOrTplItemDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvOrTplItemDO[] dos) throws BizException ;
}
