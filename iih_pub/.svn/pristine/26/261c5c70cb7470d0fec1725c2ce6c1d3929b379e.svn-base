package iih.mi.mc.mimctactics.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimctactics.d.MiMcTacticsDO;
import iih.mi.mc.mimctactics.d.MimctacticsAggDO;

/**
* 医保策略库数据维护服务
*/
public interface IMimctacticsCudService {
	/**
	*  医保策略库数据真删除
	*/
    public abstract void delete(MimctacticsAggDO[] aggdos) throws BizException;
    
    /**
	*  医保策略库数据插入保存
	*/
	public abstract MimctacticsAggDO[] insert(MimctacticsAggDO[] aggdos) throws BizException;
	
    /**
	*  医保策略库数据保存
	*/
	public abstract MimctacticsAggDO[] save(MimctacticsAggDO[] aggdos) throws BizException;
	
    /**
	*  医保策略库数据更新
	*/
	public abstract MimctacticsAggDO[] update(MimctacticsAggDO[] aggdos) throws BizException;
	
	/**
	*  医保策略库数据逻辑删除
	*/
	public abstract void logicDelete(MimctacticsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保策略库数据真删除
	 */
	public abstract void deleteByParentDO(MiMcTacticsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保策略库数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MiMcTacticsDO[] mainDos) throws BizException;
}
