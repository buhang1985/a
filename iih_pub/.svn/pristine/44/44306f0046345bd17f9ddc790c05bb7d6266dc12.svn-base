package iih.ci.ord.doctorstationprinter.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.doctorstationprinter.d.DoctorstationprinterDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医生站打印机设置数据维护服务
*/
public interface IDoctorstationprinterCudService {
	/**
	*  医生站打印机设置数据真删除
	*/
    public abstract void delete(DoctorstationprinterDO[] aggdos) throws BizException;
    
    /**
	*  医生站打印机设置数据插入保存
	*/
	public abstract DoctorstationprinterDO[] insert(DoctorstationprinterDO[] aggdos) throws BizException;
	
    /**
	*  医生站打印机设置数据保存
	*/
	public abstract DoctorstationprinterDO[] save(DoctorstationprinterDO[] aggdos) throws BizException;
	
    /**
	*  医生站打印机设置数据更新
	*/
	public abstract DoctorstationprinterDO[] update(DoctorstationprinterDO[] aggdos) throws BizException;
	
	/**
	*  医生站打印机设置数据逻辑删除
	*/
	public abstract void logicDelete(DoctorstationprinterDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DoctorstationprinterDO[] enableWithoutFilter(DoctorstationprinterDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DoctorstationprinterDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DoctorstationprinterDO[] disableVOWithoutFilter(DoctorstationprinterDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DoctorstationprinterDO[] dos) throws BizException ;
}
