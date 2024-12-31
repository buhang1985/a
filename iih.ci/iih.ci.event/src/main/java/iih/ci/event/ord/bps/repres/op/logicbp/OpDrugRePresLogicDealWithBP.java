package iih.ci.event.ord.bps.repres.op.logicbp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.event.ord.bps.repres.op.query.OpDrugRePresEntInfoQuery;
import iih.ci.event.ord.bps.repres.op.query.OpDrugRePresPressInfoQuery;
import iih.ci.event.ord.bps.repres.op.query.OpDrugRePresPressPriceInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrFeeDTO;
import iih.ci.ord.iemsg.d.IEOpPharmPresDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
/**
 * BS302 重新分方 总逻辑处理
 * @author F
 *
 * @date 2019年9月11日上午11:11:22
 *
 * @classpath iih.ci.event.ord.bps.repres.op.logicbp.OpDrugRePresLogicDealWithBP
 */
public class OpDrugRePresLogicDealWithBP extends CommonParamBP{
	/**
	 * 生成集成平台药品医嘱服务数据信息 （门诊）
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpPharmOrEnDTO[] exec(OrdEventFireDTO firedto) throws BizException {
		String id_wc_ors=firedto.getIdwcors();
		String id_herb_ors=firedto.getIdherbors();
		String iden=firedto.getIdent();
		//有效性校验
		if (OrdEventUtil.isEmpty(iden)||(OrdEventUtil.isEmpty(id_wc_ors) && OrdEventUtil.isEmpty(id_herb_ors)))
			return null;
		
		//获得医嘱签署信息
		IEOpPharmOrEnDTO rtn = getIEMsg4OrSignInfo(id_wc_ors, id_herb_ors);

		//获得处方信息
		String id_preses = pharmPresInfoHandle(id_wc_ors, id_herb_ors, rtn, iden);//"1001Z7100000000GWQMU"

		//西成药处方数据信息计算与处理
		ieOpPresItms4DrugWcHandle(id_preses, rtn);
		//草药处方数据信息计算与处理
		ieOpPresItms4HerbHandle(id_preses, rtn);
		return new IEOpPharmOrEnDTO[] { rtn };
	}

	/**
	 * 拼装医嘱id
	 * @param ciorders
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getDrugIdOrs(CiOrderDO[] ciorders) {
		String result ="";
		for (CiOrderDO ciOrderDO : ciorders) {
			result += ciOrderDO.getId_or()+",";
		}
		return result;
	}
	/**
	 * 生成集成平台药品医嘱服务数据信息 （门诊医嘱重分方）
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpPharmOrEnDTO[] execAgain(String id_wc_ors, String id_herb_ors, String iden) throws BizException {
		//有效性校验
		if (OrdEventUtil.isEmpty(id_wc_ors) && OrdEventUtil.isEmpty(id_herb_ors))
			return null;

		//获得医嘱就诊信息
		IEOpPharmOrEnDTO rtn = getIEMsg4OrSignInfo(id_wc_ors, id_herb_ors);

		//获得处方信息
		String id_preses = pharmPresInfoHandle(id_wc_ors, id_herb_ors, rtn, iden);//"1001Z7100000000GWQMU"

		//西成药处方数据信息计算与处理
		ieOpPresItms4DrugWcHandle(id_preses, rtn);

		//草药处方数据信息计算与处理
		ieOpPresItms4HerbHandle(id_preses, rtn);

		return new IEOpPharmOrEnDTO[] { rtn };
	}

	/**
	 * 草处方数据信息计算与处理
	 * 
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private void ieOpPresItms4HerbHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

		if (id_preses == null)
			return;
		//获得草药处方明细信息
		OpDrugRePresHerbLogicDealWithBP bp = new OpDrugRePresHerbLogicDealWithBP();
		Hashtable<String, FArrayList2> list = bp.exec(id_preses);

		//空判断
		if (OrdEventUtil.isEmpty(list))
			return;

		//药品处方
		FArrayList2 list2 = rtn.getId_iepharmpreses();
		if (OrdEventUtil.isEmpty(list2))
			return;
		IEOpPharmPresDTO presdto = null;
		String id_pres = "";

		//遍历
		for (int i = 0; i < list2.size(); i++) {
			presdto = (IEOpPharmPresDTO) list2.get(i);
			id_pres = presdto.getId_iepharmpres();
			if (OrdEventUtil.isEmpty(list.get(id_pres)))
				continue;
			presdto.setId_iepharmors(list.get(id_pres));
		}
	}

	/**
	 * 西成药处方数据信息计算与处理
	 * 
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private void ieOpPresItms4DrugWcHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

		if (id_preses == null)
			return;
		//获得西成药处方明细信息
		OpDrugRePresWcLogicDealWithBP bp = new OpDrugRePresWcLogicDealWithBP();
		Hashtable<String, FArrayList2> list = bp.exec(id_preses);

		//空判断
		if (OrdEventUtil.isEmpty(list))
			return;

		//药品处方
		FArrayList2 list2 = rtn.getId_iepharmpreses();
		if (OrdEventUtil.isEmpty(list2))
			return;
		IEOpPharmPresDTO presdto = null;
		String id_pres = "";

		//遍历
		for (int i = 0; i < list2.size(); i++) {
			presdto = (IEOpPharmPresDTO) list2.get(i);
			id_pres = presdto.getId_iepharmpres();
			if (OrdEventUtil.isEmpty(list.get(id_pres)))
				continue;
			presdto.setId_iepharmwcors(list.get(id_pres));
		}
	}

	/**
	 * 获得医嘱就诊信息
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private IEOpPharmOrEnDTO getIEMsg4OrSignInfo(String id_wc_ors, String id_herb_ors) throws BizException {
		String id_or = getOr(id_wc_ors, id_herb_ors);
		// 医嘱就诊信息查询
		OpDrugRePresEntInfoQuery qry = new OpDrugRePresEntInfoQuery(id_or);
		IEOpPharmOrEnDTO[] rtns = (IEOpPharmOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrEnDTO.class);

		//返回
		if (OrdEventUtil.isEmpty(rtns))
			return null;
		//设置值
		setValue(rtns);
		return rtns[0];
	}
	/**
	 * 设置值
	 * @param rtns
	 */
	private void setValue(IEOpPharmOrEnDTO[] rtns) {
		//设置域id
		rtns[0].setDomain_id("01");
		//计算年龄
		rtns[0].setAge(AgeCalcUtil.getAge(rtns[0].getBirthday()));
		//就诊次数
		if(OrdEventUtil.isEmpty(rtns[0].getTimes())) {
			rtns[0].setTimes("0");
		}
		//就诊类别
		rtns[0].setVisittypecode(getParamCodeEntp(rtns[0].getVisittypecode()));
	}

