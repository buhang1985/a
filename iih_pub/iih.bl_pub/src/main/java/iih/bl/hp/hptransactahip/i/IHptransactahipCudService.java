package iih.bl.hp.hptransactahip.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hptransactahip.d.HpTransActAhIpDO;
import iih.bl.hp.hptransactahip.d.HptransactahipAggDO;

/**
* 安徽医保住院数据维护服务
*/
public interface IHptransactahipCudService {
	/**
	*  安徽医保住院数据真删除
	*/
    public abstract void delete(HptransactahipAggDO[] aggdos) throws BizException;
    
    /**
	*  安徽医保住院数据插入保存
	*/
	public abstract HptransactahipAggDO[] insert(HptransactahipAggDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保住院数据保存
	*/
	public abstract HptransactahipAggDO[] save(HptransactahipAggDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保住院数据更新
	*/
	public abstract HptransactahipAggDO[] update(HptransactahipAggDO[] aggdos) throws BizException;
	
	/**
	*  安徽医保住院数据逻辑删除
	*/
	public abstract void logicDelete(HptransactahipAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对安徽医保住院数据真删除
	 */
	public abstract void deleteByParentDO(HpTransActAhIpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对安徽医保住院数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HpTransActAhIpDO[] mainDos) throws BizException;
}
