package iih.sc.apt.s;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import com.thoughtworks.xstream.core.util.FastField;

import cn.xapss.connector.bucket.FastFileID;
import cn.xapss.fastdfs.FastDfsCRUDer;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.bed.d.BedDTO;
import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.dto.d.AptDto;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.dto.d.AptPatDTO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.dto.d.OpAptDetailDTO;
import iih.sc.apt.dto.d.OralAptMgrDTO;
import iih.sc.apt.dto.d.OtAppDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.s.bp.AddManualApplBP;
import iih.sc.apt.s.bp.CancOptAptNotKeepNoBP;
import iih.sc.apt.s.bp.ChangeOpAptBP;
import iih.sc.apt.s.bp.GetNeedAptObsApplBP;
import iih.sc.apt.s.bp.OptAptConfirmOperBP;
import iih.sc.apt.s.bp.ReserveTickBP;
import iih.sc.apt.s.bp.SaveAddAptApplBP;
import iih.sc.apt.s.bp.SaveApplTimeBP;
import iih.sc.apt.s.bp.SaveEmplBP;
import iih.sc.apt.s.bp.SaveOpAptBPInfo;
import iih.sc.apt.s.bp.SaveSelectAptBp;
import iih.sc.apt.s.bp.UpdateSdSuObsBp;
import iih.sc.apt.s.bp.UploadImageBP;
import iih.sc.apt.s.bp.ip.AptBedBP;
import iih.sc.apt.s.bp.ip.AutoMatchBedBP;
import iih.sc.apt.s.bp.ip.BatchAptBedBP;
import iih.sc.apt.s.bp.ip.CancCfmOrRejectIpAptBP;
import iih.sc.apt.s.bp.ip.CancIpAppBP;
import iih.sc.apt.s.bp.ip.CancIpAptBP;
import iih.sc.apt.s.bp.ip.CfmOrRejectIpAptBP;
import iih.sc.apt.s.bp.ip.ChangeBedAfterIpAptBP;
import iih.sc.apt.s.bp.ip.SetNoteIpAptBP;
import iih.sc.apt.s.bp.ip.SubmitIpAptBP;
import iih.sc.apt.s.bp.mt.CancMtAptBP;
import iih.sc.apt.s.bp.mt.SaveMtAptBP;
import iih.sc.apt.s.bp.mt.apt.ChangeManualMtAptBP;
import iih.sc.apt.s.bp.mt.apt.SaveAutoMtAptBP;
import iih.sc.apt.s.bp.mt.apt.SaveManualMtAptBP;
import iih.sc.apt.s.bp.op.BatchCancAptOpBP;
import iih.sc.apt.s.bp.op.CancAptOpBP;
import iih.sc.apt.s.bp.op.SaveOpAptBP;
import iih.sc.apt.s.bp.oral.BreakOralAptBP;
import iih.sc.apt.s.bp.oral.CancOralAptBP;
import iih.sc.apt.s.bp.oral.ChangeOralAptPatBP;
import iih.sc.apt.s.bp.oral.GetOralAptListBP;
import iih.sc.apt.s.bp.oral.MakeOralAptBP;
import iih.sc.apt.s.bp.oral.ReserveOralAptBP;
import iih.sc.apt.s.bp.oral.SaveOralAptPatInfoBP;
import iih.sc.apt.s.bp.oral.SetOralAptStatusTagBP;
import iih.sc.apt.s.listener.bp.SendSmsMsgBP;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.pub.ResultBean;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预约命令服务接口
 * 
 * @author yank
 *
 */
@Service(serviceInterfaces = { IScAptCmdService.class }, binding = Binding.JSONRPC)
public class ScAptCmdServiceImpl implements IScAptCmdService {
	// ===================住院====================================//
	
	/***
	 * 住院预约确认时更换床位
	 * @param bedDTO 床位信息DTO,fanlq-2018.03.20
	 * @return
	 * @throws BizException
	 */
	@Override
	public void changeBedAfterIpApt(AptIpDTO ipAptDTO, BedDTO bedDTO) throws BizException{
		ChangeBedAfterIpAptBP bp = new ChangeBedAfterIpAptBP();
		bp.exec(ipAptDTO,bedDTO);
	}
	
