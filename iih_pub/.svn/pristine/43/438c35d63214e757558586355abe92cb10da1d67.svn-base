package iih.bd.mhi.hpfeeca.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划_费用分类字典数据维护服务
*/
public interface IHpfeecaCudService {
	/**
	*  医保计划_费用分类字典数据真删除
	*/
    public abstract void delete(HpFeecaDO[] aggdos) throws BizException;
    
    /**
	*  医保计划_费用分类字典数据插入保存
	*/
	public abstract HpFeecaDO[] insert(HpFeecaDO[] aggdos) throws BizException;
	
    /**
	*  医保计划_费用分类字典数据保存
	*/
	public abstract HpFeecaDO[] save(HpFeecaDO[] aggdos) throws BizException;
	
    /**
	*  医保计划_费用分类字典数据更新
	*/
	public abstract HpFeecaDO[] update(HpFeecaDO[] aggdos) throws BizException;
	
	/**
	*  医保计划_费用分类字典数据逻辑删除
	*/
	public abstract void logicDelete(HpFeecaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpFeecaDO[] enableWithoutFilter(HpFeecaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpFeecaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpFeecaDO[] disableVOWithoutFilter(HpFeecaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpFeecaDO[] dos) throws BizException ;
}
