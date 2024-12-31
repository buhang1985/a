package iih.ci.ord.cirptlabhis.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cirptlabhis.d.CiRptLabHISDO;
import iih.ci.ord.cirptlabhis.d.CirptlabhisAggDO;

/**
* 检验报告单历史数据维护服务
*/
public interface ICirptlabhisCudService {
	/**
	*  检验报告单历史数据真删除
	*/
    public abstract void delete(CirptlabhisAggDO[] aggdos) throws BizException;
    
    /**
	*  检验报告单历史数据插入保存
	*/
	public abstract CirptlabhisAggDO[] insert(CirptlabhisAggDO[] aggdos) throws BizException;
	
    /**
	*  检验报告单历史数据保存
	*/
	public abstract CirptlabhisAggDO[] save(CirptlabhisAggDO[] aggdos) throws BizException;
	
    /**
	*  检验报告单历史数据更新
	*/
	public abstract CirptlabhisAggDO[] update(CirptlabhisAggDO[] aggdos) throws BizException;
	
	/**
	*  检验报告单历史数据逻辑删除
	*/
	public abstract void logicDelete(CirptlabhisAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对检验报告单历史数据真删除
	 */
	public abstract void deleteByParentDO(CiRptLabHISDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对检验报告单历史数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiRptLabHISDO[] mainDos) throws BizException;
}
