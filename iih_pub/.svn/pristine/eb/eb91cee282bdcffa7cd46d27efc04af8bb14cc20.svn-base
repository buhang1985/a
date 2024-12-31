package iih.bl.hp.hpzeroreg.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hpzeroreg.d.HpZeroRegDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保零挂DO数据维护服务
*/
public interface IHpzeroregCudService {
	/**
	*  医保零挂DO数据真删除
	*/
    public abstract void delete(HpZeroRegDO[] aggdos) throws BizException;
    
    /**
	*  医保零挂DO数据插入保存
	*/
	public abstract HpZeroRegDO[] insert(HpZeroRegDO[] aggdos) throws BizException;
	
    /**
	*  医保零挂DO数据保存
	*/
	public abstract HpZeroRegDO[] save(HpZeroRegDO[] aggdos) throws BizException;
	
    /**
	*  医保零挂DO数据更新
	*/
	public abstract HpZeroRegDO[] update(HpZeroRegDO[] aggdos) throws BizException;
	
	/**
	*  医保零挂DO数据逻辑删除
	*/
	public abstract void logicDelete(HpZeroRegDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpZeroRegDO[] enableWithoutFilter(HpZeroRegDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpZeroRegDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpZeroRegDO[] disableVOWithoutFilter(HpZeroRegDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpZeroRegDO[] dos) throws BizException ;
}
