package iih.mi.bd.miudidoc.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.mi.bd.d.MiudidocDTO;
import iih.mi.bd.miudidoc.d.MiUdidocDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保档案数据维护服务
*/
public interface IMiudidocCudService {
	/**
	*  医保档案数据真删除
	*/
    public abstract void delete(MiUdidocDO[] aggdos) throws BizException;
    
    /**
	*  医保档案数据插入保存
	*/
	public abstract MiUdidocDO[] insert(MiUdidocDO[] aggdos) throws BizException;
	
    /**
	*  医保档案数据保存
	*/
	public abstract MiUdidocDO[] save(MiUdidocDO[] aggdos) throws BizException;
	
    /**
	*  医保档案数据更新
	*/
	public abstract MiUdidocDO[] update(MiUdidocDO[] aggdos) throws BizException;
	
	/**
	*  医保档案数据逻辑删除
	*/
	public abstract void logicDelete(MiUdidocDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiUdidocDO[] enableWithoutFilter(MiUdidocDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiUdidocDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiUdidocDO[] disableVOWithoutFilter(MiUdidocDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiUdidocDO[] dos) throws BizException ;
	
	/**
	 * 导入字典数据
	 * @author zhang.hw
	 * @date 2019年5月22日
	 * @param miUdidocDOs
	 * @return
	 * @throws BizException
	 */
	public void importData(MiudidocDTO[] miUdidocDTOs,String idhp) throws BizException;
}
