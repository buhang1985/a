package iih.ci.mr.mrtree.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.d.bd.pub.IPubEnumConst;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;


/**
 * 获取医疗记录自定义分类
 * 
 * @author gaorn
 * @date 2020年7月17日- 创建
 */
public class MrTreeForMrcactmBP {

	
	/**
	 * 获取医疗记录自定义分类
	 */
	public MrCaCtmMrDTO[] GetMrTreeForMrcactm(String id_ent, String code_entp,
			Integer hasAll , String docornur , String id_su_mr) throws BizException {
		/**
		 * 实现代码
		 */
		if(docornur == null || docornur.equals(""))
			docornur = "10";
		if (id_ent == null || id_ent.equals("") )
			throw new BizException("病人就诊号不能为空");

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		
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
			sbSql.append(" AND cm.id_su_mr in ("+sbf.toString()+") and cm.ds = 0 ");
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
			sbSql.append(" )");
			sbSql.append("    AND bd_mrca_ctm.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE  + " " ); 
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
			sbSql.append(" AND bd_mrca_ctm.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE +" " ); 
			sbSql.append(" AND bd_mrca_ctm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "'");
			sbSql.append(" ) ");
			sbSql.append("          ORDER BY sortno;");
		}
		strsql = sbSql.toString();
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery( strsql, new BeanListHandler(MrCaCtmMrDTO.class));
		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
     }
	
	
	/**住院病历打印一级树
	 * @param id_ent
	 * @param code_entp
	 * @param docornur
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public MrCaCtmMrDTO[] getMrCaCtmMrForPrint(String id_ent, String code_entp,String docornur,String id_dept) throws BizException{
		if(docornur == null || docornur.equals("") )
			docornur = "10";

		if (id_ent == null || id_ent.equals("") )
			throw new BizException("病人就诊号不能为空");

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		
		StringBuilder sbSql = new StringBuilder();
			sbSql.append("SELECT '%' AS id_mrcactm, " );
			sbSql.append("        'all' code, " ); 
			sbSql.append("        '全部' name, " ); 
			sbSql.append("        '全部' des, " ); 
			sbSql.append("  '" + code_entp + "' code_entp,  " ); 
			sbSql.append("  '' id_entp,  " ); 
			sbSql.append("        0 sortno, " ); 
			sbSql.append("        (select COUNT(1) " ); 
			sbSql.append("   from  CI_MR cm, bd_mrca_ctm bmc " ); 
			sbSql.append("  WHERE cm.id_mrcactm = bmc.id_mrcactm " ); 
			sbSql.append("    and cm.id_ent = '" + id_ent + "' " ); 
			sbSql.append("    AND bmc.ds = 0 " ); 
			if("10".equals(docornur))
			{
				sbSql.append(" AND (bmc.docornur =10 OR bmc.docornur = 30) " ); 
			}
			if("20".equals(docornur))
			{
				sbSql.append(" AND (bmc.docornur =20 OR bmc.docornur = 30) " ); 
			}
			sbSql.append("    AND bmc.code_entp in ('" + code_entp + "' " );
			sbSql.append(" )");
			sbSql.append("    AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE  + " " ); 
			sbSql.append("                 and cm.ds = 0 ) as mr_count, '' code_settp, 0 ds, " ); 
			sbSql.append("  to_char(sysdate, 'yyyy-MM-dd HH24:mi:ss') sv FROM dual " ); 
			sbSql.append(" UNION ALL " ); 
			sbSql.append(" SELECT bmc.id_mrcactm, " ); 
			sbSql.append("        bmc.code, " ); 
			sbSql.append("        bmc.name, " ); 
			sbSql.append("        bmc.des, " ); 
			sbSql.append("  bmc.code_entp,  " ); 
			sbSql.append("  bmc.id_entp,  " ); 
			sbSql.append("                 bmc.sortno, " ); 
			sbSql.append("                 (select COUNT(1) " ); 
			sbSql.append("            from CI_MR cm " ); 
			sbSql.append("           WHERE cm.id_mrcactm = bmc.id_mrcactm " ); 
			sbSql.append("             and cm.id_ent = '"+ id_ent + "' " ); 
			sbSql.append("              and cm.ds = 0 ) as mr_count, " ); 
			sbSql.append("             bd_set_tp.code code_settp, " ); 
			sbSql.append("              bmc.ds, bmc.sv " ); 
			sbSql.append("               FROM bd_mrca_ctm bmc " ); 
			sbSql.append("               left join bd_set_tp bd_set_tp  " ); 
			sbSql.append("               on bd_set_tp.id_setca=bmc.id_setca  " ); 
			sbSql.append("           WHERE bmc.ds = 0 " ); 
			if("10".equals(docornur))
			{
				sbSql.append(" AND (bmc.docornur =10 OR bmc.docornur = 30) " ); 
			}
			if("20".equals(docornur))
			{
				sbSql.append(" AND (bmc.docornur =20 OR bmc.docornur = 30) " ); 
			}
			sbSql.append(" AND bmc.id_org = '"+Context.get().getOrgId()+"' ");
			sbSql.append("             AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE +" " ); 
			sbSql.append("             AND (bmc.id_dept is null or   bmc.id_dept like '%" + id_dept +"%') " ); 
			sbSql.append("              AND bmc.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "'");
			sbSql.append(" ) ");
			sbSql.append("          ORDER BY sortno;");

			String strsql = sbSql.toString();
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(strsql, new BeanListHandler(MrCaCtmMrDTO.class));
		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}
}
