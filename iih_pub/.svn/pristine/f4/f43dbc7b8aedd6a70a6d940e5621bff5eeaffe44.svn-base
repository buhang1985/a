package iih.bd.pp.hpdivshis.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hpdivshis.d.HpDiVsHisDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 付款策略_医保病种目录对照数据维护服务
*/
public interface IHpdivshisCudService {
	/**
	*  付款策略_医保病种目录对照数据真删除
	*/
    public abstract void delete(HpDiVsHisDO[] aggdos) throws BizException;
    
    /**
	*  付款策略_医保病种目录对照数据插入保存
	*/
	public abstract HpDiVsHisDO[] insert(HpDiVsHisDO[] aggdos) throws BizException;
	
    /**
	*  付款策略_医保病种目录对照数据保存
	*/
	public abstract HpDiVsHisDO[] save(HpDiVsHisDO[] aggdos) throws BizException;
	
    /**
	*  付款策略_医保病种目录对照数据更新
	*/
	public abstract HpDiVsHisDO[] update(HpDiVsHisDO[] aggdos) throws BizException;
	
	/**
	*  付款策略_医保病种目录对照数据逻辑删除
	*/
	public abstract void logicDelete(HpDiVsHisDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDiVsHisDO[] enableWithoutFilter(HpDiVsHisDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDiVsHisDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDiVsHisDO[] disableVOWithoutFilter(HpDiVsHisDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDiVsHisDO[] dos) throws BizException ;
}
