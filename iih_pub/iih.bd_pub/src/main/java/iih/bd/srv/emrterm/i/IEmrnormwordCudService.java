package iih.bd.srv.emrterm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrterm.d.EmrNormWordCaDO;
import iih.bd.srv.emrterm.d.EmrnormwordAggDO;

/**
* 病历常用词分类数据维护服务
*/
public interface IEmrnormwordCudService {
	/**
	*  病历常用词分类数据真删除
	*/
    public abstract void delete(EmrnormwordAggDO[] aggdos) throws BizException;
    
    /**
	*  病历常用词分类数据插入保存
	*/
	public abstract EmrnormwordAggDO[] insert(EmrnormwordAggDO[] aggdos) throws BizException;
	
    /**
	*  病历常用词分类数据保存
	*/
	public abstract EmrnormwordAggDO[] save(EmrnormwordAggDO[] aggdos) throws BizException;
	
    /**
	*  病历常用词分类数据更新
	*/
	public abstract EmrnormwordAggDO[] update(EmrnormwordAggDO[] aggdos) throws BizException;
	
	/**
	*  病历常用词分类数据逻辑删除
	*/
	public abstract void logicDelete(EmrnormwordAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病历常用词分类数据真删除
	 */
	public abstract void deleteByParentDO(EmrNormWordCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病历常用词分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmrNormWordCaDO[] mainDos) throws BizException;
}
