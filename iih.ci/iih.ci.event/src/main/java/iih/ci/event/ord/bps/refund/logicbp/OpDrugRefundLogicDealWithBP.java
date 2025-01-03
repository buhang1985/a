package iih.ci.event.ord.bps.refund.logicbp;

import java.util.HashMap;
import java.util.Hashtable;

import iih.bd.base.utils.StringUtils;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.bps.refund.logicbp.common.OpRefundCommonLogicDealWithBP;
import iih.ci.event.ord.bps.refund.query.OpDrugRefundEntInfoQuery;
import iih.ci.event.ord.bps.refund.query.OpDrugRefundPressAllInfoQuery;
import iih.ci.event.ord.bps.refund.query.OpDrugRefundPressPriceInfoQuery;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPharmHerbOrDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrFeeDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrMmDTO;
import iih.ci.ord.iemsg.d.IEOpPharmPresDTO;
import iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊处方退费BS302逻辑处理
 * @author F
 *
 * @date 2019年9月17日上午10:36:13
 *
 * @classpath iih.ci.event.ord.bps.refund.logicbp.OpDrugRefundLogicDealWithBP
 */
public class OpDrugRefundLogicDealWithBP extends OpRefundCommonLogicDealWithBP {
	/**
	 * BS302消息数据分为3部分，A区：患者就诊基础信息；B区：处方信息；C区：已收费处方信息
	 * 1、NEW类型消息：医生新开处方后，发送NEW类型消息。处方信息区中为本次就诊所有未收费的处方详细信息。
	  *  已收费处方信息区中为本次就诊所有已收费的处方，该区可只传处方ID。平台通过覆盖未收费处方信息的方式，记录最新处方信息。
	 * 2、DELETE类型消息：医生删除处方后，当患者本次就诊下无处方时，发送DELETE类型消息。处方信息区及已收费处方信息区消息可都为空。
	 * -->3、RENEW类型消息：处方退费后，发送RENEW类型消息。该消息涉及数据范围为本次退费发票下所有药品处方。
	  * 处方信息区为本次退费发票范围内所有剩余的药品处方信息。已收费处方信息区为本次退费发票下所有的药品处方，该区可只传处方ID。
	  * 平台通过先删除已退费的处方后插入退费后剩余处方信息的方式，实现退费后处方信息记录。
	 */
	/**
	 * 生成集成平台药品医嘱服务退费数据信息 （门诊）
	 * A区就诊信息 B区未退费的信息 C区本次退费单下所有的处方信息 他们通过C-B得到哪些退费了
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpPharmOrEnDTO[] exec(OpRefund4IpEsDTO[] refund4IpEsDTOs) throws BizException {
		// 有效性校验
		if (OrdEventUtil.isEmpty(refund4IpEsDTOs))
			return null;
		String id_ors = getIdOrs(refund4IpEsDTOs);
		//String id_orsrvs = getIdOrSrvs(refund4IpEsDTOs);
		String id_preses = getIdPreses(refund4IpEsDTOs);
		//HashMap<String, OpRefund4IpEsDTO> KeyIdorsrvrefundMap = getOpRefundDTOMapKeyIdorsrv(refund4IpEsDTOs);
		//HashMap<String, OpRefund4IpEsDTO> KeyIdpresrefundMap = getOpRefundDTOMapKeyIdorsrv(refund4IpEsDTOs);
		// 获得医嘱签署信息 A区
		IEOpPharmOrEnDTO rtn = getIEMsg4OrSignInfo(id_ors);

		// 退费+未退费/B区/剩余=本次退费单下所有处方信息(已收费C区) 这里查询所有  通过收费标识id_su_bl区分哪些是退费的  哪些不是退费的
		IEOpPharmPresDTO[] presDtos = getAllRefundPressInfo(id_preses,rtn);
		
		//数据转换IEOpPharmPresDTO->IEOpPharmOrFeeDTO
		rtn.setIepharmfees(convertData(presDtos));//已收费 C区
		
		//通过收费标识筛选没有退费的数据 组成B区
		FArrayList2 unRefunLists = getUnRefundPressInfo(presDtos);
		rtn.setId_iepharmpreses(unRefunLists);
		
		//获取没有退费的处方ids串 西药草药都有
		String unRefundPress = getUnRefunPressIds(presDtos);
		
		//B区处方设置金额信息
		setValueToUnRefundPress(unRefundPress,rtn);
		
		// 西成药处方数据信息计算与处理
		ieOpPresItms4DrugWcHandle(unRefundPress, rtn);
		
		// 草药处方数据信息计算与处理
		ieOpPresItms4HerbHandle(unRefundPress, rtn);

		// 移除明细中处方下药品总量 - 累计退费数量= 0的数据   没必要了现在
		//removePresQuanIsNull(rtn, KeyIdorsrvrefundMap);

		return new IEOpPharmOrEnDTO[] { rtn };
	}
	/**
	 * 数据转换  直接将所有数据全部转换过去
	 * @param presDtos
	 * @return
	 * @throws BizException
	 */
	private FArrayList2 convertData(IEOpPharmPresDTO[] presDtos) throws BizException{
		if(OrdEventUtil.isEmpty(presDtos)) {
			return null;
		}
		FArrayList2 feelList2 = new FArrayList2();
		for (IEOpPharmPresDTO dto:presDtos) {
			//0184392: BUG:BS302处方信息部分退费时，消息内容不正确
			if(!OrdEventUtil.ID_SU_BL_2.equals(dto.getId_su_bl())){
				continue;
			}
			IEOpPharmOrFeeDTO fee = new IEOpPharmOrFeeDTO();
			fee.setOrdertypecode(dto.getOrdertypecode());
			fee.setOrdertypename(dto.getOrdertypename());
			fee.setOrderno(dto.getOrderno());
			feelList2.add(fee);
		}
		return feelList2;
	}
	/**
	 * 获取未退费的处方ids
	 * @param presDtos
	 * @return
	 * @throws BizException
	 */
	private String getUnRefunPressIds(IEOpPharmPresDTO[] presDtos)throws BizException {
		if(OrdEventUtil.isEmpty(presDtos)) {
			return null;
		}
		String unRegundPressIds="";
		for(IEOpPharmPresDTO allDto:presDtos) {
			if(OrdEventUtil.ID_SU_BL_0.equals(allDto.getId_su_bl())) {
				unRegundPressIds += allDto.getId_iepharmpres()+OrdEventUtil.COMMA_STR;
			}
		}
		if (unRegundPressIds.length() > 0) {
			unRegundPressIds = unRegundPressIds.substring(0, unRegundPressIds.length() - 1);
		}
		return unRegundPressIds;
	}
	/**
	 * 获取所有没有退费的数据 B区
	 * @param presDtos
	 * @return
	 * @throws BizException
	 */
	private FArrayList2 getUnRefundPressInfo(IEOpPharmPresDTO[] presDtos)throws BizException{
		if(OrdEventUtil.isEmpty(presDtos)) {
			return null;
		}
		FArrayList2 unRefunLists = new FArrayList2(); 
		for(IEOpPharmPresDTO allDto:presDtos) {
			if(OrdEventUtil.ID_SU_BL_0.equals(allDto.getId_su_bl())) {
				unRefunLists.add(allDto);
			}
		}
		return unRefunLists;
	}
	/**
	 * 获取所有处方信息
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private IEOpPharmPresDTO[] getAllRefundPressInfo(String id_preses,IEOpPharmOrEnDTO rtn)throws BizException{
		if(OrdEventUtil.isEmpty(id_preses) || OrdEventUtil.isEmpty(rtn)) {
			return null;
		}
		OpDrugRefundPressAllInfoQuery query = new OpDrugRefundPressAllInfoQuery(id_preses);
		IEOpPharmPresDTO[] predtos = (IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(query, IEOpPharmPresDTO.class);
		if(OrdEventUtil.isEmpty(predtos)) {
			return null;
		}
		return predtos;
	}
	/**
	 * 完善没有收费的/B区处方信息
	 * @param unRefundPress
	 * @throws BizException
	 */
	private void setValueToUnRefundPress(String unRefundPress,IEOpPharmOrEnDTO rtn)throws BizException{
		//设置金额信息（退费时一个处方可能退一部分 这里金额只是未退费的B区金额）
		if(OrdEventUtil.isEmpty(unRefundPress) || OrdEventUtil.isEmpty(rtn) || OrdEventUtil.isEmpty(rtn.getId_iepharmpreses())) {
			return;
		}
		OpDrugRefundPressPriceInfoQuery query = new OpDrugRefundPressPriceInfoQuery(unRefundPress);
		IEOpPharmPresDTO[] prePricedtos = (IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(query, IEOpPharmPresDTO.class);
		if(OrdEventUtil.isEmpty(prePricedtos)) {
			return;
		}
		//拼接
		FArrayList2 list2=rtn.getId_iepharmpreses();
		if(!OrdEventUtil.isEmpty(prePricedtos)) {
			for(int i=0;i<list2.size();i++) {
				IEOpPharmPresDTO preDto=(IEOpPharmPresDTO)list2.get(i);
				for(IEOpPharmPresDTO prePriceDto:prePricedtos) {
					if(StringUtils.isNotEmpty(preDto.getId_iepharmpres()) && StringUtils.isNotEmpty(prePriceDto.getId_iepharmpres())
							&& preDto.getId_iepharmpres().equals(prePriceDto.getId_iepharmpres())) {
						preDto.setPrescriptionmoney(prePriceDto.getPrescriptionmoney());
						preDto.setPrescriptionmoneyunit(prePriceDto.getPrescriptionmoneyunit());
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
	private void ieOpPresItms4DrugWcHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

		if (id_preses == null)
			return;
		//获得西成药处方明细信息
		OpDrugRefundWcLogicDealWithBP bp = new OpDrugRefundWcLogicDealWithBP();
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
		OpDrugRefundHerbDealWithBP bp = new OpDrugRefundHerbDealWithBP();
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

	// 移除明细中处方下药品总量 - 累计退费数量= 0的数据
	@SuppressWarnings("unused")
	private void removePresQuanIsNull(IEOpPharmOrEnDTO rtn, HashMap<String, OpRefund4IpEsDTO> refundMap) {
		if (OrdEventUtil.isEmpty(rtn))
			return;
		// 处方集合
		FArrayList2 iepharmpreses = rtn.getId_iepharmpreses();
		if (OrdEventUtil.isEmpty(iepharmpreses))
			return;
		for (Object presesObj : iepharmpreses) {
			IEOpPharmPresDTO iEOpPharmPresDTO = (IEOpPharmPresDTO) presesObj;
			FArrayList2 id_iepharmors = iEOpPharmPresDTO.getId_iepharmors();
			FArrayList2 id_iepharmwcors = iEOpPharmPresDTO.getId_iepharmwcors();
			if (!OrdEventUtil.isEmpty(id_iepharmors) && id_iepharmors.size() > 0) {
				int le = id_iepharmors.size();
				for (int i = le - 1; i >= 0; i--) {
					IEOpPharmHerbOrDTO herbOr = (IEOpPharmHerbOrDTO) id_iepharmors.get(i);
					FArrayList2 mms = herbOr.getId_iepharmormms();
					String iepharmor = herbOr.getId_iepharmor();
					OpRefund4IpEsDTO refundDTO = refundMap.get(iepharmor);
					if (!OrdEventUtil.isEmpty(refundDTO)) {
						FDouble quan = refundDTO.getQuan();
						String strAmount = ((IEOpPharmOrMmDTO) mms.get(0)).getWeight();
						if (!OrdEventUtil.isEmpty(strAmount)) {
							FDouble surplus = new FDouble(strAmount).sub(quan);
							if (surplus.compareTo(new FDouble(0)) <= 0) {
								id_iepharmors.remove(i);
							} else {
								((IEOpPharmOrMmDTO) mms.get(0)).setWeight(surplus.toString());
							}
						}
					}
				}
			}
			if (!OrdEventUtil.isEmpty(id_iepharmwcors) && id_iepharmwcors.size() > 0) {
				int le = id_iepharmwcors.size();
				for (int i = le - 1; i >= 0; i--) {
					IEOpPharmWcOrDTO wcOr = (IEOpPharmWcOrDTO) id_iepharmwcors.get(i);
					String iepharmor = wcOr.getId_iepharmwcor();
					OpRefund4IpEsDTO refundDTO = refundMap.get(iepharmor);
					if (!OrdEventUtil.isEmpty(refundDTO)) {
						FDouble quan = refundDTO.getQuan();
						String strAmount = wcOr.getAmount();
						if (!OrdEventUtil.isEmpty(strAmount)) {
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
	 * 获得医嘱签署信息 患者、就诊、签署
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private IEOpPharmOrEnDTO getIEMsg4OrSignInfo(String id_ors) throws BizException {
		String id_or = id_ors.split(OrdEventUtil.COMMA_STR)[0];

		// 医嘱数据信息查询
		OpDrugRefundEntInfoQuery qry = new OpDrugRefundEntInfoQuery(id_or);
		IEOpPharmOrEnDTO[] rtns = (IEOpPharmOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrEnDTO.class);

		// 返回
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
		// 设置域id
		rtns[0].setDomain_id("01");
		// 计算年龄
		if(!OrdEventUtil.isEmpty(rtns[0].getBirthday())) {
			rtns[0].setAge(AgeCalcUtil.getAge(rtns[0].getBirthday()));
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(rtns[0].getTimes())) {
			rtns[0].setTimes("0");
		}
		//就诊类型
		rtns[0].setVisittypecode(getParamCodeEntp(rtns[0].getVisittypecode()));
	}
}
