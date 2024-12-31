package iih.nm.nhr.nmnursra.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nmnursra.d.NmNurSraDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理管理_人员科研成果数据维护服务
*/
public interface INmnursraCudService {
	/**
	*  护理管理_人员科研成果数据真删除
	*/
    public abstract void delete(NmNurSraDO[] aggdos) throws BizException;
    
    /**
	*  护理管理_人员科研成果数据插入保存
	*/
	public abstract NmNurSraDO[] insert(NmNurSraDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员科研成果数据保存
	*/
	public abstract NmNurSraDO[] save(NmNurSraDO[] aggdos) throws BizException;
	
    /**
	*  护理管理_人员科研成果数据更新
	*/
	public abstract NmNurSraDO[] update(NmNurSraDO[] aggdos) throws BizException;
	
	/**
	*  护理管理_人员科研成果数据逻辑删除
	*/
	public abstract void logicDelete(NmNurSraDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NmNurSraDO[] enableWithoutFilter(NmNurSraDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NmNurSraDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NmNurSraDO[] disableVOWithoutFilter(NmNurSraDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NmNurSraDO[] dos) throws BizException ;
}
