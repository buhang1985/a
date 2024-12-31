package iih.sc.scbd.screleaserule.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleDO;
import iih.sc.scbd.screleaserule.d.ScreleaseruleAggDO;

/**
* 排班释放规则数据维护服务
*/
public interface IScreleaseruleCudService {
	/**
	*  排班释放规则数据真删除
	*/
    public abstract void delete(ScreleaseruleAggDO[] aggdos) throws BizException;
    
    /**
	*  排班释放规则数据插入保存
	*/
	public abstract ScreleaseruleAggDO[] insert(ScreleaseruleAggDO[] aggdos) throws BizException;
	
    /**
	*  排班释放规则数据保存
	*/
	public abstract ScreleaseruleAggDO[] save(ScreleaseruleAggDO[] aggdos) throws BizException;
	
    /**
	*  排班释放规则数据更新
	*/
	public abstract ScreleaseruleAggDO[] update(ScreleaseruleAggDO[] aggdos) throws BizException;
	
	/**
	*  排班释放规则数据逻辑删除
	*/
	public abstract void logicDelete(ScreleaseruleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班释放规则数据真删除
	 */
	public abstract void deleteByParentDO(ScReleaseRuleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班释放规则数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScReleaseRuleDO[] mainDos) throws BizException;
}