	/**
	 * 设置床位确认信息反馈,fanlq-2018.03.14
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void setNoteAptIpApt(AptIpDTO aptDTO)  throws BizException{
		SetNoteIpAptBP bp = new SetNoteIpAptBP();
		bp.exec(aptDTO);
	}
	
	/***
	 * 住院预约设置备注，fanlq-2018.03.01
	 * @param aptDTO
	 * @throws BizException
	 */
	@Override
	public void setNoteIpApt(AptIpDTO aptDTO)  throws BizException{
		SetNoteIpAptBP bp = new SetNoteIpAptBP();
		bp.exec(aptDTO);
	}
	
	/**
	 * 提交住院预约
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void submitIpApt(AptIpDTO aptDTO) throws BizException {
		SubmitIpAptBP submitBP = new SubmitIpAptBP();
		submitBP.exec(aptDTO);
	}

	/**
	 * 预约床位
	 * 
	 * @param aptDTO 住院预约DTO
	 * @param bedAggDO 床位信息
	 * @throws BizException
	 */
	@Override
	public void aptBed(AptIpDTO aptDTO, BedDTO bedDTO) throws BizException {
		AptBedBP aptBP = new AptBedBP();
		aptBP.exec(aptDTO, bedDTO);
	}

	/**
	 * 自动匹配床位
	 * 
	 * @param depId 科室id，如果为null则是全院
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptIpDTO[] autoMatchBed(String depId) throws BizException {
		AutoMatchBedBP autoMatchBP = new AutoMatchBedBP();
		return autoMatchBP.exec(depId);
	}

	/**
	 * 批量预约床位
	 * 
	 * @param aptDTOArray 住院预约DTO集合
	 * @throws BizException
	 */
	@Override
	public void batchAptBed(AptIpDTO[] aptDTOArray) throws BizException {
		BatchAptBedBP batchAptBP = new BatchAptBedBP();
		batchAptBP.exec(aptDTOArray);
	}

	/**
	 * 住院预约确认
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void cfmIpApt(AptIpDTO aptDTO) throws BizException {
		CfmOrRejectIpAptBP aptBP = new CfmOrRejectIpAptBP();
		aptBP.exec(aptDTO);
	}

	/**
	 * 住院预约取消确认
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void cancCfmIpApt(AptIpDTO aptDTO) throws BizException {
		CancCfmOrRejectIpAptBP cancCfmBP = new CancCfmOrRejectIpAptBP();
		cancCfmBP.exec(aptDTO);
	}

	/**
	 * 拒绝住院预约申请
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void rejectIpApt(AptIpDTO aptDTO) throws BizException {
		CfmOrRejectIpAptBP aptBP = new CfmOrRejectIpAptBP();
		aptBP.exec(aptDTO);
	}

	/**
	 * 取消拒绝住院预约申请
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void cancRejectIpApt(AptIpDTO aptDTO) throws BizException {
		CancCfmOrRejectIpAptBP cancCfmBP = new CancCfmOrRejectIpAptBP();
		cancCfmBP.exec(aptDTO);
	}

	/**
	 * 取消预约
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void cancIpApt(AptIpDTO aptDTO,String letParam) throws BizException {
		CancIpAptBP cancAptBP = new CancIpAptBP();
		cancAptBP.exec(aptDTO,letParam);
	}

	/**
	 * 取消住院申请
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	@Override
	public void cancIpApp(AptIpDTO aptDTO) throws BizException {
		CancIpAppBP cancBP = new CancIpAppBP();
		cancBP.exec(aptDTO);
	}

	// ===================门诊医技====================================//

	/**
	 * 快捷预约
	 * 
	 * @param aptDto 预约dto
	 * @return 预约的票号
	 * @throws BizException
	 */
	@Override
	public Integer quickScApt(AptDto aptDto) throws BizException {
		//SaveQuickAptBp aptOpBp = new SaveQuickAptBp();
		//return aptOpBp.exec(aptDto);
		return null;
	}

