package iih.nm.nom.nomwkitmapp.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomwkitmapp.d.NomWkitmAppDO;
import iih.nm.nom.nomwkitmapp.d.NomwkitmappAggDO;

/**
* 护理工作项目数据录入数据维护服务
*/
public interface INomwkitmappCudService {
	/**
	*  护理工作项目数据录入数据真删除
	*/
    public abstract void delete(NomwkitmappAggDO[] aggdos) throws BizException;
    
    /**
	*  护理工作项目数据录入数据插入保存
	*/
	public abstract NomwkitmappAggDO[] insert(NomwkitmappAggDO[] aggdos) throws BizException;
	
    /**
	*  护理工作项目数据录入数据保存
	*/
	public abstract NomwkitmappAggDO[] save(NomwkitmappAggDO[] aggdos) throws BizException;
	
    /**
	*  护理工作项目数据录入数据更新
	*/
	public abstract NomwkitmappAggDO[] update(NomwkitmappAggDO[] aggdos) throws BizException;
	
	/**
	*  护理工作项目数据录入数据逻辑删除
	*/
	public abstract void logicDelete(NomwkitmappAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对护理工作项目数据录入数据真删除
	 */
	public abstract void deleteByParentDO(NomWkitmAppDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对护理工作项目数据录入数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NomWkitmAppDO[] mainDos) throws BizException;
}
