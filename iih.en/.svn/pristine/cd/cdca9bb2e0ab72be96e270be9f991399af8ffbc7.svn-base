package iih.en.er.bp.stayout;

import iih.en.comm.ep.PiPatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayOutDTO;
import iih.en.er.ip.d.EnEntIpErDO;
import iih.en.er.ip.i.IEnentiperRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

public class GetOutStayInfoBP {
	/**
	 * 获取出急诊留观信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public UrgStayOutDTO exec(String entId) throws BizException {
		if(entId == null){
			return new UrgStayOutDTO();
		}
		UrgStayOutDTO urgstayout = new UrgStayOutDTO();
		//1查询患者信息
		this.setPatInfo(entId,urgstayout);
		//2查询离院信息
		this.setOutHosInfo(entId,urgstayout);
		return urgstayout;
	}

	/**
	 * 1.查询患者信息
	 * 
	 * @param entId
	 * @param obsPermit
	 * @throws BizException
	 */
	private void setPatInfo(String entId,UrgStayOutDTO urgstayout) throws BizException {
		urgstayout.setId_ent(entId);
		PvEP ep = new PvEP();
		PatiVisitDO patVisitDo = ep.getPvById(entId);
		if(patVisitDo == null)
			return;
		PatDO pat = this.getPat(patVisitDo.getId_pat());
		AptIpDO apt = this.getAptIpDo(entId);
		urgstayout.setName(patVisitDo.getName_pat());
		urgstayout.setId_pat(patVisitDo.getId_pat());
		urgstayout.setSex(patVisitDo.getName_sex());
		urgstayout.setMarriage(patVisitDo.getName_mari());
		urgstayout.setAddr(patVisitDo.getAddr_pat());
		urgstayout.setAge(AgeCalcUtil.getAge(patVisitDo.getDt_birth_pat()));
		urgstayout.setCode(pat.getCode());
		urgstayout.setIdtp(pat.getIdtp_name());
		urgstayout.setCode_id(pat.getId_code());
		if(!EnValidator.isEmpty(pat.getMob()))
			urgstayout.setTel(pat.getMob());
		else
			urgstayout.setTel(pat.getTel());
		if(apt == null){
			return;
		}
		//设置患者主要诊断
		urgstayout.setDidef_op(apt.getName_didef_op());
		urgstayout.setSupplement_di(apt.getSupplement_di());
	}
	
	/**
	 * 2查询离院信息
	 * 
	 * @param entId
	 * @param urgstayout
	 * @throws BizException
	 */
	private void setOutHosInfo(String entId, UrgStayOutDTO urgstayout) throws BizException {
		EnEntIpErDO enEntIpErDO = null;
		IEnentiperRService serv = ServiceFinder.find(IEnentiperRService.class);
		EnEntIpErDO[] enEntIpErDOs = serv.findByAttrValString(EnEntIpErDO.ID_ENT, entId);//一定要是住院的entId
		if(enEntIpErDOs == null || enEntIpErDOs.length<=0)
			return;
		enEntIpErDO = enEntIpErDOs[0];
		urgstayout.setId_ent(entId);
		urgstayout.setId_erpre(enEntIpErDO.getId_erpre());
		urgstayout.setName_out_way(enEntIpErDO.getEu_out_way());
		urgstayout.setOut_sensy(enEntIpErDO.getOut_sence());
		urgstayout.setDt_leave(enEntIpErDO.getDt_leave());
		urgstayout.setName_out_gowhere(enEntIpErDO.getName_gowhere_er());
		urgstayout.setId_out_gowhere(enEntIpErDO.getId_gowhere_er());
		urgstayout.setSd_out_gowhere(enEntIpErDO.getSd_gowhere_er());
	}

	/**
	 * 根据就诊id获得AptIpDo
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private AptIpDO getAptIpDo(String entId) throws BizException {
		AptIpDO aptIpDo = null;
		IAptipMDORService serv=ServiceFinder.find(IAptipMDORService.class);
		AptIpDO[] aptIps = serv.findByAttrValString(AptIpDO.ID_ENTIP, entId);
		if(aptIps == null || aptIps.length<=0)
			return null;
		aptIpDo = aptIps[0];
		return aptIpDo;
	}
	
	/**
	 * 根据患者id获取患者
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPat(String id_pat) throws BizException{
		PatDO pat = new PatDO();
		if(EnValidator.isEmpty(id_pat))
			return pat;
		PiPatEP ep = new PiPatEP();
		pat = ep.getPatById(id_pat);
		return pat;
	}
}
	
	