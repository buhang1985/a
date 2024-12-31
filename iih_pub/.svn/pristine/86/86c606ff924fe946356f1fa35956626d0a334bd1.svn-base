package iih.pe.pis.i;

import java.util.List;
import xap.mw.core.data.BizException;
import javax.jws.WebParam;
import javax.jws.WebService;

import iih.pe.papt.dto.groupsummaryreport.d.AgedisDTO;
import iih.pe.papt.dto.groupsummaryreport.d.BMIdisDTO;
import iih.pe.papt.dto.groupsummaryreport.d.BMIexplaindisDTO;
import iih.pe.papt.dto.groupsummaryreport.d.BloodFatdisDTO;
import iih.pe.papt.dto.groupsummaryreport.d.BloodGlucosedisDTO;
import iih.pe.papt.dto.groupsummaryreport.d.BloodPressuredisDTO;
import iih.pe.papt.dto.groupsummaryreport.d.EatingHabitsdisDTO;
import iih.pe.papt.dto.groupsummaryreport.d.InfoDTO;
import iih.pe.papt.dto.groupsummaryreport.d.PositiveSummaryReportDTO;
import iih.pe.papt.dto.itemintroductiondto.d.ItemIntroductionDTO;
import iih.pe.papt.dto.peaptsummarydto.d.PeAptSummaryDTO;
import iih.pe.papt.dto.pecorpdto.d.PeCorpDTO;
import iih.pe.papt.dto.pehmapptdto.d.PeHmApptListDTO;
import iih.pe.papt.dto.pepanapptdto.d.PePsnApptDTO;
import iih.pe.pis.dto.pepsnreport.d.PeReportDTO;
import iih.pe.pqn.dto.peheinsureport.d.PeHeInSuReportDTO;
import iih.pe.pqn.dto.peqadto.d.PeQaGrpDTO;
import iih.pe.papt.dto.pepanapptdto.d.PeappttladderDTO;
import iih.pe.pis.dto.papt.d.PeCorpApptDTO;
import iih.pe.pis.dto.papt.d.PeCorpGrpDTO;
import iih.pe.pwf.dto.pepsnapptdto.d.PepsnApptDTO;
import iih.pe.pwf.dto.petimeline.d.PeTimeLineDTO;
import iih.pe.pis.dto.papt.d.PeSrvBCatLogDTO;
import iih.pe.pis.dto.papt.d.PeSrvSetDTO;
import iih.pe.papt.dto.pepanapptdto.d.PesrvsetitmDTO;
import iih.pe.papt.dto.pepsnaptqrydto.d.PeCorpListQry;
import iih.pe.papt.dto.perecomdto.d.PerecomDTO;
import iih.pe.phm.dto.petcmevaldto.d.PeTCMConDTO;
import iih.pe.papt.dto.pepanapptdto.d.PesrvsetDTO;

@WebService
public interface IPePisQueryService {

	public abstract List<PesrvsetDTO> getOepSetList() throws BizException;

	public abstract List<PesrvsetitmDTO> getItmDetailList(@WebParam(name = "id_pesrvset") String id_pesrvset)
			throws BizException;

	public abstract List<PeappttladderDTO> getApptDateList() throws BizException;

	public abstract List<PePsnApptDTO> getPePsnApptInfo(@WebParam(name = "id_pepsnappt") String id_pepsnappt)
			throws BizException;

	public abstract PeReportDTO searchPeReport(@WebParam(name = "peapptid") String peapptid) throws BizException;

	public abstract List<PeSrvSetDTO> queryPeSets(@WebParam(name = "sexLimit") int sexLimit) throws BizException;

	public abstract List<PeSrvBCatLogDTO> queryPeSetItems(@WebParam(name = "catlog") int catlog,
			@WebParam(name = "sexLimit") int sexLimit) throws BizException;

	public abstract List<PeSrvBCatLogDTO> queryItemsByGrpId(@WebParam(name = "grpId") String grpId) throws BizException;

	public abstract List<String> queryItemIdsBySetId(@WebParam(name = "setId") String setId) throws BizException;

	public abstract PeCorpApptDTO queryTeamAptById(@WebParam(name = "id_pecorpappt") String id_pecorpappt)
			throws BizException;

	public abstract PeCorpGrpDTO getOneGrpDTO() throws BizException;

	public abstract List<PeQaGrpDTO> queryQuestionGrp(@WebParam(name = "apptype") int apptype,
			@WebParam(name = "questiontype") int questiontype, @WebParam(name = "id_pepsnappt") String id_pepsnappt)
			throws BizException;

	public abstract List<PepsnApptDTO> queryPeApt(@WebParam(name = "patCode") String patCode) throws BizException;

	public abstract List<PepsnApptDTO> queryPeAptOrderByDt(@WebParam(name = "patCode") String patCode)
			throws BizException;

	public abstract boolean questionHasFinish(@WebParam(name = "apptype") int apptype,
			@WebParam(name = "id_pepsnappt") String id_pepsnappt) throws BizException;

	public abstract List<PeHeInSuReportDTO> queryReportDTO(@WebParam(name = "type") int type,
			@WebParam(name = "id_pepsnappt") String id_pepsnappt) throws BizException;

