package iih.pe.pwf.perstdiagsugg.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.perstdiagsugg.d.PeRstDiagSuggDO;
import iih.pe.pwf.perstdiagsugg.d.PerstdiagsuggAggDO;

/**
* 体检结果诊断建议数据维护服务
*/
public interface IPerstdiagsuggCudService {
	/**
	*  体检结果诊断建议数据真删除
	*/
    public abstract void delete(PerstdiagsuggAggDO[] aggdos) throws BizException;
    
    /**
	*  体检结果诊断建议数据插入保存
	*/
	public abstract PerstdiagsuggAggDO[] insert(PerstdiagsuggAggDO[] aggdos) throws BizException;
	
    /**
	*  体检结果诊断建议数据保存
	*/
	public abstract PerstdiagsuggAggDO[] save(PerstdiagsuggAggDO[] aggdos) throws BizException;
	
    /**
	*  体检结果诊断建议数据更新
	*/
	public abstract PerstdiagsuggAggDO[] update(PerstdiagsuggAggDO[] aggdos) throws BizException;
	
	/**
	*  体检结果诊断建议数据逻辑删除
	*/
	public abstract void logicDelete(PerstdiagsuggAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检结果诊断建议数据真删除
	 */
	public abstract void deleteByParentDO(PeRstDiagSuggDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检结果诊断建议数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstDiagSuggDO[] mainDos) throws BizException;
}
