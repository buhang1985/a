package iih.ci.ord.s.bp.specant;


import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.specanti.d.SpecantionApplyDTO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 特殊级抗菌药申请界  新增数据  查询默认值
 * @author gh
 *
 */
public class SpecAntiConsApplyNewQryBP {

	public SpecantionApplyDTO exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		String sql = getSql(id_or); 
		@SuppressWarnings("unchecked")
		ArrayList<SpecantionApplyDTO> result = (ArrayList<SpecantionApplyDTO>) new DAFacade()
				.execQuery(sql, new BeanListHandler(SpecantionApplyDTO.class));
		if(result!=null&&result.size()>0){
			SpecantionApplyDTO dto  = result.get(0);
			//查询诊断拼接  
			ICiOrdQryService sevice = (ICiOrdQryService)ServiceFinder.find(ICiOrdQryService.class);
			String[] arr =  sevice.getDiagArray(dto.getId_ent());
			if(!StringUtils.isBlank(arr[2])) {
				dto.setStr_id_diitm (arr[2].replace("&", ","));
			}
	        if(!StringUtils.isBlank(arr[1])) {
	        	dto.setStr_code_diitm (arr[1]);
	        }
	        if(!StringUtils.isBlank(arr[0])) {
				dto.setStr_name_diitm (arr[0].replace("&", ","));
	        }
			//主诊断
	        if(!StringUtils.isBlank(arr[4])) {
	        	dto.setName_didef(arr[4]);	        
		    }
            if(!StringUtils.isBlank(arr[3])) {
			dto.setId_didef(arr[3]);
            }
			//查询过敏史
			IPiPatAlDORService patAlService = (IPiPatAlDORService)ServiceFinder.find(IPiPatAlDORService.class);
			PiPatAlDO[] pal = patAlService.findByAttrValString("Id_pat", dto.getId_pat());
			if(pal!=null&&pal.length>0){
				String al= "";
				
				for(PiPatAlDO aldo:pal){
					al+=aldo.getName_alcla()+",";
				}
				dto.setDes_sympsign(al.substring(0, al.length()-1));
			}
			dto.setDes_sympsign(clinicalzztzFrom(dto.getId_ent())); //病情描述-基本情况--感染情况
			return result.get(0);
		}
		
		return null;
	}
	
	private String getSql(String id_or){
		StringBuffer sql  = new StringBuffer();
		sql.append("select ci_order.id_or            id_or,                       ");
		sql.append("       ci_order.id_srv           id_orsrv,                    ");
		sql.append("       ci_order.Id_en            id_ent,                      ");
		sql.append("       ci_order.Id_pat           Id_pat,                      ");
		sql.append("       pi_pat.name               Name_pat,                    ");
		sql.append("       bd_dep.name               Name_dep_phy,                ");
		sql.append("       en_ent_ip.name_bed        Bed_no,                      ");
		sql.append("       en_ent_ip.code_amr_ip     Code_amr_ip,                 ");
		sql.append("       ci_or_srv.name            Type_apspe,                  ");
		sql.append("       bd_psndoc.name            Name_emp,                    ");
		sql.append("       bd_psndoc.id_emptitle     Id_emp_title,                ");
		sql.append("       emp_title.name            Name_emp_title,              ");
		sql.append("       ci_or_srv.fg_propc        Des_feasons                  ");//用药目的-
		sql.append(" 	from ci_order ci_order                              	  ");
		sql.append(" 	left join ci_ap_spec_anti_cons cons                       ");
		sql.append(" 	  on ci_order.id_or = cons.id_or                          ");
		sql.append(" 	left join ci_ap_spec_anti_invites invites                 ");
		sql.append(" 	  on invites.id_apspecanticons = cons.id_apspecanticons   ");
		sql.append(" 	left join ci_or_srv ci_or_srv                             ");
		sql.append(" 	  on ci_or_srv.id_or = ci_order.id_or                     ");
		sql.append(" 	left join pi_pat pi_pat                                   ");
		sql.append(" 	  on pi_pat.id_pat = ci_order.id_pat                      ");
		sql.append(" 	left join en_ent en_ent                                   ");
		sql.append(" 	  on ci_order.id_en = en_ent.id_ent                       ");
		sql.append(" 	left join en_ent_ip en_ent_ip                             ");
		sql.append(" 	  on ci_order.Id_en = en_ent_ip.Id_ent                    ");
		sql.append(" 	left join bd_dep bd_dep                                   ");
		sql.append(" 	  on bd_dep.id_dep = en_ent.id_dep_phy                    ");
		sql.append(" 	left join bd_psndoc bd_psndoc                             ");
		sql.append(" 	  on ci_order.id_emp_or = bd_psndoc.id_psndoc             ");
		sql.append(" 	left join bd_udidoc emp_title                             ");
		sql.append(" 	  on emp_title.id_udidoc = bd_psndoc.id_emptitle          ");
		sql.append("    left join ci_or_srv_mm mm on mm.id_orsrv=ci_or_srv.id_orsrv ");
		if(StringUtils.isNotBlank(id_or)){
			sql.append(" 	where ci_or_srv.id_orsrv = '"+id_or+"' and mm.sd_anti='3' ");
		}
		return sql.toString();
	}
	 /**
		 * 临床体征拼接字符串
		 * 
		 * @param id_ent
		 * @return
		 * @throws BizException
		 */
		public String clinicalzztzFrom(String id_ent) throws BizException {
			// 临床症状和体征
			StringBuffer clinialBuffer = null;

			IMrdocrefvalueRService mrdocservice = ServiceFinder.find(IMrdocrefvalueRService.class);
			String sql = String.format("id_ent='%s' and code_element in ('%s','%s','%s')", id_ent,
					ICiDictCodeConst.CODE_ELEMENT_MAINSUIT, ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE,
					ICiDictCodeConst.CODE_ELEMENT_TEST);

			MrDocRefValueDO[] szMrDocRefValueDO = mrdocservice.find(sql, "", FBoolean.FALSE);
			if (szMrDocRefValueDO != null && szMrDocRefValueDO.length > 0) {
				clinialBuffer = new StringBuffer();
				MrDocRefValueDO itemMainSuit = null, itemNowDise = null, itemTest = null;
				for (MrDocRefValueDO o : szMrDocRefValueDO) {
					// 主诉
					if (itemMainSuit == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_MAINSUIT)) {
						itemMainSuit = o;
					}
					// 现病史
					if (itemNowDise == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE)) {
						itemNowDise = o;
					}
					// 体格检查
					if (itemTest == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_TEST)) {
						itemTest = o;
					}
				}
				if (itemMainSuit != null && !CiOrdUtils.isEmpty(itemMainSuit.getContent())) {
					clinialBuffer.append("以" + itemMainSuit.getContent() + "之主诉就诊。").append(System.lineSeparator());
				}

				if (itemNowDise != null && !CiOrdUtils.isEmpty(itemNowDise.getContent())) {
					clinialBuffer.append(itemNowDise.getContent()).append(System.lineSeparator());
				}

				if (itemTest != null && !CiOrdUtils.isEmpty(itemTest.getContent())) {
					clinialBuffer.append(itemTest.getContent());
				}
				return clinialBuffer.toString();
			}
			return null;
		}
}
