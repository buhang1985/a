package iih.hp.cp.ele.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.ele.d.HpCpElemDO;
import iih.hp.cp.ele.d.HpcpeleAggDO;

/**
* 诊疗计划元素数据维护服务
*/
public interface IHpcpeleCudService {
	/**
	*  诊疗计划元素数据真删除
	*/
    public abstract void delete(HpcpeleAggDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划元素数据插入保存
	*/
	public abstract HpcpeleAggDO[] insert(HpcpeleAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素数据保存
	*/
	public abstract HpcpeleAggDO[] save(HpcpeleAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素数据更新
	*/
	public abstract HpcpeleAggDO[] update(HpcpeleAggDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划元素数据逻辑删除
	*/
	public abstract void logicDelete(HpcpeleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对诊疗计划元素数据真删除
	 */
	public abstract void deleteByParentDO(HpCpElemDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对诊疗计划元素数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HpCpElemDO[] mainDos) throws BizException;
}
