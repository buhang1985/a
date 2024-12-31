package iih.pe.pds.pedsdiag.i;

import xap.mw.core.data.BizException;
import iih.pe.pds.pedsdiag.d.PeDsDiagDefDO;
import iih.pe.pds.pedsdiag.d.PedsdiagAggDO;

/**
* 体检诊断决策支持数据维护服务
*/
public interface IPedsdiagCudService {
	/**
	*  体检诊断决策支持数据真删除
	*/
    public abstract void delete(PedsdiagAggDO[] aggdos) throws BizException;
    
    /**
	*  体检诊断决策支持数据插入保存
	*/
	public abstract PedsdiagAggDO[] insert(PedsdiagAggDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断决策支持数据保存
	*/
	public abstract PedsdiagAggDO[] save(PedsdiagAggDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断决策支持数据更新
	*/
	public abstract PedsdiagAggDO[] update(PedsdiagAggDO[] aggdos) throws BizException;
	
	/**
	*  体检诊断决策支持数据逻辑删除
	*/
	public abstract void logicDelete(PedsdiagAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检诊断决策支持数据真删除
	 */
	public abstract void deleteByParentDO(PeDsDiagDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检诊断决策支持数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeDsDiagDefDO[] mainDos) throws BizException;
}
