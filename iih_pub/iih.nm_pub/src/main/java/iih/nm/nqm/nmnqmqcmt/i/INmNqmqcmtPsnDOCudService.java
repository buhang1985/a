package iih.nm.nqm.nmnqmqcmt.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.nmnqmqcmt.d.NmNqmqcmtPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理管理_质控会议议题数据维护服务
*/
public interface INmNqmqcmtPsnDOCudService {
	/**
	*  护理管理_质控会议议题数据真删除
	*/
    public abstract void delete(NmNqmqcmtPsnDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_质控会议议题数据插入保存
	*/
	public abstract NmNqmqcmtPsnDO[] insert(NmNqmqcmtPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_质控会议议题数据保存
	*/
	public abstract NmNqmqcmtPsnDO[] save(NmNqmqcmtPsnDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_质控会议议题数据更新
	*/
	public abstract NmNqmqcmtPsnDO[] update(NmNqmqcmtPsnDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_质控会议议题数据逻辑删除
	*/
	public abstract void logicDelete(NmNqmqcmtPsnDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNqmqcmtPsnDO[] enableWithoutFilter(NmNqmqcmtPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNqmqcmtPsnDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNqmqcmtPsnDO[] disableVOWithoutFilter(NmNqmqcmtPsnDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNqmqcmtPsnDO[] aggdos) throws BizException ;
	
}