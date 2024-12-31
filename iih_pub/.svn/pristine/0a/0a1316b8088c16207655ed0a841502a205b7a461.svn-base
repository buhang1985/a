package iih.pmp.pay.channelbillitem.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 渠道账单明细数据维护服务
*/
public interface IChannelbillitemCudService {
	/**
	*  渠道账单明细数据真删除
	*/
    public abstract void delete(ChlBillItemDO[] aggdos) throws BizException;
    
    /**
	*  渠道账单明细数据插入保存
	*/
	public abstract ChlBillItemDO[] insert(ChlBillItemDO[] aggdos) throws BizException;
	
    /**
	*  渠道账单明细数据保存
	*/
	public abstract ChlBillItemDO[] save(ChlBillItemDO[] aggdos) throws BizException;
	
    /**
	*  渠道账单明细数据更新
	*/
	public abstract ChlBillItemDO[] update(ChlBillItemDO[] aggdos) throws BizException;
	
	/**
	*  渠道账单明细数据逻辑删除
	*/
	public abstract void logicDelete(ChlBillItemDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ChlBillItemDO[] enableWithoutFilter(ChlBillItemDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ChlBillItemDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ChlBillItemDO[] disableVOWithoutFilter(ChlBillItemDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ChlBillItemDO[] dos) throws BizException ;
}
