package iih.ci.mr.nu.ccupatcarerec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.ccupatcarerec.d.CcuPatrecDO;
import iih.ci.mr.nu.ccupatcarerec.d.CcupatcarerecAggDO;

/**
* 组件数据维护服务
*/
public interface ICcupatcarerecCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(CcupatcarerecAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract CcupatcarerecAggDO[] insert(CcupatcarerecAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract CcupatcarerecAggDO[] save(CcupatcarerecAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract CcupatcarerecAggDO[] update(CcupatcarerecAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(CcupatcarerecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(CcuPatrecDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CcuPatrecDO[] mainDos) throws BizException;
}
