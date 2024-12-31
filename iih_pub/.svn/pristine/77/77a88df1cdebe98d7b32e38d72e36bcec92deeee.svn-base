package iih.mkr.ms.mscacust.i;

import xap.mw.core.data.BizException;
import iih.mkr.ms.mscacust.d.MkrMscaCtmDO;
import iih.mkr.ms.mscacust.d.MscacustAggDO;

/**
* 组套自定义分类数据维护服务
*/
public interface IMscacustCudService {
	/**
	*  组套自定义分类数据真删除
	*/
    public abstract void delete(MscacustAggDO[] aggdos) throws BizException;
    
    /**
	*  组套自定义分类数据插入保存
	*/
	public abstract MscacustAggDO[] insert(MscacustAggDO[] aggdos) throws BizException;
	
    /**
	*  组套自定义分类数据保存
	*/
	public abstract MscacustAggDO[] save(MscacustAggDO[] aggdos) throws BizException;
	
    /**
	*  组套自定义分类数据更新
	*/
	public abstract MscacustAggDO[] update(MscacustAggDO[] aggdos) throws BizException;
	
	/**
	*  组套自定义分类数据逻辑删除
	*/
	public abstract void logicDelete(MscacustAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组套自定义分类数据真删除
	 */
	public abstract void deleteByParentDO(MkrMscaCtmDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组套自定义分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MkrMscaCtmDO[] mainDos) throws BizException;
}