	public abstract List<PeHmApptListDTO> queryPeHeApt(@WebParam(name = "patCode") String patCode) throws BizException;

	public abstract PeCorpDTO peTeamLogin(@WebParam(name = "code") String code, @WebParam(name = "pwd") String pwd)
			throws BizException;

	public abstract PeCorpDTO getPeCorpDTO() throws BizException;

	public abstract List<PeCorpDTO> queryPeCorpAptOrderByDt(@WebParam(name = "code") String code) throws BizException;

	public abstract List<PeCorpListQry> queryCorpList(@WebParam(name = "id_pecorpbinfo") String id_pecorpbinfo,
			@WebParam(name = "id_pecorpappt") String id_pecorpappt,
			@WebParam(name = "id_pecorpapptgrp") String id_pecorpapptgrp, @WebParam(name = "pestatus") String pestatus)
			throws BizException;

	public abstract List<InfoDTO> queryPeList(@WebParam(name = "pecorpapptid") String pecorpapptid,
			@WebParam(name = "sqlBranch") int sqlBranch) throws BizException;

	/**
	 * 参检者性别年龄分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<AgedisDTO> queryAgedis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者平均体质指数按年龄性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<BMIdisDTO> queryBMIdis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者肥胖年龄性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<BMIexplaindisDTO> queryBMIexplaindis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者血压年龄性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<BloodPressuredisDTO> queryBloodPressuredis(
			@WebParam(name = "pecorpapptid") String pecorpapptid) throws BizException;

	/**
	 * 参检者血糖年龄性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<BloodGlucosedisDTO> queryBloodGlucosedis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者血脂检测结果性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<BloodFatdisDTO> queryBloodFatdis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者饮食习惯性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<EatingHabitsdisDTO> queryEatingHabitsdis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者饮酒人数性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<EatingHabitsdisDTO> queryDrinkingStatusdis(
			@WebParam(name = "pecorpapptid") String pecorpapptid) throws BizException;

	/**
	 * 参检者吸烟状况性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<EatingHabitsdisDTO> querySmokingStatusdis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者睡眠情况性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<EatingHabitsdisDTO> querySleepStatusdis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者运动情况性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<EatingHabitsdisDTO> queryMotionStatusdis(@WebParam(name = "pecorpapptid") String pecorpapptid)
			throws BizException;

	/**
	 * 参检者异常诊断人数性别分布
	 * 
	 * @param pecorpapptid
	 * @return
	 * @throws BizException
	 */
	public abstract List<EatingHabitsdisDTO> queryAbnormalDiagnosisdis(
			@WebParam(name = "pecorpapptid") String pecorpapptid) throws BizException;

	public abstract List<PositiveSummaryReportDTO> queryPositiveSummaryReport(
			@WebParam(name = "pecorpapptid") String pecorpapptid) throws BizException;

	/**
	 * @Description: 查询检查项目及意义介绍
	 * @Author: chen.zhao
	 * @return
	 * @throws BizException
	 * @date: 2020年4月21日
	 */
	public abstract List<ItemIntroductionDTO> queryItemIntroduction() throws BizException;

	/**
	 * @Description: 查询个人体检时间线
	 * @Author: chen.zhao
	 * @param id_pepsnappt
	 * @return
	 * @throws BizException
	 * @date: 2020年4月26日
	 */
	public abstract List<PeTimeLineDTO> queryPeTimeLine(@WebParam(name = "id_pepsnappt") String id_pepsnappt)
			throws BizException;

	/**
	 * 健康自测问题列表
	 * 
	 * @param id_pehmappt
	 * @return
	 * @throws BizException
	 */
	public abstract List<PeQaGrpDTO> getHeAssQueList(@WebParam(name = "id_pehmappt") String id_pehmappt,
			@WebParam(name = "id_peqacatlog") String id_peqacatlog) throws BizException;

	/**
	 * 健康自测评估结果
	 * 
	 * @param id_pehmappt
	 * @return
	 * @throws BizException
	 */
	public abstract List<PeTCMConDTO> getPetcmconList(@WebParam(name = "id_pehmappt") String id_pehmappt,
			@WebParam(name = "id_peqacatlog") String id_peqacatlog) throws BizException;

	/**
	 * 体检报告对比列表
	 * 
	 * @param id_pehmappt
	 * @return
	 * @throws BizException
	 */
	public abstract List<PerecomDTO> getPerecomList(@WebParam(name = "id_pepsnappt") String id_pepsnappt)
			throws BizException;

	/**
	 * 员工登录
	 * 
	 * @param id_pehmappt
	 * @return
	 * @throws BizException
	 */
	public abstract boolean peStaffLogin(@WebParam(name = "userCode") String userCode,
			@WebParam(name = "userPWD") String userPWD) throws BizException;

	/**
	 * 体检预约人数分布
	 * 
	 * @param id_pehmappt
	 * @return
	 * @throws BizException
	 */
	public abstract List<PeAptSummaryDTO> getPeAptSuList(@WebParam(name = "month") String month) throws BizException;

}
