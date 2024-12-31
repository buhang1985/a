package iih.pe.pqn.peevalsubhealth.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalsubhealth.d.PeEvalSubhealthDO;
import iih.pe.pqn.peevalsubhealth.d.PeevalsubhealthAggDO;

/**
* 体检亚健康评估定义数据维护服务
*/
public interface IPeevalsubhealthCudService {
	/**
	*  体检亚健康评估定义数据真删除
	*/
    public abstract void delete(PeevalsubhealthAggDO[] aggdos) throws BizException;
    
    /**
	*  体检亚健康评估定义数据插入保存
	*/
	public abstract PeevalsubhealthAggDO[] insert(PeevalsubhealthAggDO[] aggdos) throws BizException;
	
    /**
	*  体检亚健康评估定义数据保存
	*/
	public abstract PeevalsubhealthAggDO[] save(PeevalsubhealthAggDO[] aggdos) throws BizException;
	
    /**
	*  体检亚健康评估定义数据更新
	*/
	public abstract PeevalsubhealthAggDO[] update(PeevalsubhealthAggDO[] aggdos) throws BizException;
	
	/**
	*  体检亚健康评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeevalsubhealthAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检亚健康评估定义数据真删除
	 */
	public abstract void deleteByParentDO(PeEvalSubhealthDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检亚健康评估定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeEvalSubhealthDO[] mainDos) throws BizException;
}
