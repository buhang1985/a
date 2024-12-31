package iih.mp.nr.mpnuhandoverrpt.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.mpnuhandoverrpt.d.MpNuHsPatDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护理交接班数据维护服务
*/
public interface IMpNuHsPatDOCudService {
	/**
	*  护理交接班数据删除
	*/
    public abstract void logicDelete(MpNuHsPatDO[] aggdos) throws BizException;
    
    /**
	*  护理交接班数据插入保存
	*/
	public abstract MpNuHsPatDO[] insert(MpNuHsPatDO[] aggdos) throws BizException;
	
    /**
	*  护理交接班数据保存
	*/
	public abstract MpNuHsPatDO[] save(MpNuHsPatDO[] aggdos) throws BizException;
	
    /**
	*  护理交接班数据更新
	*/
	public abstract MpNuHsPatDO[] update(MpNuHsPatDO[] aggdos) throws BizException;
	
	/**
	*  护理交接班数据真删
	*/
	public abstract void delete(MpNuHsPatDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpNuHsPatDO[] enableWithoutFilter(MpNuHsPatDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpNuHsPatDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpNuHsPatDO[] disableVOWithoutFilter(MpNuHsPatDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpNuHsPatDO[] aggdos) throws BizException ;
	
}
