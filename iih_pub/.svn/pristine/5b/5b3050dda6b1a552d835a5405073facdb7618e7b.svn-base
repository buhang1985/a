package iih.mi.mc.mimcpatspecdrugalogquando.i;

import xap.mw.core.data.BizException;
import iih.mi.mc.mimcpatspecdrugalogquando.d.MiMcPatSpecDrugALogQuanDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者特殊病药品增量维护日志表数据维护服务
*/
public interface IMimcpatspecdrugalogquandoCudService {
	/**
	*  患者特殊病药品增量维护日志表数据真删除
	*/
    public abstract void delete(MiMcPatSpecDrugALogQuanDO[] aggdos) throws BizException;
    
    /**
	*  患者特殊病药品增量维护日志表数据插入保存
	*/
	public abstract MiMcPatSpecDrugALogQuanDO[] insert(MiMcPatSpecDrugALogQuanDO[] aggdos) throws BizException;
	
    /**
	*  患者特殊病药品增量维护日志表数据保存
	*/
	public abstract MiMcPatSpecDrugALogQuanDO[] save(MiMcPatSpecDrugALogQuanDO[] aggdos) throws BizException;
	
    /**
	*  患者特殊病药品增量维护日志表数据更新
	*/
	public abstract MiMcPatSpecDrugALogQuanDO[] update(MiMcPatSpecDrugALogQuanDO[] aggdos) throws BizException;
	
	/**
	*  患者特殊病药品增量维护日志表数据逻辑删除
	*/
	public abstract void logicDelete(MiMcPatSpecDrugALogQuanDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiMcPatSpecDrugALogQuanDO[] enableWithoutFilter(MiMcPatSpecDrugALogQuanDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiMcPatSpecDrugALogQuanDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiMcPatSpecDrugALogQuanDO[] disableVOWithoutFilter(MiMcPatSpecDrugALogQuanDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiMcPatSpecDrugALogQuanDO[] dos) throws BizException ;
}
