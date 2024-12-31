package iih.sc.scp.scploptsrv.i;

import xap.mw.core.data.BizException;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 排班计划候选服务数据维护服务
*/
public interface IScploptsrvCudService {
	/**
	*  排班计划候选服务数据真删除
	*/
    public abstract void delete(ScPlOptSrvDO[] aggdos) throws BizException;
    
    /**
	*  排班计划候选服务数据插入保存
	*/
	public abstract ScPlOptSrvDO[] insert(ScPlOptSrvDO[] aggdos) throws BizException;
	
    /**
	*  排班计划候选服务数据保存
	*/
	public abstract ScPlOptSrvDO[] save(ScPlOptSrvDO[] aggdos) throws BizException;
	
    /**
	*  排班计划候选服务数据更新
	*/
	public abstract ScPlOptSrvDO[] update(ScPlOptSrvDO[] aggdos) throws BizException;
	
	/**
	*  排班计划候选服务数据逻辑删除
	*/
	public abstract void logicDelete(ScPlOptSrvDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ScPlOptSrvDO[] enableWithoutFilter(ScPlOptSrvDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ScPlOptSrvDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ScPlOptSrvDO[] disableVOWithoutFilter(ScPlOptSrvDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ScPlOptSrvDO[] dos) throws BizException ;
}
