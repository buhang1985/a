package iih.bd.srv.srvortpl.i;

import xap.mw.core.data.BizException;
import  iih.bd.srv.srvortpl.d.SrvortplAggDO;

/**
* 医疗服务医嘱模板数据维护服务
*/
public interface ISrvortplCudService {
	/**
	*  医疗服务医嘱模板数据删除
	*/
    public abstract void delete(SrvortplAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务医嘱模板数据插入保存
	*/
	public abstract SrvortplAggDO[] insert(SrvortplAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务医嘱模板数据保存
	*/
	public abstract SrvortplAggDO[] save(SrvortplAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务医嘱模板数据更新
	*/
	public abstract SrvortplAggDO[] update(SrvortplAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务医嘱模板数据真删
	*/
	public abstract void logicDelete(SrvortplAggDO[] aggdos) throws BizException;
}
