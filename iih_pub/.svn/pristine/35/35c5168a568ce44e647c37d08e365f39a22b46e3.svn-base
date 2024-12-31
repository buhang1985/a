package iih.nm.nhr.nmnurtrpt.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurtrpt.d.NmNurTrptDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员调岗记录数据维护服务
*/
public interface INmnurtrptCudService {
	/**
	*  人员调岗记录数据真删除
	*/
    public abstract void delete(NmNurTrptDO[] aggdos) throws BizException;
    
    /**
	*  人员调岗记录数据插入保存
	*/
	public abstract NmNurTrptDO[] insert(NmNurTrptDO[] aggdos) throws BizException;
	
    /**
	*  人员调岗记录数据保存
	*/
	public abstract NmNurTrptDO[] save(NmNurTrptDO[] aggdos) throws BizException;
	
    /**
	*  人员调岗记录数据更新
	*/
	public abstract NmNurTrptDO[] update(NmNurTrptDO[] aggdos) throws BizException;
	
	/**
	*  人员调岗记录数据逻辑删除
	*/
	public abstract void logicDelete(NmNurTrptDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurTrptDO[] enableWithoutFilter(NmNurTrptDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurTrptDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurTrptDO[] disableVOWithoutFilter(NmNurTrptDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurTrptDO[] dos) throws BizException ;
}
