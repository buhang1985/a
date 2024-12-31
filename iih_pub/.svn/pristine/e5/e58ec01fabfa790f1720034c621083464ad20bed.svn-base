package iih.bd.mm.certi.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.certi.d.CertificationDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗物品_资质证书字典数据维护服务
*/
public interface ICertiCudService {
	/**
	*  医疗物品_资质证书字典数据真删除
	*/
    public abstract void delete(CertificationDO[] aggdos) throws BizException;
    
    /**
	*  医疗物品_资质证书字典数据插入保存
	*/
	public abstract CertificationDO[] insert(CertificationDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_资质证书字典数据保存
	*/
	public abstract CertificationDO[] save(CertificationDO[] aggdos) throws BizException;
	
    /**
	*  医疗物品_资质证书字典数据更新
	*/
	public abstract CertificationDO[] update(CertificationDO[] aggdos) throws BizException;
	
	/**
	*  医疗物品_资质证书字典数据逻辑删除
	*/
	public abstract void logicDelete(CertificationDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CertificationDO[] enableWithoutFilter(CertificationDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CertificationDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CertificationDO[] disableVOWithoutFilter(CertificationDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CertificationDO[] dos) throws BizException ;
}
