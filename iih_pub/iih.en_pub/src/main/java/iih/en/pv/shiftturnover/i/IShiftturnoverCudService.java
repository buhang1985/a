package iih.en.pv.shiftturnover.i;

import xap.mw.core.data.BizException;
import iih.en.pv.shiftturnover.d.ShiftTurnOverDO;
import iih.en.pv.shiftturnover.d.ShiftturnoverAggDO;

/**
* 医生交接班数据维护服务
*/
public interface IShiftturnoverCudService {
	/**
	*  医生交接班数据真删除
	*/
    public abstract void delete(ShiftturnoverAggDO[] aggdos) throws BizException;
    
    /**
	*  医生交接班数据插入保存
	*/
	public abstract ShiftturnoverAggDO[] insert(ShiftturnoverAggDO[] aggdos) throws BizException;
	
    /**
	*  医生交接班数据保存
	*/
	public abstract ShiftturnoverAggDO[] save(ShiftturnoverAggDO[] aggdos) throws BizException;
	
    /**
	*  医生交接班数据更新
	*/
	public abstract ShiftturnoverAggDO[] update(ShiftturnoverAggDO[] aggdos) throws BizException;
	
	/**
	*  医生交接班数据逻辑删除
	*/
	public abstract void logicDelete(ShiftturnoverAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医生交接班数据真删除
	 */
	public abstract void deleteByParentDO(ShiftTurnOverDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医生交接班数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ShiftTurnOverDO[] mainDos) throws BizException;
}
