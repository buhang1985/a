package iih.ci.mrm.healthsystem.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.healthsystem.d.ValueContrastDO;
import iih.ci.mrm.healthsystem.d.ValuecontrastAggDO;

/**
* 对照数据维护服务
*/
public interface IValuecontrastCudService {
	/**
	*  对照数据真删除
	*/
    public abstract void delete(ValuecontrastAggDO[] aggdos) throws BizException;
    
    /**
	*  对照数据插入保存
	*/
	public abstract ValuecontrastAggDO[] insert(ValuecontrastAggDO[] aggdos) throws BizException;
	
    /**
	*  对照数据保存
	*/
	public abstract ValuecontrastAggDO[] save(ValuecontrastAggDO[] aggdos) throws BizException;
	
    /**
	*  对照数据更新
	*/
	public abstract ValuecontrastAggDO[] update(ValuecontrastAggDO[] aggdos) throws BizException;
	
	/**
	*  对照数据逻辑删除
	*/
	public abstract void logicDelete(ValuecontrastAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对对照数据真删除
	 */
	public abstract void deleteByParentDO(ValueContrastDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对对照数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ValueContrastDO[] mainDos) throws BizException;
}
