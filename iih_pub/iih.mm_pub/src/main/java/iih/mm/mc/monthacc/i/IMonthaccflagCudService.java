package iih.mm.mc.monthacc.i;

import xap.mw.core.data.BizException;
import iih.mm.mc.monthacc.d.MonthAccFlagDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 仓库月结标志数据维护服务
*/
public interface IMonthaccflagCudService {
	/**
	*  仓库月结标志数据删除
	*/
    public abstract void logicDelete(MonthAccFlagDO[] aggdos) throws BizException;
    
    /**
	*  仓库月结标志数据插入保存
	*/
	public abstract MonthAccFlagDO[] insert(MonthAccFlagDO[] aggdos) throws BizException;
	
    /**
	*  仓库月结标志数据保存
	*/
	public abstract MonthAccFlagDO[] save(MonthAccFlagDO[] aggdos) throws BizException;
	
    /**
	*  仓库月结标志数据更新
	*/
	public abstract MonthAccFlagDO[] update(MonthAccFlagDO[] aggdos) throws BizException;
	
	/**
	*  仓库月结标志数据真删
	*/
	public abstract void delete(MonthAccFlagDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MonthAccFlagDO[] enableWithoutFilter(MonthAccFlagDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MonthAccFlagDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MonthAccFlagDO[] disableVOWithoutFilter(MonthAccFlagDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MonthAccFlagDO[] dos) throws BizException ;
}
