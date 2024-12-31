package iih.bd.srv.mrtplvs.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplvs.d.BdMrtplVsDO;
import iih.bd.srv.mrtplvs.d.MrtplvsAggDO;

/**
* 生命体征项数据维护服务
*/
public interface IMrtplvsCudService {
	/**
	*  生命体征项数据真删除
	*/
    public abstract void delete(MrtplvsAggDO[] aggdos) throws BizException;
    
    /**
	*  生命体征项数据插入保存
	*/
	public abstract MrtplvsAggDO[] insert(MrtplvsAggDO[] aggdos) throws BizException;
	
    /**
	*  生命体征项数据保存
	*/
	public abstract MrtplvsAggDO[] save(MrtplvsAggDO[] aggdos) throws BizException;
	
    /**
	*  生命体征项数据更新
	*/
	public abstract MrtplvsAggDO[] update(MrtplvsAggDO[] aggdos) throws BizException;
	
	/**
	*  生命体征项数据逻辑删除
	*/
	public abstract void logicDelete(MrtplvsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对生命体征项数据真删除
	 */
	public abstract void deleteByParentDO(BdMrtplVsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对生命体征项数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdMrtplVsDO[] mainDos) throws BizException;
}
