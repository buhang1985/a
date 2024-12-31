package iih.en.pv.enmsg.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enmsg.d.EnMsgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊短信数据维护服务
*/
public interface IEnmsgCudService {
	/**
	*  就诊短信数据真删除
	*/
    public abstract void delete(EnMsgDO[] aggdos) throws BizException;
    
    /**
	*  就诊短信数据插入保存
	*/
	public abstract EnMsgDO[] insert(EnMsgDO[] aggdos) throws BizException;
	
    /**
	*  就诊短信数据保存
	*/
	public abstract EnMsgDO[] save(EnMsgDO[] aggdos) throws BizException;
	
    /**
	*  就诊短信数据更新
	*/
	public abstract EnMsgDO[] update(EnMsgDO[] aggdos) throws BizException;
	
	/**
	*  就诊短信数据逻辑删除
	*/
	public abstract void logicDelete(EnMsgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnMsgDO[] enableWithoutFilter(EnMsgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnMsgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnMsgDO[] disableVOWithoutFilter(EnMsgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnMsgDO[] dos) throws BizException ;
}
