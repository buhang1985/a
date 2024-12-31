package iih.pe.pitm.perstdidef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perstdidef.d.PeRstDiDefDO;
import iih.pe.pitm.perstdidef.d.PerstdidefAggDO;

/**
* 体检诊断定义数据维护服务
*/
public interface IPerstdidefCudService {
	/**
	*  体检诊断定义数据真删除
	*/
    public abstract void delete(PerstdidefAggDO[] aggdos) throws BizException;
    
    /**
	*  体检诊断定义数据插入保存
	*/
	public abstract PerstdidefAggDO[] insert(PerstdidefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断定义数据保存
	*/
	public abstract PerstdidefAggDO[] save(PerstdidefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检诊断定义数据更新
	*/
	public abstract PerstdidefAggDO[] update(PerstdidefAggDO[] aggdos) throws BizException;
	
	/**
	*  体检诊断定义数据逻辑删除
	*/
	public abstract void logicDelete(PerstdidefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检诊断定义数据真删除
	 */
	public abstract void deleteByParentDO(PeRstDiDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检诊断定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstDiDefDO[] mainDos) throws BizException;
}
