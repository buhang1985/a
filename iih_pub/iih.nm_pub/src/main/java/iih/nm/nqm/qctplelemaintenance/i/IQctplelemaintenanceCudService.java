package iih.nm.nqm.qctplelemaintenance.i;

import xap.mw.core.data.BizException;
import iih.nm.nqm.qctplelemaintenance.d.NmQctplEleDO;
import iih.nm.nqm.qctplelemaintenance.d.QctplelemaintenanceAggDO;

/**
* 质量模板元素数据维护服务
*/
public interface IQctplelemaintenanceCudService {
	/**
	*  质量模板元素数据真删除
	*/
    public abstract void delete(QctplelemaintenanceAggDO[] aggdos) throws BizException;
    
    /**
	*  质量模板元素数据插入保存
	*/
	public abstract QctplelemaintenanceAggDO[] insert(QctplelemaintenanceAggDO[] aggdos) throws BizException;
	
    /**
	*  质量模板元素数据保存
	*/
	public abstract QctplelemaintenanceAggDO[] save(QctplelemaintenanceAggDO[] aggdos) throws BizException;
	
    /**
	*  质量模板元素数据更新
	*/
	public abstract QctplelemaintenanceAggDO[] update(QctplelemaintenanceAggDO[] aggdos) throws BizException;
	
	/**
	*  质量模板元素数据逻辑删除
	*/
	public abstract void logicDelete(QctplelemaintenanceAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对质量模板元素数据真删除
	 */
	public abstract void deleteByParentDO(NmQctplEleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对质量模板元素数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmQctplEleDO[] mainDos) throws BizException;
}
