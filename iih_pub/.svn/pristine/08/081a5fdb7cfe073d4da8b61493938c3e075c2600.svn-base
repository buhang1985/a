package iih.bd.srv.diagcatectm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.diagcatectm.d.DiCaCtmItmDO;
import iih.bd.srv.diagcatectm.d.DiagcatectmitmAggDO;

/**
* 疾病诊断自定义分类项目数据维护服务
*/
public interface IDiagcatectmitmCudService {
	/**
	*  疾病诊断自定义分类项目数据真删除
	*/
    public abstract void delete(DiagcatectmitmAggDO[] aggdos) throws BizException;
    
    /**
	*  疾病诊断自定义分类项目数据插入保存
	*/
	public abstract DiagcatectmitmAggDO[] insert(DiagcatectmitmAggDO[] aggdos) throws BizException;
	
    /**
	*  疾病诊断自定义分类项目数据保存
	*/
	public abstract DiagcatectmitmAggDO[] save(DiagcatectmitmAggDO[] aggdos) throws BizException;
	
    /**
	*  疾病诊断自定义分类项目数据更新
	*/
	public abstract DiagcatectmitmAggDO[] update(DiagcatectmitmAggDO[] aggdos) throws BizException;
	
	/**
	*  疾病诊断自定义分类项目数据逻辑删除
	*/
	public abstract void logicDelete(DiagcatectmitmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对疾病诊断自定义分类项目数据真删除
	 */
	public abstract void deleteByParentDO(DiCaCtmItmDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对疾病诊断自定义分类项目数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DiCaCtmItmDO[] mainDos) throws BizException;
}
