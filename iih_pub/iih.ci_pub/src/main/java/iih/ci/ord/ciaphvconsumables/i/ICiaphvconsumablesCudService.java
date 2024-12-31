package iih.ci.ord.ciaphvconsumables.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.ciaphvconsumables.d.CiApHvconsumblesDO;
import iih.ci.ord.ciaphvconsumables.d.CiaphvconsumablesAggDO;

/**
* 医嘱高值耗材申请 数据维护服务
*/
public interface ICiaphvconsumablesCudService {
	/**
	*  医嘱高值耗材申请 数据真删除
	*/
    public abstract void delete(CiaphvconsumablesAggDO[] aggdos) throws BizException;
    
    /**
	*  医嘱高值耗材申请 数据插入保存
	*/
	public abstract CiaphvconsumablesAggDO[] insert(CiaphvconsumablesAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱高值耗材申请 数据保存
	*/
	public abstract CiaphvconsumablesAggDO[] save(CiaphvconsumablesAggDO[] aggdos) throws BizException;
	
    /**
	*  医嘱高值耗材申请 数据更新
	*/
	public abstract CiaphvconsumablesAggDO[] update(CiaphvconsumablesAggDO[] aggdos) throws BizException;
	
	/**
	*  医嘱高值耗材申请 数据逻辑删除
	*/
	public abstract void logicDelete(CiaphvconsumablesAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医嘱高值耗材申请 数据真删除
	 */
	public abstract void deleteByParentDO(CiApHvconsumblesDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医嘱高值耗材申请 数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiApHvconsumblesDO[] mainDos) throws BizException;
}
