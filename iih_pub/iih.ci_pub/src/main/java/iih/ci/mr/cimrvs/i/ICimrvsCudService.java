package iih.ci.mr.cimrvs.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.cimrvs.d.CiMrVsDO;
import iih.ci.mr.cimrvs.d.CimrvsAggDO;

/**
* 临床生命体征测量数据维护服务
*/
public interface ICimrvsCudService {
	/**
	*  临床生命体征测量数据真删除
	*/
    public abstract void delete(CimrvsAggDO[] aggdos) throws BizException;
    
    /**
	*  临床生命体征测量数据插入保存
	*/
	public abstract CimrvsAggDO[] insert(CimrvsAggDO[] aggdos) throws BizException;
	
    /**
	*  临床生命体征测量数据保存
	*/
	public abstract CimrvsAggDO[] save(CimrvsAggDO[] aggdos) throws BizException;
	
    /**
	*  临床生命体征测量数据更新
	*/
	public abstract CimrvsAggDO[] update(CimrvsAggDO[] aggdos) throws BizException;
	
	/**
	*  临床生命体征测量数据逻辑删除
	*/
	public abstract void logicDelete(CimrvsAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对临床生命体征测量数据真删除
	 */
	public abstract void deleteByParentDO(CiMrVsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对临床生命体征测量数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiMrVsDO[] mainDos) throws BizException;
}
