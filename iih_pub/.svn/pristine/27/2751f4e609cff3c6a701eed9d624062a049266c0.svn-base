package iih.sc.scp.aidset.i;

import xap.mw.core.data.BizException;
import iih.sc.scp.aidset.d.ScPlanAidSetDO;
import iih.sc.scp.aidset.d.ScplanaidsetAggDO;

/**
* 辅助样本设置数据维护服务
*/
public interface IScplanaidsetCudService {
	/**
	*  辅助样本设置数据真删除
	*/
    public abstract void delete(ScplanaidsetAggDO[] aggdos) throws BizException;
    
    /**
	*  辅助样本设置数据插入保存
	*/
	public abstract ScplanaidsetAggDO[] insert(ScplanaidsetAggDO[] aggdos) throws BizException;
	
    /**
	*  辅助样本设置数据保存
	*/
	public abstract ScplanaidsetAggDO[] save(ScplanaidsetAggDO[] aggdos) throws BizException;
	
    /**
	*  辅助样本设置数据更新
	*/
	public abstract ScplanaidsetAggDO[] update(ScplanaidsetAggDO[] aggdos) throws BizException;
	
	/**
	*  辅助样本设置数据逻辑删除
	*/
	public abstract void logicDelete(ScplanaidsetAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对辅助样本设置数据真删除
	 */
	public abstract void deleteByParentDO(ScPlanAidSetDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对辅助样本设置数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScPlanAidSetDO[] mainDos) throws BizException;
}
