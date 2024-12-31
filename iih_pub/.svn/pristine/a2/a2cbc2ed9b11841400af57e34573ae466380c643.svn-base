package iih.hp.cp.sd.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.sd.d.HpCpStandardDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 诊疗计划标准数据维护服务
*/
public interface IHpcpsdCudService {
	/**
	*  诊疗计划标准数据真删除
	*/
    public abstract void delete(HpCpStandardDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划标准数据插入保存
	*/
	public abstract HpCpStandardDO[] insert(HpCpStandardDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划标准数据保存
	*/
	public abstract HpCpStandardDO[] save(HpCpStandardDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划标准数据更新
	*/
	public abstract HpCpStandardDO[] update(HpCpStandardDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划标准数据逻辑删除
	*/
	public abstract void logicDelete(HpCpStandardDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpCpStandardDO[] enableWithoutFilter(HpCpStandardDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpCpStandardDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpCpStandardDO[] disableVOWithoutFilter(HpCpStandardDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpCpStandardDO[] dos) throws BizException ;
}
