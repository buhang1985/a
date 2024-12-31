package iih.mp.mpbd.docmemo.i;

import xap.mw.core.data.BizException;
import iih.mp.mpbd.docmemo.d.DocMemoFileDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 医生备忘录数据维护服务
*/
public interface IDocMemoFileDOCudService {
	/**
	*  医生备忘录数据真删除
	*/
    public abstract void delete(DocMemoFileDO[] aggdos) throws BizException;
    
    /**
	*  医生备忘录数据插入保存
	*/
	public abstract DocMemoFileDO[] insert(DocMemoFileDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据保存
	*/
	public abstract DocMemoFileDO[] save(DocMemoFileDO[] aggdos) throws BizException;
	
    /**
	*  医生备忘录数据更新
	*/
	public abstract DocMemoFileDO[] update(DocMemoFileDO[] aggdos) throws BizException;
	
	/**
	*  医生备忘录数据逻辑删除
	*/
	public abstract void logicDelete(DocMemoFileDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DocMemoFileDO[] enableWithoutFilter(DocMemoFileDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DocMemoFileDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DocMemoFileDO[] disableVOWithoutFilter(DocMemoFileDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DocMemoFileDO[] aggdos) throws BizException ;
	
}
