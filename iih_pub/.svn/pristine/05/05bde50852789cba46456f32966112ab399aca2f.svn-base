package iih.bd.res.bed.i;

import xap.mw.core.data.BizException;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedAggDO;

/**
* 床位管理数据维护服务
*/
public interface IBedCudService {
	/**
	*  床位管理数据真删除
	*/
    public abstract void delete(BedAggDO[] aggdos) throws BizException;
    
    /**
	*  床位管理数据插入保存
	*/
	public abstract BedAggDO[] insert(BedAggDO[] aggdos) throws BizException;
	
    /**
	*  床位管理数据保存
	*/
	public abstract BedAggDO[] save(BedAggDO[] aggdos) throws BizException;
	
    /**
	*  床位管理数据更新
	*/
	public abstract BedAggDO[] update(BedAggDO[] aggdos) throws BizException;
	
	/**
	*  床位管理数据逻辑删除
	*/
	public abstract void logicDelete(BedAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对床位管理数据真删除
	 */
	public abstract void deleteByParentDO(Bdbed[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对床位管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(Bdbed[] mainDos) throws BizException;
}
