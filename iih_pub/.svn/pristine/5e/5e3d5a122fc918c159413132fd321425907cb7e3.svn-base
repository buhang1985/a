package iih.bd.bc.cdsys.i;

import xap.mw.core.data.BizException;
import iih.bd.bc.cdsys.d.MedCdSystemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗编码标准数据维护服务
*/
public interface ICdsysCudService {
	/**
	*  医疗编码标准数据真删除
	*/
    public abstract void delete(MedCdSystemDO[] aggdos) throws BizException;
    
    /**
	*  医疗编码标准数据插入保存
	*/
	public abstract MedCdSystemDO[] insert(MedCdSystemDO[] aggdos) throws BizException;
	
    /**
	*  医疗编码标准数据保存
	*/
	public abstract MedCdSystemDO[] save(MedCdSystemDO[] aggdos) throws BizException;
	
    /**
	*  医疗编码标准数据更新
	*/
	public abstract MedCdSystemDO[] update(MedCdSystemDO[] aggdos) throws BizException;
	
	/**
	*  医疗编码标准数据逻辑删除
	*/
	public abstract void logicDelete(MedCdSystemDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedCdSystemDO[] enableWithoutFilter(MedCdSystemDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedCdSystemDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedCdSystemDO[] disableVOWithoutFilter(MedCdSystemDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedCdSystemDO[] dos) throws BizException ;
}
