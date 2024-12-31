package iih.pe.pitm.perules.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perules.d.PeRuleDefDO;
import iih.pe.pitm.perules.d.PerulesAggDO;

/**
* 异常结果判定规则数据维护服务
*/
public interface IPerulesCudService {
	/**
	*  异常结果判定规则数据真删除
	*/
    public abstract void delete(PerulesAggDO[] aggdos) throws BizException;
    
    /**
	*  异常结果判定规则数据插入保存
	*/
	public abstract PerulesAggDO[] insert(PerulesAggDO[] aggdos) throws BizException;
	
    /**
	*  异常结果判定规则数据保存
	*/
	public abstract PerulesAggDO[] save(PerulesAggDO[] aggdos) throws BizException;
	
    /**
	*  异常结果判定规则数据更新
	*/
	public abstract PerulesAggDO[] update(PerulesAggDO[] aggdos) throws BizException;
	
	/**
	*  异常结果判定规则数据逻辑删除
	*/
	public abstract void logicDelete(PerulesAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对异常结果判定规则数据真删除
	 */
	public abstract void deleteByParentDO(PeRuleDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对异常结果判定规则数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRuleDefDO[] mainDos) throws BizException;
}
