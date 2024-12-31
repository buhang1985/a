package iih.pis.ivx.pisivxsrvact.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxsrvact.d.PisIvxSrvactDO;
import iih.pis.ivx.pisivxsrvact.d.PisivxsrvactAggDO;

/**
* 微信服务号数据维护服务
*/
public interface IPisivxsrvactCudService {
	/**
	*  微信服务号数据真删除
	*/
    public abstract void delete(PisivxsrvactAggDO[] aggdos) throws BizException;
    
    /**
	*  微信服务号数据插入保存
	*/
	public abstract PisivxsrvactAggDO[] insert(PisivxsrvactAggDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号数据保存
	*/
	public abstract PisivxsrvactAggDO[] save(PisivxsrvactAggDO[] aggdos) throws BizException;
	
    /**
	*  微信服务号数据更新
	*/
	public abstract PisivxsrvactAggDO[] update(PisivxsrvactAggDO[] aggdos) throws BizException;
	
	/**
	*  微信服务号数据逻辑删除
	*/
	public abstract void logicDelete(PisivxsrvactAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对微信服务号数据真删除
	 */
	public abstract void deleteByParentDO(PisIvxSrvactDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对微信服务号数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PisIvxSrvactDO[] mainDos) throws BizException;
}
