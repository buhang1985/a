package iih.nm.nhr.nmnhrnurlvhr.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnhrnurlvhr.d.NmNhrNurLvHrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_请假工时明细表数据维护服务
*/
public interface INmnhrnurlvhrCudService {
	/**
	*  护理管理_请假工时明细表数据真删除
	*/
    public abstract void delete(NmNhrNurLvHrDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_请假工时明细表数据插入保存
	*/
	public abstract NmNhrNurLvHrDO[] insert(NmNhrNurLvHrDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_请假工时明细表数据保存
	*/
	public abstract NmNhrNurLvHrDO[] save(NmNhrNurLvHrDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_请假工时明细表数据更新
	*/
	public abstract NmNhrNurLvHrDO[] update(NmNhrNurLvHrDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_请假工时明细表数据逻辑删除
	*/
	public abstract void logicDelete(NmNhrNurLvHrDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNhrNurLvHrDO[] enableWithoutFilter(NmNhrNurLvHrDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNhrNurLvHrDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNhrNurLvHrDO[] disableVOWithoutFilter(NmNhrNurLvHrDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNhrNurLvHrDO[] dos) throws BizException ;
}
