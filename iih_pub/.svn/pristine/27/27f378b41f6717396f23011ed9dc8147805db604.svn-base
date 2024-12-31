package iih.nmr.ha.tcho.nachsorge.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.nachsorge.d.TchoNachsorgeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 出院护理评估表数据维护服务
*/
public interface INachsorgeCudService {
	/**
	*  出院护理评估表数据真删除
	*/
    public abstract void delete(TchoNachsorgeDO[] aggdos) throws BizException;
    
    /**
	*  出院护理评估表数据插入保存
	*/
	public abstract TchoNachsorgeDO[] insert(TchoNachsorgeDO[] aggdos) throws BizException;
	
    /**
	*  出院护理评估表数据保存
	*/
	public abstract TchoNachsorgeDO[] save(TchoNachsorgeDO[] aggdos) throws BizException;
	
    /**
	*  出院护理评估表数据更新
	*/
	public abstract TchoNachsorgeDO[] update(TchoNachsorgeDO[] aggdos) throws BizException;
	
	/**
	*  出院护理评估表数据逻辑删除
	*/
	public abstract void logicDelete(TchoNachsorgeDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TchoNachsorgeDO[] enableWithoutFilter(TchoNachsorgeDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TchoNachsorgeDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TchoNachsorgeDO[] disableVOWithoutFilter(TchoNachsorgeDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TchoNachsorgeDO[] dos) throws BizException ;
}
