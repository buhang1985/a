package iih.bd.pp.bdcpnca.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.d.BdcpncaAggDO;

/**
* 优惠劵_基础数据数据维护服务
*/
public interface IBdcpncaCudService {
	/**
	*  优惠劵_基础数据数据真删除
	*/
    public abstract void delete(BdcpncaAggDO[] aggdos) throws BizException;
    
    /**
	*  优惠劵_基础数据数据插入保存
	*/
	public abstract BdcpncaAggDO[] insert(BdcpncaAggDO[] aggdos) throws BizException;
	
    /**
	*  优惠劵_基础数据数据保存
	*/
	public abstract BdcpncaAggDO[] save(BdcpncaAggDO[] aggdos) throws BizException;
	
    /**
	*  优惠劵_基础数据数据更新
	*/
	public abstract BdcpncaAggDO[] update(BdcpncaAggDO[] aggdos) throws BizException;
	
	/**
	*  优惠劵_基础数据数据逻辑删除
	*/
	public abstract void logicDelete(BdcpncaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对优惠劵_基础数据数据真删除
	 */
	public abstract void deleteByParentDO(BdCpncaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对优惠劵_基础数据数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdCpncaDO[] mainDos) throws BizException;
}
