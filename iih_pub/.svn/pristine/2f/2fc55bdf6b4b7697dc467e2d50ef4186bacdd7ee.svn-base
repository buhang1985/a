package iih.pe.pps.perstslicemng.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.perstslicemng.d.PeRstSliceMngDO;
import iih.pe.pps.perstslicemng.d.PerstslicemngAggDO;

/**
* 体检重要结果分层管理数据维护服务
*/
public interface IPerstslicemngCudService {
	/**
	*  体检重要结果分层管理数据真删除
	*/
    public abstract void delete(PerstslicemngAggDO[] aggdos) throws BizException;
    
    /**
	*  体检重要结果分层管理数据插入保存
	*/
	public abstract PerstslicemngAggDO[] insert(PerstslicemngAggDO[] aggdos) throws BizException;
	
    /**
	*  体检重要结果分层管理数据保存
	*/
	public abstract PerstslicemngAggDO[] save(PerstslicemngAggDO[] aggdos) throws BizException;
	
    /**
	*  体检重要结果分层管理数据更新
	*/
	public abstract PerstslicemngAggDO[] update(PerstslicemngAggDO[] aggdos) throws BizException;
	
	/**
	*  体检重要结果分层管理数据逻辑删除
	*/
	public abstract void logicDelete(PerstslicemngAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检重要结果分层管理数据真删除
	 */
	public abstract void deleteByParentDO(PeRstSliceMngDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检重要结果分层管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstSliceMngDO[] mainDos) throws BizException;
}
