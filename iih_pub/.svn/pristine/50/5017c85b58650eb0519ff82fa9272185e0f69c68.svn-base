package iih.pe.pps.pecohort.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.pecohort.d.PeCohortDO;
import iih.pe.pps.pecohort.d.PecohortAggDO;

/**
* 体检人群队列管理数据维护服务
*/
public interface IPecohortCudService {
	/**
	*  体检人群队列管理数据真删除
	*/
    public abstract void delete(PecohortAggDO[] aggdos) throws BizException;
    
    /**
	*  体检人群队列管理数据插入保存
	*/
	public abstract PecohortAggDO[] insert(PecohortAggDO[] aggdos) throws BizException;
	
    /**
	*  体检人群队列管理数据保存
	*/
	public abstract PecohortAggDO[] save(PecohortAggDO[] aggdos) throws BizException;
	
    /**
	*  体检人群队列管理数据更新
	*/
	public abstract PecohortAggDO[] update(PecohortAggDO[] aggdos) throws BizException;
	
	/**
	*  体检人群队列管理数据逻辑删除
	*/
	public abstract void logicDelete(PecohortAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检人群队列管理数据真删除
	 */
	public abstract void deleteByParentDO(PeCohortDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检人群队列管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeCohortDO[] mainDos) throws BizException;
}
