package iih.nmr.pkuf.nmrdocmbdg.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdocmbdg.d.NmrDocMbdgDO;
import iih.nmr.pkuf.nmrdocmbdg.d.NmrdocmbdgAggDO;

/**
* 文书_移动_数据组数据维护服务
*/
public interface INmrdocmbdgCudService {
	/**
	*  文书_移动_数据组数据真删除
	*/
    public abstract void delete(NmrdocmbdgAggDO[] aggdos) throws BizException;
    
    /**
	*  文书_移动_数据组数据插入保存
	*/
	public abstract NmrdocmbdgAggDO[] insert(NmrdocmbdgAggDO[] aggdos) throws BizException;
	
    /**
	*  文书_移动_数据组数据保存
	*/
	public abstract NmrdocmbdgAggDO[] save(NmrdocmbdgAggDO[] aggdos) throws BizException;
	
    /**
	*  文书_移动_数据组数据更新
	*/
	public abstract NmrdocmbdgAggDO[] update(NmrdocmbdgAggDO[] aggdos) throws BizException;
	
	/**
	*  文书_移动_数据组数据逻辑删除
	*/
	public abstract void logicDelete(NmrdocmbdgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对文书_移动_数据组数据真删除
	 */
	public abstract void deleteByParentDO(NmrDocMbdgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对文书_移动_数据组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmrDocMbdgDO[] mainDos) throws BizException;
}
