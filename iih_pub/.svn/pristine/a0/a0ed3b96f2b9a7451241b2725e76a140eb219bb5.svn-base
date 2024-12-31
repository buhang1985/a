package iih.mp.mpbd.mobileapp.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.mobileapp.d.MpMbhAppDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 移动医疗app数据维护服务
*/
public interface IMobileappCudService {
	/**
	*  移动医疗app数据真删除
	*/
    public abstract void delete(MpMbhAppDO[] aggdos) throws BizException;
    
    /**
	*  移动医疗app数据插入保存
	*/
	public abstract MpMbhAppDO[] insert(MpMbhAppDO[] aggdos) throws BizException;
	
    /**
	*  移动医疗app数据保存
	*/
	public abstract MpMbhAppDO[] save(MpMbhAppDO[] aggdos) throws BizException;
	
    /**
	*  移动医疗app数据更新
	*/
	public abstract MpMbhAppDO[] update(MpMbhAppDO[] aggdos) throws BizException;
	
	/**
	*  移动医疗app数据逻辑删除
	*/
	public abstract void logicDelete(MpMbhAppDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpMbhAppDO[] enableWithoutFilter(MpMbhAppDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpMbhAppDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpMbhAppDO[] disableVOWithoutFilter(MpMbhAppDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpMbhAppDO[] dos) throws BizException ;
}
