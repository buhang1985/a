package iih.mp.ne.mptb.i;

import xap.mw.core.data.BizException;
import iih.mp.ne.mptb.d.MpTbDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 取血单打印数据维护服务
*/
public interface IMptbCudService {
	/**
	*  取血单打印数据真删除
	*/
    public abstract void delete(MpTbDO[] aggdos) throws BizException;
    
    /**
	*  取血单打印数据插入保存
	*/
	public abstract MpTbDO[] insert(MpTbDO[] aggdos) throws BizException;
	
    /**
	*  取血单打印数据保存
	*/
	public abstract MpTbDO[] save(MpTbDO[] aggdos) throws BizException;
	
    /**
	*  取血单打印数据更新
	*/
	public abstract MpTbDO[] update(MpTbDO[] aggdos) throws BizException;
	
	/**
	*  取血单打印数据逻辑删除
	*/
	public abstract void logicDelete(MpTbDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpTbDO[] enableWithoutFilter(MpTbDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpTbDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpTbDO[] disableVOWithoutFilter(MpTbDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpTbDO[] dos) throws BizException ;
}
