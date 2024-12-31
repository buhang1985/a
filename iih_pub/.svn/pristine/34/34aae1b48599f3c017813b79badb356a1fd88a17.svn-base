package iih.ci.mr.cimracrecords.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimracrecords.d.CiMrACBaseDO;
import iih.ci.mr.cimracrecords.d.CimracrecordsAggDO;

/**
* 产程数据记录数据维护服务
*/
public interface ICimracrecordsCudService {
	/**
	*  产程数据记录数据真删除
	*/
    public abstract void delete(CimracrecordsAggDO[] aggdos) throws BizException;
    
    /**
	*  产程数据记录数据插入保存
	*/
	public abstract CimracrecordsAggDO[] insert(CimracrecordsAggDO[] aggdos) throws BizException;
	
    /**
	*  产程数据记录数据保存
	*/
	public abstract CimracrecordsAggDO[] save(CimracrecordsAggDO[] aggdos) throws BizException;
	
    /**
	*  产程数据记录数据更新
	*/
	public abstract CimracrecordsAggDO[] update(CimracrecordsAggDO[] aggdos) throws BizException;
	
	/**
	*  产程数据记录数据逻辑删除
	*/
	public abstract void logicDelete(CimracrecordsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产程数据记录数据真删除
	 */
	public abstract void deleteByParentDO(CiMrACBaseDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产程数据记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiMrACBaseDO[] mainDos) throws BizException;
}
