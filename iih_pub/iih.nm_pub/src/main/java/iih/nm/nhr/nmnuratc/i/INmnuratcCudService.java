package iih.nm.nhr.nmnuratc.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnuratc.d.NmNurAtcDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_人员论文专著数据维护服务
*/
public interface INmnuratcCudService {
	/**
	*  护理管理_人员论文专著数据真删除
	*/
    public abstract void delete(NmNurAtcDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_人员论文专著数据插入保存
	*/
	public abstract NmNurAtcDO[] insert(NmNurAtcDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员论文专著数据保存
	*/
	public abstract NmNurAtcDO[] save(NmNurAtcDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员论文专著数据更新
	*/
	public abstract NmNurAtcDO[] update(NmNurAtcDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_人员论文专著数据逻辑删除
	*/
	public abstract void logicDelete(NmNurAtcDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurAtcDO[] enableWithoutFilter(NmNurAtcDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurAtcDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurAtcDO[] disableVOWithoutFilter(NmNurAtcDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurAtcDO[] dos) throws BizException ;
}
