package iih.mi.mibd.patca.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.patca.d.PatcaDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_患者身份数据维护服务
*/
public interface IPatcaCudService {
	/**
	*  医保平台_患者身份数据真删除
	*/
    public abstract void delete(PatcaDo[] aggdos) throws BizException;
    
    /**
	*  医保平台_患者身份数据插入保存
	*/
	public abstract PatcaDo[] insert(PatcaDo[] aggdos) throws BizException;
	
    /**
	*  医保平台_患者身份数据保存
	*/
	public abstract PatcaDo[] save(PatcaDo[] aggdos) throws BizException;
	
    /**
	*  医保平台_患者身份数据更新
	*/
	public abstract PatcaDo[] update(PatcaDo[] aggdos) throws BizException;
	
	/**
	*  医保平台_患者身份数据逻辑删除
	*/
	public abstract void logicDelete(PatcaDo[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PatcaDo[] enableWithoutFilter(PatcaDo[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PatcaDo[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PatcaDo[] disableVOWithoutFilter(PatcaDo[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PatcaDo[] dos) throws BizException ;
}
