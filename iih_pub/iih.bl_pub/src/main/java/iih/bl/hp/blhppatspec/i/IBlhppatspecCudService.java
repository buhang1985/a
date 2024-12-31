package iih.bl.hp.blhppatspec.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import iih.bl.hp.blhppatspec.d.BlhppatspecAggDO;

/**
* 医保特殊病患者数据维护服务
*/
public interface IBlhppatspecCudService {
	/**
	*  医保特殊病患者数据真删除
	*/
    public abstract void delete(BlhppatspecAggDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病患者数据插入保存
	*/
	public abstract BlhppatspecAggDO[] insert(BlhppatspecAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者数据保存
	*/
	public abstract BlhppatspecAggDO[] save(BlhppatspecAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者数据更新
	*/
	public abstract BlhppatspecAggDO[] update(BlhppatspecAggDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病患者数据逻辑删除
	*/
	public abstract void logicDelete(BlhppatspecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病患者数据真删除
	 */
	public abstract void deleteByParentDO(BlHpPatSpecDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病患者数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlHpPatSpecDO[] mainDos) throws BizException;
}
