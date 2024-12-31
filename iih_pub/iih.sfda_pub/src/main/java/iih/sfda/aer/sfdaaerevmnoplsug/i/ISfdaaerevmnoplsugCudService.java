package iih.sfda.aer.sfdaaerevmnoplsug.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmnoplsug.d.SfdaAerEvMnoplsugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 非计划再次手术数据维护服务
*/
public interface ISfdaaerevmnoplsugCudService {
	/**
	*  非计划再次手术数据真删除
	*/
    public abstract void delete(SfdaAerEvMnoplsugDO[] aggdos) throws BizException;
    
    /**
	*  非计划再次手术数据插入保存
	*/
	public abstract SfdaAerEvMnoplsugDO[] insert(SfdaAerEvMnoplsugDO[] aggdos) throws BizException;
	
    /**
	*  非计划再次手术数据保存
	*/
	public abstract SfdaAerEvMnoplsugDO[] save(SfdaAerEvMnoplsugDO[] aggdos) throws BizException;
	
    /**
	*  非计划再次手术数据更新
	*/
	public abstract SfdaAerEvMnoplsugDO[] update(SfdaAerEvMnoplsugDO[] aggdos) throws BizException;
	
	/**
	*  非计划再次手术数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMnoplsugDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMnoplsugDO[] enableWithoutFilter(SfdaAerEvMnoplsugDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMnoplsugDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMnoplsugDO[] disableVOWithoutFilter(SfdaAerEvMnoplsugDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMnoplsugDO[] dos) throws BizException ;
}
