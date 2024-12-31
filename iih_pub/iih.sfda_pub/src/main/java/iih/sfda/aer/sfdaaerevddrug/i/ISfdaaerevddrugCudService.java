package iih.sfda.aer.sfdaaerevddrug.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevddrug.d.SfdaAerEvDdrugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药物不良反应事件数据维护服务
*/
public interface ISfdaaerevddrugCudService {
	/**
	*  药物不良反应事件数据真删除
	*/
    public abstract void delete(SfdaAerEvDdrugDO[] aggdos) throws BizException;
    
    /**
	*  药物不良反应事件数据插入保存
	*/
	public abstract SfdaAerEvDdrugDO[] insert(SfdaAerEvDdrugDO[] aggdos) throws BizException;
	
    /**
	*  药物不良反应事件数据保存
	*/
	public abstract SfdaAerEvDdrugDO[] save(SfdaAerEvDdrugDO[] aggdos) throws BizException;
	
    /**
	*  药物不良反应事件数据更新
	*/
	public abstract SfdaAerEvDdrugDO[] update(SfdaAerEvDdrugDO[] aggdos) throws BizException;
	
	/**
	*  药物不良反应事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvDdrugDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvDdrugDO[] enableWithoutFilter(SfdaAerEvDdrugDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvDdrugDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvDdrugDO[] disableVOWithoutFilter(SfdaAerEvDdrugDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvDdrugDO[] dos) throws BizException ;
}
