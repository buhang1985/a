package iih.pe.pitm.peitflisitm.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.peitflisitm.d.PeItfLisPartDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检接口_LIS明细数据维护服务
*/
public interface IPeitflisitmMDOCudService {
	/**
	*  体检接口_LIS明细数据真删除
	*/
    public abstract void delete(PeItfLisPartDO[] aggdos) throws BizException;
    
    /**
	*  体检接口_LIS明细数据插入保存
	*/
	public abstract PeItfLisPartDO[] insert(PeItfLisPartDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS明细数据保存
	*/
	public abstract PeItfLisPartDO[] save(PeItfLisPartDO[] aggdos) throws BizException;
	
    /**
	*  体检接口_LIS明细数据更新
	*/
	public abstract PeItfLisPartDO[] update(PeItfLisPartDO[] aggdos) throws BizException;
	
	/**
	*  体检接口_LIS明细数据逻辑删除
	*/
	public abstract void logicDelete(PeItfLisPartDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeItfLisPartDO[] enableWithoutFilter(PeItfLisPartDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeItfLisPartDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeItfLisPartDO[] disableVOWithoutFilter(PeItfLisPartDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeItfLisPartDO[] aggdos) throws BizException ;
	
}
