package iih.ci.rcm.specimen.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.specimen.d.SpecimenDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* ICU病例监测_标本数据维护服务
*/
public interface ISpecimenCudService {
	/**
	*  ICU病例监测_标本数据真删除
	*/
    public abstract void delete(SpecimenDO[] aggdos) throws BizException;
    
    /**
	*  ICU病例监测_标本数据插入保存
	*/
	public abstract SpecimenDO[] insert(SpecimenDO[] aggdos) throws BizException;
	
    /**
	*  ICU病例监测_标本数据保存
	*/
	public abstract SpecimenDO[] save(SpecimenDO[] aggdos) throws BizException;
	
    /**
	*  ICU病例监测_标本数据更新
	*/
	public abstract SpecimenDO[] update(SpecimenDO[] aggdos) throws BizException;
	
	/**
	*  ICU病例监测_标本数据逻辑删除
	*/
	public abstract void logicDelete(SpecimenDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SpecimenDO[] enableWithoutFilter(SpecimenDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SpecimenDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SpecimenDO[] disableVOWithoutFilter(SpecimenDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SpecimenDO[] dos) throws BizException ;
}
