package iih.pe.pitm.peitflisitm.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.peitflisitm.d.PeItfLisItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检接口_LIS明细数据维护服务
*/
public interface IPeItfLisItmDOCudService {
	/**
	*  体检接口_LIS明细数据真删除
	*/
    public abstract void delete(PeItfLisItmDO[] aggdos) throws BizException;
    
    /**
	*  体检接口_LIS明细数据插入保存
	*/
	public abstract PeItfLisItmDO[] insert(PeItfLisItmDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS明细数据保存
	*/
	public abstract PeItfLisItmDO[] save(PeItfLisItmDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS明细数据更新
	*/
	public abstract PeItfLisItmDO[] update(PeItfLisItmDO[] aggdos) throws BizException;
	
	/**
	*  体检接口_LIS明细数据逻辑删除
	*/
	public abstract void logicDelete(PeItfLisItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeItfLisItmDO[] enableWithoutFilter(PeItfLisItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeItfLisItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeItfLisItmDO[] disableVOWithoutFilter(PeItfLisItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeItfLisItmDO[] aggdos) throws BizException ;
	
}
