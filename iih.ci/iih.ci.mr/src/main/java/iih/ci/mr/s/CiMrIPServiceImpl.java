package iih.ci.mr.s;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeTypeConst;
import iih.ci.mr.auditdto.d.AuditDTO;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import iih.ci.mr.cimrpatinfodto.d.CiMrPatInfoDTO;
import iih.ci.mr.i.ICiMrIPService;
import iih.ci.mr.secinfodto.d.SecInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = { ICiMrIPService.class }, binding = Binding.JSONRPC)
public class CiMrIPServiceImpl implements ICiMrIPService {

	public CiMrIPBaseDTO[] getCiMrIPBaseDTO(String id_mr) throws BizException {
		
		if (id_mr == null || "".equals(id_mr)) {
			return new CiMrIPBaseDTO[] {};
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select case ee.code_entp when '10' then '02' else '01' end id_pre, ");// 就诊类型编码
		sql.append("cm.id_mr id_mr, ");// 病历id
		sql.append("pp.code id_pat, ");// 患者id
		sql.append("   (CASE WHEN ee.code_entp= '10' ");
		sql.append("    THEN  pp.code_amr_ip ");
		sql.append("  ElSE  pp.barcode_chis ");
		sql.append("   end) as id_ent, ");// 就诊id
		sql.append("eeo.times_op times_op, ");// 门诊次数
		sql.append("eei.times_ip times_ip, ");// 住院次数
		sql.append("ee.code en_code_liushui, ");// 就诊流水号
		sql.append("   (CASE WHEN ee.code_entp= '00' ");
		sql.append("    THEN  '01' ");
		sql.append("  WHEN ee.code_entp= '01' ");
		sql.append("    THEN  '02' ");
		sql.append("  WHEN ee.code_entp= '10' ");
		sql.append("    THEN  '03' ");
		sql.append("  WHEN ee.code_entp= '02' ");
		sql.append("    THEN  '04' ");
		sql.append("  ElSE  '05' ");
		sql.append("   end) as code_entp, ");
		sql.append("be.name name_entp, ");
		sql.append("pp.name name, ");// 患者姓名
		sql.append("pp.sd_sex code_sex, ");
		sql.append("bu1.name sex, ");
		sql.append("pp.dt_birth dt_birth, ");
		sql.append("bu2.code code_nation, ");// 民族编码
		sql.append("bu2.name nation, ");// 民族名称
		sql.append("pp.sd_marry code_marry, ");
		sql.append("bu3.name name_marry, ");// 婚姻名称
		sql.append("ppa.street add_born, ");// 出生地址
		sql.append("bu4.code as work_code, ");// 职业编码
		sql.append("bu4.name as work, ");// 职业名称
		sql.append("bd1.code code_dept, ");// 科室编码
		sql.append("bd1.name dept, ");
		sql.append("bd2.code code_dep_nuradm, ");// 病区编码
		sql.append("bd2.name dep_nuradm, ");
		sql.append("eei.name_bed name_bed, ");// 病床号
		sql.append("cm.dt_rd dt_record, ");// 医疗记录录入日期
		sql.append("cm.name name_mr, ");// 病历名称
		sql.append("psn.code code_doc, ");// 创建人员编码
		sql.append("psn.name doc, ");
		sql.append("bo.orgcode code_org, ");// 平台消息码
		sql.append("bo.name org, ");// 组织名称
		sql.append("cm.createdtime dt_created, ");// 病历创建时间
		sql.append("cm.modifiedtime dt_update, ");// 病历最后修改时间
		sql.append("psn2.code code_up_doc, ");// 修改人员编码
		sql.append("psn2.name up_doc, ");
		sql.append("ee.dt_end dt_end, ");
		sql.append("ee.dt_acpt, ");
		sql.append("decode(ee.dt_end, null, trunc(sysdate)-trunc(to_date(ee.dt_acpt,'yyyy-mm-dd hh24:mi:ss')), trunc(to_date(ee.dt_end,'yyyy-mm-dd hh24:mi:ss'))-trunc(to_date(ee.dt_acpt,'yyyy-mm-dd hh24:mi:ss'))) ip_day, ");// 住院天数
		sql.append("psn3.code code_doc_sign, ");//录入人员编码
		sql.append("psn3.name doc_sign, ");
		sql.append("bs.code code_set, ");// 数据集编码
		//sql.append("cmf.emrfs fs, ");// 医疗记录显示数据流
		sql.append("pp.sd_idtp sd_idtp, ");// 身份证类型编码
		sql.append("pp.id_code id_code, ");// 身份证号码
		sql.append("ee.addr_pat as addr, ");// 现住址
		sql.append("pp.workunit as work_unit, ");// 工作地址
		sql.append("ee.telno_pat as tel_num, ");// 联系电话
		sql.append("ppc.name as cont_name, ");// 联系人姓名
		sql.append("ppc.conttel as cont_tel ");// 联系人电话
		sql.append("from ci_mr cm ");
		sql.append("left join en_ent ee on cm.id_ent = ee.id_ent ");
		sql.append("left join pi_pat pp on ee.id_pat = pp.id_pat ");
		sql.append("left join en_ent_op eeo on ee.id_ent = eeo.id_ent ");
		sql.append("left join en_ent_ip eei on ee.id_ent = eei.id_ent ");
		sql.append("left join bd_entp be on ee.code_entp = be.code ");
		sql.append("left join bd_udidoc bu1 on bu1.id_udidoclist = '");
		sql.append(ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX);
		sql.append("' and bu1.code = pp.sd_sex ");
		sql.append("left join bd_udidoc bu2 on bu2.id_udidoclist = '");
		sql.append(ICiMrDictCodeTypeConst.ID_UDIDOCLIST_NATION);
		sql.append("' and bu2.id_udidoc = pp.id_nation ");
		sql.append("left join bd_udidoc bu3 on bu3.id_udidoc = pp.id_marry ");
		sql.append("left join bd_udidoc bu4 on bu4.id_udidoc = pp.id_occu ");
		sql.append("left join pi_pat_addr ppa on pp.id_pat = ppa.id_pat and ppa.sd_addrtp='6' ");
		sql.append("left join bd_dep bd1 on ee.id_dep_phy = bd1.id_dep ");
		sql.append("left join bd_dep bd2 on ee.id_dep_nur = bd2.id_dep ");
		sql.append("left join sys_user su1 on cm.createdby = su1.id_user ");
		sql.append("left join bd_psndoc psn on psn.id_psndoc = su1.id_psn ");
		sql.append("left join bd_org bo on cm.id_org = bo.id_org ");
		sql.append("left join sys_user su2 on cm.modifiedby = su2.id_user ");
		sql.append("left join bd_psndoc psn2 on psn2.id_psndoc = su2.id_psn ");
		sql.append("left join sys_user su3 on cm.id_emp_submit = su3.id_user ");
		sql.append("left join bd_psndoc psn3 on psn3.id_psndoc = su3.id_psn ");
		sql.append("left join bd_mrtp bm on cm.id_mrtp = bm.id_mrtp ");
		sql.append("left join bd_set bs on bm.id_data_set = bs.id_set ");
		sql.append("left join CI_order orde on orde.id_en = ee.id_ent ");
		sql.append("left join CI_AP_TRANS cat on cat.id_or = orde.id_or ");
		sql.append("left join pi_pat_cont ppc on pp.id_pat = ppc.id_pat ");
		//sql.append("inner join ci_mr_fs cmf on cm.id_mr = cmf.id_mr ");
		sql.append("where cm.id_mr = ? ");
		
		SqlParam sp = new SqlParam();
			sp.addParam(id_mr);
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiMrIPBaseDTO> lsDto = (List<CiMrIPBaseDTO>) daf.execQuery(sql.toString(), sp, new BeanListHandler(CiMrIPBaseDTO.class));
		return lsDto.toArray(new CiMrIPBaseDTO[0]);
	}

	@Override
	public AuditDTO[] getAuditDTO(String id_mr) throws BizException {
		DAFacade daf = new DAFacade();
		String sql1 = "select dt_sign as dt_audit,psn.code as code_audit_doc,name as audit_doc from ci_mr_sign cms left join bd_psndoc psn on psn.id_psndoc=cms.id_emp_sign "				
				+ " where cms.id_mr='"
				+ id_mr + "'";

		@SuppressWarnings("unchecked")
		List<AuditDTO> lsDto = (List<AuditDTO>) daf.execQuery(sql1, new BeanListHandler(AuditDTO.class));
		return lsDto.toArray(new AuditDTO[0]);
	}

	@Override
	public SecInfoDTO[] getSecInfoDTO(String id_mr) throws BizException {
		DAFacade daf = new DAFacade();
		String sql1 = "select ccc.code_element Code_sec ,dg.name Title,ccc.content Sec from ci_mr_doc_reference_value ccc   left join  bd_dg dg on dg.code=ccc.code_element   where  ccc.code_element like 'S%' and "				
				+ " ccc.id_mr='"
				+ id_mr + "'";

		@SuppressWarnings("unchecked")
		List<SecInfoDTO> secDto = (List<SecInfoDTO>) daf.execQuery(sql1, new BeanListHandler(SecInfoDTO.class));
		return secDto.toArray(new SecInfoDTO[0]);
	}

	@Override
	public CiMrPatInfoDTO[] getCiMrPatInfoDTO(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("select case ee.code_entp ");
		sb.append("           when '10' then " );
		sb.append("            '02' " );
		sb.append("           else " );
		sb.append("            '01' " );
		sb.append("       end id_pre, " );
		sb.append("       pp.code code_pat, " );
		sb.append("       pp.barcode_chis code_ent, " );
		sb.append("       (CASE " );
		sb.append("           WHEN ee.code_entp = '10' THEN " );
		sb.append("            pp.code_amr_ip " );
		sb.append("           ElSE " );
		sb.append("            pp.barcode_chis " );
		sb.append("       end) as code_ent, " );
		sb.append("       pp.id_code id_code, " );
		sb.append("       eeo.times_op times_op, " );
		sb.append("       eei.times_ip times_ip, " );
		sb.append("       (CASE " );
		sb.append("           WHEN ee.code_entp = '00' THEN " );
		sb.append("            '01' " );
		sb.append("           WHEN ee.code_entp = '01' THEN " );
		sb.append("            '02' " );
		sb.append("           WHEN ee.code_entp = '10' THEN " );
		sb.append("            '03' " );
		sb.append("           WHEN ee.code_entp = '02' THEN " );
		sb.append("            '04' " );
		sb.append("           ElSE " );
		sb.append("            '05' " );
		sb.append("       end) as id_entp, " );
		sb.append("       be.name name_entp, " );
		sb.append("       pp.name name_pat, " );
		sb.append("       ee.sd_sex_pat id_sex_pat, " );
		sb.append("       (CASE " );
		sb.append("           WHEN ee.sd_sex_pat = '0' THEN " );
		sb.append("            '未知的性别' " );
		sb.append("           WHEN ee.sd_sex_pat = '1' THEN " );
		sb.append("            '男' " );
		sb.append("           WHEN ee.sd_sex_pat = '2' THEN " );
		sb.append("            '女' " );
		sb.append("           WHEN ee.sd_sex_pat = '9' THEN " );
		sb.append("            '未说明性别' " );
		sb.append("       end) as name_sex_pat, " );
		sb.append("       bd1.code id_dep_phyadm, " );
		sb.append("       bd1.name name_dep_phyadm, " );
		sb.append("       bd2.code id_dep_nuradm, " );
		sb.append("       bd2.name name_dep_nuradm, " );
		sb.append("       eei.name_bed name_bed, " );
		sb.append("       ee.code code_ent_liushui, " );
		sb.append("       bo.orgcode code_org, " );
		sb.append("       bo.name org, " );
		sb.append("       pp.dt_birth dt_birth, " );
		sb.append("       pp.id_occu as id_occu, " );
		sb.append("       occu.code as sd_occu, " );
		sb.append("       occu.name as name_occu " );
		sb.append("  from en_ent ee " );
		sb.append("  left join pi_pat pp " );
		sb.append("    on ee.id_pat = pp.id_pat " );
		sb.append("  left join en_ent_op eeo " );
		sb.append("    on ee.id_ent = eeo.id_ent " );
		sb.append("  left join en_ent_ip eei " );
		sb.append("    on ee.id_ent = eei.id_ent " );
		sb.append("  left join bd_entp be " );
		sb.append("    on ee.code_entp = be.code " );
		sb.append("  left join bd_dep bd1 " );
		sb.append("    on ee.id_dep_phy = bd1.id_dep " );
		sb.append("  left join bd_dep bd2 " );
		sb.append("    on ee.id_dep_nur = bd2.id_dep " );
		sb.append("  left join bd_org bo " );
		sb.append("    on ee.id_org = bo.id_org " );
		sb.append("  left join bd_udidoc occu " );
		sb.append("    on pp.id_occu = occu.id_udidoc " );
		sb.append(" where ee.id_ent = '");
		sb.append(id_ent);
		sb.append("' ");

		@SuppressWarnings("unchecked")
		List<CiMrPatInfoDTO> lsDto = (List<CiMrPatInfoDTO>) daf.execQuery(sb.toString(), new BeanListHandler(CiMrPatInfoDTO.class));
		return lsDto.toArray(new CiMrPatInfoDTO[0]);
	}

	@Override
	public SecInfoDTO[] getSecInfoDTOForInsertAfter(String id_en) throws BizException {
		DAFacade daf = new DAFacade();
		String sql1 = "select ccc.code_element Code_sec ,dg.name Title,ccc.content Sec from ci_mr_doc_reference_value ccc   left join  bd_dg dg on dg.code=ccc.code_element   where  ccc.code_element like 'S%' and "				
				+ " ccc.id_mr='"
				+ id_en + "' and ccc.id_ent='"+id_en+"'";

		@SuppressWarnings("unchecked")
		List<SecInfoDTO> secDto = (List<SecInfoDTO>) daf.execQuery(sql1, new BeanListHandler(SecInfoDTO.class));
		return secDto.toArray(new SecInfoDTO[0]);
	}

}
