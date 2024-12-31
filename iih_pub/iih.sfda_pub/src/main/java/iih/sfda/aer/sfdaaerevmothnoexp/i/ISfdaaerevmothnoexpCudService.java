package iih.sfda.aer.sfdaaerevmothnoexp.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmothnoexp.d.SfdaAerEvMOthnoexpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 其他非预期事件数据维护服务
*/
public interface ISfdaaerevmothnoexpCudService {
	/**
	*  其他非预期事件数据真删除
	*/
    public abstract void delete(SfdaAerEvMOthnoexpDO[] aggdos) throws BizException;
    
    /**
	*  其他非预期事件数据插入保存
	*/
	public abstract SfdaAerEvMOthnoexpDO[] insert(SfdaAerEvMOthnoexpDO[] aggdos) throws BizException;
	
    /**
	*  其他非预期事件数据保存
	*/
	public abstract SfdaAerEvMOthnoexpDO[] save(SfdaAerEvMOthnoexpDO[] aggdos) throws BizException;
	
    /**
	*  其他非预期事件数据更新
	*/
	public abstract SfdaAerEvMOthnoexpDO[] update(SfdaAerEvMOthnoexpDO[] aggdos) throws BizException;
	
	/**
	*  其他非预期事件数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMOthnoexpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMOthnoexpDO[] enableWithoutFilter(SfdaAerEvMOthnoexpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMOthnoexpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMOthnoexpDO[] disableVOWithoutFilter(SfdaAerEvMOthnoexpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMOthnoexpDO[] dos) throws BizException ;
}
