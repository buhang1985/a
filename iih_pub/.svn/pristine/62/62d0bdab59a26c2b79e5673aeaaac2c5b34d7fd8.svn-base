package iih.pe.pps.peivforms.i;

import xap.mw.core.data.BizException;
import iih.pe.pps.peivforms.d.PeIvFormsDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检随访模板列表数据维护服务
*/
public interface IPeivformsCudService {
	/**
	*  体检随访模板列表数据真删除
	*/
    public abstract void delete(PeIvFormsDO[] aggdos) throws BizException;
    
    /**
	*  体检随访模板列表数据插入保存
	*/
	public abstract PeIvFormsDO[] insert(PeIvFormsDO[] aggdos) throws BizException;
	
    /**
	*  体检随访模板列表数据保存
	*/
	public abstract PeIvFormsDO[] save(PeIvFormsDO[] aggdos) throws BizException;
	
    /**
	*  体检随访模板列表数据更新
	*/
	public abstract PeIvFormsDO[] update(PeIvFormsDO[] aggdos) throws BizException;
	
	/**
	*  体检随访模板列表数据逻辑删除
	*/
	public abstract void logicDelete(PeIvFormsDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeIvFormsDO[] enableWithoutFilter(PeIvFormsDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeIvFormsDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeIvFormsDO[] disableVOWithoutFilter(PeIvFormsDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeIvFormsDO[] dos) throws BizException ;
}
