package iih.en.pv.inpatient.i;

import xap.mw.core.data.BizException;
import iih.en.pv.inpatient.d.EntIpntDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 入院通知单数据维护服务
*/
public interface IEnipntMDOCudService {
	/**
	*  入院通知单数据真删除
	*/
    public abstract void delete(EntIpntDO[] aggdos) throws BizException;
    
    /**
	*  入院通知单数据插入保存
	*/
	public abstract EntIpntDO[] insert(EntIpntDO[] aggdos) throws BizException;
	
    /**
	*  入院通知单数据保存
	*/
	public abstract EntIpntDO[] save(EntIpntDO[] aggdos) throws BizException;
	
    /**
	*  入院通知单数据更新
	*/
	public abstract EntIpntDO[] update(EntIpntDO[] aggdos) throws BizException;
	
	/**
	*  入院通知单数据逻辑删除
	*/
	public abstract void logicDelete(EntIpntDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EntIpntDO[] enableWithoutFilter(EntIpntDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EntIpntDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EntIpntDO[] disableVOWithoutFilter(EntIpntDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EntIpntDO[] aggdos) throws BizException ;
	
}
