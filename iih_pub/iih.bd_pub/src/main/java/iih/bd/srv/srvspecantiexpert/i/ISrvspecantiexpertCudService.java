package iih.bd.srv.srvspecantiexpert.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvspecantiexpert.d.SrvSpecAntiExpertDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗服务_特殊使用级抗菌药专家数据维护服务
*/
public interface ISrvspecantiexpertCudService {
	/**
	*  医疗服务_特殊使用级抗菌药专家数据真删除
	*/
    public abstract void delete(SrvSpecAntiExpertDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务_特殊使用级抗菌药专家数据插入保存
	*/
	public abstract SrvSpecAntiExpertDO[] insert(SrvSpecAntiExpertDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_特殊使用级抗菌药专家数据保存
	*/
	public abstract SrvSpecAntiExpertDO[] save(SrvSpecAntiExpertDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_特殊使用级抗菌药专家数据更新
	*/
	public abstract SrvSpecAntiExpertDO[] update(SrvSpecAntiExpertDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务_特殊使用级抗菌药专家数据逻辑删除
	*/
	public abstract void logicDelete(SrvSpecAntiExpertDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SrvSpecAntiExpertDO[] enableWithoutFilter(SrvSpecAntiExpertDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SrvSpecAntiExpertDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SrvSpecAntiExpertDO[] disableVOWithoutFilter(SrvSpecAntiExpertDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SrvSpecAntiExpertDO[] dos) throws BizException ;
}
