package iih.pmp.pay.channelbill.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 渠道账单数据维护服务
*/
public interface IChannelbillCudService {
	/**
	*  渠道账单数据真删除
	*/
    public abstract void delete(ChannelBillDO[] aggdos) throws BizException;
    
    /**
	*  渠道账单数据插入保存
	*/
	public abstract ChannelBillDO[] insert(ChannelBillDO[] aggdos) throws BizException;
	
    /**
	*  渠道账单数据保存
	*/
	public abstract ChannelBillDO[] save(ChannelBillDO[] aggdos) throws BizException;
	
    /**
	*  渠道账单数据更新
	*/
	public abstract ChannelBillDO[] update(ChannelBillDO[] aggdos) throws BizException;
	
	/**
	*  渠道账单数据逻辑删除
	*/
	public abstract void logicDelete(ChannelBillDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ChannelBillDO[] enableWithoutFilter(ChannelBillDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ChannelBillDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ChannelBillDO[] disableVOWithoutFilter(ChannelBillDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ChannelBillDO[] dos) throws BizException ;
}
