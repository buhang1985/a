package iih.nm.npi.nmnpinhs.i;

import xap.mw.core.data.BizException;
import iih.nm.npi.nmnpinhs.d.NmNpiNhsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_制度维护数据维护服务
*/
public interface INmnpinhsCudService {
	/**
	*  护理管理_制度维护数据真删除
	*/
    public abstract void delete(NmNpiNhsDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_制度维护数据插入保存
	*/
	public abstract NmNpiNhsDO[] insert(NmNpiNhsDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_制度维护数据保存
	*/
	public abstract NmNpiNhsDO[] save(NmNpiNhsDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_制度维护数据更新
	*/
	public abstract NmNpiNhsDO[] update(NmNpiNhsDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_制度维护数据逻辑删除
	*/
	public abstract void logicDelete(NmNpiNhsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNpiNhsDO[] enableWithoutFilter(NmNpiNhsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNpiNhsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNpiNhsDO[] disableVOWithoutFilter(NmNpiNhsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNpiNhsDO[] dos) throws BizException ;
}
