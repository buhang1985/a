package iih.nm.nom.nomnurplsm.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomnurplsm.d.NomNurPlSmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护士长计划与总结数据维护服务
*/
public interface INomnurplsmCudService {
	/**
	*  护士长计划与总结数据真删除
	*/
    public abstract void delete(NomNurPlSmDO[] aggdos) throws BizException;
    
    /**
	*  护士长计划与总结数据插入保存
	*/
	public abstract NomNurPlSmDO[] insert(NomNurPlSmDO[] aggdos) throws BizException;
	
    /**
	*  护士长计划与总结数据保存
	*/
	public abstract NomNurPlSmDO[] save(NomNurPlSmDO[] aggdos) throws BizException;
	
    /**
	*  护士长计划与总结数据更新
	*/
	public abstract NomNurPlSmDO[] update(NomNurPlSmDO[] aggdos) throws BizException;
	
	/**
	*  护士长计划与总结数据逻辑删除
	*/
	public abstract void logicDelete(NomNurPlSmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NomNurPlSmDO[] enableWithoutFilter(NomNurPlSmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NomNurPlSmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NomNurPlSmDO[] disableVOWithoutFilter(NomNurPlSmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NomNurPlSmDO[] dos) throws BizException ;
}
