package iih.bd.fc.mdwfconfig.i;

import xap.mw.core.data.BizException;
import  iih.bd.fc.mdwfconfig.d.MdwfconfigAggDO;

/**
* 组件数据维护服务
*/
public interface IMdwfconfigCudService {
	/**
	*  组件数据删除
	*/
    public abstract void delete(MdwfconfigAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract MdwfconfigAggDO[] insert(MdwfconfigAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract MdwfconfigAggDO[] save(MdwfconfigAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract MdwfconfigAggDO[] update(MdwfconfigAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据真删
	*/
	public abstract void logicDelete(MdwfconfigAggDO[] aggdos) throws BizException;
}
