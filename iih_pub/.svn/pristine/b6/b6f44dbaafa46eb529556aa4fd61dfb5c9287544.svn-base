package iih.nm.net.nmnetmeet.i;

import xap.mw.core.data.BizException;
import iih.nm.net.nmnetmeet.d.NmNetMeetDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 培训考核计划场次数据维护服务
*/
public interface INmnetmeetCudService {
	/**
	*  培训考核计划场次数据真删除
	*/
    public abstract void delete(NmNetMeetDO[] aggdos) throws BizException;
    
    /**
	*  培训考核计划场次数据插入保存
	*/
	public abstract NmNetMeetDO[] insert(NmNetMeetDO[] aggdos) throws BizException;
	
    /**
	*  培训考核计划场次数据保存
	*/
	public abstract NmNetMeetDO[] save(NmNetMeetDO[] aggdos) throws BizException;
	
    /**
	*  培训考核计划场次数据更新
	*/
	public abstract NmNetMeetDO[] update(NmNetMeetDO[] aggdos) throws BizException;
	
	/**
	*  培训考核计划场次数据逻辑删除
	*/
	public abstract void logicDelete(NmNetMeetDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNetMeetDO[] enableWithoutFilter(NmNetMeetDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNetMeetDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNetMeetDO[] disableVOWithoutFilter(NmNetMeetDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNetMeetDO[] dos) throws BizException ;
}
