package iih.sc.scbd.schedulechl.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.SchedulechlAggDO;

/**
* 排班预约渠道数据维护服务
*/
public interface ISchedulechlCudService {
	/**
	*  排班预约渠道数据真删除
	*/
    public abstract void delete(SchedulechlAggDO[] aggdos) throws BizException;
    
    /**
	*  排班预约渠道数据插入保存
	*/
	public abstract SchedulechlAggDO[] insert(SchedulechlAggDO[] aggdos) throws BizException;
	
    /**
	*  排班预约渠道数据保存
	*/
	public abstract SchedulechlAggDO[] save(SchedulechlAggDO[] aggdos) throws BizException;
	
    /**
	*  排班预约渠道数据更新
	*/
	public abstract SchedulechlAggDO[] update(SchedulechlAggDO[] aggdos) throws BizException;
	
	/**
	*  排班预约渠道数据逻辑删除
	*/
	public abstract void logicDelete(SchedulechlAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班预约渠道数据真删除
	 */
	public abstract void deleteByParentDO(SchedulechlDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班预约渠道数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SchedulechlDO[] mainDos) throws BizException;
}