	/**
	 * 选号预约
	 * 
	 * @param aptDto 预约dto
	 * @return 预约的票号
	 * @throws BizException
	 */
	@Override
	public Integer saveScApt(AptDto aptDto) throws BizException {
		SaveSelectAptBp aptOpBp = new SaveSelectAptBp();
		return aptOpBp.exec(aptDto);
	}

	/**
	 * 取消医技预约修改医嘱申请单状态
	 * 
	 * @param id_or 医嘱id
	 * @throws BizException
	 */
	@Override
	public void cancAptMt(String id_or) throws BizException {
		UpdateSdSuObsBp sdSuObsBp = new UpdateSdSuObsBp();
		sdSuObsBp.exec(id_or, FBoolean.FALSE);
	}

	/**
	 * 保存医技预约信息
	 * 
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public MtResDTO saveMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException {
		SaveMtAptBP saveMtAptBp = new SaveMtAptBP();
		return saveMtAptBp.exec(mtresdto, appdto, IScDictCodeConst.SD_SCTP_MT);
	}
	/**
	 * 保存医技预约信息
	 * 手动预约:选号和不选号
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public MtResDTO saveManualMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException {
		SaveManualMtAptBP saveMtAptBp = new SaveManualMtAptBP();
		return saveMtAptBp.exec(mtresdto, appdto, IScDictCodeConst.SD_SCTP_MT);
	}
	/**
	 * 保存医技预约信息
	 * 自动预约:单项目
	 * @author yzh
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public MtResDTO saveAutoMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException {
		SaveAutoMtAptBP saveAutoMtAptBp = new SaveAutoMtAptBP();
		return saveAutoMtAptBp.exec(mtresdto, appdto, IScDictCodeConst.SD_SCTP_MT);
	}
	/**
	 * 医技改约
	 * @author yzh
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public MtResDTO changeMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException {
		ChangeManualMtAptBP changeManualMtAptBp = new ChangeManualMtAptBP();
		return changeManualMtAptBp.exec(mtresdto, appdto, IScDictCodeConst.SD_SCTP_MT);
	}
	/**
	 * 取消医技预约
	 * 
	 * @param appdto
	 * @throws BizException
	 */
	@Override
	public void cancelMtApt(MtAppDTO appdto) throws BizException {
		new CancMtAptBP().exec(appdto, IScDictCodeConst.SD_SCTP_MT);
	}
	
	/**
	 * 根据患者住院号或门诊号获取chis中患者申请单
	 * @param id_pat
	 * @throws BizException
	 */
	@Override
	public void getNeedAptObsAppl(String id_pat) throws BizException {
		new GetNeedAptObsApplBP().exec(id_pat);
	}
	/**
	 * 上传医技预约图片
	 * @param imageBytes
	 * @return
	 * @throws BizException
	 */
	@Override
	public String uploadImage(byte[] imageBytes) throws BizException{
		return new UploadImageBP().exec(imageBytes);
	}
	/**
         *手工录入申请单
	 * @param applDO 申请单
	 * @throws BizException
	 */
	@Override
	public ScAptApplDO addManualAppl(ScAptApplDO applDO)throws BizException{
		
		return new AddManualApplBP().exec(applDO);
	}
	
	/**
	 * 保留号位
	 * @param id_tick
	 * @throws BizException 
	 */
	@Override
	public void reserveTick(String id_tick) throws BizException {
		new ReserveTickBP().exec(id_tick);
	}
	
	// ===================end 医技 end====================================//

	// ===================门诊====================================//

	/**
	 * 门诊预约（门诊预约查询）
	 * 
	 * @param opAptDetailDTO 门诊预约详细信息dto
	 * @throws BizException
	 */
	@Override
	public void saveQryOpApt(OpAptDetailDTO opAptDetailDTO) throws BizException {
		SaveOpAptBPInfo saveOpAptBP = new SaveOpAptBPInfo();
		saveOpAptBP.exec(opAptDetailDTO);
	}

