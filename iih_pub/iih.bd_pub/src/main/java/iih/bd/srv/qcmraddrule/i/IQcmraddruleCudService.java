package iih.bd.srv.qcmraddrule.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.qcmraddrule.d.QcmraddruleDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleAggDO;

/**
* 组件数据维护服务
*/
public interface IQcmraddruleCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(QcmraddruleAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract QcmraddruleAggDO[] insert(QcmraddruleAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract QcmraddruleAggDO[] save(QcmraddruleAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract QcmraddruleAggDO[] update(QcmraddruleAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(QcmraddruleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(QcmraddruleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(QcmraddruleDO[] mainDos) throws BizException;
}
