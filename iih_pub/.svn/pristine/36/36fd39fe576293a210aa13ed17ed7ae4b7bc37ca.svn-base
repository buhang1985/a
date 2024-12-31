package iih.sfda.aer.sfdaaerevmcomplain.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmcomplain.d.SfdaAerEvMcomplainDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗投诉事件数据维护服务
*/
public interface ISfdaaerevmcomplainCudService {
	/**
	*  医疗投诉事件数据真删除
	*/
    public abstract void delete(SfdaAerEvMcomplainDO[] aggdos) throws BizException;
    
    /**
	*  医疗投诉事件数据插入保存
	*/
	public abstract SfdaAerEvMcomplainDO[] insert(SfdaAerEvMcomplainDO[] aggdos) throws BizException;
	
    /**
	*  医疗投诉事件数据保存
	*/
	public abstract SfdaAerEvMcomplainDO[] save(SfdaAerEvMcomplainDO[] aggdos) throws BizException;
	
    /**
	*  医疗投诉事件数据更新
	*/
	public abstract SfdaAerEvMcomplainDO[] update(SfdaAerEvMcomplainDO[] aggdos) throws BizException;
	
	/**
	*  医疗投诉事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMcomplainDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMcomplainDO[] enableWithoutFilter(SfdaAerEvMcomplainDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMcomplainDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMcomplainDO[] disableVOWithoutFilter(SfdaAerEvMcomplainDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMcomplainDO[] dos) throws BizException ;
}
