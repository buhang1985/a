package iih.sfda.aer.sfdaaerevdadvice.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevdadvice.d.SfdaAerEvDadviceDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 药物医嘱开立错误(医生)数据维护服务
*/
public interface ISfdaaerevdadviceCudService {
	/**
	*  药物医嘱开立错误(医生)数据真删除
	*/
    public abstract void delete(SfdaAerEvDadviceDO[] aggdos) throws BizException;
    
    /**
	*  药物医嘱开立错误(医生)数据插入保存
	*/
	public abstract SfdaAerEvDadviceDO[] insert(SfdaAerEvDadviceDO[] aggdos) throws BizException;
	
    /**
	*  药物医嘱开立错误(医生)数据保存
	*/
	public abstract SfdaAerEvDadviceDO[] save(SfdaAerEvDadviceDO[] aggdos) throws BizException;
	
    /**
	*  药物医嘱开立错误(医生)数据更新
	*/
	public abstract SfdaAerEvDadviceDO[] update(SfdaAerEvDadviceDO[] aggdos) throws BizException;
	
	/**
	*  药物医嘱开立错误(医生)数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvDadviceDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvDadviceDO[] enableWithoutFilter(SfdaAerEvDadviceDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvDadviceDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvDadviceDO[] disableVOWithoutFilter(SfdaAerEvDadviceDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvDadviceDO[] dos) throws BizException ;
}
