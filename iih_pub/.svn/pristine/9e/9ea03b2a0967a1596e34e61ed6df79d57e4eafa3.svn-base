package iih.bd.srv.mropgrouppower.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mropgrouppower.d.MrOpGroupPowerDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历业务组权限配置数据维护服务
*/
public interface IMropgrouppowerCudService {
	/**
	*  病历业务组权限配置数据真删除
	*/
    public abstract void delete(MrOpGroupPowerDO[] aggdos) throws BizException;
    
    /**
	*  病历业务组权限配置数据插入保存
	*/
	public abstract MrOpGroupPowerDO[] insert(MrOpGroupPowerDO[] aggdos) throws BizException;
	
    /**
	*  病历业务组权限配置数据保存
	*/
	public abstract MrOpGroupPowerDO[] save(MrOpGroupPowerDO[] aggdos) throws BizException;
	
    /**
	*  病历业务组权限配置数据更新
	*/
	public abstract MrOpGroupPowerDO[] update(MrOpGroupPowerDO[] aggdos) throws BizException;
	
	/**
	*  病历业务组权限配置数据逻辑删除
	*/
	public abstract void logicDelete(MrOpGroupPowerDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrOpGroupPowerDO[] enableWithoutFilter(MrOpGroupPowerDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrOpGroupPowerDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrOpGroupPowerDO[] disableVOWithoutFilter(MrOpGroupPowerDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrOpGroupPowerDO[] dos) throws BizException ;
}
