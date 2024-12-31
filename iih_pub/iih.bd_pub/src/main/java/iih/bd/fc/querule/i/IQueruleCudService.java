package iih.bd.fc.querule.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.querule.d.QueRuleDO;
import iih.bd.fc.querule.d.QueruleAggDO;

/**
* 队列规则数据维护服务
*/
public interface IQueruleCudService {
	/**
	*  队列规则数据真删除
	*/
    public abstract void delete(QueruleAggDO[] aggdos) throws BizException;
    
    /**
	*  队列规则数据插入保存
	*/
	public abstract QueruleAggDO[] insert(QueruleAggDO[] aggdos) throws BizException;
	
    /**
	*  队列规则数据保存
	*/
	public abstract QueruleAggDO[] save(QueruleAggDO[] aggdos) throws BizException;
	
    /**
	*  队列规则数据更新
	*/
	public abstract QueruleAggDO[] update(QueruleAggDO[] aggdos) throws BizException;
	
	/**
	*  队列规则数据逻辑删除
	*/
	public abstract void logicDelete(QueruleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对队列规则数据真删除
	 */
	public abstract void deleteByParentDO(QueRuleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对队列规则数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(QueRuleDO[] mainDos) throws BizException;
}
