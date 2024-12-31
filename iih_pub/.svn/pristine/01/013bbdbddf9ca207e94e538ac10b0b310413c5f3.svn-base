package iih.bd.srv.emrterm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.emrterm.d.EmrtermcaAggDO;

/**
* 病历术语分类数据维护服务
*/
public interface IEmrtermcaCudService {
	/**
	*  病历术语分类数据真删除
	*/
    public abstract void delete(EmrtermcaAggDO[] aggdos) throws BizException;
    
    /**
	*  病历术语分类数据插入保存
	*/
	public abstract EmrtermcaAggDO[] insert(EmrtermcaAggDO[] aggdos) throws BizException;
	
    /**
	*  病历术语分类数据保存
	*/
	public abstract EmrtermcaAggDO[] save(EmrtermcaAggDO[] aggdos) throws BizException;
	
    /**
	*  病历术语分类数据更新
	*/
	public abstract EmrtermcaAggDO[] update(EmrtermcaAggDO[] aggdos) throws BizException;
	
	/**
	*  病历术语分类数据逻辑删除
	*/
	public abstract void logicDelete(EmrtermcaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病历术语分类数据真删除
	 */
	public abstract void deleteByParentDO(EmrTermCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病历术语分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmrTermCaDO[] mainDos) throws BizException;
}
