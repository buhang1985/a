package iih.en.pv.s;

import iih.en.comm.ep.EntAuthEP;
import java.lang.reflect.InvocationTargetException;
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
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.inpatient.dto.d.EnIppreCancelHosDTO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.en.pv.s.bp.CancMarkPatBP;
import iih.en.pv.s.bp.DeleteEnPePatBP;
import iih.en.pv.s.bp.EnCancAptIpBp;
import iih.en.pv.s.bp.SaveEnPePatInfosBP;
import iih.en.pv.s.bp.SetEntStateBP;
import iih.en.pv.s.bp.ip.AddMarkPatBP;
import iih.en.pv.s.bp.ip.ApplyTransDepBP;
import iih.en.pv.s.bp.ip.CallBackLvNum4NmBP;
import iih.en.pv.s.bp.ip.CancRentBedBP;
import iih.en.pv.s.bp.ip.CancelEnPeRegBP;
import iih.en.pv.s.bp.ip.CancelRegisterBP;
import iih.en.pv.s.bp.ip.CancelTransOutBP;
import iih.en.pv.s.bp.ip.CfmTransDepAppBP;
import iih.en.pv.s.bp.ip.ChangeBedBP;
import iih.en.pv.s.bp.ip.ChargeForIpRegisterBP;
import iih.en.pv.s.bp.ip.DeleteNbBP;
import iih.en.pv.s.bp.ip.DisIpacptBP;
import iih.en.pv.s.bp.ip.DischargeHosBP;
import iih.en.pv.s.bp.ip.EndepBp;
import iih.en.pv.s.bp.ip.IPRegisterBP;
import iih.en.pv.s.bp.ip.InsertNb4weightBP;
import iih.en.pv.s.bp.ip.InsertNbBP;
import iih.en.pv.s.bp.ip.IpRegHpCancelBP;
import iih.en.pv.s.bp.ip.IpRegHpInfoChgBP;
import iih.en.pv.s.bp.ip.LeaveHosBP;
import iih.en.pv.s.bp.ip.LvEnPeBP;
import iih.en.pv.s.bp.ip.RecallBP;
import iih.en.pv.s.bp.ip.RegAndPatRegBP;
import iih.en.pv.s.bp.ip.RentBedBP;
import iih.en.pv.s.bp.ip.SaveEnPeComyInfoBP;
import iih.en.pv.s.bp.ip.SaveEnPsnBP;
import iih.en.pv.s.bp.ip.SetMainEntStateBP;
import iih.en.pv.s.bp.ip.SetPatEntStateBP;
import iih.en.pv.s.bp.ip.SyncBabyInfoBP;
import iih.en.pv.s.bp.ip.UpdateBedPricBP;
import iih.en.pv.s.bp.ip.UpdateDtacptBP;
import iih.en.pv.s.bp.ip.UpdateDutyEmpBP;
import iih.en.pv.s.bp.ip.UpdateBbSepaBP;
import iih.en.pv.s.bp.ip.UpdateEntIdByEntCodeBP;
import iih.en.pv.s.bp.ip.UpdateIpHpRegistBP;
import iih.en.pv.s.bp.ip.UpdateIpInfoBP;
import iih.en.pv.s.bp.ip.UpdateNbBP;
import iih.en.pv.s.bp.ip.ValidateCanRegInfoBP;
import iih.en.pv.s.bp.ip.ValidateDischargeInfoBP;
import iih.en.pv.s.bp.ip.ValidateIPDataBP;
import iih.en.pv.s.bp.ippre.CancelIppreSuspendHosBP;
import iih.en.pv.s.bp.ippre.CancelIppreTransHosBP;
import iih.en.pv.s.bp.ippre.IppreCancelHosBP;
import iih.en.pv.s.bp.ippre.IppreTransHosBP;
import iih.en.pv.s.bp.ippre.qry.SaveAccepteEnippreBp;
import iih.en.pv.s.bp.op.SaveEntIpntBP;
import iih.sc.apt.dto.d.AptIpDTO;
import java.lang.reflect.InvocationTargetException;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import java.lang.reflect.InvocationTargetException;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 住院就诊变更服务
 * @author yank,renying
 *
 */
