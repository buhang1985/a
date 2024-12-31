package iih.mkr.ms.mkrms.i;

import xap.mw.core.data.BizException;
import iih.mkr.ms.mkrms.d.MkrMsDO;
import iih.mkr.ms.mkrms.d.MkrmsAggDO;

/**
* 组套定义数据维护服务
*/
public interface IMkrmsCudService {
	/**
	*  组套定义数据真删除
	*/
    public abstract void delete(MkrmsAggDO[] aggdos) throws BizException;
    
    /**
	*  组套定义数据插入保存
	*/
	public abstract MkrmsAggDO[] insert(MkrmsAggDO[] aggdos) throws BizException;
	
    /**
	*  组套定义数据保存
	*/
	public abstract MkrmsAggDO[] save(MkrmsAggDO[] aggdos) throws BizException;
	
    /**
	*  组套定义数据更新
	*/
	public abstract MkrmsAggDO[] update(MkrmsAggDO[] aggdos) throws BizException;
	
	/**
	*  组套定义数据逻辑删除
	*/
	public abstract void logicDelete(MkrmsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组套定义数据真删除
	 */
	public abstract void deleteByParentDO(MkrMsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组套定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MkrMsDO[] mainDos) throws BizException;
}
