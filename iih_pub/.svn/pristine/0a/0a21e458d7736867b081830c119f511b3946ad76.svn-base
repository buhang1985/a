package iih.bd.fc.entpwf.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.entpwf.d.BdEntpWfDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊流程定义数据维护服务
*/
public interface IEntpwfCudService {
	/**
	*  就诊流程定义数据真删除
	*/
    public abstract void delete(BdEntpWfDO[] aggdos) throws BizException;
    
    /**
	*  就诊流程定义数据插入保存
	*/
	public abstract BdEntpWfDO[] insert(BdEntpWfDO[] aggdos) throws BizException;
	
    /**
	*  就诊流程定义数据保存
	*/
	public abstract BdEntpWfDO[] save(BdEntpWfDO[] aggdos) throws BizException;
	
    /**
	*  就诊流程定义数据更新
	*/
	public abstract BdEntpWfDO[] update(BdEntpWfDO[] aggdos) throws BizException;
	
	/**
	*  就诊流程定义数据逻辑删除
	*/
	public abstract void logicDelete(BdEntpWfDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdEntpWfDO[] enableWithoutFilter(BdEntpWfDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdEntpWfDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdEntpWfDO[] disableVOWithoutFilter(BdEntpWfDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdEntpWfDO[] dos) throws BizException ;
}
