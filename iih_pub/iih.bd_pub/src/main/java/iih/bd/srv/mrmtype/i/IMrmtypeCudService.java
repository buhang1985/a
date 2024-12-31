package iih.bd.srv.mrmtype.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.d.MrmtypeAggDO;

/**
* 病案分类数据维护服务
*/
public interface IMrmtypeCudService {
	/**
	*  病案分类数据真删除
	*/
    public abstract void delete(MrmtypeAggDO[] aggdos) throws BizException;
    
    /**
	*  病案分类数据插入保存
	*/
	public abstract MrmtypeAggDO[] insert(MrmtypeAggDO[] aggdos) throws BizException;
	
    /**
	*  病案分类数据保存
	*/
	public abstract MrmtypeAggDO[] save(MrmtypeAggDO[] aggdos) throws BizException;
	
    /**
	*  病案分类数据更新
	*/
	public abstract MrmtypeAggDO[] update(MrmtypeAggDO[] aggdos) throws BizException;
	
	/**
	*  病案分类数据逻辑删除
	*/
	public abstract void logicDelete(MrmtypeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病案分类数据真删除
	 */
	public abstract void deleteByParentDO(MrmTypeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病案分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MrmTypeDO[] mainDos) throws BizException;
}
