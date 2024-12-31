package iih.bd.srv.mrctmca.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.d.MrctmcaAggDO;

/**
* 医疗记录类型自定义分类数据维护服务
*/
public interface IMrctmcaCudService {
	/**
	*  医疗记录类型自定义分类数据真删除
	*/
    public abstract void delete(MrctmcaAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录类型自定义分类数据插入保存
	*/
	public abstract MrctmcaAggDO[] insert(MrctmcaAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录类型自定义分类数据保存
	*/
	public abstract MrctmcaAggDO[] save(MrctmcaAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录类型自定义分类数据更新
	*/
	public abstract MrctmcaAggDO[] update(MrctmcaAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录类型自定义分类数据逻辑删除
	*/
	public abstract void logicDelete(MrctmcaAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录类型自定义分类数据真删除
	 */
	public abstract void deleteByParentDO(MrCtmCaDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录类型自定义分类数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MrCtmCaDO[] mainDos) throws BizException;
}
