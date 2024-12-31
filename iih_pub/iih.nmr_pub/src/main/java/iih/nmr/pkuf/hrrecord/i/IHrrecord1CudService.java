package iih.nmr.pkuf.hrrecord.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.hrrecord.d.HrrecordDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 心率监测记录单数据维护服务
*/
public interface IHrrecord1CudService {
	/**
	*  心率监测记录单数据真删除
	*/
    public abstract void delete(HrrecordDO[] aggdos) throws BizException;
    
    /**
	*  心率监测记录单数据插入保存
	*/
	public abstract HrrecordDO[] insert(HrrecordDO[] aggdos) throws BizException;
	
    /**
	*  心率监测记录单数据保存
	*/
	public abstract HrrecordDO[] save(HrrecordDO[] aggdos) throws BizException;
	
    /**
	*  心率监测记录单数据更新
	*/
	public abstract HrrecordDO[] update(HrrecordDO[] aggdos) throws BizException;
	
	/**
	*  心率监测记录单数据逻辑删除
	*/
	public abstract void logicDelete(HrrecordDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HrrecordDO[] enableWithoutFilter(HrrecordDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HrrecordDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HrrecordDO[] disableVOWithoutFilter(HrrecordDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HrrecordDO[] dos) throws BizException ;
}
