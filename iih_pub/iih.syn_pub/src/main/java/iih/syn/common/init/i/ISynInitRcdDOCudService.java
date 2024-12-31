package iih.syn.common.init.i;

import xap.mw.core.data.BizException;
import iih.syn.common.init.d.SynInitRcdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 基础数据初始化数据维护服务
*/
public interface ISynInitRcdDOCudService {
	/**
	*  基础数据初始化数据真删除
	*/
    public abstract void delete(SynInitRcdDO[] aggdos) throws BizException;
    
    /**
	*  基础数据初始化数据插入保存
	*/
	public abstract SynInitRcdDO[] insert(SynInitRcdDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据保存
	*/
	public abstract SynInitRcdDO[] save(SynInitRcdDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据更新
	*/
	public abstract SynInitRcdDO[] update(SynInitRcdDO[] aggdos) throws BizException;
	
	/**
	*  基础数据初始化数据逻辑删除
	*/
	public abstract void logicDelete(SynInitRcdDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SynInitRcdDO[] enableWithoutFilter(SynInitRcdDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SynInitRcdDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SynInitRcdDO[] disableVOWithoutFilter(SynInitRcdDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SynInitRcdDO[] aggdos) throws BizException ;
	
}
