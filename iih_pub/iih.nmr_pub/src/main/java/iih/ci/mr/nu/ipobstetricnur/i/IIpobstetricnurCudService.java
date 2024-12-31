package iih.ci.mr.nu.ipobstetricnur.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.ipobstetricnur.d.IpobstetricnurinfoDO;
import iih.ci.mr.nu.ipobstetricnur.d.IpobstetricnurAggDO;

/**
* 产科住院患者护理记录单数据维护服务
*/
public interface IIpobstetricnurCudService {
	/**
	*  产科住院患者护理记录单数据真删除
	*/
    public abstract void delete(IpobstetricnurAggDO[] aggdos) throws BizException;
    
    /**
	*  产科住院患者护理记录单数据插入保存
	*/
	public abstract IpobstetricnurAggDO[] insert(IpobstetricnurAggDO[] aggdos) throws BizException;
	
    /**
	*  产科住院患者护理记录单数据保存
	*/
	public abstract IpobstetricnurAggDO[] save(IpobstetricnurAggDO[] aggdos) throws BizException;
	
    /**
	*  产科住院患者护理记录单数据更新
	*/
	public abstract IpobstetricnurAggDO[] update(IpobstetricnurAggDO[] aggdos) throws BizException;
	
	/**
	*  产科住院患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(IpobstetricnurAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对产科住院患者护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(IpobstetricnurinfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对产科住院患者护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(IpobstetricnurinfoDO[] mainDos) throws BizException;
}
