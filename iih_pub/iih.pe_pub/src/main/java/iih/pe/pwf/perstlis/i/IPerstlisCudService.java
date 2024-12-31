package iih.pe.pwf.perstlis.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.perstlis.d.PeRstLisDO;
import iih.pe.pwf.perstlis.d.PerstlisAggDO;

/**
* 体检检验报告数据维护服务
*/
public interface IPerstlisCudService {
	/**
	*  体检检验报告数据真删除
	*/
    public abstract void delete(PerstlisAggDO[] aggdos) throws BizException;
    
    /**
	*  体检检验报告数据插入保存
	*/
	public abstract PerstlisAggDO[] insert(PerstlisAggDO[] aggdos) throws BizException;
	
    /**
	*  体检检验报告数据保存
	*/
	public abstract PerstlisAggDO[] save(PerstlisAggDO[] aggdos) throws BizException;
	
    /**
	*  体检检验报告数据更新
	*/
	public abstract PerstlisAggDO[] update(PerstlisAggDO[] aggdos) throws BizException;
	
	/**
	*  体检检验报告数据逻辑删除
	*/
	public abstract void logicDelete(PerstlisAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检检验报告数据真删除
	 */
	public abstract void deleteByParentDO(PeRstLisDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检检验报告数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstLisDO[] mainDos) throws BizException;
}
