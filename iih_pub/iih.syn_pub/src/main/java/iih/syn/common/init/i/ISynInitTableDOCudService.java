package iih.syn.common.init.i;

import xap.mw.core.data.BizException;
import iih.syn.common.init.d.SynInitTableDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 基础数据初始化数据维护服务
*/
public interface ISynInitTableDOCudService {
	/**
	*  基础数据初始化数据真删除
	*/
    public abstract void delete(SynInitTableDO[] aggdos) throws BizException;
    
    /**
	*  基础数据初始化数据插入保存
	*/
	public abstract SynInitTableDO[] insert(SynInitTableDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据保存
	*/
	public abstract SynInitTableDO[] save(SynInitTableDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据更新
	*/
	public abstract SynInitTableDO[] update(SynInitTableDO[] aggdos) throws BizException;
	
	/**
	*  基础数据初始化数据逻辑删除
	*/
	public abstract void logicDelete(SynInitTableDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SynInitTableDO[] enableWithoutFilter(SynInitTableDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SynInitTableDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SynInitTableDO[] disableVOWithoutFilter(SynInitTableDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SynInitTableDO[] aggdos) throws BizException ;
	
}
