package iih.pe.pbd.qrycond.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.qrycond.d.QryCondDO;
import iih.pe.pbd.qrycond.d.QrycondAggDO;

/**
* 查询条件数据维护服务
*/
public interface IQrycondCudService {
	/**
	*  查询条件数据真删除
	*/
    public abstract void delete(QrycondAggDO[] aggdos) throws BizException;
    
    /**
	*  查询条件数据插入保存
	*/
	public abstract QrycondAggDO[] insert(QrycondAggDO[] aggdos) throws BizException;
	
    /**
	*  查询条件数据保存
	*/
	public abstract QrycondAggDO[] save(QrycondAggDO[] aggdos) throws BizException;
	
    /**
	*  查询条件数据更新
	*/
	public abstract QrycondAggDO[] update(QrycondAggDO[] aggdos) throws BizException;
	
	/**
	*  查询条件数据逻辑删除
	*/
	public abstract void logicDelete(QrycondAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对查询条件数据真删除
	 */
	public abstract void deleteByParentDO(QryCondDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对查询条件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(QryCondDO[] mainDos) throws BizException;
}
