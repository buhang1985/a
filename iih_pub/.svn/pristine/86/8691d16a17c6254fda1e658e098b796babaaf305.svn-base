package iih.sfda.aer.sfdaaerevmedlkg.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmedlkg.d.SfdaAerEvMedlkgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 护理安全_输液药物渗漏事件数据维护服务
*/
public interface ISfdaaerevmedlkgCudService {
	/**
	*  护理安全_输液药物渗漏事件数据真删除
	*/
    public abstract void delete(SfdaAerEvMedlkgDO[] aggdos) throws BizException;
    
    /**
	*  护理安全_输液药物渗漏事件数据插入保存
	*/
	public abstract SfdaAerEvMedlkgDO[] insert(SfdaAerEvMedlkgDO[] aggdos) throws BizException;
	
    /**
	*  护理安全_输液药物渗漏事件数据保存
	*/
	public abstract SfdaAerEvMedlkgDO[] save(SfdaAerEvMedlkgDO[] aggdos) throws BizException;
	
    /**
	*  护理安全_输液药物渗漏事件数据更新
	*/
	public abstract SfdaAerEvMedlkgDO[] update(SfdaAerEvMedlkgDO[] aggdos) throws BizException;
	
	/**
	*  护理安全_输液药物渗漏事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMedlkgDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMedlkgDO[] enableWithoutFilter(SfdaAerEvMedlkgDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMedlkgDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMedlkgDO[] disableVOWithoutFilter(SfdaAerEvMedlkgDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMedlkgDO[] dos) throws BizException ;
}
