package iih.ci.mrm.healthsystem.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.healthsystem.d.FieldContrastDO;
import iih.ci.mrm.healthsystem.d.HealthsystemfieldAggDO;

/**
* 字段转换数据维护服务
*/
public interface IHealthsystemfieldCudService {
	/**
	*  字段转换数据真删除
	*/
    public abstract void delete(HealthsystemfieldAggDO[] aggdos) throws BizException;
    
    /**
	*  字段转换数据插入保存
	*/
	public abstract HealthsystemfieldAggDO[] insert(HealthsystemfieldAggDO[] aggdos) throws BizException;
	
    /**
	*  字段转换数据保存
	*/
	public abstract HealthsystemfieldAggDO[] save(HealthsystemfieldAggDO[] aggdos) throws BizException;
	
    /**
	*  字段转换数据更新
	*/
	public abstract HealthsystemfieldAggDO[] update(HealthsystemfieldAggDO[] aggdos) throws BizException;
	
	/**
	*  字段转换数据逻辑删除
	*/
	public abstract void logicDelete(HealthsystemfieldAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对字段转换数据真删除
	 */
	public abstract void deleteByParentDO(FieldContrastDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对字段转换数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(FieldContrastDO[] mainDos) throws BizException;
}
