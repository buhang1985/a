package iih.ci.rcm.hospitalsenmonitordto.s;

import java.util.List;

import iih.ci.rcm.hospitalreport.d.HospitalReportDO;
import iih.ci.rcm.hospitalreport.i.IHospitalreportRService;
import iih.ci.rcm.hospitalsenmonitordto.d.HospitalSenMonitorDTO;
import iih.ci.rcm.hospitalsenmonitordto.i.IHospitalSenMonitor;
import iih.ci.rcm.hosreminder.s.bp.HosReminderMsgBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = {IHospitalSenMonitor.class}, binding = Binding.JSONRPC)
public class IHospitalSenMonitorImpl extends PagingServiceImpl<HospitalSenMonitorDTO> implements IHospitalSenMonitor{
	
		@Override
		public PagingRtnData<HospitalSenMonitorDTO> getHospitalSenMonitorList(QryRootNodeDTO qryRootNodeDTO,
				PaginationInfo paginationInfo) throws BizException {
			IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
			String sqlwhere = "1=1";
			if (qryRootNodeDTO != null) {
				sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
			}
			
			int index_begain = sqlwhere.indexOf("%");
			int index_end = sqlwhere.indexOf("%",index_begain+1);
			String str="";
			String str1="";
			String str2="";
			if(index_begain!=-1 && index_end !=-1)
				str= sqlwhere.substring(index_begain+1,index_end);
			
			if(str.contains(">")){
				 int index=str.indexOf(">");
				 str1=str.substring(0,index);
				 str2=str.substring(index+1,str.length());
				 sqlwhere=str1+str2;
			}
			
			String a=null;  String b="0";
			String a2=null; String b2="0";
			String a3=null; 
			String a4=null; String b4="0";
			
			if(!str.isEmpty() && !str1.isEmpty() && !str2.isEmpty()){
				a=a2=a3=a4=str1;
				b=b2=b4=str2;
				if("体温".equals(str1))
					b=b2=b4="38";			
			}else if(!str.isEmpty() && str1.isEmpty() && str2.isEmpty()){
				a=a2=a3=a4=str;
			}else{
				a="超敏C反应蛋白";  b="8.5";
				a2="降钙素原"; b2="0.5";
				a4="体温"; b4="38";
			}
			
			
			StringBuilder sb = new StringBuilder();
		
			sb.append(" select *   ");
			sb.append("   from (select distinct  dep.id_dep            as id_dept,");
			sb.append("                          dep.code              as code_dept,");
			sb.append("                          dep.name              as name_dept,");
			sb.append("                          ENT_IP.id_bed         as id_bed,");
			sb.append("                          ENT_IP.Name_Bed       as name_bed,");
			sb.append("                          ENT_IP.Code_Amr_Ip    as code_amr_ip,");
			sb.append(" 						 ent.id_ent            as id_ent,");
			sb.append(" 						 ent.code_entp         as code_entp,");
			sb.append(" 						 ent.id_pat            as id_pat,");
			sb.append("                          ent.name_pat          as name_pat,");
			sb.append("                          ent.dt_birth_pat      as dt_birth,");
			sb.append("                          UDIDOC1.Name          as name_sex,");
			sb.append("                          doc.id_psndoc         as id_doc,");
			sb.append("                          doc.code              as code_doc,");
			sb.append("                          doc.name              as name_doc,");
			sb.append("                          ent.dt_insert         as dt_insert,");
			sb.append("                          ent.dt_end            as dt_end,");
			sb.append("                          lab_itm.name_srv      as name_srv,");
			sb.append("                          lab_itm.val_rstrptlab as val_rstrptlab,");
			sb.append("                          lab.dt_rptlab         as dt_rptlab");
			sb.append("           from en_ent_ip ENT_IP");
			sb.append("          inner join en_ent ent");
			sb.append("             on ent.id_ent = ent_ip.id_ent ");
			sb.append("          inner join bd_udidoc UDIDOC1");
			sb.append("             on UDIDOC1.Id_Udidoc = ent.id_sex_pat");
			sb.append("           left join BD_DEP dep");
			sb.append("             on dep.ID_DEP = ent.id_dep_phy");
			sb.append("          inner join bd_psndoc doc");
			sb.append("             on doc.Id_Psndoc = ent.id_emp_phy");
			sb.append("          inner join ci_rpt_lab lab");
			sb.append("             on lab.id_ent = ent_ip.id_ent");
			sb.append("          inner join ci_rpt_lab_itm lab_itm");
			sb.append("             on lab.id_rptlab = lab_itm.id_rptlab");
			sb.append("          where ( lab_itm.name_srv = '"+a+"'");
			sb.append("            and lab_itm.val_rstrptlab > "+b+")");
			sb.append("            or   ( lab_itm.name_srv = '"+a2+"'");
			sb.append("            and lab_itm.val_rstrptlab > "+b2+")");
			sb.append("         union");
			sb.append("         select distinct  dep.id_dep            as id_dept,");
			sb.append("                          dep.code              as code_dept,");
			sb.append("                          dep.name              as name_dept,");
			sb.append("                          ENT_IP.id_bed         as id_bed,");
			sb.append("                          ENT_IP.Name_Bed       as name_bed,");
			sb.append("                          ENT_IP.Code_Amr_Ip    as code_amr_ip,");
			sb.append("                          ent.id_ent            as id_ent,");
			sb.append(" 						 ent.code_entp         as code_entp,");
			sb.append("                          ent.id_pat            as id_pat,");
			sb.append("                          ent.name_pat          as name_pat,");
			sb.append("                          ent.dt_birth_pat      as dt_birth,");
			sb.append("                          UDIDOC1.Name          as name_sex, ");
			sb.append("                          doc.id_psndoc         as id_doc,");
			sb.append("                          doc.code              as code_doc,");
			sb.append("                          doc.name              as name_doc,");
			sb.append("                          ent.dt_insert         as dt_insert,");
			sb.append("                          ent.dt_end            as dt_end,");
			sb.append("                          ord.content_or        as name_srv,");
			sb.append("                          '有'                  as val_rstrptlab,");
			sb.append("                          lab.dt_rptlab         as dt_rptlab");
			sb.append("           from en_ent_ip ENT_IP");
			sb.append("          inner join en_ent ent");
			sb.append("             on ent.id_ent = ent_ip.id_ent");
			sb.append("          inner join bd_udidoc UDIDOC1");
			sb.append("             on UDIDOC1.Id_Udidoc = ent.id_sex_pat");
			sb.append("           left join BD_DEP dep");
			sb.append("             on dep.ID_DEP = ent.id_dep_phy");
			sb.append("          inner join bd_psndoc doc");
			sb.append("             on doc.id_psndoc = ent.id_emp_phy");
			sb.append("          inner join ci_order ord");
			sb.append("             on ord.id_pat = ent.id_pat");
			sb.append("            and ord.content_or like '%"+a3+"%'");
			sb.append("            and ord.fg_canc = 'N'");
			sb.append("          inner join ci_rpt_lab lab");
			sb.append("             on lab.id_or = ord.id_or");
			sb.append("         union");
			sb.append("         select distinct  dep.id_dep            as id_dept,");
			sb.append("                          dep.code              as code_dept,");
			sb.append("                          dep.name              as name_dept,");
			sb.append("                          ENT_IP.id_bed         as id_bed,");
			sb.append("                          ENT_IP.Name_Bed       as name_bed,");
			sb.append("                          ENT_IP.Code_Amr_Ip    as code_amr_ip,");
			sb.append("                          ent.id_ent            as id_ent,");
			sb.append(" 						 ent.code_entp         as code_entp,");
			sb.append("                          ent.id_pat            as id_pat,");
			sb.append("                          ent.name_pat          as name_pat,");
			sb.append("                          ent.dt_birth_pat      as dt_birth,");
			sb.append("                          UDIDOC1.Name          as name_sex,");
			sb.append("                          doc.id_psndoc         as id_doc,");
			sb.append("                          doc.code              as code_doc,");
			sb.append("                          doc.name              as name_doc,");
			sb.append("                          ent.dt_insert         as dt_insert,");
			sb.append("                          ent.dt_end            as dt_end,");
			sb.append("                          ci_itm.name           as name_srv,");
			sb.append("                          ci_itm.value          as val_rstrptlab,");
			sb.append("                          ci.dt_vt              as dt_rptlab");
			sb.append("           from en_ent_ip  ENT_IP");
			sb.append("          inner join en_ent ent");
			sb.append("             on ent.id_ent = ent_ip.id_ent");
			sb.append("          inner join bd_udidoc UDIDOC1");
			sb.append("             on UDIDOC1.Id_Udidoc = ent.id_sex_pat");
			sb.append("           left join BD_DEP dep");
			sb.append("             on dep.ID_DEP = ent.id_dep_phy");
			sb.append("          inner join bd_psndoc doc");
			sb.append("             on doc.id_psndoc = ent.id_emp_phy");
			sb.append("          inner join ci_mr_vs ci");
			sb.append("             on ci.id_ent = ent_ip.id_ent");
			sb.append("          inner join ci_mr_vs_itm ci_itm");
			sb.append("             on ci.id_mr_vs = ci_itm.id_mr_vs");
			sb.append("            and ci_itm.name = '"+a4+"'");
			sb.append("            and ci_itm.value > "+b4+")");
			//sb.append("         where "+sqlwhere );
			sb.append("  order by name_dept, dt_insert, name_bed" );
			
		
			PagingRtnData<HospitalSenMonitorDTO> pagingRtnData = super.findByPageInfo(new HospitalSenMonitorDTO(), paginationInfo, sb.toString(), "", null);
			
			IHospitalreportRService reportservice= ServiceFinder.find(IHospitalreportRService.class);
			List<HospitalSenMonitorDTO> data=pagingRtnData.getPageData();
			for(HospitalSenMonitorDTO  dto : data){
				HospitalReportDO[] reportDos=reportservice.find("id_ent='"+dto.getId_ent()+"'", "", FBoolean.FALSE);
			    if(reportDos!=null && reportDos.length>0){
			    	dto.setDef1("有");
			    }else{
			    	dto.setDef1("无");
			    }
			}
			
			return pagingRtnData;
		}
		
		public void sendHosReminderMsg(HospitalSenMonitorDTO senMonitorDto) throws BizException{
			HosReminderMsgBP bp=new HosReminderMsgBP();
			bp.sendHosReminderMsg(senMonitorDto);
		}
 }

