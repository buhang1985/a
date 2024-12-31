package iih.cssd.dpbd.pkg.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpbd.pkg.d.CssdPkgDO;
import iih.cssd.dpbd.pkg.d.PkgAggDO;

/**
* 消毒包定义数据维护服务
*/
public interface IPkgCudService {
	/**
	*  消毒包定义数据真删除
	*/
    public abstract void delete(PkgAggDO[] aggdos) throws BizException;
    
    /**
	*  消毒包定义数据插入保存
	*/
	public abstract PkgAggDO[] insert(PkgAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包定义数据保存
	*/
	public abstract PkgAggDO[] save(PkgAggDO[] aggdos) throws BizException;
	
    /**
	*  消毒包定义数据更新
	*/
	public abstract PkgAggDO[] update(PkgAggDO[] aggdos) throws BizException;
	
	/**
	*  消毒包定义数据逻辑删除
	*/
	public abstract void logicDelete(PkgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对消毒包定义数据真删除
	 */
	public abstract void deleteByParentDO(CssdPkgDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对消毒包定义数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CssdPkgDO[] mainDos) throws BizException;
}
