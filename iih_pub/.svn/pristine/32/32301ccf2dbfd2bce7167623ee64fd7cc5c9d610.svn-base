package iih.pe.phm.persthra.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.persthra.d.PeRstHraDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 健康评估结果-单因素数据维护服务
*/
public interface IPersthraMDOCudService {
	/**
	*  健康评估结果-单因素数据真删除
	*/
    public abstract void delete(PeRstHraDO[] aggdos) throws BizException;
    
    /**
	*  健康评估结果-单因素数据插入保存
	*/
	public abstract PeRstHraDO[] insert(PeRstHraDO[] aggdos) throws BizException;
	
    /**
	*  健康评估结果-单因素数据保存
	*/
	public abstract PeRstHraDO[] save(PeRstHraDO[] aggdos) throws BizException;
	
    /**
	*  健康评估结果-单因素数据更新
	*/
	public abstract PeRstHraDO[] update(PeRstHraDO[] aggdos) throws BizException;
	
	/**
	*  健康评估结果-单因素数据逻辑删除
	*/
	public abstract void logicDelete(PeRstHraDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstHraDO[] enableWithoutFilter(PeRstHraDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstHraDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstHraDO[] disableVOWithoutFilter(PeRstHraDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstHraDO[] aggdos) throws BizException ;
	
}