	/**
	 * 取消门诊预约
	 * 
	 * @param aptDTO 预约dto，(必输项：aptId,entId,id_tick,Sd_pttp)
	 * @throws BizException
	 */
	@Override
	public void cancOpApt(OpAptDTO aptDTO) throws BizException {
		CancAptOpBP cancBP = new CancAptOpBP();
		cancBP.exec(aptDTO);
	}

	/**
	 * 批量取消门诊预约
	 *
	 * @author zhengcm
	 * 
	 * @param aptDTOs
	 * @throws BizException
	 */
	@Override
	public void batchCancOpApt(OpAptDTO[] aptDTOs) throws BizException {
		new BatchCancAptOpBP().exec(aptDTOs);
	}

	/**
	 * 保存门诊预约信息(预约)
	 * 
	 * @param mtResDTO
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtResDTO saveOpApt(MtResDTO mtResDTO, String patId) throws BizException {
		SaveOpAptBP saveOpAptBp = new SaveOpAptBP();
		return saveOpAptBp.exec(mtResDTO, patId, IScDictCodeConst.SC_APT_OPERATE);
	}

	// ===================end 门诊 end====================================//

	/**
	 * 口腔预约
	 * 
	 * @param patId 患者ID
	 * @param aptOpOralDO 口腔预约信息
	 * @param tickDTOs 预约号位集合
	 * @throws BizException
	 */
	@Override
	public AptOralDTO makeOralApt(String patId, AptOralDTO aptOpOralDO) throws BizException {
		return new MakeOralAptBP().exec(patId, aptOpOralDO);
	}

	/**
	 * 取消口腔预约
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @param msgType 短信类型
	 * @throws BizException
	 */
	@Override
	public void cancOralApt(String aptId, FBoolean isCheckChl, int msgType) throws BizException {
		new CancOralAptBP().exec(aptId, isCheckChl, msgType);
	}

	/**
	 * 爽约
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @throws BizException
	 */
	@Override
	public void breakOralApt(String aptId, FBoolean isCheckChl) throws BizException {
		new BreakOralAptBP().exec(aptId, isCheckChl);
	}

	/**
	 * 保存口腔科预约患者信息
	 *
	 * @param aptPatDTO 口腔预约患者信息DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public AptPatDTO saveOralAptPatInfo(AptPatDTO aptPatDTO) throws BizException {
		return new SaveOralAptPatInfoBP().exec(aptPatDTO);
	}

	/**
	 * 口腔科预约占用
	 *
	 * @param id_tick_arr 排班号位id数组
	 * @param sd_reserve_rsn 占用原因
	 * @param note_reserve 备注
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public void reserveOralApt(String[] id_tick_arr, String sd_reserve_rsn, String note_reserve) throws BizException {
		new ReserveOralAptBP().exec(id_tick_arr, sd_reserve_rsn, note_reserve);
	}

	/**
	 * 设置口腔科预约状态
	 *
	 * @param id_apt 预约id
	 * @param sd_statustag 状态编码
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public void setOralAptStatusTag(String id_apt, String sd_statustag) throws BizException {
		new SetOralAptStatusTagBP().exec(id_apt, sd_statustag);
	}

	/**
	 * 取消口腔预约(口腔预约查询)
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @param msgType 短信类型
	 * @throws BizException
	 */
	@Override
	public OralAptMgrDTO cancOralAptMgr(String aptId, FBoolean isCheckChl, int msgType) throws BizException {
		new CancOralAptBP().exec(aptId, isCheckChl, msgType);
		return new GetOralAptListBP().exec(aptId);
	}

	/**
	 * 爽约(口腔预约查询)
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @throws BizException
	 */
	@Override
	public OralAptMgrDTO breakOralAptMgr(String aptId, FBoolean isCheckChl) throws BizException {
		new BreakOralAptBP().exec(aptId, isCheckChl);
		return new GetOralAptListBP().exec(aptId);
	}

