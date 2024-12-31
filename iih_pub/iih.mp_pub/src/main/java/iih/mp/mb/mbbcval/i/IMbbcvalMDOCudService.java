package iih.mp.mb.mbbcval.i;

import xap.mw.core.data.BizException;
import iih.mp.mb.mbbcval.d.MbBcValDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 条码对照查询数据维护服务
*/
public interface IMbbcvalMDOCudService {
	/**
	*  条码对照查询数据真删除
	*/
    public abstract void delete(MbBcValDO[] aggdos) throws BizException;
    
    /**
	*  条码对照查询数据插入保存
	*/
	public abstract MbBcValDO[] insert(MbBcValDO[] aggdos) throws BizException;
	
    /**
	*  条码对照查询数据保存
	*/
	public abstract MbBcValDO[] save(MbBcValDO[] aggdos) throws BizException;
	
    /**
	*  条码对照查询数据更新
	*/
	public abstract MbBcValDO[] update(MbBcValDO[] aggdos) throws BizException;
	
	/**
	*  条码对照查询数据逻辑删除
	*/
	public abstract void logicDelete(MbBcValDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MbBcValDO[] enableWithoutFilter(MbBcValDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MbBcValDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MbBcValDO[] disableVOWithoutFilter(MbBcValDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MbBcValDO[] aggdos) throws BizException ;
	
}
