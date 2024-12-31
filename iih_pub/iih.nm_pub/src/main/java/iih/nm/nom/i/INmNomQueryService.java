package iih.nm.nom.i;

import iih.nm.nom.dto.nmnomwbkappdto.d.NomWbkAppDTO;
import iih.nm.nom.dto.nmpatinfodto.d.NmPatInfoDTO;
import iih.nm.nom.nmbedward.d.NmBedwardDTO;
import iih.nm.nom.nmbedwardrecord.d.NomBedwardItmDO;
import iih.nm.nom.nmnomwbkapp.d.NmNomWbkAppDO;
import iih.nm.nom.nmnomwbkitm.d.NmNomWbkItmDO;
import iih.nm.nom.nomquality.d.NomNurQualityDO;
import iih.nm.nom.nomwkitmapp.d.NomwkitmappAggDO;
import iih.nm.nom.nomwkitmcollectdto.d.NomWkitmCollectParamDTO;
import iih.nm.nom.nomwkitmcollectdto.d.NomwkitmappDTO;
import iih.nm.nom.nomwkitmcollectdto.d.UncomfirmSearchDTO;
import iih.nm.nqm.nqmchk.d.NqmChkDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

public interface INmNomQueryService {

	/**
	 * 
	 * @param id_dep_nur
	 * @param dt_month
	 * @return
	 * @throws BizException
	 */
	public abstract NomwkitmappAggDO findNomWkitmappAggData(String id_dep_nur, FDate dt_month) throws BizException;

	/**
	 * 根据科室与时间段查询工作量项目
	 * 
	 * @param id_dep_nur
	 *            科室Id
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public NomwkitmappDTO[] findNomwkitmappDTOs(NomWkitmCollectParamDTO paramDTO) throws BizException;

	/**
	 * 根据科室信息查询护理质量监控
	 * 
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public abstract NomNurQualityDO[] findNomNurQualityDO(String id_dep_nur, boolean isWard) throws BizException;

	/**
	 * 根据科室以及日期查询病房患者日志信息
	 * 
	 * @param id_dep_mp
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public NmBedwardDTO[] getNmBedwardDTOs(String id_dep_mp, FDate dt_begin, FDate dt_end) throws BizException;

	/**
	 * 根据科室以及日期获取未上报科室信息
	 * 
	 * @param id_dep_mp
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public UncomfirmSearchDTO[] getUncomfirmSearchDTOs(FDate dt_begin, FDate dt_end) throws BizException;

	/**
	 * 根据日期以及科室查询病房日志信息
	 * 
	 * @param id_dep_mp
	 * @param dt_date
	 * @return
	 * @throws BizException
	 */
	public NomBedwardItmDO[] getNomBedwardItmDOs(String id_dep_mp, FDate dt_date) throws BizException;

	/**
	 * 获取病房日志未上报科室信息
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public UncomfirmSearchDTO[] getBedwardUncomfirmDTOs(FDate dt_begin, FDate dt_end) throws BizException;

	/**
	 * 获取护理质量监控未上报科室信息
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public UncomfirmSearchDTO[] getQualityUncomfirmDTOs(FDate dt_begin, FDate dt_end) throws BizException;

	/**
	 * 获取未上报的护理质量管理信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public NomNurQualityDO[] getUnNomNurQualityDOs(FDate dt_begin, FDate dt_end) throws BizException;

	/**
	 * 获取护士长手册书写目录(lijm)
	 * 
	 * @param id_dep_nur
	 * @param dt_year
	 * @return
	 * @throws BizException
	 */
	public NomWbkAppDTO[] getNomWbkAppDirList(String id_dep, FDate dt_year) throws BizException;
	
	/**
	 * 质量检查问题汇总统计
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	public NqmChkDO[] getNqmChkQuesStatistics(String id_dep,String dt_chk,String[] sd_chk_lvl) throws BizException;

	/**
	 * 获取近一个月出院患者
	 * @param id_dep_nur
	 * @param dt_disc
	 * @return
	 * @throws BizException
	 */
	public NmPatInfoDTO[] getOutPatientPatinfo(String id_dep_nur,String dt_disc) throws BizException;
}
