package iih.bl.cg.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgipconfeetail.bp.BlCgIpConFeetailBp;
import iih.bl.cg.blcgipfeequery.bp.BlcgIpFeeListQuery;
import iih.bl.cg.blcgipfeetail.bp.BlCgIpFeetailBp;
import iih.bl.cg.blcgipmend.bp.BlCgIpMendBp;
import iih.bl.cg.blcgoep.bp.BlCgOepQueryBp;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.Service.d.CreateBlcgqueryDTO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgzyquerydto.d.BlCgZyQueryDTO;
import iih.bl.cg.blprinterset.QryPrinterSetInfoBp;
import iih.bl.cg.blprinterset.SavePrinterSetBp;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.blstrikebalancebp.BlstStrikeBalanceBp;
import iih.bl.cg.bp.GetInvoiceType;
import iih.bl.cg.bp.QueryBlCg;
import iih.bl.cg.bp.QueryOepBlCg;
import iih.bl.cg.d.BlIpFeeDTO;
import iih.bl.cg.d.BlIpFeeInfo;
import iih.bl.cg.dto.d.BlCgAmtDTO;
import iih.bl.cg.dto.d.BlCgItmVsBiPritpDTO;
import iih.bl.cg.dto.d.BlCgPriceAndAmtDTO;
import iih.bl.cg.dto.d.BlcgDto;
import iih.bl.cg.dto.d.EntPatInfoDTO;
import iih.bl.cg.dto.d.OepfeeitmqryDTO;
import iih.bl.cg.dto.d.SrvVsInvoiceTypeDTO;
import iih.bl.cg.ip.s.bp.NurseRedBackFeeBp;
import iih.bl.cg.oepfeeitemqry.bp.OepfeeitmqryBp;
import iih.bl.cg.service.d.BlCgIpAmtAndUncgRationDTO;
import iih.bl.cg.service.s.bp.BlIpFeeBp;
import iih.bl.cg.service.s.bp.BlSupportTriageCiOrderFeeBp;
import iih.bl.cg.service.s.bp.GetBlIpInfoDataBp;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import iih.en.pv.enfee.dto.d.PatiFixedFeeLeftDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces={IBlcgqueryService.class}, binding=Binding.JSONRPC)
public  class BlcgqueryServiceImpl implements IBlcgqueryService {
	
	/**
	 * 查询处方是否缴费（只要一个服务缴费即代表整个处方缴费）
	 * @param id_OrArr 医嘱列
	 * @return Map<String,FBoolean> <id_or,是否缴费(FBoolean.TRUE:缴费;FBoolean.FALSE:未缴费)>
	 * @throws BizException
	 */
	public Map<String,FBoolean> querySettlementByIdPres_Oep(String[] id_presArr) throws BizException 
	{
		Map<String,FBoolean> queryResultMap=new HashMap<String,FBoolean>();
		DAFacade dafacade=new DAFacade();
	
			for(String id_pres: id_presArr)
			{
				StringBuffer sqlb=new StringBuffer();
				sqlb.append(" select a.id_cgitmoep,a.id_or,a.id_pres,a.id_orsrv ");
				sqlb.append("   from bl_cg_itm_oep a ");
				sqlb.append("  inner join bl_st_oep b ");
				sqlb.append("     on a.id_stoep = b.id_stoep ");
				sqlb.append("  inner join bl_pay_pat_oep c ");
				sqlb.append("     on b.id_paypatoep = c.id_paypatoep ");
				//sqlb.append("    and a.id_or = ? ");
				sqlb.append("    where a.id_pres = ? and b.eu_direct=1 and b.fg_canc='N'");
				SqlParam sqlp=new SqlParam();
				sqlp.addParam(id_pres);
				List<BlCgItmOepDO> blCgItmOepDOLst=(List<BlCgItmOepDO>)dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
				if(blCgItmOepDOLst!=null && blCgItmOepDOLst.size()>0)
				{
					queryResultMap.put(id_pres, FBoolean.TRUE);//已缴费
				}
				else
				{
					queryResultMap.put(id_pres, FBoolean.FALSE);//未缴费
				}
			}
		
		return queryResultMap;  
		   

	}
	
