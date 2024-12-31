package iih.mc.st.dmout.i;

import xap.mw.core.data.BizException;
import iih.mc.st.dmout.d.McDamageOutDO;
import iih.mc.st.dmout.d.DmoutAggDO;

/**
* 高值耗材报损数据维护服务
*/
public interface IDmoutCudService {
	/**
	*  高值耗材报损数据真删除
	*/
    public abstract void delete(DmoutAggDO[] aggdos) throws BizException;
    
    /**
	*  高值耗材报损数据插入保存
	*/
	public abstract DmoutAggDO[] insert(DmoutAggDO[] aggdos) throws BizException;
	
    /**
	*  高值耗材报损数据保存
	*/
	public abstract DmoutAggDO[] save(DmoutAggDO[] aggdos) throws BizException;
	
    /**
	*  高值耗材报损数据更新
	*/
	public abstract DmoutAggDO[] update(DmoutAggDO[] aggdos) throws BizException;
	
	/**
	*  高值耗材报损数据逻辑删除
	*/
	public abstract void logicDelete(DmoutAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对高值耗材报损数据真删除
	 */
	public abstract void deleteByParentDO(McDamageOutDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对高值耗材报损数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(McDamageOutDO[] mainDos) throws BizException;
}
