package iih.sfda.aer.sfdaaerevmnoexpret.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmnoexpret.d.SfdaAerEvMnoexpretDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 非预期重返ICU数据维护服务
*/
public interface ISfdaaerevmnoexpretCudService {
	/**
	*  非预期重返ICU数据真删除
	*/
    public abstract void delete(SfdaAerEvMnoexpretDO[] aggdos) throws BizException;
    
    /**
	*  非预期重返ICU数据插入保存
	*/
	public abstract SfdaAerEvMnoexpretDO[] insert(SfdaAerEvMnoexpretDO[] aggdos) throws BizException;
	
    /**
	*  非预期重返ICU数据保存
	*/
	public abstract SfdaAerEvMnoexpretDO[] save(SfdaAerEvMnoexpretDO[] aggdos) throws BizException;
	
    /**
	*  非预期重返ICU数据更新
	*/
	public abstract SfdaAerEvMnoexpretDO[] update(SfdaAerEvMnoexpretDO[] aggdos) throws BizException;
	
	/**
	*  非预期重返ICU数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMnoexpretDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMnoexpretDO[] enableWithoutFilter(SfdaAerEvMnoexpretDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMnoexpretDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMnoexpretDO[] disableVOWithoutFilter(SfdaAerEvMnoexpretDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMnoexpretDO[] dos) throws BizException ;
}
