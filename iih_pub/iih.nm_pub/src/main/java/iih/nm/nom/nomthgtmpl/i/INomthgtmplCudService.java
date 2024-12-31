package iih.nm.nom.nomthgtmpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nomthgtmpl.d.NomThgTmplCaDO;
import iih.nm.nom.nomthgtmpl.d.NomthgtmplAggDO;

/**
* 病区事物记录模板数据维护服务
*/
public interface INomthgtmplCudService {
	/**
	*  病区事物记录模板数据真删除
	*/
    public abstract void delete(NomthgtmplAggDO[] aggdos) throws BizException;
    
    /**
	*  病区事物记录模板数据插入保存
	*/
	public abstract NomthgtmplAggDO[] insert(NomthgtmplAggDO[] aggdos) throws BizException;
	
    /**
	*  病区事物记录模板数据保存
	*/
	public abstract NomthgtmplAggDO[] save(NomthgtmplAggDO[] aggdos) throws BizException;
	
    /**
	*  病区事物记录模板数据更新
	*/
	public abstract NomthgtmplAggDO[] update(NomthgtmplAggDO[] aggdos) throws BizException;
	
	/**
	*  病区事物记录模板数据逻辑删除
	*/
	public abstract void logicDelete(NomthgtmplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病区事物记录模板数据真删除
	 */
	public abstract void deleteByParentDO(NomThgTmplCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病区事物记录模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NomThgTmplCaDO[] mainDos) throws BizException;
}
