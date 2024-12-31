package iih.mi.biz.insureprop.lyneusoftoep.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.insureprop.lyneusoftoep.d.MiPropArOepLYNeusoftDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 临沂医保门诊分摊表数据维护服务
*/
public interface IMiproparoeplyneusoftoepCudService {
	/**
	*  临沂医保门诊分摊表数据真删除
	*/
    public abstract void delete(MiPropArOepLYNeusoftDO[] aggdos) throws BizException;
    
    /**
	*  临沂医保门诊分摊表数据插入保存
	*/
	public abstract MiPropArOepLYNeusoftDO[] insert(MiPropArOepLYNeusoftDO[] aggdos) throws BizException;
	
    /**
	*  临沂医保门诊分摊表数据保存
	*/
	public abstract MiPropArOepLYNeusoftDO[] save(MiPropArOepLYNeusoftDO[] aggdos) throws BizException;
	
    /**
	*  临沂医保门诊分摊表数据更新
	*/
	public abstract MiPropArOepLYNeusoftDO[] update(MiPropArOepLYNeusoftDO[] aggdos) throws BizException;
	
	/**
	*  临沂医保门诊分摊表数据逻辑删除
	*/
	public abstract void logicDelete(MiPropArOepLYNeusoftDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiPropArOepLYNeusoftDO[] enableWithoutFilter(MiPropArOepLYNeusoftDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiPropArOepLYNeusoftDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiPropArOepLYNeusoftDO[] disableVOWithoutFilter(MiPropArOepLYNeusoftDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiPropArOepLYNeusoftDO[] dos) throws BizException ;
}
