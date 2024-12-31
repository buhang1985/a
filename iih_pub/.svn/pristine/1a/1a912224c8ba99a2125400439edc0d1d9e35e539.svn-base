package iih.hr.hbd.psntitle.i;

import xap.mw.core.data.BizException;
import iih.hr.hbd.psntitle.d.HbdPsnTitleDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 人员职称数据维护服务
*/
public interface IPsntitleCudService {
	/**
	*  人员职称数据真删除
	*/
    public abstract void delete(HbdPsnTitleDO[] aggdos) throws BizException;
    
    /**
	*  人员职称数据插入保存
	*/
	public abstract HbdPsnTitleDO[] insert(HbdPsnTitleDO[] aggdos) throws BizException;
	
    /**
	*  人员职称数据保存
	*/
	public abstract HbdPsnTitleDO[] save(HbdPsnTitleDO[] aggdos) throws BizException;
	
    /**
	*  人员职称数据更新
	*/
	public abstract HbdPsnTitleDO[] update(HbdPsnTitleDO[] aggdos) throws BizException;
	
	/**
	*  人员职称数据逻辑删除
	*/
	public abstract void logicDelete(HbdPsnTitleDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HbdPsnTitleDO[] enableWithoutFilter(HbdPsnTitleDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HbdPsnTitleDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HbdPsnTitleDO[] disableVOWithoutFilter(HbdPsnTitleDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HbdPsnTitleDO[] dos) throws BizException ;
}
