package iih.nmr.pkuf.nmrdocmobdg.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.nmrdocmobdg.d.NmrDocMobdgDO;
import iih.nmr.pkuf.nmrdocmobdg.d.NmrdocmobdgAggDO;

/**
* 移动数据集新版数据维护服务
*/
public interface INmrdocmobdgCudService {
	/**
	*  移动数据集新版数据真删除
	*/
    public abstract void delete(NmrdocmobdgAggDO[] aggdos) throws BizException;
    
    /**
	*  移动数据集新版数据插入保存
	*/
	public abstract NmrdocmobdgAggDO[] insert(NmrdocmobdgAggDO[] aggdos) throws BizException;
	
    /**
	*  移动数据集新版数据保存
	*/
	public abstract NmrdocmobdgAggDO[] save(NmrdocmobdgAggDO[] aggdos) throws BizException;
	
    /**
	*  移动数据集新版数据更新
	*/
	public abstract NmrdocmobdgAggDO[] update(NmrdocmobdgAggDO[] aggdos) throws BizException;
	
	/**
	*  移动数据集新版数据逻辑删除
	*/
	public abstract void logicDelete(NmrdocmobdgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对移动数据集新版数据真删除
	 */
	public abstract void deleteByParentDO(NmrDocMobdgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对移动数据集新版数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmrDocMobdgDO[] mainDos) throws BizException;
}
