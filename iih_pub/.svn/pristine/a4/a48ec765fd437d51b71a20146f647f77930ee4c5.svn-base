package iih.bd.pp.bddepcg.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.pp.bddepcg.d.BddepcgAggDO;

/**
* 科室补费策略数据维护服务
*/
public interface IBddepcgCudService {
	/**
	*  科室补费策略数据真删除
	*/
    public abstract void delete(BddepcgAggDO[] aggdos) throws BizException;
    
    /**
	*  科室补费策略数据插入保存
	*/
	public abstract BddepcgAggDO[] insert(BddepcgAggDO[] aggdos) throws BizException;
	
    /**
	*  科室补费策略数据保存
	*/
	public abstract BddepcgAggDO[] save(BddepcgAggDO[] aggdos) throws BizException;
	
    /**
	*  科室补费策略数据更新
	*/
	public abstract BddepcgAggDO[] update(BddepcgAggDO[] aggdos) throws BizException;
	
	/**
	*  科室补费策略数据逻辑删除
	*/
	public abstract void logicDelete(BddepcgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对科室补费策略数据真删除
	 */
	public abstract void deleteByParentDO(BdDepCgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对科室补费策略数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdDepCgDO[] mainDos) throws BizException;
}
