package iih.nmr.pkuf.nmrdoc.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdoc.d.NmrDocDO;
import iih.nmr.pkuf.nmrdoc.d.NmrdocAggDO;

/**
* 文书基本信息数据维护服务
*/
public interface INmrdocCudService {
	/**
	*  文书基本信息数据真删除
	*/
    public abstract void delete(NmrdocAggDO[] aggdos) throws BizException;
    
    /**
	*  文书基本信息数据插入保存
	*/
	public abstract NmrdocAggDO[] insert(NmrdocAggDO[] aggdos) throws BizException;
	
    /**
	*  文书基本信息数据保存
	*/
	public abstract NmrdocAggDO[] save(NmrdocAggDO[] aggdos) throws BizException;
	
    /**
	*  文书基本信息数据更新
	*/
	public abstract NmrdocAggDO[] update(NmrdocAggDO[] aggdos) throws BizException;
	
	/**
	*  文书基本信息数据逻辑删除
	*/
	public abstract void logicDelete(NmrdocAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对文书基本信息数据真删除
	 */
	public abstract void deleteByParentDO(NmrDocDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对文书基本信息数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmrDocDO[] mainDos) throws BizException;
}
