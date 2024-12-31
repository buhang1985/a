package iih.sfda.aer.sfdaaerevissu.i;

import xap.mw.core.data.BizException;
import iih.sfda.aer.sfdaaerevissu.d.SfdaAerEvIssuDO;
import iih.sfda.aer.sfdaaerevissu.d.SfdaaerevissuAggDO;

/**
* 不良报告_整改问题数据维护服务
*/
public interface ISfdaaerevissuCudService {
	/**
	*  不良报告_整改问题数据真删除
	*/
    public abstract void delete(SfdaaerevissuAggDO[] aggdos) throws BizException;
    
    /**
	*  不良报告_整改问题数据插入保存
	*/
	public abstract SfdaaerevissuAggDO[] insert(SfdaaerevissuAggDO[] aggdos) throws BizException;
	
    /**
	*  不良报告_整改问题数据保存
	*/
	public abstract SfdaaerevissuAggDO[] save(SfdaaerevissuAggDO[] aggdos) throws BizException;
	
    /**
	*  不良报告_整改问题数据更新
	*/
	public abstract SfdaaerevissuAggDO[] update(SfdaaerevissuAggDO[] aggdos) throws BizException;
	
	/**
	*  不良报告_整改问题数据逻辑删除
	*/
	public abstract void logicDelete(SfdaaerevissuAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对不良报告_整改问题数据真删除
	 */
	public abstract void deleteByParentDO(SfdaAerEvIssuDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对不良报告_整改问题数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SfdaAerEvIssuDO[] mainDos) throws BizException;
}
