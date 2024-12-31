package iih.bd.mhi.hpsrvselfpayfree.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpsrvselfpayfree.d.HpSrvSelfPayFreeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划自付部分减免数据维护服务
*/
public interface IHpsrvselfpayfreeCudService {
	/**
	*  医保计划自付部分减免数据真删除
	*/
    public abstract void delete(HpSrvSelfPayFreeDO[] aggdos) throws BizException;
    
    /**
	*  医保计划自付部分减免数据插入保存
	*/
	public abstract HpSrvSelfPayFreeDO[] insert(HpSrvSelfPayFreeDO[] aggdos) throws BizException;
	
    /**
	*  医保计划自付部分减免数据保存
	*/
	public abstract HpSrvSelfPayFreeDO[] save(HpSrvSelfPayFreeDO[] aggdos) throws BizException;
	
    /**
	*  医保计划自付部分减免数据更新
	*/
	public abstract HpSrvSelfPayFreeDO[] update(HpSrvSelfPayFreeDO[] aggdos) throws BizException;
	
	/**
	*  医保计划自付部分减免数据逻辑删除
	*/
	public abstract void logicDelete(HpSrvSelfPayFreeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpSrvSelfPayFreeDO[] enableWithoutFilter(HpSrvSelfPayFreeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpSrvSelfPayFreeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpSrvSelfPayFreeDO[] disableVOWithoutFilter(HpSrvSelfPayFreeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpSrvSelfPayFreeDO[] dos) throws BizException ;
}
