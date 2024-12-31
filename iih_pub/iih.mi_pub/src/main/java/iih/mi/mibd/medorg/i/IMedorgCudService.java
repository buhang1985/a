package iih.mi.mibd.medorg.i;

import xap.mw.core.data.BizException;
import iih.mi.mibd.medorg.d.MedorgDo;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保平台_医疗机构数据维护服务
*/
public interface IMedorgCudService {
	/**
	*  医保平台_医疗机构数据真删除
	*/
    public abstract void delete(MedorgDo[] aggdos) throws BizException;
    
    /**
	*  医保平台_医疗机构数据插入保存
	*/
	public abstract MedorgDo[] insert(MedorgDo[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗机构数据保存
	*/
	public abstract MedorgDo[] save(MedorgDo[] aggdos) throws BizException;
	
    /**
	*  医保平台_医疗机构数据更新
	*/
	public abstract MedorgDo[] update(MedorgDo[] aggdos) throws BizException;
	
	/**
	*  医保平台_医疗机构数据逻辑删除
	*/
	public abstract void logicDelete(MedorgDo[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MedorgDo[] enableWithoutFilter(MedorgDo[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MedorgDo[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MedorgDo[] disableVOWithoutFilter(MedorgDo[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MedorgDo[] dos) throws BizException ;
}
