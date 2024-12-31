package iih.bd.res.opt.i;

import xap.mw.core.data.BizException;
import iih.bd.res.opt.d.OptDO;
import iih.bd.res.opt.d.OptAggDO;

/**
* 手术台数据维护服务
*/
public interface IOptCudService {
	/**
	*  手术台数据真删除
	*/
    public abstract void delete(OptAggDO[] aggdos) throws BizException;
    
    /**
	*  手术台数据插入保存
	*/
	public abstract OptAggDO[] insert(OptAggDO[] aggdos) throws BizException;
	
    /**
	*  手术台数据保存
	*/
	public abstract OptAggDO[] save(OptAggDO[] aggdos) throws BizException;
	
    /**
	*  手术台数据更新
	*/
	public abstract OptAggDO[] update(OptAggDO[] aggdos) throws BizException;
	
	/**
	*  手术台数据逻辑删除
	*/
	public abstract void logicDelete(OptAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对手术台数据真删除
	 */
	public abstract void deleteByParentDO(OptDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对手术台数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OptDO[] mainDos) throws BizException;
}
