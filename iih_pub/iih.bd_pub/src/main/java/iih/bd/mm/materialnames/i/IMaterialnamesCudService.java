package iih.bd.mm.materialnames.i;

import xap.mw.core.data.BizException;
import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.MaterialnamesAggDO;

/**
* 药品通用名目录数据维护服务
*/
public interface IMaterialnamesCudService {
	/**
	*  药品通用名目录数据真删除
	*/
    public abstract void delete(MaterialnamesAggDO[] aggdos) throws BizException;
    
    /**
	*  药品通用名目录数据插入保存
	*/
	public abstract MaterialnamesAggDO[] insert(MaterialnamesAggDO[] aggdos) throws BizException;
	
    /**
	*  药品通用名目录数据保存
	*/
	public abstract MaterialnamesAggDO[] save(MaterialnamesAggDO[] aggdos) throws BizException;
	
    /**
	*  药品通用名目录数据更新
	*/
	public abstract MaterialnamesAggDO[] update(MaterialnamesAggDO[] aggdos) throws BizException;
	
	/**
	*  药品通用名目录数据逻辑删除
	*/
	public abstract void logicDelete(MaterialnamesAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对药品通用名目录数据真删除
	 */
	public abstract void deleteByParentDO(MaterialNamesDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对药品通用名目录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MaterialNamesDO[] mainDos) throws BizException;
}
