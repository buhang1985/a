package iih.ci.mr.mrsign.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.mrsign.d.CiMrSignCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 临床医疗记录签名数据维护服务
*/
public interface ICiMrSignCaDOCudService {
	/**
	*  临床医疗记录签名数据真删除
	*/
    public abstract void delete(CiMrSignCaDO[] aggdos) throws BizException;
    
    /**
	*  临床医疗记录签名数据插入保存
	*/
	public abstract CiMrSignCaDO[] insert(CiMrSignCaDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录签名数据保存
	*/
	public abstract CiMrSignCaDO[] save(CiMrSignCaDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录签名数据更新
	*/
	public abstract CiMrSignCaDO[] update(CiMrSignCaDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录签名数据逻辑删除
	*/
	public abstract void logicDelete(CiMrSignCaDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiMrSignCaDO[] enableWithoutFilter(CiMrSignCaDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiMrSignCaDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiMrSignCaDO[] disableVOWithoutFilter(CiMrSignCaDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiMrSignCaDO[] aggdos) throws BizException ;
	
}
