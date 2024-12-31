package iih.ems.eass.emshift.i;

import xap.mw.core.data.BizException;
import iih.ems.eass.emshift.d.EmsEmShiftDO;
import iih.ems.eass.emshift.d.EmshiftAggDO;

/**
* 设备资产保管变更数据维护服务
*/
public interface IEmshiftCudService {
	/**
	*  设备资产保管变更数据真删除
	*/
    public abstract void delete(EmshiftAggDO[] aggdos) throws BizException;
    
    /**
	*  设备资产保管变更数据插入保存
	*/
	public abstract EmshiftAggDO[] insert(EmshiftAggDO[] aggdos) throws BizException;
	
    /**
	*  设备资产保管变更数据保存
	*/
	public abstract EmshiftAggDO[] save(EmshiftAggDO[] aggdos) throws BizException;
	
    /**
	*  设备资产保管变更数据更新
	*/
	public abstract EmshiftAggDO[] update(EmshiftAggDO[] aggdos) throws BizException;
	
	/**
	*  设备资产保管变更数据逻辑删除
	*/
	public abstract void logicDelete(EmshiftAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对设备资产保管变更数据真删除
	 */
	public abstract void deleteByParentDO(EmsEmShiftDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对设备资产保管变更数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmsEmShiftDO[] mainDos) throws BizException;
}
