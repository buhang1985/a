package iih.sfda.aer.sfdaaerevpart.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevpart.d.SfdaAerEvPartDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 当事人资料数据维护服务
*/
public interface ISfdaaerevpartCudService {
	/**
	*  当事人资料数据真删除
	*/
    public abstract void delete(SfdaAerEvPartDO[] aggdos) throws BizException;
    
    /**
	*  当事人资料数据插入保存
	*/
	public abstract SfdaAerEvPartDO[] insert(SfdaAerEvPartDO[] aggdos) throws BizException;
	
    /**
	*  当事人资料数据保存
	*/
	public abstract SfdaAerEvPartDO[] save(SfdaAerEvPartDO[] aggdos) throws BizException;
	
    /**
	*  当事人资料数据更新
	*/
	public abstract SfdaAerEvPartDO[] update(SfdaAerEvPartDO[] aggdos) throws BizException;
	
	/**
	*  当事人资料数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvPartDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvPartDO[] enableWithoutFilter(SfdaAerEvPartDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvPartDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvPartDO[] disableVOWithoutFilter(SfdaAerEvPartDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvPartDO[] dos) throws BizException ;
}
