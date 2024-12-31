package iih.en.pv.enfee.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.d.EnfixedfeeAggDO;

/**
* 患者就诊_固定费用数据维护服务
*/
public interface IEnfixedfeeCudService {
	/**
	*  患者就诊_固定费用数据真删除
	*/
    public abstract void delete(EnfixedfeeAggDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_固定费用数据插入保存
	*/
	public abstract EnfixedfeeAggDO[] insert(EnfixedfeeAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_固定费用数据保存
	*/
	public abstract EnfixedfeeAggDO[] save(EnfixedfeeAggDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_固定费用数据更新
	*/
	public abstract EnfixedfeeAggDO[] update(EnfixedfeeAggDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_固定费用数据逻辑删除
	*/
	public abstract void logicDelete(EnfixedfeeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊_固定费用数据真删除
	 */
	public abstract void deleteByParentDO(EnFixedFeeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者就诊_固定费用数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EnFixedFeeDO[] mainDos) throws BizException;
}
