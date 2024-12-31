package iih.bd.pp.bdbltpl.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;

/**
* 自定义费用模板数据维护服务
*/
public interface IBdbltplCudService {
	/**
	*  自定义费用模板数据真删除
	*/
    public abstract void delete(BdbltplAggDO[] aggdos) throws BizException;
    
    /**
	*  自定义费用模板数据插入保存
	*/
	public abstract BdbltplAggDO[] insert(BdbltplAggDO[] aggdos) throws BizException;
	
    /**
	*  自定义费用模板数据保存
	*/
	public abstract BdbltplAggDO[] save(BdbltplAggDO[] aggdos) throws BizException;
	
    /**
	*  自定义费用模板数据更新
	*/
	public abstract BdbltplAggDO[] update(BdbltplAggDO[] aggdos) throws BizException;
	
	/**
	*  自定义费用模板数据逻辑删除
	*/
	public abstract void logicDelete(BdbltplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对自定义费用模板数据真删除
	 */
	public abstract void deleteByParentDO(BdBlTplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对自定义费用模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BdBlTplDO[] mainDos) throws BizException;
}
