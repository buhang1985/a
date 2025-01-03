package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.ep.EntDiEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.s.bp.ip.CalculateHosDaysBP;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 查询床位大卡
 * 
 * @author Sarah
 *
 */
public class GetBedBP {
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
		// 5.设置新生儿的标识和母亲对应的婴儿的entid
		this.setNBInfo(bedBigCardDTOs, bedBigCardDTOList);
		// 6.设置住院天数
        this.getInhosdays(bedBigCardDTOs);
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
		GetBedListForBigCardBP qryBP = new GetBedListForBigCardBP();
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
	 * 设置新生儿标识
	 * @param bigCardArr
	 * @param entIdList
	 * @throws BizException
	 */
	private void setNBInfo(BedBigCardDTO[] bigCardArr, List<String> entIdList) throws BizException {
		if (EnValidator.isEmpty(bigCardArr))
			return;
		NbEP nbep = new NbEP();  
		NewbornDO[] nbBBDOs = nbep.getNbChildren(entIdList);

		NewbornDO[] nbMMDOs = nbep.getNbMoms(entIdList);
		
//		for (BedBigCardDTO cardDTO : bigCardArr) {
//			cardDTO.setFg_nb(FBoolean.FALSE);
//			//for (NewbornDO nbDO : nbBBDOs) {
//				//if (!EnValidator.isEmpty(cardDTO.getId_ent()) && cardDTO.getId_ent().equals(nbDO.getId_ent_bb()) && FBoolean.TRUE.equals(cardDTO.getFg_nb())) {
//					//cardDTO.setFg_nb(FBoolean.TRUE);
//					//cardDTO.setDt_birth_bb(nbDO.getDt_birth());
//					break;
//				}
//			}
//		}
		if (!EnValidator.isEmpty(nbMMDOs) && !EnValidator.isEmpty(nbBBDOs) ) {
			for (BedBigCardDTO cardDTO : bigCardArr) {
				for (NewbornDO nbDO : nbMMDOs) {
					
					if (!EnValidator.isEmpty(cardDTO.getId_ent()) && cardDTO.getId_ent().equals(nbDO.getId_ent_mom())) {
						FArrayList flist = new FArrayList();
						this.getChildId(flist, nbBBDOs, nbDO.getId_ent_mom());
						cardDTO.setId_ent_nbs(flist);
					}
				}
			}
		}
		if (!EnValidator.isEmpty(nbBBDOs) ) {
			for (BedBigCardDTO cardDTO : bigCardArr) {
				for (NewbornDO nbDO : nbBBDOs) {
					if (!EnValidator.isEmpty(cardDTO.getId_ent()) && cardDTO.getId_ent().equals(nbDO.getId_ent_bb()) && FBoolean.TRUE.equals(cardDTO.getFg_nb())) {
						cardDTO.setFg_sepa(nbDO.getFg_sepa());//设置新生儿分离标志
						break;
					}
				}
			}
		}
	}
	/**
	 * 查找母亲对应的所有的孩子的id_ent
	 * @param flist
	 * @param nbDOs
	 * @param entId
	 */
	private void getChildId(FArrayList flist,NewbornDO[] nbDOs,String entId)
	{
		for(NewbornDO nbDO :nbDOs){
			if(!EnValidator.isEmpty(nbDO.getId_ent_mom()) && nbDO.getId_ent_mom().equals(entId)){
				flist.add(nbDO.getId_ent_bb());
			}
		}		
	}
	
	/**
	 * 计算入院天数
	 * @param bigCardArr
	 * @throws BizException 
	 */
	private void getInhosdays(BedBigCardDTO[] bigCardArr) throws BizException{
		if (EnValidator.isEmpty(bigCardArr))
			return;
		CalculateHosDaysBP daysBp  = new CalculateHosDaysBP();
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		for (BedBigCardDTO cardDTO : bigCardArr) {
			cardDTO.setDays_inhos(daysBp.calculate(cardDTO.getDt_acpt(), dateTime, cardDTO.getFg_ip() )+"天");
		}
	}
}
