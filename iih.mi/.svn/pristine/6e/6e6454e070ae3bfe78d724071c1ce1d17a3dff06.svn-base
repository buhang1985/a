package iih.mi.verify.bp;

import java.util.List;

import iih.mi.biz.dto.d.DiInfoRegInParamDTO;
import iih.mi.biz.dto.verify.d.VerifyEntInputDTO;
import iih.mi.biz.dto.verify.d.VerifyInputDTO;
import iih.mi.biz.dto.verify.d.VerifySrvInputDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院审核入参
 * @author hanjq 2019年4月10日
 */
public class GetIpVerifyBP {
	/**
	 * 获取住院审核入参
	 * @param id_ors
	 * @param id_ent
	 * @return
	 * @author hanjq 2019年4月10日
	 * @throws BizException 
	 */
	public VerifyInputDTO exce(FArrayList id_ors, String id_ent) throws BizException{
		VerifyInputDTO inputDto = new GetEntVerifyBP().exce(id_ent);
		VerifyEntInputDTO entInputDto = getVerifyEntInputDTO(id_ent);
		entInputDto.setAmt_hp(new FDouble(0));
		
		String sdIncca = "12";//住院
		FArrayList SrvList = new GetSrvVerifyBP().exce(id_ors, id_ent, sdIncca);
		double amt = 0;//总金额
		if(SrvList != null && SrvList.size() > 0){
			for(Object o :SrvList){
				VerifySrvInputDTO SrvInputDto = (VerifySrvInputDTO) o;
				if(SrvInputDto.getAmt() != null)
				amt+=SrvInputDto.getAmt().doubleValue();
			}
		}
		entInputDto.setAmt_hp(new FDouble(amt));
		entInputDto.setTotal_cost(new FDouble(amt));
		inputDto.setTotalnum(SrvList.size());
		inputDto.setTotalamount(new FDouble(amt));
		entInputDto.setTotal_cost(new FDouble(amt));
		inputDto.setHospitalclaim(entInputDto);
		inputDto.setSrvdetail(SrvList);
		return inputDto;		
	}
	/**
	 * 获取住院就诊审核信息
	 * @param id_ors
	 * @param id_ent
	 * @return
	 * @author F 2019年4月10日
	 * @throws DAException 
	 */
	private VerifyEntInputDTO getVerifyEntInputDTO(String id_ent) throws DAException{
		StringBuffer bf = new StringBuffer("SELECT DISTINCT ");
		bf.append("0 amt_hp,");//医保报销金额
		bf.append("ENT.DT_ENTRY Dt_entry ,");//就诊时间
		bf.append("'' Diagnosis_in , ");//入院诊断编码
		bf.append("'' Diagnosis_out, ");//出院诊断编码
		bf.append("'' Diagnosis_tother,");//其他诊断
		bf.append("ppt.sd_sex Gender, ");//性别
		bf.append("'3' Hospital_level,");//定点机构等级
		bf.append("dep.code Hs_area_code,");//科室(病区)		
		bf.append("'' Hs_diagnosis_in_name , ");//入院诊断名称
		bf.append("'' Hs_diagnosis_out_name, ");//出院诊断名称		
		bf.append("eip.code_amr_ip Hs_in_number,");//病案号
		bf.append("eip.code_amr_ip Hs_number,");//住院号\住院号
		bf.append("ppt.name Hs_patient_name,");//参保人姓名
		bf.append("decode(ENT.FG_ST, 'Y','1','0') Hs_status,");//住院状态
		bf.append("'1' Hospitaltype,");//定点机构类型
		bf.append("ENT.CODE Id,");//主单id
		bf.append("ENT.dt_entry In_date,");//入院日期
		bf.append("'0' Islactation,");//是否哺乳期(0否1是)
		bf.append("'0' Ispregnant,");//是否孕期(0否1是)
		bf.append("'03' Medical_type , ");//就医方式 01住院，03住院
		bf.append("ENT.DT_END Out_date,");//出院日期
		bf.append("PPT.DT_BIRTH Patient_birth,");//出生日期
		bf.append("'-1' Patientbenefitgroupcode,");//参保人特殊保险类型组编码 1	代表生育 2	代表工伤 -1	其他
		bf.append("ppt.code Patient_idstr,");//参保人唯一编码
		bf.append("sti.dt_st Settle_date,");//结算日期
		bf.append("0 Total_cost,");//总费用
		bf.append("patca.code Unusual_flag,");//是否异地就医(0否1是)
		bf.append("'0' Z_aact007,");//公务员标记
		bf.append("'1' Z_aact008,");//诊疗项目限价类别
		bf.append("'0' Z_bac021 ");//预留三
		bf.append(" FROM EN_ENT ent ");
		bf.append(" INNER JOIN pi_pat ppt on ppt.id_pat = ent.id_pat ");
		bf.append(" INNER JOIN en_ent_ip eip on eip.id_ent = ent.id_ent ");
		bf.append(" INNER JOIN bd_dep dep on dep.id_dep = eip.id_dep_nuradm ");
		bf.append(" LEFT JOIN BL_ST_IP sti on sti.id_ent = ent.id_ent and sti.fg_canc = 'N' ");
		bf.append(" LEFT JOIN pi_pat_ca patca on patca.id_patca = ent.id_patca ");
		bf.append(" WHERE ENT.id_ent = ? ");
		DAFacade daf = new DAFacade();
		SqlParam sp = new SqlParam();
		sp.addParam(id_ent);
		List<VerifyEntInputDTO> verifyEntInputDtos = (List<VerifyEntInputDTO>) daf.execQuery(bf.toString(), sp,new BeanListHandler(VerifyEntInputDTO.class));
		VerifyEntInputDTO entInputDto = verifyEntInputDtos.get(0);
		if("08".equals(entInputDto.getUnusual_flag()) || "10".equals(entInputDto.getUnusual_flag())){
			entInputDto.setUnusual_flag("1");
		}else{
			entInputDto.setUnusual_flag("0");
		}
		if("1".equals(entInputDto.getGender())){
			
		}else if("2".equals(entInputDto.getGender())){
			entInputDto.setGender("0");
		}else{
			entInputDto.setGender("-1");
		}
		
		if(entInputDto.getOut_date() == null){
			entInputDto.setOut_date(new FDateTime());
		}
		SetEntDi(entInputDto, id_ent);
		return entInputDto;		
	}
	
