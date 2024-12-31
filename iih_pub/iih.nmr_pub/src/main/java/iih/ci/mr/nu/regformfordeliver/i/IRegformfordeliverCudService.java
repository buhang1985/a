package iih.ci.mr.nu.regformfordeliver.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.regformfordeliver.d.RegformDO;
import iih.ci.mr.nu.regformfordeliver.d.RegformfordeliverAggDO;

/**
* 分娩登记表数据维护服务
*/
public interface IRegformfordeliverCudService {
	/**
	*  分娩登记表数据真删除
	*/
    public abstract void delete(RegformfordeliverAggDO[] aggdos) throws BizException;
    
    /**
	*  分娩登记表数据插入保存
	*/
	public abstract RegformfordeliverAggDO[] insert(RegformfordeliverAggDO[] aggdos) throws BizException;
	
    /**
	*  分娩登记表数据保存
	*/
	public abstract RegformfordeliverAggDO[] save(RegformfordeliverAggDO[] aggdos) throws BizException;
	
    /**
	*  分娩登记表数据更新
	*/
	public abstract RegformfordeliverAggDO[] update(RegformfordeliverAggDO[] aggdos) throws BizException;
	
	/**
	*  分娩登记表数据逻辑删除
	*/
	public abstract void logicDelete(RegformfordeliverAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对分娩登记表数据真删除
	 */
	public abstract void deleteByParentDO(RegformDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对分娩登记表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(RegformDO[] mainDos) throws BizException;
}
