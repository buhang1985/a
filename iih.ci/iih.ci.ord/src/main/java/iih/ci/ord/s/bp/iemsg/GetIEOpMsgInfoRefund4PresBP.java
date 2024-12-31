package iih.ci.ord.s.bp.iemsg;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.bl.cg.service.IBlcgqueryService;
import iih.ci.ord.iemsg.d.IEOpPharmHerbOrDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrFeeDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrMmDTO;
import iih.ci.ord.iemsg.d.IEOpPharmPresDTO;
import iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugConfirmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugPresMesg8IdPresQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugPresRefundMesg8IdPresQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS302：处方信息服务</br>
 * 生成集成平台药品医嘱退费服务数据信息操作BP （门诊）
 */
public class GetIEOpMsgInfoRefund4PresBP extends GetIEOpMsgInfoRefundAbstractBP {

	/**
	 * 生成集成平台药品医嘱服务退费数据信息 （门诊）
	 * 
	 * @param id_ors
	 *            医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpPharmOrEnDTO[] exec(OpRefund4IpEsDTO[] refund4IpEsDTOs) throws BizException {
		// 有效性校验
		if (CiOrdUtils.isEmpty(refund4IpEsDTOs))
			return null;
		String id_ors = getIdOrs(refund4IpEsDTOs);
		String id_orsrvs = getIdOrSrvs(refund4IpEsDTOs);
		String id_preses = getIdPreses(refund4IpEsDTOs);
		HashMap<String, OpRefund4IpEsDTO> KeyIdorsrvrefundMap = getOpRefundDTOMapKeyIdorsrv(refund4IpEsDTOs);
		HashMap<String, OpRefund4IpEsDTO> KeyIdpresrefundMap = getOpRefundDTOMapKeyIdorsrv(refund4IpEsDTOs);
		// 获得医嘱签署信息
		IEOpPharmOrEnDTO rtn = getIEMsg4OrSignInfo(id_ors);

		//pharmPresInfoHandle(id_preses, rtn);

		// 西成药处方数据信息计算与处理
		//ieOpPresItms4DrugWcHandle(id_preses, rtn);
		// 设置已收费处方信息
		iepharmfeesHandle(KeyIdpresrefundMap, rtn,id_preses);
		//iepharmfeesHandle(id_preses, rtn);
		// 草药处方数据信息计算与处理
		//ieOpPresItms4HerbHandle(id_preses, rtn);

		// 移除明细中处方下药品总量 - 累计退费数量= 0的数据
		removePresQuanIsNull(rtn, KeyIdorsrvrefundMap);

		return new IEOpPharmOrEnDTO[] { rtn };
	}

	private void iepharmfeesHandle(HashMap<String, OpRefund4IpEsDTO> keyIdpresrefundMap, IEOpPharmOrEnDTO rtn,String id_preses) throws BizException {
		if (CiOrdUtils.isEmpty(keyIdpresrefundMap)) {
			return;
		}
		FArrayList2 list = new FArrayList2();
		Collection<OpRefund4IpEsDTO> collection = keyIdpresrefundMap.values();
		if (CiOrdUtils.isEmpty(id_preses))
			return;
		// 处方号信息查询
		CiOpDrugPresRefundMesg8IdPresQry qry = new CiOpDrugPresRefundMesg8IdPresQry(id_preses);
		IEOpPharmOrFeeDTO[] predtos = (IEOpPharmOrFeeDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrFeeDTO.class);
		for (OpRefund4IpEsDTO dto : collection) {
			IEOpPharmOrFeeDTO fee = new IEOpPharmOrFeeDTO();
			//fee.setOrderno(dto.getId_pres());
			fee.setOrdertypecode(dto.getCode_applytp());
			list.add(fee);
		}
		for (int i=0;i<predtos.length;i++) {
			IEOpPharmOrFeeDTO fee1 = new IEOpPharmOrFeeDTO();
			fee1.setOrderno(predtos[i].getOrderno());
			list.add(fee1);
		}
		rtn.setIepharmfees(list);
	}
	
	
	// 移除明细中处方下药品总量 - 累计退费数量= 0的数据
	private void removePresQuanIsNull(IEOpPharmOrEnDTO rtn, HashMap<String, OpRefund4IpEsDTO> refundMap) {
		if (CiOrdUtils.isEmpty(rtn))
			return;
		// 处方集合
		FArrayList2 iepharmpreses = rtn.getId_iepharmpreses();
		if (CiOrdUtils.isEmpty(iepharmpreses))
			return;
		for (Object presesObj : iepharmpreses) {
			IEOpPharmPresDTO iEOpPharmPresDTO = (IEOpPharmPresDTO) presesObj;
			FArrayList2 id_iepharmors = iEOpPharmPresDTO.getId_iepharmors();
			FArrayList2 id_iepharmwcors = iEOpPharmPresDTO.getId_iepharmwcors();
			if (!CiOrdUtils.isEmpty(id_iepharmors) && id_iepharmors.size() > 0) {
				int le = id_iepharmors.size();
				for (int i = le - 1; i >= 0; i--) {
					IEOpPharmHerbOrDTO herbOr = (IEOpPharmHerbOrDTO) id_iepharmors.get(i);
					FArrayList2 mms = herbOr.getId_iepharmormms();
					String iepharmor = herbOr.getId_iepharmor();
					OpRefund4IpEsDTO refundDTO = refundMap.get(iepharmor);
					if (!CiOrdUtils.isEmpty(refundDTO)) {
						FDouble quan = refundDTO.getQuan();
						String strAmount = ((IEOpPharmOrMmDTO)mms.get(0)).getWeight();
						if (!CiOrdUtils.isEmpty(strAmount)) {
							FDouble surplus = new FDouble(strAmount).sub(quan);
							if (surplus.compareTo(new FDouble(0)) <= 0) {
								id_iepharmors.remove(i);
							} else {
								((IEOpPharmOrMmDTO)mms.get(0)).setWeight(surplus.toString());
							}
						}
					}
				}
			}
			if (!CiOrdUtils.isEmpty(id_iepharmwcors) && id_iepharmwcors.size() > 0) {
				int le = id_iepharmwcors.size();
				for (int i = le - 1; i >= 0; i--) {
					IEOpPharmWcOrDTO wcOr = (IEOpPharmWcOrDTO) id_iepharmwcors.get(i);
					String iepharmor = wcOr.getId_iepharmwcor();
					OpRefund4IpEsDTO refundDTO = refundMap.get(iepharmor);
					if (!CiOrdUtils.isEmpty(refundDTO)) {
						FDouble quan = refundDTO.getQuan();
						String strAmount = wcOr.getAmount();
						if (!CiOrdUtils.isEmpty(strAmount)) {
							FDouble surplus = new FDouble(strAmount).sub(quan);
							if (surplus.compareTo(new FDouble(0)) <= 0) {
								id_iepharmwcors.remove(i);
							} else {
								wcOr.setAmount(surplus.toString());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 西成药处方数据信息计算与处理
	 * 
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private void ieOpPresItms4HerbHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

		if (id_preses == null)
			return;
		// 获得草药处方明细信息
		GetIEOpMsgInfo4DrugHerbBP bp = new GetIEOpMsgInfo4DrugHerbBP();
		Hashtable<String, FArrayList2> list = bp.exec(id_preses);

		// 空判断
		if (CiOrdUtils.isEmpty(list))
			return;

		// 药品处方
		FArrayList2 list2 = rtn.getId_iepharmpreses();
		if (CiOrdUtils.isEmpty(list2))
			return;
		IEOpPharmPresDTO presdto = null;
		String id_pres = "";

		// 遍历
		for (int i = 0; i < list2.size(); i++) {
			presdto = (IEOpPharmPresDTO) list2.get(i);
			id_pres = presdto.getId_iepharmpres();
			if (CiOrdUtils.isEmpty(list.get(id_pres)))
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
		// 获得西成药处方明细信息
		GetIEOpMsgInfo4DrugWcBP bp = new GetIEOpMsgInfo4DrugWcBP();
		Hashtable<String, FArrayList2> list = bp.exec(id_preses);

		// 空判断
		if (CiOrdUtils.isEmpty(list))
			return;

		// 药品处方
		FArrayList2 list2 = rtn.getId_iepharmpreses();
		if (CiOrdUtils.isEmpty(list2))
			return;
		IEOpPharmPresDTO presdto = null;
		String id_pres = "";

		// 遍历
		for (int i = 0; i < list2.size(); i++) {
			presdto = (IEOpPharmPresDTO) list2.get(i);
			id_pres = presdto.getId_iepharmpres();
			if (CiOrdUtils.isEmpty(list.get(id_pres)))
				continue;
			presdto.setId_iepharmwcors(list.get(id_pres));
		}
	}

	/**
	 * 获得医嘱签署信息 患者、就诊、签署
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private IEOpPharmOrEnDTO getIEMsg4OrSignInfo(String id_ors) throws BizException {
		String id_or = id_ors.split(CiOrdUtils.COMMA_STR)[0];

		// 医嘱数据信息查询
		CiOpDrugConfirmQry qry = new CiOpDrugConfirmQry(id_or);
		IEOpPharmOrEnDTO[] rtns = (IEOpPharmOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrEnDTO.class);

		// 返回
		if (CiOrdUtils.isEmpty(rtns))
			return null;

		// 设置域id
		rtns[0].setDomain_id("01");
		// 计算年龄
		rtns[0].setAge(AgeCalcUtil.getAge(rtns[0].getBirthday()));

		return rtns[0];
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
	private void pharmPresInfoHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {
		// String id_ors=getIDOrs(id_wc_ors,id_herb_ors);
		if (CiOrdUtils.isEmpty(id_preses))
			return;
		// 医嘱数据信息查询
		CiOpDrugPresMesg8IdPresQry qry = new CiOpDrugPresMesg8IdPresQry(id_preses);
		IEOpPharmPresDTO[] predtos = (IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmPresDTO.class);
		// 空判断
		if (CiOrdUtils.isEmpty(predtos))
			return;
		FArrayList2 preslist = handlePres(predtos);

		rtn.setId_iepharmpreses(preslist);

	}

	/**
	 * 合并医嘱ID字串
	 * 
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @return
	 */
	private String getIDOrs(String id_wc_ors, String id_herb_ors) {
		if (CiOrdUtils.isEmpty(id_wc_ors)) {
			return id_herb_ors;
		} else {
			if (CiOrdUtils.isEmpty(id_herb_ors))
				return id_wc_ors;
			return id_wc_ors + CiOrdUtils.COMMA_STR + id_herb_ors;
		}
	}

	private FArrayList2 handlePres(IEOpPharmPresDTO[] predtos) throws BizException {

		FArrayList2 feelist = new FArrayList2();
		for (IEOpPharmPresDTO ieOpPharmPresDTO : predtos) {
			feelist.add(ieOpPharmPresDTO);
		}
		return feelist;

	}

	private Map<String, FBoolean> getFeedtos(IEOpPharmPresDTO[] predtos) throws BizException {

		IBlcgqueryService service = ServiceFinder.find(IBlcgqueryService.class);
		String[] idpreses = new String[predtos.length];
		int i = 0;
		for (IEOpPharmPresDTO ieOpPharmPresDTO : predtos) {
			idpreses[i] = ieOpPharmPresDTO.getId_iepharmpres();
			i++;
		}

		return service.querySettlementByIdPres_Oep(idpreses);

	}

}
