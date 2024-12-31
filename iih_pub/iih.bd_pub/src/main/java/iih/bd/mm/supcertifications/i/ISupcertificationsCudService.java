package iih.bd.mm.supcertifications.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.supcertifications.d.SupCertifiDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 供应商厂商资质证书数据维护服务
*/
public interface ISupcertificationsCudService {
	/**
	*  供应商厂商资质证书数据真删除
	*/
    public abstract void delete(SupCertifiDO[] aggdos) throws BizException;
    
    /**
	*  供应商厂商资质证书数据插入保存
	*/
	public abstract SupCertifiDO[] insert(SupCertifiDO[] aggdos) throws BizException;
	
    /**
	*  供应商厂商资质证书数据保存
	*/
	public abstract SupCertifiDO[] save(SupCertifiDO[] aggdos) throws BizException;
	
    /**
	*  供应商厂商资质证书数据更新
	*/
	public abstract SupCertifiDO[] update(SupCertifiDO[] aggdos) throws BizException;
	
	/**
	*  供应商厂商资质证书数据逻辑删除
	*/
	public abstract void logicDelete(SupCertifiDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SupCertifiDO[] enableWithoutFilter(SupCertifiDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SupCertifiDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SupCertifiDO[] disableVOWithoutFilter(SupCertifiDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SupCertifiDO[] dos) throws BizException ;
}
