package iih.nm.nhr.nmpsnshift.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员调度数据维护服务
*/
public interface INmpsnshiftCudService {
	/**
	*  人员调度数据真删除
	*/
    public abstract void delete(NmNurTransDO[] aggdos) throws BizException;
    
    /**
	*  人员调度数据插入保存
	*/
	public abstract NmNurTransDO[] insert(NmNurTransDO[] aggdos) throws BizException;
	
    /**
	*  人员调度数据保存
	*/
	public abstract NmNurTransDO[] save(NmNurTransDO[] aggdos) throws BizException;
	
    /**
	*  人员调度数据更新
	*/
	public abstract NmNurTransDO[] update(NmNurTransDO[] aggdos) throws BizException;
	
	/**
	*  人员调度数据逻辑删除
	*/
	public abstract void logicDelete(NmNurTransDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurTransDO[] enableWithoutFilter(NmNurTransDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurTransDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurTransDO[] disableVOWithoutFilter(NmNurTransDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurTransDO[] dos) throws BizException ;
}
