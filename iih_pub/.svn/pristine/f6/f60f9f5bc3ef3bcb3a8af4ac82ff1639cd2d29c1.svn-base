package iih.syn.common.init.i;

import xap.mw.core.data.BizException;
import iih.syn.common.init.d.SynInitDO;
import iih.syn.common.init.d.InitAggDO;

/**
* 基础数据初始化数据维护服务
*/
public interface IInitCudService {
	/**
	*  基础数据初始化数据真删除
	*/
    public abstract void delete(InitAggDO[] aggdos) throws BizException;
    
    /**
	*  基础数据初始化数据插入保存
	*/
	public abstract InitAggDO[] insert(InitAggDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据保存
	*/
	public abstract InitAggDO[] save(InitAggDO[] aggdos) throws BizException;
	
    /**
	*  基础数据初始化数据更新
	*/
	public abstract InitAggDO[] update(InitAggDO[] aggdos) throws BizException;
	
	/**
	*  基础数据初始化数据逻辑删除
	*/
	public abstract void logicDelete(InitAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对基础数据初始化数据真删除
	 */
	public abstract void deleteByParentDO(SynInitDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对基础数据初始化数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SynInitDO[] mainDos) throws BizException;
}
