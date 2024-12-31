package iih.mi.biz.mihptransact.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.mihptransact.d.MiHpTransActDO;
import iih.mi.biz.mihptransact.d.MihptransactAggDO;

/**
* 安徽医保交易记录数据维护服务
*/
public interface IMihptransactCudService {
	/**
	*  安徽医保交易记录数据真删除
	*/
    public abstract void delete(MihptransactAggDO[] aggdos) throws BizException;
    
    /**
	*  安徽医保交易记录数据插入保存
	*/
	public abstract MihptransactAggDO[] insert(MihptransactAggDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保交易记录数据保存
	*/
	public abstract MihptransactAggDO[] save(MihptransactAggDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保交易记录数据更新
	*/
	public abstract MihptransactAggDO[] update(MihptransactAggDO[] aggdos) throws BizException;
	
	/**
	*  安徽医保交易记录数据逻辑删除
	*/
	public abstract void logicDelete(MihptransactAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对安徽医保交易记录数据真删除
	 */
	public abstract void deleteByParentDO(MiHpTransActDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对安徽医保交易记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MiHpTransActDO[] mainDos) throws BizException;
}
