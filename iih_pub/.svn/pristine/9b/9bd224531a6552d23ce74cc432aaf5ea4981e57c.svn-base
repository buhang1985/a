package iih.pe.pbd.peinstrument.i;

import xap.mw.core.data.BizException;
import iih.pe.pbd.peinstrument.d.PeInstItmRelDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 仪器设备定义数据维护服务
*/
public interface IPeInstItmRelDefDOCudService {
	/**
	*  仪器设备定义数据真删除
	*/
    public abstract void delete(PeInstItmRelDefDO[] aggdos) throws BizException;
    
    /**
	*  仪器设备定义数据插入保存
	*/
	public abstract PeInstItmRelDefDO[] insert(PeInstItmRelDefDO[] aggdos) throws BizException;
	
    /**
	*  仪器设备定义数据保存
	*/
	public abstract PeInstItmRelDefDO[] save(PeInstItmRelDefDO[] aggdos) throws BizException;
	
    /**
	*  仪器设备定义数据更新
	*/
	public abstract PeInstItmRelDefDO[] update(PeInstItmRelDefDO[] aggdos) throws BizException;
	
	/**
	*  仪器设备定义数据逻辑删除
	*/
	public abstract void logicDelete(PeInstItmRelDefDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeInstItmRelDefDO[] enableWithoutFilter(PeInstItmRelDefDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeInstItmRelDefDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeInstItmRelDefDO[] disableVOWithoutFilter(PeInstItmRelDefDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeInstItmRelDefDO[] aggdos) throws BizException ;
	
}
