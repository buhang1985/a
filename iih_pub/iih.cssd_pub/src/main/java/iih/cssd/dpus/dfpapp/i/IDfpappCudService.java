package iih.cssd.dpus.dfpapp.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfpapp.d.DfpAppDO;
import iih.cssd.dpus.dfpapp.d.DfpappAggDO;

/**
* 请领消毒包数据维护服务
*/
public interface IDfpappCudService {
	/**
	*  请领消毒包数据真删除
	*/
    public abstract void delete(DfpappAggDO[] aggdos) throws BizException;
    
    /**
	*  请领消毒包数据插入保存
	*/
	public abstract DfpappAggDO[] insert(DfpappAggDO[] aggdos) throws BizException;
	
    /**
	*  请领消毒包数据保存
	*/
	public abstract DfpappAggDO[] save(DfpappAggDO[] aggdos) throws BizException;
	
    /**
	*  请领消毒包数据更新
	*/
	public abstract DfpappAggDO[] update(DfpappAggDO[] aggdos) throws BizException;
	
	/**
	*  请领消毒包数据逻辑删除
	*/
	public abstract void logicDelete(DfpappAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对请领消毒包数据真删除
	 */
	public abstract void deleteByParentDO(DfpAppDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对请领消毒包数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DfpAppDO[] mainDos) throws BizException;
}
