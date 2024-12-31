package iih.bd.srv.freqdef.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;

/**
* 医嘱频次定义数据维护服务
*/
public interface IFreqdefCudService {
	/**
	*  医嘱频次定义数据真删除
	*/
    public abstract void delete(FreqdefAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱频次定义数据插入保存
	*/
	public abstract FreqdefAggDO[] insert(FreqdefAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱频次定义数据保存
	*/
	public abstract FreqdefAggDO[] save(FreqdefAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱频次定义数据更新
	*/
	public abstract FreqdefAggDO[] update(FreqdefAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱频次定义数据逻辑删除
	*/
	public abstract void logicDelete(FreqdefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医嘱频次定义数据真删除
	 */
	public abstract void deleteByParentDO(FreqDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医嘱频次定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(FreqDefDO[] mainDos) throws BizException;
}
