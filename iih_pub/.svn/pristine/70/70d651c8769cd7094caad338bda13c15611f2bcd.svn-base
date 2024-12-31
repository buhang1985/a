package iih.pe.pitm.pesrvsampleca.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvsampleca.d.PeSrvSampleCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检标本类型数据维护服务
*/
public interface IPesrvsamplecaCudService {
	/**
	*  体检标本类型数据真删除
	*/
    public abstract void delete(PeSrvSampleCaDO[] aggdos) throws BizException;
    
    /**
	*  体检标本类型数据插入保存
	*/
	public abstract PeSrvSampleCaDO[] insert(PeSrvSampleCaDO[] aggdos) throws BizException;
	
    /**
	*  体检标本类型数据保存
	*/
	public abstract PeSrvSampleCaDO[] save(PeSrvSampleCaDO[] aggdos) throws BizException;
	
    /**
	*  体检标本类型数据更新
	*/
	public abstract PeSrvSampleCaDO[] update(PeSrvSampleCaDO[] aggdos) throws BizException;
	
	/**
	*  体检标本类型数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvSampleCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvSampleCaDO[] enableWithoutFilter(PeSrvSampleCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvSampleCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvSampleCaDO[] disableVOWithoutFilter(PeSrvSampleCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvSampleCaDO[] dos) throws BizException ;
}
