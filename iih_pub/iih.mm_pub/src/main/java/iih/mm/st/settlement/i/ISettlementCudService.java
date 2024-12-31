package iih.mm.st.settlement.i;

import xap.mw.core.data.BizException;
import iih.mm.st.settlement.d.SettlementDO;
import iih.mm.st.settlement.d.SettlementAggDO;

/**
* 采购结算数据维护服务
*/
public interface ISettlementCudService {
	/**
	*  采购结算数据真删除
	*/
    public abstract void delete(SettlementAggDO[] aggdos) throws BizException;
    
    /**
	*  采购结算数据插入保存
	*/
	public abstract SettlementAggDO[] insert(SettlementAggDO[] aggdos) throws BizException;
	
    /**
	*  采购结算数据保存
	*/
	public abstract SettlementAggDO[] save(SettlementAggDO[] aggdos) throws BizException;
	
    /**
	*  采购结算数据更新
	*/
	public abstract SettlementAggDO[] update(SettlementAggDO[] aggdos) throws BizException;
	
	/**
	*  采购结算数据逻辑删除
	*/
	public abstract void logicDelete(SettlementAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对采购结算数据真删除
	 */
	public abstract void deleteByParentDO(SettlementDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对采购结算数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SettlementDO[] mainDos) throws BizException;
}
