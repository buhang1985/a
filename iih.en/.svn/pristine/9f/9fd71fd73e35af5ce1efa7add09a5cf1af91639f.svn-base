package iih.en.pv.s.bp.ip.qry;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.i.IEntcontRService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 入院登记(含注册)患者信息查询
 * 
 * @author jizb
 *
 */
public class GetPatInfoBP {

	/**
	 * 入院登记(含注册)患者信息查询
	 * 
	 * @param cond
	 * @return
	 * @throws BizException 
	 */
	public EnHosPatDTO exec(PiPatFuzyyQueryCondDTO cond, String entId, FBoolean isChild, FBoolean fgBb) throws BizException {
		IPiRegQryService rService = ServiceFinder.find(IPiRegQryService.class);
		PatiAggDO[] patiAggDOs = rService.fuzzyQueryPati(cond);
		if (EnValidator.isEmpty(patiAggDOs)) {
			return null;
		}
		EnHosPatDTO[] enHosPatDTOs = this.changePatiAggTOPatEnHosDTO(patiAggDOs, entId, isChild, fgBb);
		if (EnValidator.isEmpty(enHosPatDTOs)) {
			return null;
		}
		//获取患者担保人信息  zhangpp 2019.10.28
		this.getEntContSurety(enHosPatDTOs[0], entId);
        this.getInpatientInfo(enHosPatDTOs[0], entId);
        enHosPatDTOs[0].setStatus(DOStatus.NEW);
		return enHosPatDTOs[0];
	}
	
	/**
	 * 把患者agg信息转换成dto信息
	 * 
	 * @param patiAggDOs
	 * @param entId
	 * @param fgBb
	 * @return
	 * @throws BizException 
	 */
	private EnHosPatDTO[] changePatiAggTOPatEnHosDTO(PatiAggDO[] patiAggDOs, String entId, FBoolean isChild, FBoolean fgBb) throws BizException {
		List<EnHosPatDTO> list = new ArrayList<EnHosPatDTO>();
		if (patiAggDOs == null || patiAggDOs.length == 0) 
			return null;
		for (PatiAggDO patiAggDO : patiAggDOs) {
			list.add(changePatAggToEnHosPat(patiAggDO, entId, isChild, fgBb));
		}
		return list.toArray(new EnHosPatDTO[]{});
	}
	
	/**
	 * 
	 * 
	 * @param patiAggDO
	 * @param entId
	 * @param ischild
	 * @param fg_bb
	 * @return
	 * @throws BizException 
	 */
	private EnHosPatDTO changePatAggToEnHosPat(PatiAggDO patiAggDO, String entId, FBoolean ischild, FBoolean fg_bb) throws BizException {
		EnHosPatDTO enHosPatDTO = new EnHosPatDTO();
		this.getAddrInfo(patiAggDO, enHosPatDTO);
        this.getPatContValue(patiAggDO, enHosPatDTO, entId,ischild,fg_bb);
        this.getPatBasicInfo(patiAggDO, enHosPatDTO,entId);
        if (ischild.booleanValue()) {
        	enHosPatDTO.setIschild(ischild);
        }
        return enHosPatDTO;
	}
	
