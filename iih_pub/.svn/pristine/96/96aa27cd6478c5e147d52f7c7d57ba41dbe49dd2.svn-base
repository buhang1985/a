package iih.bd.mhi.hpsex.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpsex.d.HpSexDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划性别数据维护服务
*/
public interface IHpsexCudService {
	/**
	*  医保计划性别数据真删除
	*/
    public abstract void delete(HpSexDO[] aggdos) throws BizException;
    
    /**
	*  医保计划性别数据插入保存
	*/
	public abstract HpSexDO[] insert(HpSexDO[] aggdos) throws BizException;
	
    /**
	*  医保计划性别数据保存
	*/
	public abstract HpSexDO[] save(HpSexDO[] aggdos) throws BizException;
	
    /**
	*  医保计划性别数据更新
	*/
	public abstract HpSexDO[] update(HpSexDO[] aggdos) throws BizException;
	
	/**
	*  医保计划性别数据逻辑删除
	*/
	public abstract void logicDelete(HpSexDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpSexDO[] enableWithoutFilter(HpSexDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpSexDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpSexDO[] disableVOWithoutFilter(HpSexDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpSexDO[] dos) throws BizException ;
}
