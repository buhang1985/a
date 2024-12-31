package iih.mm.pl.departrequest.i;

import xap.mw.core.data.BizException;
import  iih.mm.pl.departrequest.d.DepartrequestAggDO;

/**
* 部门领用申请数据维护服务
*/
public interface IDepartrequestCudService {
	/**
	*  部门领用申请数据真删除
	*/
    public abstract void delete(DepartrequestAggDO[] aggdos) throws BizException;
    
    /**
	*  部门领用申请数据插入保存
	*/
	public abstract DepartrequestAggDO[] insert(DepartrequestAggDO[] aggdos) throws BizException;
	
    /**
	*  部门领用申请数据保存
	*/
	public abstract DepartrequestAggDO[] save(DepartrequestAggDO[] aggdos) throws BizException;
	
    /**
	*  部门领用申请数据更新
	*/
	public abstract DepartrequestAggDO[] update(DepartrequestAggDO[] aggdos) throws BizException;
	
	/**
	*  部门领用申请数据逻辑删除
	*/
	public abstract void logicDelete(DepartrequestAggDO[] aggdos) throws BizException;
}
