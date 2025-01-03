package iih.mp.dg.mpdgprtconfig.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.mpdgprtconfig.d.MpdgPrtConfigDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药单打印配置数据维护服务
*/
public interface IMpdgprtconfigCudService {
	/**
	*  药单打印配置数据真删除
	*/
    public abstract void delete(MpdgPrtConfigDO[] aggdos) throws BizException;
    
    /**
	*  药单打印配置数据插入保存
	*/
	public abstract MpdgPrtConfigDO[] insert(MpdgPrtConfigDO[] aggdos) throws BizException;
	
    /**
	*  药单打印配置数据保存
	*/
	public abstract MpdgPrtConfigDO[] save(MpdgPrtConfigDO[] aggdos) throws BizException;
	
    /**
	*  药单打印配置数据更新
	*/
	public abstract MpdgPrtConfigDO[] update(MpdgPrtConfigDO[] aggdos) throws BizException;
	
	/**
	*  药单打印配置数据逻辑删除
	*/
	public abstract void logicDelete(MpdgPrtConfigDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpdgPrtConfigDO[] enableWithoutFilter(MpdgPrtConfigDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpdgPrtConfigDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpdgPrtConfigDO[] disableVOWithoutFilter(MpdgPrtConfigDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpdgPrtConfigDO[] dos) throws BizException ;
}
