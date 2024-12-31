package iih.pe.phm.petcmhealth.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.petcmhealth.d.PeTCMHealthTpDO;
import iih.pe.phm.petcmhealth.d.PetcmhealthAggDO;

/**
* 体检中医养生数据维护服务
*/
public interface IPetcmhealthCudService {
	/**
	*  体检中医养生数据真删除
	*/
    public abstract void delete(PetcmhealthAggDO[] aggdos) throws BizException;
    
    /**
	*  体检中医养生数据插入保存
	*/
	public abstract PetcmhealthAggDO[] insert(PetcmhealthAggDO[] aggdos) throws BizException;
	
    /**
	*  体检中医养生数据保存
	*/
	public abstract PetcmhealthAggDO[] save(PetcmhealthAggDO[] aggdos) throws BizException;
	
    /**
	*  体检中医养生数据更新
	*/
	public abstract PetcmhealthAggDO[] update(PetcmhealthAggDO[] aggdos) throws BizException;
	
	/**
	*  体检中医养生数据逻辑删除
	*/
	public abstract void logicDelete(PetcmhealthAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检中医养生数据真删除
	 */
	public abstract void deleteByParentDO(PeTCMHealthTpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检中医养生数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeTCMHealthTpDO[] mainDos) throws BizException;
}
