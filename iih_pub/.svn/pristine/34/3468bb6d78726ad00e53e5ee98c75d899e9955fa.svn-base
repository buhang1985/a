package iih.bd.srv.mrtplvst.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.bd.srv.mrtplvst.d.MrtplvstAggDO;

/**
* 生命体征模版数据维护服务
*/
public interface IMrtplvstCudService {
	/**
	*  生命体征模版数据真删除
	*/
    public abstract void delete(MrtplvstAggDO[] aggdos) throws BizException;
    
    /**
	*  生命体征模版数据插入保存
	*/
	public abstract MrtplvstAggDO[] insert(MrtplvstAggDO[] aggdos) throws BizException;
	
    /**
	*  生命体征模版数据保存
	*/
	public abstract MrtplvstAggDO[] save(MrtplvstAggDO[] aggdos) throws BizException;
	
    /**
	*  生命体征模版数据更新
	*/
	public abstract MrtplvstAggDO[] update(MrtplvstAggDO[] aggdos) throws BizException;
	
	/**
	*  生命体征模版数据逻辑删除
	*/
	public abstract void logicDelete(MrtplvstAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对生命体征模版数据真删除
	 */
	public abstract void deleteByParentDO(BdMrtplVstDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对生命体征模版数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdMrtplVstDO[] mainDos) throws BizException;
}
