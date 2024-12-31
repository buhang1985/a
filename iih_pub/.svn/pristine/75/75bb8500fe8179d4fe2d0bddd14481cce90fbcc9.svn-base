package iih.bd.srv.srvreact.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.srv.srvreact.d.SrvreactAggDO;

/**
* 服务互斥数据维护服务
*/
public interface ISrvreactCudService {
	/**
	*  服务互斥数据真删除
	*/
    public abstract void delete(SrvreactAggDO[] aggdos) throws BizException;
    
    /**
	*  服务互斥数据插入保存
	*/
	public abstract SrvreactAggDO[] insert(SrvreactAggDO[] aggdos) throws BizException;
	
    /**
	*  服务互斥数据保存
	*/
	public abstract SrvreactAggDO[] save(SrvreactAggDO[] aggdos) throws BizException;
	
    /**
	*  服务互斥数据更新
	*/
	public abstract SrvreactAggDO[] update(SrvreactAggDO[] aggdos) throws BizException;
	
	/**
	*  服务互斥数据逻辑删除
	*/
	public abstract void logicDelete(SrvreactAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对服务互斥数据真删除
	 */
	public abstract void deleteByParentDO(SrvReactDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对服务互斥数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SrvReactDO[] mainDos) throws BizException;
}
