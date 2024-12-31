package iih.mi.bd.cataloguploadrcd.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.mi.bd.cataloguploadrcd.d.MiCatalogUploadRcdDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保原始目录文件上传记录数据维护服务
*/
public interface ICataloguploadrcdCudService {
	/**
	*  医保原始目录文件上传记录数据真删除
	*/
    public abstract void delete(MiCatalogUploadRcdDO[] aggdos) throws BizException;
    
    /**
	*  医保原始目录文件上传记录数据插入保存
	*/
	public abstract MiCatalogUploadRcdDO[] insert(MiCatalogUploadRcdDO[] aggdos) throws BizException;
	
    /**
	*  医保原始目录文件上传记录数据保存
	*/
	public abstract MiCatalogUploadRcdDO[] save(MiCatalogUploadRcdDO[] aggdos) throws BizException;
	
    /**
	*  医保原始目录文件上传记录数据更新
	*/
	public abstract MiCatalogUploadRcdDO[] update(MiCatalogUploadRcdDO[] aggdos) throws BizException;
	
	/**
	*  医保原始目录文件上传记录数据逻辑删除
	*/
	public abstract void logicDelete(MiCatalogUploadRcdDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiCatalogUploadRcdDO[] enableWithoutFilter(MiCatalogUploadRcdDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiCatalogUploadRcdDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiCatalogUploadRcdDO[] disableVOWithoutFilter(MiCatalogUploadRcdDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiCatalogUploadRcdDO[] dos) throws BizException ;
	
	/**
	 * 查询可用数据
	 * @author zhang.hw
	 * @date 2019年5月16日
	 * @param miSrvTp
	 * @return
	 * @throws BizException
	 */
	public MiCatalogUploadRcdDO findUseringData(String idHp,String miSrvTp) throws BizException;
	
	/**
	 * 插入医保目录下载记录
	 * @author zhang.hw
	 * @date 2019年5月16日
	 * @param miCatalogUploadRcdDO
	 * @return
	 * @throws BizException
	 */
	public FBoolean insertRcdDo(MiCatalogUploadRcdDO miCatalogUploadRcdDO) throws BizException;
	
}