	/**
	 * 获得药品处方数据信息 西成药 草药
	 * 
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String pharmPresInfoHandle(String id_wc_ors, String id_herb_ors, IEOpPharmOrEnDTO rtn, String id_en)
			throws BizException {

		// 医嘱数据信息查询
		OpDrugRePresPressInfoQuery qry = new OpDrugRePresPressInfoQuery(id_en);
		IEOpPharmPresDTO[] predtos = (IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmPresDTO.class);
		//查询处方金额 根据处方id进行拼接
		OpDrugRePresPressPriceInfoQuery priceQry = new OpDrugRePresPressPriceInfoQuery(id_en);
		IEOpPharmPresDTO[] prePricedtos = (IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(priceQry, IEOpPharmPresDTO.class);
		//空判断
		if (OrdEventUtil.isEmpty(predtos)) {
			return null;
		}
		//拼接
		if(!OrdEventUtil.isEmpty(prePricedtos)) {
			for(IEOpPharmPresDTO preDto:predtos) {
				for(IEOpPharmPresDTO prePriceDto:prePricedtos) {
					if(StringUtils.isNotEmpty(preDto.getId_iepharmpres()) && StringUtils.isNotEmpty(prePriceDto.getId_iepharmpres())
							&& preDto.getId_iepharmpres().equals(prePriceDto.getId_iepharmpres())) {
						preDto.setPrescriptionmoney(prePriceDto.getPrescriptionmoney());
						preDto.setPrescriptionmoneyunit(prePriceDto.getPrescriptionmoneyunit());
					}
				}
			}
		}
		//设置已收费处方数据
		List<IEOpPharmPresDTO> preslist = handlePres(predtos, rtn);

		//空判断
		if (preslist == null || preslist.isEmpty())
			return null;

		//参数设置
		FArrayList2 list = new FArrayList2();
		String rtnstr = "";

		IEOpPharmPresDTO oo = new IEOpPharmPresDTO();
		
		//遍历
		for (IEOpPharmPresDTO o : preslist) {

			//去除重复处方号
			if (oo != null && o.getOrderno().equals((oo.getOrderno()))) {
				continue;
			}
			oo.setOrderno(o.getOrderno());
			list.add(o);
			rtnstr += OrdEventUtil.COMMA_STR + o.getId_iepharmpres();
		}

		//设置未收费处方集合数据信息
		rtn.setId_iepharmpreses(list);

		if (rtnstr.equals(""))
			return null;
		//返回
		return rtnstr.substring(1);
	}

	/**
	 * 获得一个医嘱ID
	 * 
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @return
	 */
	private String getOr(String id_wc_ors, String id_herb_ors) {
		String id_ors = null;
		if (!OrdEventUtil.isEmpty(id_wc_ors)) {
			id_ors = id_wc_ors;
		} else {
			id_ors = id_herb_ors;
		}

		return id_ors.split(OrdEventUtil.COMMA_STR)[0];
	}

