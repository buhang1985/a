package iih.nm.nhr.nmnurcert.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurcert.d.NmNurCertDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员证书数据维护服务
*/
public interface INmnurcertCudService {
	/**
	*  人员证书数据真删除
	*/
    public abstract void delete(NmNurCertDO[] aggdos) throws BizException;
    
    /**
	*  人员证书数据插入保存
	*/
	public abstract NmNurCertDO[] insert(NmNurCertDO[] aggdos) throws BizException;
	
    /**
	*  人员证书数据保存
	*/
	public abstract NmNurCertDO[] save(NmNurCertDO[] aggdos) throws BizException;
	
    /**
	*  人员证书数据更新
	*/
	public abstract NmNurCertDO[] update(NmNurCertDO[] aggdos) throws BizException;
	
	/**
	*  人员证书数据逻辑删除
	*/
	public abstract void logicDelete(NmNurCertDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurCertDO[] enableWithoutFilter(NmNurCertDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurCertDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurCertDO[] disableVOWithoutFilter(NmNurCertDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurCertDO[] dos) throws BizException ;
}
