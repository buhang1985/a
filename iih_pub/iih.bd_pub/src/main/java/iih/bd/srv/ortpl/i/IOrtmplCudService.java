package iih.bd.srv.ortpl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrtmplAggDO;

/**
* 医嘱模板数据维护服务
*/
public interface IOrtmplCudService {
	/**
	*  医嘱模板数据真删除
	*/
    public abstract void delete(OrtmplAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱模板数据插入保存
	*/
	public abstract OrtmplAggDO[] insert(OrtmplAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱模板数据保存
	*/
	public abstract OrtmplAggDO[] save(OrtmplAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱模板数据更新
	*/
	public abstract OrtmplAggDO[] update(OrtmplAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱模板数据逻辑删除
	*/
	public abstract void logicDelete(OrtmplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医嘱模板数据真删除
	 */
	public abstract void deleteByParentDO(OrTmplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医嘱模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OrTmplDO[] mainDos) throws BizException;
}
