package iih.nm.nom.nmnomwbkitm.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nmnomwbkitm.d.NmNomWbkCaDO;
import iih.nm.nom.nmnomwbkitm.d.NmnomwbkitmAggDO;

/**
* 护士长手册模板数据维护服务
*/
public interface INmnomwbkitmCudService {
	/**
	*  护士长手册模板数据真删除
	*/
    public abstract void delete(NmnomwbkitmAggDO[] aggdos) throws BizException;
    
    /**
	*  护士长手册模板数据插入保存
	*/
	public abstract NmnomwbkitmAggDO[] insert(NmnomwbkitmAggDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册模板数据保存
	*/
	public abstract NmnomwbkitmAggDO[] save(NmnomwbkitmAggDO[] aggdos) throws BizException;
	
    /**
	*  护士长手册模板数据更新
	*/
	public abstract NmnomwbkitmAggDO[] update(NmnomwbkitmAggDO[] aggdos) throws BizException;
	
	/**
	*  护士长手册模板数据逻辑删除
	*/
	public abstract void logicDelete(NmnomwbkitmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护士长手册模板数据真删除
	 */
	public abstract void deleteByParentDO(NmNomWbkCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护士长手册模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNomWbkCaDO[] mainDos) throws BizException;
}
