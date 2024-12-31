package iih.ci.mr.nu.babybirrecord.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.babybirrecord.d.BabyBirInfoDO;
import iih.ci.mr.nu.babybirrecord.d.BabybirrecordAggDO;

/**
* 婴儿产时记录数据维护服务
*/
public interface IBabybirrecordCudService {
	/**
	*  婴儿产时记录数据真删除
	*/
    public abstract void delete(BabybirrecordAggDO[] aggdos) throws BizException;
    
    /**
	*  婴儿产时记录数据插入保存
	*/
	public abstract BabybirrecordAggDO[] insert(BabybirrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  婴儿产时记录数据保存
	*/
	public abstract BabybirrecordAggDO[] save(BabybirrecordAggDO[] aggdos) throws BizException;
	
    /**
	*  婴儿产时记录数据更新
	*/
	public abstract BabybirrecordAggDO[] update(BabybirrecordAggDO[] aggdos) throws BizException;
	
	/**
	*  婴儿产时记录数据逻辑删除
	*/
	public abstract void logicDelete(BabybirrecordAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对婴儿产时记录数据真删除
	 */
	public abstract void deleteByParentDO(BabyBirInfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对婴儿产时记录数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BabyBirInfoDO[] mainDos) throws BizException;
}
