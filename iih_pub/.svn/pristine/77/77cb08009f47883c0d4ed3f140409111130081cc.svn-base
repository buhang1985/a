package iih.sfda.adbd.abdbconfig.i;

import xap.mw.core.data.BizException;
import iih.sfda.adbd.abdbconfig.d.AdbdConfigDO;
import iih.sfda.adbd.abdbconfig.d.AbdbconfigAggDO;

/**
* 事件处理流程配置数据维护服务
*/
public interface IAbdbconfigCudService {
	/**
	*  事件处理流程配置数据真删除
	*/
    public abstract void delete(AbdbconfigAggDO[] aggdos) throws BizException;
    
    /**
	*  事件处理流程配置数据插入保存
	*/
	public abstract AbdbconfigAggDO[] insert(AbdbconfigAggDO[] aggdos) throws BizException;
	
    /**
	*  事件处理流程配置数据保存
	*/
	public abstract AbdbconfigAggDO[] save(AbdbconfigAggDO[] aggdos) throws BizException;
	
    /**
	*  事件处理流程配置数据更新
	*/
	public abstract AbdbconfigAggDO[] update(AbdbconfigAggDO[] aggdos) throws BizException;
	
	/**
	*  事件处理流程配置数据逻辑删除
	*/
	public abstract void logicDelete(AbdbconfigAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对事件处理流程配置数据真删除
	 */
	public abstract void deleteByParentDO(AdbdConfigDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对事件处理流程配置数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AdbdConfigDO[] mainDos) throws BizException;
}