	/**
	 * 查询医嘱是否缴费（只要一个服务缴费即代表整个医嘱缴费）
	 * @param id_OrArr 医嘱ID_OR列
	 * @return Map<String,FBoolean> <id_or,是否缴费(FBoolean.TRUE:缴费;FBoolean.FALSE:未缴费)>
	 * @throws BizException
	 */
	public Map<String,FBoolean> querySettlementByIdOr_Oep(String[] id_OrArr) throws BizException
	{
		Map<String,FBoolean> queryResultMap=new HashMap<String,FBoolean>();
		DAFacade dafacade=new DAFacade();
		
			for(String id_or: id_OrArr)
			{
				StringBuffer sqlb=new StringBuffer();
				sqlb.append(" select a.id_cgitmoep,a.id_or,a.id_pres,a.id_orsrv ");
				sqlb.append("   from bl_cg_itm_oep a ");
				sqlb.append("  inner join bl_st_oep b ");
				sqlb.append("     on a.id_stoep = b.id_stoep ");
				sqlb.append("  inner join bl_pay_pat_oep c ");
				sqlb.append("     on b.id_paypatoep = c.id_paypatoep ");
				sqlb.append("    where a.id_or = ? and b.eu_direct=1 and b.fg_canc='N'");
				//sqlb.append("    where a.id_pres = ? ");
				SqlParam sqlp=new SqlParam();
				sqlp.addParam(id_or);
				List<BlCgItmOepDO> blCgItmOepDOLst=(List<BlCgItmOepDO>)dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgItmOepDO.class));
				if(blCgItmOepDOLst!=null && blCgItmOepDOLst.size()>0)
				{
					queryResultMap.put(id_or, FBoolean.TRUE);//已缴费
				}
				else
				{
					queryResultMap.put(id_or, FBoolean.FALSE);//未缴费
				}
			}
		
		return queryResultMap;  
		   

	}
	/**
	 * 根据就诊，返回该就诊下的费用明细及其对应的收费方式
	 * @param id_ent 就诊ID
	 * @param code_enttp 就诊类型CODE
	 * @return 该就诊下的费用明细及其对应的收费方式
	 * @throws BizException
	 * @author tcy
	 */
	@SuppressWarnings("unchecked")
	public BlCgItmVsBiPritpDTO[] getBlCgItmVsBiPritpDTO(String id_ent,String code_enttp) throws BizException {
		BlCgItmVsBiPritpDTO[] blCgItmVsBiPritpDTOArr=null;
		DAFacade dafacade=new DAFacade();
		StringBuffer sqlb=new StringBuffer();
		StringBuffer sqlBF = new StringBuffer();
		if (code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
				|| code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)
				|| code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) //门诊
		{
			sqlb.append("       select b.sd_pritp,");
			sqlb.append("              a.id_srv,");
			sqlb.append("              a.name_srv,");
			sqlb.append("              a.amt_std * c.eu_direct amt_std,");
			sqlb.append("              a.amt_ratio * c.eu_direct amt_ratio");
			sqlb.append("         from bl_cg_oep c");
			sqlb.append("        inner join bl_cg_itm_oep a");
			sqlb.append("           on c.id_cgoep = a.id_cgoep");
			sqlb.append("         left join bd_srv b");
			sqlb.append("           on a.id_srv = b.id_srv");
			sqlb.append("        where a.id_ent = ?");
		}
		else//住院
		{
			sqlb.append(" select b.sd_pritp,");
			sqlb.append("       a.id_srv,");
			sqlb.append("       a.name_srv,");
			sqlb.append("       a.amt_std * a.eu_direct amt_std,");
			sqlb.append("       a.amt_ratio * a.eu_direct amt_ratio");
			sqlb.append("  from bl_cg_ip a left join bd_srv b");
			sqlb.append(" on a.id_srv = b.id_srv");
			sqlb.append("   where a.id_ent = ?");
			
			//给病案首页提供的自付金额是否需要添加个人账户金额
			FBoolean blCg0031 = BlParams.BLCG0031();
			if(blCg0031 != null){
				if(blCg0031.booleanValue()){
					//计算自付金额(自付金额带个人账户)
					sqlBF.append(" select nvl(sum(case when proparip.id_proparip is null then stip.amt_ratio*stip.eu_direct else (nvl(proparip.amt_cash,0) + nvl(proparip.amt_psnacc,0))*proparip.eu_direct end),0) amt_pat ");
					sqlBF.append("  from bl_st_ip stip ");
					sqlBF.append(" left join bl_prop_ip propip on stip.id_stip = propip.id_stip ");
					sqlBF.append(" left join bl_prop_ar_ip proparip on proparip.id_propip = propip.id_propip ");
					sqlBF.append(" where stip.id_ent = ? ");
				}else{
					//计算自付金额(自付金额不带个人账户)
					sqlBF.append(" select nvl(sum(case when proparip.id_proparip is null then stip.amt_ratio*stip.eu_direct else nvl(proparip.amt_cash,0)*proparip.eu_direct end),0) amt_pat ");
					sqlBF.append("  from bl_st_ip stip ");
					sqlBF.append(" left join bl_prop_ip propip on stip.id_stip = propip.id_stip ");
					sqlBF.append(" left join bl_prop_ar_ip proparip on proparip.id_propip = propip.id_propip ");
					sqlBF.append(" where stip.id_ent = ? ");
				}
			}
			
		}
		SqlParam sqlp=new SqlParam();
		sqlp.addParam(id_ent);
		List<BlCgItmVsBiPritpDTO> blCgItmVsBiPritpDTOLst=(List<BlCgItmVsBiPritpDTO>)dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlCgItmVsBiPritpDTO.class));
		
		SqlParam sqlBFs=new SqlParam();
		sqlBFs.addParam(id_ent);
		List<BlCgItmVsBiPritpDTO> blCgItmVsBiPritpDTOList = (List<BlCgItmVsBiPritpDTO>)dafacade.execQuery(sqlBF.toString(), sqlBFs, new BeanListHandler(BlCgItmVsBiPritpDTO.class));
		blCgItmVsBiPritpDTOLst.addAll(blCgItmVsBiPritpDTOList);
		
		if(blCgItmVsBiPritpDTOLst!=null && blCgItmVsBiPritpDTOLst.size()>0)
		{
			blCgItmVsBiPritpDTOArr=blCgItmVsBiPritpDTOLst.toArray(new BlCgItmVsBiPritpDTO[0]);
		}
		return blCgItmVsBiPritpDTOArr;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public BlcgDto getAmountAndPayMode(String entId) throws BizException {

		String sql = "select st.amt_st as amt,st.amt_pi as amt_pat,pay.id_paytp, pay.sd_paytp,udipay.name as name_paytp, "
				+ "pay.id_bank,udibank.name as name_bank, pay.bankno "
				+ "from bl_st_oep st "
				+ "inner join bl_pay_pat_oep pay "
				+ " on st.id_stoep = pay.id_stoep "
				+ "left join bd_udidoc udipay "
				+ "  on pay.id_paytp = udipay.id_udidoc "
				+ "left join bd_udidoc udibank "
				+ "  on pay.id_bank = udibank.id_udidoc "
				+ "where st.id_ent= ? ";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(entId);
		
		List<BlcgDto> list = (List<BlcgDto>) new DAFacade().execQuery(sql,
				sqlParam, new BeanListHandler(BlcgDto.class));
		
		if (ListUtil.isEmpty(list)) {
			throw new BizException("收付款信息不存在");
		}
		
		return list.get(0);
	}
