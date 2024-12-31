package iih.sfda.aer.sfdaaerevfst.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevfst.d.SfdaAerEvFstDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 未按医嘱执行禁食禁水事件数据维护服务
*/
public interface ISfdaaerevfstCudService {
	/**
	*  未按医嘱执行禁食禁水事件数据真删除
	*/
    public abstract void delete(SfdaAerEvFstDO[] aggdos) throws BizException;
    
    /**
	*  未按医嘱执行禁食禁水事件数据插入保存
	*/
	public abstract SfdaAerEvFstDO[] insert(SfdaAerEvFstDO[] aggdos) throws BizException;
	
    /**
	*  未按医嘱执行禁食禁水事件数据保存
	*/
	public abstract SfdaAerEvFstDO[] save(SfdaAerEvFstDO[] aggdos) throws BizException;
	
    /**
	*  未按医嘱执行禁食禁水事件数据更新
	*/
	public abstract SfdaAerEvFstDO[] update(SfdaAerEvFstDO[] aggdos) throws BizException;
	
	/**
	*  未按医嘱执行禁食禁水事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvFstDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvFstDO[] enableWithoutFilter(SfdaAerEvFstDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvFstDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvFstDO[] disableVOWithoutFilter(SfdaAerEvFstDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvFstDO[] dos) throws BizException ;
}
