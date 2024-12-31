package iih.bd.srv.ems.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ems.d.EmsPrnTmplRelPresDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医疗单打印模板管理数据维护服务
*/
public interface IEmsPrnTmplRelPresDOCudService {
	/**
	*  医疗单打印模板管理数据真删除
	*/
    public abstract void delete(EmsPrnTmplRelPresDO[] aggdos) throws BizException;
    
    /**
	*  医疗单打印模板管理数据插入保存
	*/
	public abstract EmsPrnTmplRelPresDO[] insert(EmsPrnTmplRelPresDO[] aggdos) throws BizException;
	
    /**
	*  医疗单打印模板管理数据保存
	*/
	public abstract EmsPrnTmplRelPresDO[] save(EmsPrnTmplRelPresDO[] aggdos) throws BizException;
	
    /**
	*  医疗单打印模板管理数据更新
	*/
	public abstract EmsPrnTmplRelPresDO[] update(EmsPrnTmplRelPresDO[] aggdos) throws BizException;
	
	/**
	*  医疗单打印模板管理数据逻辑删除
	*/
	public abstract void logicDelete(EmsPrnTmplRelPresDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmsPrnTmplRelPresDO[] enableWithoutFilter(EmsPrnTmplRelPresDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmsPrnTmplRelPresDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmsPrnTmplRelPresDO[] disableVOWithoutFilter(EmsPrnTmplRelPresDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmsPrnTmplRelPresDO[] aggdos) throws BizException ;
	
}
