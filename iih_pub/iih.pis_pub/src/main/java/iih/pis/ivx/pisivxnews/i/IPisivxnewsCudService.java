package iih.pis.ivx.pisivxnews.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxnews.d.PisivxNewsDO;
import iih.pis.ivx.pisivxnews.d.PisivxnewsAggDO;

/**
* 微信服务-新闻服务数据维护服务
*/
public interface IPisivxnewsCudService {
	/**
	*  微信服务-新闻服务数据真删除
	*/
    public abstract void delete(PisivxnewsAggDO[] aggdos) throws BizException;
    
    /**
	*  微信服务-新闻服务数据插入保存
	*/
	public abstract PisivxnewsAggDO[] insert(PisivxnewsAggDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-新闻服务数据保存
	*/
	public abstract PisivxnewsAggDO[] save(PisivxnewsAggDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-新闻服务数据更新
	*/
	public abstract PisivxnewsAggDO[] update(PisivxnewsAggDO[] aggdos) throws BizException;
	
	/**
	*  微信服务-新闻服务数据逻辑删除
	*/
	public abstract void logicDelete(PisivxnewsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对微信服务-新闻服务数据真删除
	 */
	public abstract void deleteByParentDO(PisivxNewsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对微信服务-新闻服务数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PisivxNewsDO[] mainDos) throws BizException;
}
