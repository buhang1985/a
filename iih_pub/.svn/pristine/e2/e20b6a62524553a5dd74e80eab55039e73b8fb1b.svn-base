package iih.nm.nhr.nmnurtitled.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnurtitled.d.NmNurTitleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_人员职称数据维护服务
*/
public interface INmnurtitledCudService {
	/**
	*  护理管理_人员职称数据真删除
	*/
    public abstract void delete(NmNurTitleDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_人员职称数据插入保存
	*/
	public abstract NmNurTitleDO[] insert(NmNurTitleDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员职称数据保存
	*/
	public abstract NmNurTitleDO[] save(NmNurTitleDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员职称数据更新
	*/
	public abstract NmNurTitleDO[] update(NmNurTitleDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_人员职称数据逻辑删除
	*/
	public abstract void logicDelete(NmNurTitleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurTitleDO[] enableWithoutFilter(NmNurTitleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurTitleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurTitleDO[] disableVOWithoutFilter(NmNurTitleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurTitleDO[] dos) throws BizException ;
}
