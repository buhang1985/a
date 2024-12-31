package iih.syn.common.userinit.i;

import xap.mw.core.data.BizException;
import iih.syn.common.userinit.d.SynUserInitDO;
import iih.syn.common.userinit.d.UserinitAggDO;

/**
* 用户同步初始化数据维护服务
*/
public interface IUserinitCudService {
	/**
	*  用户同步初始化数据真删除
	*/
    public abstract void delete(UserinitAggDO[] aggdos) throws BizException;
    
    /**
	*  用户同步初始化数据插入保存
	*/
	public abstract UserinitAggDO[] insert(UserinitAggDO[] aggdos) throws BizException;
	
    /**
	*  用户同步初始化数据保存
	*/
	public abstract UserinitAggDO[] save(UserinitAggDO[] aggdos) throws BizException;
	
    /**
	*  用户同步初始化数据更新
	*/
	public abstract UserinitAggDO[] update(UserinitAggDO[] aggdos) throws BizException;
	
	/**
	*  用户同步初始化数据逻辑删除
	*/
	public abstract void logicDelete(UserinitAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对用户同步初始化数据真删除
	 */
	public abstract void deleteByParentDO(SynUserInitDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对用户同步初始化数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SynUserInitDO[] mainDos) throws BizException;
}
