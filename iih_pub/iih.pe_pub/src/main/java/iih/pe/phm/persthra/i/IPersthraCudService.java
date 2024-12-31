package iih.pe.phm.persthra.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.persthra.d.PeRstHraDO;
import iih.pe.phm.persthra.d.PersthraAggDO;

/**
* 健康评估结果-单因素数据维护服务
*/
public interface IPersthraCudService {
	/**
	*  健康评估结果-单因素数据真删除
	*/
    public abstract void delete(PersthraAggDO[] aggdos) throws BizException;
    
    /**
	*  健康评估结果-单因素数据插入保存
	*/
	public abstract PersthraAggDO[] insert(PersthraAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估结果-单因素数据保存
	*/
	public abstract PersthraAggDO[] save(PersthraAggDO[] aggdos) throws BizException;
	
    /**
	*  健康评估结果-单因素数据更新
	*/
	public abstract PersthraAggDO[] update(PersthraAggDO[] aggdos) throws BizException;
	
	/**
	*  健康评估结果-单因素数据逻辑删除
	*/
	public abstract void logicDelete(PersthraAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康评估结果-单因素数据真删除
	 */
	public abstract void deleteByParentDO(PeRstHraDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康评估结果-单因素数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeRstHraDO[] mainDos) throws BizException;
}
