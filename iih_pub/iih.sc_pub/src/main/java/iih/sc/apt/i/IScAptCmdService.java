package iih.sc.apt.i;


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
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.pub.ResultBean;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预约命令服务接口
 * 
 * @author yank
 *
 */
public interface IScAptCmdService {
	// ===================住院====================================//
	
	/***
	 * 住院预约确认时更换床位
	 * @param bedDTO 床位信息DTO,fanlq-2018.03.20
	 * @return
	 * @throws BizException
	 */
	public void changeBedAfterIpApt(AptIpDTO ipAptDTO, BedDTO bedDTO) throws BizException;
	/**
	 * 设置床位确认信息反馈，fanlq-2018.03.14
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	public void setNoteAptIpApt(AptIpDTO aptDTO)  throws BizException;
	/***
	 * 住院预约设置备注，fanlq-2018.03.01
	 * @param aptDTO
	 * @throws BizException
	 */
	void setNoteIpApt(AptIpDTO aptDTO)  throws BizException;
	
	/**
	 * 保存住院预约
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	void submitIpApt(AptIpDTO aptDTO) throws BizException;

	/**
	 * 预约床位
	 * 
	 * @param aptDTO 住院预约DTO
	 * @param bedDTO 床位信息
	 * @throws BizException
	 */
	void aptBed(AptIpDTO aptDTO, BedDTO bedDTO) throws BizException;

	/**
	 * 自动匹配床位
	 * 
	 * @param depId 科室id，如果为null则是全院
	 * @return
	 * @throws BizException
	 */
	AptIpDTO[] autoMatchBed(String depId) throws BizException;

	/**
	 * 批量预约床位
	 * 
	 * @param aptDTOArray 住院预约DTO集合
	 * @throws BizException
	 */
	void batchAptBed(AptIpDTO[] aptDTOArray) throws BizException;

	/**
	 * 住院预约确认
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	void cfmIpApt(AptIpDTO aptDTO) throws BizException;

	/**
	 * 住院预约取消确认
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	void cancCfmIpApt(AptIpDTO aptDTO) throws BizException;

	/**
	 * 拒绝住院预约申请
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	void rejectIpApt(AptIpDTO aptDTO) throws BizException;

	/**
	 * 取消拒绝住院预约申请
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	void cancRejectIpApt(AptIpDTO aptDTO) throws BizException;

	/**
	 * 取消预约
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	void cancIpApt(AptIpDTO aptDTO,String letParam) throws BizException;

	/**
	 * 取消住院申请
	 * 
	 * @param aptDTO 住院预约DTO
	 * @throws BizException
	 */
	void cancIpApp(AptIpDTO aptDTO) throws BizException;

	// ===================门诊医技====================================//

	/**
	 * 门诊预约（门诊预约查询）
	 * 
	 * @param opAptDetailDTO 门诊预约详细信息dto
	 * @throws BizException
	 */
	void saveQryOpApt(OpAptDetailDTO opAptDetailDTO) throws BizException;

	/**
	 * 取消门诊预约
	 * 
	 * @param aptDTO 预约dto，(必输项：aptId,entId,id_tick,Sd_pttp)
	 * @throws BizException
	 */
	void cancOpApt(OpAptDTO aptDTO) throws BizException;

	/**
	 * 批量取消门诊预约
	 * 
	 * @author zhengcm
	 * 
	 * @param aptDTOs
	 * @throws BizException
	 */
	public void batchCancOpApt(OpAptDTO[] aptDTOs) throws BizException;

	/**
	 * 快捷预约
	 * 
	 * @param aptDto 预约dto
	 * @return 预约的票号
	 * @throws BizException
	 */
	Integer quickScApt(AptDto aptDto) throws BizException;

	/**
	 * 预约选号保存
	 * 
	 * @param aptDto 预约dto
	 * @return
	 * @throws BizException
	 */
	Integer saveScApt(AptDto aptDto) throws BizException;

	/**
	 * 取消医技预约修改医嘱申请单状态
	 * 
	 * @param id_or 医嘱id
	 * @throws BizException
	 */
	void cancAptMt(String id_or) throws BizException;

	/**
	 * 保存医技预约信息
	 * 
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	MtResDTO saveMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException;
	
	/**
	 * 保存医技预约信息
	 * 手动预约:选号和不选号
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	MtResDTO saveManualMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException;
	
	/**
	 * 保存医技预约信息
	 * 自动预约:单项目
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	MtResDTO saveAutoMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException;
	
	/**
	 * 医技改约
	 * @author yzh
	 * @param mtresdto
	 * @param appdto
	 * @throws BizException
	 */
	MtResDTO changeMtApt(MtResDTO mtresdto, MtAppDTO appdto) throws BizException;
	/**
	 * 取消医技预约
	 * 
	 * @param appdto
	 * @throws BizException
	 */
	void cancelMtApt(MtAppDTO appdto) throws BizException;
	
	/**
	 * 根据患者住院号或门诊号获取chis中患者申请单
	 * @param id_pat
	 * @throws BizException
	 */
	void getNeedAptObsAppl(String id_pat) throws BizException;
	/**
	 * 上传医技预约图片
	 * @param imageBytes
	 * @return
	 * @throws BizException
	 */
	String uploadImage(byte[] imageBytes) throws BizException;

