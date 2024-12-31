package iih.ci.mr.nu.baby24care.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.baby24care.d.Baby24InfoDO;
import iih.ci.mr.nu.baby24care.d.Baby24careAggDO;

/**
* 新生儿24小时护理记录单数据维护服务
*/
public interface IBaby24careCudService {
	/**
	*  新生儿24小时护理记录单数据真删除
	*/
    public abstract void delete(Baby24careAggDO[] aggdos) throws BizException;
    
    /**
	*  新生儿24小时护理记录单数据插入保存
	*/
	public abstract Baby24careAggDO[] insert(Baby24careAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿24小时护理记录单数据保存
	*/
	public abstract Baby24careAggDO[] save(Baby24careAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿24小时护理记录单数据更新
	*/
	public abstract Baby24careAggDO[] update(Baby24careAggDO[] aggdos) throws BizException;
	
	/**
	*  新生儿24小时护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(Baby24careAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对新生儿24小时护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(Baby24InfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对新生儿24小时护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(Baby24InfoDO[] mainDos) throws BizException;
}
