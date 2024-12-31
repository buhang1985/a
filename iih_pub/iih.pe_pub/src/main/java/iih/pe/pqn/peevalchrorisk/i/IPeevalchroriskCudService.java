package iih.pe.pqn.peevalchrorisk.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalchrorisk.d.PeChroRiskDO;
import iih.pe.pqn.peevalchrorisk.d.PeevalchroriskAggDO;

/**
* 体检慢病风险因素数据维护服务
*/
public interface IPeevalchroriskCudService {
	/**
	*  体检慢病风险因素数据真删除
	*/
    public abstract void delete(PeevalchroriskAggDO[] aggdos) throws BizException;
    
    /**
	*  体检慢病风险因素数据插入保存
	*/
	public abstract PeevalchroriskAggDO[] insert(PeevalchroriskAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢病风险因素数据保存
	*/
	public abstract PeevalchroriskAggDO[] save(PeevalchroriskAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢病风险因素数据更新
	*/
	public abstract PeevalchroriskAggDO[] update(PeevalchroriskAggDO[] aggdos) throws BizException;
	
	/**
	*  体检慢病风险因素数据逻辑删除
	*/
	public abstract void logicDelete(PeevalchroriskAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检慢病风险因素数据真删除
	 */
	public abstract void deleteByParentDO(PeChroRiskDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检慢病风险因素数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeChroRiskDO[] mainDos) throws BizException;
}
