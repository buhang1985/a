package iih.bd.srv.deptsrvlimit.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitDO;
import iih.bd.srv.deptsrvlimit.d.DeptsrvlimitAggDO;

/**
* 科室服务白黑名单数据维护服务
*/
public interface IDeptsrvlimitCudService {
	/**
	*  科室服务白黑名单数据真删除
	*/
    public abstract void delete(DeptsrvlimitAggDO[] aggdos) throws BizException;
    
    /**
	*  科室服务白黑名单数据插入保存
	*/
	public abstract DeptsrvlimitAggDO[] insert(DeptsrvlimitAggDO[] aggdos) throws BizException;
	
    /**
	*  科室服务白黑名单数据保存
	*/
	public abstract DeptsrvlimitAggDO[] save(DeptsrvlimitAggDO[] aggdos) throws BizException;
	
    /**
	*  科室服务白黑名单数据更新
	*/
	public abstract DeptsrvlimitAggDO[] update(DeptsrvlimitAggDO[] aggdos) throws BizException;
	
	/**
	*  科室服务白黑名单数据逻辑删除
	*/
	public abstract void logicDelete(DeptsrvlimitAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对科室服务白黑名单数据真删除
	 */
	public abstract void deleteByParentDO(DeptSrvLimitDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对科室服务白黑名单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DeptSrvLimitDO[] mainDos) throws BizException;
}
