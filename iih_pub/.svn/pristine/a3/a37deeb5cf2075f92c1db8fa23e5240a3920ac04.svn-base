package iih.mc.mc.monthaccflag.i;

import xap.mw.core.data.BizException;
import iih.mc.mc.monthaccflag.d.McMonthAccFlagDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 仓库月结标志数据维护服务
*/
public interface IMonthaccflagCudService {
	/**
	*  仓库月结标志数据真删除
	*/
    public abstract void delete(McMonthAccFlagDO[] aggdos) throws BizException;
    
    /**
	*  仓库月结标志数据插入保存
	*/
	public abstract McMonthAccFlagDO[] insert(McMonthAccFlagDO[] aggdos) throws BizException;
	
    /**
	*  仓库月结标志数据保存
	*/
	public abstract McMonthAccFlagDO[] save(McMonthAccFlagDO[] aggdos) throws BizException;
	
    /**
	*  仓库月结标志数据更新
	*/
	public abstract McMonthAccFlagDO[] update(McMonthAccFlagDO[] aggdos) throws BizException;
	
	/**
	*  仓库月结标志数据逻辑删除
	*/
	public abstract void logicDelete(McMonthAccFlagDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public McMonthAccFlagDO[] enableWithoutFilter(McMonthAccFlagDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(McMonthAccFlagDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public McMonthAccFlagDO[] disableVOWithoutFilter(McMonthAccFlagDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(McMonthAccFlagDO[] dos) throws BizException ;
}
