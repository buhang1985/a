package iih.mp.ot.deptmp.i;

import xap.mw.core.data.BizException;
import iih.mp.ot.deptmp.d.MpOrPrTmpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 通用医技科室模板数据维护服务
*/
public interface IDeptmpMDOCudService {
	/**
	*  通用医技科室模板数据真删除
	*/
    public abstract void delete(MpOrPrTmpDO[] aggdos) throws BizException;
    
    /**
	*  通用医技科室模板数据插入保存
	*/
	public abstract MpOrPrTmpDO[] insert(MpOrPrTmpDO[] aggdos) throws BizException;
	
    /**
	*  通用医技科室模板数据保存
	*/
	public abstract MpOrPrTmpDO[] save(MpOrPrTmpDO[] aggdos) throws BizException;
	
    /**
	*  通用医技科室模板数据更新
	*/
	public abstract MpOrPrTmpDO[] update(MpOrPrTmpDO[] aggdos) throws BizException;
	
	/**
	*  通用医技科室模板数据逻辑删除
	*/
	public abstract void logicDelete(MpOrPrTmpDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpOrPrTmpDO[] enableWithoutFilter(MpOrPrTmpDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpOrPrTmpDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpOrPrTmpDO[] disableVOWithoutFilter(MpOrPrTmpDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpOrPrTmpDO[] aggdos) throws BizException ;
	
}
