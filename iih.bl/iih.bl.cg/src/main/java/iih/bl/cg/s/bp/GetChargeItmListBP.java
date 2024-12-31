package iih.bl.cg.s.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.dto.d.ChargeItmDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取收费项目集合
 * @author li_pengying
 *
 */
public class GetChargeItmListBP {
	/**
	 * 获取收费项目集合	 
	 * @param entpCode 就诊类型编码
	 * @param orIds 医嘱ID集合
	 * @return 收费项目DTO集合
	 * @throws BizException
	 * @author
	 */
	public ChargeItmDTO[] exec(String entpCode,String[] orIds) throws BizException{
		//参数校验
		if (ArrayUtil.isEmpty(orIds)) {
			return null;
		}
			
		//根据就诊类型，获取收费项目，门急诊
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entpCode)
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(entpCode))
		{
			StringBuffer sb=new StringBuffer();
			 sb.append("select cgitm.id_srv,cgitm.code_srv,cgitm.name_srv, st.code_st,cgitm.id_or,");
		     sb.append("cgitm.price,cgitm.price_ratio,cgitm.quan,cgitm.amt_ratio,cgitm.amt,");
		     sb.append("payoep.id_emp_pay as id_emp_st ,psn.code as code_emp_st ,psn.name as name_emp_st,");
		     sb.append("orsrv.sd_su_bl as status_st,doc.name as name_statusst, payoep.dt_pay as dt_st    ");
		     sb.append("from  bl_cg_itm_oep cgitm  ");
		     sb.append("inner join ci_or_srv  orsrv on cgitm.id_orsrv = orsrv.id_orsrv  and cgitm.id_or = orsrv.id_or ");
		     sb.append("inner join bl_st_oep st on cgitm.id_stoep = st.id_stoep  ");
		     sb.append("inner join bl_pay_pat_oep  payoep on st.id_paypatoep = payoep.id_paypatoep ");
		     sb.append("inner join bd_psndoc  psn on  payoep.id_emp_pay = psn.id_psndoc  ");
		     sb.append("inner join bd_udidoc doc on orsrv.sd_su_bl= doc.code ");
		     sb.append("where  doc.id_udidoclist='@@@@ZZ2000000000005S'and  orsrv.sd_su_bl ='1'     ");
		     sb.append(" and " + SqlUtils.getInSqlByIds("cgitm.id_or", orIds) +" order by dt_st desc " );
		     sb.append("");
		  	@SuppressWarnings("unchecked")
			List<ChargeItmDTO> list= (List<ChargeItmDTO>)new DAFacade().execQuery(sb.toString(),new BeanListHandler(ChargeItmDTO.class));
			 if(!(list.isEmpty())&&list.size()>0){
				 ChargeItmDTO[] bldos= list.toArray(new ChargeItmDTO[0]);
				 return bldos; 
			 }else {
				 return null;
			 }
		}
		//住院类型
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entpCode))
		{
			StringBuffer sb=new StringBuffer();
			sb.append("select cgip.id_or, cgip.id_srv ,cgip.code_srv,cgip.name_srv,cgip.price,cgip.price_ratio,");
		     sb.append("cgip.quan,cgip.amt,cgip.amt_ratio,cgip.id_emp_cg as id_emp_st,psn.code as code_emp_st,");
		     sb.append("psn.name as name_emp_st,cgip.dt_cg as dt_st,orsrv.sd_su_bl as status_st,doc.name as name_statusst ");
		     sb.append(" from  bl_cg_ip  cgip   ");
		     sb.append(" inner join  ci_or_srv orsrv  on cgip.id_or = orsrv.id_or and cgip.id_orsrv = orsrv.id_orsrv ");
		     sb.append(" inner join  bd_psndoc  psn on cgip.id_emp_cg = psn.id_psndoc  ");
		     sb.append(" inner join  bd_udidoc doc on orsrv.sd_su_bl= doc.code  ");
		     sb.append(" where doc.id_udidoclist='@@@@ZZ2000000000005S' and orsrv.sd_su_bl = '1' ");  //1为已记账状态
		     sb.append(" and " + SqlUtils.getInSqlByIds("cgip.id_or", orIds) +" order by dt_st desc ");
		  
			@SuppressWarnings("unchecked")
			List<ChargeItmDTO> list= (List<ChargeItmDTO>)new DAFacade().execQuery(sb.toString(),new BeanListHandler(ChargeItmDTO.class));
			 if(!(list.isEmpty())&&list.size()>0){
				 ChargeItmDTO[] bldos= list.toArray(new ChargeItmDTO[0]);
				 return bldos; 
			 }else {
				 return null;
			 }	
		}
		return null;
	}
}
