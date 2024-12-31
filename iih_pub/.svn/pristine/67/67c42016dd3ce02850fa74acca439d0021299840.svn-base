package iih.nm.nhr.nmnurlabor.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurlabor.d.NmNurLaborDO;
import iih.nm.nhr.nmnurlabor.d.NmnurlaborAggDO;

/**
* 工时调整数据维护服务
*/
public interface INmnurlaborCudService {
	/**
	*  工时调整数据真删除
	*/
    public abstract void delete(NmnurlaborAggDO[] aggdos) throws BizException;
    
    /**
	*  工时调整数据插入保存
	*/
	public abstract NmnurlaborAggDO[] insert(NmnurlaborAggDO[] aggdos) throws BizException;
	
    /**
	*  工时调整数据保存
	*/
	public abstract NmnurlaborAggDO[] save(NmnurlaborAggDO[] aggdos) throws BizException;
	
    /**
	*  工时调整数据更新
	*/
	public abstract NmnurlaborAggDO[] update(NmnurlaborAggDO[] aggdos) throws BizException;
	
	/**
	*  工时调整数据逻辑删除
	*/
	public abstract void logicDelete(NmnurlaborAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对工时调整数据真删除
	 */
	public abstract void deleteByParentDO(NmNurLaborDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对工时调整数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNurLaborDO[] mainDos) throws BizException;
}
