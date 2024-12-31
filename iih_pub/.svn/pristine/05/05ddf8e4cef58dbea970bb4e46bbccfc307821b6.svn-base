package iih.mi.biz.insureprop.lyneusoftip.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.insureprop.lyneusoftip.d.MiPropArIPLYNeusoftDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 临沂住院医保分摊数据维护服务
*/
public interface IMiproparipneusoftlyCudService {
	/**
	*  临沂住院医保分摊数据真删除
	*/
    public abstract void delete(MiPropArIPLYNeusoftDO[] aggdos) throws BizException;
    
    /**
	*  临沂住院医保分摊数据插入保存
	*/
	public abstract MiPropArIPLYNeusoftDO[] insert(MiPropArIPLYNeusoftDO[] aggdos) throws BizException;
	
    /**
	*  临沂住院医保分摊数据保存
	*/
	public abstract MiPropArIPLYNeusoftDO[] save(MiPropArIPLYNeusoftDO[] aggdos) throws BizException;
	
    /**
	*  临沂住院医保分摊数据更新
	*/
	public abstract MiPropArIPLYNeusoftDO[] update(MiPropArIPLYNeusoftDO[] aggdos) throws BizException;
	
	/**
	*  临沂住院医保分摊数据逻辑删除
	*/
	public abstract void logicDelete(MiPropArIPLYNeusoftDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiPropArIPLYNeusoftDO[] enableWithoutFilter(MiPropArIPLYNeusoftDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiPropArIPLYNeusoftDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiPropArIPLYNeusoftDO[] disableVOWithoutFilter(MiPropArIPLYNeusoftDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiPropArIPLYNeusoftDO[] dos) throws BizException ;
}
