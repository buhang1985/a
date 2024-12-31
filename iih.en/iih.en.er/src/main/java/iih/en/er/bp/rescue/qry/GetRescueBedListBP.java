package iih.en.er.bp.rescue.qry;

import iih.en.comm.ep.EntDiEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.util.AgeCalcUtil;

public class GetRescueBedListBP {

	/**
	 * 查询床位大卡信息
	 * 
	 * @param qryMod  查询模板
	 * @return
	 * @throws BizException
	 */
	public BedBigCardDTO[] exec(BedQryModDTO qryMod) throws BizException {
		// 1.查询大卡需要信息	
		BedBigCardDTO[] bedBigCardDTOs = this.getBedListForBigCard(qryMod);
		if (EnValidator.isEmpty(bedBigCardDTOs)) {
			return bedBigCardDTOs;
		}
		// 2.获得id_ent的list
		List<String> bedBigCardDTOList = this.GetBigCardEntIDList(bedBigCardDTOs);
		// 3.获取诊断的值
		bedBigCardDTOs = SetDiValue(bedBigCardDTOList, bedBigCardDTOs);
		// 4.获取医保的值
		bedBigCardDTOs = SetHPValue(bedBigCardDTOList, bedBigCardDTOs);
		//5.获取年龄
		this.setAge(bedBigCardDTOs);
		//6.获取滞留时长
		this.getErTimes(bedBigCardDTOs);
		//7.获取绿色通道信息
		this.getGreenChannel(bedBigCardDTOs,bedBigCardDTOList);
		//8.获取评分
		//this.getLevelNmae(bedBigCardDTOs,bedBigCardDTOList);
		return bedBigCardDTOs;
	}
	
