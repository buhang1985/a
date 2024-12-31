package iih.nm.nit.nitpracgrppl.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpracgrppl.d.NitPracgrpPlDO;
import iih.nm.nit.nitpracgrppl.d.NitpracgrpplAggDO;

/**
* 小组计划数据维护服务
*/
public interface INitpracgrpplCudService {
	/**
	*  小组计划数据真删除
	*/
    public abstract void delete(NitpracgrpplAggDO[] aggdos) throws BizException;
    
    /**
	*  小组计划数据插入保存
	*/
	public abstract NitpracgrpplAggDO[] insert(NitpracgrpplAggDO[] aggdos) throws BizException;
	
    /**
	*  小组计划数据保存
	*/
	public abstract NitpracgrpplAggDO[] save(NitpracgrpplAggDO[] aggdos) throws BizException;
	
    /**
	*  小组计划数据更新
	*/
	public abstract NitpracgrpplAggDO[] update(NitpracgrpplAggDO[] aggdos) throws BizException;
	
	/**
	*  小组计划数据逻辑删除
	*/
	public abstract void logicDelete(NitpracgrpplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对小组计划数据真删除
	 */
	public abstract void deleteByParentDO(NitPracgrpPlDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对小组计划数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NitPracgrpPlDO[] mainDos) throws BizException;
}
