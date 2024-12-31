package iih.mp.nr.nur.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.nur.d.MpOrNurDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱执行护士数据维护服务
*/
public interface INurCudService {
	/**
	*  医嘱执行护士数据真删除
	*/
    public abstract void delete(MpOrNurDO[] aggdos) throws BizException;
    
    /**
	*  医嘱执行护士数据插入保存
	*/
	public abstract MpOrNurDO[] insert(MpOrNurDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行护士数据保存
	*/
	public abstract MpOrNurDO[] save(MpOrNurDO[] aggdos) throws BizException;
	
    /**
	*  医嘱执行护士数据更新
	*/
	public abstract MpOrNurDO[] update(MpOrNurDO[] aggdos) throws BizException;
	
	/**
	*  医嘱执行护士数据逻辑删除
	*/
	public abstract void logicDelete(MpOrNurDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOrNurDO[] enableWithoutFilter(MpOrNurDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOrNurDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOrNurDO[] disableVOWithoutFilter(MpOrNurDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOrNurDO[] dos) throws BizException ;
}
