package iih.nm.nhr.nmnurplc.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurplc.d.NmNurPlcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理人员_政治面目数据维护服务
*/
public interface INmnurplcCudService {
	/**
	*  护理人员_政治面目数据真删除
	*/
    public abstract void delete(NmNurPlcDO[] aggdos) throws BizException;
    
    /**
	*  护理人员_政治面目数据插入保存
	*/
	public abstract NmNurPlcDO[] insert(NmNurPlcDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_政治面目数据保存
	*/
	public abstract NmNurPlcDO[] save(NmNurPlcDO[] aggdos) throws BizException;
	
    /**
	*  护理人员_政治面目数据更新
	*/
	public abstract NmNurPlcDO[] update(NmNurPlcDO[] aggdos) throws BizException;
	
	/**
	*  护理人员_政治面目数据逻辑删除
	*/
	public abstract void logicDelete(NmNurPlcDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurPlcDO[] enableWithoutFilter(NmNurPlcDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurPlcDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurPlcDO[] disableVOWithoutFilter(NmNurPlcDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurPlcDO[] dos) throws BizException ;
}
