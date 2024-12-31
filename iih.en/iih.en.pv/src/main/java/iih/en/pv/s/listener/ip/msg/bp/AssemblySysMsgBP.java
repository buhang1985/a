package iih.en.pv.s.listener.ip.msg.bp;

import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.en.comm.validator.EnValidator;
import iih.en.pub.IEnSysMsgConst;
import iih.en.pv.inpatient.dto.d.IpReg4EsDTO;
import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 组装IpSysMsgDTO
 * 
 * @author liubin
 *
 */
public class AssemblySysMsgBP {
	/**
	 * 通过IpReg4EsDTO组装IpSysMsgDTO
	 * 
	 * @param ipReg4Es
	 * @return
	 */
	public IpSysMsgDTO assemblySysMsgByIpRegDTO(IpReg4EsDTO ipReg4Es){
		if(ipReg4Es == null)
			return null;
		IpSysMsgDTO ipSysMsg = new IpSysMsgDTO();
		ipSysMsg.setId_ent(ipReg4Es.getId_ent());
		ipSysMsg.setId_pat(ipReg4Es.getId_pat());
		ipSysMsg.setName_pat(ipReg4Es.getName_pat());
		ipSysMsg.setId_dep_phy(ipReg4Es.getId_dep_phy());
		ipSysMsg.setId_dep_nur(ipReg4Es.getId_dep_nur());
		ipSysMsg.setIsnew(ipReg4Es.getIsnew());
		ipSysMsg.setNoticecode(IEnSysMsgConst.MSG_IN_HOSPITAL);
		return ipSysMsg;
	}
	/**
	 * 通过转科医嘱组装IpSysMsgDTO
	 * 
	 * @param or
	 * @return
	 * @throws BizException
	 */
	public IpSysMsgDTO assemblySysMsgByTransOr(CiOrderDO or) throws BizException{
		IpSysMsgDTO ipSysMsg = new IpSysMsgDTO();
		ipSysMsg.setId_ent(or.getId_en());
		DAFacade df = new DAFacade();
		PatiVisitDO patiVisitDO = (PatiVisitDO) df.findByPK(PatiVisitDO.class, or.getId_en(), 
				new String[]{PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT, PatiVisitDO.NAME_PAT});
		if(patiVisitDO == null)
			return null;
		ipSysMsg.setId_pat(patiVisitDO.getId_pat());
		ipSysMsg.setName_pat(patiVisitDO.getName_pat());
		@SuppressWarnings("unchecked")
		List<OrdApTransDO> list = (List<OrdApTransDO>) df.findByAttrValString(OrdApTransDO.class, OrdApTransDO.ID_OR, 
				or.getId_or(), null);
		if(EnValidator.isEmpty(list))
			return null;
		ipSysMsg.setId_dep_phy(list.get(0).getId_dep_from());
		ipSysMsg.setId_dep_nur(list.get(0).getId_dep_nur_from());
		return ipSysMsg;
	}
	/**
	 * 通过TransDept4EsDTO组装IpSysMsgDTO
	 * 
	 * @param ipReg4Es
	 * @return
	 */
	public IpSysMsgDTO assemblySysMsgByTransDeptDTO(TransDept4EsDTO transDept4Es){
		if(transDept4Es == null)
			return null;
		IpSysMsgDTO ipSysMsg = new IpSysMsgDTO();
		ipSysMsg.setId_ent(transDept4Es.getId_ent());
		ipSysMsg.setId_pat(transDept4Es.getId_pat());
		ipSysMsg.setName_pat(transDept4Es.getName_pat());
		ipSysMsg.setId_dep_phy(transDept4Es.getId_dep_opr());
		ipSysMsg.setId_dep_nur(transDept4Es.getId_dep_nur());
		ipSysMsg.setName_dep_nur(transDept4Es.getOld_dep_nur_name());
		ipSysMsg.setName_dep_phy(transDept4Es.getOld_dep_phy_name());
		ipSysMsg.setNoticecode(IEnSysMsgConst.MSG_TRANSOUT_TITLE);
		return ipSysMsg;
	}

	/**
	 * 通过出院医嘱组装IpSysMsgDTO
	 * 
	 * @param or
	 * @return
	 * @throws BizException
	 */
	public IpSysMsgDTO assemblySysMsgByOutHospOr(CiOrderDO or) throws BizException{
		IpSysMsgDTO ipSysMsg = new IpSysMsgDTO();
		ipSysMsg.setId_ent(or.getId_en());
		PatiVisitDO patiVisitDO = (PatiVisitDO) new DAFacade().findByPK(PatiVisitDO.class, or.getId_en(), 
				new String[]{PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT, PatiVisitDO.NAME_PAT, 
					PatiVisitDO.ID_DEP_PHY, PatiVisitDO.ID_DEP_NUR });
		if(patiVisitDO == null)
			return null;
		ipSysMsg.setId_pat(patiVisitDO.getId_pat());
		ipSysMsg.setName_pat(patiVisitDO.getName_pat());
		ipSysMsg.setId_dep_phy(patiVisitDO.getId_dep_phy());
		ipSysMsg.setId_dep_nur(patiVisitDO.getId_dep_nur());
		return ipSysMsg;
	}
}
