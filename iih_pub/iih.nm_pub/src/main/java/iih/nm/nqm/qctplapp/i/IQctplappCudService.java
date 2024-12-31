package iih.nm.nqm.qctplapp.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.qctplapp.d.QctplAppDO;
import iih.nm.nqm.qctplapp.d.QctplappAggDO;

/**
* 质量控制应用数据维护服务
*/
public interface IQctplappCudService {
	/**
	*  质量控制应用数据真删除
	*/
    public abstract void delete(QctplappAggDO[] aggdos) throws BizException;
    
    /**
	*  质量控制应用数据插入保存
	*/
	public abstract QctplappAggDO[] insert(QctplappAggDO[] aggdos) throws BizException;
	
    /**
	*  质量控制应用数据保存
	*/
	public abstract QctplappAggDO[] save(QctplappAggDO[] aggdos) throws BizException;
	
    /**
	*  质量控制应用数据更新
	*/
	public abstract QctplappAggDO[] update(QctplappAggDO[] aggdos) throws BizException;
	
	/**
	*  质量控制应用数据逻辑删除
	*/
	public abstract void logicDelete(QctplappAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对质量控制应用数据真删除
	 */
	public abstract void deleteByParentDO(QctplAppDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对质量控制应用数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(QctplAppDO[] mainDos) throws BizException;
}
