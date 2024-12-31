package iih.bd.srv.diagcate.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.d.DiagcateAggDO;

/**
* 疾病诊断分类数据维护服务
*/
public interface IDiagcateCudService {
	/**
	*  疾病诊断分类数据真删除
	*/
    public abstract void delete(DiagcateAggDO[] aggdos) throws BizException;
    
    /**
	*  疾病诊断分类数据插入保存
	*/
	public abstract DiagcateAggDO[] insert(DiagcateAggDO[] aggdos) throws BizException;
	
    /**
	*  疾病诊断分类数据保存
	*/
	public abstract DiagcateAggDO[] save(DiagcateAggDO[] aggdos) throws BizException;
	
    /**
	*  疾病诊断分类数据更新
	*/
	public abstract DiagcateAggDO[] update(DiagcateAggDO[] aggdos) throws BizException;
	
	/**
	*  疾病诊断分类数据逻辑删除
	*/
	public abstract void logicDelete(DiagcateAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对疾病诊断分类数据真删除
	 */
	public abstract void deleteByParentDO(DiagCateDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对疾病诊断分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DiagCateDO[] mainDos) throws BizException;
}
