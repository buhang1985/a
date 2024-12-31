package iih.bd.fc.orwf.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医嘱流向数据维护服务
*/
public interface IOrwfMDOCudService {
	/**
	*  医嘱流向数据真删除
	*/
    public abstract void delete(OrWfCfgDO[] aggdos) throws BizException;
    
    /**
	*  医嘱流向数据插入保存
	*/
	public abstract OrWfCfgDO[] insert(OrWfCfgDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向数据保存
	*/
	public abstract OrWfCfgDO[] save(OrWfCfgDO[] aggdos) throws BizException;
	
    /**
	*  医嘱流向数据更新
	*/
	public abstract OrWfCfgDO[] update(OrWfCfgDO[] aggdos) throws BizException;
	
	/**
	*  医嘱流向数据逻辑删除
	*/
	public abstract void logicDelete(OrWfCfgDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrWfCfgDO[] enableWithoutFilter(OrWfCfgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrWfCfgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrWfCfgDO[] disableVOWithoutFilter(OrWfCfgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrWfCfgDO[] aggdos) throws BizException ;
	
}
