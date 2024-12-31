package iih.pe.phm.perstin.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.perstin.d.PeRstinDO;
import iih.pe.phm.perstin.d.PerstinAggDO;

/**
* 体检手工录入结果数据维护服务
*/
public interface IPerstinCudService {
	/**
	*  体检手工录入结果数据真删除
	*/
    public abstract void delete(PerstinAggDO[] aggdos) throws BizException;
    
    /**
	*  体检手工录入结果数据插入保存
	*/
	public abstract PerstinAggDO[] insert(PerstinAggDO[] aggdos) throws BizException;
	
    /**
	*  体检手工录入结果数据保存
	*/
	public abstract PerstinAggDO[] save(PerstinAggDO[] aggdos) throws BizException;
	
    /**
	*  体检手工录入结果数据更新
	*/
	public abstract PerstinAggDO[] update(PerstinAggDO[] aggdos) throws BizException;
	
	/**
	*  体检手工录入结果数据逻辑删除
	*/
	public abstract void logicDelete(PerstinAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检手工录入结果数据真删除
	 */
	public abstract void deleteByParentDO(PeRstinDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检手工录入结果数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstinDO[] mainDos) throws BizException;
}
