package iih.ci.rcm.infectionoutbreakreport.i;

import xap.mw.core.data.BizException;
import iih.ci.rcm.infectionoutbreakreport.d.InfectionOutbreakReportDO;
import iih.ci.rcm.infectionoutbreakreport.d.InfectionoutbreakreportAggDO;

/**
* 医院感染暴发报告登记表数据维护服务
*/
public interface IInfectionoutbreakreportCudService {
	/**
	*  医院感染暴发报告登记表数据真删除
	*/
    public abstract void delete(InfectionoutbreakreportAggDO[] aggdos) throws BizException;
    
    /**
	*  医院感染暴发报告登记表数据插入保存
	*/
	public abstract InfectionoutbreakreportAggDO[] insert(InfectionoutbreakreportAggDO[] aggdos) throws BizException;
	
    /**
	*  医院感染暴发报告登记表数据保存
	*/
	public abstract InfectionoutbreakreportAggDO[] save(InfectionoutbreakreportAggDO[] aggdos) throws BizException;
	
    /**
	*  医院感染暴发报告登记表数据更新
	*/
	public abstract InfectionoutbreakreportAggDO[] update(InfectionoutbreakreportAggDO[] aggdos) throws BizException;
	
	/**
	*  医院感染暴发报告登记表数据逻辑删除
	*/
	public abstract void logicDelete(InfectionoutbreakreportAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医院感染暴发报告登记表数据真删除
	 */
	public abstract void deleteByParentDO(InfectionOutbreakReportDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医院感染暴发报告登记表数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(InfectionOutbreakReportDO[] mainDos) throws BizException;
}
