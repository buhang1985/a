package iih.mp.orm.surginsmtmrtpl.i;

import xap.mw.core.data.BizException;
import iih.mp.orm.surginsmtmrtpl.d.SurgInsmtMrtplItemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 手术器械模板数据维护服务
*/
public interface ISurgInsmtMrtplItemDOCudService {
	/**
	*  手术器械模板数据真删除
	*/
    public abstract void delete(SurgInsmtMrtplItemDO[] aggdos) throws BizException;
    
    /**
	*  手术器械模板数据插入保存
	*/
	public abstract SurgInsmtMrtplItemDO[] insert(SurgInsmtMrtplItemDO[] aggdos) throws BizException;
	
    /**
	*  手术器械模板数据保存
	*/
	public abstract SurgInsmtMrtplItemDO[] save(SurgInsmtMrtplItemDO[] aggdos) throws BizException;
	
    /**
	*  手术器械模板数据更新
	*/
	public abstract SurgInsmtMrtplItemDO[] update(SurgInsmtMrtplItemDO[] aggdos) throws BizException;
	
	/**
	*  手术器械模板数据逻辑删除
	*/
	public abstract void logicDelete(SurgInsmtMrtplItemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SurgInsmtMrtplItemDO[] enableWithoutFilter(SurgInsmtMrtplItemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SurgInsmtMrtplItemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SurgInsmtMrtplItemDO[] disableVOWithoutFilter(SurgInsmtMrtplItemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SurgInsmtMrtplItemDO[] aggdos) throws BizException ;
	
}
