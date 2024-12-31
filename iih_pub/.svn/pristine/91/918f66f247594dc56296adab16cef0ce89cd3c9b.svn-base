package iih.cssd.dpus.dfprecy.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfprecy.d.DfpRecyDo;
import iih.cssd.dpus.dfprecy.d.DfprecyAggDO;

/**
* 消毒包回收数据维护服务
*/
public interface IDfprecyCudService {
	/**
	*  消毒包回收数据真删除
	*/
    public abstract void delete(DfprecyAggDO[] aggdos) throws BizException;
    
    /**
	*  消毒包回收数据插入保存
	*/
	public abstract DfprecyAggDO[] insert(DfprecyAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包回收数据保存
	*/
	public abstract DfprecyAggDO[] save(DfprecyAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包回收数据更新
	*/
	public abstract DfprecyAggDO[] update(DfprecyAggDO[] aggdos) throws BizException;
	
	/**
	*  消毒包回收数据逻辑删除
	*/
	public abstract void logicDelete(DfprecyAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对消毒包回收数据真删除
	 */
	public abstract void deleteByParentDO(DfpRecyDo[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对消毒包回收数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DfpRecyDo[] mainDos) throws BizException;
}
