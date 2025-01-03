package iih.en.pv.i;

import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.dto.d.HosRecallDTO;
import iih.en.pv.dto.d.IpInfoDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.dto.d.MainStateDTO;
import iih.en.pv.dto.d.PativisitensonDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.enres.d.EnAuthDO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.inpatient.dto.d.EnIppreCancelHosDTO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.BedQrySchmDTO;

import java.lang.reflect.InvocationTargetException;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 住院就诊命令服务
 * @author yank
 *
 */
public interface IEnIpCmdService {
	/****
	 * 修改床位费用
	 * @throws BizException
	 */
	void updateBedPric(BedQrySchmDTO bedQrySchmDTO,String Id_bed) throws BizException;
	/***
	 * 根据就诊编码回写转诊单就诊id
	 * @param codeEnt 就诊编码
	 * @throws BizException
	 */
	void updateReferralEnt(String codeEnt) throws BizException;
	/**
	 * 保存入院通知单信息
	 * @param entipntDTO 入院通知单DTO
	 * @return
	 * @throws BizException
	 */
	void saveIpnt(AptIpDTO entipntDTO,Boolean isDiagEnd) throws BizException;
	/**
	 * 取消住院申请
	 * @param entipntDTO 住院申请
	 * @param entId 当前就诊ID
	 * @throws BizException
	 */
	void cancAptIp(AptIpDTO entipntDTO,String entId) throws BizException;
	/**
	 * 入院登记
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 */
	EnHosRegDTO register(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO) throws BizException;	

	/***
	 * 入院登记（含患者注册）--先保存患者信息
	 * @param patDTO
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	EnHosPatDTO savePatInfo(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO)throws BizException;	
	/**
	 * 入院登记（含患者注册）
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 */
	EnHosRegDTO regAndPatReg(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO) throws BizException;
	
