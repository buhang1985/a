package iih.sc.apt.aptip.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.AptipAggDO;

/**
* 住院预约数据维护服务
*/
public interface IAptipCudService {
	/**
	*  住院预约数据真删除
	*/
    public abstract void delete(AptipAggDO[] aggdos) throws BizException;
    
    /**
	*  住院预约数据插入保存
	*/
	public abstract AptipAggDO[] insert(AptipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院预约数据保存
	*/
	public abstract AptipAggDO[] save(AptipAggDO[] aggdos) throws BizException;
	
    /**
	*  住院预约数据更新
	*/
	public abstract AptipAggDO[] update(AptipAggDO[] aggdos) throws BizException;
	
	/**
	*  住院预约数据逻辑删除
	*/
	public abstract void logicDelete(AptipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对住院预约数据真删除
	 */
	public abstract void deleteByParentDO(AptIpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对住院预约数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AptIpDO[] mainDos) throws BizException;
}
