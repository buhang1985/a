package iih.pis.phk.phk.i;

import xap.mw.core.data.BizException;
import iih.pis.phk.phk.d.PisPhkDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者就诊_管家接待数据维护服务
*/
public interface IPisphkCudService {
	/**
	*  患者就诊_管家接待数据真删除
	*/
    public abstract void delete(PisPhkDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_管家接待数据插入保存
	*/
	public abstract PisPhkDO[] insert(PisPhkDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_管家接待数据保存
	*/
	public abstract PisPhkDO[] save(PisPhkDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_管家接待数据更新
	*/
	public abstract PisPhkDO[] update(PisPhkDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_管家接待数据逻辑删除
	*/
	public abstract void logicDelete(PisPhkDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PisPhkDO[] enableWithoutFilter(PisPhkDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PisPhkDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PisPhkDO[] disableVOWithoutFilter(PisPhkDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PisPhkDO[] dos) throws BizException ;
}
