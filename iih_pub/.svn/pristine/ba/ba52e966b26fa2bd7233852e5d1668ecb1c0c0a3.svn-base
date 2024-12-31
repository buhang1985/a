package iih.mp.orm.surgappconfirm.i;

import xap.mw.core.data.BizException;
import iih.mp.orm.surgappconfirm.d.SurgImConfDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 手术申请单确认数据维护服务
*/
public interface ISurgImConfDOCudService {
	/**
	*  手术申请单确认数据真删除
	*/
    public abstract void delete(SurgImConfDO[] aggdos) throws BizException;
    
    /**
	*  手术申请单确认数据插入保存
	*/
	public abstract SurgImConfDO[] insert(SurgImConfDO[] aggdos) throws BizException;
	
    /**
	*  手术申请单确认数据保存
	*/
	public abstract SurgImConfDO[] save(SurgImConfDO[] aggdos) throws BizException;
	
    /**
	*  手术申请单确认数据更新
	*/
	public abstract SurgImConfDO[] update(SurgImConfDO[] aggdos) throws BizException;
	
	/**
	*  手术申请单确认数据逻辑删除
	*/
	public abstract void logicDelete(SurgImConfDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SurgImConfDO[] enableWithoutFilter(SurgImConfDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SurgImConfDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SurgImConfDO[] disableVOWithoutFilter(SurgImConfDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SurgImConfDO[] aggdos) throws BizException ;
	
}
