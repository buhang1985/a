package iih.nmr.pkuf.carecord.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.carecord.d.CarecorDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理记录单数据维护服务
*/
public interface ICarecord1MDOCudService {
	/**
	*  护理记录单数据真删除
	*/
    public abstract void delete(CarecorDO[] aggdos) throws BizException;
    
    /**
	*  护理记录单数据插入保存
	*/
	public abstract CarecorDO[] insert(CarecorDO[] aggdos) throws BizException;
	
    /**
	*  护理记录单数据保存
	*/
	public abstract CarecorDO[] save(CarecorDO[] aggdos) throws BizException;
	
    /**
	*  护理记录单数据更新
	*/
	public abstract CarecorDO[] update(CarecorDO[] aggdos) throws BizException;
	
	/**
	*  护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(CarecorDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CarecorDO[] enableWithoutFilter(CarecorDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CarecorDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CarecorDO[] disableVOWithoutFilter(CarecorDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CarecorDO[] aggdos) throws BizException ;
	
}
