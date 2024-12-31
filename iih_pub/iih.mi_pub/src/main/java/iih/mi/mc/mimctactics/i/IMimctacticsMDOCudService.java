package iih.mi.mc.mimctactics.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimctactics.d.MiMcTacticsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医保策略库数据维护服务
*/
public interface IMimctacticsMDOCudService {
	/**
	*  医保策略库数据真删除
	*/
    public abstract void delete(MiMcTacticsDO[] aggdos) throws BizException;
    
    /**
	*  医保策略库数据插入保存
	*/
	public abstract MiMcTacticsDO[] insert(MiMcTacticsDO[] aggdos) throws BizException;
	
    /**
	*  医保策略库数据保存
	*/
	public abstract MiMcTacticsDO[] save(MiMcTacticsDO[] aggdos) throws BizException;
	
    /**
	*  医保策略库数据更新
	*/
	public abstract MiMcTacticsDO[] update(MiMcTacticsDO[] aggdos) throws BizException;
	
	/**
	*  医保策略库数据逻辑删除
	*/
	public abstract void logicDelete(MiMcTacticsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcTacticsDO[] enableWithoutFilter(MiMcTacticsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcTacticsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcTacticsDO[] disableVOWithoutFilter(MiMcTacticsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcTacticsDO[] aggdos) throws BizException ;
	
}
