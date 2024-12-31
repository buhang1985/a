package iih.bd.fc.wf.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.WfAggDO;

/**
* 流程配置_医嘱流向数据维护服务
*/
public interface IWfCudService {
	/**
	*  流程配置_医嘱流向数据真删除
	*/
    public abstract void delete(WfAggDO[] aggdos) throws BizException;
    
    /**
	*  流程配置_医嘱流向数据插入保存
	*/
	public abstract WfAggDO[] insert(WfAggDO[] aggdos) throws BizException;
	
    /**
	*  流程配置_医嘱流向数据保存
	*/
	public abstract WfAggDO[] save(WfAggDO[] aggdos) throws BizException;
	
    /**
	*  流程配置_医嘱流向数据更新
	*/
	public abstract WfAggDO[] update(WfAggDO[] aggdos) throws BizException;
	
	/**
	*  流程配置_医嘱流向数据逻辑删除
	*/
	public abstract void logicDelete(WfAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对流程配置_医嘱流向数据真删除
	 */
	public abstract void deleteByParentDO(WfDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对流程配置_医嘱流向数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(WfDO[] mainDos) throws BizException;
}
