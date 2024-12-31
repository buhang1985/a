package iih.nm.nom.nmnomwbkconfig.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nmnomwbkconfig.d.NmNomWbkConfigDO;
import iih.nm.nom.nmnomwbkconfig.d.NmnomwbkconfigAggDO;

/**
* 护士长手册配置数据维护服务
*/
public interface INmnomwbkconfigCudService {
	/**
	*  护士长手册配置数据真删除
	*/
    public abstract void delete(NmnomwbkconfigAggDO[] aggdos) throws BizException;
    
    /**
	*  护士长手册配置数据插入保存
	*/
	public abstract NmnomwbkconfigAggDO[] insert(NmnomwbkconfigAggDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册配置数据保存
	*/
	public abstract NmnomwbkconfigAggDO[] save(NmnomwbkconfigAggDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册配置数据更新
	*/
	public abstract NmnomwbkconfigAggDO[] update(NmnomwbkconfigAggDO[] aggdos) throws BizException;
	
	/**
	*  护士长手册配置数据逻辑删除
	*/
	public abstract void logicDelete(NmnomwbkconfigAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护士长手册配置数据真删除
	 */
	public abstract void deleteByParentDO(NmNomWbkConfigDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护士长手册配置数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNomWbkConfigDO[] mainDos) throws BizException;
}
