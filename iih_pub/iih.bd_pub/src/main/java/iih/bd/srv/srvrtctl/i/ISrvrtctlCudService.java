package iih.bd.srv.srvrtctl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDO;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;

/**
* 服务开立权限数据维护服务
*/
public interface ISrvrtctlCudService {
	/**
	*  服务开立权限数据真删除
	*/
    public abstract void delete(SrvrtctlAggDO[] aggdos) throws BizException;
    
    /**
	*  服务开立权限数据插入保存
	*/
	public abstract SrvrtctlAggDO[] insert(SrvrtctlAggDO[] aggdos) throws BizException;
	
    /**
	*  服务开立权限数据保存
	*/
	public abstract SrvrtctlAggDO[] save(SrvrtctlAggDO[] aggdos) throws BizException;
	
    /**
	*  服务开立权限数据更新
	*/
	public abstract SrvrtctlAggDO[] update(SrvrtctlAggDO[] aggdos) throws BizException;
	
	/**
	*  服务开立权限数据逻辑删除
	*/
	public abstract void logicDelete(SrvrtctlAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对服务开立权限数据真删除
	 */
	public abstract void deleteByParentDO(SrvRtCtlDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对服务开立权限数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SrvRtCtlDO[] mainDos) throws BizException;
}
