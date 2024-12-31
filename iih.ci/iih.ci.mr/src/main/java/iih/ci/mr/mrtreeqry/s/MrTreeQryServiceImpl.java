package iih.ci.mr.mrtreeqry.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.SuMrConst;
import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.ci.mr.mrtreeqry.i.IMrTreeQryService;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.d.bd.pub.IPubEnumConst;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

@Service(serviceInterfaces = { IMrTreeQryService.class }, binding = Binding.JSONRPC)
public class MrTreeQryServiceImpl implements IMrTreeQryService{

	@Override
	public MrCaCtmMrDTO[] getMrcactm(String id_ent, String code_entp,
			Integer hasAll , String docornur)
			throws BizException {
		/**
		 * 实现代码
		 */
		if(docornur == null || docornur.equals("") )
		{
			docornur = "10";
		}

		if (id_ent == null || id_ent.equals("") )
			throw new BizException("病人就诊号不能为空");

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder
				.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service
				.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		StringBuilder sbSql = new StringBuilder();
		String strsql="";
		//质控用
		if (0 == hasAll) {		
			sbSql.append("SELECT  ");
			sbSql.append("  bd_mrca_ctm.id_mrcactm,  " ); 
			sbSql.append("  bd_mrca_ctm.code,  " ); 
			sbSql.append("  bd_mrca_ctm.name,  " );
			sbSql.append("  bd_mrca_ctm.des,  " ); 
			sbSql.append("  bd_mrca_ctm.sortno,  " ) ;
			sbSql.append("  bd_mrca_ctm.code_entp,  " ); 
			sbSql.append("  bd_mrca_ctm.id_entp,  " ); 
			sbSql.append("  (select COUNT(1)  " ); 
			sbSql.append("FROM  " ); 
			sbSql.append("CI_MR cm  "  ); 
			sbSql.append("WHERE cm.id_mrcactm = bd_mrca_ctm.id_mrcactm  "  ); 
			sbSql.append("AND cm.id_ent = '" + id_ent + "'  "  ); 
			sbSql.append("AND cm.sd_su_mr not in  ('" + SuMrConst.SD_SUMR_NEW + "','" + SuMrConst.SD_SUMR_RETRIEVE + "','" + SuMrConst.SD_SUMR_REJECT + "') and cm.ds = 0 "  ); 
			sbSql.append(" ) AS mr_count,  " ); 
			sbSql.append("    bd_mrca_ctm.ds,  " ); 
			sbSql.append("bd_mrca_ctm.sv  " ); 
			sbSql.append("FROM  " ); 
			sbSql.append("bd_mrca_ctm bd_mrca_ctm  " ); 
			sbSql.append("WHERE  " );  
			sbSql.append("bd_mrca_ctm.ds = 0  and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)); 
			if("10".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =10 OR bd_mrca_ctm.docornur = 30) " ); 
				
			}
			if("20".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =20 OR bd_mrca_ctm.docornur = 30) " ); 
				
			}
			sbSql.append("AND bd_mrca_ctm.code_entp = '"+ code_entp + "'  " ); 
			sbSql.append("AND bd_mrca_ctm.activestate =   " + IPubEnumConst.ACTIVESTATE_ENABLE ); 
			sbSql.append("    ORDER BY sortno;" ); 

		}
		//门诊用
		if (2 == hasAll) {		

			sbSql.append("SELECT  " );
			sbSql.append("  bd_mrca_ctm.id_mrcactm,  " ); 
			sbSql.append("  bd_mrca_ctm.code,  " ); 
			sbSql.append("  bd_mrca_ctm.name,  " ); 
			sbSql.append("  bd_mrca_ctm.des,  " ); 
			sbSql.append("  bd_mrca_ctm.sortno,  " ); 
			sbSql.append("  bd_mrca_ctm.code_entp,  " ); 
			sbSql.append("  bd_mrca_ctm.id_entp,  " ); 
			sbSql.append("  (select COUNT(1)  " ); 
			sbSql.append("FROM  " ); 
			sbSql.append("CI_MR cm  " ); 
			sbSql.append("WHERE cm.id_mrcactm = bd_mrca_ctm.id_mrcactm  " ); 
			sbSql.append("AND cm.id_ent = '" + id_ent + "' and cm.ds = 0  " ); 
			sbSql.append(" ) AS mr_count,  " ); 
			sbSql.append("    bd_mrca_ctm.ds,  " ); 
			sbSql.append("bd_mrca_ctm.sv  " ); 
			sbSql.append("FROM  " ); 
			sbSql.append("bd_mrca_ctm bd_mrca_ctm  " ); 
			sbSql.append("WHERE  " ); 
			sbSql.append("bd_mrca_ctm.ds = 0  and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)); 
			//sbSql.append("AND bd_mrca_ctm.code_entp = '"+ code_entp + "'  " ); //bd_mrca_ctm.code_entp in( '30','10')
			sbSql.append("    AND bd_mrca_ctm.code_entp in ('" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' " );
			if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){
				sbSql.append(" , '" + code_entp + "'");
			}
			sbSql.append(" )");
			sbSql.append("AND bd_mrca_ctm.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE );
			sbSql.append("    ORDER BY sortno;");

		}
		//住院用
		if (hasAll == 1) {
			
			sbSql.append("SELECT '%' AS id_mrcactm, " );
			sbSql.append("        'all' code, " ); 
			sbSql.append("        '全部' name, " ); 
			sbSql.append("        '全部' des, " ); 
			sbSql.append("  '" + code_entp + "' code_entp,  " ); 
			sbSql.append("  '' id_entp,  " ); 
			sbSql.append("        0 sortno, " ); 
			sbSql.append("        (select COUNT(1) " ); 
			sbSql.append("   from CI_MR cm, bd_mrca_ctm bd_mrca_ctm " ); 
			sbSql.append("  WHERE cm.id_mrcactm = bd_mrca_ctm.id_mrcactm " ); 
			sbSql.append("    and cm.id_ent = '" + id_ent + "' and cm.ds = 0  and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)); 
			sbSql.append("    AND bd_mrca_ctm.ds = 0 " ); 
			if("10".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =10 OR bd_mrca_ctm.docornur = 30) " ); 
				
			}
			if("20".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =20 OR bd_mrca_ctm.docornur = 30) " ); 
				
			}
			sbSql.append("    AND bd_mrca_ctm.code_entp in ('" + code_entp + "' " );
//			if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp) && !IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){
//				sbSql.append(" , '" + code_entp + "'");
//			}
			sbSql.append(" )");
			sbSql.append("    AND bd_mrca_ctm.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE  + " " ); 
			//sbSql.append(" and cm.sd_su_mr <> '00' ");
			sbSql.append("                 ) as mr_count, 0 ds, " ); 
			sbSql.append("  to_char(sysdate, 'yyyy-MM-dd HH24:mi:ss') sv FROM dual " ); 
			sbSql.append(" UNION ALL " ); 
			sbSql.append(" SELECT bd_mrca_ctm.id_mrcactm, " ); 
			sbSql.append("        bd_mrca_ctm.code, " ); 
			sbSql.append("        bd_mrca_ctm.name, " ); 
			sbSql.append("        bd_mrca_ctm.des, " ); 
			sbSql.append("  bd_mrca_ctm.code_entp,  " ); 
			sbSql.append("  bd_mrca_ctm.id_entp,  " ); 
			sbSql.append("                 bd_mrca_ctm.sortno, " ); 
			sbSql.append("                 (select COUNT(1) " ); 
			sbSql.append("            from  CI_MR cm " ); 
			sbSql.append("           WHERE cm.id_mrcactm = bd_mrca_ctm.id_mrcactm " ); 
			sbSql.append("             and cm.id_ent = '"+ id_ent + "' and cm.ds = 0  " ); 
			//sbSql.append(" and cm.sd_su_mr <> '00' ");//新增的数据不显示在既往病历中
			sbSql.append("             ) as mr_count, " ); 
			sbSql.append("              bd_mrca_ctm.ds, bd_mrca_ctm.sv " ); 
			sbSql.append("               FROM bd_mrca_ctm bd_mrca_ctm " ); 
			sbSql.append("           WHERE bd_mrca_ctm.ds = 0 and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)); 
			if("10".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =10 OR bd_mrca_ctm.docornur = 30) " ); 
				
			}
			if("20".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =20 OR bd_mrca_ctm.docornur = 30) " ); 
				
			}
			sbSql.append("             AND bd_mrca_ctm.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE +" " ); 
			sbSql.append("              AND bd_mrca_ctm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "'");
//			if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp) && !IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){
//				sbSql.append(" , '" + code_entp + "'");
//			}
			sbSql.append(" ) ");
			sbSql.append("          ORDER BY sortno;");

			//SqlParam param = new SqlParam();
			
		}
		strsql = sbSql.toString();
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}
	
	@Override
	public MrDTO[] GetMrDtoForTree(String id_ent, String id_mrcactm,
			String code_entp,  String docornur)
			throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals("")) {
			docornur = "10";
		}

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder
				.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service
				.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		StringBuilder sb = new StringBuilder();
		if (ICiMrDictCodeConst.SD_ENTP_ZHUYUAN.equals(code_entp))// 住院
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       bd_udidoc.name Name_su_mr ,");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.id_emp_submit  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append(" left join bd_udidoc bd_udidoc ");
			sb.append(" on cm.id_su_mr = bd_udidoc.id_udidoc ");
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
			sb.append("   AND bmc.activestate = "
					+ IPubEnumConst.ACTIVESTATE_ENABLE + "\n");			
//			sb.append("   AND cm.sd_su_mr <> '" + SuMrConst.SD_SUMR_NEW + "'\n");
			sb.append("   AND cm.code_entp in ( '"
					+ IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ");
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}
		if (ICiMrDictCodeConst.SD_ENTP_MENZHEN.equals(code_entp))// 门诊
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
			sb.append("       cm.id_emp_submit  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
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
			sb.append("   AND bmc.activestate = "
					+ IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			
			sb.append("   AND cm.code_entp in ( '"
					+ code_entp + "' ");
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(),
				new BeanListHandler(MrDTO.class));
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
			// mr.getName_emp_submit();
			// mr.getDt_rd();
			String CombineName = CombineName(mr.getName(), mr.getName_emp_submit(),
					mr.getDt_rd(),mr.getName_su_mr());
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
	public String CombineName(String name, String name_emp_submit, String dt_rd,String name_su_mr) {
		StringBuilder returnV = new StringBuilder();
		if (name == null || "".equals(name) || "~".equals(name)) {
			returnV.append(name);
			returnV.append("_");
			returnV.append(name_su_mr);
		} else if (name_emp_submit == null || "".equals(name_emp_submit)
				|| "~".equals(name_emp_submit)) {
			returnV.append(name);
			returnV.append("_");
			returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
			returnV.append("_");
			returnV.append(name_su_mr);
		} else if (dt_rd == null || "".equals(dt_rd) || "~".equals(dt_rd)
				|| dt_rd.length() < 3) {
			returnV.append(name);
			returnV.append("_");
			returnV.append(name_su_mr);
		} else {
			returnV.append(name);
			returnV.append("_");
			returnV.append(name_emp_submit);
			returnV.append("_");
			returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
			returnV.append("_");
			returnV.append(name_su_mr);
		}
		return returnV.toString();
	}

}
