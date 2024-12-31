package iih.pe.phm.pehmlifestyle.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pehmlifestyle.d.PeHmLifestyleDO;
import iih.pe.phm.pehmlifestyle.d.PehmlifestyleAggDO;

/**
* 健康生活方式评估数据维护服务
*/
public interface IPehmlifestyleCudService {
	/**
	*  健康生活方式评估数据真删除
	*/
    public abstract void delete(PehmlifestyleAggDO[] aggdos) throws BizException;
    
    /**
	*  健康生活方式评估数据插入保存
	*/
	public abstract PehmlifestyleAggDO[] insert(PehmlifestyleAggDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估数据保存
	*/
	public abstract PehmlifestyleAggDO[] save(PehmlifestyleAggDO[] aggdos) throws BizException;
	
    /**
	*  健康生活方式评估数据更新
	*/
	public abstract PehmlifestyleAggDO[] update(PehmlifestyleAggDO[] aggdos) throws BizException;
	
	/**
	*  健康生活方式评估数据逻辑删除
	*/
	public abstract void logicDelete(PehmlifestyleAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对健康生活方式评估数据真删除
	 */
	public abstract void deleteByParentDO(PeHmLifestyleDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对健康生活方式评估数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeHmLifestyleDO[] mainDos) throws BizException;
}
