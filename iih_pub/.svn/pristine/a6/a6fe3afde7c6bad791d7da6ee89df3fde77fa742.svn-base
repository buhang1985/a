package iih.pe.pqn.peevalmeal.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalmeal.d.PeEvalMealDO;
import iih.pe.pqn.peevalmeal.d.PeevalmealAggDO;

/**
* 体检饮食评估定义数据维护服务
*/
public interface IPeevalmealCudService {
	/**
	*  体检饮食评估定义数据真删除
	*/
    public abstract void delete(PeevalmealAggDO[] aggdos) throws BizException;
    
    /**
	*  体检饮食评估定义数据插入保存
	*/
	public abstract PeevalmealAggDO[] insert(PeevalmealAggDO[] aggdos) throws BizException;
	
    /**
	*  体检饮食评估定义数据保存
	*/
	public abstract PeevalmealAggDO[] save(PeevalmealAggDO[] aggdos) throws BizException;
	
    /**
	*  体检饮食评估定义数据更新
	*/
	public abstract PeevalmealAggDO[] update(PeevalmealAggDO[] aggdos) throws BizException;
	
	/**
	*  体检饮食评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeevalmealAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检饮食评估定义数据真删除
	 */
	public abstract void deleteByParentDO(PeEvalMealDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检饮食评估定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeEvalMealDO[] mainDos) throws BizException;
}
