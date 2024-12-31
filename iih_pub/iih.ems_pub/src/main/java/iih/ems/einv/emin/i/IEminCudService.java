package iih.ems.einv.emin.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.emin.d.EmsInDO;
import iih.ems.einv.emin.d.EminAggDO;

/**
* 设备入库数据维护服务
*/
public interface IEminCudService {
	/**
	*  设备入库数据真删除
	*/
    public abstract void delete(EminAggDO[] aggdos) throws BizException;
    
    /**
	*  设备入库数据插入保存
	*/
	public abstract EminAggDO[] insert(EminAggDO[] aggdos) throws BizException;
	
    /**
	*  设备入库数据保存
	*/
	public abstract EminAggDO[] save(EminAggDO[] aggdos) throws BizException;
	
    /**
	*  设备入库数据更新
	*/
	public abstract EminAggDO[] update(EminAggDO[] aggdos) throws BizException;
	
	/**
	*  设备入库数据逻辑删除
	*/
	public abstract void logicDelete(EminAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对设备入库数据真删除
	 */
	public abstract void deleteByParentDO(EmsInDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对设备入库数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmsInDO[] mainDos) throws BizException;
}
