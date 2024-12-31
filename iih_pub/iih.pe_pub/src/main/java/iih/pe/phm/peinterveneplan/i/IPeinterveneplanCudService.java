package iih.pe.phm.peinterveneplan.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peinterveneplan.d.PeIntervenePlanDO;
import iih.pe.phm.peinterveneplan.d.PeinterveneplanAggDO;

/**
* 健康干预个人计划数据维护服务
*/
public interface IPeinterveneplanCudService {
	/**
	*  健康干预个人计划数据真删除
	*/
    public abstract void delete(PeinterveneplanAggDO[] aggdos) throws BizException;
    
    /**
	*  健康干预个人计划数据插入保存
	*/
	public abstract PeinterveneplanAggDO[] insert(PeinterveneplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康干预个人计划数据保存
	*/
	public abstract PeinterveneplanAggDO[] save(PeinterveneplanAggDO[] aggdos) throws BizException;
	
    /**
	*  健康干预个人计划数据更新
	*/
	public abstract PeinterveneplanAggDO[] update(PeinterveneplanAggDO[] aggdos) throws BizException;
	
	/**
	*  健康干预个人计划数据逻辑删除
	*/
	public abstract void logicDelete(PeinterveneplanAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康干预个人计划数据真删除
	 */
	public abstract void deleteByParentDO(PeIntervenePlanDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康干预个人计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeIntervenePlanDO[] mainDos) throws BizException;
}
