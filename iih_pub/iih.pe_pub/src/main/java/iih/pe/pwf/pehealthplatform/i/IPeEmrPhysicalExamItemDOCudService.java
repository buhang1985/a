package iih.pe.pwf.pehealthplatform.i;

import xap.mw.core.data.BizException;
import iih.pe.pwf.pehealthplatform.d.PeEmrPhysicalExamItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检健康平台接口山东数据维护服务
*/
public interface IPeEmrPhysicalExamItemDOCudService {
	/**
	*  体检健康平台接口山东数据真删除
	*/
    public abstract void delete(PeEmrPhysicalExamItemDO[] aggdos) throws BizException;
    
    /**
	*  体检健康平台接口山东数据插入保存
	*/
	public abstract PeEmrPhysicalExamItemDO[] insert(PeEmrPhysicalExamItemDO[] aggdos) throws BizException;
	
    /**
	*  体检健康平台接口山东数据保存
	*/
	public abstract PeEmrPhysicalExamItemDO[] save(PeEmrPhysicalExamItemDO[] aggdos) throws BizException;
	
    /**
	*  体检健康平台接口山东数据更新
	*/
	public abstract PeEmrPhysicalExamItemDO[] update(PeEmrPhysicalExamItemDO[] aggdos) throws BizException;
	
	/**
	*  体检健康平台接口山东数据逻辑删除
	*/
	public abstract void logicDelete(PeEmrPhysicalExamItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeEmrPhysicalExamItemDO[] enableWithoutFilter(PeEmrPhysicalExamItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeEmrPhysicalExamItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeEmrPhysicalExamItemDO[] disableVOWithoutFilter(PeEmrPhysicalExamItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeEmrPhysicalExamItemDO[] aggdos) throws BizException ;
	
}