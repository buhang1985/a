package iih.pe.pitm.pepsydef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pepsydef.d.PePsyTpDO;
import iih.pe.pitm.pepsydef.d.PepsydefAggDO;

/**
* 体检心理处方定义数据维护服务
*/
public interface IPepsydefCudService {
	/**
	*  体检心理处方定义数据真删除
	*/
    public abstract void delete(PepsydefAggDO[] aggdos) throws BizException;
    
    /**
	*  体检心理处方定义数据插入保存
	*/
	public abstract PepsydefAggDO[] insert(PepsydefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检心理处方定义数据保存
	*/
	public abstract PepsydefAggDO[] save(PepsydefAggDO[] aggdos) throws BizException;
	
    /**
	*  体检心理处方定义数据更新
	*/
	public abstract PepsydefAggDO[] update(PepsydefAggDO[] aggdos) throws BizException;
	
	/**
	*  体检心理处方定义数据逻辑删除
	*/
	public abstract void logicDelete(PepsydefAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检心理处方定义数据真删除
	 */
	public abstract void deleteByParentDO(PePsyTpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检心理处方定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PePsyTpDO[] mainDos) throws BizException;
}
