package iih.bd.srv.srvdc.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvdc.d.FixedChargePkgDO;
import iih.bd.srv.srvdc.d.SrvdcAggDO;

/**
* 医疗服务固定收费包数据维护服务
*/
public interface ISrvdcCudService {
	/**
	*  医疗服务固定收费包数据真删除
	*/
    public abstract void delete(SrvdcAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务固定收费包数据插入保存
	*/
	public abstract SrvdcAggDO[] insert(SrvdcAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务固定收费包数据保存
	*/
	public abstract SrvdcAggDO[] save(SrvdcAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务固定收费包数据更新
	*/
	public abstract SrvdcAggDO[] update(SrvdcAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务固定收费包数据逻辑删除
	*/
	public abstract void logicDelete(SrvdcAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务固定收费包数据真删除
	 */
	public abstract void deleteByParentDO(FixedChargePkgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务固定收费包数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(FixedChargePkgDO[] mainDos) throws BizException;
}
