package iih.mc.pl.trrequestap.i;

import xap.mw.core.data.BizException;
import iih.mc.pl.trrequestap.d.McTrReqApOrderDO;
import iih.mc.pl.trrequestap.d.TrrequestapAggDO;

/**
* 调拨申请单数据维护服务
*/
public interface ITrrequestapCudService {
	/**
	*  调拨申请单数据真删除
	*/
    public abstract void delete(TrrequestapAggDO[] aggdos) throws BizException;
    
    /**
	*  调拨申请单数据插入保存
	*/
	public abstract TrrequestapAggDO[] insert(TrrequestapAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨申请单数据保存
	*/
	public abstract TrrequestapAggDO[] save(TrrequestapAggDO[] aggdos) throws BizException;
	
    /**
	*  调拨申请单数据更新
	*/
	public abstract TrrequestapAggDO[] update(TrrequestapAggDO[] aggdos) throws BizException;
	
	/**
	*  调拨申请单数据逻辑删除
	*/
	public abstract void logicDelete(TrrequestapAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对调拨申请单数据真删除
	 */
	public abstract void deleteByParentDO(McTrReqApOrderDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对调拨申请单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McTrReqApOrderDO[] mainDos) throws BizException;
}
