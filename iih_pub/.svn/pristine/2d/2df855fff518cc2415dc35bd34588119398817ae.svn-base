package iih.bd.srv.srvselfcaitm.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.srvselfcaitm.d.SrvSelfCaItemDO;
import iih.bd.srv.srvselfcaitm.d.SrvselfcaitmAggDO;

/**
* 服务自定义分类项目数据维护服务
*/
public interface ISrvselfcaitmCudService {
	/**
	*  服务自定义分类项目数据真删除
	*/
    public abstract void delete(SrvselfcaitmAggDO[] aggdos) throws BizException;
    
    /**
	*  服务自定义分类项目数据插入保存
	*/
	public abstract SrvselfcaitmAggDO[] insert(SrvselfcaitmAggDO[] aggdos) throws BizException;
	
    /**
	*  服务自定义分类项目数据保存
	*/
	public abstract SrvselfcaitmAggDO[] save(SrvselfcaitmAggDO[] aggdos) throws BizException;
	
    /**
	*  服务自定义分类项目数据更新
	*/
	public abstract SrvselfcaitmAggDO[] update(SrvselfcaitmAggDO[] aggdos) throws BizException;
	
	/**
	*  服务自定义分类项目数据逻辑删除
	*/
	public abstract void logicDelete(SrvselfcaitmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对服务自定义分类项目数据真删除
	 */
	public abstract void deleteByParentDO(SrvSelfCaItemDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对服务自定义分类项目数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SrvSelfCaItemDO[] mainDos) throws BizException;
}
