package iih.pi.patsrvpkg.pipatsrvpkgitem.i;

import xap.mw.core.data.BizException;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PiPatSrvPkgItmDO;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PipatsrvpkgitemAggDO;

/**
* 患者服务包服务项目对照数据维护服务
*/
public interface IPipatsrvpkgitemCudService {
	/**
	*  患者服务包服务项目对照数据真删除
	*/
    public abstract void delete(PipatsrvpkgitemAggDO[] aggdos) throws BizException;
    
    /**
	*  患者服务包服务项目对照数据插入保存
	*/
	public abstract PipatsrvpkgitemAggDO[] insert(PipatsrvpkgitemAggDO[] aggdos) throws BizException;
	
    /**
	*  患者服务包服务项目对照数据保存
	*/
	public abstract PipatsrvpkgitemAggDO[] save(PipatsrvpkgitemAggDO[] aggdos) throws BizException;
	
    /**
	*  患者服务包服务项目对照数据更新
	*/
	public abstract PipatsrvpkgitemAggDO[] update(PipatsrvpkgitemAggDO[] aggdos) throws BizException;
	
	/**
	*  患者服务包服务项目对照数据逻辑删除
	*/
	public abstract void logicDelete(PipatsrvpkgitemAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者服务包服务项目对照数据真删除
	 */
	public abstract void deleteByParentDO(PiPatSrvPkgItmDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者服务包服务项目对照数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PiPatSrvPkgItmDO[] mainDos) throws BizException;
}
