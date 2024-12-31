package iih.bl.st.blpaypatip.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;

/**
* 住院患者结算收付款数据维护服务
*/
public interface IBlpaypatipCudService {
	/**
	*  住院患者结算收付款数据真删除
	*/
    public abstract void delete(BlpaypatipAggDO[] aggdos) throws BizException;
    
    /**
	*  住院患者结算收付款数据插入保存
	*/
	public abstract BlpaypatipAggDO[] insert(BlpaypatipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院患者结算收付款数据保存
	*/
	public abstract BlpaypatipAggDO[] save(BlpaypatipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院患者结算收付款数据更新
	*/
	public abstract BlpaypatipAggDO[] update(BlpaypatipAggDO[] aggdos) throws BizException;
	
	/**
	*  住院患者结算收付款数据逻辑删除
	*/
	public abstract void logicDelete(BlpaypatipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对住院患者结算收付款数据真删除
	 */
	public abstract void deleteByParentDO(BlPayPatIpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对住院患者结算收付款数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlPayPatIpDO[] mainDos) throws BizException;
}
