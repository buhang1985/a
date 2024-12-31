package iih.ci.mr.nu.opermatlist.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.opermatlist.d.OpermatDO;
import iih.ci.mr.nu.opermatlist.d.OpermatlistAggDO;

/**
* 手术患者术中物品清点单数据维护服务
*/
public interface IOpermatlistCudService {
	/**
	*  手术患者术中物品清点单数据真删除
	*/
    public abstract void delete(OpermatlistAggDO[] aggdos) throws BizException;
    
    /**
	*  手术患者术中物品清点单数据插入保存
	*/
	public abstract OpermatlistAggDO[] insert(OpermatlistAggDO[] aggdos) throws BizException;
	
    /**
	*  手术患者术中物品清点单数据保存
	*/
	public abstract OpermatlistAggDO[] save(OpermatlistAggDO[] aggdos) throws BizException;
	
    /**
	*  手术患者术中物品清点单数据更新
	*/
	public abstract OpermatlistAggDO[] update(OpermatlistAggDO[] aggdos) throws BizException;
	
	/**
	*  手术患者术中物品清点单数据逻辑删除
	*/
	public abstract void logicDelete(OpermatlistAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对手术患者术中物品清点单数据真删除
	 */
	public abstract void deleteByParentDO(OpermatDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对手术患者术中物品清点单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(OpermatDO[] mainDos) throws BizException;
}
