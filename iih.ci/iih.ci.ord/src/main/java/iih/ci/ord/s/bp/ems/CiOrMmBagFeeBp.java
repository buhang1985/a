package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.relmmbagtactics.d.RelMmBagTacticsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.save.op.CiOrRelUsgFeeOrSrvBuildBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @code 药品关联 药袋费用 (门诊、急诊流水、急诊抢救)
 * @author LiYue
 * @date 2020年1月9日,上午11:38:02
 */
public class CiOrMmBagFeeBp {

	public ArrayList<OrdSrvDO> exec(CiorderAggDO aggorder, CiEmsDTO ems, ArrayList<OrdSrvDO> orsrvs,Hashtable ht) throws BizException {
		//有效性校验  
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0 || ems.getCode_entp()==null )return null;
		//前台是否已经算过费用项目
		if (CiOrdUtils.isHasPriSrvHandled(ems).booleanValue())return null;
		//结果
		ArrayList<OrdSrvDO> rtnlist = new ArrayList<OrdSrvDO>();
		//查询关联的药袋费用  (门诊、急诊流水、急诊抢救)
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ems.getCode_entp()) ||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ems.getCode_entp())
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ems.getCode_entp()) )
		rtnlist = getOpMmBagFee( aggorder, orsrvs,ht);
		
		return rtnlist;
	}

	/**
	 * @throws BizException 
	 * @code 门诊查询关联的药袋费用
	 * @author LiYue
	 * @date 2020年1月9日,下午1:38:07
	 */
	private ArrayList<OrdSrvDO> getOpMmBagFee(CiorderAggDO aggorder,ArrayList<OrdSrvDO> orsrvs,Hashtable ht) throws BizException {
		//计算药袋费用的项目
		ArrayList<OrdSrvDO> needfulList = getNeedfulList(orsrvs);
		if(needfulList==null || needfulList.size()<=0) return new ArrayList<OrdSrvDO>();
		//查关联的药袋服务
		List<RelMmBagTacticsDO> bdBagSrv = getmmBagSrvList(orsrvs.get(0),needfulList);
		if(bdBagSrv==null || bdBagSrv.size()<=0) return new ArrayList<OrdSrvDO>();
		//转化DTO
		UsageRelFeeSrvDO[] bagfeesrvdos = conversionParam(bdBagSrv);
		//生成医嘱服务
		CiOrRelUsgFeeOrSrvBuildBP bp=new CiOrRelUsgFeeOrSrvBuildBP();
		OrdSrvDO[] rtarr = bp.exec(aggorder, bagfeesrvdos,ht);
		ArrayList<OrdSrvDO> ciBagSrv = new ArrayList<>();
		if(rtarr!=null&&rtarr.length>0) {
		Collections.addAll(ciBagSrv, rtarr);
		}
		
		return  ciBagSrv;	
		//ArrayList<OrdSrvDO> ciBagSrv = convertOrsrv(aggorder,needfulList,bdBagSrv);
		//return  ciBagSrv;
	}
	//转换器
	private UsageRelFeeSrvDO[] conversionParam(List<RelMmBagTacticsDO> bdBagSrv) {
		ArrayList<UsageRelFeeSrvDO> rt = new ArrayList<>();
		for (RelMmBagTacticsDO MmBagDO : bdBagSrv) {
			UsageRelFeeSrvDO srvDO = new UsageRelFeeSrvDO();
			srvDO.setId_srv(MmBagDO.getId_srv());
			srvDO.setId_unit(MmBagDO.getId_unit());
			srvDO.setQuan_medu(MmBagDO.getQuan_medu());
			srvDO.setReltype(OrSrvSourceFromEnum.MMBAGFEE);
			srvDO.setIsTotalQuanMd(FBoolean.FALSE);//单次模式
			rt.add(srvDO);
		}
		return rt.toArray(new UsageRelFeeSrvDO[bdBagSrv.size()]);
	}

	/**
	 * @code 生成药袋医嘱服务
	 * @author LiYue
	 * @date 2020年1月13日,下午5:14:45
	 * @param mmBagSrv
	 * @throws BizException 
	 */
	private ArrayList<OrdSrvDO> convertOrsrv(CiorderAggDO aggdo, ArrayList<OrdSrvDO> needfulList, List<RelMmBagTacticsDO> mmBagSrv) throws BizException {
		CiEnContextDTO CiEnContext = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		CiOrderDO ordo = aggdo.getParentDO();
		ArrayList<OrdSrvDO> list = new ArrayList<OrdSrvDO>();
		OrdSrvDO srvdo;
		for (RelMmBagTacticsDO relMmBag : mmBagSrv) {
			for (OrdSrvDO ordSrvDO : needfulList) {
				if(ordSrvDO.getId_mm().equals(relMmBag.getId_mm())) {
					srvdo = new OrdSrvDO();
					srvdo.setId_srv(relMmBag.getId_srv());
					srvdo.setName(ordSrvDO.getName()+"("+"药袋费"+")");
					srvdo.setQuan_medu(relMmBag.getQuan_medu());// 剂量
					srvdo.setId_medu(relMmBag.getId_unit());// 单位
					srvdo.setQuan_total_medu(relMmBag.getQuan_medu());
					MedSrvRelMmDTO srvrelmmdo = null;
					srvdo.setId_or(ordo.getId_or());
					srvdo.setId_pat(ordo.getId_pat());
					srvdo.setId_entp(ordo.getId_entp());
					srvdo.setCode_entp(ordo.getCode_entp());
					srvdo.setId_en(ordo.getId_en());
					srvdo.setId_srvtp(ordo.getId_srvtp());
					srvdo.setSd_srvtp(ordo.getSd_srvtp());
					srvdo.setFg_dose_anoma(FBoolean.FALSE);
					srvdo.setId_route(ordSrvDO.getId_route());
					srvdo.setId_routedes(ordSrvDO.getId_routedes());
					srvdo.setId_boil(ordSrvDO.getId_boil());
					srvdo.setId_boildes(ordSrvDO.getId_boildes());
					srvdo.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
					srvdo.setId_org_srv(ordo.getId_org_or());
					srvdo.setId_dep_srv(ordo.getId_dep_or());
					srvdo.setId_wg_or(ordo.getId_wg_or());
					srvdo.setId_emp_srv(ordo.getId_emp_or());
					srvdo.setDt_create(ordo.getDt_entry());
					srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
					srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
					srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
					srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
					srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
					srvdo.setDt_last_bl(ordo.getDt_last_bl());
					srvdo.setFg_or(FBoolean.FALSE);
					srvdo.setFg_bl(FBoolean.TRUE);
					srvdo.setFreq_name(IBdSrvDictCodeConst.NAME_FREQNUNITCT_ITEM_ONCE);
					srvdo.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
					srvdo.setEu_blmd(ordSrvDO.getEu_blmd()); // 本服务定价
					srvdo.setFg_mm(FBoolean.FALSE);
					srvdo.setFg_set(FBoolean.FALSE);
					srvdo.setFg_propc(FBoolean.FALSE);
					srvdo.setFg_self(FBoolean.FALSE);
					srvdo.setFg_pres_outp(FBoolean.FALSE);
					srvdo.setNote_srv("");
					srvdo.setId_srvca(ordSrvDO.getId_srvca());
					srvdo.setFg_bl(CiOrdUtils.nullHandle(ordSrvDO.getFg_bl()));
					srvdo.setCode_srv(ordSrvDO.getCode_dsdef());
					srvdo.setEu_sourcemd(OrSrvSourceFromEnum.BOILDESRELFEE);
					srvdo.setId_primd(ordSrvDO.getId_primd());
					srvdo.setId_dep_mp(ordSrvDO.getId_dep_mp());
					srvdo.setId_dep_srv(ordSrvDO.getId_dep_srv());
					srvdo.setId_srv_src(ordo.getId_srv());
					srvdo.setId_hp(CiEnContext.getId_hp());// 2016-07-12新增医保相关信息
					srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
					srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
					srvdo.setId_org_mp(srvdo.getId_dep_mp());
					CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv("", srvdo.getId_srv(), srvdo.getId_primd(), srvdo);
					srvdo.setFg_feertnable(FBoolean.TRUE);
					srvdo.setStatus(DOStatus.NEW);
					list.add(srvdo);
				}
			}
		}
		
		return list;
	}

	
	/**
	 * @code 查询关联的药袋费用 SRV
	 * @author LiYue
	 * @date 2020年1月13日,下午5:16:22
	 * @return
	 * @throws DAException 
	 */
	private List<RelMmBagTacticsDO> getmmBagSrvList(OrdSrvDO ems, ArrayList<OrdSrvDO> needfulList)  {
		//物品id校验
		String id_mms = getId_mms(needfulList);
		if(StringUtils.isEmpty(id_mms))
		{
			return null;
		}
		String sql = getSql(ems,id_mms);
		List<RelMmBagTacticsDO> mmBagSrv = null;
		try {
			mmBagSrv = (List<RelMmBagTacticsDO>) new DAFacade().execQuery(sql, new BeanListHandler(RelMmBagTacticsDO.class));
		} catch (DAException e) {
		}
		return mmBagSrv;
	}

	/**
	 * @code 过滤出需要计算药袋费用的项目
	 * @author LiYue
	 * @date 2020年1月13日,下午5:16:02
	 */
	private ArrayList<OrdSrvDO> getNeedfulList(ArrayList<OrdSrvDO> orsrvs){
		ArrayList<OrdSrvDO> needfulList = new ArrayList<OrdSrvDO>();
		for (OrdSrvDO ordSrvDO : orsrvs) {
			if (DOStatus.DELETED != ordSrvDO.getStatus() && ordSrvDO.getSd_srvtp() != null
					&& ordSrvDO.getFg_bl().booleanValue()) {
				needfulList.add(ordSrvDO);
			}
		}
		return needfulList;
	}
	
	//就诊类型匹配
	private String getCode_enStr(OrdSrvDO ems) {
		switch (ems.getCode_entp()) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP://门诊
			return"FG_use_op";
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW://急诊流水
			return"FG_use_er";
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID://急诊抢救
			return"FG_use_er1";
		default:
			break;
		}
		return null;
	}

	private String getSql(OrdSrvDO ems,String id_mms) {
		String code_enStr = getCode_enStr(ems);
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(" 				select id_srv,id_mm,quan_medu,id_unit 	");
		sBuilder.append(" 				from BD_RELMMBAG_TACTICS  				");
		sBuilder.append(String.format(" where id_grp='%s' 						",CiOrdAppUtils.getEnvContext().getGroupId()));
		sBuilder.append(String.format(" AND id_org='%s' 						",CiOrdAppUtils.getEnvContext().getOrgId()));
		sBuilder.append(String.format(" and %s ='Y' 							",code_enStr));
		sBuilder.append(String.format(" and id_mm in(%s)						 ",id_mms));
		return sBuilder.toString();
	}

	//过滤出需要的查询的物品
	private String getId_mms(ArrayList<OrdSrvDO> needfulList) {
		String id_mms = "";
		// 遍历
		for (OrdSrvDO ordSrvDO : needfulList) {
			if(ordSrvDO!=null && StringUtils.isNotEmpty(ordSrvDO.getId_mm())) {
				id_mms += CiOrdUtils.SQUOTE_MARK_STR+ordSrvDO.getId_mm()+CiOrdUtils.SQUOTE_MARK_STR+CiOrdUtils.COMMA_STR;
			}
		}
		if(id_mms.length()<=0) return null;
		id_mms=id_mms.substring(0,id_mms.length()-1);
		return id_mms;
	}
	
	
	
	
	
}
