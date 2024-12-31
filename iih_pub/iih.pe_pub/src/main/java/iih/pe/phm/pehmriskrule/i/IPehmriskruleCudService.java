package iih.pe.phm.pehmriskrule.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmriskrule.d.PeHmRiskRuleDO;
import iih.pe.phm.pehmriskrule.d.PehmriskruleAggDO;

/**
* 健康危险因素规则定义数据维护服务
*/
public interface IPehmriskruleCudService {
	/**
	*  健康危险因素规则定义数据真删除
	*/
    public abstract void delete(PehmriskruleAggDO[] aggdos) throws BizException;
    
    /**
	*  健康危险因素规则定义数据插入保存
	*/
	public abstract PehmriskruleAggDO[] insert(PehmriskruleAggDO[] aggdos) throws BizException;
	
    /**
	*  健康危险因素规则定义数据保存
	*/
	public abstract PehmriskruleAggDO[] save(PehmriskruleAggDO[] aggdos) throws BizException;
	
    /**
	*  健康危险因素规则定义数据更新
	*/
	public abstract PehmriskruleAggDO[] update(PehmriskruleAggDO[] aggdos) throws BizException;
	
	/**
	*  健康危险因素规则定义数据逻辑删除
	*/
	public abstract void logicDelete(PehmriskruleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康危险因素规则定义数据真删除
	 */
	public abstract void deleteByParentDO(PeHmRiskRuleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康危险因素规则定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeHmRiskRuleDO[] mainDos) throws BizException;
}
