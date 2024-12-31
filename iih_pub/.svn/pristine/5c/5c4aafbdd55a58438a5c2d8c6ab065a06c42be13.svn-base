package iih.nm.nit.psninfo.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.psninfo.d.NitPsnInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 实习生基本信息数据维护服务
*/
public interface IPsninfoCudService {
	/**
	*  实习生基本信息数据真删除
	*/
    public abstract void delete(NitPsnInfoDO[] aggdos) throws BizException;
    
    /**
	*  实习生基本信息数据插入保存
	*/
	public abstract NitPsnInfoDO[] insert(NitPsnInfoDO[] aggdos) throws BizException;
	
    /**
	*  实习生基本信息数据保存
	*/
	public abstract NitPsnInfoDO[] save(NitPsnInfoDO[] aggdos) throws BizException;
	
    /**
	*  实习生基本信息数据更新
	*/
	public abstract NitPsnInfoDO[] update(NitPsnInfoDO[] aggdos) throws BizException;
	
	/**
	*  实习生基本信息数据逻辑删除
	*/
	public abstract void logicDelete(NitPsnInfoDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NitPsnInfoDO[] enableWithoutFilter(NitPsnInfoDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NitPsnInfoDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NitPsnInfoDO[] disableVOWithoutFilter(NitPsnInfoDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NitPsnInfoDO[] dos) throws BizException ;
}
