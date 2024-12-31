package iih.sfda.aer.sfdaaerevanalys.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevanalys.d.SfdaAerEvAnalysDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 分析报告数据维护服务
*/
public interface ISfdaaerevanalysCudService {
	/**
	*  分析报告数据真删除
	*/
    public abstract void delete(SfdaAerEvAnalysDO[] aggdos) throws BizException;
    
    /**
	*  分析报告数据插入保存
	*/
	public abstract SfdaAerEvAnalysDO[] insert(SfdaAerEvAnalysDO[] aggdos) throws BizException;
	
    /**
	*  分析报告数据保存
	*/
	public abstract SfdaAerEvAnalysDO[] save(SfdaAerEvAnalysDO[] aggdos) throws BizException;
	
    /**
	*  分析报告数据更新
	*/
	public abstract SfdaAerEvAnalysDO[] update(SfdaAerEvAnalysDO[] aggdos) throws BizException;
	
	/**
	*  分析报告数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvAnalysDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvAnalysDO[] enableWithoutFilter(SfdaAerEvAnalysDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvAnalysDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvAnalysDO[] disableVOWithoutFilter(SfdaAerEvAnalysDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvAnalysDO[] dos) throws BizException ;
}
