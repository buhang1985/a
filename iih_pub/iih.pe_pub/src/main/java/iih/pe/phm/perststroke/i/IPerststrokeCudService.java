package iih.pe.phm.perststroke.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.perststroke.d.PeRstStrokeDO;
import iih.pe.phm.perststroke.d.PerststrokeAggDO;

/**
* 健康管理_脑卒中评估结果数据维护服务
*/
public interface IPerststrokeCudService {
	/**
	*  健康管理_脑卒中评估结果数据真删除
	*/
    public abstract void delete(PerststrokeAggDO[] aggdos) throws BizException;
    
    /**
	*  健康管理_脑卒中评估结果数据插入保存
	*/
	public abstract PerststrokeAggDO[] insert(PerststrokeAggDO[] aggdos) throws BizException;
	
    /**
	*  健康管理_脑卒中评估结果数据保存
	*/
	public abstract PerststrokeAggDO[] save(PerststrokeAggDO[] aggdos) throws BizException;
	
    /**
	*  健康管理_脑卒中评估结果数据更新
	*/
	public abstract PerststrokeAggDO[] update(PerststrokeAggDO[] aggdos) throws BizException;
	
	/**
	*  健康管理_脑卒中评估结果数据逻辑删除
	*/
	public abstract void logicDelete(PerststrokeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康管理_脑卒中评估结果数据真删除
	 */
	public abstract void deleteByParentDO(PeRstStrokeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康管理_脑卒中评估结果数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstStrokeDO[] mainDos) throws BizException;
}
