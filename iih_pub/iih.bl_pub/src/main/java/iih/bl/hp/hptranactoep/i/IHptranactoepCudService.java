package iih.bl.hp.hptranactoep.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 交易记录表数据维护服务
*/
public interface IHptranactoepCudService {
	/**
	*  交易记录表数据真删除
	*/
    public abstract void delete(HpTransactOepDO[] aggdos) throws BizException;
    
    /**
	*  交易记录表数据插入保存
	*/
	public abstract HpTransactOepDO[] insert(HpTransactOepDO[] aggdos) throws BizException;
	
    /**
	*  交易记录表数据保存
	*/
	public abstract HpTransactOepDO[] save(HpTransactOepDO[] aggdos) throws BizException;
	
    /**
	*  交易记录表数据更新
	*/
	public abstract HpTransactOepDO[] update(HpTransactOepDO[] aggdos) throws BizException;
	
	/**
	*  交易记录表数据逻辑删除
	*/
	public abstract void logicDelete(HpTransactOepDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpTransactOepDO[] enableWithoutFilter(HpTransactOepDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpTransactOepDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpTransactOepDO[] disableVOWithoutFilter(HpTransactOepDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpTransactOepDO[] dos) throws BizException ;
}
