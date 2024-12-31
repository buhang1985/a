package iih.sfda.aer.sfdaaerevmnoexpihosptm.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevmnoexpihosptm.d.SfdaAerEvMNoexpIhospTmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 非预期延长住院时间数据维护服务
*/
public interface ISfdaaerevmnoexpihosptmCudService {
	/**
	*  非预期延长住院时间数据真删除
	*/
    public abstract void delete(SfdaAerEvMNoexpIhospTmDO[] aggdos) throws BizException;
    
    /**
	*  非预期延长住院时间数据插入保存
	*/
	public abstract SfdaAerEvMNoexpIhospTmDO[] insert(SfdaAerEvMNoexpIhospTmDO[] aggdos) throws BizException;
	
    /**
	*  非预期延长住院时间数据保存
	*/
	public abstract SfdaAerEvMNoexpIhospTmDO[] save(SfdaAerEvMNoexpIhospTmDO[] aggdos) throws BizException;
	
    /**
	*  非预期延长住院时间数据更新
	*/
	public abstract SfdaAerEvMNoexpIhospTmDO[] update(SfdaAerEvMNoexpIhospTmDO[] aggdos) throws BizException;
	
	/**
	*  非预期延长住院时间数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvMNoexpIhospTmDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvMNoexpIhospTmDO[] enableWithoutFilter(SfdaAerEvMNoexpIhospTmDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvMNoexpIhospTmDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvMNoexpIhospTmDO[] disableVOWithoutFilter(SfdaAerEvMNoexpIhospTmDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvMNoexpIhospTmDO[] dos) throws BizException ;
}
