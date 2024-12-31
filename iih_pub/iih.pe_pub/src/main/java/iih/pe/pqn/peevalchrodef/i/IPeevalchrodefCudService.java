package iih.pe.pqn.peevalchrodef.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peevalchrodef.d.PeEvalChroDefDO;
import iih.pe.pqn.peevalchrodef.d.PeevalchrodefAggDO;

/**
* 体检慢性病评估定义数据维护服务
*/
public interface IPeevalchrodefCudService {
	/**
	*  体检慢性病评估定义数据真删除
	*/
    public abstract void delete(PeevalchrodefAggDO[] aggdos) throws BizException;
    
    /**
	*  体检慢性病评估定义数据插入保存
	*/
	public abstract PeevalchrodefAggDO[] insert(PeevalchrodefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病评估定义数据保存
	*/
	public abstract PeevalchrodefAggDO[] save(PeevalchrodefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检慢性病评估定义数据更新
	*/
	public abstract PeevalchrodefAggDO[] update(PeevalchrodefAggDO[] aggdos) throws BizException;
	
	/**
	*  体检慢性病评估定义数据逻辑删除
	*/
	public abstract void logicDelete(PeevalchrodefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检慢性病评估定义数据真删除
	 */
	public abstract void deleteByParentDO(PeEvalChroDefDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检慢性病评估定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeEvalChroDefDO[] mainDos) throws BizException;
}
