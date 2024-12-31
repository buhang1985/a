package iih.ci.mrqc.mrconnotationqc.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcDO;
import iih.ci.mrqc.mrconnotationqc.d.MrconnotationqcAggDO;

/**
* mrconnotationqcdo数据维护服务
*/
public interface IMrconnotationqcCudService {
	/**
	*  mrconnotationqcdo数据真删除
	*/
    public abstract void delete(MrconnotationqcAggDO[] aggdos) throws BizException;
    
    /**
	*  mrconnotationqcdo数据插入保存
	*/
	public abstract MrconnotationqcAggDO[] insert(MrconnotationqcAggDO[] aggdos) throws BizException;
	
    /**
	*  mrconnotationqcdo数据保存
	*/
	public abstract MrconnotationqcAggDO[] save(MrconnotationqcAggDO[] aggdos) throws BizException;
	
    /**
	*  mrconnotationqcdo数据更新
	*/
	public abstract MrconnotationqcAggDO[] update(MrconnotationqcAggDO[] aggdos) throws BizException;
	
	/**
	*  mrconnotationqcdo数据逻辑删除
	*/
	public abstract void logicDelete(MrconnotationqcAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对mrconnotationqcdo数据真删除
	 */
	public abstract void deleteByParentDO(MrConnotationQcDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对mrconnotationqcdo数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MrConnotationQcDO[] mainDos) throws BizException;
}
