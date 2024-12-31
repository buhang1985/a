package iih.mi.mibd.medkind.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.medkind.d.MedkindDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_医疗类别数据维护服务
*/
public interface IMedkindCudService {
	/**
	*  医保平台_医疗类别数据真删除
	*/
    public abstract void delete(MedkindDO[] aggdos) throws BizException;
    
    /**
	*  医保平台_医疗类别数据插入保存
	*/
	public abstract MedkindDO[] insert(MedkindDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗类别数据保存
	*/
	public abstract MedkindDO[] save(MedkindDO[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗类别数据更新
	*/
	public abstract MedkindDO[] update(MedkindDO[] aggdos) throws BizException;
	
	/**
	*  医保平台_医疗类别数据逻辑删除
	*/
	public abstract void logicDelete(MedkindDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedkindDO[] enableWithoutFilter(MedkindDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedkindDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedkindDO[] disableVOWithoutFilter(MedkindDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedkindDO[] dos) throws BizException ;
}
