package iih.bd.pp.bdhpsrvctrdef.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.bdhpsrvctrdef.d.BdHpSrvCtrDsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保目录对照病种限制数据维护服务
*/
public interface IBdhpsrvctrdsdefCudService {
	/**
	*  医保目录对照病种限制数据真删除
	*/
    public abstract void delete(BdHpSrvCtrDsDO[] aggdos) throws BizException;
    
    /**
	*  医保目录对照病种限制数据插入保存
	*/
	public abstract BdHpSrvCtrDsDO[] insert(BdHpSrvCtrDsDO[] aggdos) throws BizException;
	
    /**
	*  医保目录对照病种限制数据保存
	*/
	public abstract BdHpSrvCtrDsDO[] save(BdHpSrvCtrDsDO[] aggdos) throws BizException;
	
    /**
	*  医保目录对照病种限制数据更新
	*/
	public abstract BdHpSrvCtrDsDO[] update(BdHpSrvCtrDsDO[] aggdos) throws BizException;
	
	/**
	*  医保目录对照病种限制数据逻辑删除
	*/
	public abstract void logicDelete(BdHpSrvCtrDsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BdHpSrvCtrDsDO[] enableWithoutFilter(BdHpSrvCtrDsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BdHpSrvCtrDsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BdHpSrvCtrDsDO[] disableVOWithoutFilter(BdHpSrvCtrDsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BdHpSrvCtrDsDO[] dos) throws BizException ;
}
