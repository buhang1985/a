package iih.cssd.dpus.dfpuse.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfpuse.d.DfpUseDo;
import iih.cssd.dpus.dfpuse.d.DfpuseAggDO;

/**
* 消毒包使用数据维护服务
*/
public interface IDfpuseCudService {
	/**
	*  消毒包使用数据真删除
	*/
    public abstract void delete(DfpuseAggDO[] aggdos) throws BizException;
    
    /**
	*  消毒包使用数据插入保存
	*/
	public abstract DfpuseAggDO[] insert(DfpuseAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包使用数据保存
	*/
	public abstract DfpuseAggDO[] save(DfpuseAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包使用数据更新
	*/
	public abstract DfpuseAggDO[] update(DfpuseAggDO[] aggdos) throws BizException;
	
	/**
	*  消毒包使用数据逻辑删除
	*/
	public abstract void logicDelete(DfpuseAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对消毒包使用数据真删除
	 */
	public abstract void deleteByParentDO(DfpUseDo[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对消毒包使用数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DfpUseDo[] mainDos) throws BizException;
}
