package iih.bl.hp.hptransactah.i;

import xap.mw.core.data.BizException;
import iih.bl.hp.hptransactah.d.HpTransActAhDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 安徽医保交易记录数据维护服务
*/
public interface IHptransactahMDOCudService {
	/**
	*  安徽医保交易记录数据真删除
	*/
    public abstract void delete(HpTransActAhDO[] aggdos) throws BizException;
    
    /**
	*  安徽医保交易记录数据插入保存
	*/
	public abstract HpTransActAhDO[] insert(HpTransActAhDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保交易记录数据保存
	*/
	public abstract HpTransActAhDO[] save(HpTransActAhDO[] aggdos) throws BizException;
	
    /**
	*  安徽医保交易记录数据更新
	*/
	public abstract HpTransActAhDO[] update(HpTransActAhDO[] aggdos) throws BizException;
	
	/**
	*  安徽医保交易记录数据逻辑删除
	*/
	public abstract void logicDelete(HpTransActAhDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpTransActAhDO[] enableWithoutFilter(HpTransActAhDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpTransActAhDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpTransActAhDO[] disableVOWithoutFilter(HpTransActAhDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpTransActAhDO[] aggdos) throws BizException ;
	
}
