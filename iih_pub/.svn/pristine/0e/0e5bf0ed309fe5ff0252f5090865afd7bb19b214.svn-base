package iih.bd.pp.medinsurrecdiff.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.MedinsurrecdiffAggDO;

/**
* 医保记录差异数据维护服务
*/
public interface IMedinsurrecdiffCudService {
	/**
	*  医保记录差异数据真删除
	*/
    public abstract void delete(MedinsurrecdiffAggDO[] aggdos) throws BizException;
    
    /**
	*  医保记录差异数据插入保存
	*/
	public abstract MedinsurrecdiffAggDO[] insert(MedinsurrecdiffAggDO[] aggdos) throws BizException;
	
    /**
	*  医保记录差异数据保存
	*/
	public abstract MedinsurrecdiffAggDO[] save(MedinsurrecdiffAggDO[] aggdos) throws BizException;
	
    /**
	*  医保记录差异数据更新
	*/
	public abstract MedinsurrecdiffAggDO[] update(MedinsurrecdiffAggDO[] aggdos) throws BizException;
	
	/**
	*  医保记录差异数据逻辑删除
	*/
	public abstract void logicDelete(MedinsurrecdiffAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保记录差异数据真删除
	 */
	public abstract void deleteByParentDO(MedInsurRecDiffDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保记录差异数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MedInsurRecDiffDO[] mainDos) throws BizException;
}
