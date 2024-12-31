package iih.ci.mr.nu.earlywarnmark.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.earlywarnmark.d.EarlywarnminfoDO;
import iih.ci.mr.nu.earlywarnmark.d.EarlywarnmarkAggDO;

/**
* 重症患者早期预警评分表数据维护服务
*/
public interface IEarlywarnmarkCudService {
	/**
	*  重症患者早期预警评分表数据真删除
	*/
    public abstract void delete(EarlywarnmarkAggDO[] aggdos) throws BizException;
    
    /**
	*  重症患者早期预警评分表数据插入保存
	*/
	public abstract EarlywarnmarkAggDO[] insert(EarlywarnmarkAggDO[] aggdos) throws BizException;
	
    /**
	*  重症患者早期预警评分表数据保存
	*/
	public abstract EarlywarnmarkAggDO[] save(EarlywarnmarkAggDO[] aggdos) throws BizException;
	
    /**
	*  重症患者早期预警评分表数据更新
	*/
	public abstract EarlywarnmarkAggDO[] update(EarlywarnmarkAggDO[] aggdos) throws BizException;
	
	/**
	*  重症患者早期预警评分表数据逻辑删除
	*/
	public abstract void logicDelete(EarlywarnmarkAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对重症患者早期预警评分表数据真删除
	 */
	public abstract void deleteByParentDO(EarlywarnminfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对重症患者早期预警评分表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EarlywarnminfoDO[] mainDos) throws BizException;
}
