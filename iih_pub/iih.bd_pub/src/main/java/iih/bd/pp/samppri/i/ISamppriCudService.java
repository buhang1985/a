package iih.bd.pp.samppri.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.samppri.d.SampPriDO;
import iih.bd.pp.samppri.d.SamppriAggDO;

/**
* 标本费用对照数据维护服务
*/
public interface ISamppriCudService {
	/**
	*  标本费用对照数据真删除
	*/
    public abstract void delete(SamppriAggDO[] aggdos) throws BizException;
    
    /**
	*  标本费用对照数据插入保存
	*/
	public abstract SamppriAggDO[] insert(SamppriAggDO[] aggdos) throws BizException;
	
    /**
	*  标本费用对照数据保存
	*/
	public abstract SamppriAggDO[] save(SamppriAggDO[] aggdos) throws BizException;
	
    /**
	*  标本费用对照数据更新
	*/
	public abstract SamppriAggDO[] update(SamppriAggDO[] aggdos) throws BizException;
	
	/**
	*  标本费用对照数据逻辑删除
	*/
	public abstract void logicDelete(SamppriAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对标本费用对照数据真删除
	 */
	public abstract void deleteByParentDO(SampPriDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对标本费用对照数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SampPriDO[] mainDos) throws BizException;
}
