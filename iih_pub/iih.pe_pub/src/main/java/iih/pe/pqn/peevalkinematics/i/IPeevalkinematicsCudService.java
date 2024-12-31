package iih.pe.pqn.peevalkinematics.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalkinematics.d.PeEvalKinematicsDO;
import iih.pe.pqn.peevalkinematics.d.PeevalkinematicsAggDO;

/**
* 健康评估-运动评估定义数据维护服务
*/
public interface IPeevalkinematicsCudService {
	/**
	*  健康评估-运动评估定义数据真删除
	*/
    public abstract void delete(PeevalkinematicsAggDO[] aggdos) throws BizException;
    
    /**
	*  健康评估-运动评估定义数据插入保存
	*/
	public abstract PeevalkinematicsAggDO[] insert(PeevalkinematicsAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-运动评估定义数据保存
	*/
	public abstract PeevalkinematicsAggDO[] save(PeevalkinematicsAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估-运动评估定义数据更新
	*/
	public abstract PeevalkinematicsAggDO[] update(PeevalkinematicsAggDO[] aggdos) throws BizException;
	
	/**
	*  健康评估-运动评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeevalkinematicsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康评估-运动评估定义数据真删除
	 */
	public abstract void deleteByParentDO(PeEvalKinematicsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康评估-运动评估定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeEvalKinematicsDO[] mainDos) throws BizException;
}
