package iih.sfda.aer.sfdaaerevfdb.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevfdb.d.SfdaAerEvFdbDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 跌倒/坠床数据维护服务
*/
public interface ISfdaaerevfdbCudService {
	/**
	*  跌倒/坠床数据真删除
	*/
    public abstract void delete(SfdaAerEvFdbDO[] aggdos) throws BizException;
    
    /**
	*  跌倒/坠床数据插入保存
	*/
	public abstract SfdaAerEvFdbDO[] insert(SfdaAerEvFdbDO[] aggdos) throws BizException;
	
    /**
	*  跌倒/坠床数据保存
	*/
	public abstract SfdaAerEvFdbDO[] save(SfdaAerEvFdbDO[] aggdos) throws BizException;
	
    /**
	*  跌倒/坠床数据更新
	*/
	public abstract SfdaAerEvFdbDO[] update(SfdaAerEvFdbDO[] aggdos) throws BizException;
	
	/**
	*  跌倒/坠床数据逻辑删除
	*/
	public abstract void logicDelete(SfdaAerEvFdbDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SfdaAerEvFdbDO[] enableWithoutFilter(SfdaAerEvFdbDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SfdaAerEvFdbDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SfdaAerEvFdbDO[] disableVOWithoutFilter(SfdaAerEvFdbDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SfdaAerEvFdbDO[] dos) throws BizException ;
}
