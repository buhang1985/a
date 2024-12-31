package iih.bl.st.blauditip.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.st.blauditip.bp.qry.IpOutAuditPatQry;
import iih.bl.st.blipauditouthospcheck.d.BlIpAuditOutHospCheckDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 住院医保自费项目审核功能-待预审核信息查询
 * @author hanjq
 *
 */
public class GetIpOutAuditPatsBP {

	public GetIpOutAuditPatsBP()
	{
	}
	
	/**
	 * 出院患者带有查询方案和分页的查询
	 * 
	 * @param qryRoot
	 * @param pgInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlIpAuditOutHospCheckDTO> exec(String whereStr,
			PaginationInfo pgInfo) throws BizException {
		// 得到带有分页的数据集合
		PagingRtnData<BlIpAuditOutHospCheckDTO> pageFeeDTO = new PagingRtnData<BlIpAuditOutHospCheckDTO>();
		pageFeeDTO = getPatsInfo(whereStr, pgInfo);
		
		if (pageFeeDTO==null)
			return null;
		
		List<String> entids=new ArrayList<>();
		for (int i = 0; i < pageFeeDTO.getPageData().size(); i++) {
			BlIpAuditOutHospCheckDTO outHospCheckDTO = (BlIpAuditOutHospCheckDTO)
					pageFeeDTO.getPageData().get(i);
			if (outHospCheckDTO.getBirth_date() != null) {
				String age = AgeCalcUtil.getAge(outHospCheckDTO.getBirth_date());
				outHospCheckDTO.setPat_age(age);
			}
			entids.add(outHospCheckDTO.getId_ent());
		}
		//获取医保患者的未结费用
		Map<String,FDouble> hpPatUnstDee = this.getHpPatUnSt(entids);
		PagingRtnData<BlIpAuditOutHospCheckDTO> rtnData = this.getAmtUncg(pageFeeDTO, hpPatUnstDee);
		return rtnData;
	}
	
	private PagingRtnData<BlIpAuditOutHospCheckDTO> getPatsInfo(String whereStr, PaginationInfo pgInfo) throws BizException
	{
		PagingRtnData<BlIpAuditOutHospCheckDTO> pageFeeDTO = new PagingRtnData<BlIpAuditOutHospCheckDTO>();
		PagingServiceImpl<BlIpAuditOutHospCheckDTO> service = new PagingServiceImpl<BlIpAuditOutHospCheckDTO>();
		IpOutAuditPatQry qry = new IpOutAuditPatQry(whereStr);
        // 普通住院
		pageFeeDTO = service.findByPageInfo(new BlIpAuditOutHospCheckDTO(), pgInfo, qry.getQrySQLStr(), "", qry.getQryParameter(null));

		return pageFeeDTO;
	}
	
	/**
	 * 
	 * @Description: 获取未结算费用    
	 * @author: xy.zhou     
	 * @throws
	 */
	private PagingRtnData<BlIpAuditOutHospCheckDTO>  getAmtUncg
	(PagingRtnData<BlIpAuditOutHospCheckDTO> pageFeeDTO,Map<String,FDouble> hpPatUnstDee)throws BizException{
		
		//不取预交金锁定金额，取记账表里未结算费用，没有则为0 by lim 2018-11-22
		for (int i = 0; i < pageFeeDTO.getPageData().size(); i++) {
			BlIpAuditOutHospCheckDTO outHospCheckDTO = (BlIpAuditOutHospCheckDTO)
					pageFeeDTO.getPageData().get(i);
			if(hpPatUnstDee.containsKey(outHospCheckDTO.getId_ent())){
				outHospCheckDTO.setAmt_uncg(hpPatUnstDee.get(outHospCheckDTO.getId_ent()));
			}else{
				outHospCheckDTO.setAmt_uncg(FDouble.ZERO_DBL);
			}
		}
		return pageFeeDTO;
	}
	
	/**
	 * 获取医保患者的未结费用
	 * @param entids
	 * @return
	 * @throws Exception 
	 */
	private Map<String, FDouble> getHpPatUnSt(List<String> entids) throws BizException {

		Map<String, FDouble> patUnstMap = new HashMap<String, FDouble>();
		StringBuilder sb = new StringBuilder();
		sb.append("select cg.id_ent,sum(nvl(cg.amt_ratio,'0')*cg.eu_direct) as amt_ratio ");
		sb.append(" from bl_cg_ip cg ");
		sb.append(" inner join en_ent ent on cg.id_ent =ent.id_ent ");
		//sb.append(" inner join en_ent_hp enthp on ent.id_ent=enthp.id_ent ");
		sb.append(" left join bl_audit_ip auditip on auditip.id_ent = ent.id_ent ");
		sb.append(" inner join bd_dep in_nur on in_nur.id_dep = ent.id_dep_nur ");
		sb.append(" inner join bd_dep in_dep on in_dep.id_dep = ent.id_dep_phy ");

		sb.append(" where  cg.id_stip='~' and ent.fg_ip='N' ");
		
		if(entids != null && entids.size() > 0)
		{
			sb.append(" and  cg.id_ent  in (");
			sb.append(SqlUtils.arrayToStr(entids.toArray(new String[0])));
			sb.append(") ");
		}
		
		sb.append(" group by cg.id_ent");
		@SuppressWarnings("unchecked")
		List<BlCgIpDO> blcgDoList = (List<BlCgIpDO>) new DAFacade().execQuery(sb.toString(),
				new BeanListHandler(BlCgIpDO.class));

		if (!ListUtil.isEmpty(blcgDoList)) {
			for (BlCgIpDO blcgDo : blcgDoList) {
				patUnstMap.put(blcgDo.getId_ent(), blcgDo.getAmt_ratio());
			}
		}
		return patUnstMap;
	}
	
}
