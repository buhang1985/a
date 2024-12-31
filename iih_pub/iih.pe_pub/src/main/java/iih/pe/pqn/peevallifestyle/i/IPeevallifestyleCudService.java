package iih.pe.pqn.peevallifestyle.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevallifestyle.d.PeEvalLifestyleDO;
import iih.pe.pqn.peevallifestyle.d.PeevallifestyleAggDO;

/**
* 健康生活方式评估定义数据维护服务
*/
public interface IPeevallifestyleCudService {
	/**
	*  健康生活方式评估定义数据真删除
	*/
    public abstract void delete(PeevallifestyleAggDO[] aggdos) throws BizException;
    
    /**
	*  健康生活方式评估定义数据插入保存
	*/
	public abstract PeevallifestyleAggDO[] insert(PeevallifestyleAggDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估定义数据保存
	*/
	public abstract PeevallifestyleAggDO[] save(PeevallifestyleAggDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估定义数据更新
	*/
	public abstract PeevallifestyleAggDO[] update(PeevallifestyleAggDO[] aggdos) throws BizException;
	
	/**
	*  健康生活方式评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeevallifestyleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康生活方式评估定义数据真删除
	 */
	public abstract void deleteByParentDO(PeEvalLifestyleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康生活方式评估定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeEvalLifestyleDO[] mainDos) throws BizException;
}
