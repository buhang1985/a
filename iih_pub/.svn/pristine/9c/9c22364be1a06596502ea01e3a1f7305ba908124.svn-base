package iih.bd.mhi.hpdosage.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpdosage.d.HpDosageDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保剂型目录数据维护服务
*/
public interface IHpdosageCudService {
	/**
	*  医保剂型目录数据真删除
	*/
    public abstract void delete(HpDosageDO[] aggdos) throws BizException;
    
    /**
	*  医保剂型目录数据插入保存
	*/
	public abstract HpDosageDO[] insert(HpDosageDO[] aggdos) throws BizException;
	
    /**
	*  医保剂型目录数据保存
	*/
	public abstract HpDosageDO[] save(HpDosageDO[] aggdos) throws BizException;
	
    /**
	*  医保剂型目录数据更新
	*/
	public abstract HpDosageDO[] update(HpDosageDO[] aggdos) throws BizException;
	
	/**
	*  医保剂型目录数据逻辑删除
	*/
	public abstract void logicDelete(HpDosageDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDosageDO[] enableWithoutFilter(HpDosageDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDosageDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDosageDO[] disableVOWithoutFilter(HpDosageDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDosageDO[] dos) throws BizException ;
}
