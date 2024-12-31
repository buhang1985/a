package iih.mp.mb.mbbcval.i;

import xap.mw.core.data.BizException;
import iih.mp.mb.mbbcval.d.MbBcValParamDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 条码对照查询数据维护服务
*/
public interface IMbBcValParamDOCudService {
	/**
	*  条码对照查询数据真删除
	*/
    public abstract void delete(MbBcValParamDO[] aggdos) throws BizException;
    
    /**
	*  条码对照查询数据插入保存
	*/
	public abstract MbBcValParamDO[] insert(MbBcValParamDO[] aggdos) throws BizException;
	
    /**
	*  条码对照查询数据保存
	*/
	public abstract MbBcValParamDO[] save(MbBcValParamDO[] aggdos) throws BizException;
	
    /**
	*  条码对照查询数据更新
	*/
	public abstract MbBcValParamDO[] update(MbBcValParamDO[] aggdos) throws BizException;
	
	/**
	*  条码对照查询数据逻辑删除
	*/
	public abstract void logicDelete(MbBcValParamDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MbBcValParamDO[] enableWithoutFilter(MbBcValParamDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MbBcValParamDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MbBcValParamDO[] disableVOWithoutFilter(MbBcValParamDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MbBcValParamDO[] aggdos) throws BizException ;
	
}
