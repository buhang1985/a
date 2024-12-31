package iih.sfda.aer.sfdaaerevissu.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevissu.d.SfdaAerEvIssuMsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 不良报告_整改问题数据维护服务
*/
public interface ISfdaAerEvIssuMsDOCudService {
	/**
	*  不良报告_整改问题数据真删除
	*/
    public abstract void delete(SfdaAerEvIssuMsDO[] aggdos) throws BizException;
    
    /**
	*  不良报告_整改问题数据插入保存
	*/
	public abstract SfdaAerEvIssuMsDO[] insert(SfdaAerEvIssuMsDO[] aggdos) throws BizException;
	
    /**
	*  不良报告_整改问题数据保存
	*/
	public abstract SfdaAerEvIssuMsDO[] save(SfdaAerEvIssuMsDO[] aggdos) throws BizException;
	
    /**
	*  不良报告_整改问题数据更新
	*/
	public abstract SfdaAerEvIssuMsDO[] update(SfdaAerEvIssuMsDO[] aggdos) throws BizException;
	
	/**
	*  不良报告_整改问题数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvIssuMsDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvIssuMsDO[] enableWithoutFilter(SfdaAerEvIssuMsDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvIssuMsDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvIssuMsDO[] disableVOWithoutFilter(SfdaAerEvIssuMsDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvIssuMsDO[] aggdos) throws BizException ;
	
}
