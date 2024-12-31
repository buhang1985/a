package iih.pis.ivx.pisivxsetting.i;

import xap.mw.core.data.BizException;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingDO;
import iih.pis.ivx.pisivxsetting.d.PisivxsettingAggDO;

/**
* 微信服务-微信服务号配置数据维护服务
*/
public interface IPisivxsettingCudService {
	/**
	*  微信服务-微信服务号配置数据真删除
	*/
    public abstract void delete(PisivxsettingAggDO[] aggdos) throws BizException;
    
    /**
	*  微信服务-微信服务号配置数据插入保存
	*/
	public abstract PisivxsettingAggDO[] insert(PisivxsettingAggDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-微信服务号配置数据保存
	*/
	public abstract PisivxsettingAggDO[] save(PisivxsettingAggDO[] aggdos) throws BizException;
	
    /**
	*  微信服务-微信服务号配置数据更新
	*/
	public abstract PisivxsettingAggDO[] update(PisivxsettingAggDO[] aggdos) throws BizException;
	
	/**
	*  微信服务-微信服务号配置数据逻辑删除
	*/
	public abstract void logicDelete(PisivxsettingAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对微信服务-微信服务号配置数据真删除
	 */
	public abstract void deleteByParentDO(PisIvxSettingDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对微信服务-微信服务号配置数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PisIvxSettingDO[] mainDos) throws BizException;
}
