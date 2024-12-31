package iih.en.pv.s.bp.ip;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.entp.i.IEntpRService;
import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取住院基本信息
 * @author renying
 *
 */
public class GetIpBasicInfoBP {
	/**
	 * 获取住院基本信息	
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public IpBasicDTO exec(String entId) throws BizException{	
		if(EnValidator.isEmpty(entId))
			return null;
		// 1.创建新的dto
		IpBasicDTO ipBasicDTO = new IpBasicDTO();
		ipBasicDTO.setId_ent(entId);
		// 2.查找ent信息
		if(!this.getEntInfo(ipBasicDTO)){
			return null;
		}
			
		// 3. 查找住院信息
		this.getInPatientDO(ipBasicDTO);
		return ipBasicDTO;
	}

	/**
	 * 查找en_ent中的信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private Boolean getEntInfo(IpBasicDTO ipbasicDTO) throws BizException {
		IPativisitRService patvisitService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pativisitDO = patvisitService.findById(ipbasicDTO.getId_ent());
		IEntpRService entprservice = ServiceFinder.find(IEntpRService.class);
		EnTypeDO[] entypedos = entprservice.findByAttrValString(EnTypeDO.CODE, pativisitDO.getCode_entp());
		if (pativisitDO == null) {
			return false;
		}
		ipbasicDTO.setId_pat(pativisitDO.getId_pat());
		ipbasicDTO.setName_pat(pativisitDO.getName_pat());
		ipbasicDTO.setDt_entry(pativisitDO.getDt_entry());//入院登记时间
		ipbasicDTO.setDt_acpt(pativisitDO.getDt_acpt());
		ipbasicDTO.setId_dep_phy(pativisitDO.getId_dep_phy());
		ipbasicDTO.setId_dep_nur(pativisitDO.getId_dep_nur());
		ipbasicDTO.setName_dep_phy(pativisitDO.getName_dep_phy());
		ipbasicDTO.setName_dep_nur(pativisitDO.getName_dep_nur());
		ipbasicDTO.setName_sex(this.setSexName(pativisitDO.getId_sex_pat()));//任志  2018年4月1号
		ipbasicDTO.setAge_pat(this.setAgePat(pativisitDO.getDt_birth_pat()));//任志  2018年4月1号
		ipbasicDTO.setId_pat(pativisitDO.getId_pat());
        ipbasicDTO.setDt_end(pativisitDO.getDt_end());
        ipbasicDTO.setFg_ip(pativisitDO.getFg_ip());
        ipbasicDTO.setId_hp(pativisitDO.getId_hp());//医保计划
        ipbasicDTO.setId_pripat(pativisitDO.getId_pripat());
        ipbasicDTO.setVisitordno(pativisitDO.getCode());//流水号
        ipbasicDTO.setName_pripat(pativisitDO.getName_pripat());
        ipbasicDTO.setVisittypecode(pativisitDO.getCode_entp());//就诊类型编码
        ipbasicDTO.setVisittypename(entypedos[0].getName());//就诊类型
        return true;
	}
	
	/**
	 * 查询住院信息
	 * @param ipbasicDTO
	 * @throws BizException
	 */
	private void getInPatientDO(IpBasicDTO ipbasicDTO) throws BizException {
		IInpatientRService inpatientRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOs = inpatientRService.find(InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent = '"
						+ ipbasicDTO.getId_ent() + "'", "", FBoolean.FALSE);
		if (inpatientDOs == null || inpatientDOs.length < 1)
			return;
		InpatientDO inpatientDO = inpatientDOs[0];
		ipbasicDTO.setId_bed(inpatientDO.getId_bed());
		ipbasicDTO.setName_bed(inpatientDO.getName_bed());
		ipbasicDTO.setCode_amr_ip(inpatientDO.getCode_amr_ip());
		ipbasicDTO.setSd_status(inpatientDO.getSd_status());
		ipbasicDTO.setTimes_ip(inpatientDO.getTimes_ip());//住院次数
	}
	
    /**
     * 获取性别
     * 任志  2018年4月1号
     * @param Idsexpat
     * @return
     */
    private String setSexName(String Idsexpat) {
        if (IEnConst.SEX_ID_BOY.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_BOY;
        }
        if (IEnConst.SEX_ID_GIRL.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_GIRL;
        }
        if (IEnConst.SEX_ID_UNDECLARED.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_UNDECLARED;
        }
        if (IEnConst.SEX_ID_UNKNOWN.equals(Idsexpat)) {
            return IEnConst.SEX_NAME_UNKNOWN;
        }
        return "";
    }
    /**
     * 获取年龄
     * 任志  2018年4月1号
     * @param fDate
     * @return
     */
    private String setAgePat(FDate fDate) {
        FDate date = new FDate();
        if (fDate != null && fDate.getYear() != 0) {
            Integer age = date.getYear() - fDate.getYear();
            return age.toString();
        }
        return "";
    }
}

