package iih.bd.srv.mrfpbltype.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;
import iih.bd.srv.mrfpbltype.d.MrfpbltypeAggDO;

/**
* 病案首页费用分类数据维护服务
*/
public interface IMrfpbltypeCudService {
	/**
	*  病案首页费用分类数据真删除
	*/
    public abstract void delete(MrfpbltypeAggDO[] aggdos) throws BizException;
    
    /**
	*  病案首页费用分类数据插入保存
	*/
	public abstract MrfpbltypeAggDO[] insert(MrfpbltypeAggDO[] aggdos) throws BizException;
	
    /**
	*  病案首页费用分类数据保存
	*/
	public abstract MrfpbltypeAggDO[] save(MrfpbltypeAggDO[] aggdos) throws BizException;
	
    /**
	*  病案首页费用分类数据更新
	*/
	public abstract MrfpbltypeAggDO[] update(MrfpbltypeAggDO[] aggdos) throws BizException;
	
	/**
	*  病案首页费用分类数据逻辑删除
	*/
	public abstract void logicDelete(MrfpbltypeAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病案首页费用分类数据真删除
	 */
	public abstract void deleteByParentDO(MrFpBlTypeDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病案首页费用分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MrFpBlTypeDO[] mainDos) throws BizException;
}
