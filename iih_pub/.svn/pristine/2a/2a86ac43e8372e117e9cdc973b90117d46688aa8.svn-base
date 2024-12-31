package iih.mm.qy.departreq.i;

import xap.mw.core.data.BizException;
import iih.mm.qy.departreq.d.DepartReqQueryView;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 领用申请查询数据维护服务
*/
public interface IDepartreqCudService {
	/**
	*  领用申请查询数据真删除
	*/
    public abstract void delete(DepartReqQueryView[] aggdos) throws BizException;
    
    /**
	*  领用申请查询数据插入保存
	*/
	public abstract DepartReqQueryView[] insert(DepartReqQueryView[] aggdos) throws BizException;
	
    /**
	*  领用申请查询数据保存
	*/
	public abstract DepartReqQueryView[] save(DepartReqQueryView[] aggdos) throws BizException;
	
    /**
	*  领用申请查询数据更新
	*/
	public abstract DepartReqQueryView[] update(DepartReqQueryView[] aggdos) throws BizException;
	
	/**
	*  领用申请查询数据逻辑删除
	*/
	public abstract void logicDelete(DepartReqQueryView[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DepartReqQueryView[] enableWithoutFilter(DepartReqQueryView[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DepartReqQueryView[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DepartReqQueryView[] disableVOWithoutFilter(DepartReqQueryView[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DepartReqQueryView[] dos) throws BizException ;
}
