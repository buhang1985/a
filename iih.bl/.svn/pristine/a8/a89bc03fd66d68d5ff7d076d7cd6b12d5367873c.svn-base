package iih.bl.cc.blcc.bp;

import iih.bl.cc.blccdto.d.BlPayPatIpDTO;
import iih.bl.cc.blccdto.d.BlpayOepPatDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 结账逻辑
 * @author 卫佳
 *
 */
public class BlccBp {

	
	/**
	 * 通过结账查询界面的选中的一条数据BlccDO的主键id找到一条结账所对应的住院结账类型的住院收付款明细，用于显示结账历史查询的收付款明细界面显示用，用于修改需求后的显示用。
	 * @param id_cc
	 * @return
	 * @throws BizException
	 * 结账已废弃
	 */
	@SuppressWarnings("unchecked")
	public  BlPayPatIpDTO[] getBlPaypatIpDtosByIdcc(String id_cc,String id_emp_pay) throws BizException{
		
		StringBuffer sb=new StringBuffer();
		sb.append("select  distinct  A.id_paypatip,B.Id_Payitmpatip, C.code as code_pat,C.name as name_pat, E.Name as name_enttp, ");
		sb.append("       A.AMT,A.Eu_Direct,B.EU_DIRECT as payitem_eudirect, case when B.eu_direct=1 then '收款' else '退款' end as pay_direct, ");
		sb.append("       F.name as name_emppay,G.name as name_deppay,H.name as name_pm, ");
		sb.append("       A.eu_direct * B.eu_direct as sign_eudirect,case  when ( A.eu_direct * B.eu_direct)=1 then '否' else '是' end as change , ");
		sb.append("       B.AMT as amt_payitm,B.Paymodenode,K.Code_St,A.Dt_Pay  ");
		sb.append("   from bl_pay_pat_ip  A   ");
		sb.append(" inner join  bl_pay_itm_pat_ip  B  on   A.Id_Paypatip=B.id_paypatip  ");
		sb.append(" join  pi_pat             C  on   A.id_pat=C.id_pat  ");
		sb.append(" join  bl_cc              D  on   A.id_cc=D.id_cc ");
		sb.append(" left  join   bd_entp     E  on   A.id_enttp=E.Id_Entp ");
		sb.append(" left  join   bd_psndoc   F  on   A.id_emp_pay=F.id_psndoc ");
		sb.append(" left  join   bd_dep      G  on   A.id_dep_pay=G.id_dep   ");
		sb.append(" left  join   bl_st_ip    K  on   A.Id_stip   =K.Id_stip ");
		sb.append(" join bd_pri_pm   H on B.id_pm=H.id_pm    "); 
		sb.append(" where A.id_cc=?  and  A.Fg_cc='Y'  and A.id_emp_pay=?  order by a.dt_pay desc ");
		
		SqlParam sp=new SqlParam();
		sp.addParam(id_cc);
		sp.addParam(id_emp_pay);
		List<BlPayPatIpDTO> ipdtos= (List<BlPayPatIpDTO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(BlPayPatIpDTO.class));
	    return ipdtos.toArray(new BlPayPatIpDTO[0]); 
	}
	
