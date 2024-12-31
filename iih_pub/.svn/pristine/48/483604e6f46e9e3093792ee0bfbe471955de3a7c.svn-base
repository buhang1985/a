package iih.sc.apt.scapt.i;

import xap.mw.core.data.BizException;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;

/**
* 计划排班_预约数据维护服务
*/
public interface IScaptCudService {
	/**
	*  计划排班_预约数据真删除
	*/
    public abstract void delete(ScaptAggDO[] aggdos) throws BizException;
    
    /**
	*  计划排班_预约数据插入保存
	*/
	public abstract ScaptAggDO[] insert(ScaptAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约数据保存
	*/
	public abstract ScaptAggDO[] save(ScaptAggDO[] aggdos) throws BizException;
	
    /**
	*  计划排班_预约数据更新
	*/
	public abstract ScaptAggDO[] update(ScaptAggDO[] aggdos) throws BizException;
	
	/**
	*  计划排班_预约数据逻辑删除
	*/
	public abstract void logicDelete(ScaptAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_预约数据真删除
	 */
	public abstract void deleteByParentDO(ScAptDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对计划排班_预约数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScAptDO[] mainDos) throws BizException;
}
