package iih.bd.pp.bdpripkg.i;

import xap.mw.core.data.BizException;
import  iih.bd.pp.bdpripkg.d.BdpripkgAggDO;

/**
* 组件数据维护服务
*/
public interface IBdpripkgCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BdpripkgAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BdpripkgAggDO[] insert(BdpripkgAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BdpripkgAggDO[] save(BdpripkgAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BdpripkgAggDO[] update(BdpripkgAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BdpripkgAggDO[] aggdos) throws BizException;
}
