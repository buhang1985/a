package iih.bd.pp.baseprisrv.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.BaseprisrvAggDO;

/**
* 价格服务数据维护服务
*/
public interface IBaseprisrvCudService {
	/**
	*  价格服务数据真删除
	*/
    public abstract void delete(BaseprisrvAggDO[] aggdos) throws BizException;
    
    /**
	*  价格服务数据插入保存
	*/
	public abstract BaseprisrvAggDO[] insert(BaseprisrvAggDO[] aggdos) throws BizException;
	
    /**
	*  价格服务数据保存
	*/
	public abstract BaseprisrvAggDO[] save(BaseprisrvAggDO[] aggdos) throws BizException;
	
    /**
	*  价格服务数据更新
	*/
	public abstract BaseprisrvAggDO[] update(BaseprisrvAggDO[] aggdos) throws BizException;
	
	/**
	*  价格服务数据逻辑删除
	*/
	public abstract void logicDelete(BaseprisrvAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对价格服务数据真删除
	 */
	public abstract void deleteByParentDO(PriSrvDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对价格服务数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PriSrvDO[] mainDos) throws BizException;
}
