package iih.bl.hp.hptransactah.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import iih.bl.hp.hptransactah.d.HptransactahAggDO;

/**
* 安徽医保交易记录数据维护服务
*/
public interface IHptransactahCudService {
	/**
	*  安徽医保交易记录数据真删除
	*/
    public abstract void delete(HptransactahAggDO[] aggdos) throws BizException;
    
    /**
	*  安徽医保交易记录数据插入保存
	*/
	public abstract HptransactahAggDO[] insert(HptransactahAggDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保交易记录数据保存
	*/
	public abstract HptransactahAggDO[] save(HptransactahAggDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保交易记录数据更新
	*/
	public abstract HptransactahAggDO[] update(HptransactahAggDO[] aggdos) throws BizException;
	
	/**
	*  安徽医保交易记录数据逻辑删除
	*/
	public abstract void logicDelete(HptransactahAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对安徽医保交易记录数据真删除
	 */
	public abstract void deleteByParentDO(HpTransActAhDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对安徽医保交易记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(HpTransActAhDO[] mainDos) throws BizException;
}
