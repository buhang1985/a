package iih.hp.cp.eletp.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.eletp.d.HpCpElemTypeDO;
import iih.hp.cp.eletp.d.HpcpeletpAggDO;

/**
* 诊疗计划元素类型数据维护服务
*/
public interface IHpcpeletpCudService {
	/**
	*  诊疗计划元素类型数据真删除
	*/
    public abstract void delete(HpcpeletpAggDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划元素类型数据插入保存
	*/
	public abstract HpcpeletpAggDO[] insert(HpcpeletpAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素类型数据保存
	*/
	public abstract HpcpeletpAggDO[] save(HpcpeletpAggDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素类型数据更新
	*/
	public abstract HpcpeletpAggDO[] update(HpcpeletpAggDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划元素类型数据逻辑删除
	*/
	public abstract void logicDelete(HpcpeletpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对诊疗计划元素类型数据真删除
	 */
	public abstract void deleteByParentDO(HpCpElemTypeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对诊疗计划元素类型数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HpCpElemTypeDO[] mainDos) throws BizException;
}
