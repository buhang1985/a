package iih.ci.mr.cdss.s.bp;

import java.util.List;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import iih.ci.mr.mrcdssdto.d.MrCdssDTO;
import iih.ci.mr.mrcdssmaindto.d.MrCdssMainDTO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.diag.ICiEnDiagInfoService;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class MrCdssBp {
	/**
	 * 获取cdss主dto数据
	 * @param bannerDto
	 * @param userCode
	 * @param userName
	 * @param deptName
	 * @param orgCode
	 * @param orgName
	 * @param cdssKey
	 * @return
	 * @throws BizException
	 */
	public MrCdssMainDTO getMrCdssMainDto(Ent4BannerDTO bannerDto,String userCode,String userName,String deptName,String orgCode,String orgName,String cdssKey) throws BizException {
		  MrCdssMainDTO mrCdssMainDto = new MrCdssMainDTO();
          mrCdssMainDto.setUserguid(bannerDto.getBarcode_chis());// 患者ID(条码号)
          mrCdssMainDto.setSerialnumber(bannerDto.getCode_amr_ip());// 就诊编号（住院号）
          mrCdssMainDto.setDoctorguid(userCode);// 医生编号(工号)
          mrCdssMainDto.setDoctorname(userName);// 医生姓名
          mrCdssMainDto.setDepartment(deptName);// 科室名称
          mrCdssMainDto.setHospitalguid(orgCode);// 医院编号
          mrCdssMainDto.setHospitalname(orgName);// 医院名称
          mrCdssMainDto.setAutherkey(cdssKey);// 客户秘钥
          return mrCdssMainDto;
	}
	/**
	 * 获取cdss报文数据
	 * @param id_ent
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MrCdssDTO[] getMrCdssDtos(Ent4BannerDTO bannerDto,CiMrDO ciMrDo,String userCode,String userName,String orgName) throws BizException {
		if(ciMrDo == null){
			return null;
		}
 		DAFacade daf = new DAFacade();
 		StringBuilder sql = new StringBuilder();
 		sql.append(" SELECT pp.barcode_chis as userguid, ");
 		sql.append(" ee.name_pat as patientname, ");
 		sql.append(" ee.code as serialnumber, ");
 		sql.append(" ee.dt_acpt as admissionTime, ");
 		sql.append(" ee.id_dep_phy,");
 		sql.append(" case when sex.name = '未知' then sex.name when sex.name is null then '' else substr(sex.name, 0 ,1) end as gender, ");
 		sql.append(" pp.dt_birth as birthdate, ");
 		if (ciMrDo != null && ciMrDo.getId_mr() != null && "".equals(ciMrDo.getId_mr())) {
 			sql.append(" ctm.name as progresstype, ");
 		}
 		sql.append(" pp.sd_marry as maritalstatus ");
 		sql.append(" from en_ent ee ");
 		sql.append(" left join pi_pat pp ");
 		sql.append(" on ee.id_pat = pp.id_pat " );
 		sql.append(" left join bd_dep bd ");
 		sql.append(" on ee.id_dep_phy = bd.id_dep " );
 		sql.append(" left join bd_udidoc sex ");
 		sql.append(" on ee.id_sex_pat = sex.id_udidoc " );
 		if (ciMrDo != null && ciMrDo.getId_mr() != null && "".equals(ciMrDo.getId_mr())) {
 			sql.append(" left join ci_mr mr ");
 	 		sql.append(" on ee.id_ent = mr.id_ent " );
 	 		sql.append(" left join bd_mrtp mrtp ");
 	 		sql.append(" on mr.id_mrtp = mrtp.id_mrtp " );
 	 		sql.append(" left join bd_mrca_ctm_itm ctmi ");
 	 		sql.append(" on mrtp.id_mrtp = ctmi.id_mrtp " );
 	 		sql.append(" left join bd_mrca_ctm ctm ");
 	 		sql.append(" on ctmi.id_mrcactm = ctm.id_mrcactm " );
 	 		sql.append(" where mr.id_mr = '");
 	 		sql.append(ciMrDo.getId_mr());
 	 		sql.append("' and mr.ds = 0 ");
 	 		sql.append(" and ee.id_ent = ? ");
 		} else {
 			sql.append(" where ee.id_ent = ? ");
 		}
 		String sqlStr=sql.toString();
 		SqlParam sp = new SqlParam();
 		sp.addParam(ciMrDo.getId_ent());
 		List<MrCdssDTO> mrCdssDtoList=(List<MrCdssDTO>) daf.execQuery(sqlStr,sp,new BeanListHandler(MrCdssDTO.class));
 		
		if (mrCdssDtoList == null || mrCdssDtoList.size() <= 0){
			return null;
		}
		MrCdssDTO[] mrCdssDtos = (MrCdssDTO[]) mrCdssDtoList.toArray(new MrCdssDTO[mrCdssDtoList.size()]);
		
		if (ciMrDo != null && ciMrDo.getId_mr() != null && "".equals(ciMrDo.getId_mr())){
			IMrdocrefvalueRService service=ServiceFinder.find(IMrdocrefvalueRService.class);
			MrDocRefValueDO[] mrDocRefValueDOs = service.find("id_mr = '"+ ciMrDo.getId_mr() +"'","",FBoolean.FALSE);
			FArrayList2 fArrayList2 = new FArrayList2();
			
			for (int i = 0; i < mrDocRefValueDOs.length; i++) {
				fArrayList2.add(mrDocRefValueDOs[i]);
			}
			mrCdssDtos[0].setMessagelist(fArrayList2);
		}
		// 设置年龄
		mrCdssDtos[0].setAge(GetPatAge(mrCdssDtos[0].getBirthdate()));
		if (mrCdssDtos[0].getProgresstype() == null) {
			mrCdssDtos[0].setProgresstype("入院记录");
		}
		mrCdssDtos[0].setDefinitediagnosis(getDig(ciMrDo.getId_ent()));
		mrCdssDtos[0].setUserguid(ciMrDo.getId_pat());
		mrCdssDtos[0].setSerialnumber(bannerDto.getBarcode_chis());
		mrCdssDtos[0].setDoctorguid(userCode);
		mrCdssDtos[0].setDoctorname(userName);
		mrCdssDtos[0].setPagesource("2");
		mrCdssDtos[0].setMsgtype("2");
		mrCdssDtos[0].setProgresstemplatename(ciMrDo.getDep_name());
		mrCdssDtos[0].setHospitalname(orgName);
		mrCdssDtos[0].setTimes_ip(bannerDto.getTimes_ip() != null ? bannerDto.getTimes_ip().toString() : "");
		mrCdssDtos[0].setTimes_op(bannerDto.getTimes_op() != null ? bannerDto.getTimes_op().toString() : "");
		switch(ciMrDo.getCode_entp()){
			case "00"://门诊
				mrCdssDtos[0].setName_entp("门诊");
				break;
			case "01"://急诊
				mrCdssDtos[0].setName_entp("急诊");
				break;
			case "02"://体检
				mrCdssDtos[0].setName_entp("体检");
				break;
			case "10"://住院
				mrCdssDtos[0].setName_entp("住院");
				break;
		}
		mrCdssDtos[0].setId_ent(ciMrDo.getId_ent());
		mrCdssDtos[0].setCommitdocnum(ciMrDo.getEmp_submit_name() == null || "".equals(ciMrDo.getEmp_submit_name()) ? "" : ciMrDo.getEmp_submit_name());
		mrCdssDtos[0].setProgressguid(ciMrDo.getId_mr() == null || "".equals(ciMrDo.getId_mr()) ? "" : ciMrDo.getId_mr());
		mrCdssDtos[0].setFinishtime(ciMrDo.getDate_submit() == null || "".equals(ciMrDo.getDate_submit()) ?  "" : ciMrDo.getDate_submit().toString());
		if(ciMrDo.getId_mr() != null){
			mrCdssDtos[0].setMessagelist(getElement(ciMrDo.getId_mr()));
		}
		return mrCdssDtos;
	}
	
	/**
	 * 获取主诉，现病史等值
	 */
	@SuppressWarnings("unchecked")
	public FArrayList2 getElement(String id_mr) throws BizException {
		FArrayList2 list = new FArrayList2();
 		DAFacade daf = new DAFacade();
 		StringBuilder sql = new StringBuilder();
 		sql.append(" SELECT bd_dg.name as id_element, ");
 		sql.append(" ci_mr_doc_reference_value.content as content ");
 		sql.append(" from ci_mr_doc_reference_value ");
 		sql.append(" left join bd_dg ");
 		sql.append(" on bd_dg.code = ci_mr_doc_reference_value.code_element ");
 		sql.append(" where id_mr = ? ");
 		String sqlStr=sql.toString();
 		
 		SqlParam sp = new SqlParam();
 		sp.addParam(id_mr);
 		
 		List<MrDocRefValueDO> mrCdssDtoList = (List<MrDocRefValueDO>) daf.execQuery(sqlStr,sp,new BeanListHandler(MrDocRefValueDO.class));
 		if(mrCdssDtoList.size() > 0){
 			for (MrDocRefValueDO mrDocRefValueDO : mrCdssDtoList) {
 				list.add(mrDocRefValueDO);
			}
 		}
 		return list;
	}
	
	/**
	 * 获取有效诊断
	 */
	@SuppressWarnings("unchecked")
	public FArrayList2 getDig(String id_ent) throws BizException {
		ICiEnDiagInfoService diagService = ServiceFinder.find(ICiEnDiagInfoService.class);
		DiaInfoDTO[] diagInfoDtos = diagService.getCiEnDiagInfos(id_ent);
		FArrayList2 list = new FArrayList2();
		if (diagInfoDtos != null && diagInfoDtos.length > 0) {
			for (int i = 0; i < diagInfoDtos.length; i++) {
				MrDocRefValueDO mrDocRefValueDO = new MrDocRefValueDO();
				mrDocRefValueDO.setId_element(diagInfoDtos[i].getCode_dia_tp());// 诊断类型编码
				mrDocRefValueDO.setCode_element(diagInfoDtos[i].getDia_tp());// 诊断类型名称
				mrDocRefValueDO.setContent(diagInfoDtos[i].getDia());// 诊断名称
				list.add(mrDocRefValueDO);
			}
		} 
		return list;
	}
	
    /*
     * 计算患者年龄  -by Vampire
     */
    private String GetPatAge(FDate dt_birth) throws BizException {
	    String age = "";
	    if (dt_birth == null)
		    return age;
	    FDate dt_now = new FDate();
	    long age_millis = dt_now.getMillis() - dt_birth.getMillis();
	    double age_years = (double) age_millis / (1000.0 * 60.0 * 60.0 * 24.0 * 365.0);
		
	    if (age_years >= 1.0) {
		    age = (int)Math.floor(age_years) + "岁";
	    } else {
		    age_years = age_years * 365.0;
		
		    if (age_years >= 30.0) {
			    String month = (int)(age_years / 30.0) + "月";
			    String day = (int)(age_years % 30.0) + "天";
			    age = month + day;
		    } else {
			    age = (int)(age_years % 30.0) + "天";
		    }
	    }
	    return age;
    }
	
}

