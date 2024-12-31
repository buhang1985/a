package iih.nm.nhr.nmnhrsi.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrsi.d.NmNhrSiDO;
import iih.nm.nhr.nmnhrsi.d.NmnhrsiAggDO;

/**
* 班次信息数据维护服务
*/
public interface INmnhrsiCudService {
	/**
	*  班次信息数据真删除
	*/
    public abstract void delete(NmnhrsiAggDO[] aggdos) throws BizException;
    
    /**
	*  班次信息数据插入保存
	*/
	public abstract NmnhrsiAggDO[] insert(NmnhrsiAggDO[] aggdos) throws BizException;
	
    /**
	*  班次信息数据保存
	*/
	public abstract NmnhrsiAggDO[] save(NmnhrsiAggDO[] aggdos) throws BizException;
	
    /**
	*  班次信息数据更新
	*/
	public abstract NmnhrsiAggDO[] update(NmnhrsiAggDO[] aggdos) throws BizException;
	
	/**
	*  班次信息数据逻辑删除
	*/
	public abstract void logicDelete(NmnhrsiAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对班次信息数据真删除
	 */
	public abstract void deleteByParentDO(NmNhrSiDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对班次信息数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNhrSiDO[] mainDos) throws BizException;
}
