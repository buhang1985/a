package iih.sfda.aer.sfdaaerevmnoexphosp.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmnoexphosp.d.SfdaAerEvMNoexphospDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 非预期再住院事件数据维护服务
*/
public interface ISfdaaerevmnoexphospCudService {
	/**
	*  非预期再住院事件数据真删除
	*/
    public abstract void delete(SfdaAerEvMNoexphospDO[] aggdos) throws BizException;
    
    /**
	*  非预期再住院事件数据插入保存
	*/
	public abstract SfdaAerEvMNoexphospDO[] insert(SfdaAerEvMNoexphospDO[] aggdos) throws BizException;
	
    /**
	*  非预期再住院事件数据保存
	*/
	public abstract SfdaAerEvMNoexphospDO[] save(SfdaAerEvMNoexphospDO[] aggdos) throws BizException;
	
    /**
	*  非预期再住院事件数据更新
	*/
	public abstract SfdaAerEvMNoexphospDO[] update(SfdaAerEvMNoexphospDO[] aggdos) throws BizException;
	
	/**
	*  非预期再住院事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMNoexphospDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMNoexphospDO[] enableWithoutFilter(SfdaAerEvMNoexphospDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMNoexphospDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMNoexphospDO[] disableVOWithoutFilter(SfdaAerEvMNoexphospDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMNoexphospDO[] dos) throws BizException ;
}
