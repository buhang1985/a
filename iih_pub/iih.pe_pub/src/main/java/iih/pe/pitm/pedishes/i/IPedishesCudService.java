package iih.pe.pitm.pedishes.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pedishes.d.PeDishesDO;
import iih.pe.pitm.pedishes.d.PedishesAggDO;

/**
* 体检食物菜单定义数据维护服务
*/
public interface IPedishesCudService {
	/**
	*  体检食物菜单定义数据真删除
	*/
    public abstract void delete(PedishesAggDO[] aggdos) throws BizException;
    
    /**
	*  体检食物菜单定义数据插入保存
	*/
	public abstract PedishesAggDO[] insert(PedishesAggDO[] aggdos) throws BizException;
	
    /**
	*  体检食物菜单定义数据保存
	*/
	public abstract PedishesAggDO[] save(PedishesAggDO[] aggdos) throws BizException;
	
    /**
	*  体检食物菜单定义数据更新
	*/
	public abstract PedishesAggDO[] update(PedishesAggDO[] aggdos) throws BizException;
	
	/**
	*  体检食物菜单定义数据逻辑删除
	*/
	public abstract void logicDelete(PedishesAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检食物菜单定义数据真删除
	 */
	public abstract void deleteByParentDO(PeDishesDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检食物菜单定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeDishesDO[] mainDos) throws BizException;
}
