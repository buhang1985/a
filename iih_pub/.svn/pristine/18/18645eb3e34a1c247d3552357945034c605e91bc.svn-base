package iih.bd.srv.mrelement.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrelement.d.MrElementDO;
import iih.bd.srv.mrelement.d.BdmrdeAggDO;

/**
* 病历元素数据维护服务
*/
public interface IBdmrdeCudService {
	/**
	*  病历元素数据真删除
	*/
    public abstract void delete(BdmrdeAggDO[] aggdos) throws BizException;
    
    /**
	*  病历元素数据插入保存
	*/
	public abstract BdmrdeAggDO[] insert(BdmrdeAggDO[] aggdos) throws BizException;
	
    /**
	*  病历元素数据保存
	*/
	public abstract BdmrdeAggDO[] save(BdmrdeAggDO[] aggdos) throws BizException;
	
    /**
	*  病历元素数据更新
	*/
	public abstract BdmrdeAggDO[] update(BdmrdeAggDO[] aggdos) throws BizException;
	
	/**
	*  病历元素数据逻辑删除
	*/
	public abstract void logicDelete(BdmrdeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病历元素数据真删除
	 */
	public abstract void deleteByParentDO(MrElementDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病历元素数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MrElementDO[] mainDos) throws BizException;
}
