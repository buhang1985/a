package iih.mm.qy.trapreqquery.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.trapreqquery.d.TrapReqQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 调拨申请查询数据维护服务
*/
public interface ITrapreqqueryCudService {
	/**
	*  调拨申请查询数据真删除
	*/
    public abstract void delete(TrapReqQueryView[] aggdos) throws BizException;
    
    /**
	*  调拨申请查询数据插入保存
	*/
	public abstract TrapReqQueryView[] insert(TrapReqQueryView[] aggdos) throws BizException;
	
    /**
	*  调拨申请查询数据保存
	*/
	public abstract TrapReqQueryView[] save(TrapReqQueryView[] aggdos) throws BizException;
	
    /**
	*  调拨申请查询数据更新
	*/
	public abstract TrapReqQueryView[] update(TrapReqQueryView[] aggdos) throws BizException;
	
	/**
	*  调拨申请查询数据逻辑删除
	*/
	public abstract void logicDelete(TrapReqQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TrapReqQueryView[] enableWithoutFilter(TrapReqQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TrapReqQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TrapReqQueryView[] disableVOWithoutFilter(TrapReqQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TrapReqQueryView[] dos) throws BizException ;
}
