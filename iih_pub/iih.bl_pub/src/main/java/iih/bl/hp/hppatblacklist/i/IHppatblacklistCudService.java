package iih.bl.hp.hppatblacklist.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hppatblacklist.d.HpPatBlackListDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保患者黑名单数据维护服务
*/
public interface IHppatblacklistCudService {
	/**
	*  医保患者黑名单数据真删除
	*/
    public abstract void delete(HpPatBlackListDO[] aggdos) throws BizException;
    
    /**
	*  医保患者黑名单数据插入保存
	*/
	public abstract HpPatBlackListDO[] insert(HpPatBlackListDO[] aggdos) throws BizException;
	
    /**
	*  医保患者黑名单数据保存
	*/
	public abstract HpPatBlackListDO[] save(HpPatBlackListDO[] aggdos) throws BizException;
	
    /**
	*  医保患者黑名单数据更新
	*/
	public abstract HpPatBlackListDO[] update(HpPatBlackListDO[] aggdos) throws BizException;
	
	/**
	*  医保患者黑名单数据逻辑删除
	*/
	public abstract void logicDelete(HpPatBlackListDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpPatBlackListDO[] enableWithoutFilter(HpPatBlackListDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpPatBlackListDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpPatBlackListDO[] disableVOWithoutFilter(HpPatBlackListDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpPatBlackListDO[] dos) throws BizException ;
}