	/**
	 * 设置口腔科预约状态(口腔预约查询)
	 *
	 * @param id_apt 预约id
	 * @param sd_statustag 状态编码
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public OralAptMgrDTO setOralAptMgrStatusTag(String id_apt, String sd_statustag) throws BizException {
		new SetOralAptStatusTagBP().exec(id_apt, sd_statustag);
		return new GetOralAptListBP().exec(id_apt);
	}

	/**
	 * 口腔预约更改患者
	 * 
	 * @param oralAptDTO 口腔预约DTO
	 * @param newPatId 新患者ID
	 * @return 口腔预约DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public AptOralDTO changeOralAptPat(AptOralDTO oralAptDTO, String newPatId) throws BizException {
		ChangeOralAptPatBP changePatBP = new ChangeOralAptPatBP();
		return changePatBP.exec(oralAptDTO, newPatId);
	}

	/**
	 * 向一组手机号发送短信
	 * 
	 * @param mobiles 一个或者多个手机号，用逗号分开
	 * @param msgCode 消息编码
	 * @param msg 消息内容
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public ResultBean sendSmsMsg(String mobiles, String msgCode, String msg) throws BizException {
		SendSmsMsgBP sendBP = new SendSmsMsgBP();
		return sendBP.exec(mobiles, msgCode, msg);
	}

	/**
	 * 手术预约保存
	 * 
	 * @author zhengcm
	 *
	 * @param resDTO
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtResDTO saveOptApt(MtResDTO resDTO, MtAppDTO appDTO) throws BizException {
		return new SaveMtAptBP().exec(resDTO, appDTO, IScDictCodeConst.SD_SCTP_OT);
	}

	/**
	 * 取消手术预约
	 * 
	 * @author zhengcm
	 * @param appDTO
	 * @throws BizException
	 */
	@Override
	public void cancOptApt(MtAppDTO appDTO) throws BizException {
		new CancMtAptBP().exec(appDTO, IScDictCodeConst.SD_SCTP_OT);
	}
	
	/**
	 * 取消手术预约--不保留号
	 * 
	 * @author zhengcm
	 * @param appDTO
	 * @throws BizException
	 */
	@Override
	public void cancOptAptNotKeepNo(MtAppDTO appDTO) throws BizException {
		new CancOptAptNotKeepNoBP().exec(appDTO);
	}

	/**
	 * 保存手术人员信息
	 * @param dtos
	 * @param id_apt
	 * @throws BizException
	 */
	@Override
	public void saveEmpl(ScAptOptEmpDO[] dtos,  MtAppDTO mtAppDTO) throws BizException {
		new SaveEmplBP().exec(dtos,mtAppDTO);
	}

	/**
	 * 修改手术计划时间
	 * @param dtos
	 * @param id_apt
	 * @throws BizException
	 */
	@Override
	public String saveApplTime(MtAppDTO mtAppDTO,String type) throws BizException {
		return new SaveApplTimeBP().exec(mtAppDTO,type);
	}

	/**
	 * 手术预约   改约
	 */
	@Override
	public MtResDTO changeOpApt(MtResDTO resDTO, MtAppDTO appDTO) throws BizException {
		return new ChangeOpAptBP().exec(resDTO, appDTO);
	}

	/**
	 * 手术预约   手工增加申请单
	 * @param otAppDTO
	 * @throws BizException 
	 */
	@Override
	public void saveAddAptAppl(OtAppDTO otAppDTO) throws BizException {
		new SaveAddAptApplBP().exec(otAppDTO);
	}

	/**
	 * 科室手术确认/取消确认操作
	 * @param appls
	 * @param oper confirm:确认操作|canc:取消确认操作
	 * @throws BizException
	 */
	@Override
	public void optAptConfirmOper(ScAptApplOptDO[] appls, String oper) throws BizException {
			new OptAptConfirmOperBP().exec(appls, oper);
	}
}
