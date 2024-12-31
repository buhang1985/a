package iih.pe.pitm.perulecombine.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perulecombine.d.PeRuleCombineDO;
import iih.pe.pitm.perulecombine.d.PerulecombineAggDO;

/**
* 体检组合规则定义数据维护服务
*/
public interface IPerulecombineCudService {
	/**
	*  体检组合规则定义数据真删除
	*/
    public abstract void delete(PerulecombineAggDO[] aggdos) throws BizException;
    
    /**
	*  体检组合规则定义数据插入保存
	*/
	public abstract PerulecombineAggDO[] insert(PerulecombineAggDO[] aggdos) throws BizException;
	
    /**
	*  体检组合规则定义数据保存
	*/
	public abstract PerulecombineAggDO[] save(PerulecombineAggDO[] aggdos) throws BizException;
	
    /**
	*  体检组合规则定义数据更新
	*/
	public abstract PerulecombineAggDO[] update(PerulecombineAggDO[] aggdos) throws BizException;
	
	/**
	*  体检组合规则定义数据逻辑删除
	*/
	public abstract void logicDelete(PerulecombineAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检组合规则定义数据真删除
	 */
	public abstract void deleteByParentDO(PeRuleCombineDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检组合规则定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRuleCombineDO[] mainDos) throws BizException;
}
