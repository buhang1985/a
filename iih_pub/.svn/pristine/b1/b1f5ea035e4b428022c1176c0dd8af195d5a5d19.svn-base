package iih.mi.mibd.medorglevel.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.medorglevel.d.MedOrgLevelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_医疗机构级别数据维护服务
*/
public interface IMedorglevelCudService {
	/**
	*  医保平台_医疗机构级别数据真删除
	*/
    public abstract void delete(MedOrgLevelDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_医疗机构级别数据插入保存
	*/
	public abstract MedOrgLevelDO[] insert(MedOrgLevelDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗机构级别数据保存
	*/
	public abstract MedOrgLevelDO[] save(MedOrgLevelDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗机构级别数据更新
	*/
	public abstract MedOrgLevelDO[] update(MedOrgLevelDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_医疗机构级别数据逻辑删除
	*/
	public abstract void logicDelete(MedOrgLevelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedOrgLevelDO[] enableWithoutFilter(MedOrgLevelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedOrgLevelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedOrgLevelDO[] disableVOWithoutFilter(MedOrgLevelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedOrgLevelDO[] dos) throws BizException ;
}
