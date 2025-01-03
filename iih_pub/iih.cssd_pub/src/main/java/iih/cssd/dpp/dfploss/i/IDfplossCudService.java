package iih.cssd.dpp.dfploss.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpp.dfploss.d.DfpLossDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 消毒包损失登记数据维护服务
*/
public interface IDfplossCudService {
	/**
	*  消毒包损失登记数据真删除
	*/
    public abstract void delete(DfpLossDO[] aggdos) throws BizException;
    
    /**
	*  消毒包损失登记数据插入保存
	*/
	public abstract DfpLossDO[] insert(DfpLossDO[] aggdos) throws BizException;
	
    /**
	*  消毒包损失登记数据保存
	*/
	public abstract DfpLossDO[] save(DfpLossDO[] aggdos) throws BizException;
	
    /**
	*  消毒包损失登记数据更新
	*/
	public abstract DfpLossDO[] update(DfpLossDO[] aggdos) throws BizException;
	
	/**
	*  消毒包损失登记数据逻辑删除
	*/
	public abstract void logicDelete(DfpLossDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpLossDO[] enableWithoutFilter(DfpLossDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpLossDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpLossDO[] disableVOWithoutFilter(DfpLossDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpLossDO[] dos) throws BizException ;
}
