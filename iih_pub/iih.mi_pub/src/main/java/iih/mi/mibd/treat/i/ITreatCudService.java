package iih.mi.mibd.treat.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.treat.d.TreatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
 * 医保平台_诊疗项目数据维护服务
 *
 *@author hexx
 */
public interface ITreatCudService {
	/**
	*  医保平台_诊疗项目数据真删除
	*/
    public abstract void delete(TreatDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_诊疗项目数据插入保存
	*/
	public abstract TreatDO[] insert(TreatDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_诊疗项目数据保存
	*/
	public abstract TreatDO[] save(TreatDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_诊疗项目数据更新
	*/
	public abstract TreatDO[] update(TreatDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_诊疗项目数据逻辑删除
	*/
	public abstract void logicDelete(TreatDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TreatDO[] enableWithoutFilter(TreatDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TreatDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TreatDO[] disableVOWithoutFilter(TreatDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TreatDO[] dos) throws BizException ;
}
