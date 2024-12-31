package iih.pe.phm.persticvd.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.persticvd.d.PeRstIcvdDO;
import iih.pe.phm.persticvd.d.PersticvdAggDO;

/**
* 健康管理_缺血性冠心病评估结果数据维护服务
*/
public interface IPersticvdCudService {
	/**
	*  健康管理_缺血性冠心病评估结果数据真删除
	*/
    public abstract void delete(PersticvdAggDO[] aggdos) throws BizException;
    
    /**
	*  健康管理_缺血性冠心病评估结果数据插入保存
	*/
	public abstract PersticvdAggDO[] insert(PersticvdAggDO[] aggdos) throws BizException;
	
    /**
	*  健康管理_缺血性冠心病评估结果数据保存
	*/
	public abstract PersticvdAggDO[] save(PersticvdAggDO[] aggdos) throws BizException;
	
    /**
	*  健康管理_缺血性冠心病评估结果数据更新
	*/
	public abstract PersticvdAggDO[] update(PersticvdAggDO[] aggdos) throws BizException;
	
	/**
	*  健康管理_缺血性冠心病评估结果数据逻辑删除
	*/
	public abstract void logicDelete(PersticvdAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康管理_缺血性冠心病评估结果数据真删除
	 */
	public abstract void deleteByParentDO(PeRstIcvdDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康管理_缺血性冠心病评估结果数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstIcvdDO[] mainDos) throws BizException;
}
