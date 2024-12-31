package iih.pe.pbd.pedeptset.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.pedeptset.d.PeDeptSetDO;
import iih.pe.pbd.pedeptset.d.PedeptsetAggDO;

/**
* 体检科室设置数据维护服务
*/
public interface IPedeptsetCudService {
	/**
	*  体检科室设置数据真删除
	*/
    public abstract void delete(PedeptsetAggDO[] aggdos) throws BizException;
    
    /**
	*  体检科室设置数据插入保存
	*/
	public abstract PedeptsetAggDO[] insert(PedeptsetAggDO[] aggdos) throws BizException;
	
    /**
	*  体检科室设置数据保存
	*/
	public abstract PedeptsetAggDO[] save(PedeptsetAggDO[] aggdos) throws BizException;
	
    /**
	*  体检科室设置数据更新
	*/
	public abstract PedeptsetAggDO[] update(PedeptsetAggDO[] aggdos) throws BizException;
	
	/**
	*  体检科室设置数据逻辑删除
	*/
	public abstract void logicDelete(PedeptsetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检科室设置数据真删除
	 */
	public abstract void deleteByParentDO(PeDeptSetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检科室设置数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeDeptSetDO[] mainDos) throws BizException;
}
