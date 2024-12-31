package iih.sfda.aer.sfdaaerevdadjust.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevdadjust.d.SfdaAerEvDadjustDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药物调剂错误(药剂师)数据维护服务
*/
public interface ISfdaaerevdadjustCudService {
	/**
	*  药物调剂错误(药剂师)数据真删除
	*/
    public abstract void delete(SfdaAerEvDadjustDO[] aggdos) throws BizException;
    
    /**
	*  药物调剂错误(药剂师)数据插入保存
	*/
	public abstract SfdaAerEvDadjustDO[] insert(SfdaAerEvDadjustDO[] aggdos) throws BizException;
	
    /**
	*  药物调剂错误(药剂师)数据保存
	*/
	public abstract SfdaAerEvDadjustDO[] save(SfdaAerEvDadjustDO[] aggdos) throws BizException;
	
    /**
	*  药物调剂错误(药剂师)数据更新
	*/
	public abstract SfdaAerEvDadjustDO[] update(SfdaAerEvDadjustDO[] aggdos) throws BizException;
	
	/**
	*  药物调剂错误(药剂师)数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvDadjustDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvDadjustDO[] enableWithoutFilter(SfdaAerEvDadjustDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvDadjustDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvDadjustDO[] disableVOWithoutFilter(SfdaAerEvDadjustDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvDadjustDO[] dos) throws BizException ;
}
