package iih.bd.srv.mrtplvt.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 生命体征测量数据维护服务
*/
public interface IMrtplvtMDOCudService {
	/**
	*  生命体征测量数据真删除
	*/
    public abstract void delete(MrtplVtDO[] aggdos) throws BizException;
    
    /**
	*  生命体征测量数据插入保存
	*/
	public abstract MrtplVtDO[] insert(MrtplVtDO[] aggdos) throws BizException;
	
    /**
	*  生命体征测量数据保存
	*/
	public abstract MrtplVtDO[] save(MrtplVtDO[] aggdos) throws BizException;
	
    /**
	*  生命体征测量数据更新
	*/
	public abstract MrtplVtDO[] update(MrtplVtDO[] aggdos) throws BizException;
	
	/**
	*  生命体征测量数据逻辑删除
	*/
	public abstract void logicDelete(MrtplVtDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrtplVtDO[] enableWithoutFilter(MrtplVtDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrtplVtDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrtplVtDO[] disableVOWithoutFilter(MrtplVtDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrtplVtDO[] aggdos) throws BizException ;
	
}
