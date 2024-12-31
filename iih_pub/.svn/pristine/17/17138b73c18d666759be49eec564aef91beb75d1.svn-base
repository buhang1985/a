package iih.bd.mhi.hpdrug.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpdrug.d.HpDrugDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
 * 医保产品_药品数据维护服务
 */
public interface IHpdrugCudService {
	/**
	 * 医保产品_药品数据真删除
	 */
	public abstract void delete(HpDrugDO[] aggdos) throws BizException;

	/**
	 * 医保产品_药品数据插入保存
	 */
	public abstract HpDrugDO[] insert(HpDrugDO[] aggdos) throws BizException;

	/**
	 * 医保产品_药品数据保存
	 */
	public abstract HpDrugDO[] save(HpDrugDO[] aggdos) throws BizException;

	/**
	 * 医保产品_药品数据更新
	 */
	public abstract HpDrugDO[] update(HpDrugDO[] aggdos) throws BizException;

	/**
	 * 医保产品_药品数据逻辑删除
	 */
	public abstract void logicDelete(HpDrugDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDrugDO[] enableWithoutFilter(HpDrugDO[] dos) throws BizException;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDrugDO[] dos) throws BizException;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDrugDO[] disableVOWithoutFilter(HpDrugDO[] dos) throws BizException;

	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDrugDO[] dos) throws BizException;
}
