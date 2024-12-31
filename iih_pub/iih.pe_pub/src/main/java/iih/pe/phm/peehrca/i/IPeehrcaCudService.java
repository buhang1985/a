package iih.pe.phm.peehrca.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.peehrca.d.PeEHRcaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检电子健康档案目录数据维护服务
*/
public interface IPeehrcaCudService {
	/**
	*  体检电子健康档案目录数据真删除
	*/
    public abstract void delete(PeEHRcaDO[] aggdos) throws BizException;
    
    /**
	*  体检电子健康档案目录数据插入保存
	*/
	public abstract PeEHRcaDO[] insert(PeEHRcaDO[] aggdos) throws BizException;
	
    /**
	*  体检电子健康档案目录数据保存
	*/
	public abstract PeEHRcaDO[] save(PeEHRcaDO[] aggdos) throws BizException;
	
    /**
	*  体检电子健康档案目录数据更新
	*/
	public abstract PeEHRcaDO[] update(PeEHRcaDO[] aggdos) throws BizException;
	
	/**
	*  体检电子健康档案目录数据逻辑删除
	*/
	public abstract void logicDelete(PeEHRcaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeEHRcaDO[] enableWithoutFilter(PeEHRcaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeEHRcaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeEHRcaDO[] disableVOWithoutFilter(PeEHRcaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeEHRcaDO[] dos) throws BizException ;
}
