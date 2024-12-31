package iih.pe.pitm.perstdocdidef.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.perstdocdidef.d.PeDocTmplDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检医生模板数据维护服务
*/
public interface IPerstdocdidefMDOCudService {
	/**
	*  体检医生模板数据真删除
	*/
    public abstract void delete(PeDocTmplDO[] aggdos) throws BizException;
    
    /**
	*  体检医生模板数据插入保存
	*/
	public abstract PeDocTmplDO[] insert(PeDocTmplDO[] aggdos) throws BizException;
	
    /**
	*  体检医生模板数据保存
	*/
	public abstract PeDocTmplDO[] save(PeDocTmplDO[] aggdos) throws BizException;
	
    /**
	*  体检医生模板数据更新
	*/
	public abstract PeDocTmplDO[] update(PeDocTmplDO[] aggdos) throws BizException;
	
	/**
	*  体检医生模板数据逻辑删除
	*/
	public abstract void logicDelete(PeDocTmplDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeDocTmplDO[] enableWithoutFilter(PeDocTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeDocTmplDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeDocTmplDO[] disableVOWithoutFilter(PeDocTmplDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeDocTmplDO[] aggdos) throws BizException ;
	
}
