package iih.pe.phm.pemetabolic.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pemetabolic.d.PeMetabolicDefDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检危险因素-肥胖与高血压糖尿病血脂异常关系数据维护服务
*/
public interface IPemetabolicCudService {
	/**
	*  体检危险因素-肥胖与高血压糖尿病血脂异常关系数据真删除
	*/
    public abstract void delete(PeMetabolicDefDO[] aggdos) throws BizException;
    
    /**
	*  体检危险因素-肥胖与高血压糖尿病血脂异常关系数据插入保存
	*/
	public abstract PeMetabolicDefDO[] insert(PeMetabolicDefDO[] aggdos) throws BizException;
	
    /**
	*  体检危险因素-肥胖与高血压糖尿病血脂异常关系数据保存
	*/
	public abstract PeMetabolicDefDO[] save(PeMetabolicDefDO[] aggdos) throws BizException;
	
    /**
	*  体检危险因素-肥胖与高血压糖尿病血脂异常关系数据更新
	*/
	public abstract PeMetabolicDefDO[] update(PeMetabolicDefDO[] aggdos) throws BizException;
	
	/**
	*  体检危险因素-肥胖与高血压糖尿病血脂异常关系数据逻辑删除
	*/
	public abstract void logicDelete(PeMetabolicDefDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeMetabolicDefDO[] enableWithoutFilter(PeMetabolicDefDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeMetabolicDefDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeMetabolicDefDO[] disableVOWithoutFilter(PeMetabolicDefDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeMetabolicDefDO[] dos) throws BizException ;
}
