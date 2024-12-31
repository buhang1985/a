package iih.ci.mrqc.randomcheck.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomcheck.d.MrqcrandomcheckAggDO;

/**
* 门诊病历抽查数据维护服务
*/
public interface IMrqcrandomcheckCudService {
	/**
	*  门诊病历抽查数据真删除
	*/
    public abstract void delete(MrqcrandomcheckAggDO[] aggdos) throws BizException;
    
    /**
	*  门诊病历抽查数据插入保存
	*/
	public abstract MrqcrandomcheckAggDO[] insert(MrqcrandomcheckAggDO[] aggdos) throws BizException;
	
    /**
	*  门诊病历抽查数据保存
	*/
	public abstract MrqcrandomcheckAggDO[] save(MrqcrandomcheckAggDO[] aggdos) throws BizException;
	
    /**
	*  门诊病历抽查数据更新
	*/
	public abstract MrqcrandomcheckAggDO[] update(MrqcrandomcheckAggDO[] aggdos) throws BizException;
	
	/**
	*  门诊病历抽查数据逻辑删除
	*/
	public abstract void logicDelete(MrqcrandomcheckAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对门诊病历抽查数据真删除
	 */
	public abstract void deleteByParentDO(CiMrQcRandomRecordDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对门诊病历抽查数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiMrQcRandomRecordDO[] mainDos) throws BizException;
}
