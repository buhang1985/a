package iih.sfda.aer.sfdaaerevmmedicoth.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmmedicoth.d.SfdaAerEvMmedicothDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗其他事件数据维护服务
*/
public interface ISfdaaerevmmedicothCudService {
	/**
	*  医疗其他事件数据真删除
	*/
    public abstract void delete(SfdaAerEvMmedicothDO[] aggdos) throws BizException;
    
    /**
	*  医疗其他事件数据插入保存
	*/
	public abstract SfdaAerEvMmedicothDO[] insert(SfdaAerEvMmedicothDO[] aggdos) throws BizException;
	
    /**
	*  医疗其他事件数据保存
	*/
	public abstract SfdaAerEvMmedicothDO[] save(SfdaAerEvMmedicothDO[] aggdos) throws BizException;
	
    /**
	*  医疗其他事件数据更新
	*/
	public abstract SfdaAerEvMmedicothDO[] update(SfdaAerEvMmedicothDO[] aggdos) throws BizException;
	
	/**
	*  医疗其他事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMmedicothDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMmedicothDO[] enableWithoutFilter(SfdaAerEvMmedicothDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMmedicothDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMmedicothDO[] disableVOWithoutFilter(SfdaAerEvMmedicothDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMmedicothDO[] dos) throws BizException ;
}
