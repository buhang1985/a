package iih.mp.orm.surgappconfirm.i;

import xap.mw.core.data.BizException;
import iih.mp.orm.surgappconfirm.d.SurgSrvConfDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 手术申请单确认数据维护服务
*/
public interface ISurgSrvConfDOCudService {
	/**
	*  手术申请单确认数据真删除
	*/
    public abstract void delete(SurgSrvConfDO[] aggdos) throws BizException;
    
    /**
	*  手术申请单确认数据插入保存
	*/
	public abstract SurgSrvConfDO[] insert(SurgSrvConfDO[] aggdos) throws BizException;
	
    /**
	*  手术申请单确认数据保存
	*/
	public abstract SurgSrvConfDO[] save(SurgSrvConfDO[] aggdos) throws BizException;
	
    /**
	*  手术申请单确认数据更新
	*/
	public abstract SurgSrvConfDO[] update(SurgSrvConfDO[] aggdos) throws BizException;
	
	/**
	*  手术申请单确认数据逻辑删除
	*/
	public abstract void logicDelete(SurgSrvConfDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SurgSrvConfDO[] enableWithoutFilter(SurgSrvConfDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SurgSrvConfDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SurgSrvConfDO[] disableVOWithoutFilter(SurgSrvConfDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SurgSrvConfDO[] aggdos) throws BizException ;
	
}