	/**
	 * 住院结账预览时获取住院结算收付款明细信息(分页)（包括结账后查询）
	 * @param map   where条件集合(id_user,end_time,id_cc)	 
	 * @param pageInfo
	 * @author Liwq
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public PagingRtnData<BlPayPatIpDTO> getBlPaypatIpDTOPageInfo(FMap map, PaginationInfo pageInfo) throws BizException{
		PagingRtnData<BlPayPatIpDTO> pageDTO = new PagingRtnData<BlPayPatIpDTO>();
		PagingServiceImpl<BlPayPatIpDTO> service = new PagingServiceImpl();
		if(map.isEmpty())
			return pageDTO;
		SqlParam sp=new SqlParam();
		StringBuffer sb=new StringBuffer();
		if("".equals(map.get("id_cc").toString()) || map.get("id_cc") == null)
		{	//结账前分页查询		
			sb.append(" select distinct A.id_paypatip,B.Id_Payitmpatip, C.code as code_pat,");
			sb.append("	C.name as name_pat,E.Name as name_enttp,A.Eu_Direct,B.eu_direct as payitem_eudirect,");
			sb.append("	case when B.eu_direct=1 then '收款' else '退款' end as pay_direct,");
			sb.append(" F.name as name_emppay,G.name as name_deppay,H.name as name_pm, ");
			sb.append(" A.eu_direct * B.eu_direct as sign_eudirect,");
			sb.append(" case  when ( A.eu_direct * B.eu_direct)=1 then '否' else '是' end as change ,");
			sb.append(" B.AMT as amt_payitm,B.Paymodenode,K.Code_St, A.Dt_Pay ");
			sb.append(" from bl_pay_pat_ip  A ");
			sb.append(" join bl_pay_itm_pat_ip  B on  A.Id_Paypatip=B.id_paypatip  ");
			sb.append(" join pi_pat C on A.id_pat=C.id_pat  ");
			sb.append(" left join bd_entp E on A.id_enttp=E.Id_Entp ");
			sb.append(" left join bd_psndoc F on A.id_emp_pay=F.id_psndoc ");
			sb.append(" left  join bd_dep G on A.id_dep_pay=G.name  left join bl_st_ip K on A.Id_stip=K.Id_stip ");
			sb.append(" join bd_pri_pm   H on B.id_pm=H.id_pm  ");
			sb.append(" where A.FG_CC = 'N'  and A.ID_EMP_PAY = ? and A.DT_PAY < ?"); 
			
			sb.append(" order by A.Dt_Pay desc");
			
			String id_user = map.get("id_user").toString();
			FDateTime end_time = new FDateTime(map.get("end_time").toString());
			
			sp.addParam(id_user);
			sp.addParam(end_time);
		}else {//结账后分页查询
			sb.append("select  distinct  A.id_paypatip,B.Id_Payitmpatip, C.code as code_pat,C.name as name_pat, E.Name as name_enttp, ");
			sb.append("       A.AMT,A.Eu_Direct,B.EU_DIRECT as payitem_eudirect, case when B.eu_direct=1 then '收款' else '退款' end as pay_direct, ");
			sb.append("       F.name as name_emppay,G.name as name_deppay,H.name as name_pm, ");
			sb.append("       A.eu_direct * B.eu_direct as sign_eudirect,case  when ( A.eu_direct * B.eu_direct)=1 then '否' else '是' end as change , ");
			sb.append("       B.AMT as amt_payitm,B.Paymodenode,K.Code_St,A.Dt_Pay  ");
			sb.append("   from bl_pay_pat_ip  A   ");
			sb.append(" inner join  bl_pay_itm_pat_ip  B  on   A.Id_Paypatip=B.id_paypatip  ");
			sb.append(" join  pi_pat             C  on   A.id_pat=C.id_pat  ");
			sb.append(" join  bl_cc              D  on   A.id_cc=D.id_cc ");
			sb.append(" left  join   bd_entp     E  on   A.id_enttp=E.Id_Entp ");
			sb.append(" left  join   bd_psndoc   F  on   A.id_emp_pay=F.id_psndoc ");
			sb.append(" left  join   bd_dep      G  on   A.id_dep_pay=G.id_dep   ");
			sb.append(" left  join   bl_st_ip    K  on   A.Id_stip   =K.Id_stip ");
			sb.append(" join bd_pri_pm   H on B.id_pm=H.id_pm    "); 
			sb.append(" where A.id_cc=?  and  A.Fg_cc='Y'  and A.id_emp_pay=?  ");
			sb.append(" order by A.Dt_Pay desc");
			String id_cc = map.get("id_cc").toString();
			String id_emp = map.get("id_user").toString();
			sp.addParam(id_cc);
			sp.addParam(id_emp);
		}		
		
		pageDTO = service.findByPageInfo(new BlPayPatIpDTO(), pageInfo,sb.toString(), "", sp);
		return pageDTO;
	}
	
	/**
	 * 通过结账查询界面的选中的一条数据BlccDO的主键id找到一条门诊结账类型所对应的门诊结账的收付款明细，用于显示结账历史查询的收付款明细界面显示用，用于修改需求后的显示用。
	 * @param id_cc
	 * @return
	 * @throws BizException
	 * 结账已废弃
	 */
	@SuppressWarnings("unchecked")
	public  BlpayOepPatDTO[] findBlPaypatOepDtosByIdcc(String id_cc,String id_emp_pay) throws BizException{
		StringBuffer sb=new StringBuffer();
		sb.append("  select   x.id_paypatoep,x.id_enttp,t3.name as entp_name,x.id_pat,x.pat_code,x.pat_name,x.amt,x.id_dep_pay,x.id_paytp,");
		sb.append("   x.eu_direct,case when x.eu_direct=1 then '收款' else '退款' end as direct ,");
		sb.append("   x.id_emp_pay,x.id_blcc,x.paymodenode,t4.name as dept_name,t5.name as emp_name,t6.name as pm_name,");
		sb.append("   x.sign_eudirect, case when x.sign_eudirect=1 then ''  else '是' end as change,x.dt_pay  ");
		sb.append("   from   ");
		sb.append("   (select  t1.id_paypatoep,t1.id_enttp,t1.id_pat,B.amt,t1.id_dep_pay,t1.id_emp_pay,id_paytp,B.eu_direct,t1.id_cc as id_blcc,B.id_pm,C.CODE as pat_code,C.name as pat_name,B.paymodenode ,t1.dt_pay,t1.eu_direct * B.EU_DIRECT as sign_eudirect from bl_pay_pat_oep t1  ");
		sb.append("    inner JOIN BL_PAY_ITM_PAT_OEP B ON t1.ID_PAYPATOEP = B.ID_PAYPATOEP ");		
		sb.append("    JOIN PI_PAT C ON t1.ID_PAT = C.ID_PAT   ");
		sb.append("    join  bl_cc t2  on t1.id_cc=t2.id_cc  where  t1.id_cc =?  and t1.FG_CC ='Y'  and  t1.id_emp_pay=?  ");
		sb.append("    and B.fg_realpay='Y' ) x");//增加了条件：只显示实收（退）付款段
		sb.append("  left join bd_entp t3 on  x.id_enttp=t3.id_entp ");
		sb.append("  left join bd_dep t4  on   x.id_dep_pay=t4.id_dep ");
		sb.append("  left join bd_psndoc t5 on x.id_emp_pay=t5.id_psndoc");
		sb.append("  join bd_pri_pm t6 on  x.id_pm=t6.id_pm  order by x.dt_pay desc ");
		
		SqlParam sp=new SqlParam();
		sp.addParam(id_cc);
		sp.addParam(id_emp_pay);
		 List<BlpayOepPatDTO> list= (List<BlpayOepPatDTO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(BlpayOepPatDTO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 return list.toArray(new BlpayOepPatDTO[0]);
		 }else {
			 return null;
		 }
	
	}
	
	/**
	 * 门诊结账预览时获取门诊结算收付款明细信息（分页）（包括结账后查询）
	 * @param map where条件集合（id_user,end_time,id_cc）
	 * @param pageInfo
	 * @author Liwq
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public  PagingRtnData<BlpayOepPatDTO> getBlPaypatOepDtosPageInfo(FMap map, PaginationInfo pageInfo) throws BizException{
		PagingRtnData<BlpayOepPatDTO> pageDTO = new PagingRtnData<BlpayOepPatDTO>();
		PagingServiceImpl<BlpayOepPatDTO> service = new PagingServiceImpl();
		if(map.isEmpty())
			return pageDTO;
		SqlParam sp=new SqlParam();
		StringBuffer sb=new StringBuffer();
		if("".equals(map.get("id_cc").toString()) || map.get("id_cc") == null) {
			sb.append("  select   x.id_paypatoep,x.id_enttp,t3.name as entp_name,x.id_pat,x.pat_code,x.pat_name,x.amt,x.id_dep_pay,x.id_paytp,");
			sb.append("   x.eu_direct,x.payitem_eudirect,case when x.payitem_eudirect=1 then '收款' else '退款' end as direct ,");
			sb.append("   x.id_emp_pay,x.id_blcc,x.paymodenode,t4.name as dept_name,t5.name as emp_name,t6.name as pm_name,");
			sb.append("   x.sign_eudirect, case when x.sign_eudirect=1 then ''  else '是' end as change,x.dt_pay  ");
			sb.append("   from   ");
			sb.append("   (select  t1.id_paypatoep,t1.id_enttp,t1.id_pat,B.amt,");
			sb.append("   t1.id_dep_pay,t1.id_emp_pay,id_paytp,B.eu_direct as payitem_eudirect,T1.Eu_direct,t1.id_cc as id_blcc,");
			sb.append("   B.id_pm,C.CODE as pat_code,C.name as pat_name,B.paymodenode ,");
			sb.append("   t1.eu_direct * B.EU_DIRECT as sign_eudirect,t1.dt_pay,B.id_payitmpatoep   from bl_pay_pat_oep t1  ");
			sb.append("    JOIN BL_PAY_ITM_PAT_OEP B ON t1.ID_PAYPATOEP = B.ID_PAYPATOEP ");
			sb.append("    JOIN PI_PAT C ON t1.ID_PAT = C.ID_PAT   ");
			sb.append("    where  t1.FG_CC = 'N'  and t1.ID_EMP_PAY = ? and t1.DT_PAY < ? ");
			sb.append("    and B.fg_realpay='Y' ) x"); //增加了条件：只显示实收（退）付款段
			sb.append("  left join bd_entp t3 on  x.id_enttp=t3.id_entp ");
			sb.append("  left join bd_dep t4  on   x.id_dep_pay=t4.id_dep ");
			sb.append("  left join bd_psndoc t5 on x.id_emp_pay=t5.id_psndoc");	
			sb.append("  join bd_pri_pm t6 on  x.id_pm=t6.id_pm   ");		
			sb.append("order by x.dt_pay desc ");
			String id_user = map.get("id_user").toString();
			FDateTime end_time = new FDateTime(map.get("end_time").toString());
			sp.addParam(id_user);
			sp.addParam(end_time);
		}else {
			sb.append("  select   x.id_paypatoep,x.id_enttp,t3.name as entp_name,x.id_pat,x.pat_code,x.pat_name,x.amt,x.id_dep_pay,x.id_paytp,");
			sb.append("   x.eu_direct,case when x.eu_direct=1 then '收款' else '退款' end as direct ,");
			sb.append("   x.id_emp_pay,x.id_blcc,x.paymodenode,t4.name as dept_name,t5.name as emp_name,t6.name as pm_name,");
			sb.append("   x.sign_eudirect, case when x.sign_eudirect=1 then ''  else '是' end as change,x.dt_pay  ");
			sb.append("   from   ");
			sb.append("   (select  t1.id_paypatoep,t1.id_enttp,t1.id_pat,B.amt,t1.id_dep_pay,t1.id_emp_pay,id_paytp,B.eu_direct,t1.id_cc as id_blcc,B.id_pm,C.CODE as pat_code,C.name as pat_name,B.paymodenode ,t1.dt_pay,t1.eu_direct * B.EU_DIRECT as sign_eudirect from bl_pay_pat_oep t1  ");
			sb.append("    inner JOIN BL_PAY_ITM_PAT_OEP B ON t1.ID_PAYPATOEP = B.ID_PAYPATOEP ");		
			sb.append("    JOIN PI_PAT C ON t1.ID_PAT = C.ID_PAT   ");
			sb.append("    join  bl_cc t2  on t1.id_cc=t2.id_cc  where  t1.id_cc =?  and t1.FG_CC ='Y'  and  t1.id_emp_pay=?  ");
			sb.append("    and B.fg_realpay='Y' ) x");//增加了条件：只显示实收（退）付款段
			sb.append("  left join bd_entp t3 on  x.id_enttp=t3.id_entp ");
			sb.append("  left join bd_dep t4  on   x.id_dep_pay=t4.id_dep ");
			sb.append("  left join bd_psndoc t5 on x.id_emp_pay=t5.id_psndoc");
			sb.append("  join bd_pri_pm t6 on  x.id_pm=t6.id_pm  order by x.dt_pay desc ");
			String id_cc = map.get("id_cc").toString();
			String id_emp = map.get("id_user").toString();
			sp.addParam(id_cc);
			sp.addParam(id_emp);
		}	
		
		pageDTO = service.findByPageInfo(new BlpayOepPatDTO(), pageInfo,sb.toString(), "", sp);
		return pageDTO;
	
	}
	
}
