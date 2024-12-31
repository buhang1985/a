package iih.pe.pwf.perstlis.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.perstlis.d.PeRstLisDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检检验报告数据维护服务
*/
public interface IPerstlisMDOCudService {
	/**
	*  体检检验报告数据真删除
	*/
    public abstract void delete(PeRstLisDO[] aggdos) throws BizException;
    
    /**
	*  体检检验报告数据插入保存
	*/
	public abstract PeRstLisDO[] insert(PeRstLisDO[] aggdos) throws BizException;
	
    /**
	*  体检检验报告数据保存
	*/
	public abstract PeRstLisDO[] save(PeRstLisDO[] aggdos) throws BizException;
	
    /**
	*  体检检验报告数据更新
	*/
	public abstract PeRstLisDO[] update(PeRstLisDO[] aggdos) throws BizException;
	
	/**
	*  体检检验报告数据逻辑删除
	*/
	public abstract void logicDelete(PeRstLisDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeRstLisDO[] enableWithoutFilter(PeRstLisDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeRstLisDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeRstLisDO[] disableVOWithoutFilter(PeRstLisDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeRstLisDO[] aggdos) throws BizException ;
	
}