/*
 * (non-Javadoc)查找表头数据方法
 * @see iih.bl.cg.service.IBlcgqueryService#blcgFindByQCond(xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO, java.lang.String, xap.mw.coreitf.d.FBoolean)
 */
	@SuppressWarnings("unchecked")
	@Override
	public CreateBlcgqueryDTO blcgFindByQCond(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, FBoolean isLazy) throws BizException {

    	String sql = "select"
				      +" a.code,"
				      +" a.name,"
				      +" b.dt_acpt,"
				      +" b.id_pripat,"      
				      +" c.id_dep_phydisc,"
				      +" d.amt_prepay - d.amt_uncg surplus"
				      +" from pi_pat a, en_ent b, EN_ENT_IP c, en_ent_acc d"
				      +" where a.id_pat = b.id_pat"
				      +" and b.id_ent = c.id_ent"
				      +" and b.id_ent = d.id_ent";

		StringBuffer bb =new StringBuffer();
		bb.append(sql);
		if(qryRootNodeDTO !=null){
			String[] attrNames= qryRootNodeDTO.getAttrNames();
			if(attrNames != null && attrNames.length > 0){
				for (int i = 0; i< attrNames.length; i++) {
					String attrName = attrNames[i];
					bb.append(qryRootNodeDTO.getAttrVal(attrName));
					if(i < (attrNames.length - 1)){
						bb.append(" and");
					}			
				}
			}
		}
		

		sql=bb.toString();
		System.out.println(sql);
		List<CreateBlcgqueryDTO> list  = (List<CreateBlcgqueryDTO>)new DAFacade().execQuery(sql, new BeanListHandler(CreateBlcgqueryDTO.class));
		//用取出的结果集给对应属性赋.
		
		if(list.isEmpty())
			return null;
		return list.get(0);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CreateBlcgqueryDTO[] BlcgFindByQCond(String wheresql,
			String orderStr, FBoolean isLazy) throws BizException {

    	String sql = "select"
				      +" a.code Pat_code,"
				      +" a.name Pat_name,"
				      +" b.dt_acpt Pat_dt_acpt,"
				      +" e.name Pat_id_pricca,"      
				      +" c.id_dep_phydisc Id_dep_phyadm,"
				      +" d.amt_prepay - d.amt_uncg Prepay_balance"
				      +" from pi_pat a, en_ent b, EN_ENT_IP c, en_ent_acc d,bd_pri_pat e"
				      +" where a.id_pat = b.id_pat"
				      +" and b.id_ent = c.id_ent"
				      +" and b.id_ent = d.id_ent "
				      +" and a.id_pat=d.id_pat "
				      +" and b.id_pripat=e.id_pripat ";
    	sql=sql+" "+wheresql;
//sql=sql+" "+whereffer();
//		bb.append(wheresql);
//	
//		
//
//		sql=bb.toString();
//    	System.out.println("==========================");
//		System.out.println(sql);
		List<CreateBlcgqueryDTO> list  = (List<CreateBlcgqueryDTO>)new DAFacade().execQuery(sql, new BeanListHandler(CreateBlcgqueryDTO.class));
		//用取出的结果集给对应属性赋.
		
		if(list.isEmpty())
			return null;
		
		CreateBlcgqueryDTO[] createBlcetgqueryDTOs = list.toArray(new CreateBlcgqueryDTO[0]);
		return createBlcetgqueryDTOs;
		
	}
	
	
	/**
	 * 住院费用清单节点的新表头绑定数据用接口
	 * 
	 */
	@Override
	public  BlCgZyQueryDTO[] BlCgZyFindByQCond(String wheresql,String orderStr, FBoolean isLazy) throws BizException
	{
		BlcgIpFeeListQuery  bp= new BlcgIpFeeListQuery();
		return bp.BlCgZyFindByQCond(wheresql,orderStr,isLazy);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public  CreateBlcgqueryDTO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException{
		//String sql2="select b.code,b.code from bd_pri_pat b, en_ent e where b.id_pripat=e.id_pripat and e.id_pat='0001AA1000000000JSYP'";
		
		String sql3=" select a.code,a.name from pi_pat a";
		List<CreateBlcgqueryDTO> list  = (List<CreateBlcgqueryDTO>)new DAFacade().execQuery(sql3, new BeanListHandler(CreateBlcgqueryDTO.class));
		//用取出的结果集给对应属性赋值
		
		
		return list.toArray(new CreateBlcgqueryDTO[0]);
	}
	

	@Override
	public OepfeeitmqryDTO[] findByQueryCondsforOepfeeitmqry(String[] conds)
			throws BizException {
		// TODO Auto-generated method stub
		OepfeeitmqryBp bp=new OepfeeitmqryBp();
		return bp.findByQueryCondsforOepfeeitmqry(conds);
	}

	
	
	@Override
	public BlCgIpDO[] findBlCgIpInfoByIdEnt(String id_ent) throws BizException {
		BlCgIpMendBp blCgIpMendBp = new BlCgIpMendBp();
		//review by yangyang 2017-10-21 修正住院获取记账数据的信息
//		return blCgIpMendBp.getBlCgIpInfoByIdEnt(id_ent);
		return blCgIpMendBp.getBlCgIpDoByIdEnt(id_ent);
	}
//	@Override
//	public BlCgIpDO[] findBlCgIpInfoByIdor(String id_or) throws BizException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/**
	 * 根据医嘱号查询该医嘱下的门诊费用明细(按明细显示，不汇总）
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgItmOepDO[] findBlCgOepInfoByIdor(String id_or) throws BizException {
		// TODO Auto-generated method stub
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.findBlCgOepInfoByIdor(id_or);
	}
	/**
	 * 根据医嘱号查询该医嘱下的门诊费用明细(按汇总显示）
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepDO[] findBlCgOepInfoByIdor_aggregate(String id_or) throws BizException 
	{
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.findBlCgOepInfoByIdor_aggregate(id_or);
	}
	/**
	 * 根据就诊号查询该就诊下的门诊费用明细
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgItmOepDO[] findBlCgOepInfoByIdent(String id_ent)
			throws BizException {
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.findBlCgOepInfoByIdent(id_ent);
	}
	
	/**
	 * 根据病人ID和就诊ID，获得可消费余额，账户余额，已消费总额，特定服务分类占比
	 * @param id_pat 病人ID
	 * @param id_ent 就诊ID
	 * @param Code_srvca 服务项目分类，如果查药占比，则传“01”
	 * @return DTO:可消费余额，账户余额，已消费总额，特定服务分类占比
	 * @throws BizException
	 */
	@Override
	public  BlCgIpAmtAndUncgRationDTO GetBlcgIpAmtVsDrugRation(String id_pat,String id_ent,String code_srvca) throws BizException
	{
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.GetBlcgIpAmtVSsrvcaRation(id_pat,id_ent,code_srvca);
		
	}	
	
	/**
	 * 根据就诊和就诊类型，查询该就诊下发生的费用
	 * @param id_ent 就诊ID
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgAmtDTO GetBlCgAmtByIdEnt(String id_ent,String code_entp)  throws BizException
	{
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.GetBlCgAmtByIdEnt(id_ent,code_entp);
		
	}
	
	/**
	 * 从费用角度判断，是否可以分诊：
	 * 医嘱已交费，可以分诊；医嘱未交费，预交金余额任免支付，可以分诊；医嘱未交费，预交金余额不足，信用额度足够，可以分诊
	 * @param id_orArr 医嘱id_or数组
	 * @return 
	 * @throws BizException
	 */
	@Override
	public  FMap fSupportTriage_CiOrderFee(String[] id_orArr)   throws BizException
	{
		
		BlSupportTriageCiOrderFeeBp bp=new BlSupportTriageCiOrderFeeBp();
		return bp.fSupportTriage_CiOrderFee(id_orArr);
		
	}
	
	/**
	 * 从门诊费用明细表中获得该处方的所有费用信息
	 * @param id_pat 病人ID
	 * @param id_presarr 处方数组
	 * @return
	 * @throws BizException
	 */
	public BlCgPriceAndAmtDTO[] getBlCgPriceAndAmtDTOFromIdPres(String id_pat,String[] id_presarr)   throws BizException
	{
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.getBlCgPriceAndAmtDTOFromIdPres(id_pat,id_presarr);
		
	}
	
	
	/**
	 * 根据患者id_pat查询门诊未结算Fg_st='N'就诊信息
	 * @param id_pat 病人ID
	 * @return
	 * @throws BizException
	 * */
	public  BlRecgOepDTO[] findBlCgOepInfoByIdpat(String id_pat,String pat_code,String id_grp,String id_org) throws BizException
	{
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.findBlCgOepInfoByIdpat(id_pat,pat_code, id_grp, id_org);
	}
	
	/**
	 * 根据部门Id查询患者就诊信息
	 * */
	@Override
	public EntPatInfoDTO[] findEntPatInfoByDept(String id_dept)
			throws BizException {
		BlCgIpFeetailBp blCgIpFeetailBp = new BlCgIpFeetailBp();
		return blCgIpFeetailBp.getEntPatInfoByDept(id_dept);
	}
	
	/**
	 * 根据条件查询患者就诊信息
	 * */
	@Override
	public EntPatInfoDTO[] findEntPatInfoByCondition(String id_dept,
			String keyCond, String condition) throws BizException {
		BlCgIpFeetailBp blCgIpFeetailBp = new BlCgIpFeetailBp();
		return blCgIpFeetailBp.getEntPatInfoByDept(id_dept, keyCond, condition);
	}
	/**
	 * 根据条件查询会诊患者就诊信息
	 * */
	
	public EntPatInfoDTO[] findEntConPatInfoByCondition(String id_dept,
			String keyCond, String condition) throws BizException {
		BlCgIpConFeetailBp blCgIpConFeetailBp = new BlCgIpConFeetailBp();
		return blCgIpConFeetailBp.getEntPatConInfoByDept(id_dept, keyCond, condition);
	}

	@Override
	public BlBannerDTO[] findStMendBannerDtoInfo(String inputValue,
			String[] selectCondition) throws BizException {
		BlCgIpMendBp blCgIpMendBp = new BlCgIpMendBp();
		return blCgIpMendBp.getStMendBannerEnEntInfo(inputValue, selectCondition);
	}
	
	
	/**
	 * 返回指定结算号所有服务对应的发票分类<name code,amt_ratio>
	 * @param id_stoeps sql中in格式的，例如   '11','23'
	 * @return
	 * @throws BizException
	 */
	@Override
	public SrvVsInvoiceTypeDTO[] GetInvocieTypeByStOepId(
			String id_stoeps) throws BizException {
	
		GetInvoiceType GetInvoiceType=new GetInvoiceType();
		return GetInvoiceType.GetInvocieTypeByStOepId( id_stoeps);
	}
	
	@Override
	public PatiFixedFeeLeftDTO[] getPatientListInfo(String id_dep_nuradm)
			throws BizException {
		// TODO Auto-generated method stub
		BlstStrikeBalanceBp bp=new BlstStrikeBalanceBp();
		return bp.getPatientListInfo(id_dep_nuradm);
	}

	@Override
	public BlCgIpDO[] findBlCgIpDOsByIdent(String id_ent) throws BizException {
		// TODO Auto-generated method stub
		BlstStrikeBalanceBp bp=new BlstStrikeBalanceBp();
		return bp.findBlCgIpDOsByIdent(id_ent);
	}
	
	/*
	 * 按发票主键查询对应的发票信息
	 */
	@Override
    public BlIncItmVsTypeDTO[] getStIncInfoDtoByIncId(String strIdInc) throws BizException {
        BlCgOepQueryBp handlerBp=new BlCgOepQueryBp();      
        return handlerBp.getIncOepInfoDtoByIncId(strIdInc);
    }

    @Override
	  public BlCgIpDO[] saveNurseTuifee(BlCgIpDO[] blcgipDos,String ident) throws BizException{
//		  BlstStrikeBalanceBp bp=new BlstStrikeBalanceBp();
//			return bp.saveNurseTuifee(blcgipDos,ident);
    	NurseRedBackFeeBp handlerBp=new NurseRedBackFeeBp();
    	return handlerBp.exec(blcgipDos, ident);
	  }
    

	  @Override
	  public      FBoolean     savePrinterSetInfo(BlPrinterSetDTO viewDto) throws BizException{
		//BlPrinterSetDtoBp bp=new BlPrinterSetDtoBp();
		SavePrinterSetBp sbp=new SavePrinterSetBp();
		return sbp.execSavePrinterSetInfo(viewDto);
		  
	  }

	  @Override
	  public     BlPrinterSetDTO  findBlPrinterSetDtoInfo(String printerType) throws BizException {
		 // BlPrinterSetDtoBp  printet = new BlPrinterSetDtoBp();
		 // return  printet.findBlPrinterSetDtoInfo(printerType);
		  QryPrinterSetInfoBp qrybp =new QryPrinterSetInfoBp();
		  return  qrybp.execQryPrinterSetInfo(printerType);
	  }

	@Override
	public PatiFixedFeeLeftDTO[] getPatientListInfoByQueryCondition(
			String id_dep, String key, String value) throws BizException {
		
		BlstStrikeBalanceBp  bp=new BlstStrikeBalanceBp();
		return bp.getPatientListInfoByQueryCondition(id_dep,key,value);
	}

	@Override
	public BlIncItmVsTypeDTO[] getIncOepInfoDtoByIncId(String strIdInc)
			throws BizException {
		// TODO Auto-generated method stub
		BlCgOepQueryBp bp=new BlCgOepQueryBp();
		return bp.getIncOepInfoDtoByIncId(strIdInc);
	}
	
	
	/**
	 * 住院费用清单展示 根据查询模板条件查询
	 * @param querySchema  查询参数
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public BlIpAuditFeeDTO[] getIpFeeInfo(FMap2 queryMap) throws BizException {
		QueryBlCg queryBlCg = new QueryBlCg();
		return queryBlCg.queryBlCgByCond(queryMap);
	}
	
	/**
	 * 留观费用清单 费用明细查询
	 * @param querySchema  查询参数
	 * @return
	 * @throws BizException
	 * @author xuebei
	 */
	public BlIpAuditFeeDTO[] getEtFeeInfo(FMap2 queryMap) throws BizException {
		
		if(BlParams.BLST0002() == 1)
		{
			QueryOepBlCg queryBlCg = new QueryOepBlCg();
			return queryBlCg.queryOepBlCgByCond(queryMap);
		}
		else if(BlParams.BLST0002() == 2)
		{
			QueryBlCg queryBlCg = new QueryBlCg();
			return queryBlCg.queryBlCgByCond(queryMap);
		} 
		else
		{
			return null;
		}
	}
	
	/**
	 * 获取某服务项目对应的记账明细
	 * @param BlIpAuditFeeDTO
	 * @param PaginationInfo
	 * @author liwq
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditFeeDTO> getIpCgFeeDetail(BlIpAuditFeeDTO feeDto, PaginationInfo pageInfo) throws BizException{
		QueryBlCg queryBlCg = new QueryBlCg();
		return queryBlCg.getIpCgFeeDetail(feeDto, pageInfo);
	}

	/**
	 * 住院退补费-总费用
	 * @param String
	 * @param String
	 * @author zhanghw
	 * @throws BizException
	 */
	public BlIpFeeDTO[] getBlIpFeeDTO(String id_ent, String condition) throws BizException {
		BlIpFeeBp blIpFeeBp = new BlIpFeeBp();
		return blIpFeeBp.exec(id_ent, condition);
	}

	/**
	 * 住院退补费-费用明细
	 * @param String
	 * @param String[]
	 * @author zhanghw
	 * @throws BizException
	 */
	public BlIpFeeInfo[] getInfoData(String id_ent, String[] idList) throws BizException {
		GetBlIpInfoDataBp bp = new GetBlIpInfoDataBp();
		return bp.exec(id_ent, idList);
	}
	
	/**
	 * 获取某服务项目对应的记账明细
	 * @param BlIpAuditFeeDTO
	 * @param PaginationInfo
	 * @author liwq
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditFeeDTO> getEtCgFeeDetail(BlIpAuditFeeDTO feeDto, FMap2 queryMap ,PaginationInfo pageInfo) throws BizException{
		
		
		if(BlParamValueConst.BLST0002_OP.equals(BlParams.BLST0002()))
		{			
			QueryOepBlCg queryBlCg = new QueryOepBlCg();
			return queryBlCg.getOepCgFeeDetail(feeDto, queryMap ,pageInfo);
		}
		else if(BlParamValueConst.BLST0002_IP.equals(BlParams.BLST0002()))
		{
			QueryBlCg queryBlCg = new QueryBlCg();
			return queryBlCg.getIpCgFeeDetail(feeDto, pageInfo);
		} 
		else
		{
			return null;
		}
	}

	
 }
