package iih.nm.nca.nmncatmpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nca.nmncatmpl.d.NmNcaTpmlDO;
import iih.nm.nca.nmncatmpl.d.NmncatmplAggDO;

/**
* 满意度问卷模板数据维护服务
*/
public interface INmncatmplCudService {
	/**
	*  满意度问卷模板数据真删除
	*/
    public abstract void delete(NmncatmplAggDO[] aggdos) throws BizException;
    
    /**
	*  满意度问卷模板数据插入保存
	*/
	public abstract NmncatmplAggDO[] insert(NmncatmplAggDO[] aggdos) throws BizException;
	
    /**
	*  满意度问卷模板数据保存
	*/
	public abstract NmncatmplAggDO[] save(NmncatmplAggDO[] aggdos) throws BizException;
	
    /**
	*  满意度问卷模板数据更新
	*/
	public abstract NmncatmplAggDO[] update(NmncatmplAggDO[] aggdos) throws BizException;
	
	/**
	*  满意度问卷模板数据逻辑删除
	*/
	public abstract void logicDelete(NmncatmplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对满意度问卷模板数据真删除
	 */
	public abstract void deleteByParentDO(NmNcaTpmlDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对满意度问卷模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NmNcaTpmlDO[] mainDos) throws BizException;
}
