package iih.mi.biz.insureprop.ynyuxiethoep.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.insureprop.ynyuxiethoep.d.MiPropArOepYXNeusoftDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 玉溪门诊医保分摊数据维护服务
*/
public interface IMoepropynyuxiethCudService {
	/**
	*  玉溪门诊医保分摊数据真删除
	*/
    public abstract void delete(MiPropArOepYXNeusoftDO[] aggdos) throws BizException;
    
    /**
	*  玉溪门诊医保分摊数据插入保存
	*/
	public abstract MiPropArOepYXNeusoftDO[] insert(MiPropArOepYXNeusoftDO[] aggdos) throws BizException;
	
    /**
	*  玉溪门诊医保分摊数据保存
	*/
	public abstract MiPropArOepYXNeusoftDO[] save(MiPropArOepYXNeusoftDO[] aggdos) throws BizException;
	
    /**
	*  玉溪门诊医保分摊数据更新
	*/
	public abstract MiPropArOepYXNeusoftDO[] update(MiPropArOepYXNeusoftDO[] aggdos) throws BizException;
	
	/**
	*  玉溪门诊医保分摊数据逻辑删除
	*/
	public abstract void logicDelete(MiPropArOepYXNeusoftDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiPropArOepYXNeusoftDO[] enableWithoutFilter(MiPropArOepYXNeusoftDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiPropArOepYXNeusoftDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiPropArOepYXNeusoftDO[] disableVOWithoutFilter(MiPropArOepYXNeusoftDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiPropArOepYXNeusoftDO[] dos) throws BizException ;
}
