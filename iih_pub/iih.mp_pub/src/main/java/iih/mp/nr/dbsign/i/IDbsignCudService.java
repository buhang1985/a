package iih.mp.nr.dbsign.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.dbsign.d.MpOrSignDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 执行双签数据维护服务
*/
public interface IDbsignCudService {
	/**
	*  执行双签数据真删除
	*/
    public abstract void delete(MpOrSignDO[] aggdos) throws BizException;
    
    /**
	*  执行双签数据插入保存
	*/
	public abstract MpOrSignDO[] insert(MpOrSignDO[] aggdos) throws BizException;
	
    /**
	*  执行双签数据保存
	*/
	public abstract MpOrSignDO[] save(MpOrSignDO[] aggdos) throws BizException;
	
    /**
	*  执行双签数据更新
	*/
	public abstract MpOrSignDO[] update(MpOrSignDO[] aggdos) throws BizException;
	
	/**
	*  执行双签数据逻辑删除
	*/
	public abstract void logicDelete(MpOrSignDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOrSignDO[] enableWithoutFilter(MpOrSignDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOrSignDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOrSignDO[] disableVOWithoutFilter(MpOrSignDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOrSignDO[] dos) throws BizException ;
}