	/**
	 * 合并医嘱ID字串
	 * 
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getIDOrs(String id_wc_ors, String id_herb_ors) {
		if (OrdEventUtil.isEmpty(id_wc_ors)) {
			return id_herb_ors;
		} else {
			if (OrdEventUtil.isEmpty(id_herb_ors))
				return id_wc_ors;
			return id_wc_ors + OrdEventUtil.COMMA_STR + id_herb_ors;
		}
	}

	@SuppressWarnings("unchecked")
	private List<IEOpPharmPresDTO> handlePres(IEOpPharmPresDTO[] predtos, IEOpPharmOrEnDTO rtn) throws BizException {

		List<IEOpPharmPresDTO> preslist = new ArrayList<>();
		FArrayList2 feelist = new FArrayList2();

		Map<String, FBoolean> feernt = getFeedtos(predtos);

		for (IEOpPharmPresDTO ieOpPharmPresDTO : predtos) {
			if (feernt.get(ieOpPharmPresDTO.getId_iepharmpres()).booleanValue()) {
				IEOpPharmOrFeeDTO feedto = new IEOpPharmOrFeeDTO();
				feedto.setOrderno(ieOpPharmPresDTO.getOrderno());
				feedto.setOrdertypecode(ieOpPharmPresDTO.getOrdertypecode());
				feedto.setOrdertypename(ieOpPharmPresDTO.getOrdertypename());
				feelist.add(feedto);
			} else {

				preslist.add(ieOpPharmPresDTO);
			}
		}
		//设置已收费处方
		rtn.setIepharmfees(feelist);
		return preslist;

	}

	@SuppressWarnings("unchecked")
	private Map<String, FBoolean> getFeedtos(IEOpPharmPresDTO[] predtos) throws BizException {

//		IBlcgqueryService service = ServiceFinder.find(IBlcgqueryService.class);
		String[] idpreses = new String[predtos.length];
		int i = 0;
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		String ids="";
		
		for (IEOpPharmPresDTO ieOpPharmPresDTO : predtos) {
			idpreses[i] = ieOpPharmPresDTO.getId_iepharmpres();
			ids+="'"+ieOpPharmPresDTO.getId_iepharmpres()+"',";
			i++;
		}
		Map<String, FBoolean> result = new HashMap<String,FBoolean>();
		//2017-08-11 14:52:33  by yzh 修改原因:原判断根据处方id调用费用接口返回该处方是否已收费,现修改为根据ci_or_srv的记账标识 id_su_bl判断是否记账
		// 查询
		sqlb.append(" select A.id_pres,B.id_su_bl from ci_pres A left outer join ci_or_srv B on A.id_pres=B.id_pres where A.id_pres in ("+ids.substring(0, ids.length()-1)+")");
		List<Map<String,Object>> rlt = (List<Map<String,Object>>)dafacade.
				execQuery(sqlb.toString(), new MapListHandler());
		for (String id_pres : idpreses) {
			boolean isAcount= false;
			for (Map<String, Object> map : rlt) {
				String id = (String) map.get("id_pres");
				String id_su_bl = (String) map.get("id_su_bl");
				if(id_pres.equals(id)){
					if(id_su_bl.equals(ICiDictCodeTypeConst.ID_SU_BL_0)) isAcount=true;
				}
			}
			if(isAcount){
				result.put(id_pres, FBoolean.TRUE);
			}else{
				result.put(id_pres, FBoolean.FALSE);
			}
		}
		return result;

	}
}
