package iih.mp.mpbd.tcstyle.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.tcstyle.d.TcstyDepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体温单样式数据维护服务
*/
public interface ITcstyDepDOCudService {
	/**
	*  体温单样式数据真删除
	*/
    public abstract void delete(TcstyDepDO[] aggdos) throws BizException;
    
    /**
	*  体温单样式数据插入保存
	*/
	public abstract TcstyDepDO[] insert(TcstyDepDO[] aggdos) throws BizException;
	
    /**
	*  体温单样式数据保存
	*/
	public abstract TcstyDepDO[] save(TcstyDepDO[] aggdos) throws BizException;
	
    /**
	*  体温单样式数据更新
	*/
	public abstract TcstyDepDO[] update(TcstyDepDO[] aggdos) throws BizException;
	
	/**
	*  体温单样式数据逻辑删除
	*/
	public abstract void logicDelete(TcstyDepDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TcstyDepDO[] enableWithoutFilter(TcstyDepDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TcstyDepDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TcstyDepDO[] disableVOWithoutFilter(TcstyDepDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TcstyDepDO[] aggdos) throws BizException ;
	
}
