package iih.pe.pwf.perstmor.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.perstmor.d.PeRstMorDO;
import iih.pe.pwf.perstmor.d.PerstmorAggDO;

/**
* 体检形态学报告数据维护服务
*/
public interface IPerstmorCudService {
	/**
	*  体检形态学报告数据真删除
	*/
    public abstract void delete(PerstmorAggDO[] aggdos) throws BizException;
    
    /**
	*  体检形态学报告数据插入保存
	*/
	public abstract PerstmorAggDO[] insert(PerstmorAggDO[] aggdos) throws BizException;
	
    /**
	*  体检形态学报告数据保存
	*/
	public abstract PerstmorAggDO[] save(PerstmorAggDO[] aggdos) throws BizException;
	
    /**
	*  体检形态学报告数据更新
	*/
	public abstract PerstmorAggDO[] update(PerstmorAggDO[] aggdos) throws BizException;
	
	/**
	*  体检形态学报告数据逻辑删除
	*/
	public abstract void logicDelete(PerstmorAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检形态学报告数据真删除
	 */
	public abstract void deleteByParentDO(PeRstMorDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检形态学报告数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstMorDO[] mainDos) throws BizException;
}
