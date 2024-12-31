package iih.en.pv.vt.i;

import xap.mw.core.data.BizException;
import iih.en.pv.vt.d.EnVtDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 就诊_体征数据维护服务
*/
public interface IEnvtMDOCudService {
	/**
	*  就诊_体征数据真删除
	*/
    public abstract void delete(EnVtDO[] aggdos) throws BizException;
    
    /**
	*  就诊_体征数据插入保存
	*/
	public abstract EnVtDO[] insert(EnVtDO[] aggdos) throws BizException;
	
    /**
	*  就诊_体征数据保存
	*/
	public abstract EnVtDO[] save(EnVtDO[] aggdos) throws BizException;
	
    /**
	*  就诊_体征数据更新
	*/
	public abstract EnVtDO[] update(EnVtDO[] aggdos) throws BizException;
	
	/**
	*  就诊_体征数据逻辑删除
	*/
	public abstract void logicDelete(EnVtDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EnVtDO[] enableWithoutFilter(EnVtDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EnVtDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EnVtDO[] disableVOWithoutFilter(EnVtDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EnVtDO[] aggdos) throws BizException ;
	
}
