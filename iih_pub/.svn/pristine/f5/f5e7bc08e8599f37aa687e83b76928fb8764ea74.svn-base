package iih.nm.nit.nipracfbtmpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nipracfbtmpl.d.NiPracfbTmplItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 实习反馈模板数据维护服务
*/
public interface INiPracfbTmplItmDOCudService {
	/**
	*  实习反馈模板数据真删除
	*/
    public abstract void delete(NiPracfbTmplItmDO[] aggdos) throws BizException;
    
    /**
	*  实习反馈模板数据插入保存
	*/
	public abstract NiPracfbTmplItmDO[] insert(NiPracfbTmplItmDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈模板数据保存
	*/
	public abstract NiPracfbTmplItmDO[] save(NiPracfbTmplItmDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈模板数据更新
	*/
	public abstract NiPracfbTmplItmDO[] update(NiPracfbTmplItmDO[] aggdos) throws BizException;
	
	/**
	*  实习反馈模板数据逻辑删除
	*/
	public abstract void logicDelete(NiPracfbTmplItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NiPracfbTmplItmDO[] enableWithoutFilter(NiPracfbTmplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NiPracfbTmplItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NiPracfbTmplItmDO[] disableVOWithoutFilter(NiPracfbTmplItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NiPracfbTmplItmDO[] aggdos) throws BizException ;
	
}
