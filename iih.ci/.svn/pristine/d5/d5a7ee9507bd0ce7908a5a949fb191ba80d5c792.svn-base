package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.dto.consdto.d.OrdConsDTO;
import iih.ci.ord.dto.patdetaildto.d.PatDetailDTO;
import iih.ci.ord.s.bp.qry.GetConsDTOQry;
import iih.ci.ord.s.bp.qry.GetInviteDTOQry;
import iih.ci.ord.specanti.d.SpeConsRstType;
import iih.ci.ord.specanti.d.SpecantionApplyDTO;
import iih.ci.ord.speconsqrydto.d.SpeConsEnumType;
import iih.ci.ord.speconsqrydto.d.SpeconsQryDTO;
import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.ci.ord.pub.CiOrdUtils;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetInviteDTOListBP {

//	public EmsConsItemDO[] getConsList(String id_dep,String su_cons) throws BizException{
////		if(StringUtils.isBlank(id_dep) || StringUtils.isBlank(su_cons))return null;
////		GetConsDTOQry qry=new GetConsDTOQry(id_dep,su_cons);
////		DAFacade cade = new DAFacade();
////		List<EmsConsItemDO> cons = (List<EmsConsItemDO>) cade.execQuery(qry.getQrySQLStr(),new BeanListHandler(EmsConsItemDO.class));
////		return cons.toArray(new EmsConsItemDO[0]);
//		return null;
//	}
	/*
	public OrdConsDTO[] GetInviteList(String id_dep ,String str) throws DAException {
		if (StringUtils.isEmpty(id_dep) || StringUtils.isEmpty(str))
			return null;
		String sql = getSql(id_dep,str);

		@SuppressWarnings("unchecked")
		ArrayList<OrdConsDTO> result = (ArrayList<OrdConsDTO>) new DAFacade().execQuery(sql,
				new BeanListHandler(OrdConsDTO.class));

		return result.toArray(new OrdConsDTO[0]);
	}*/

	
	public OrdConsDTO[] GetInviteList(String id_dep ,String str)throws BizException{
		if(StringUtils.isBlank(str)) return null;
		GetInviteDTOQry qry=new GetInviteDTOQry(id_dep,str);
		DAFacade cade = new DAFacade();
		List<OrdConsDTO> cons = (List<OrdConsDTO>) cade.execQuery(qry.getQrySQLStr(),new BeanListHandler(OrdConsDTO.class));
		return cons.toArray(new OrdConsDTO[0]);
	}
	
	/*public OrdConsDTO[] GetInviteList(String id_dep ,String str)throws BizException{
		if(StringUtils.isBlank(str)) return null;
		GetConsDTOQry qry=new GetConsDTOQry(id_dep,str);
		DAFacade cade = new DAFacade();
		List<OrdConsDTO> cons = (List<OrdConsDTO>) cade.execQuery(qry.getQrySQLStr(),new BeanListHandler(OrdConsDTO.class));
		return cons.toArray(new OrdConsDTO[0]);
	}*/
	
	
	public PatDetailDTO getConsPatDetail(String id_en)throws BizException{
		if(StringUtils.isBlank(id_en)) return null;
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		if(qryService==null)return null;
		IpDetailDTO patDto=qryService.getIpDetailInfo(id_en);
		PatDetailDTO consPatDto=new PatDetailDTO();
		consPatDto.setId_ent(id_en);
		consPatDto.setId_pat(patDto.getId_pat());		
		consPatDto.setName_pat(patDto.getName_pat()); 	
		consPatDto.setSex_pat(patDto.getName_sex_pat());		
		consPatDto.setTel(patDto.getTel());			 
		consPatDto.setName_nation(patDto.getName_nation());	
		consPatDto.setName_patcret	(patDto.getName_patcret()); 
		consPatDto.setName_hp(patDto.getName_hp());
		String address="";
		if(!CiOrdUtils.isEmpty(patDto.getFullname_admdiv()) && !patDto.getFullname_admdiv().equals("null")){
			address+=patDto.getFullname_admdiv();
		}
		if(!CiOrdUtils.isEmpty(patDto.getAddr_pat()) && !patDto.getAddr_pat().equals("null")){
			address+=patDto.getAddr_pat();
		}
		consPatDto.setAddr_pat(address);
		consPatDto.setName_didef_dis(patDto.getName_didef_dis());
		consPatDto.setName_dep_phy(patDto.getName_dep_phy());	  
		consPatDto.setName_dep_nur(patDto.getName_dep_nur());	 
		consPatDto.setName_bed(patDto.getName_bed());		 
		consPatDto.setName_emp_phy(patDto.getName_emp_phy());	 
		consPatDto.setPat_age(AgeCalcUtil.getAge(patDto.getDt_birth()));		
		consPatDto.setName_idcardtp(patDto.getName_idtp());
		consPatDto.setName_idcard(patDto.getId_code());   
		consPatDto.setCode_entp(patDto.getCode_entp());

		
		return consPatDto;
	}
	
	
	/*private String getSql(String id_dep,String str) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT t2.id_apcons,t112.name yqks,t2.fg_urgent, "); // 申请单号
		sql.append("  t2.dt_plan,t2.sd_su_cons,t3.dt_entry,t3.id_en,t4.name_pat, "); // 患者姓名
		sql.append("  t4.code code_en,t5.name name_su_cons, "); // 患者科室
		sql.append(" t8.NAME AS Emp_name,t12.name_bed pat_bedno,t13.fg_emptitlelimit, "); // 就诊号
		sql.append("  t13.id_emptitle,t13.sd_emptitle,t13.fg_inorg "); // 药物
		sql.append(" FROM ci_invite_cons t1  "); // 住院号
		sql.append(" LEFT OUTER JOIN ci_ap_cons t2n ON t1.id_apcons = t2.id_apcons  "); // 病床
		sql.append("LEFT OUTER JOIN ci_order t3 ON t2.id_or = t3.id_or  "); // 诊断
		sql.append(" LEFT OUTER JOIN en_ent t4 ON t3.id_en = t4.id_ent "); // 申请医生
		sql.append(" LEFT OUTER JOIN bd_udidoc t5 ON t2.id_su_cons = t5.id_udidoc "); // 创建时间
		sql.append(" LEFT OUTER JOIN bd_dep t6 ON t3.id_dep_or = t6.id_dep  ");
		sql.append(" left join bd_dep t112 on t1.id_dep=t112.id_dep ");
		sql.append(" LEFT OUTER JOIN en_ent_ip t11 ON t3.id_en = t11.id_ent ");
		sql.append(" LEFT OUTER JOIN en_ent_bed t12 ON t11.id_bed = t12.id_bed ");
		sql.append(" LEFT OUTER JOIN bd_srv_cons t13 ON t3.id_srv = t13.id_srv ");
		sql.append(" LEFT OUTER JOIN bd_psndoc t8 ON t8.ID_PSNDOC    = t1.ID_EMP ");

		sql.append(" where ORD.code_entp ='10'");// 开发测试条件
		sql.append("   and bd_srv_drug.sd_anti = '"+IBdMmDictCodeConst.SD_ANTI_SPECIAL+"'  "); //特殊级抗菌药code
	    sql.append(getWherePart(speconsQryDTO));

		return sql.toString();
	}*/

	/**
	 * 获得查询过滤条件  
	 *  Yes 是否审核
	 * @param speconsQryDTO
	 * @return
	 */
	private String getWherePart(SpeconsQryDTO speconsQryDTO) {
		StringBuffer sql = new StringBuffer();
		if (speconsQryDTO.getDt_cons_app() != null) {
			sql.append(" and CON.dt_cons_app >= '" + speconsQryDTO.getDt_cons_app() + "'");
		}
		if (speconsQryDTO.getDt_end() != null) {
			sql.append(" and CON.dt_cons_app <= '" + speconsQryDTO.getDt_end() + "'");
		}
		
		// 专家会诊
		if (SpeConsEnumType.SPECONSEXPERT.equals(speconsQryDTO.getConsenum())) {
			// 会诊受邀人为当前登录人
			sql.append(" and invit.id_emp='" + speconsQryDTO.getId_emp_cons() + "'");
			
		  if("Yes".equals(speconsQryDTO.getCons_sh())){
			// 专家已审批
			sql.append(" and CON.sd_approve_emp is not null ");
		  }else{
			// 专家未审批
			sql.append(" and CON.sd_approve_emp is null ");
		  }
		
		} else if (SpeConsEnumType.SPECONSMSS.equals(speconsQryDTO.getConsenum())) {
			// 医务科会诊同意
			sql.append(" and CON.sd_approve_emp ='" + SpeConsRstType.SPECONSD_AGREE + "' ");
			  
			  if ("Yes".equals(speconsQryDTO.getCons_sh())){
			  // 医务科已审批
			  sql.append(" and CON.sd_approve_meddep is not null ");
			  }else{
			  // 医务科未审批
			  sql.append(" and CON.sd_approve_meddep is null ");	
			  
			}
			  //按时间倒序排序
			  sql.append(" ORDER BY CON.DT_CONS_APP desc ");	
		}else if(SpeConsEnumType.SPECONSDEPT.equals(speconsQryDTO.getConsenum())){
			sql.append(" and 1!=1 ");
		}
		return sql.toString();
	}
	
}
