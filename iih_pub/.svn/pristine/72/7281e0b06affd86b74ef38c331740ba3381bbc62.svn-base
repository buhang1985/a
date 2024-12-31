package iih.pis.ivx.pisivxsrvmenu.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxsrvmenu.d.PisIvxSrvMenuDO;
import iih.pis.ivx.pisivxsrvmenu.d.PisivxsrvmenuAggDO;

/**
* 服务号菜单数据维护服务
*/
public interface IPisivxsrvmenuCudService {
	/**
	*  服务号菜单数据真删除
	*/
    public abstract void delete(PisivxsrvmenuAggDO[] aggdos) throws BizException;
    
    /**
	*  服务号菜单数据插入保存
	*/
	public abstract PisivxsrvmenuAggDO[] insert(PisivxsrvmenuAggDO[] aggdos) throws BizException;
	
    /**
	*  服务号菜单数据保存
	*/
	public abstract PisivxsrvmenuAggDO[] save(PisivxsrvmenuAggDO[] aggdos) throws BizException;
	
    /**
	*  服务号菜单数据更新
	*/
	public abstract PisivxsrvmenuAggDO[] update(PisivxsrvmenuAggDO[] aggdos) throws BizException;
	
	/**
	*  服务号菜单数据逻辑删除
	*/
	public abstract void logicDelete(PisivxsrvmenuAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对服务号菜单数据真删除
	 */
	public abstract void deleteByParentDO(PisIvxSrvMenuDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对服务号菜单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PisIvxSrvMenuDO[] mainDos) throws BizException;
}
