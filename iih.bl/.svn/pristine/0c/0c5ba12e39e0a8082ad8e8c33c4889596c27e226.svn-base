package iih.bl.comm.s.bp;

import iih.bl.comm.IBlBannerConst;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.pub.BlGroupControlUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 根据banner中输入值查询相关患者就诊信息
 * @author LIM
 *
 */
public class GetEtBannerInfoBp {
	/**
	 * 根据banner中输入值查询相关患者就诊信息
	 * @param qryType 检索类型
	 * @param inputValue 输入值
	 * @param selectCondition 查询条件字段
	 */
	@SuppressWarnings({ "unchecked" })
	public PagingRtnData<BlBannerDTO> exec(String qryType,String inputValue,String[] selectCondition, String strCode_entp, PaginationInfo pageInfo) throws BizException{
		StringBuffer sql = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		sql.append("select t.id_ent,")
			.append("p.id_pat,")
			.append("p.name as name_pat,")
			.append("t.code as code_ent,")
			.append("nvl(t.dt_acpt,t.dt_entry) as dt_in,")  //不取入院登记时间，改为取入科时间
			.append("e.code_amr_ip,")
			.append("e.times_ip,")
			.append("r.id_pripat,")
			.append("r.name as name_pripat,")
			.append("h.id_hp,")
			.append("h.name as name_hp,")
			.append("t.fg_ip ")
			.append("from en_ent t ")
			.append("left join pi_pat p on p.id_pat = t.id_pat ")
			.append("left join en_ent_ip e on e.id_ent = t.id_ent ")
			.append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
			.append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
			.append("left join bd_hp h on h.id_hp = n.id_hp ")
			.append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
			.append("where 1=1 ")
			.append("and t.fg_canc = 'N' ");
		
		sql.append("and t.code_entp = ").append(strCode_entp);
			
		sql.append(" and ").append(BlGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "t"));
		sql.append(this.getSqlWhere(qryType));
		if(selectCondition != null && selectCondition.length > 0){
			
			sb.append(" select * from  (");
			StringBuffer wheresql = new StringBuffer();
			for(String cond : selectCondition){
				if("code_ent".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and t.code = '").append(inputValue).append("'");
				}else if("id_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and p.id_pat = '").append(inputValue).append("'");
				}else if("code_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and p.code = '").append(inputValue).append("'");
				}else if("id_code".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and p.id_code = '").append(inputValue).append("'");
				}else if("barcode_chis".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and p.barcode_chis = '").append(inputValue).append("'");
				}else if("code_amr_ip".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and e.code_amr_ip = '").append(inputValue).append("'");
				}else if("patcode".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and c.code = '").append(inputValue).append("'");
				}else if("name_pat".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and p.name = '").append(inputValue).append("'");
				}else if("no_hp".equals(cond)){
					if(wheresql != null && wheresql.length() > 0){
						wheresql.append(" union ");
					}
					wheresql.append(sql);
					wheresql.append(" and n.no_hp = '").append(inputValue).append("'");
				}
			}
			sb.append(wheresql.toString());
			sb.append(") ");
		}
		sb.append(" order by id_pat,times_ip desc");
//		List<BlBannerDTO> list = (List<BlBannerDTO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlBannerDTO.class));
		PagingRtnData<BlBannerDTO> pageDTO = new PagingRtnData<BlBannerDTO>();
		PagingServiceImpl<BlBannerDTO> service = new PagingServiceImpl<BlBannerDTO>();
		pageDTO = service.findByPageInfo(new BlBannerDTO(), pageInfo, sb.toString(), "", new SqlParam());
		return pageDTO;
	}

	
	/**
	 * 根据节点编号拼接不同的where条件
	 * @param menuID
	 * @return
	 */
	private String getSqlWhere(String qryType){
		String sWhere="";
		switch (qryType){
			case IBlBannerConst.BANNER_NO_ST://住院退补费明细 
				sWhere="  and t.fg_st = 'N' ";
				break;
			case IBlBannerConst.BANNER_NO_STORPAY://收付款、结算、预交金账户转移
				sWhere=" and (t.fg_st = 'N' or (t.fg_st = 'Y' and exists( select s.id_ent from bl_st_ip s where s.id_ent = t.id_ent and s.fg_pay = 'N') )) ";
				break;
			default://收退住院预交金、欠费补交结算、退费、住院费用审核
				sWhere="";
				break;	
		}	
		return sWhere;
	}
}
