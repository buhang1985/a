package iih.ems.einv.emout.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.emout.d.EmsOutDO;
import iih.ems.einv.emout.d.EmoutAggDO;

/**
* 设备出库数据维护服务
*/
public interface IEmoutCudService {
	/**
	*  设备出库数据真删除
	*/
    public abstract void delete(EmoutAggDO[] aggdos) throws BizException;
    
    /**
	*  设备出库数据插入保存
	*/
	public abstract EmoutAggDO[] insert(EmoutAggDO[] aggdos) throws BizException;
	
    /**
	*  设备出库数据保存
	*/
	public abstract EmoutAggDO[] save(EmoutAggDO[] aggdos) throws BizException;
	
    /**
	*  设备出库数据更新
	*/
	public abstract EmoutAggDO[] update(EmoutAggDO[] aggdos) throws BizException;
	
	/**
	*  设备出库数据逻辑删除
	*/
	public abstract void logicDelete(EmoutAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对设备出库数据真删除
	 */
	public abstract void deleteByParentDO(EmsOutDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对设备出库数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmsOutDO[] mainDos) throws BizException;
}