	/**
	 * 设置住院就诊的诊断信息
	 * @param entInputDto
	 * @param id_ent
	 * @author hanjq 2019年4月10日
	 * @throws DAException 
	 */
	private void SetEntDi(VerifyEntInputDTO entInputDto,String id_ent) throws DAException{
		DAFacade daf = new DAFacade();
		StringBuffer bf = new StringBuffer();
		bf.append("SELECT ");
		bf.append(" DISTINCT hpdi.code Di_code,hpdi.name Di_name , doc.code Didoctor_code , CYZD.SD_DITP Di_tp ");
		bf.append(" FROM CI_DI cyzd ");
		bf.append(" INNER JOIN ci_di_itm itm ON itm.id_di = cyzd.id_di ");
		bf.append(" INNER JOIN BD_PSNDOC doc ON doc.id_psndoc = cyzd.id_emp_sign ");
		bf.append(" INNER JOIN bd_hp_di_vs_his hpdi on hpdi.id_didef = itm.id_didef ");
		bf.append(" WHERE cyzd.id_en = ? ");
		SqlParam sp = new SqlParam();
		sp.addParam(id_ent);
		List<DiInfoRegInParamDTO> diInfos = (List<DiInfoRegInParamDTO>) daf.execQuery(bf.toString(), sp,new BeanListHandler(DiInfoRegInParamDTO.class));
		if(diInfos != null && diInfos.size() >0){
			StringBuffer other = new StringBuffer();
			boolean isDS = false;
			for(DiInfoRegInParamDTO di : diInfos){
				if("15".equals(di.getDi_tp())){
					entInputDto.setDiagnosis_out(di.getDi_code());//出院诊断
					entInputDto.setHs_diagnosis_out_name(di.getDi_name());
				}else if("12".equals(di.getDi_tp())){
					entInputDto.setDiagnosis_in(di.getDi_code());//入院诊断
					entInputDto.setHs_diagnosis_in_name(di.getDi_name());
				}else{
					if(isDS)
						other.append("|");
					other.append(di.getDi_code());//其他诊断
					isDS = true;
				}
			}
			entInputDto.setDiagnosis_tother(other.toString());
		}
	}
}
