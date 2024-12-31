package iih.mp.nr.skdmsg.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.skdmsg.d.MpSkdMsgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理任务消息数据维护服务
*/
public interface ISkdmsgCudService {
	/**
	*  护理任务消息数据真删除
	*/
    public abstract void delete(MpSkdMsgDO[] aggdos) throws BizException;
    
    /**
	*  护理任务消息数据插入保存
	*/
	public abstract MpSkdMsgDO[] insert(MpSkdMsgDO[] aggdos) throws BizException;
	
    /**
	*  护理任务消息数据保存
	*/
	public abstract MpSkdMsgDO[] save(MpSkdMsgDO[] aggdos) throws BizException;
	
    /**
	*  护理任务消息数据更新
	*/
	public abstract MpSkdMsgDO[] update(MpSkdMsgDO[] aggdos) throws BizException;
	
	/**
	*  护理任务消息数据逻辑删除
	*/
	public abstract void logicDelete(MpSkdMsgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpSkdMsgDO[] enableWithoutFilter(MpSkdMsgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpSkdMsgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpSkdMsgDO[] disableVOWithoutFilter(MpSkdMsgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpSkdMsgDO[] dos) throws BizException ;
}
