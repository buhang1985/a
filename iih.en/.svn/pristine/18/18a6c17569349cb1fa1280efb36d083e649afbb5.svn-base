package iih.en.que.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.en.comm.IEnConst;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.i.IEnOpQryService;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.i.IScAptOpDOCudService;
import iih.sc.apt.scapt.i.IScAptOpDORService;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 未挂号分诊模式预约取号
 * 
 * @author liubin
 *
 */
public class NoRegTriageTakeNoBP {
	/**
	 * 未挂号分诊模式预约取号
	 * 
	 * @param patId
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	public OpRegDTO exec(String patId, String aptId) throws BizException {
		//获取患者信息
		PatDO pat = getPatInfo(patId);
		//获取预约信息
		OpAptDTO aptDto = aptInfoHanle(pat, aptId);
		//生成就诊记录
		String entId = aptCreatEnt(pat, aptDto);
		//修改预约数据
		updateApt(aptId, entId);
		//查询就诊数据
		return getRegDTO(entId);
	}
	/**
	 * 患者信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatInfo(String patId) throws BizException {
		PatEP  patEp = new PatEP();
		return patEp.getPatById(patId);
	}
	/**
	 * 
	 * 
	 * @param pat
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	private OpAptDTO aptInfoHanle(PatDO pat, String aptId) throws BizException {
		//获取预约信息
		IScAptOutQryService aptServ = ServiceFinder.find(IScAptOutQryService.class);
		OpAptDTO aptDto = aptServ.getOpApt(aptId);
		//验证预约信息
		this.validateAptDO(aptDto);
		if(!(EnParamUtils.getAcptPatca().equals(IEnConst.ENOP0017_PAT) &&  !EnParamUtils.isSaveHPAtAcpt())){
			//设置医保信息
			this.setHpInfo(pat, aptDto);
		}
		aptDto.setEu_regtp(EuRegTp.NOREGTRIAGE);
		return aptDto;
	}
	/**
	 * 生成就诊记录
	 * 
	 * @param pat
	 * @param aptDto
	 * @return
	 * @throws BizException
	 */
	private String aptCreatEnt(PatDO pat, OpAptDTO aptDto) throws BizException{
		IEnOutCmdService ent4AptService = ServiceFinder.find(IEnOutCmdService.class);
		return ent4AptService.aptCreateEnt(pat, aptDto, FBoolean.TRUE);
	}
	/**
	 * 修改预约状态
	 * 
	 * @param aptId
	 * @param entId
	 * @throws BizException
	 */
	private void updateApt(String aptId, String entId) throws BizException{
		//修改sc_apt
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO scAptDO = aptRService.findById(aptId);// 获取预约数据
		scAptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_FINISH);
		scAptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH);// 状态改为完成
		scAptDO.setStatus(DOStatus.UPDATED);
		IScaptMDOCudService aptCudService = ServiceFinder.find(IScaptMDOCudService.class);
		aptCudService.save(new ScAptDO[]{scAptDO});
		
		//修改sc_apt_op
		IScAptOpDORService aptOpRService = ServiceFinder.find(IScAptOpDORService.class);
		ScAptOpDO[] aptOpDOs = aptOpRService.findByAttrValString(ScAptOpDO.ID_APT, aptId);
		aptOpDOs[0].setId_en(entId);// 就诊id
		aptOpDOs[0].setDt_en(EnAppUtils.getServerDateTime());// 就诊时间
		aptOpDOs[0].setFg_en(FBoolean.TRUE);// 就诊标识
		aptOpDOs[0].setStatus(DOStatus.UPDATED);
		IScAptOpDOCudService aptOpCudService = ServiceFinder.find(IScAptOpDOCudService.class);
		aptOpCudService.save(new ScAptOpDO[] { aptOpDOs[0] });
	}
	
	/**
	 * 设置挂号医保计划
	 * 
	 * @param regInfo
	 * @param pat
	 * @throws BizException 
	 */
	private void setHpInfo(PatDO pat, OpAptDTO aptDto) throws BizException{
		//获取pi_pat_ca_hp
		IPatcatehpRService patcatehpRServ = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO[] piPatCaHps =  patcatehpRServ.findByAttrValString(PiPatCaHpDO.ID_PATCA, pat.getId_paticate());
		if(EnValidator.isEmpty(piPatCaHps))
			return;
		PiPatCaHpDO piPatCaHp = piPatCaHps[0];
		if(EnValidator.isEmpty(piPatCaHp.getId_hp()))
			return;
		IPiPatHpDORService piPatHpDORServ = ServiceFinder.find(IPiPatHpDORService.class);
		String whereStr = String.format("%s.id_pat = '%s' and %s.id_hp = '%s' and %s.fg_act = '%s'", 
				PiPatHpDODesc.TABLE_ALIAS_NAME, pat.getId_pat(),
				PiPatHpDODesc.TABLE_ALIAS_NAME, piPatCaHp.getId_hp(),
				PiPatHpDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		PiPatHpDO[] piPatHps = piPatHpDORServ.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(piPatHps))
			throw new BizException(String.format("患者分类为%s，患者未注册正确的医保计划[%s]！", pat.getPaticate_name(), piPatCaHp.getName_hp()));
		HPDO hpDO = this.getHpDO(piPatCaHp.getId_hp());
		if(hpDO == null)
			throw new BizException(String.format("患者分类为%s，查询医保计划[%s]信息失败！", pat.getPaticate_name(), piPatCaHp.getName_hp()));
		if(FBoolean.TRUE.equals(hpDO.getFg_reqhpcode()) && EnValidator.isEmpty(piPatHps[0].getNo_hp()))
			throw new BizException(String.format("患者分类为%s，医保计划[%s]医保号不能为空，请到患者注册维护后重试！", pat.getPaticate_name(), piPatCaHp.getName_hp()));
		aptDto.setFg_hp_card(piPatCaHp.getFg_hp_card());
		aptDto.setFg_settlebycard(piPatCaHp.getFg_hp_card());
		aptDto.setFg_hpsettle(piPatCaHp.getFg_fundpay());
		aptDto.setId_hp(piPatCaHp.getId_hp());
		aptDto.setNo_hp(piPatHps[0].getNo_hp());
		aptDto.setName_hp(piPatCaHp.getName_hp());
		aptDto.setId_hpkind(piPatCaHp.getId_hpkind());
		aptDto.setCode_hpkind(piPatCaHp.getCode_hpkind());
	}
	/**
	 * 获取医保计划
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private HPDO getHpDO(String hpId) throws BizException {
		if (EnValidator.isEmpty(hpId))
			return null;
		HPDO hpDO = (HPDO) new DAFacade()
				.findByPK(HPDO.class, hpId, new String[] { HPDO.ID_HP,
						HPDO.NAME, HPDO.FG_REQHPCODE });
		return hpDO;
	}
	/**
	 * 验证预约信息
	 * 
	 * @param aptDTO
	 * @throws BizException
	 */
	private void validateAptDO(OpAptDTO aptDO) throws BizException {
		if (aptDO == null) {
			throw new BizException("获取患者预约信息失败！");
		}
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(aptDO.getSd_status())) {
			throw new BizException("该预约已经取号，不能重复取号！");
		}
		if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(aptDO.getSd_status())) {
			throw new BizException("该预约已经取消，不能取号!");
		}
	}
	/**
	 * 
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO getRegDTO(String entId) throws BizException {
		IEnOpQryService serv = ServiceFinder.find(IEnOpQryService.class);
		return serv.getRegByEntId(entId);
	}
}
