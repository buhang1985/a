package iih.en.pv.enfee.i;

import xap.mw.core.data.BizException;
import iih.en.pv.enfee.d.EntAccActDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 患者就诊_就诊账户数据维护服务
*/
public interface IEntAccActDOCudService {
	/**
	*  患者就诊_就诊账户数据真删除
	*/
    public abstract void delete(EntAccActDO[] aggdos) throws BizException;
    
    /**
	*  患者就诊_就诊账户数据插入保存
	*/
	public abstract EntAccActDO[] insert(EntAccActDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_就诊账户数据保存
	*/
	public abstract EntAccActDO[] save(EntAccActDO[] aggdos) throws BizException;
	
    /**
	*  患者就诊_就诊账户数据更新
	*/
	public abstract EntAccActDO[] update(EntAccActDO[] aggdos) throws BizException;
	
	/**
	*  患者就诊_就诊账户数据逻辑删除
	*/
	public abstract void logicDelete(EntAccActDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EntAccActDO[] enableWithoutFilter(EntAccActDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EntAccActDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EntAccActDO[] disableVOWithoutFilter(EntAccActDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EntAccActDO[] aggdos) throws BizException ;
	
}
