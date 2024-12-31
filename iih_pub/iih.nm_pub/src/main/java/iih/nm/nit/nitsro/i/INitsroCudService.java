package iih.nm.nit.nitsro.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitsro.d.NitSroDO;
import iih.nm.nit.nitsro.d.NitsroAggDO;

/**
* 院校批次管理数据维护服务
*/
public interface INitsroCudService {
	/**
	*  院校批次管理数据真删除
	*/
    public abstract void delete(NitsroAggDO[] aggdos) throws BizException;
    
    /**
	*  院校批次管理数据插入保存
	*/
	public abstract NitsroAggDO[] insert(NitsroAggDO[] aggdos) throws BizException;
	
    /**
	*  院校批次管理数据保存
	*/
	public abstract NitsroAggDO[] save(NitsroAggDO[] aggdos) throws BizException;
	
    /**
	*  院校批次管理数据更新
	*/
	public abstract NitsroAggDO[] update(NitsroAggDO[] aggdos) throws BizException;
	
	/**
	*  院校批次管理数据逻辑删除
	*/
	public abstract void logicDelete(NitsroAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对院校批次管理数据真删除
	 */
	public abstract void deleteByParentDO(NitSroDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对院校批次管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NitSroDO[] mainDos) throws BizException;
}
