package iih.syn.common.syninitapp.i;

import xap.mw.core.data.BizException;
import iih.syn.common.syninitapp.d.SynInitAppDO;
import iih.syn.common.syninitapp.d.SyninitappAggDO;

/**
* 数据初始化申请数据维护服务
*/
public interface ISyninitappCudService {
	/**
	*  数据初始化申请数据真删除
	*/
    public abstract void delete(SyninitappAggDO[] aggdos) throws BizException;
    
    /**
	*  数据初始化申请数据插入保存
	*/
	public abstract SyninitappAggDO[] insert(SyninitappAggDO[] aggdos) throws BizException;
	
    /**
	*  数据初始化申请数据保存
	*/
	public abstract SyninitappAggDO[] save(SyninitappAggDO[] aggdos) throws BizException;
	
    /**
	*  数据初始化申请数据更新
	*/
	public abstract SyninitappAggDO[] update(SyninitappAggDO[] aggdos) throws BizException;
	
	/**
	*  数据初始化申请数据逻辑删除
	*/
	public abstract void logicDelete(SyninitappAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对数据初始化申请数据真删除
	 */
	public abstract void deleteByParentDO(SynInitAppDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对数据初始化申请数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SynInitAppDO[] mainDos) throws BizException;
}