	/**
	 * 地址信息
	 * 
	 * @param patiAggDO
	 * @param enHosPatDTO
	 */
	private void getAddrInfo(PatiAggDO patiAggDO, EnHosPatDTO enHosPatDTO) {
		PatiAddrDO[] patAddrs = patiAggDO.getPatiAddrDO();
        if (patAddrs == null || patAddrs.length == 0)
        {
            return;
        }
        for (PatiAddrDO addrPatDO : patAddrs)
        {//现住址
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_NOW) && EnValidator.isEmpty(enHosPatDTO.getName_admdiv()))
            {
            	enHosPatDTO.setName_admdiv(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setId_admdiv(addrPatDO.getId_admdiv());
            	enHosPatDTO.setSd_admdiv(addrPatDO.getSd_admdiv());
            	enHosPatDTO.setAddr_pat(addrPatDO.getStreet());
            	enHosPatDTO.setPostcode_addr(addrPatDO.getZip());
            	enHosPatDTO.setTel_admdiv(addrPatDO.getTel());
            }
            //户籍地址
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS))
            {
            	enHosPatDTO.setId_admdiv_resi(addrPatDO.getId_admdiv());
            	enHosPatDTO.setSd_admdiv_resi(addrPatDO.getSd_admdiv());
            	enHosPatDTO.setName_admdiv_resi(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setDetail_addr_resi(addrPatDO.getStreet());
            	enHosPatDTO.setPostcode_resi(addrPatDO.getZip());
            }
            //工作地址
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_WORK))
            {
            	enHosPatDTO.setId_admdiv_work(addrPatDO.getId_admdiv());
            	enHosPatDTO.setSd_admdiv_work(addrPatDO.getSd_admdiv());
            	enHosPatDTO.setName_admdiv_work(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setDetail_addr_work(addrPatDO.getStreet());
            	enHosPatDTO.setPostcode_work(addrPatDO.getZip());
            	enHosPatDTO.setTel_work(addrPatDO.getTel());
            }
            //籍贯
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN))
            {
            	enHosPatDTO.setId_nativeaddr(addrPatDO.getId_admdiv());
            	enHosPatDTO.setName_nativeaddr(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setSd_nativeaddr(addrPatDO.getSd_admdiv());
            }
            //出生地
            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_BORN))
            {
            	enHosPatDTO.setId_birth_addr(addrPatDO.getId_admdiv());
            	enHosPatDTO.setName_birth_addr(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setSd_birth_addr(addrPatDO.getSd_admdiv());
            }
        }
	}
	
	/**
	 * 基本信息
	 * 
	 * @param pataggdo
	 * @param enhosPatDTO
	 */
	private void getPatBasicInfo(PatiAggDO pataggdo, EnHosPatDTO enhosPatDTO,String entId)
    {
        PatDO patdo = pataggdo.getParentDO();
        enhosPatDTO.setName_marry(patdo.getMarry_name());
        enhosPatDTO.setId_marry(patdo.getId_marry());
        enhosPatDTO.setId_pat(patdo.getId_pat());
        enhosPatDTO.setCode_pat(patdo.getCode());
        enhosPatDTO.setName_pat(patdo.getName());
        if (!(EnParamUtils.getIsChangeIpCode())) {
            enhosPatDTO.setCode_amr_ip(patdo.getCode_amr_ip());
		}else{
			if(!EnValidator.isEmpty(entId)){
				enhosPatDTO.setCode_amr_ip(patdo.getCode_amr_ip());
			}
		}


        enhosPatDTO.setId_sex(patdo.getId_sex());//性别
        enhosPatDTO.setSd_sex(patdo.getSd_sex());
        enhosPatDTO.setName_sex(patdo.getName_sex());

        enhosPatDTO.setId_idtp(patdo.getId_idtp());//证件类型
        enhosPatDTO.setSd_idtp(patdo.getSd_idtp());
        enhosPatDTO.setName_idtp(patdo.getIdtp_name());
        enhosPatDTO.setId(patdo.getId_code());//证件号码

        enhosPatDTO.setDt_birth(patdo.getDt_birth());
        enhosPatDTO.setDt_birth_hms(patdo.getDt_birth_hms()); // 出生日期 年月日 - zhangpp
        
        enhosPatDTO.setId_marry(patdo.getId_marry());
        enhosPatDTO.setSd_marry(patdo.getSd_marry());
        enhosPatDTO.setName_marry(patdo.getMarry_name());
        enhosPatDTO.setTel(patdo.getTel());//电话
        enhosPatDTO.setMob(patdo.getMob());//移动电话      	

        enhosPatDTO.setId_nation(patdo.getId_nation()); //民族
        enhosPatDTO.setName_nation(patdo.getNation_name());

        enhosPatDTO.setId_country(patdo.getId_country());//国籍
        enhosPatDTO.setName_country(patdo.getCountry_name());
        enhosPatDTO.setAge(AgeCalcUtil.getAge(patdo.getDt_birth()));

        enhosPatDTO.setId_patca(patdo.getId_paticate());//患者分类
        enhosPatDTO.setName_patca(patdo.getPaticate_name());

        enhosPatDTO.setId_job(patdo.getId_occu());
        enhosPatDTO.setName_job(patdo.getOccu_name());
        enhosPatDTO.setPhoto(patdo.getPhoto());
        enhosPatDTO.setWorkplace(patdo.getWorkunit());
    }
	
	/**
	 * 患者联系人
	 * 
	 * @param pataggdo
	 * @param enhosPatDTO
	 * @param entId
	 * @param ischild
	 * @param fg_bb
	 * @throws BizException
	 */
	private void getPatContValue(PatiAggDO pataggdo, EnHosPatDTO enhosPatDTO, String entId, FBoolean ischild, FBoolean fg_bb) throws BizException
    {
        PiPatContDO[] patContDOs = pataggdo.getPiPatContDO();
        if (EnValidator.isEmpty(patContDOs))
        {
            return;
        }
        if (!ischild.booleanValue()  && (fg_bb == null || !fg_bb.booleanValue()))
        {
        	 if (EnValidator.isEmpty(entId))
             {
        		 this.SetPatContValueWithIpnt(pataggdo.getPrimaryKey(), enhosPatDTO);
             	return;
             }
             IEntcontRService contRService = ServiceFinder.find(IEntcontRService.class);
             EntContDO[] entConts = null;
             entConts = contRService.find("id_ent = '" + entId + "' and eu_entconttp='" + (int)EuEntContTp.CONTACT + "'", "", FBoolean.FALSE);
             if (entConts == null || entConts.length == 0)
             {
                 entConts = contRService.find("id_ent = '" + entId + "' and eu_entconttp in ('" + (int)EuEntContTp.FATHER + "' ,'"+(int)EuEntContTp.MOTHER +"')",
                 "", FBoolean.FALSE);
                 if (EnValidator.isEmpty(entConts))
                 {
                     return;
                 }
             }
             EntContDO entCont = entConts[0];   
             PiPatContDO patConts =null;
             for (PiPatContDO piPatContDO : patContDOs) {
     			if (piPatContDO.getId_patcont().equals(entCont.getId_patcontid())) {
     				patConts=piPatContDO;
     				break;
     			}
     		}
             if(patConts ==null){
             	return ;
             }  	     
            this.setPatContValue(enhosPatDTO, patConts);
        }else{
        	this.SetChildValue(enhosPatDTO, patContDOs);
        }
      
    }
	/**
	 * 如果有入院申请单的，需要取联系人
	 * @param patId
	 * @throws DAException
	 */
	private void SetPatContValueWithIpnt(String patId,EnHosPatDTO enhosPatDTO) throws DAException{
		// 组装查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append(" select patcont.* , doc.name  as Conttp_name   from   sc_apt_ip ip  ");
		sb.append(" inner join pi_pat_cont patcont  ");
		sb.append(" on patcont.id_patcont = ip.id_patcont ");
		sb.append(" and ip.id_pat = patcont.id_pat ");
		sb.append(" left join bd_udidoc doc");
		sb.append("  on doc.id_udidoc  = patcont.id_conttp");
		sb.append(" where ip.id_pat =? ");
		sb.append(" and ip.sd_status in ('" + IEnDictCodeConst.SD_STATUS_NOTICE_CREATE + "','" + IEnDictCodeConst.SD_STATUS_NOTICE_NOTIFY + "','"

		+ IEnDictCodeConst.SD_STATUS_NOTICE_ACC + "','" + IEnDictCodeConst.SD_STATUS_NOTICE_REFUSE + "')");
		sb.append(" and ip.fg_emgstay=ISNULL(ip.fg_emgstay,'N')  and ip.Fg_canc ='N'");// 急诊留观标识
		
		

		SqlParam param = new SqlParam();
		param.addParam(patId);
		List<PiPatContDO> list = (List<PiPatContDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(PiPatContDO.class));
		if(EnValidator.isEmpty(list)){
			return ;
		}
		this.setPatContValue(enhosPatDTO, list.get(0));
		
	}
	/**
	 * 回写联系人的值
	 * @param enhosPatDTO
	 * @param patConts
	 */
	private void  setPatContValue(EnHosPatDTO enhosPatDTO ,PiPatContDO  patConts){
		   enhosPatDTO.setId_patcont(patConts.getId_patcont());
           enhosPatDTO.setName_patcont(patConts.getName());
           enhosPatDTO.setName_patcontref(patConts.getName());
           enhosPatDTO.setId_conttp(patConts.getId_conttp());
           enhosPatDTO.setName_conttp(patConts.getConttp_name());
           enhosPatDTO.setConttel(patConts.getConttel());
           enhosPatDTO.setContaddr(patConts.getContaddr());	
	}
	/**
	 * 设置婴儿的父母值
	 * @param enhosPatDTO
	 * @param patContDOs
	 */
	private void SetChildValue( EnHosPatDTO enhosPatDTO, PiPatContDO[] patContDOs){
		for (PiPatContDO contDo : patContDOs)
        {
            if (contDo.getSd_fmrole() == IPiDictCodeConst.SD_PARENT_MOTHER)
            {
                enhosPatDTO.setId_patcont(contDo.getId_patcont());
                enhosPatDTO.setName_patcontref(contDo.getName());
                enhosPatDTO.setConttel(contDo.getConttel());
                enhosPatDTO.setContaddr(contDo.getContaddr());
                enhosPatDTO.setZip_cont(contDo.getZip());
                enhosPatDTO.setId_cont(contDo.getContid());
            }
            if (contDo.getSd_fmrole() == IPiDictCodeConst.SD_PARENT_FATHER) 
            {
                enhosPatDTO.setId_patcont2(contDo.getId_patcont());
                enhosPatDTO.setName_patcontref2(contDo.getName());
                enhosPatDTO.setConttel2(contDo.getConttel());
                enhosPatDTO.setContaddr2(contDo.getContaddr());
                enhosPatDTO.setZip_cont2(contDo.getZip());
                enhosPatDTO.setId_cont2(contDo.getContid());
            }
        }	  
	}
	
	/**
	 * 住院信息
	 * 
	 * @param enHosPatDTO
	 * @param entId
	 * @throws BizException
	 */
	private void getInpatientInfo(EnHosPatDTO enHosPatDTO, String entId) throws BizException {
		IInpatientRService rService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOs = rService.find(String.format(InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent='%s'",entId), null, FBoolean.FALSE);
		if (EnValidator.isEmpty(inpatientDOs)) {
			return;
		}
		enHosPatDTO.setCode_amr_ip(inpatientDOs[0].getCode_amr_ip());
		enHosPatDTO.setSd_pay_mothod(inpatientDOs[0].getSd_pay_mothod());
		enHosPatDTO.setFg_vip(inpatientDOs[0].getFg_vip());
		enHosPatDTO.setFg_mobapp(inpatientDOs[0].getFg_mobapp());
		enHosPatDTO.setTelno_mobapp(inpatientDOs[0].getTelno_mobapp());
		enHosPatDTO.setFg_pe(inpatientDOs[0].getFg_pe());
		enHosPatDTO.setSd_pe_psntp(inpatientDOs[0].getSd_pe_psntp());
		enHosPatDTO.setName_pe_intr(inpatientDOs[0].getName_pe_intr());
		IUdidocRService uService = ServiceFinder.find(IUdidocRService.class);
		//付款方式
		UdidocDO[] payMethods = uService.find(String.format(UdidocDODesc.TABLE_ALIAS_NAME + ".id_udidoclist='%s' and " + UdidocDODesc.TABLE_ALIAS_NAME
				+ ".code='%s'", "@@@@TL400000000000QF", inpatientDOs[0].getSd_pay_mothod()), null, FBoolean.FALSE);
		//体检身份类型
		UdidocDO[] pePsnTps = uService.find(String.format(UdidocDODesc.TABLE_ALIAS_NAME + ".id_udidoclist='%s' and " + UdidocDODesc.TABLE_ALIAS_NAME
				+ ".code='%s'", "@@@@ZZ2000000000005L", inpatientDOs[0].getSd_pe_psntp()), null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(payMethods) && payMethods.length > 0) {
			enHosPatDTO.setName_pay_mothod(payMethods[0].getName());
			enHosPatDTO.setId_pay_mothod(payMethods[0].getId_udidoc());
		}
		if (!EnValidator.isEmpty(pePsnTps) && pePsnTps.length > 0) {
			enHosPatDTO.setName_pe_psntp(pePsnTps[0].getName());
			enHosPatDTO.setId_pe_psntp(pePsnTps[0].getId_udidoc());
		}
	}
	
	/**
	 * 查询患者担保人信息
	 * @param enHosPatDTO
	 * @param entId
	 * @throws BizException 
	 */
	private void getEntContSurety(EnHosPatDTO enHosPatDTO, String entId) throws BizException{
		if (EnValidator.isEmpty(entId)) {
			return;
		}
		EntContDO[] entContDOs = new EntContEP().getEntConts(entId, EuEntContTp.SURETY, "");
		if (EnValidator.isEmpty(entContDOs)) {
			return;
		}
		enHosPatDTO.setSurety_idtype(entContDOs[0].getId_guarantp());
		enHosPatDTO.setSurety_sdtype(entContDOs[0].getSd_guarantp());
		enHosPatDTO.setSurety_nametype(entContDOs[0].getName_guarantp());
		enHosPatDTO.setSurety_name_emp(entContDOs[0].getName());
		enHosPatDTO.setSurety_idconttp_emp(entContDOs[0].getId_conttp());
		enHosPatDTO.setSurety_sdconttp_emp(entContDOs[0].getSd_conttp());
		enHosPatDTO.setSurety_nameconttp_emp(entContDOs[0].getName_conttp());
		enHosPatDTO.setSurety_idtp_emp(entContDOs[0].getId_idtp());
		enHosPatDTO.setSurety_sdtp_emp(entContDOs[0].getSd_idtp());
		enHosPatDTO.setSurety_nametp_emp(entContDOs[0].getName_idtp());
		enHosPatDTO.setSurety_idcard_emp(entContDOs[0].getIdcode());
		enHosPatDTO.setSurety_tel_emp(entContDOs[0].getConttel());
	}
	
}
