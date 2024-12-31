package iih.pis.phk.i;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import iih.pis.phk.dto.d.PatReceiveDTO;
import iih.pis.phk.dto.d.PisEntDayInfoDTO;
import iih.pis.phk.dto.d.PisPhkMtAppQryDTO;
import iih.pis.phk.dto.d.PisPhkMedTechAplDTO;
import iih.pis.phk.dto.d.PisPhkRegResDTO;
import iih.pis.phk.dto.d.PisPhkSchinfoAndPregweekQryParamsDTO;
import iih.pis.phk.dto.d.PisPhkTriageBenInfoDTO;
import iih.pis.phk.dto.d.PisPhkTriageEntDTO;
import iih.pis.phk.dto.d.PisPhkTriageQueSiteDTO;
import iih.pis.phk.dto.d.StewardData;
import iih.pis.phk.render.orderCard.d.OrderData;
import iih.pis.phk.render.patientdata.d.PatientData;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.sys.jdbc.facade.DAException;

public interface IPisPhkQryService {
    /**
     * 加载管家下所有的患者信息
     * 
     * @param id_emp
     * @return
     */
    FArrayList loadPatientData(String id_emp) throws BizException;

    /**
     * 新增接待患者时，查询患者信息
     * 
     * @param idNo
     * @param cardtype
     * @return
     */
    PatientData getPatientInfo(String idNo, String cardtype) throws DAException;

    /**
     * 获得患者就诊和诊疗信息
     * 
     * @param id_pat
     * @return
     * @throws BizException
     */
    public OrderData[] getPatEntTreatInfo(String id_pat) throws BizException;

    /**
     * 获得所有管家信息
     * 
     * @return
     * @throws BizException
     */
    FArrayList getAllSteward(StewardData condition) throws BizException;

    /**
     * 获得患者的历次接待信息
     * 
     * @param dto
     * @return
     * @throws BizException
     */
    PatReceiveDTO[] getReceiveInfo(PatReceiveDTO dto) throws BizException;

    /**
     * 当日就诊信息
     * 
     * @param id_pat
     * @return
     * @throws BizException
     */
    public PisEntDayInfoDTO[] getEntDayInfo(String id_pat) throws BizException;

    /**
     * 当日费用信息
     * 
     * @param id_ent
     * @param code_entp
     * @return
     * @throws BizException
     */
    public FMap2 getPatEntFeesCensusBP(String id_ent, String code_entp) throws BizException;

    /**
     * 查询排班和孕周信息列表
     * 
     * @param id_pat
     *            患者id
     * @param code_pat
     *            患者code
     * @param deptCode
     *            科室编码
     * @param resName
     *            资源名称
     * @param srvType
     *            号别01-普通号 02-专家号；空串表示全部
     * @param yearMonth
     *            年月
     * @param chlType
     *            渠道类型
     * @return
     * @throws BizException
     */
    public FMap2 getSchList(PisPhkSchinfoAndPregweekQryParamsDTO qryDto) throws BizException, ParseException;

    /**
     * 根据就诊卡 医保卡 身份证等信息查询就诊记录
     * @param type
     * @param param
     * @param id_ben
     * @return
     * @throws BizException
     */
    public PatientData[] getEntData(String type, String param,String id_ben) throws BizException;

    /**
     * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
     * 
     * @param benId
     *            分诊台ID
     * @param code_entp
     *            就诊类型
     * @return
     * @throws BizException
     */
    PisPhkTriageBenInfoDTO getTriageBenInfo(String benId, String code_entp) throws BizException;

    /**
     * 得到分诊台的队列和站点信息信息，包括 队列或站点的分诊数和候诊数
     * 
     * @param date
     *            日期
     * @param dayslotId
     *            时间分组ID
     * @param benId
     *            分诊台ID
     * @return
     * @throws BizException
     */
    PisPhkTriageQueSiteDTO[] getOpTriQueSite(String dayslotId, String benId) throws BizException;

    /**
     * 
     * 根据status状态获取待分诊的患者列表
     * 
     * @param benId
     *            分诊台ID
     * @param dayslotId
     *            时间分诊ID
     * @param status
     *            状态 参照枚举：EntQueStatus
     *            <ul>
     *            <li>[-1] 未到诊状态患者</li>
     *            <li>[0] 到诊状态患者</li>
     *            <li>[1] 分诊状态患者</li>
     *            <li>[2] 通知状态患者</li>
     *            <li>[3] 就诊状态患者</li>
     *            <li>[4] 全部状态患者（不包括未到诊患者）</li>
     *            <li>[5] 回诊状态患者</li>
     *            </ul>
     * @return
     * @throws BizException
     */
    PisPhkTriageEntDTO[] getWaitingByBen(String benId, String dayslotId, int status) throws BizException;

    /**
     * 得到分诊台的队列和站点信息信息，
     * 包括队列或站点的分诊数和候诊数
     * 
     * @param benId 分诊台ID
     * @param date 日期
     * @param dayslotId 日期分组Id
     * @param depId 科室ID
     * @param status
     * @return
     * @throws BizException
     */
    public FMap getTriageSite(String benId,String code_entp,String dayslotId, String depId, int status) throws BizException;
    
    /**
     * 根据查询模板查询资源
     * ResQrySchemeDTO
     * @param qryScheme
     *            查询模板
     * @return
     * @throws BizException
     */
    public PisPhkRegResDTO[] getResByScheme(String qryScheme) throws BizException;
	/**
	 * 查询患者需要预约的检查申请单
	 * @param id_pat
	 * @return
	 * @throws DAException
	 */
	public PisPhkMedTechAplDTO[] getMedicalTchkAplDTOs(String id_pat) throws DAException ;
	/**
	 * 医技排班查询
	 * @param mtAppQryDTO
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws BizException 
	 * @throws ParseException 
	 */
	public FMap2 getMtResList(PisPhkMtAppQryDTO mtAppQryDTO) throws BizException, IllegalAccessException, InvocationTargetException, ParseException;
	public FArrayList getTriageSiteNew(String benId,String code_entp,String dayslotId, String depId, int status)  throws BizException;
	/**
	 * 患者医技预约和未预约查询
	 * @param id_pat
	 * @param id_dep_or 申请科室id
	 * @return
	 * @throws BizException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	FArrayList getPatMtAptList(String id_pat,String id_dep_or) throws BizException, IllegalAccessException, InvocationTargetException;
	/**
	 * 患者的管家对应的用户
	 * @param id_pat
	 * @return
	 */
	String[] getPhkUsers(String id_pat) throws DAException;
}
