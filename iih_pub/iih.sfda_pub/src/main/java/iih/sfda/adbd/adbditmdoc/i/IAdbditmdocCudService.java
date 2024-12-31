package iih.sfda.adbd.adbditmdoc.i;

import xap.mw.core.data.BizException;
import iih.sfda.adbd.adbditmdoc.d.AdbdItmdoclistDO;
import iih.sfda.adbd.adbditmdoc.d.AdbditmdocAggDO;

/**
* 属性项目档案数据维护服务
*/
public interface IAdbditmdocCudService {
	/**
	*  属性项目档案数据真删除
	*/
    public abstract void delete(AdbditmdocAggDO[] aggdos) throws BizException;
    
    /**
	*  属性项目档案数据插入保存
	*/
	public abstract AdbditmdocAggDO[] insert(AdbditmdocAggDO[] aggdos) throws BizException;
	
    /**
	*  属性项目档案数据保存
	*/
	public abstract AdbditmdocAggDO[] save(AdbditmdocAggDO[] aggdos) throws BizException;
	
    /**
	*  属性项目档案数据更新
	*/
	public abstract AdbditmdocAggDO[] update(AdbditmdocAggDO[] aggdos) throws BizException;
	
	/**
	*  属性项目档案数据逻辑删除
	*/
	public abstract void logicDelete(AdbditmdocAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对属性项目档案数据真删除
	 */
	public abstract void deleteByParentDO(AdbdItmdoclistDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对属性项目档案数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(AdbdItmdoclistDO[] mainDos) throws BizException;
}
