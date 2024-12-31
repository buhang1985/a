package iih.ci.ord.ordprintsignpsn.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.ord.ordprintsignpsn.d.OrdPrintSignPsnDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医嘱打印签字人员数据维护服务
*/
public interface IOrdprintsignpsnCudService {
	/**
	*  医嘱打印签字人员数据真删除
	*/
    public abstract void delete(OrdPrintSignPsnDO[] aggdos) throws BizException;
    
    /**
	*  医嘱打印签字人员数据插入保存
	*/
	public abstract OrdPrintSignPsnDO[] insert(OrdPrintSignPsnDO[] aggdos) throws BizException;
	
    /**
	*  医嘱打印签字人员数据保存
	*/
	public abstract OrdPrintSignPsnDO[] save(OrdPrintSignPsnDO[] aggdos) throws BizException;
	
    /**
	*  医嘱打印签字人员数据更新
	*/
	public abstract OrdPrintSignPsnDO[] update(OrdPrintSignPsnDO[] aggdos) throws BizException;
	
	/**
	*  医嘱打印签字人员数据逻辑删除
	*/
	public abstract void logicDelete(OrdPrintSignPsnDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public OrdPrintSignPsnDO[] enableWithoutFilter(OrdPrintSignPsnDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(OrdPrintSignPsnDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public OrdPrintSignPsnDO[] disableVOWithoutFilter(OrdPrintSignPsnDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(OrdPrintSignPsnDO[] dos) throws BizException ;
	/**
	 * 删除签署人
	 * @param id_en
	 * @param page_num
	 * @param fg_long
	 * @param fg_herb
	 * @return
	 */
	public String delSignPsn(String id_en, String page_num, FBoolean fg_long, FBoolean fg_herb) throws BizException ;
}
