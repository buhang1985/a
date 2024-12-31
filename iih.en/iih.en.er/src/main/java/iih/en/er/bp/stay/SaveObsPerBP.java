package iih.en.er.bp.stay;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnObsPermitDTO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiAddrDOCudService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存留观许可
 * 
 * @author liubin
 *
 */
public class SaveObsPerBP {
	/**
	 * 保存留观许可
	 * 
	 * @param enObsPermitDto
	 * @return
	 * @throws BizException
	 */
	public EnObsPermitDTO exec(EnObsPermitDTO enObsPermitDto) throws BizException {
		//1.保存患者现住址
		saveNowAddr(enObsPermitDto);
		//2.保存患者联系人
		PiPatContDO patCont = savePatCont(enObsPermitDto);
		//3.保存留观申请单信息
		saveAptIp(enObsPermitDto, patCont);
		//4.重新查询数据并返
		return new GetObsPerInfoBP().exec(enObsPermitDto.getId_ent());
	}
	/**
	 * 保存患者现住址
	 * 
	 * @param enObsPermitDto
	 * @throws BizException
	 */
	private void saveNowAddr(EnObsPermitDTO enObsPermitDto) throws BizException {
		PatiAddrDO addr = new PiPatEP().getNowPatAddr(enObsPermitDto.getId_pat());
		if(EnValidator.isEmpty(enObsPermitDto.getId_addr_now())){
			if(addr == null)
				return;
			addr.setStatus(DOStatus.DELETED);
		}else{
			if(addr == null){
				addr = new PatiAddrDO();
				addr.setStatus(DOStatus.NEW);
				addr.setId_pat(enObsPermitDto.getId_pat());
				addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
				addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			}else{
				addr.setStatus(DOStatus.UPDATED);
			}
			addr.setId_admdiv(enObsPermitDto.getId_addr_now());
			addr.setSd_admdiv(enObsPermitDto.getCode_addr_now());
			addr.setStreet(enObsPermitDto.getStreet_addr_now());
		}
		IPatiAddrDOCudService serv = ServiceFinder.find(IPatiAddrDOCudService.class);
		serv.save(new PatiAddrDO[]{addr});
	}
	/**
	 * 保存患者联系人
	 * 
	 * @param enObsPermitDto
	 * @return
	 * @throws BizException
	 */
	private PiPatContDO savePatCont(EnObsPermitDTO enObsPermitDto) throws BizException {
		if(EnValidator.isEmpty(enObsPermitDto.getName_patcont()))
			return null;
		PatEP patEP = new PatEP();
		PiPatContDO patCont = null;
		if(!EnValidator.isEmpty(enObsPermitDto.getId_patcont())){
			patCont = patEP.getPatContById(enObsPermitDto.getId_patcont());
		}
		if(patCont == null){
			patCont = new PiPatContDO();
			patCont.setStatus(DOStatus.NEW);
			patCont.setId_pat(enObsPermitDto.getId_pat());
		}else{
			patCont.setStatus(DOStatus.UPDATED);
		}
		patCont.setId_conttp(enObsPermitDto.getId_conttp());
		patCont.setSd_conttp(enObsPermitDto.getSd_conttp());
		patCont.setName(enObsPermitDto.getName_patcont());
		patCont.setContaddr(enObsPermitDto.getContaddr());
		patCont.setConttel(enObsPermitDto.getConttel());
		return patEP.savePatCont(patCont);
	}
	/**
	 * 保存申请单
	 * 
	 * @param enObsPermitDto
	 * @param patCont
	 * @return
	 * @throws BizException
	 */
	private AptIpDO saveAptIp(EnObsPermitDTO enObsPermitDto, PiPatContDO patCont) throws BizException {
		AptIpDO aptIpDo = null;
		if(EnValidator.isEmpty(enObsPermitDto.getId_aptip())){
			FDateTime now = EnAppUtils.getServerDateTime();
			aptIpDo = new AptIpDO();
			aptIpDo.setStatus(DOStatus.NEW);
			aptIpDo.setId_ent(enObsPermitDto.getId_ent());
			aptIpDo.setId_pat(enObsPermitDto.getId_pat());
			aptIpDo.setId_dep_op(enObsPermitDto.getId_dep_op());
			aptIpDo.setName_dep_op(enObsPermitDto.getName_dep_op());
			aptIpDo.setFg_plan(FBoolean.TRUE);
			aptIpDo.setFg_emgstay(FBoolean.TRUE);
			aptIpDo.setFg_manual(FBoolean.FALSE);
			aptIpDo.setSd_status(IScDictCodeConst.SD_APTIP_STATUS_APPLY);
			aptIpDo.setDt_insert(now);
			aptIpDo.setId_grp(EnContextUtils.getGrpId());
			aptIpDo.setId_org(EnContextUtils.getOrgId());
			aptIpDo.setId_emp_notice(EnContextUtils.getPsnDoc().getId_psndoc());
			aptIpDo.setName_emp_notice(EnContextUtils.getPsnDoc().getName());
			aptIpDo.setDa_notice(now);
		}else{
			IAptipMDORService serv=ServiceFinder.find(IAptipMDORService.class);
			aptIpDo = serv.findById(enObsPermitDto.getId_aptip());
			aptIpDo.setStatus(DOStatus.UPDATED);
		}
		aptIpDo.setName_pat(enObsPermitDto.getName_pat());
		aptIpDo.setId_patca(enObsPermitDto.getId_patca());
		aptIpDo.setId_sex_pat(enObsPermitDto.getSd_sex());
		aptIpDo.setSd_sex_pat(enObsPermitDto.getSd_sex());
		aptIpDo.setDt_brith_pat(enObsPermitDto.getDt_birth());
		aptIpDo.setId_emp_phy_op(EnContextUtils.getPsnDoc().getId_psndoc());
		aptIpDo.setName_emp_phy_op(EnContextUtils.getPsnDoc().getName());
		aptIpDo.setId_didef_op(enObsPermitDto.getId_didef_op());
		aptIpDo.setId_didef_op(enObsPermitDto.getId_didef_op());
		aptIpDo.setName_didef_op(enObsPermitDto.getName_didef_op());
		aptIpDo.setSupplement_di(enObsPermitDto.getSupplement_di());
		aptIpDo.setId_level_dise(enObsPermitDto.getId_level_dise());
		aptIpDo.setSd_level_dise(enObsPermitDto.getSd_level_dise());
		aptIpDo.setId_dep_phy_ip(enObsPermitDto.getId_dep_phy_ip());
		aptIpDo.setId_dep_nur_ip(enObsPermitDto.getId_dep_nur_ip());
		aptIpDo.setDt_admit_plan(new FDateTime(enObsPermitDto.getDt_admit_plan(), new FTime("00:00:00")));
		aptIpDo.setAmt_deposit(enObsPermitDto.getAmt_deposit());
		aptIpDo.setNote(enObsPermitDto.getNote());
		aptIpDo.setFg_vip(enObsPermitDto.getFg_vip());
		aptIpDo.setId_patcont(patCont == null ? null : patCont.getId_patcont());
		aptIpDo.setDt_valid(new FDateTime(enObsPermitDto.getDt_admit_plan().getDateAfter(1), new FTime("23:59:59")));
		IAptipMDOCudService serv=ServiceFinder.find(IAptipMDOCudService.class);
		return serv.save(new AptIpDO[] {aptIpDo} )[0];
	}
}	
