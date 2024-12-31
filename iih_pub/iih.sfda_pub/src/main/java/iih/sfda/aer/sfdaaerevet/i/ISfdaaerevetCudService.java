package iih.sfda.aer.sfdaaerevet.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevet.d.SfdaAerEvEtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 不良报告_跟踪数据维护服务
*/
public interface ISfdaaerevetCudService {
	/**
	*  不良报告_跟踪数据真删除
	*/
    public abstract void delete(SfdaAerEvEtDO[] aggdos) throws BizException;
    
    /**
	*  不良报告_跟踪数据插入保存
	*/
	public abstract SfdaAerEvEtDO[] insert(SfdaAerEvEtDO[] aggdos) throws BizException;
	
    /**
	*  不良报告_跟踪数据保存
	*/
	public abstract SfdaAerEvEtDO[] save(SfdaAerEvEtDO[] aggdos) throws BizException;
	
    /**
	*  不良报告_跟踪数据更新
	*/
	public abstract SfdaAerEvEtDO[] update(SfdaAerEvEtDO[] aggdos) throws BizException;
	
	/**
	*  不良报告_跟踪数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvEtDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvEtDO[] enableWithoutFilter(SfdaAerEvEtDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvEtDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvEtDO[] disableVOWithoutFilter(SfdaAerEvEtDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvEtDO[] dos) throws BizException ;
}
