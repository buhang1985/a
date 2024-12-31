package iih.pe.pitm.peitflisitm.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.peitflisitm.d.PeItfLisPartDO;
import iih.pe.pitm.peitflisitm.d.PeitflisitmAggDO;

/**
* 体检接口_LIS明细数据维护服务
*/
public interface IPeitflisitmCudService {
	/**
	*  体检接口_LIS明细数据真删除
	*/
    public abstract void delete(PeitflisitmAggDO[] aggdos) throws BizException;
    
    /**
	*  体检接口_LIS明细数据插入保存
	*/
	public abstract PeitflisitmAggDO[] insert(PeitflisitmAggDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS明细数据保存
	*/
	public abstract PeitflisitmAggDO[] save(PeitflisitmAggDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS明细数据更新
	*/
	public abstract PeitflisitmAggDO[] update(PeitflisitmAggDO[] aggdos) throws BizException;
	
	/**
	*  体检接口_LIS明细数据逻辑删除
	*/
	public abstract void logicDelete(PeitflisitmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检接口_LIS明细数据真删除
	 */
	public abstract void deleteByParentDO(PeItfLisPartDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检接口_LIS明细数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeItfLisPartDO[] mainDos) throws BizException;
}