	/**
	 * 入院登记注册保存失败时，回滚生成的住院号 zhangpp 2019.10.31
	 * @throws BizException
	 */
	void rollBackCodeAmrIp(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException; 
	
	/**
	 * 入院登记（含患者注册）
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 */
	EnHosRegDTO regAndPatReg2(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO,String id_transactneusoftahip) throws BizException;

	/**
	 * 入院登记自动记账
	 * 
	 * @param entId
	 *            就诊id
	 * @param fgFirst
	 *            是否首次入院
	 * @return
	 * @throws BizException
	 * @author jizb
	 */
	public FBoolean chargeForIpRegister(String entId, FBoolean fgFirst)throws BizException;
	/**
	 * 入院登记保存前校验
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 * @param isReg 是否是入院登记（含注册）节点
	 */
	InpatientDO validateIPData(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO,FBoolean isReg) throws BizException;
	/**
	 * 取消入院登记
	 * @param entId
	 * @throws BizException
	 */
	void cancRegister(EnHosRegDTO enHosRegDTO) throws BizException;
	/**
	 * 取消入院登记前校验
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	void validateBeforeCancel(EnHosRegDTO enHosRegDTO) throws BizException;
	/**
	 * 入科服务
	 * @param endepDTO 一条记录患者信息的入科DTO
	 * @return boolean 反应是否入科成功
	 * @throws BizException
	 */
	FBoolean enterDep(EnDepDTO endepDTO) throws BizException;
	/**
	 * 更新住院信息
	 * @param ipInfoDTO 住院信息
	 * @return
	 * @throws BizException
	 */
	void updateIpInfo(IpInfoDTO ipInfoDTO) throws BizException;
	/**
	 * 换床
	 * 根据对应的床位状态及ent_id判定是换空床，还是两人交换
	 * @param source 原来床位
	 * @param target 目标床位
	 * @throws BizException
	 */
	void changeBed(BedBigCardDTO source,BedBigCardDTO target) throws BizException;
	/**
	 * 包床
	 * @param entId 就诊id
	 * @param mainBedId 主床位id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	void rentBed(String entId,String mainBedId,String bedId) throws BizException;
	/**
	 * 取消包床
	 * @param entId 就诊id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	void cancRentBed(String entId,String bedId) throws BizException;
	/**
	 * 保存医护人员信息
	 * @param medPsnDTO 医护人员DTO
	 * @throws BizException
	 */
	PativisitensonDTO[] saveMedPsn(PativisitensonDTO medPsnDTO) throws BizException;
	/**
	 * 申请转科
	 * @param patDTO 患者信息
	 * @throws BizException 
	 */
	void applyTransDep(TransDepPatDTO[] patDTO) throws BizException;
	/**
	 * 撤销转出
	 * 
	 * @param cancelDTOs
	 * @throws BizException
	 */
	void cancelTransOut(TransDepPatDTO[] cancelDTOs) throws BizException;
	/**
	 * 转科转入申请确认
	 * @param patDTO 申请患者
	 * @param endepDTO 入科信息
	 * @throws BizException 
	 */
	void cfmTransDepApp(TransDepPatDTO patDTO,EnDepDTO endepDTO) throws BizException;
	/**
	 * 出院
	 * @param appDTO 出院申请DTO
	 * @throws BizException
	 */
	void leaveHos(LvHosAppDTO appDTO) throws BizException;
	/**
	 * 召回
	 * @param recallDTO 召回DTO
	 * @throws BizException
	 */
	void recall(HosRecallDTO recallDTO) throws BizException;
	/**
	 * 取消入科 zhangpp-2018.12.11
	 * @param dischargeDTO
	 * @throws BizException
	 */
	void disIpacpt(DischargeDTO dischargeDTO) throws BizException;
	/** 
	 * 退院
	 * @param dischargeDTO 退院申请DTO
	 * @throws BizException
	 */
	void dischargeHos(DischargeDTO dischargeDTO) throws BizException;
	/** 
	 * 退院前校验
	 * @param dischargeDTO 退院申请DTO
	 * @throws BizException
	 */
	void validateBeforeDischarge(DischargeDTO dischargeDTO) throws BizException;
	/**
	 * 设置就诊状况
	 * @param entStateDTO 就诊状况DTO
	 * @throws BizException
	 */
	void setEntState(EntStateDTO entStateDTO) throws BizException;
	/**
	 * 设置患者就诊状况
	 * @param entId 就诊ID
	 * @param entStateDTOs 就诊状况DTO数组
	 * @throws BizException
	 * @author renying
	 */
	void setPatEntState(String entId,EntStateDTO[] entStateDTOs) throws BizException;
	/**
	 * 设置患者主要就诊状况
	 * 包括：病情、护理、营养
	 * @param mainStateDTO 主要就诊状况DTO
	 * @throws BizException
	 * @author renying
	 */
	void setMainEntState(MainStateDTO mainStateDTO) throws BizException;	
	/**
	 * 新增新生儿记录
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	String insertNb(NewbornDTO nbDTO) throws BizException;
	/**
	 * 更新新生儿记录
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	void updateNb(NewbornDTO nbDTO) throws BizException;
	/**
	 * 删除新生儿记录
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 */
	void deleteNb(NewbornDTO nbDTO) throws BizException;
	/**
	 * 同步婴儿信息
	 * 1、更新婴儿就诊联系人
	 * 2、更新婴儿患者联系人
	 * @param momEntId 母亲就诊ID
	 * @throws BizException
	 * @author zhengcm
	 */
	void syncBabyInfo(String momEntId) throws BizException;
	/**
	 * 住院医保身份修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	void ipRegHpInfoChg(EnHosPatDTO patDTO, EnHosRegDTO enHosReg) throws BizException;
	/**
	 * 住院医保取消登记
	 * 
	 * @param codeEnt
	 * @throws BizException
	 */
	void ipRegHpCancel(String codeEnt) throws BizException;
	/**
	 * 医保身份修改
	 * 
	 * @param ipHpRegist
	 * @throws BizException
	 */
	void updateIpHpRegist(IpHpRegistDTO ipHpRegist) throws BizException;
	
	 /**
     * 保存团检单位信息
     * @param qryDTO
     * @return
     * @throws BizException
     */
    public void saveEnPeCmpyInfo(EnPeCmpyDTO qryDTO)throws BizException;
    
    /**
     * 根据团检记录id删除团检记录
     * @param qryDTO
     * @throws BizException
     */
    public void deleteEnPeCmpInfo(EnPeCmpyDTO qryDTO)throws BizException;
    
    /**
     * 保存团检单位患者信息
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void saveEnPePatInfos(String pecmpyId)throws BizException;
    
    
    /**
     * 团检出院
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void LvEnPe(String pecmpyId)throws BizException;
    
    /**
     * 团检取消入院
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void CancelEnPeReg(String pecmpyId)throws BizException;
    /**
     * 用户加关注
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
    public void addNarkPat(String entId, String empId)throws BizException;
    /**
     * 用户取消关注
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
    public void cancNarkPat(String entId, String empId)throws BizException;
    /**
     * 修改入院日期
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
    public void updateDtacpt(IpRegInfoDTO newregInfoDTO,IpRegInfoDTO oldregInfoDTO)throws BizException;
    /**
	 * 患者授权-确认授权
	 * @throws BizException 
	 */
	public EnAuthDO authComfirm(EnAuthDO authDO) throws BizException;
	/**
	 * 患者授权-取消授权
	 * @param authDO
	 * @throws BizException
	 */
	public void cancelAuth(EnAuthDO authDO) throws BizException;
	/**
	 * 出院人数统计接口
	 * 
	 * @param nurId
	 * @param dateTime
	 * @throws BizException
	 */
	public void callBackLvNum4Nm(String nurId, FDateTime dateTime) throws BizException;
	
	/**
	 * 保存新生儿体重等信息
	 * @return
	 */
	public void saveNb4weight(NewbornDTO nbDTO) throws BizException;
	/***
     * 修改患者的责任医生为当前医生
     * @param entId
     * @param empId
     * @throws BizException
     */
    public FBoolean updateDutyEmp(String entId, String empId) throws BizException;
    /**
	 * 接收预住院
	 * @param enDepDTO
	 * @throws BizException
	 */
	public FBoolean saveAccepteEnippre(EnDepDTO enDepDTO) throws BizException;
	/**
	 * 预住院中止入院
	 * @param enIppreCancelDto
	 * @throws BizException
	 */
	public void ippreCancelHos(EnIppreCancelHosDTO enIppreCancelDto) throws BizException;
	/**
	 * 预住院转入院
	 * @param ippreTransHos
	 * @throws BizException
	 */
	public void ippreTransHos(EnIppreTransHosDTO ippreTransHos) throws BizException;
	/**
	 * 取消预住院转入院
	 * @param ippreTransHos
	 * @throws BizException
	 */
	public void cancelIppreTransHos(EnIppreInfoDTO ippreTransHos) throws BizException;
	/**
	 * 取消中止住院
	 * @param ippreTransHos
	 * @throws BizException
	 */
	public void cancelIppreSuspendHos(EnIppreInfoDTO ippreTransHos) throws BizException;
    /***
     * 母婴分床、合床
     * 
     * @param id_ent
     * @param fg_sepa
     * @throws BizException
     */
    public void updateBbSepa(BedBigCardDTO originalBedDTO,BedBigCardDTO targetBedDTO,FBoolean fg_sepa) throws BizException;
}
