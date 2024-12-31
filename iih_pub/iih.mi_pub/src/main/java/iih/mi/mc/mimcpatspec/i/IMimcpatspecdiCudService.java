package iih.mi.mc.mimcpatspec.i;

import iih.mi.mc.dto.d.MiMcPatSpecDTO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MimcpatspecdiAggDO;
import xap.mw.core.data.BizException;

/**
* 医保特殊病患者维护数据维护服务
*/
public interface IMimcpatspecdiCudService {
	/**
	*  医保特殊病患者维护数据真删除
	*/
    public abstract void delete(MimcpatspecdiAggDO[] aggdos) throws BizException;
    
    /**
	*  医保特殊病患者维护数据插入保存
	*/
	public abstract MimcpatspecdiAggDO[] insert(MimcpatspecdiAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者维护数据保存
	*/
	public abstract MimcpatspecdiAggDO[] save(MimcpatspecdiAggDO[] aggdos) throws BizException;
	
    /**
	*  医保特殊病患者维护数据更新
	*/
	public abstract MimcpatspecdiAggDO[] update(MimcpatspecdiAggDO[] aggdos) throws BizException;
	
	/**
	*  医保特殊病患者维护数据逻辑删除
	*/
	public abstract void logicDelete(MimcpatspecdiAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病患者维护数据真删除
	 */
	public abstract void deleteByParentDO(MiMcPatSpecDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保特殊病患者维护数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MiMcPatSpecDO[] mainDos) throws BizException;
	/**
	 * 根据AggDO保存导入医保患者诊断信息
	 */
	public abstract void importData(MiMcPatSpecDTO[] miSpecAgg) throws BizException;
}
