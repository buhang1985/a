package iih.ems.einv.eminsp.i;

import xap.mw.core.data.BizException;
import iih.ems.einv.eminsp.d.EmsInspDO;
import iih.ems.einv.eminsp.d.EminspAggDO;

/**
* 大型设备验收数据维护服务
*/
public interface IEminspCudService {
	/**
	*  大型设备验收数据真删除
	*/
    public abstract void delete(EminspAggDO[] aggdos) throws BizException;
    
    /**
	*  大型设备验收数据插入保存
	*/
	public abstract EminspAggDO[] insert(EminspAggDO[] aggdos) throws BizException;
	
    /**
	*  大型设备验收数据保存
	*/
	public abstract EminspAggDO[] save(EminspAggDO[] aggdos) throws BizException;
	
    /**
	*  大型设备验收数据更新
	*/
	public abstract EminspAggDO[] update(EminspAggDO[] aggdos) throws BizException;
	
	/**
	*  大型设备验收数据逻辑删除
	*/
	public abstract void logicDelete(EminspAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对大型设备验收数据真删除
	 */
	public abstract void deleteByParentDO(EmsInspDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对大型设备验收数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmsInspDO[] mainDos) throws BizException;
}
