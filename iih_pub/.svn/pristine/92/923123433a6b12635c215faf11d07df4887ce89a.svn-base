package iih.bd.srv.mrinfectdisewarnmsg.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrinfectdisewarnmsg.d.MrInfectDiseWarnMsgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 传染病预警消息数据维护服务
*/
public interface IMrinfectdisewarnmsgCudService {
	/**
	*  传染病预警消息数据真删除
	*/
    public abstract void delete(MrInfectDiseWarnMsgDO[] aggdos) throws BizException;
    
    /**
	*  传染病预警消息数据插入保存
	*/
	public abstract MrInfectDiseWarnMsgDO[] insert(MrInfectDiseWarnMsgDO[] aggdos) throws BizException;
	
    /**
	*  传染病预警消息数据保存
	*/
	public abstract MrInfectDiseWarnMsgDO[] save(MrInfectDiseWarnMsgDO[] aggdos) throws BizException;
	
    /**
	*  传染病预警消息数据更新
	*/
	public abstract MrInfectDiseWarnMsgDO[] update(MrInfectDiseWarnMsgDO[] aggdos) throws BizException;
	
	/**
	*  传染病预警消息数据逻辑删除
	*/
	public abstract void logicDelete(MrInfectDiseWarnMsgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MrInfectDiseWarnMsgDO[] enableWithoutFilter(MrInfectDiseWarnMsgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MrInfectDiseWarnMsgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MrInfectDiseWarnMsgDO[] disableVOWithoutFilter(MrInfectDiseWarnMsgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MrInfectDiseWarnMsgDO[] dos) throws BizException ;
}
