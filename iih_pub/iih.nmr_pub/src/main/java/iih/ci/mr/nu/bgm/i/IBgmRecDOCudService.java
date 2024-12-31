package iih.ci.mr.nu.bgm.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.bgm.d.BgmRecDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 血糖监测表数据维护服务
*/
public interface IBgmRecDOCudService {
	/**
	*  血糖监测表数据真删除
	*/
    public abstract void delete(BgmRecDO[] aggdos) throws BizException;
    
    /**
	*  血糖监测表数据插入保存
	*/
	public abstract BgmRecDO[] insert(BgmRecDO[] aggdos) throws BizException;
	
    /**
	*  血糖监测表数据保存
	*/
	public abstract BgmRecDO[] save(BgmRecDO[] aggdos) throws BizException;
	
    /**
	*  血糖监测表数据更新
	*/
	public abstract BgmRecDO[] update(BgmRecDO[] aggdos) throws BizException;
	
	/**
	*  血糖监测表数据逻辑删除
	*/
	public abstract void logicDelete(BgmRecDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BgmRecDO[] enableWithoutFilter(BgmRecDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BgmRecDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BgmRecDO[] disableVOWithoutFilter(BgmRecDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BgmRecDO[] aggdos) throws BizException ;
	
}
