package iih.cssd.dpbd.apptmpl.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpbd.apptmpl.d.DfpAppTmplDO;
import iih.cssd.dpbd.apptmpl.d.ApptmplAggDO;

/**
* 消毒包科室请领模板数据维护服务
*/
public interface IApptmplCudService {
	/**
	*  消毒包科室请领模板数据真删除
	*/
    public abstract void delete(ApptmplAggDO[] aggdos) throws BizException;
    
    /**
	*  消毒包科室请领模板数据插入保存
	*/
	public abstract ApptmplAggDO[] insert(ApptmplAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包科室请领模板数据保存
	*/
	public abstract ApptmplAggDO[] save(ApptmplAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包科室请领模板数据更新
	*/
	public abstract ApptmplAggDO[] update(ApptmplAggDO[] aggdos) throws BizException;
	
	/**
	*  消毒包科室请领模板数据逻辑删除
	*/
	public abstract void logicDelete(ApptmplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对消毒包科室请领模板数据真删除
	 */
	public abstract void deleteByParentDO(DfpAppTmplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对消毒包科室请领模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DfpAppTmplDO[] mainDos) throws BizException;
}
