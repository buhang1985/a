package iih.nm.nhr.institutabatch.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.institutabatch.d.NmStuOrgDO;
import iih.nm.nhr.institutabatch.d.InstitutabatchAggDO;

/**
* 院校批次管理数据维护服务
*/
public interface IInstitutabatchCudService {
	/**
	*  院校批次管理数据真删除
	*/
    public abstract void delete(InstitutabatchAggDO[] aggdos) throws BizException;
    
    /**
	*  院校批次管理数据插入保存
	*/
	public abstract InstitutabatchAggDO[] insert(InstitutabatchAggDO[] aggdos) throws BizException;
	
    /**
	*  院校批次管理数据保存
	*/
	public abstract InstitutabatchAggDO[] save(InstitutabatchAggDO[] aggdos) throws BizException;
	
    /**
	*  院校批次管理数据更新
	*/
	public abstract InstitutabatchAggDO[] update(InstitutabatchAggDO[] aggdos) throws BizException;
	
	/**
	*  院校批次管理数据逻辑删除
	*/
	public abstract void logicDelete(InstitutabatchAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对院校批次管理数据真删除
	 */
	public abstract void deleteByParentDO(NmStuOrgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对院校批次管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmStuOrgDO[] mainDos) throws BizException;
}
