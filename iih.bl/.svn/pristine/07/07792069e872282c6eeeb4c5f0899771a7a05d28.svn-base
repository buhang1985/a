package iih.bl.pay.blpaypat.bp.ip;

import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.pub.BlGroupControlUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;
/**
 * 获取住院收退预交金节点用banner信息的bp类
 * @author li_pengying
 * @since 2017-06-22
 *
 */
public class GetIpBannerInfoBp {
	
	/**
	 * 根据banner中输入值查询相关患者就诊信息
	 * */
	@SuppressWarnings({ "unchecked" })
	public BlBannerDTO[] getBannerEnEntInfo(String inputValue,String[] selectCondition) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t.id_ent,p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip,dep.name as name_dep_nur,e.name_bed ")
			.append(" ,hpca.name_hppatca ,medkind.name as name_hpmedkind 	") 
			.append("from en_ent t ")
			 .append(" inner join en_ent_acc entacc on t.id_ent=entacc.id_ent ")
			 .append("left join pi_pat p on p.id_pat = t.id_pat ")
			 .append("left join en_ent_ip e on e.id_ent = t.id_ent ")
			 .append(" left join bl_st_ip st on st.id_ent=t.id_ent  and st.fg_canc='N' and st.eu_direct=1 and st.eu_sttp='10' ")
			 .append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
			 .append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
			 .append("left join bd_hp h on h.id_hp = n.id_hp ")
			 .append("left join bd_dep dep on t.id_dep_nur = dep.id_dep ")
			 .append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
			 .append("left join pi_pat_hp php on php.id_pat = p.id_pat ")
			 .append("left join  bd_hp_patca hpca on hpca.code_hppatca = n.code_hppatca and hpca.id_hp =h.id_hp ")
			 .append("left join  bd_hp_med_kind_ah medkind on medkind.code = t.code_hpmedkind ")
			 .append("where t.code_entp in('10','11') ")
			 .append("and t.fg_canc = 'N' and (nvl(st.fg_pay,'N')='N' or entacc.amt_prepay>0)");//增加如果预交金余额大于0的也可以参照出来，只能进行退费操作 by lim 2019-11-04
		sql.append(" and ").append(BlGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "t"));
		if(selectCondition != null && selectCondition.length > 0){
			sql.append("and (");
			StringBuffer wheresql = new StringBuffer();
			for(String cond : selectCondition){
				if("code_ent".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("t.code = '").append(inputValue).append("'");
				}else if("id_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat in (select patamr.id_pat from pi_pat_amr_code patamr where patamr.code = '").append(inputValue).append("')");
				}else if("code_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.code = '").append(inputValue).append("'");
				}else if("id_code".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code = '").append(inputValue).append("'");
				}else if("barcode_chis".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis = '").append(inputValue).append("'");
				}else if("code_amr_ip".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.code_amr_ip = '").append(inputValue).append("'");
				}else if("patcode".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("c.code = '").append(inputValue).append("'");
				}else if("name_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("p.name = '").append(inputValue).append("'");
				}else if("no_hp".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" or ");
					}
					wheresql.append("php.no_hp = '").append(inputValue).append("'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatiVisitDO(), "t");//增加组织隔离
		sql.append(sqlContext);
		sql.append("order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[]{});
	}
}
