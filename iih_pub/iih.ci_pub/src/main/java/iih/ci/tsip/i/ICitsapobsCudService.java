package iih.ci.tsip.i;

import xap.mw.core.data.BizException;
import iih.ci.tsip.d.CiTsApObsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 治疗方案检查申请数据维护服务
*/
public interface ICitsapobsCudService {
	/**
	*  治疗方案检查申请数据真删除
	*/
    public abstract void delete(CiTsApObsDO[] aggdos) throws BizException;
    
    /**
	*  治疗方案检查申请数据插入保存
	*/
	public abstract CiTsApObsDO[] insert(CiTsApObsDO[] aggdos) throws BizException;
	
    /**
	*  治疗方案检查申请数据保存
	*/
	public abstract CiTsApObsDO[] save(CiTsApObsDO[] aggdos) throws BizException;
	
    /**
	*  治疗方案检查申请数据更新
	*/
	public abstract CiTsApObsDO[] update(CiTsApObsDO[] aggdos) throws BizException;
	
	/**
	*  治疗方案检查申请数据逻辑删除
	*/
	public abstract void logicDelete(CiTsApObsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public CiTsApObsDO[] enableWithoutFilter(CiTsApObsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(CiTsApObsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public CiTsApObsDO[] disableVOWithoutFilter(CiTsApObsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(CiTsApObsDO[] dos) throws BizException ;
}