	/**
	 * 查询大卡基础需要信息
	 * 
	 * @param qryMod
	 * @return
	 * @throws BizException
	 */
	private BedBigCardDTO[] getBedListForBigCard(BedQryModDTO qryMod) throws BizException {
		GetRescueBedListBaseBP qryBP = new GetRescueBedListBaseBP();
		BedBigCardDTO[] bigCardArr = qryBP.getBedListForBigCard(qryMod);
		return bigCardArr;
	}
	/**
	 * 获取查询到大卡的id_ent 组成list 便于统一查询诊断和医保
	 * 
	 * @param bedBigCardDTOs
	 * @return
	 */
	private List<String> GetBigCardEntIDList(BedBigCardDTO[] bedBigCardDTOs) {
		List<String> entIdList = new ArrayList<String>();
		for (BedBigCardDTO cardDO : bedBigCardDTOs) {
			if(EnValidator.isEmpty(cardDO.getId_ent()))
				continue;
			entIdList.add(cardDO.getId_ent());
		}
		return entIdList;
	}  
	/**
	 * 查找年龄
	 * @param pageBedDTO
	 */
	private void setAge( BedBigCardDTO[] bedBigCardDTOs){
		if(bedBigCardDTOs == null || bedBigCardDTOs.length <= 0)
			return;
		for(BedBigCardDTO obj: bedBigCardDTOs){
			if(obj.getDt_birth_pat()== null)
				continue;
			obj.setAge_pat(AgeCalcUtil.getAge(obj.getDt_birth_pat()));
		}
	}
	/**
	 * 获取滞留时长
	 * 
	 * @param urgNurErInfoDTO
	 * @param id_ent
	 */
	private void getErTimes(BedBigCardDTO[] bedBigCardDTOs){
		FDateTime datetime = EnAppUtils.getServerDateTime();
		if(bedBigCardDTOs == null || bedBigCardDTOs.length <= 0)
			return;
		for(BedBigCardDTO obj: bedBigCardDTOs){
			if(obj.getDt_erentry()== null)
				continue;
			obj.setTimes(DateTimeUtils.getTimeLength(obj.getDt_erentry(),datetime));
		}
	}
	/***
	 * 获取绿色通道信息
	 * 
	 * @param urgNurErInfoDTO
	 * @param id_ent
	 * @throws BizException 
	 */
	private void getGreenChannel(BedBigCardDTO[] bedBigCardDTOs,List<String> bedBigCardDTOList) throws BizException{
		if(bedBigCardDTOs == null || bedBigCardDTOs.length <= 0)
			return;
		if(bedBigCardDTOList == null || bedBigCardDTOList.size() <= 0)
			return;
		StringBuffer sql = new StringBuffer();
		sql.append("select er.* ");
		sql.append("from en_erpre er " );
		sql.append("inner join en_ent_op_er oper on  oper.id_erpre = er.id_erpre " );
		sql.append("inner join en_ent ent on ent.id_ent = er.id_ent_last ");
		sql.append("where "+EnSqlUtils.getInSqlByIds("oper.id_ent", bedBigCardDTOList));
		sql.append(" and "+EnSqlUtils.getInSqlByIds("ent.code_entp", EnParamUtils.getErTpNoComm())); 
		@SuppressWarnings("unchecked")
		List<EnErPreDO> list = (List<EnErPreDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(EnErPreDO.class));
		FMap map = new FMap();
		if(list != null && list.size() > 0){
			EnErPreDO[] enErPreDOs = list.toArray(new EnErPreDO[0]);
			ErPreEP ep = new ErPreEP();
			ep.setGreenNames(enErPreDOs,EnErPreDO.IDS_GREEN_CHANNEL_SYM,EnErPreDO.NAMES_GREEN_CHANNEL);
			for(EnErPreDO enErPreDO : enErPreDOs){
				map.put(enErPreDO.getId_ent_last(), enErPreDO.getNames_green_channel());
			}
			if(map != null && map.size() > 0){
				for(BedBigCardDTO obj: bedBigCardDTOs){
					if(map.get(obj.getId_ent()) != null){
						obj.setGreen_channel(map.get(obj.getId_ent()).toString());
					}
				}
			}
		}
	}
//	/***
//	 * 获取评分
//	 * 
//	 * @param urgNurErInfoDTO
//	 * @param id_ent
//	 * @throws BizException 
//	 */
//	private void getLevelNmae(BedBigCardDTO[] bedBigCardDTOs,List<String> bedBigCardDTOList) throws BizException{
//		if(bedBigCardDTOs == null || bedBigCardDTOs.length <= 0)
//			return;
//		if(bedBigCardDTOList == null || bedBigCardDTOList.size() <= 0)
//			return;
//		StringBuffer sql = new StringBuffer();
//		sql.append("select er.id_ent_last as id_ent, ");
//		sql.append("udi.name as name_score ");
//		sql.append("from en_erpre er " );
//		sql.append("inner join en_ent_op_er oper on  oper.id_erpre = er.id_erpre " );
//		sql.append("inner join en_ent ent on ent.id_ent = er.id_ent_last ");
//		sql.append("left join en_erpre_score sco on sco.id_erpre = oper.id_erpre ");
//		sql.append("inner join bd_udidoc udi on sco.sd_scotp = udi.code ");
//		sql.append("inner join bd_udidoclist list on udi.id_udidoclist = list.id_udidoclist ");
//		sql.append("where "+EnSqlUtils.getInSqlByIds("er.id_ent_last", bedBigCardDTOList));
//		sql.append(" and "+EnSqlUtils.getInSqlByIds("ent.code_entp", EnParamUtils.getErTpNoComm())); 
//		sql.append(" and list.code = ?"); 
//		SqlParam param = new SqlParam();
//		param.addParam(IEnDictCodeTypeConst.SD_STATUS_SCOTP);
//		@SuppressWarnings("unchecked")
//		List<BedBigCardDTO> list = (List<BedBigCardDTO>) new DAFacade().execQuery(sql.toString(),param, new BeanListHandler(BedBigCardDTO.class));
//		Map<String,String> map = new HashMap<>();
//		if(list != null && list.size() > 0){
//			for(BedBigCardDTO dto : list){
//				if(!map.containsKey(dto.getId_ent())){
//					map.put(dto.getId_ent(), dto.getName_score());
//				}else{
//					String name_score= map.get(dto.getId_ent());
//					map.remove(dto.getId_ent());
//					map.put(dto.getId_ent(), name_score+dto.getName_score());
//				}
//			}
//			if(map != null && map.size() > 0){
//				for(BedBigCardDTO obj: bedBigCardDTOs){
//					if(map.get(obj.getId_ent()) != null){
//						obj.setName_score(map.get(obj.getId_ent()));
//					}
//				}
//			}
//		}
//	}
	/**
	 * 设置诊断的值
	 * 
	 * @param entIdList
	 * @param bigCardArr
	 * @return
	 * @throws BizException
	 */
	private BedBigCardDTO[] SetDiValue(List<String> entIdList, BedBigCardDTO[] bigCardArr) throws BizException {
		EntDiEP entDiBP = new EntDiEP();
		EntDiDO[] diArray = entDiBP.getEntMajDiList(entIdList);
		if (!EnValidator.isEmpty(diArray)) {
			for (BedBigCardDTO cardDTO : bigCardArr) {
				if(EnValidator.isEmpty(cardDTO.getId_ent()))
					continue;
				for (EntDiDO diDO : diArray) {
					if (cardDTO.getId_ent().equals(diDO.getId_ent())) {
						if (EnValidator.isEmpty(diDO.getName_didef_dis())) {
							cardDTO.setDes_di(diDO.getSupplement());
						} else {
							cardDTO.setDes_di(diDO.getName_didef_dis());
						}
						break;
					}
				}
			}
		}
		return bigCardArr;
	}
	/**
	 * 设置医保的值
	 * 
	 * @param entIdList
	 * @param bigCardArr
	 * @return
	 * @throws BizException
	 */
	private BedBigCardDTO[] SetHPValue(List<String> entIdList, BedBigCardDTO[] bigCardArr) throws BizException {
		EntHpEP entHpBp = new EntHpEP();
		EntHpDO[] enhpDOArr = entHpBp.getEntMajHpList(entIdList);

		if (EnValidator.isEmpty(enhpDOArr)) {
			return bigCardArr;
		}
		for (BedBigCardDTO cardDTO : bigCardArr) {
			if(EnValidator.isEmpty(cardDTO.getId_ent()))
				continue;
			for (EntHpDO hpDO : enhpDOArr) {
				if (cardDTO.getId_ent().equals(hpDO.getId_ent())) {
					if (hpDO.getFg_maj() == FBoolean.TRUE) {
						cardDTO.setId_hp(hpDO.getId_hp());
						cardDTO.setName_hp(hpDO.getName_hp());
					} else {
						cardDTO.setId_hp_sec(hpDO.getId_hp());
						cardDTO.setName_hp_sec(hpDO.getName_hp());
					}
				}
			}
		}

		return bigCardArr;
	}
}

