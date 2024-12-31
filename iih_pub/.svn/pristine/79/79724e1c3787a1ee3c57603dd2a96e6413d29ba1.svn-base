package iih.mp.orm.instrumentca.i;

import xap.mw.core.data.BizException;
import iih.mp.orm.instrumentca.d.InstrumentCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 器械分类数据维护服务
*/
public interface IInstrumentcaCudService {
	/**
	*  器械分类数据真删除
	*/
    public abstract void delete(InstrumentCaDO[] aggdos) throws BizException;
    
    /**
	*  器械分类数据插入保存
	*/
	public abstract InstrumentCaDO[] insert(InstrumentCaDO[] aggdos) throws BizException;
	
    /**
	*  器械分类数据保存
	*/
	public abstract InstrumentCaDO[] save(InstrumentCaDO[] aggdos) throws BizException;
	
    /**
	*  器械分类数据更新
	*/
	public abstract InstrumentCaDO[] update(InstrumentCaDO[] aggdos) throws BizException;
	
	/**
	*  器械分类数据逻辑删除
	*/
	public abstract void logicDelete(InstrumentCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public InstrumentCaDO[] enableWithoutFilter(InstrumentCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(InstrumentCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public InstrumentCaDO[] disableVOWithoutFilter(InstrumentCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(InstrumentCaDO[] dos) throws BizException ;
}
