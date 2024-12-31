package iih.en.pv.s.listener.bp;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.ChgDoctor4IpDTO;
import iih.en.pv.inpatient.dto.d.Doctor4IpDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * 包装医生变更集成平台DTO
 * @author Kaptain
 *
 */
public class WrapChgDoc4IpBP {
	
	/**
	 * 包装集成平台事件源
	 * 
	 * @param enterDept4EsDTO
	 * @return
	 * @throws BizException
	 */
	public ChgDoctor4IpDTO exec(String entId) throws BizException {
		ChgDoctor4IpDTO ipDTO = new ChgDoctor4IpDTO();
		ipDTO.setArea(IEnConst.HISAREA);
		ipDTO.setCode_enttp(IEnConst.IPENTTP);
		ipDTO.setCreate_time(EnAppUtils.getServerDateTime().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmmss")));
		this.setValueFromIpInfo(entId, ipDTO);
		this.setValueFromPativisitInfo(entId, ipDTO);
		this.setEmpInfo(entId, ipDTO);
		this.setValueFromPat(ipDTO.getId_pat(), ipDTO);
		this.setGrpValue(ipDTO);
		return ipDTO;
	}
	
	/**
	 * 获取患者数据
	 * 
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void setValueFromPat(String patID, ChgDoctor4IpDTO ipDTO) throws BizException {
		PatEP patEP = new PatEP();
		PatDO patdo = patEP.getPatById(patID);
		if (patdo == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		ipDTO.setCode_pat(patdo.getCode());
//		ipDTO.setCode_ent(patdo.getBarcode_chis());//集成平台需要的就诊号
	
	}
	/**
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromIpInfo(String entId, ChgDoctor4IpDTO ipDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(entId);

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
	    ipDTO.setTimes_ent(ipdo.getTimes_ip());
	    ipDTO.setCode_amr_ip(ipdo.getCode_amr_ip());
	} 
	
	
	/**
	 * 就诊数据
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromPativisitInfo(String entId, ChgDoctor4IpDTO ipDTO) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO endo = pvep.getPvById(entId);
		ipDTO.setId_pat(endo.getId_pat());
		ipDTO.setCode_ent(endo.getCode());
	}
	
	/**
	 * 查询医护人员赋值
	 * @param entId
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setEmpInfo(String entId,ChgDoctor4IpDTO ipDTO) throws BizException
	{
 		FArrayList2 list = new FArrayList2();
 		FDateTime bigestDtb = getMaxBigEnEmp(entId);
 		this.getEmpList(list, entId, IEnDictCodeConst.SD_EMPROLE_DOCTOR, IEnConst.NAME_EMPROLE_ZG, bigestDtb);
 		this.getEmpList(list, entId, IEnDictCodeConst.SD_EMPROLE_ZZDOC, IEnConst.NAME_EMPROLE_ZZ, bigestDtb);
 		this.getEmpList(list, entId, IEnDictCodeConst.SD_EMPROLE_ZRDOC, IEnConst.NAME_EMPROLE_ZR, bigestDtb);
 		this.getEmpList(list, entId, IEnDictCodeConst.SD_EMPROLE_ZYDOC, IEnConst.NAME_EMPROLE_ZY, bigestDtb);
 		this.getEmpList(list, entId, IEnDictCodeConst.SD_EMPROLE_NURSE, IEnConst.NAME_EMPROLE_NURSE, bigestDtb);
		ipDTO.setDocchglist(list);      
	}
	
	/**
	 *查询医护人员列表
	 * 
	 * @param list
	 * @param entId
	 * @param empRole
	 * @throws BizException
	 */
	private void getEmpList(FArrayList2 list, String entId, String empRole, String empRoleName ,FDateTime bigestDtb ) throws BizException{
 		EntEmpEP ep = new EntEmpEP();
		EnPsnDO[] enPsnDos = ep.getEnEmps(entId, empRole);
		if(enPsnDos ==null || bigestDtb == null)
			return;
		//如果是最新更改的，设置成 change first 否则只设first
		boolean flag = isNew(enPsnDos,bigestDtb);
		
		for(int i=0;i<enPsnDos.length;i++){
			EnPsnDO enpsnDO = enPsnDos[i];
			if(null == enpsnDO.getId_emp() && null == enpsnDO.getSd_psndoc() && null == enpsnDO.getName_psndoc()){
				continue;//没有填入医生信息，所以不设置
			}
			Doctor4IpDTO doc =new Doctor4IpDTO();
			if (enpsnDO.getDt_e() != null && i == enPsnDos.length - 2 && flag) {
				doc.setAction("change");
			} else if (enPsnDos.length == 1|| enpsnDO.getDt_e() ==null) {
				doc.setAction("first");
			}
			else{
				continue;
			}		
		
			doc.setId_doctor(enpsnDO.getId_emp());
			doc.setCode_doctor(enpsnDO.getSd_psndoc());
			doc.setName_docotr(enpsnDO.getName_psndoc());
			doc.setTital_typename(empRoleName);
			doc.setDt_begin(enpsnDO.getDt_b().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmmss")));
			if(enpsnDO.getDt_e() !=null){
				doc.setDt_end(enpsnDO.getDt_e().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmmss"))); 	
			}
			doc.setId_ent(enpsnDO.getId_ent());	
			if(IEnDictCodeConst.SD_EMPROLE_DOCTOR.equals(empRole)){
				doc.setZg_doc_flag("1");//主管医师标识（1：是）
			}
			list.add(doc);
		}
	}
	
	/**
	 * 设置机构
	 * @throws BizException
	 */
	private void setGrpValue( ChgDoctor4IpDTO ipDTO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		ipDTO.setSd_org(orgDo.getOrgcode());
		ipDTO.setName_org(orgDo.getName());;
	
	}
	
	/**
	 * 获得最大的dt_b
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public FDateTime getMaxBigEnEmp(String entId) throws BizException {
		IEnpsnRService enpsnService = ServiceFinder.find(IEnpsnRService.class);
		String whereStr = String.format("id_ent='%s' ", entId);
		String orderStr = "dt_b desc";
		EnPsnDO[] psnDOArray = enpsnService.find(whereStr, orderStr, FBoolean.FALSE);
		if (EnValidator.isEmpty(psnDOArray)) {
			return null;
		}
		return psnDOArray[0].getDt_b();
	}
	
	public boolean isNew(EnPsnDO[] enPsnDos , FDateTime bigestDtb){
		boolean flag = false;
		for(int i=0;i<enPsnDos.length;i++){
			EnPsnDO enpsnDO = enPsnDos[i];
			if (enpsnDO.getDt_b().equals(bigestDtb)) {
				flag = true;
			}
		}
		return flag;
	}
	
}
