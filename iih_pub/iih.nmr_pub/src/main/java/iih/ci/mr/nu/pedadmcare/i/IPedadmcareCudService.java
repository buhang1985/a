package iih.ci.mr.nu.pedadmcare.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.pedadmcare.d.PedadmcareDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 儿科入院护理评估记录单数据维护服务
*/
public interface IPedadmcareCudService {
	/**
	*  儿科入院护理评估记录单数据真删除
	*/
    public abstract void delete(PedadmcareDO[] aggdos) throws BizException;
    
    /**
	*  儿科入院护理评估记录单数据插入保存
	*/
	public abstract PedadmcareDO[] insert(PedadmcareDO[] aggdos) throws BizException;
	
    /**
	*  儿科入院护理评估记录单数据保存
	*/
	public abstract PedadmcareDO[] save(PedadmcareDO[] aggdos) throws BizException;
	
    /**
	*  儿科入院护理评估记录单数据更新
	*/
	public abstract PedadmcareDO[] update(PedadmcareDO[] aggdos) throws BizException;
	
	/**
	*  儿科入院护理评估记录单数据逻辑删除
	*/
	public abstract void logicDelete(PedadmcareDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PedadmcareDO[] enableWithoutFilter(PedadmcareDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PedadmcareDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PedadmcareDO[] disableVOWithoutFilter(PedadmcareDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PedadmcareDO[] dos) throws BizException ;
}
