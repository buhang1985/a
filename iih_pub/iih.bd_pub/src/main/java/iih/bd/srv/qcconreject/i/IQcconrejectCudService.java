package iih.bd.srv.qcconreject.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.qcconreject.d.QcconrejectDO;
import iih.bd.srv.qcconreject.d.QcconrejectAggDO;

/**
* 组件数据维护服务
*/
public interface IQcconrejectCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(QcconrejectAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract QcconrejectAggDO[] insert(QcconrejectAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract QcconrejectAggDO[] save(QcconrejectAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract QcconrejectAggDO[] update(QcconrejectAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(QcconrejectAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(QcconrejectDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(QcconrejectDO[] mainDos) throws BizException;
}
