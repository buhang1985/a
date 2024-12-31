package iih.syn.common.unittrg.i;

import xap.mw.core.data.BizException;
import iih.syn.common.unittrg.d.SynUnitTrgDO;
import iih.syn.common.unittrg.d.UnittrgAggDO;

/**
* 数据同步目标数据维护服务
*/
public interface IUnittrgCudService {
	/**
	*  数据同步目标数据真删除
	*/
    public abstract void delete(UnittrgAggDO[] aggdos) throws BizException;
    
    /**
	*  数据同步目标数据插入保存
	*/
	public abstract UnittrgAggDO[] insert(UnittrgAggDO[] aggdos) throws BizException;
	
    /**
	*  数据同步目标数据保存
	*/
	public abstract UnittrgAggDO[] save(UnittrgAggDO[] aggdos) throws BizException;
	
    /**
	*  数据同步目标数据更新
	*/
	public abstract UnittrgAggDO[] update(UnittrgAggDO[] aggdos) throws BizException;
	
	/**
	*  数据同步目标数据逻辑删除
	*/
	public abstract void logicDelete(UnittrgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对数据同步目标数据真删除
	 */
	public abstract void deleteByParentDO(SynUnitTrgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对数据同步目标数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SynUnitTrgDO[] mainDos) throws BizException;
}
