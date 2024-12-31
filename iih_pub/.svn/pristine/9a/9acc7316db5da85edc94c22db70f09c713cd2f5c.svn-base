package iih.pi.dic.creditcategory.i;

import xap.mw.core.data.BizException;
import iih.pi.dic.creditcategory.d.PiPatCretDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者信用分类数据维护服务
*/
public interface ICreditcategoryCudService {
	/**
	*  患者信用分类数据真删除
	*/
    public abstract void delete(PiPatCretDO[] aggdos) throws BizException;
    
    /**
	*  患者信用分类数据插入保存
	*/
	public abstract PiPatCretDO[] insert(PiPatCretDO[] aggdos) throws BizException;
	
    /**
	*  患者信用分类数据保存
	*/
	public abstract PiPatCretDO[] save(PiPatCretDO[] aggdos) throws BizException;
	
    /**
	*  患者信用分类数据更新
	*/
	public abstract PiPatCretDO[] update(PiPatCretDO[] aggdos) throws BizException;
	
	/**
	*  患者信用分类数据逻辑删除
	*/
	public abstract void logicDelete(PiPatCretDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatCretDO[] enableWithoutFilter(PiPatCretDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatCretDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatCretDO[] disableVOWithoutFilter(PiPatCretDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatCretDO[] dos) throws BizException ;
}
