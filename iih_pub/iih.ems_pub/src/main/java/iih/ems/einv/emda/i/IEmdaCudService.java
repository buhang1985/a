package iih.ems.einv.emda.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.emda.d.EmsDaDO;
import iih.ems.einv.emda.d.EmdaAggDO;

/**
* 设备领用申请数据维护服务
*/
public interface IEmdaCudService {
	/**
	*  设备领用申请数据真删除
	*/
    public abstract void delete(EmdaAggDO[] aggdos) throws BizException;
    
    /**
	*  设备领用申请数据插入保存
	*/
	public abstract EmdaAggDO[] insert(EmdaAggDO[] aggdos) throws BizException;
	
    /**
	*  设备领用申请数据保存
	*/
	public abstract EmdaAggDO[] save(EmdaAggDO[] aggdos) throws BizException;
	
    /**
	*  设备领用申请数据更新
	*/
	public abstract EmdaAggDO[] update(EmdaAggDO[] aggdos) throws BizException;
	
	/**
	*  设备领用申请数据逻辑删除
	*/
	public abstract void logicDelete(EmdaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对设备领用申请数据真删除
	 */
	public abstract void deleteByParentDO(EmsDaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对设备领用申请数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmsDaDO[] mainDos) throws BizException;
}
