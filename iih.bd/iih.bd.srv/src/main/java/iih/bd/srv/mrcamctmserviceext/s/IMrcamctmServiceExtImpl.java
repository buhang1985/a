package iih.bd.srv.mrcamctmserviceext.s;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.SuMrConst;
import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.bd.srv.mrcamctmserviceext.i.IMrcamctmServiceExt;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrtpltreeitem.d.MrtplTreeItemDTO;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.i.ICiMrBrowseParamService;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.std.deset.i.IDesetMDORService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.d.bd.pub.IPubEnumConst;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 病历模板自定义操作操作方法服务实现
 */
@Service(serviceInterfaces = { IMrcamctmServiceExt.class }, binding = Binding.JSONRPC)
public class IMrcamctmServiceExtImpl implements IMrcamctmServiceExt {

	/**
	 * 获取医疗记录自定义分类
	 */
	@Override
	public MrCaCtmMrDTO[] getMrcactm(String id_ent, String code_entp,
			Integer hasAll , String docornur ) throws BizException {

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
			sbSql.append("   AND cm.sd_su_mr not in ( '");
			sbSql.append(SuMrConst.SD_SUMR_NEW);
			sbSql.append("','");
			sbSql.append(SuMrConst.SD_SUMR_RETRIEVE);
			sbSql.append("','");
			sbSql.append(SuMrConst.SD_SUMR_REJECT);
			sbSql.append("')");
			sbSql.append(" and cm.ds = 0 "  ); 
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
	/*
	 * 获取医疗记录自定义分类
	 */
	@Override
	public MrCaCtmMrDTO[] getMrcactmBrowseTree(String id_ent, String code_entp,
			Integer hasAll , String docornur ) throws BizException {

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
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		
		
		ICiMrBrowseParamService browseParamService  = ServiceFinder.find(ICiMrBrowseParamService.class);
		SqlParam sp=new SqlParam();
		StringBuilder sbfg =new StringBuilder();
		
		sbfg.append(" select *from ci_amr where ");
		if(id_ent!=null && id_ent!=""){
			sbfg.append(" id_ent =? ");
			sp.addParam(id_ent);
		}
		
		AMrDO amrDo = (AMrDO) daf.execQuery(sbfg.toString(),sp,new BeanHandler(AMrDO.class));
		String param="";
		if(amrDo == null)
		{
			return new MrCaCtmMrDTO[]{};
		}
		else if(amrDo.getFg_complete() !=null &&amrDo.getFg_complete().equals(FBoolean.TRUE)){
			param=browseParamService.GetSysParamArchived(amrDo.getId_org());
		}else {	
			param=browseParamService.GetSysParamNoArchive(amrDo.getId_org());
		}
		String [] str = param.split(",");
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
			sbSql.append(" AND cm.id_su_mr in ("+sbf.toString()+") ");
			sbSql.append(" and cm.ds = 0 " );
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
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(strsql,new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}
	
	/**
	 * 获取医疗记录自定义分类
	 * 查询过滤：
	 * 		1.若未完成书写，则查询已提交（或者是审签中和审签完成）的病历
	 * 		2.若已完成书写，则只按照完成书写标志查询，已完成书写则可以查看
	 * 此方法暂时为兰陵使用方法  - by Vampire
	 */
	public MrCaCtmMrDTO[] getSpecialMrcactm(String id_ent, String code_entp, String docornur ) throws BizException {
		if(docornur == null || docornur.equals("") )
			docornur = "10";
		if (id_ent == null || id_ent.equals("") )
			throw new BizException("病人就诊号不能为空");
		String strsql = "";
		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);
		PatiVisitDO patiVisitDo = service.findById(id_ent);
		
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		AMrDO[] aMrDOs = amrService.find(" a0.id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		// 查询部门参数
		String id_dep = Context.get().getDeptId();
		Boolean canShowNewMR = paraService.getSysParamShowNewMR(id_dep);
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(" select bd_mrca_ctm.id_mrcactm, ");
		sbSql.append(" bd_mrca_ctm.code,  "); 
		sbSql.append(" bd_mrca_ctm.name,  ");
		sbSql.append(" bd_mrca_ctm.des,  "); 
		sbSql.append(" bd_mrca_ctm.sortno,  ") ;
		sbSql.append(" bd_mrca_ctm.code_entp,  "); 
		sbSql.append(" bd_mrca_ctm.id_entp,  "); 
		sbSql.append(" (select count(1)  "); 
		sbSql.append(" from " );
		sbSql.append(" ci_mr cm "); 
		sbSql.append(" where cm.id_mrcactm = bd_mrca_ctm.id_mrcactm  "); 
		sbSql.append(" and cm.id_ent = '" + id_ent + "'  ");
		// 如果当前科室参数为true，则可以直接查看未提交状态的病历；否则需要判断是否已经完成书写
		if(aMrDOs!=null && aMrDOs.length>0 ){
			if (!canShowNewMR) {
				if (aMrDOs[0].getFg_complete() != FBoolean.TRUE) {
					sbSql.append(" and cm.sd_su_mr <> '" + SuMrConst.SD_SUMR_NEW + "' "); 
					sbSql.append(" and cm.sd_su_mr <> '" + SuMrConst.SD_SUMR_RETRIEVE + "' ");
					sbSql.append(" and cm.sd_su_mr <> '" + SuMrConst.SD_SUMR_REJECT + "' ");
				}
			}
		}
		
		sbSql.append(" and cm.ds = 0 ) AS mr_count, "); 
		sbSql.append(" bd_mrca_ctm.ds, "); 
		sbSql.append(" bd_mrca_ctm.sv "); 
		sbSql.append(" from "); 
		sbSql.append(" bd_mrca_ctm bd_mrca_ctm "); 
		sbSql.append(" where ");  
		sbSql.append(" bd_mrca_ctm.ds = 0  and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)); 
		if("10".equals(docornur))
		{
			sbSql.append(" and (bd_mrca_ctm.docornur =10 OR bd_mrca_ctm.docornur = 30) "); 
		}
		if("20".equals(docornur))
		{
			sbSql.append(" and (bd_mrca_ctm.docornur =20 OR bd_mrca_ctm.docornur = 30) "); 
		}
		sbSql.append("and bd_mrca_ctm.code_entp = '"+ code_entp + "' " ); 
		sbSql.append("and bd_mrca_ctm.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE); 
		sbSql.append(" order by sortno; "); 
		
		strsql = sbSql.toString();
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = 
				(List<MrCaCtmMrDTO>) daf.execQuery(strsql, new BeanListHandler(MrCaCtmMrDTO.class));
		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}

	@Override
	public MrCaCtmMrDTO[] getMrtplcactm(String id_ownorg, String id_dep,
			String id_user, String code_entp, String docornur) throws BizException {
		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");
		if(docornur == null || docornur == "")
		{
			docornur = "10";
		}

		DAFacade daf = new DAFacade();
		String strsql = "SELECT '%' AS id_mrcactm, " + "       'all' code, "
				+ "       '全部' name, " + "       '全部' des, "
				+ "  bmc.code_entp,  " 
				+ "  bmc.id_entp,  " 
				+ "       0 sortno, " + "       （select COUNT(1) "
				+ "  from bd_mrca_ctm_itm bmci " + "  JOIN bd_mrtpl bm "
				+ "  ON bmci.id_mrtp = bm.id_mrtp " + " "
				+ "  JOIN  bd_mrca_ctm bmc "
				+ "  ON  bmc.id_mrcactm = bmci.id_mrcactm AND bm.ds = 0 "
				+ " WHERE " + "    bmc.ds = 0 "
				+ "   AND bmc.activestate = 1 " + "   AND bmc.code_entp = '"
				+ code_entp + "' " + "   AND ( " + "    (1=0) ";
		if (id_user != null)
			strsql = strsql + "   OR (bm.id_emp LIKE  '" + id_user + "' AND bm.id_emp<>'~' ) ";
		if (id_dep != null)
			strsql = strsql + "   OR  (bm.id_dept LIKE  '" + id_dep + "' AND bm.id_dept<>'~' ) ";
		if (id_ownorg != null)
			strsql = strsql + "   OR (bm.id_org LIKE  '" + id_ownorg
					+ "' AND bm.id_org<>'~' and bm.sd_owtp = '0' ) ";
		strsql = strsql + "   ))   as mr_count, 0 ds, "
				+ " to_char(sysdate, 'yyyy-MM-dd HH24:mi:ss') sv FROM dual "
				+ "UNION ALL " + "SELECT bmc.id_mrcactm, "
				+ "       bmc.code, " + "       bmc.name, "
				+ "  bmc.code_entp,  " 
				+ "  bmc.id_entp,  " 
				+ "       bmc.des, " + "       bmc.sortno, "
				+ "       （select COUNT(1) " + "  from bd_mrca_ctm_itm bmci "
				+ "  JOIN bd_mrtpl bm " + "   ON bmci.id_mrtp = bm.id_mrtp "
				+ " " + " WHERE bmc.id_mrcactm = bmci.id_mrcactm "
				+ "   AND bmc.code_entp = '" + code_entp + "' "
				+ "   AND ( " + "    (1=0) ";
		if (id_user != null)
			strsql = strsql + "   OR (bm.id_emp LIKE  '" + id_user + "' AND bm.id_emp<>'~' ) ";
		if (id_dep != null)
			strsql = strsql + "   OR  (bm.id_dept LIKE  '" + id_dep + "' AND bm.id_dept<>'~' ) ";
		if (id_ownorg != null)
			strsql = strsql + "   OR (bm.id_org LIKE  '" + id_ownorg
					+ "' AND bm.id_org<>'~' and bm.sd_owtp = '0' ) ";
		strsql = strsql + "   ) "
				+ "  AND bm.ds = 0   ） as mr_count, bmc.ds, bmc.sv FROM "
				+ " bd_mrca_ctm bmc " + " WHERE bmc.ds = 0 "
				+ "   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE  + " " + " ORDER BY sortno; ";

		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}

	@Override
	public EmrTplDO[] GetMrtplByMrCa( String code_entp , String id_ownorg , String id_dep , String id_user , String id_mrcactm , String id_mrtp , String id_owngrp )
			throws BizException {
		if (id_mrcactm == null || id_mrcactm == "")
			throw new BizException("自定义分类不能为空");
		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");


		IEmrtplMDORService cmservice = ServiceFinder
				.find(IEmrtplMDORService.class);
		StringBuilder sb = new StringBuilder();
		sb.append(" (1=1) ");
		sb.append(" AND (a0.id_mrtp in  ");

		sb.append("( ");
		sb.append("SELECT bmci.id_mrtp FROM bd_mrca_ctm_itm bmci ");
		sb.append("WHERE (1=1) ");
		sb.append("   AND ( ");
		sb.append("    (1=0) ");
		if (id_user != null)
			sb.append("   OR (a0.id_emp LIKE  '" + id_user + "' AND a0.id_emp<>'~' ) ");
		if (id_dep != null)
			sb.append("   OR  (a0.id_dept LIKE  '" + id_dep + "' AND a0.id_dept<>'~' ) ");
		if (id_ownorg != null)
			sb.append("   OR (a0.id_org LIKE  '" + id_ownorg + "' AND a0.id_org<>'~'  and a0.sd_owtp = '0') ");
		if (id_owngrp != null)
			sb.append("   OR (a0.id_group LIKE  '" + id_owngrp + "' AND a0.id_group<>'~' ) ");
		sb.append("   ) ");
		sb.append(" AND bmci.id_mrtp LIKE '" + id_mrtp + "' ");
		sb.append(" AND bmci.id_mrcactm LIKE '" + id_mrcactm + "'))");
		String whereStr = sb.toString();
		EmrTplDO[] mrDos = cmservice.find(whereStr, " orderid", FBoolean.FALSE);
		return mrDos;
	}
	
//	public EmrTplDO[] GetMrtplByMrCa2( String code_entp , String id_ownorg , String id_dep , String id_user , String id_mrcactm , String id_mrtp , String id_owngrp ,String filter )
//			throws BizException {
//		if (id_mrcactm == null || id_mrcactm == "")
//			throw new BizException("自定义分类不能为空");
//		if (code_entp == null || code_entp == "")
//			throw new BizException("就诊类型不能为空");
//
//
//		IEmrtplMDORService cmservice = ServiceFinder
//				.find(IEmrtplMDORService.class);
//		StringBuilder sb = new StringBuilder();
//		sb.append(" (1=1) ");
//		sb.append(" AND (a0.id_mrtp in  ");
//
//		sb.append("( ");
//		sb.append("SELECT bmci.id_mrtp FROM bd_mrca_ctm_itm bmci left join bd_mrca_ctm bmc on bmc.id_mrcactm=bmci.id_mrcactm ");
//		sb.append("WHERE (1=1) ");
//		sb.append("   AND ( ");
//		sb.append("    (1=0) ");
//		if (id_user != null)
//			sb.append("   OR (a0.id_emp LIKE  '" + id_user + "' AND a0.id_emp<>'~' ) ");
//		if (id_dep != null)
//			sb.append("   OR  (a0.id_dept LIKE  '" + id_dep + "' AND a0.id_dept<>'~' ) ");
//		if (id_ownorg != null)
//			sb.append("   OR (a0.id_org LIKE  '" + id_ownorg + "' AND a0.id_org<>'~'  and a0.sd_owtp = '0') ");
//		if (id_owngrp != null)
//			sb.append("   OR (a0.id_group LIKE  '" + id_owngrp + "' AND a0.id_group<>'~' ) ");
//		sb.append("   ) ");
//		if(id_mrtp!=null&&!id_mrtp.equals("null"))
//		{
//		sb.append(" AND bmci.id_mrtp LIKE '" + id_mrtp+ "' ");
//		}
//		sb.append(" AND bmci.id_mrcactm LIKE '" +  id_mrcactm + "'");
//		sb.append(" AND bmc.code_entp='" + code_entp + "'))");
//		if(filter!=null && filter!="")
//		{
//			sb.append(" AND ").append(filter);
//		}
//		String whereStr = sb.toString();
//		EmrTplDO[] mrDos = cmservice.find(whereStr, "orderid", FBoolean.FALSE);
//		return mrDos;
//	}
	
	public EmrTplDO[] GetMrtplByMrCa2( String code_entp , String id_ownorg , String id_dep , String id_user , String id_mrcactm , String id_mrtp , String id_owngrp ,String filter )
			throws BizException {
		if (id_mrcactm == null || id_mrcactm == "")
			throw new BizException("自定义分类不能为空");
		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");


		IEmrtplMDORService cmservice = ServiceFinder
				.find(IEmrtplMDORService.class);
		StringBuilder sb = new StringBuilder();
		sb.append(" ((1=1) ");
		sb.append(" AND (a0.id_mrtp in  ");

		sb.append("( ");
		sb.append("SELECT bmci.id_mrtp FROM bd_mrca_ctm_itm bmci left join bd_mrca_ctm bmc on bmc.id_mrcactm=bmci.id_mrcactm ");
		sb.append("WHERE (1=1) ");
		sb.append("   AND ( ");
		sb.append("    (1=0) ");
		if (id_user != null)
			sb.append("   OR (a0.id_emp LIKE  '" + id_user + "' AND a0.id_emp<>'~' ) ");
		if (id_dep != null)
			sb.append("   OR  (a0.id_dept LIKE  '" + id_dep + "' AND a0.id_dept<>'~' ) ");
		if (id_ownorg != null)
			sb.append("   OR (a0.id_org LIKE  '" + id_ownorg + "' AND a0.id_org<>'~'  and a0.sd_owtp = '0' ) ");
		if (id_owngrp != null)
			sb.append("   OR (a0.id_group LIKE  '" + id_owngrp + "' AND a0.id_group<>'~' ) ");
		sb.append("   ) ");
		if(id_mrtp!=null&&!id_mrtp.equals("null"))
		{
		sb.append(" AND bmci.id_mrtp LIKE '" + id_mrtp+ "' ");
		}
		sb.append(" AND bmci.id_mrcactm LIKE '" +  id_mrcactm + "'");
		sb.append(" AND bmc.code_entp='" + code_entp + "'))");
		if(filter!=null && filter!="")
		{
			sb.append(" AND ").append(filter);
		}
		sb.append(") ");
		
		sb.append(" or (id_mrtpl in (select id_mrtpl from bd_mrtpl_shared t where t.id_to_dep = '");
		sb.append(id_dep);
		sb.append("' and t.id_mrtp in (select id_mrtp from bd_mrca_ctm_itm left join bd_mrca_ctm on bd_mrca_ctm_itm.id_mrcactm = bd_mrca_ctm.id_mrcactm where bd_mrca_ctm_itm.id_mrcactm = '");
		sb.append(id_mrcactm);
		sb.append("' ");
		if(id_mrtp!=null&&!id_mrtp.equals("null"))
		{
			sb.append(" and bd_mrca_ctm_itm.id_mrtp = '");
			sb.append(id_mrtp);
			sb.append("'");
		}
		sb.append("and bd_mrca_ctm.code_entp = '00')))");
			          
		
		String whereStr = sb.toString();
		EmrTplDO[] mrDos = cmservice.find(whereStr, "orderid", FBoolean.FALSE);
		return mrDos;
	}
	
	/**ryp**/
	
	@Override
	public EmrTplDO[] GetMrtplByFilter( String id_ownorg , String id_dep , String id_user ,  String id_owngrp ,String filter)
			throws BizException {



		IEmrtplMDORService cmservice = ServiceFinder
				.find(IEmrtplMDORService.class);
		StringBuilder sb = new StringBuilder();
		sb.append(" (1=1) AND ((1=0) ");

		if (id_user != null)
			sb.append("   OR (a0.id_emp LIKE  '" + id_user + "' AND a0.id_emp<>'~' ) ");
		if (id_dep != null)
			sb.append("   OR  (a0.id_dept LIKE  '" + id_dep + "' AND a0.id_dept<>'~' ) ");
		if (id_ownorg != null)
			sb.append("   OR (a0.id_org LIKE  '" + id_ownorg + "' AND a0.id_org<>'~'  and a0.sd_owtp = '0') ");
		if (id_owngrp != null)
			sb.append("   OR (a0.id_group LIKE  '" + id_owngrp + "' AND a0.id_group<>'~' ) ");
		
		sb.append("   ) and( a0.name like '%"+filter+"%' or a0.wbcode like '%"+filter+"%' or a0.pycode like '%"+filter+"%' or a0.des like '%"+filter+"%' )");

		String whereStr = sb.toString();
		EmrTplDO[] mrDos = cmservice.find(whereStr, "", FBoolean.FALSE);
		return mrDos;
	}

	
	@Override
	public MrtplTreeItemDTO[] GetMrtplTreeItems( String code_entp , String id_ownorg , String id_dep , String id_user , String mrtp_name , String id_owngrp ) 
			throws BizException {
		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");
	    

		DAFacade daf = new DAFacade();
		List<MrtplTreeItemDTO> listMrCaCtmMrResult = new ArrayList<MrtplTreeItemDTO>();

	
		String strsqltpl="select * from (select bd_mrca_ctm.id_mrcactm id_treeitem, "+
		" bd_mrca_ctm.id_mrcactm id_mrcactm, "+				
       "bd_mrca_ctm.name, "+
       "0 mrtpl_count, "+
       "'' id_parent, "+
       "bd_mrca_ctm.name as title, "+
       "bd_mrca_ctm.id_grp id_owngrp, "+
       "bd_mrca_ctm.id_org id_ownorg, "+
       "'~' id_emp, "+
       "'~' id_dept, "+
       "'~' id_mrtp, "+
       " bd_mrca_ctm.sortno sortno, "+
       " '~' code "+
  "from bd_mrca_ctm bd_mrca_ctm "+
" where 1 = 1 and bd_mrca_ctm.ds=0 and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)+
" UNION ALL "+
"select bd_mrca_ctm.id_mrcactm||bd_mrtp.id_mrtp id_treeitem, "+
" bd_mrca_ctm.id_mrcactm id_mrcactm, "+
       "bd_mrtp.name, "+
       "0 mrtpl_count, "+
      " bd_mrca_ctm.id_mrcactm id_parent, "+
       "bd_mrtp.name as title, "+
       "bd_mrca_ctm.id_grp id_owngrp, "+
       "bd_mrca_ctm.id_org id_ownorg, "+
      " '~' id_emp, "+
       "'~' id_dept, "+
       "bd_mrtp.id_mrtp id_mrtp, "+
       " bd_mrca_ctm.sortno sortno, "+
       " bd_mrtp.code code "+
 " from bd_mrtp bd_mrtp "+
 " left join bd_mrca_ctm_itm bd_mrca_ctm_itm "+
 "   on bd_mrca_ctm_itm.id_mrtp = bd_mrtp.id_mrtp "+
 " left join bd_mrca_ctm bd_mrca_ctm "+
 "   on bd_mrca_ctm.id_mrcactm = bd_mrca_ctm_itm.id_mrcactm "+
 "where 1 = 1 and bd_mrca_ctm.ds=0 and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)+
 ") tb order by sortno,code";

		@SuppressWarnings("unchecked")
		List<MrtplTreeItemDTO> listMrCaCtmMrtpl = (List<MrtplTreeItemDTO>) daf.execQuery(
				strsqltpl, new BeanListHandler(MrtplTreeItemDTO.class));
		listMrCaCtmMrResult.addAll(listMrCaCtmMrtpl);
		for(int i=0;i<listMrCaCtmMrResult.size();i++)
		{
			listMrCaCtmMrResult.get(i).setSortno(i+1);
		}
		return listMrCaCtmMrResult.toArray(new MrtplTreeItemDTO[0]);
	}
	

	@Override
	public MrtplTreeItemDTO[] GetMrtplTreeItems2( String code_entp , String id_ownorg , String id_dep , String id_user , String mrtp_name , String id_owngrp ) 
			throws BizException {
		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");
	    

		DAFacade daf = new DAFacade();
		List<MrtplTreeItemDTO> listMrCaCtmMrResult = new ArrayList<MrtplTreeItemDTO>();
		
		
			//" ) tb where tb.code_entp='"+code_entp+"'";
	
		String strsqltpl="select * from (select bd_mrca_ctm.id_mrcactm id_treeitem, "+
				" bd_mrca_ctm.id_mrcactm id_mrcactm, "+				
		       "bd_mrca_ctm.name, "+
		       "0 mrtpl_count, "+
		       "'' id_parent, "+
		       "bd_mrca_ctm.name as title, "+
		       "bd_mrca_ctm.id_grp id_owngrp, "+
		       "bd_mrca_ctm.id_org id_ownorg, "+
		       "'~' id_emp, "+
		       "'~' id_dept, "+
		       "'~' id_mrtp, "+
		       " bd_mrca_ctm.sortno sortno, "+
		       "bd_mrca_ctm.fg_only, "+
		       " '~' code "+
		  "from bd_mrca_ctm bd_mrca_ctm "+
		" where 1 = 1 and bd_mrca_ctm.ds=0 and bd_mrca_ctm.code_entp='"+code_entp+"' and (bd_mrca_ctm.id_dept is null or bd_mrca_ctm.id_dept like '%"+id_dep+"%') and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)+
		" UNION ALL "+
		"select bd_mrca_ctm.id_mrcactm||bd_mrtp.id_mrtp id_treeitem, "+
		" bd_mrca_ctm.id_mrcactm id_mrcactm, "+
		       "bd_mrtp.name, "+
		       "0 mrtpl_count, "+
		      " bd_mrca_ctm.id_mrcactm id_parent, "+
		       "bd_mrtp.name as title, "+
		       "bd_mrca_ctm.id_grp id_owngrp, "+
		       "bd_mrca_ctm.id_org id_ownorg, "+
		      " '~' id_emp, "+
		       "'~' id_dept, "+
		       "bd_mrtp.id_mrtp id_mrtp, "+
		       " bd_mrca_ctm.sortno sortno, "+
		       "bd_mrca_ctm.fg_only, "+
		       " bd_mrtp.code code "+
		 " from bd_mrtp bd_mrtp "+
		 " left join bd_mrca_ctm_itm bd_mrca_ctm_itm "+
		 "   on bd_mrca_ctm_itm.id_mrtp = bd_mrtp.id_mrtp "+
		 " left join bd_mrca_ctm bd_mrca_ctm "+
		 "   on bd_mrca_ctm.id_mrcactm = bd_mrca_ctm_itm.id_mrcactm "+
		 "where 1 = 1 and bd_mrca_ctm.ds=0 and bd_mrca_ctm.code_entp = '"+code_entp+"' and  (bd_mrca_ctm.id_dept is null or bd_mrca_ctm.id_dept like '%"+id_dep+"%') and "+EnvContextUtil.processEnvContext("", new MrCtmCaDO(), false)+
		 ") tb order by sortno,code";
	
		@SuppressWarnings("unchecked")
		List<MrtplTreeItemDTO> listMrCaCtmMrtpl = (List<MrtplTreeItemDTO>) daf.execQuery(
				strsqltpl, new BeanListHandler(MrtplTreeItemDTO.class));
		listMrCaCtmMrResult.addAll(listMrCaCtmMrtpl);
		for(int i=0;i<listMrCaCtmMrResult.size();i++)
		{
			listMrCaCtmMrResult.get(i).setSortno(i+1);
		}
		return listMrCaCtmMrResult.toArray(new MrtplTreeItemDTO[0]);
	}
	
	
	public OrgDO[]  GetOrgs(String pk_group) throws BizException
	{
		if(pk_group!=null){
			
		 String sql= "SELECT * FROM  BD_ORG"
				+"	WHERE Isbizunit = 'Y' and Activestate = '2' and BD_ORG.ID_GRP = '"+pk_group+"' "
				+"  and BD_ORG.ID_org  <> '"+pk_group+"'";
			
			@SuppressWarnings("unchecked")
			List<OrgDO> list= (List<OrgDO>)new DAFacade().execQuery(sql, new BeanListHandler(OrgDO.class));
			return list.toArray(new OrgDO[0]);
		}
		return null;
	}

	
	@Override
	public MrCaCtmMrDTO[] getMrcactmForIP(String id_ent, String code_entp,String docornur,String id_dept) throws BizException {
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
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}
	
	public MrCaCtmMrDTO[] getMrcactmAndScans(String id_ent, String code_entp,String docornur,String id_dept) throws BizException {
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
		String whereSql = "";//医护人员身份
		if("10".equals(docornur))
		{
			whereSql =" AND (bmc.docornur =10 OR bmc.docornur = 30)"; 
		}
		if("20".equals(docornur))
		{
			whereSql=" AND (bmc.docornur =20 OR bmc.docornur = 30)"; 
		} 
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT '%' AS id_mrcactm,");//“全部”节点
		sbSql.append("'all' code,");
		sbSql.append("'全部' name,");
		sbSql.append("'全部' des,");
		sbSql.append("'"+code_entp+"' code_entp,");
		sbSql.append("''  fg_scanmr,");
		sbSql.append("'' id_entp,");
		sbSql.append("0 sortno,");
		sbSql.append("(select COUNT(1)");
		sbSql.append(" from CI_MR cm, bd_mrca_ctm bmc");
		sbSql.append(" WHERE cm.id_mrcactm = bmc.id_mrcactm");
		sbSql.append(" and cm.id_ent = '"+id_ent+"'");
		sbSql.append(" AND bmc.ds = 0");
		sbSql.append(" and bmc.id_org='"+Context.get().getOrgId()+"'");
		sbSql.append(whereSql);
		sbSql.append(" AND bmc.code_entp in ('"+code_entp+"')");
		sbSql.append(" AND bmc.activestate = "+IPubEnumConst.ACTIVESTATE_ENABLE+"");
		sbSql.append(" and cm.ds = 0) as mr_count,");
		sbSql.append("'' code_settp,");
		sbSql.append("0 ds,");
		sbSql.append("to_char(sysdate, 'yyyy-MM-dd HH24:mi:ss') sv,");
		sbSql.append("0 idx");
		sbSql.append(" FROM dual");
		sbSql.append(" UNION ALL");	//组合非扫描病历	
		sbSql.append(" SELECT bmc.id_mrcactm,");
		sbSql.append("bmc.code,");
		sbSql.append("bmc.name,");
		sbSql.append("bmc.des,");
		sbSql.append("bmc.code_entp,");
		sbSql.append("bmc.fg_scanmr,");
		sbSql.append("bmc.id_entp,");
		sbSql.append("bmc.sortno,");
		sbSql.append("(select COUNT(1)");
		sbSql.append(" from CI_MR cm");
		sbSql.append(" WHERE cm.id_mrcactm = bmc.id_mrcactm");
		sbSql.append(" and cm.id_ent = '"+id_ent+"'");
		sbSql.append(" and cm.ds = 0) as mr_count,");
		sbSql.append("bd_set_tp.code code_settp,");
		sbSql.append("bmc.ds,");
		sbSql.append("bmc.sv,");
		sbSql.append("1 idx");
		sbSql.append(" FROM bd_mrca_ctm bmc");
		sbSql.append(" left join bd_set_tp bd_set_tp");
		sbSql.append(" on bd_set_tp.id_setca = bmc.id_setca");
		sbSql.append(" WHERE");
		sbSql.append(" bmc.ds = 0");
		sbSql.append(" and bmc.id_org='"+Context.get().getOrgId()+"'");
		sbSql.append(" and (bmc.fg_scanmr <> 'Y'");
		sbSql.append(whereSql);
		sbSql.append(" AND bmc.activestate = "+IPubEnumConst.ACTIVESTATE_ENABLE +"");
		//sbSql.append(" AND (bmc.id_dept is null or bmc.id_dept = '"+id_dept+"')");
		sbSql.append(" AND (bmc.id_dept is null or (instr(bmc.id_dept, '"+ id_dept +"') > 0))");
		sbSql.append(" AND bmc.code_entp in ('"+code_entp+"'))");
		sbSql.append(" UNION ALL");//组合扫描病历
		sbSql.append(" select  id_mrcactm,code,name,des,code_entp,fg_scanmr,id_entp,sortno,mr_count,code_settp,ds,sv,idx from( ");
		sbSql.append(" SELECT bmc.id_mrcactm,  ");
		sbSql.append("bmc.code,");
		sbSql.append("bmc.name||'【扫描】' name ,");//扫描类型，名称添加【扫描】
		sbSql.append("bmc.des,");
		sbSql.append("bmc.code_entp,");
		sbSql.append("bmc.fg_scanmr,");//使用fg_scanmr区分是否扫描病历
		sbSql.append("bmc.id_entp,");
		sbSql.append("bmc.sortno,     ");
		sbSql.append("(select COUNT(1)");
		sbSql.append(" from ci_mr_mmrecord red");
		sbSql.append(" WHERE red.id_mrcactm = bmc.id_mrcactm");
		sbSql.append(" and red.id_ent = '"+id_ent+"'");
		sbSql.append(" and red.ds = 0) as mr_count,");
		sbSql.append("bd_set_tp.code code_settp,");
		sbSql.append("bmc.ds,");
		sbSql.append("bmc.sv,");
		sbSql.append("2 idx");
		sbSql.append(" FROM bd_mrca_ctm bmc");
		sbSql.append(" left join bd_set_tp bd_set_tp");
		sbSql.append(" on bd_set_tp.id_setca = bmc.id_setca");
		sbSql.append(" WHERE ");
		sbSql.append(" bmc.ds = 0");
		sbSql.append(" and bmc.id_org='"+Context.get().getOrgId()+"'");
		sbSql.append(" and bmc.fg_scanmr = 'Y' ");
		sbSql.append(whereSql);
		sbSql.append(" AND bmc.activestate = "+IPubEnumConst.ACTIVESTATE_ENABLE +"");
		//sbSql.append(" AND (bmc.id_dept is null or bmc.id_dept = '"+id_dept+"')");
		sbSql.append(" AND (bmc.id_dept is null or bmc.id_dept = '~' or  (instr(bmc.id_dept, '"+ id_dept +"') > 0))");
		sbSql.append(" AND bmc.code_entp in ('"+code_entp+"'))");
		sbSql.append(" ORDER BY idx, sortno");
		String strsql = sbSql.toString();
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}
	

	@Override
	public MrCaCtmMrDTO[] getMrcactmForOP(String id_ent, String code_entp,String id_dept) throws BizException {

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
			sbSql.append("SELECT  " );
			sbSql.append("  bmc.id_mrcactm,  " ); 
			sbSql.append("  bmc.code,  " ); 
			sbSql.append("  bmc.name,  " ); 
			sbSql.append("  bmc.des,  " ); 
			sbSql.append("  bmc.sortno,  " ); 
			sbSql.append("  bmc.code_entp,  " ); 
			sbSql.append("  bmc.id_entp,  " ); 
			sbSql.append("  (select COUNT(1)  " ); 
			sbSql.append("FROM bd_mrca_ctm_itm bmci,  " ); 
			sbSql.append("CI_MR cm  " ); 
			sbSql.append("WHERE bmc.id_mrcactm = bmci.id_mrcactm  " ); 
			sbSql.append("AND bmci.id_mrtp = cm.id_mrtp  " ); 
			sbSql.append("AND cm.id_ent = '" + id_ent + "'  " ); 
			sbSql.append("  and cm.ds = 0 ) AS mr_count,  " ); 
			sbSql.append("    bmc.ds,  " ); 
			sbSql.append("bmc.sv  " ); 
			sbSql.append("FROM  " ); 
			sbSql.append("bd_mrca_ctm bmc  " ); 
			sbSql.append("WHERE  " ); 
			sbSql.append("bmc.ds = 0  " ); 
			//sbSql.append("AND bmc.code_entp = '"+ code_entp + "'  " ); //bmc.code_entp in( '30','10')
			sbSql.append("    AND bmc.code_entp in ('" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' " );
			if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){
				sbSql.append(" , '" + code_entp + "'");
			}
			sbSql.append(" )");
			sbSql.append("AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE );
			sbSql.append("             AND (bmc.id_dept is null or   bmc.id_dept like '%" + id_dept +"%') " ); 
			sbSql.append("    ORDER BY sortno;");
			
			String strsql = sbSql.toString();
			
			
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}
	

	@Override
	public MrCaCtmMrDTO[] getMrcactmForHelper(String id_ent, String code_entp,
			Integer hasAll , String docornur) throws BizException {
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
		
			sbSql.append(" SELECT bd_mrca_ctm.id_mrcactm, " ); 
			sbSql.append("        bd_mrca_ctm.code, " ); 
			sbSql.append("        bd_mrca_ctm.name, " ); 
			sbSql.append("        bd_mrca_ctm.des, " ); 
			sbSql.append("  bd_mrca_ctm.code_entp,  " ); 
			sbSql.append("  bd_mrca_ctm.id_entp,  " ); 
			sbSql.append("                 bd_mrca_ctm.sortno, " ); 
			sbSql.append("                 (select COUNT(1) " ); 
//			sbSql.append("            from bd_mrca_ctm_itm bmci, CI_MR cm " ); 
//			sbSql.append("           WHERE bd_mrca_ctm.id_mrcactm = bmci.id_mrcactm " ); 
//			sbSql.append("             and bmci.id_mrtp = cm.id_mrtp " ); 
			sbSql.append("            from  CI_MR cm " ); 
			sbSql.append("           WHERE bd_mrca_ctm.id_mrcactm = cm.id_mrcactm " ); 
			//sbSql.append("             and bmci.id_mrtp = cm.id_mrtp " ); 
			sbSql.append("             and cm.id_ent = '"+ id_ent + "' " ); 
			sbSql.append(" and cm.code_entp = '" + code_entp + "' ");
			//sbSql.append(" and cm.sd_su_mr <> '00' ");//新增的数据不显示
			sbSql.append("             and cm.ds = 0 ) as mr_count, " ); 
			sbSql.append("              bd_mrca_ctm.ds, bd_mrca_ctm.sv " ); 
			sbSql.append("               FROM bd_mrca_ctm bd_mrca_ctm " ); 
			sbSql.append("           WHERE bd_mrca_ctm.ds = 0 and bd_mrca_ctm.id_org='"+Context.get().getOrgId()+"' "); 
			if("10".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =10 OR bd_mrca_ctm.docornur = 30) " ); 
			}
			if("20".equals(docornur))
			{
				sbSql.append(" AND (bd_mrca_ctm.docornur =20 OR bd_mrca_ctm.docornur = 30) " ); 
			}
			sbSql.append("             AND bd_mrca_ctm.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE +" " ); 
			sbSql.append("              AND bd_mrca_ctm.code_entp in ( '" ).append(code_entp).append( "')");
			sbSql.append("          ORDER BY sortno");
		
		
		strsql = sbSql.toString();
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}
	

	@Override
	public MrCaCtmMrDTO[] getMrcactmForPast(String id_ent, String code_entp,
			Integer hasAll , String docornur) throws BizException {
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
			sbSql.append("FROM   " ); 
			sbSql.append("CI_MR cm  " ); 
			sbSql.append("WHERE cm.id_mrcactm = bd_mrca_ctm.id_mrcactm  " ); 
			sbSql.append("AND cm.id_ent = '" + id_ent + "'  " ); 
			sbSql.append("  and cm.ds = 0 ) AS mr_count,  " ); 
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
			sbSql.append("             and cm.id_ent = '"+ id_ent + "' " ); 
			//sbSql.append(" and cm.sd_su_mr <> '00' ");//新增的数据不显示在既往病历中
			sbSql.append("             and cm.ds = 0 ) as mr_count, " ); 
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
			sbSql.append(" ) ");
			sbSql.append("          ORDER BY sortno;");
			
		}
		strsql = sbSql.toString();
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}


	@Override
	public MrCaCtmMrDTO[] getMrcactmForNur(String id_ent, String code_entp)
			throws BizException {
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
			sbSql.append("SELECT  " );
			sbSql.append("  bmc.id_mrcactm,  " ); 
			sbSql.append("  bmc.code,  " ); 
			sbSql.append("  bmc.name,  " ); 
			sbSql.append("  bmc.des,  " ); 
			sbSql.append("  bmc.sortno,  " ); 
			sbSql.append("  bmc.code_entp,  " ); 
			sbSql.append("  bmc.id_entp,  " ); 
			sbSql.append("  (select COUNT(1)  " ); 
			sbSql.append("FROM bd_mrca_ctm_itm bmci,  " ); 
			sbSql.append("CI_MR cm  " ); 
			sbSql.append("WHERE bmc.id_mrcactm = bmci.id_mrcactm  " ); 
			sbSql.append("AND bmci.id_mrtp = cm.id_mrtp  " ); 
			sbSql.append("AND cm.id_ent = '" + id_ent + "'  " ); 
			sbSql.append("  and cm.ds = 0 ) AS mr_count,  " ); 
			sbSql.append("    bmc.ds,  " ); 
			sbSql.append("bmc.sv  " ); 
			sbSql.append("FROM  " ); 
			sbSql.append("bd_mrca_ctm bmc  " ); 
			sbSql.append("WHERE  " ); 
			sbSql.append("bmc.ds = 0  " ); 
			//sbSql.append("AND bmc.code_entp = '"+ code_entp + "'  " ); //bmc.code_entp in( '30','10')
			sbSql.append("    AND bmc.code_entp in ('" + code_entp + "' " );
			if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){
				sbSql.append(" , '" + code_entp + "'");
			}
//			DoctorNur a = IBdFcDictCodeConst.DoctorNur.doctor;
//			String aa = a.getCode();
			sbSql.append(" )");
			sbSql.append(" AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE );
			sbSql.append(" AND bmc.docornur in ('" + IBdFcDictCodeConst.DoctorNur.doctorNur.getCode() + "','" + IBdFcDictCodeConst.DoctorNur.nur.getCode() + "')" );
			sbSql.append("    ORDER BY sortno;");
			
			String strsql = sbSql.toString();
			
			
		@SuppressWarnings("unchecked")
		List<MrCaCtmMrDTO> listMrCaCtmMr = (List<MrCaCtmMrDTO>) daf.execQuery(
				strsql, new BeanListHandler(MrCaCtmMrDTO.class));

		return listMrCaCtmMr.toArray(new MrCaCtmMrDTO[0]);
	}

	/**
	 * 根据传入的id获取到医疗记录类型自定义分类
	 * @throws BizException 
	 */
	@Override
	public MrDTO[] GetMrcactmByIdmrcactm(String Id_mrcactm , String Id_mrtp) throws BizException {
		if (Id_mrcactm == null || Id_mrcactm.equals(""))
			throw new BizException("医疗记录类型自定义分类主键不能为空");
		DAFacade daf = new DAFacade();
		StringBuilder sbSql = new StringBuilder();
		
		sbSql.append("select ctm.id_mrcactm as id_mrcactm , ctm.name as Mrcactm_name,mrtp.id_mrtp as id_mrtp"
				+ " , mrtp.name as Mrtp_name  ");
		sbSql.append("  from bd_mrca_ctm ctm , bd_mrca_ctm_itm itm , bd_mrtp mrtp  ");
		sbSql.append("  where ctm.id_mrcactm = itm.id_mrcactm and mrtp.id_mrtp = itm.id_mrtp   ");
		sbSql.append("  and itm.id_mrcactm = '" + Id_mrcactm+ "'");
		if(!StringUtils.isBlank(Id_mrtp)){
			sbSql.append("  and itm.id_mrtp = '" + Id_mrtp + "'  ");
		}
		
		String strsql = sbSql.toString();
		
		@SuppressWarnings("unchecked")
		List<MrDTO> listMrCaCtmMr = (List<MrDTO>) daf.execQuery(strsql,
				new BeanListHandler(MrDTO.class));

		return listMrCaCtmMr.toArray(new MrDTO[0]);
	}

	@Override
	public MrTpDO getMrtpForAddView(String id_set) throws BizException {
		// TODO Auto-generated method stub
		IDesetMDORService bdsetService=ServiceFinder.find(IDesetMDORService.class);
		DeDataSetDO[] setDoArr=bdsetService.find(" code = '"+IMrPubConst.DS_SCBC+"'", "", FBoolean.FALSE);
		if(setDoArr.length<0) return new MrTpDO();
		DeDataSetDO bdSetDo=setDoArr[0];
		IEmrtypeRService epService =ServiceFinder.find(IEmrtypeRService.class);
		MrTpDO[] tplDoArr=epService.find(" id_data_set = '"+bdSetDo.getId_set()+"' ", "", FBoolean.FALSE);
		//if(tplDoArr.length<0) return new MrTpDO();
		MrTpDO tplDo=new MrTpDO();
		if(tplDoArr!=null && tplDoArr.length>0){
		tplDo=tplDoArr[0];
		}
		return tplDo;
	}

	
}