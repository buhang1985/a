package iih.nm.nhr.nmoptpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmoptpl.d.NmOptPlDO;
import iih.nm.nhr.nmoptpl.d.NmoptplAggDO;

/**
* 实习计划数据维护服务
*/
public interface INmoptplCudService {
	/**
	*  实习计划数据真删除
	*/
    public abstract void delete(NmoptplAggDO[] aggdos) throws BizException;
    
    /**
	*  实习计划数据插入保存
	*/
	public abstract NmoptplAggDO[] insert(NmoptplAggDO[] aggdos) throws BizException;
	
    /**
	*  实习计划数据保存
	*/
	public abstract NmoptplAggDO[] save(NmoptplAggDO[] aggdos) throws BizException;
	
    /**
	*  实习计划数据更新
	*/
	public abstract NmoptplAggDO[] update(NmoptplAggDO[] aggdos) throws BizException;
	
	/**
	*  实习计划数据逻辑删除
	*/
	public abstract void logicDelete(NmoptplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对实习计划数据真删除
	 */
	public abstract void deleteByParentDO(NmOptPlDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对实习计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmOptPlDO[] mainDos) throws BizException;
}
