package iih.syn.common.init.i;

import xap.mw.core.data.BizException;
import iih.syn.common.init.d.SynInitDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 基础数据初始化数据维护服务
*/
public interface IInitMDOCudService {
	/**
	*  基础数据初始化数据真删除
	*/
    public abstract void delete(SynInitDO[] aggdos) throws BizException;
    
    /**
	*  基础数据初始化数据插入保存
	*/
	public abstract SynInitDO[] insert(SynInitDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据保存
	*/
	public abstract SynInitDO[] save(SynInitDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据更新
	*/
	public abstract SynInitDO[] update(SynInitDO[] aggdos) throws BizException;
	
	/**
	*  基础数据初始化数据逻辑删除
	*/
	public abstract void logicDelete(SynInitDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SynInitDO[] enableWithoutFilter(SynInitDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SynInitDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SynInitDO[] disableVOWithoutFilter(SynInitDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SynInitDO[] aggdos) throws BizException ;
	
}
