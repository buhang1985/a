package iih.mi.mc.mimcpatspecdrugaquando.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimcpatspecdrugaquando.d.MiMcPatSpecDrugAQuanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者特殊病药品增量表数据维护服务
*/
public interface IMimcpatspecdrugaquandoCudService {
	/**
	*  患者特殊病药品增量表数据真删除
	*/
    public abstract void delete(MiMcPatSpecDrugAQuanDO[] aggdos) throws BizException;
    
    /**
	*  患者特殊病药品增量表数据插入保存
	*/
	public abstract MiMcPatSpecDrugAQuanDO[] insert(MiMcPatSpecDrugAQuanDO[] aggdos) throws BizException;
	
    /**
	*  患者特殊病药品增量表数据保存
	*/
	public abstract MiMcPatSpecDrugAQuanDO[] save(MiMcPatSpecDrugAQuanDO[] aggdos) throws BizException;
	
    /**
	*  患者特殊病药品增量表数据更新
	*/
	public abstract MiMcPatSpecDrugAQuanDO[] update(MiMcPatSpecDrugAQuanDO[] aggdos) throws BizException;
	
	/**
	*  患者特殊病药品增量表数据逻辑删除
	*/
	public abstract void logicDelete(MiMcPatSpecDrugAQuanDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcPatSpecDrugAQuanDO[] enableWithoutFilter(MiMcPatSpecDrugAQuanDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcPatSpecDrugAQuanDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcPatSpecDrugAQuanDO[] disableVOWithoutFilter(MiMcPatSpecDrugAQuanDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcPatSpecDrugAQuanDO[] dos) throws BizException ;
}
