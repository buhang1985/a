package iih.mc.st.trreqapimpl.i;

import xap.mw.core.data.BizException;
import iih.mc.st.trreqapimpl.d.McTrReqApImplDO;
import iih.mc.st.trreqapimpl.d.TrreqapimplAggDO;

/**
* 调拨单数据维护服务
*/
public interface ITrreqapimplCudService {
	/**
	*  调拨单数据真删除
	*/
    public abstract void delete(TrreqapimplAggDO[] aggdos) throws BizException;
    
    /**
	*  调拨单数据插入保存
	*/
	public abstract TrreqapimplAggDO[] insert(TrreqapimplAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨单数据保存
	*/
	public abstract TrreqapimplAggDO[] save(TrreqapimplAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨单数据更新
	*/
	public abstract TrreqapimplAggDO[] update(TrreqapimplAggDO[] aggdos) throws BizException;
	
	/**
	*  调拨单数据逻辑删除
	*/
	public abstract void logicDelete(TrreqapimplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对调拨单数据真删除
	 */
	public abstract void deleteByParentDO(McTrReqApImplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对调拨单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McTrReqApImplDO[] mainDos) throws BizException;
}
