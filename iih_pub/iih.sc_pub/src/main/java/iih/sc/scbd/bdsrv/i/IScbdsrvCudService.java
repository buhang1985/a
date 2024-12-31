package iih.sc.scbd.bdsrv.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.d.ScbdsrvAggDO;

/**
* 排班计划-医疗服务数据维护服务
*/
public interface IScbdsrvCudService {
	/**
	*  排班计划-医疗服务数据真删除
	*/
    public abstract void delete(ScbdsrvAggDO[] aggdos) throws BizException;
    
    /**
	*  排班计划-医疗服务数据插入保存
	*/
	public abstract ScbdsrvAggDO[] insert(ScbdsrvAggDO[] aggdos) throws BizException;
	
    /**
	*  排班计划-医疗服务数据保存
	*/
	public abstract ScbdsrvAggDO[] save(ScbdsrvAggDO[] aggdos) throws BizException;
	
    /**
	*  排班计划-医疗服务数据更新
	*/
	public abstract ScbdsrvAggDO[] update(ScbdsrvAggDO[] aggdos) throws BizException;
	
	/**
	*  排班计划-医疗服务数据逻辑删除
	*/
	public abstract void logicDelete(ScbdsrvAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班计划-医疗服务数据真删除
	 */
	public abstract void deleteByParentDO(ScBdsrvDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班计划-医疗服务数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScBdsrvDO[] mainDos) throws BizException;
}
