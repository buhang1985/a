package iih.ci.mr.nu.prescforoper.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.prescforoper.d.PrescforDO;
import iih.ci.mr.nu.prescforoper.d.PrescforoperAggDO;

/**
* 手术室患者压疮危险因素评分数据维护服务
*/
public interface IPrescforoperCudService {
	/**
	*  手术室患者压疮危险因素评分数据真删除
	*/
    public abstract void delete(PrescforoperAggDO[] aggdos) throws BizException;
    
    /**
	*  手术室患者压疮危险因素评分数据插入保存
	*/
	public abstract PrescforoperAggDO[] insert(PrescforoperAggDO[] aggdos) throws BizException;
	
    /**
	*  手术室患者压疮危险因素评分数据保存
	*/
	public abstract PrescforoperAggDO[] save(PrescforoperAggDO[] aggdos) throws BizException;
	
    /**
	*  手术室患者压疮危险因素评分数据更新
	*/
	public abstract PrescforoperAggDO[] update(PrescforoperAggDO[] aggdos) throws BizException;
	
	/**
	*  手术室患者压疮危险因素评分数据逻辑删除
	*/
	public abstract void logicDelete(PrescforoperAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对手术室患者压疮危险因素评分数据真删除
	 */
	public abstract void deleteByParentDO(PrescforDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对手术室患者压疮危险因素评分数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PrescforDO[] mainDos) throws BizException;
}
