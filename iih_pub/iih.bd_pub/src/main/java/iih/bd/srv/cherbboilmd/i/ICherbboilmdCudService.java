package iih.bd.srv.cherbboilmd.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.d.CherbboilmdAggDO;

/**
* 医疗服务中药煎法数据维护服务
*/
public interface ICherbboilmdCudService {
	/**
	*  医疗服务中药煎法数据真删除
	*/
    public abstract void delete(CherbboilmdAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务中药煎法数据插入保存
	*/
	public abstract CherbboilmdAggDO[] insert(CherbboilmdAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务中药煎法数据保存
	*/
	public abstract CherbboilmdAggDO[] save(CherbboilmdAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务中药煎法数据更新
	*/
	public abstract CherbboilmdAggDO[] update(CherbboilmdAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务中药煎法数据逻辑删除
	*/
	public abstract void logicDelete(CherbboilmdAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务中药煎法数据真删除
	 */
	public abstract void deleteByParentDO(CHerbBoilMdDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务中药煎法数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CHerbBoilMdDO[] mainDos) throws BizException;
}
