package iih.ci.tsip.i;

import xap.mw.core.data.BizException;
import iih.ci.tsip.d.CiTsOrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 治疗方案医嘱数据维护服务
*/
public interface ICitsorderMDOCudService {
	/**
	*  治疗方案医嘱数据真删除
	*/
    public abstract void delete(CiTsOrDO[] aggdos) throws BizException;
    
    /**
	*  治疗方案医嘱数据插入保存
	*/
	public abstract CiTsOrDO[] insert(CiTsOrDO[] aggdos) throws BizException;
	
    /**
	*  治疗方案医嘱数据保存
	*/
	public abstract CiTsOrDO[] save(CiTsOrDO[] aggdos) throws BizException;
	
    /**
	*  治疗方案医嘱数据更新
	*/
	public abstract CiTsOrDO[] update(CiTsOrDO[] aggdos) throws BizException;
	
	/**
	*  治疗方案医嘱数据逻辑删除
	*/
	public abstract void logicDelete(CiTsOrDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiTsOrDO[] enableWithoutFilter(CiTsOrDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiTsOrDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiTsOrDO[] disableVOWithoutFilter(CiTsOrDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiTsOrDO[] aggdos) throws BizException ;
	
}
