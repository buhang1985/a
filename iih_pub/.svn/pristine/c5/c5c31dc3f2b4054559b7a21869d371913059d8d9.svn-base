package iih.sfda.aer.sfdaaerevsug.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevsug.d.SfdaAerEvSugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 手术事件数据维护服务
*/
public interface ISfdaaerevsugCudService {
	/**
	*  手术事件数据真删除
	*/
    public abstract void delete(SfdaAerEvSugDO[] aggdos) throws BizException;
    
    /**
	*  手术事件数据插入保存
	*/
	public abstract SfdaAerEvSugDO[] insert(SfdaAerEvSugDO[] aggdos) throws BizException;
	
    /**
	*  手术事件数据保存
	*/
	public abstract SfdaAerEvSugDO[] save(SfdaAerEvSugDO[] aggdos) throws BizException;
	
    /**
	*  手术事件数据更新
	*/
	public abstract SfdaAerEvSugDO[] update(SfdaAerEvSugDO[] aggdos) throws BizException;
	
	/**
	*  手术事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvSugDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvSugDO[] enableWithoutFilter(SfdaAerEvSugDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvSugDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvSugDO[] disableVOWithoutFilter(SfdaAerEvSugDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvSugDO[] dos) throws BizException ;
}
