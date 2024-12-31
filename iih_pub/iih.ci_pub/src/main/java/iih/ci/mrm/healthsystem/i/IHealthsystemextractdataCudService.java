package iih.ci.mrm.healthsystem.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.healthsystem.d.ExtractDataDO;
import iih.ci.mrm.healthsystem.d.HealthsystemextractdataAggDO;

/**
* 数据抽取任务数据维护服务
*/
public interface IHealthsystemextractdataCudService {
	/**
	*  数据抽取任务数据真删除
	*/
    public abstract void delete(HealthsystemextractdataAggDO[] aggdos) throws BizException;
    
    /**
	*  数据抽取任务数据插入保存
	*/
	public abstract HealthsystemextractdataAggDO[] insert(HealthsystemextractdataAggDO[] aggdos) throws BizException;
	
    /**
	*  数据抽取任务数据保存
	*/
	public abstract HealthsystemextractdataAggDO[] save(HealthsystemextractdataAggDO[] aggdos) throws BizException;
	
    /**
	*  数据抽取任务数据更新
	*/
	public abstract HealthsystemextractdataAggDO[] update(HealthsystemextractdataAggDO[] aggdos) throws BizException;
	
	/**
	*  数据抽取任务数据逻辑删除
	*/
	public abstract void logicDelete(HealthsystemextractdataAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对数据抽取任务数据真删除
	 */
	public abstract void deleteByParentDO(ExtractDataDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对数据抽取任务数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ExtractDataDO[] mainDos) throws BizException;
}
