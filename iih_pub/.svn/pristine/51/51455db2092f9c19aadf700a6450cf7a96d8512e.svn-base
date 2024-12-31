package iih.bl.hp.hpentrefunddetail.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hpentrefunddetail.d.HpEntRefundDetailDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保半退明细记录数据维护服务
*/
public interface IHpentrefunddetailCudService {
	/**
	*  医保半退明细记录数据真删除
	*/
    public abstract void delete(HpEntRefundDetailDO[] aggdos) throws BizException;
    
    /**
	*  医保半退明细记录数据插入保存
	*/
	public abstract HpEntRefundDetailDO[] insert(HpEntRefundDetailDO[] aggdos) throws BizException;
	
    /**
	*  医保半退明细记录数据保存
	*/
	public abstract HpEntRefundDetailDO[] save(HpEntRefundDetailDO[] aggdos) throws BizException;
	
    /**
	*  医保半退明细记录数据更新
	*/
	public abstract HpEntRefundDetailDO[] update(HpEntRefundDetailDO[] aggdos) throws BizException;
	
	/**
	*  医保半退明细记录数据逻辑删除
	*/
	public abstract void logicDelete(HpEntRefundDetailDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpEntRefundDetailDO[] enableWithoutFilter(HpEntRefundDetailDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpEntRefundDetailDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpEntRefundDetailDO[] disableVOWithoutFilter(HpEntRefundDetailDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpEntRefundDetailDO[] dos) throws BizException ;
}
