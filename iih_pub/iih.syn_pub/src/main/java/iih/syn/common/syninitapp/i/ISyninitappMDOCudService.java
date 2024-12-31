package iih.syn.common.syninitapp.i;

import xap.mw.core.data.BizException;
import iih.syn.common.syninitapp.d.SynInitAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 数据初始化申请数据维护服务
*/
public interface ISyninitappMDOCudService {
	/**
	*  数据初始化申请数据真删除
	*/
    public abstract void delete(SynInitAppDO[] aggdos) throws BizException;
    
    /**
	*  数据初始化申请数据插入保存
	*/
	public abstract SynInitAppDO[] insert(SynInitAppDO[] aggdos) throws BizException;
	
    /**
	*  数据初始化申请数据保存
	*/
	public abstract SynInitAppDO[] save(SynInitAppDO[] aggdos) throws BizException;
	
    /**
	*  数据初始化申请数据更新
	*/
	public abstract SynInitAppDO[] update(SynInitAppDO[] aggdos) throws BizException;
	
	/**
	*  数据初始化申请数据逻辑删除
	*/
	public abstract void logicDelete(SynInitAppDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SynInitAppDO[] enableWithoutFilter(SynInitAppDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SynInitAppDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SynInitAppDO[] disableVOWithoutFilter(SynInitAppDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SynInitAppDO[] aggdos) throws BizException ;
	
}
