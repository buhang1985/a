package iih.pe.papt.pecorpappt.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pecorpappt.d.PeCorpApptDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检团体预约单数据维护服务
*/
public interface IPecorpapptMDOCudService {
	/**
	*  体检团体预约单数据真删除
	*/
    public abstract void delete(PeCorpApptDO[] aggdos) throws BizException;
    
    /**
	*  体检团体预约单数据插入保存
	*/
	public abstract PeCorpApptDO[] insert(PeCorpApptDO[] aggdos) throws BizException;
	
    /**
	*  体检团体预约单数据保存
	*/
	public abstract PeCorpApptDO[] save(PeCorpApptDO[] aggdos) throws BizException;
	
    /**
	*  体检团体预约单数据更新
	*/
	public abstract PeCorpApptDO[] update(PeCorpApptDO[] aggdos) throws BizException;
	
	/**
	*  体检团体预约单数据逻辑删除
	*/
	public abstract void logicDelete(PeCorpApptDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCorpApptDO[] enableWithoutFilter(PeCorpApptDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCorpApptDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCorpApptDO[] disableVOWithoutFilter(PeCorpApptDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCorpApptDO[] aggdos) throws BizException ;
	
}