	/**
         * 手工录入申请单
	 * @param applDO 申请单对象
	 * @throws BizException
	 */
	ScAptApplDO addManualAppl(ScAptApplDO applDO)throws BizException;
	
	/**
	 * 保留号位
	 * @param id_tick
	 */
	void reserveTick(String id_tick) throws BizException;
	// ===================门诊====================================//

	// ===================end 门诊 end====================================//

	/**
	 * 保存门诊预约信息
	 *
	 * @param mtResDTO
	 * @param patId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	MtResDTO saveOpApt(MtResDTO mtResDTO, String patId) throws BizException;

	// ===================口腔====================================//
	/**
	 * 口腔预约
	 * 
	 * @param patId 患者ID
	 * @param aptOpOralDO 口腔预约信息
	 * @param tickDTOs 预约号位集合
	 * @throws BizException
	 */
	AptOralDTO makeOralApt(String patId, AptOralDTO aptOpOralDO) throws BizException;

	/**
	 * 取消口腔预约
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @param msgType 短信类型
	 * @throws BizException
	 */
	void cancOralApt(String aptId, FBoolean isCheckChl, int msgType) throws BizException;

	/**
	 * 爽约
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @throws BizException
	 */
	void breakOralApt(String aptId, FBoolean isCheckChl) throws BizException;

	/**
	 * 保存口腔科预约患者信息
	 *
	 * @param aptPatDTO 口腔预约患者信息DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	AptPatDTO saveOralAptPatInfo(AptPatDTO aptPatDTO) throws BizException;

	/**
	 * 口腔科预约占用
	 *
	 * @param id_tick_arr 排班号位id数组
	 * @param sd_reserve_rsn 占用原因
	 * @param note_reserve 备注
	 * @throws BizException
	 * @author zhengcm
	 */
	void reserveOralApt(String[] id_tick_arr, String sd_reserve_rsn, String note_reserve) throws BizException;

	/**
	 * 设置口腔科预约状态
	 *
	 * @param id_apt 预约id
	 * @param sd_statustag 状态编码
	 * @throws BizException
	 * @author zhengcm
	 */
	void setOralAptStatusTag(String id_apt, String sd_statustag) throws BizException;

	/**
	 * 取消口腔预约(口腔预约查询)
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @param msgType 短信类型
	 * @throws BizException
	 */
	OralAptMgrDTO cancOralAptMgr(String aptId, FBoolean isCheckChl, int msgType) throws BizException;

	/**
	 * 爽约(口腔预约查询)
	 * 
	 * @param aptId 预约id
	 * @param isCheckChl 是否检查渠道
	 * @throws BizException
	 */
	OralAptMgrDTO breakOralAptMgr(String aptId, FBoolean isCheckChl) throws BizException;

	/**
	 * 设置口腔科预约状态(口腔预约查询)
	 *
	 * @param id_apt 预约id
	 * @param sd_statustag 状态编码
	 * @throws BizException
	 * @author zhengcm
	 */
	OralAptMgrDTO setOralAptMgrStatusTag(String id_apt, String sd_statustag) throws BizException;

	/**
	 * 口腔预约更改患者
	 * 
	 * @param oralAptDTO 口腔预约DTO
	 * @param newPatId 新患者ID
	 * @return 口腔预约DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	AptOralDTO changeOralAptPat(AptOralDTO oralAptDTO, String newPatId) throws BizException;

	/**
	 * 向一组手机号发送短信
	 * 
	 * @param mobiles 一个或者多个手机号，用逗号分开
	 * @param msgCode 消息编码
	 * @param msg 消息内容
	 * @throws BizException
	 * @author yank
	 */
	ResultBean sendSmsMsg(String mobiles, String msgCode, String msg) throws BizException;

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
	MtResDTO saveOptApt(MtResDTO resDTO, MtAppDTO appDTO) throws BizException;

	/**
	 * 取消手术预约
	 * 
	 * @author zhengcm
	 *
	 * @param appDTO
	 * @throws BizException
	 */
	void cancOptApt(MtAppDTO appDTO) throws BizException;
	
	/**
	 * 取消手术预约--不保留号位
	 * 
	 * @author zhengcm
	 *
	 * @param appDTO
	 * @throws BizException
	 */
	void cancOptAptNotKeepNo(MtAppDTO appDTO) throws BizException;
	
	
	/**
	 * 保存手术人员信息
	 * @param dtos
	 * @param id_apt
	 * @throws BizException
	 */
	void saveEmpl(ScAptOptEmpDO[] dtos,MtAppDTO mtAppDTO)throws BizException;
	
	/**
	 * 修改手术计划时间
	 * @param dtos
	 * @param id_apt
	 * @throws BizException
	 */
	String saveApplTime(MtAppDTO mtAppDTO,String type)throws BizException;
	
	/**
	 * 手术预约   改约
	 * @param resDTO
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	MtResDTO changeOpApt(MtResDTO resDTO, MtAppDTO appDTO)throws BizException;
	
	/**
	 * 手术预约   手工增加申请单
	 * @param otAppDTO
	 */
	void saveAddAptAppl(OtAppDTO otAppDTO)  throws BizException;
	
	/**
	 * 科室手术确认/取消确认操作
	 * @param appls
	 * @param oper confirm:确认操作|canc:取消确认操作
	 * @throws BizException
	 */
	void optAptConfirmOper(ScAptApplOptDO[] appls, String oper) throws BizException;
}
