package iih.ci.rcm.infectionrate.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.infectionrate.d.InfectionRateDO;
import iih.ci.rcm.infectionrate.d.InfectionrateAggDO;

/**
* 医院感染现患率数据维护服务
*/
public interface IInfectionrateCudService {
	/**
	*  医院感染现患率数据真删除
	*/
    public abstract void delete(InfectionrateAggDO[] aggdos) throws BizException;
    
    /**
	*  医院感染现患率数据插入保存
	*/
	public abstract InfectionrateAggDO[] insert(InfectionrateAggDO[] aggdos) throws BizException;
	
    /**
	*  医院感染现患率数据保存
	*/
	public abstract InfectionrateAggDO[] save(InfectionrateAggDO[] aggdos) throws BizException;
	
    /**
	*  医院感染现患率数据更新
	*/
	public abstract InfectionrateAggDO[] update(InfectionrateAggDO[] aggdos) throws BizException;
	
	/**
	*  医院感染现患率数据逻辑删除
	*/
	public abstract void logicDelete(InfectionrateAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医院感染现患率数据真删除
	 */
	public abstract void deleteByParentDO(InfectionRateDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医院感染现患率数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(InfectionRateDO[] mainDos) throws BizException;
}
