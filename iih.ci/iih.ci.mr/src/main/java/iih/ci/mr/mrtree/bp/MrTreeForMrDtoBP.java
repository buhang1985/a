package iih.ci.mr.mrtree.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.SuMrConst;
import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.d.bd.pub.IPubEnumConst;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取指定病人医疗文件DTO
 * 
 * @author gaorn
 * @date 2020年7月17日- 创建
 */
public class MrTreeForMrDtoBP {

	public MrDTO[] GetMrTreeForMrDto(String id_ent, String id_mrcactm,
			String code_entp, String docornur,String id_su_mr) throws BizException {

		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals(""))
			docornur = "10";

		String [] str = id_su_mr.split(",");
		StringBuffer sbf = new StringBuffer();
		
		if(str.length>0){
			for(int i = 0 ; i <str.length ; i++){
				if(i==str.length-1){
					sbf.append("\'"+str[i]+"\'");
				}else{
					sbf.append("\'"+str[i]+"\',");
				}
			}
		}
		
		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		StringBuilder sb = new StringBuilder();
		
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		
		if ("10".equals(code_entp)) {// 住院
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.createdby  id_treat_doctor,\n");
			sb.append("       cm.id_dep_pat id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       bm.code as code_mrtp,\n");
			sb.append("       bmc.code as code_mrcactm,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM CI_MR cm\n");
			sb.append("  JOIN bd_mrca_ctm bmc\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  LEFT  JOIN bd_mrtp bm\n");
			sb.append("    ON cm.id_mrtp = bm.id_mrtp\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'  and cm.ds = 0 \n ");
			
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");	
			}
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			sb.append(" AND cm.id_su_mr in ("+sbf.toString()+") ");
			sb.append("   AND cm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ");
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}
		if ("00".equals(code_entp))// 门诊
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.createdby  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM CI_MR cm\n");
			sb.append("  JOIN bd_mrca_ctm bmc\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'  and cm.ds = 0 \n ");
			
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			sb.append("   AND cm.code_entp in ( '" + code_entp + "' ");
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");
		}
		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}

	/**
	 * 返回组合显示病历名称后的List<MrDTO>
	 * 
	 * @param listMrDto
	 * @return 组合显示病历名称后的list
	 */
	public List<MrDTO> CombineNamesList(List<MrDTO> listMrDto) {
		List<MrDTO> listMrDto2 = new ArrayList<MrDTO>();

		for (MrDTO mr : listMrDto) {
			String CombineName = CombineName(mr.getName(), mr.getDt_rd(),
					mr.getName_emp_submit());
			mr.setName(CombineName);
			listMrDto2.add(mr);
		}
		return listMrDto2;
	}

	/**
	 * 整合显示病历名称 显示为：名称+"_"+业务时间+"_"+提交人 如果提交人为空显示为：名称+"_"+业务时间
	 * 
	 * @param name
	 *            名称
	 * @param dt_rd
	 *            业务时间（精确到分钟）
	 * @param id_emp_submit
	 *            提交人
	 * @return 组合后的名称
	 */
	public String CombineName(String name, String dt_rd, String name_emp_submit) {
		StringBuilder returnV = new StringBuilder();
		if (name == null || "".equals(name) || "~".equals(name)) {
			returnV.append(name);
		} else if (dt_rd == null || "".equals(dt_rd) || "~".equals(dt_rd)
				|| dt_rd.length() < 3) {
			returnV.append(name);
		} else if (name_emp_submit == null || "".equals(name_emp_submit)
				|| "~".equals(name_emp_submit)) {
			returnV.append(name);
			returnV.append("_");
			returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
		} else {
			returnV.append(name);
			returnV.append("_");
			returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
			returnV.append("_");
			returnV.append(name_emp_submit);
		}
		return returnV.toString();
	}

	
	/**
	 * 住院病历打印二级树
	 * @param id_ent
	 * @param id_mrcactm
	 * @param code_entp
	 * @param paramtype
	 * @param docornur
	 * @return
	 * @throws BizException
	 */
	public MrDTO[] getMrdtoForPrint(String id_ent, String id_mrcactm, String code_entp, String paramtype,String docornur) throws BizException{
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals(""))
			docornur = "10";
		
		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		
		StringBuilder sb = new StringBuilder();
		sb.append("select su.name     as name_emp_submit, ");
		sb.append(" cm.dt_rd          as dt_rd, ");
		sb.append(" cm.id_mr          as id_mr, ");
		sb.append(" cm.id_ent         as id_ent, ");
		sb.append(" cm.id_pat         as id_pat, ");
	    sb.append("	  (case when  su.name is not null ");
        sb.append("	        then  cm.name || '_' || to_char(to_date(cm.dt_rd,'yyyy-MM-dd hh24:mi:ss'),'yyyy-MM-dd hh24:mm')  || '_' ||su.name ");
        sb.append("	        when  su.name is null ");
        sb.append("	        then  cm.name || '_' || to_char(to_date(cm.dt_rd,'yyyy-MM-dd hh24:mi:ss'),'yyyy-MM-dd hh24:mm') ");
        sb.append("	   end) as name,");
		sb.append(" cm.id_mrtp        as id_mrtp, ");
		sb.append(" cm.sd_su_mr, ");
		sb.append(" bmc.id_mrcactm, ");
		sb.append(" bmc.fg_cp, ");
		sb.append(" bmc.name          as mrcactm_name, ");
		sb.append(" cm.id_emp_submit  as id_treat_doctor, ");
		sb.append(" cm.id_submit_dept as id_dep_pat, ");
		sb.append(" bmc.id_fst, ");
		sb.append(" cqif.name         as fst_name ");
		sb.append("  from ci_mr cm ");
		sb.append("  left join bd_mrca_ctm bmc");
		sb.append("  on bmc.id_mrcactm = cm.id_mrcactm ");
		sb.append("  left join ci_qa_itm_fst cqif ");
		sb.append("  on cqif.id_fst = bmc.id_fst ");
		sb.append("  left  join sys_user su ");
		sb.append("  on su.id_user = cm.id_emp_submit ");
		sb.append(" where cm.code_entp = '" + code_entp + "' ");
		sb.append(" and bmc.id_mrcactm like '" + id_mrcactm + "' ");
		sb.append(" and bmc.id_org = '" + Context.get().getOrgId() + "' ");
		sb.append(" and cm.id_ent = '" + id_ent + "' and cm.ds = 0 ");
		
		if (docornur.equals("20")) {
			sb.append(" and (bmc.docornur = '20' or bmc.docornur ='30') ");
		} else {
			sb.append(" and (bmc.docornur = '10' or bmc.docornur ='30') ");
		}
		sb.append(" and bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + " ");
		sb.append(" order by cm.dt_rd asc , cm.createdtime asc ");

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		return (MrDTO[]) listMrDto.toArray(new MrDTO[0]);
	}
}