@Service(serviceInterfaces={IEnIpCmdService.class}, binding=Binding.JSONRPC)
public class EnIpCmdServiceImpl implements IEnIpCmdService {
	/****
	 * 修改床位费用
	 * @throws BizException
	 */
	@Override
	public void updateBedPric(BedQrySchmDTO bedQrySchmDTO,String Id_bed) throws BizException{
		UpdateBedPricBP bp = new UpdateBedPricBP();
		bp.exec(bedQrySchmDTO, Id_bed);
	}
	/***
	 * 根据就诊编码回写转诊单就诊id
	 * @param codeEnt 就诊编码
	 * @throws BizException
	 */
	@Override
	public void updateReferralEnt(String codeEnt) throws BizException{
		UpdateEntIdByEntCodeBP bp = new UpdateEntIdByEntCodeBP();
		bp.exec(codeEnt);
	}
	/**
	 * 保存入院通知单信息
	 * @param entipntDTO 入院通知单DTO
	 * @return
	 * @throws BizException
	 */                                                                           
	@Override
	public void saveIpnt(AptIpDTO entipntDTO,Boolean isDiagEnd) throws BizException{
		SaveEntIpntBP saveEntIpnt = new SaveEntIpntBP();
	    saveEntIpnt.exec(entipntDTO, isDiagEnd);
	}
	/**
	 * 取消住院申请
	 * @param entipntDTO 住院申请
	 * @param entId 当前就诊ID
	 * @throws BizException
	 */
	@Override
	public void cancAptIp(AptIpDTO entipntDTO,String entId) throws BizException{
		EnCancAptIpBp cancAptBp = new EnCancAptIpBp();
		cancAptBp.exec(entipntDTO, entId);
	}
	/**
	 * 入院登记
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 */
	@Override
	public EnHosRegDTO register(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO) throws BizException{
		IPRegisterBP registerbp = new IPRegisterBP();
		return registerbp.exec(patDTO, enHosRegDTO);
	}
	/***
	 * 入院登记（含患者注册）--先保存患者信息
	 * @param patDTO
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnHosPatDTO savePatInfo(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO) throws BizException{
		RegAndPatRegBP regBP = new RegAndPatRegBP();
		return regBP.savePatInfo(patDTO, enHosRegDTO);
	}
	/**
	 * 入院登记（含患者注册）
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 */
	@Override
	public EnHosRegDTO regAndPatReg(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO) throws BizException{
		RegAndPatRegBP regBP = new RegAndPatRegBP();
		return regBP.exec(patDTO, enHosRegDTO);
	}
	/**
	 * 入院登记注册保存失败时，回滚生成的住院号
	 */
	@Override
	public void rollBackCodeAmrIp(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException {
		RegAndPatRegBP regBP = new RegAndPatRegBP();
		regBP.rollBackCodeAmrIp(patDTO, enHosRegDTO);
	}
	/**
	 * 入院登记（含患者注册）
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 */
	@Override
	public EnHosRegDTO regAndPatReg2(EnHosPatDTO patDTO,EnHosRegDTO enHosRegDTO,String id_transactneusoftahip) throws BizException{
		RegAndPatRegBP regBP = new RegAndPatRegBP();
		return regBP.exec(patDTO, enHosRegDTO,id_transactneusoftahip);
	}
	/**
	 * 入院登记保存前校验
	 * @param patDTO 患者信息
	 * @param enHosRegDTO 入院登记DTO
	 * @param isReg 
	 */
	@Override
	public InpatientDO validateIPData(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO,FBoolean isReg) throws BizException{
		ValidateIPDataBP val = new ValidateIPDataBP();
		return val.exec(patDTO, enHosRegDTO, isReg);
	}
    /**
	 * 入院登记自动记账
	 * @param entId 就诊id
	 * @param fgFirst 是否首次入院
	 * @return
	 * @throws BizException
	 * @author jizb
	 */
	@Override
	public FBoolean chargeForIpRegister(String entId, FBoolean fgFirst) throws BizException {
		ChargeForIpRegisterBP bp = new ChargeForIpRegisterBP();
		return bp.exec(entId, fgFirst);
	}
	/**
	 * 取消入院登记
	 * @param entId
	 * @throws BizException
	 */
	@Override
	public void cancRegister(EnHosRegDTO enHosRegDTO) throws BizException{
		CancelRegisterBP cancelBP = new CancelRegisterBP();
		cancelBP.exec(enHosRegDTO);
	}
	/**
	 * 取消入院登记前校验
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	@Override
	public void validateBeforeCancel(EnHosRegDTO enHosRegDTO) throws BizException{
		//1、 查找就诊数据
		CancelRegisterBP cancelRegisterBP = new CancelRegisterBP();
		InpatientDO inpatientDO = cancelRegisterBP.getInpatient(enHosRegDTO.getId_ent());
		//2.校验数据
		ValidateCanRegInfoBP vb = new ValidateCanRegInfoBP();
		vb.exec(enHosRegDTO, inpatientDO);
	}
	/**
	 * 入科服务
	 * @param endepDTO 一条记录患者信息的入科DTO
	 * @return boolean 反应是否入科成功
	 * @throws BizException
	 */
	@Override
	public FBoolean enterDep(EnDepDTO endepDTO) throws BizException{
		EndepBp endepBP = new EndepBp();
		return endepBP.exec(endepDTO);
	}
	/**
	 * 更新住院信息
	 * @param ipInfoDTO 住院信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public void updateIpInfo(IpInfoDTO ipInfoDTO) throws BizException{
		UpdateIpInfoBP updateBP = new UpdateIpInfoBP();
		updateBP.exec(ipInfoDTO);
	}
	/**
	 * 换床
	 * 根据对应的床位状态及ent_id判定是换空床，还是两人交换
	 * @param source 原来床位
	 * @param target 目标床位
	 * @throws BizException
	 */
	@Override
	public void changeBed(BedBigCardDTO source,BedBigCardDTO target) throws BizException{
		ChangeBedBP chgBedBP = new ChangeBedBP();
		chgBedBP.exec(source, target);
	}
	/**
	 * 包床
	 * @param entId 就诊id
	 * @param mainBedId 主床位id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	@Override
	public void rentBed(String entId,String mainBedId,String bedId) throws BizException{
		RentBedBP rentBedBP = new RentBedBP();
		rentBedBP.exec(entId, mainBedId, bedId);
	}
	/**
	 * 取消包床
	 * @param entId 就诊id
	 * @param bedId 床位id
	 * @throws BizException
	 */
	@Override
	public void cancRentBed(String entId,String bedId) throws BizException{
		CancRentBedBP cancRentBedBP = new CancRentBedBP();
		cancRentBedBP.exec(entId, bedId);
	}
	/**
	 * 保存医护人员信息
	 * @param medPsnDTO 医护人员DTO
	 * @throws BizException
	 */
	@Override
	public PativisitensonDTO[] saveMedPsn(PativisitensonDTO medPsnDTO) throws BizException {		
		SaveEnPsnBP enpsnBP = new SaveEnPsnBP();
		return enpsnBP.exec(medPsnDTO);
	}
	/**
	 * 申请转科
	 * @param patDTO 患者信息
	 * @throws BizException 
	 */
	@Override
	public void applyTransDep(TransDepPatDTO[] patDTO) throws BizException{
		ApplyTransDepBP appTransBP = new ApplyTransDepBP();
		appTransBP.exec(patDTO);
	}
	/**
	 * 撤销转出
	 * 
	 * @param cancelDTOs
	 * @throws BizException
	 */
	@Override
	public void cancelTransOut(TransDepPatDTO[] cancelDTOs) throws BizException{
		CancelTransOutBP bp = new CancelTransOutBP();
		bp.exec(cancelDTOs);
	}
	/**
	 * 转科转入申请确认
	 * @param patDTO 申请患者
	 * @param endepDTO 入科信息
	 * @throws BizException 
	 */
	@Override
	public void cfmTransDepApp(TransDepPatDTO patDTO,EnDepDTO endepDTO) throws BizException{
		CfmTransDepAppBP cfmBP = new CfmTransDepAppBP();
		cfmBP.exec(patDTO, endepDTO);
	}
	/**
	 * 出院
	 * @param appDTO 出院申请DTO
	 * @throws BizException
	 */
	@Override
	public void leaveHos(LvHosAppDTO appDTO) throws BizException{
		LeaveHosBP leaveBP = new LeaveHosBP();
		leaveBP.exec(appDTO);
	}
	/**
	 * 召回
	 * @param recallDTOs 召回DTO数组
	 * @throws BizException
	 */
	@Override
	public void recall(HosRecallDTO recallDTO) throws BizException{
		RecallBP recallBP = new RecallBP();
		recallBP.exec(new HosRecallDTO[]{ recallDTO});
	}
	/** 
	 * 取消入科 zhangpp-2018.12.11
	 * @param dischargeDTO 
	 * @throws BizException 异常
	 */
	@Override
	public void disIpacpt(DischargeDTO dischargeDTO) throws BizException{
		DisIpacptBP bp = new DisIpacptBP();
		bp.exec(dischargeDTO);
	}
	/** 
	 * 退院
	 * @param dischargeDTO 退院申请DTO
	 * @throws BizException 异常
	 */
	@Override
	public void dischargeHos(DischargeDTO dischargeDTO) throws BizException{
		DischargeHosBP dischargeBP = new DischargeHosBP();
		dischargeBP.exec(dischargeDTO);
	}
	/** 
	 * 退院前校验
	 * @param dischargeDTO 退院申请DTO
	 * @throws BizException
	 */
	@Override
	public void validateBeforeDischarge(DischargeDTO dischargeDTO) throws BizException{
		ValidateDischargeInfoBP vb = new ValidateDischargeInfoBP();
		vb.exec(dischargeDTO);
	}
	/**
	 * 设置就诊状况
	 * @param entStateDTO 就诊状况DTO
	 * @throws BizException
	 */
	@Override
	public void setEntState(EntStateDTO entStateDTO) throws BizException{
		SetEntStateBP setBP = new SetEntStateBP();
		setBP.exec(entStateDTO);
	}
	/**
	 * 设置患者就诊状况
	 * @param entId 就诊ID
	 * @param entStateDTOs 就诊状况DTO数组
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public void setPatEntState(String entId,EntStateDTO[] entStateDTOs) throws BizException{
		SetPatEntStateBP setStateBP = new SetPatEntStateBP();
		setStateBP.exec(entId, entStateDTOs);
	}
	/**
	 * 设置患者主要就诊状况
	 * 包括：病情、护理、营养
	 * @param mainStateDTO 主要就诊状况DTO
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public void setMainEntState(MainStateDTO mainStateDTO) throws BizException{
		SetMainEntStateBP setStateBP = new SetMainEntStateBP();
		setStateBP.exec(mainStateDTO);
	}
	/**
	 * 新增新生儿记录
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Override
	public String insertNb(NewbornDTO nbDTO) throws BizException{
		InsertNbBP insertBP = new InsertNbBP();
		return insertBP.exec(nbDTO);
	}
	/**
	 * 更新新生儿记录
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Override
	public void updateNb(NewbornDTO nbDTO) throws BizException{
		UpdateNbBP updateBP = new UpdateNbBP();
		updateBP.exec(nbDTO);
	}
	/**
	 * 删除新生儿记录
	 * @param nbDO 新生儿记录DO
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public void deleteNb(NewbornDTO nbDTO) throws BizException{
		DeleteNbBP deleteBP = new DeleteNbBP();
		deleteBP.exec(nbDTO);
	}	
	/**
	 * 同步婴儿信息
	 * 1、更新婴儿就诊联系人
	 * 2、更新婴儿患者联系人
	 * @param momEntId 母亲就诊ID
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public void syncBabyInfo(String momEntId) throws BizException{
		SyncBabyInfoBP syncBP = new SyncBabyInfoBP();
		syncBP.exec(momEntId);
	}
	/**
	 * 住院医保身份修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	@Override
	public void ipRegHpInfoChg(EnHosPatDTO patDTO, EnHosRegDTO enHosReg) throws BizException {
		IpRegHpInfoChgBP bp = new IpRegHpInfoChgBP();
		bp.exec(patDTO, enHosReg);
	}
	/**
	 * 住院医保取消登记
	 * 
	 * @param codeEnt
	 * @throws BizException
	 */
	@Override
	public void ipRegHpCancel(String codeEnt) throws BizException {
		IpRegHpCancelBP bp  = new IpRegHpCancelBP();
		bp.exec(codeEnt);
	}
	/**
	 * 医保身份修改
	 * 
	 * @param ipHpRegist
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public void updateIpHpRegist(IpHpRegistDTO ipHpRegist) throws BizException {
		UpdateIpHpRegistBP bp = new UpdateIpHpRegistBP();
		bp.exec(ipHpRegist);
	}
	
	 /**
     * 保存团检单位信息
     * @param qryDTO
     * @return
     * @throws BizException
     */
    public void saveEnPeCmpyInfo(EnPeCmpyDTO qryDTO)throws BizException{
        SaveEnPeComyInfoBP bp = new SaveEnPeComyInfoBP();
        bp.exec(qryDTO);
    }   
    
    /**
     * 保存团检单位患者信息
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void saveEnPePatInfos(String pecmpyId)throws BizException{
        SaveEnPePatInfosBP bp = new SaveEnPePatInfosBP();
        bp.exec(pecmpyId);
    }
    
    /**
     * 根据团检记录id删除团检记录
     * @param qryDTO
     * @throws BizException
     */
    public void deleteEnPeCmpInfo(EnPeCmpyDTO qryDTO) throws BizException {
        DeleteEnPePatBP bp = new DeleteEnPePatBP();
        bp.exec(qryDTO);
    }
    
    /**
     * 团检出院
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void LvEnPe(String pecmpyId)throws BizException{
        LvEnPeBP bp = new LvEnPeBP();
        bp.exec(pecmpyId);
    }
    
    /**
     * 团检取消入院
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void CancelEnPeReg(String pecmpyId)throws BizException{
        CancelEnPeRegBP bp = new CancelEnPeRegBP();
        bp.exec(pecmpyId);
    }
    /**
     * 用户加关注
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
	@Override
	public void addNarkPat(String entId, String empId) throws BizException {
		AddMarkPatBP bp = new AddMarkPatBP();
		bp.exec(entId, empId);
	}
	/**
     * 用户取消关注
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
	@Override
	public void cancNarkPat(String entId, String empId) throws BizException {
		CancMarkPatBP bp = new CancMarkPatBP();
		bp.exec(entId, empId);
	}
	 /**
     * 修改入院日期
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
	@Override
    public void updateDtacpt(IpRegInfoDTO newregInfoDTO,IpRegInfoDTO oldregInfoDTO)throws BizException{
		UpdateDtacptBP bp = new UpdateDtacptBP();
		bp.exec(newregInfoDTO, oldregInfoDTO);
    }
	/**
	 * 患者授权-确认授权
	 * @throws BizException 
	 */
	@Override
	public EnAuthDO authComfirm(EnAuthDO authDO) throws BizException{
		EntAuthEP bp = new EntAuthEP();
		return bp.authComfirm(authDO);
	}
	
	/**
	 * 患者授权-取消授权
	 * @throws BizException 
	 */
	@Override
	public void cancelAuth(EnAuthDO authDO) throws BizException{
		EntAuthEP bp = new EntAuthEP();
		bp.cancelAuth(authDO);
	}
	/**
	 * 出院人数统计接口
	 * 
	 * @param nurId
	 * @param dateTime
	 * @throws BizException
	 */
	@Override
	public void callBackLvNum4Nm(String nurId, FDateTime dateTime)
			throws BizException {
		CallBackLvNum4NmBP bp = new CallBackLvNum4NmBP();
		bp.exec(nurId, dateTime);
	}
	/**
	 * 保存新生儿体重等信息
	 * @param nbDTO
	 * @throws BizException
	 */
	@Override
	public void saveNb4weight(NewbornDTO nbDTO) throws BizException {
		InsertNb4weightBP bp = new InsertNb4weightBP();
		bp.exec(nbDTO);
	}
	
	/***
     * 修改患者的责任医生为当前医生
     * @param entId
     * @param empId
     * @throws BizException
     */
	@Override
    public FBoolean updateDutyEmp(String entId, String empId) throws BizException{
		UpdateDutyEmpBP bp = new UpdateDutyEmpBP();
		return bp.exec(entId, empId);
    }
	
	/**
	 * 接收预住院
	 * @param enDepDTO
	 * @throws BizException
	 */
	public FBoolean saveAccepteEnippre(EnDepDTO enDepDTO) throws BizException{
		SaveAccepteEnippreBp bp = new SaveAccepteEnippreBp();
		return bp.exec(enDepDTO);
	}
	/**
	 * 预住院中止入院
	 * @param enIppreCancelDto
	 * @throws BizException 
	 */
	@Override
	public void ippreCancelHos(EnIppreCancelHosDTO enIppreCancelDto) throws BizException{
		new IppreCancelHosBP().exec(enIppreCancelDto);
	}
	/**
	 * 预住院转入院
	 * @param ippreTransHos
	 * @throws BizException 
	 */
	@Override
	public void ippreTransHos(EnIppreTransHosDTO ippreTransHos) throws BizException{
		new IppreTransHosBP().exec(ippreTransHos);
	}
	/**
	 * 取消预住院转入院
	 * @param ippreTransHos
	 * @throws BizException 
	 */
	@Override
	public void cancelIppreTransHos(EnIppreInfoDTO ippreTransHos) throws BizException{
		new CancelIppreTransHosBP().exec(ippreTransHos);
	}
	/**
	 * 取消中止住院
	 * @param ippreTransHos
	 * @throws BizException 
	 */
	@Override
	public void cancelIppreSuspendHos(EnIppreInfoDTO ippreTransHos) throws BizException {
		new CancelIppreSuspendHosBP().exec(ippreTransHos);
	}
    /***
     * 母婴分床、合床
     * 
     * @param id_ent
     * @param fg_sepa
     * @throws BizException
     */
	@Override
    public void updateBbSepa(BedBigCardDTO originalBedDTO,BedBigCardDTO targetBedDTO,FBoolean fg_sepa) throws BizException{
		new UpdateBbSepaBP().exec(originalBedDTO,targetBedDTO, fg_sepa);
    }
	}
