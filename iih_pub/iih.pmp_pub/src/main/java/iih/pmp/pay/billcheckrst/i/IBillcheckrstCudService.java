package iih.pmp.pay.billcheckrst.i;

import xap.mw.core.data.BizException;
import iih.pmp.pay.billcheckrst.d.BillCheckRstDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 对账结果数据维护服务
*/
public interface IBillcheckrstCudService {
	/**
	*  对账结果数据真删除
	*/
    public abstract void delete(BillCheckRstDO[] aggdos) throws BizException;
    
    /**
	*  对账结果数据插入保存
	*/
	public abstract BillCheckRstDO[] insert(BillCheckRstDO[] aggdos) throws BizException;
	
    /**
	*  对账结果数据保存
	*/
	public abstract BillCheckRstDO[] save(BillCheckRstDO[] aggdos) throws BizException;
	
    /**
	*  对账结果数据更新
	*/
	public abstract BillCheckRstDO[] update(BillCheckRstDO[] aggdos) throws BizException;
	
	/**
	*  对账结果数据逻辑删除
	*/
	public abstract void logicDelete(BillCheckRstDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BillCheckRstDO[] enableWithoutFilter(BillCheckRstDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BillCheckRstDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BillCheckRstDO[] disableVOWithoutFilter(BillCheckRstDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BillCheckRstDO[] dos) throws BizException ;
}
