package iih.nm.nhr.nmdeppl.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmdeppl.d.NmDepplDO;
import iih.nm.nhr.nmdeppl.d.NmdepplAggDO;

/**
* 实习科室轮转计划数据维护服务
*/
public interface INmdepplCudService {
	/**
	*  实习科室轮转计划数据真删除
	*/
    public abstract void delete(NmdepplAggDO[] aggdos) throws BizException;
    
    /**
	*  实习科室轮转计划数据插入保存
	*/
	public abstract NmdepplAggDO[] insert(NmdepplAggDO[] aggdos) throws BizException;
	
    /**
	*  实习科室轮转计划数据保存
	*/
	public abstract NmdepplAggDO[] save(NmdepplAggDO[] aggdos) throws BizException;
	
    /**
	*  实习科室轮转计划数据更新
	*/
	public abstract NmdepplAggDO[] update(NmdepplAggDO[] aggdos) throws BizException;
	
	/**
	*  实习科室轮转计划数据逻辑删除
	*/
	public abstract void logicDelete(NmdepplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对实习科室轮转计划数据真删除
	 */
	public abstract void deleteByParentDO(NmDepplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对实习科室轮转计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmDepplDO[] mainDos) throws BizException;
}
