package iih.bd.srv.diagdef.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;

/**
* 医疗服务_疾病诊断定义数据维护服务
*/
public interface IDiagdefCudService {
	/**
	*  医疗服务_疾病诊断定义数据真删除
	*/
    public abstract void delete(DiagdefAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务_疾病诊断定义数据插入保存
	*/
	public abstract DiagdefAggDO[] insert(DiagdefAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_疾病诊断定义数据保存
	*/
	public abstract DiagdefAggDO[] save(DiagdefAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务_疾病诊断定义数据更新
	*/
	public abstract DiagdefAggDO[] update(DiagdefAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务_疾病诊断定义数据逻辑删除
	*/
	public abstract void logicDelete(DiagdefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务_疾病诊断定义数据真删除
	 */
	public abstract void deleteByParentDO(DiagDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务_疾病诊断定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(DiagDefDO[] mainDos) throws BizException;
}
