package iih.hp.cp.appele.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.appele.d.HpCpAppElemDO;
import iih.hp.cp.appele.d.HpcpappeleAggDO;

/**
* 诊疗计划应用_元素数据维护服务
*/
public interface IHpcpappeleCudService {
	/**
	*  诊疗计划应用_元素数据真删除
	*/
    public abstract void delete(HpcpappeleAggDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划应用_元素数据插入保存
	*/
	public abstract HpcpappeleAggDO[] insert(HpcpappeleAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划应用_元素数据保存
	*/
	public abstract HpcpappeleAggDO[] save(HpcpappeleAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划应用_元素数据更新
	*/
	public abstract HpcpappeleAggDO[] update(HpcpappeleAggDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划应用_元素数据逻辑删除
	*/
	public abstract void logicDelete(HpcpappeleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对诊疗计划应用_元素数据真删除
	 */
	public abstract void deleteByParentDO(HpCpAppElemDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对诊疗计划应用_元素数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HpCpAppElemDO[] mainDos) throws BizException;
}
