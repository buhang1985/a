package iih.mp.nr.nurhdv.i;

import xap.mw.core.data.BizException;
import iih.mp.nr.nurhdv.d.HdvEntAttrDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 护士交接班数据维护服务
*/
public interface IHdvEntAttrDOCudService {
	/**
	*  护士交接班数据真删除
	*/
    public abstract void delete(HdvEntAttrDO[] aggdos) throws BizException;
    
    /**
	*  护士交接班数据插入保存
	*/
	public abstract HdvEntAttrDO[] insert(HdvEntAttrDO[] aggdos) throws BizException;
	
    /**
	*  护士交接班数据保存
	*/
	public abstract HdvEntAttrDO[] save(HdvEntAttrDO[] aggdos) throws BizException;
	
    /**
	*  护士交接班数据更新
	*/
	public abstract HdvEntAttrDO[] update(HdvEntAttrDO[] aggdos) throws BizException;
	
	/**
	*  护士交接班数据逻辑删除
	*/
	public abstract void logicDelete(HdvEntAttrDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HdvEntAttrDO[] enableWithoutFilter(HdvEntAttrDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HdvEntAttrDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HdvEntAttrDO[] disableVOWithoutFilter(HdvEntAttrDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HdvEntAttrDO[] aggdos) throws BizException ;
	
}
