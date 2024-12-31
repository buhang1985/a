package iih.pe.pqn.peqacatlog.i;

import xap.mw.core.data.BizException;
import iih.pe.pqn.peqacatlog.d.PeQaCatDO;
import iih.pe.pqn.peqacatlog.d.PeqacatlogAggDO;

/**
* 体检问卷问题分组数据维护服务
*/
public interface IPeqacatlogCudService {
	/**
	*  体检问卷问题分组数据真删除
	*/
    public abstract void delete(PeqacatlogAggDO[] aggdos) throws BizException;
    
    /**
	*  体检问卷问题分组数据插入保存
	*/
	public abstract PeqacatlogAggDO[] insert(PeqacatlogAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷问题分组数据保存
	*/
	public abstract PeqacatlogAggDO[] save(PeqacatlogAggDO[] aggdos) throws BizException;
	
    /**
	*  体检问卷问题分组数据更新
	*/
	public abstract PeqacatlogAggDO[] update(PeqacatlogAggDO[] aggdos) throws BizException;
	
	/**
	*  体检问卷问题分组数据逻辑删除
	*/
	public abstract void logicDelete(PeqacatlogAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷问题分组数据真删除
	 */
	public abstract void deleteByParentDO(PeQaCatDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检问卷问题分组数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeQaCatDO[] mainDos) throws BizException;
}
