package iih.pe.phm.petcmconstcaeval.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.petcmconstcaeval.d.PeTCMConDO;
import iih.pe.phm.petcmconstcaeval.d.PetcmconstcaevalAggDO;

/**
* 体检中医体质评估数据维护服务
*/
public interface IPetcmconstcaevalCudService {
	/**
	*  体检中医体质评估数据真删除
	*/
    public abstract void delete(PetcmconstcaevalAggDO[] aggdos) throws BizException;
    
    /**
	*  体检中医体质评估数据插入保存
	*/
	public abstract PetcmconstcaevalAggDO[] insert(PetcmconstcaevalAggDO[] aggdos) throws BizException;
	
    /**
	*  体检中医体质评估数据保存
	*/
	public abstract PetcmconstcaevalAggDO[] save(PetcmconstcaevalAggDO[] aggdos) throws BizException;
	
    /**
	*  体检中医体质评估数据更新
	*/
	public abstract PetcmconstcaevalAggDO[] update(PetcmconstcaevalAggDO[] aggdos) throws BizException;
	
	/**
	*  体检中医体质评估数据逻辑删除
	*/
	public abstract void logicDelete(PetcmconstcaevalAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检中医体质评估数据真删除
	 */
	public abstract void deleteByParentDO(PeTCMConDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检中医体质评估数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeTCMConDO[] mainDos) throws BizException;
}
