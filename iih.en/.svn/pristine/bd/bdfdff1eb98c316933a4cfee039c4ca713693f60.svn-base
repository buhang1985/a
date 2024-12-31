package iih.en.pv.s.bp.ip;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.bd.pp.dto.d.BlTplPriceDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mrfp.cimrsugdto.d.CiMrSugDTO;
import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.dto.d.BedCardDetailDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mp.nr.foreign.d.CiorderPreviewDTO;
import iih.mp.nr.foreign.i.IForeignService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取床位卡详细信息
 * 
 * @author renying
 *
 */
public class GetBedCardDetailBP {
	/**
	 * 获取床位卡详细信息
	 * 
	 * @param entId 就诊ID
	 * @return 床位卡详细信息
	 * @throws BizException
	 * @author renying
	 */
	public BedCardDetailDTO exec(String entId, String idBltpl) throws BizException {
		BedCardDetailDTO detailDTO = new BedCardDetailDTO();
		if (EnValidator.isEmpty(entId)) {
			return detailDTO;
		}
		detailDTO.setId_ent(entId);
		PatiVisitDO patiVisitDO = new PvEP().getPvById(entId);
		//获取床位单价
		if (!EnValidator.isEmpty(idBltpl)) 
			this.getBedPrice(detailDTO, idBltpl,patiVisitDO.getId_pripat());
		// 加载费用信息
		// 加载临床信息
		// 获取体温、脉搏、血压信息，iih.mp.nr.foreign.i.getCiorderPreviewDTOS(String id_ent)
		this.getBlInfo(detailDTO);
		this.getmpInfo(detailDTO);
		
		return detailDTO;
	}

	/**
	 * 费用信息
	 * 
	 * @param detailDTO
	 * @throws BizException
	 */
	private void getBlInfo(BedCardDetailDTO detailDTO) throws BizException {
		GetBalanceBP getBlcBP = new GetBalanceBP();
		BalanceDTO blanceDTO = getBlcBP.exec(detailDTO.getId_ent());
		if (blanceDTO != null) {
			detailDTO.setPrepaid(blanceDTO.getAmt_prepay());// 预交金
			detailDTO.setBill(blanceDTO.getAmt_uncg());// 账单
			detailDTO.setBalance(blanceDTO.getAmt_bal());// 余额
			detailDTO.setAmt_cred(blanceDTO.getAmt_cred());
			detailDTO.setAmt_hp(blanceDTO.getAmt_hp());
		}
	}

	/**
	 * 医技信息
	 * 
	 * @param detailDTO
	 * @throws BizException
	 */
	private void getmpInfo(BedCardDetailDTO detailDTO) throws BizException {
		int opera = EnParamUtils.getDisplayOpera();
		//0-不显示 1-取医嘱 2-取手麻系统 3-取emr系统
		switch (opera) {
		case 1:
			//手术
			ICiOrdEnService mrServices = ServiceFinder.find(ICiOrdEnService.class);
			List<CiMrSugDTO> list = mrServices.getCiOrdSurgeryInfo(detailDTO.getId_ent());
			if (!EnValidator.isEmpty(list)) {
				detailDTO.setName_ops(list.get(0).getName_sug());
				if (!EnValidator.isEmpty(list.get(0).getDt_start_sug())) {
					detailDTO.setDt_ops(new FDateTime(list.get(0).getDt_start_sug()));
				}
			}
			break;
		case 2:
			break;
		case 3:
			break;
		}
		IForeignService foreign = ServiceFinder.find(IForeignService.class);
		CiorderPreviewDTO[] ciorders = foreign.getCiorderPreviewDTOS(detailDTO
				.getId_ent());
		if (EnValidator.isEmpty(ciorders)) {
			return;
		}
		for (CiorderPreviewDTO cider : ciorders) {
			// 体温
			if (!EnValidator.isEmpty(cider.getCode())
					&& cider.getCode().equals(
							IMpNsDictCodeConst.SD_TEMPERATURE_SRVVT)) {
				detailDTO.setTemp(cider.getValue());
			}
			// 脉搏
			if (!EnValidator.isEmpty(cider.getCode())
					&& cider.getCode().equals(IMpNsDictCodeConst.SD_PLUS_SRVVT)) {
				detailDTO.setPulse(cider.getValue());
			}
			// 血压
			if (!EnValidator.isEmpty(cider.getCode())
					&& cider.getCode().equals(
							IMpNsDictCodeConst.SD_PRESSURE_SRVVT)) {
				detailDTO.setSbp(cider.getValue());
			}
		}

	}
	
	/**
	 * 查询床位单价
	 * 
	 * @param detailDTO
	 * @throws BizException 
	 * @author jizb
	 * @param patiVisitDO 
	 */
	private void getBedPrice(BedCardDetailDTO detailDTO, String idBltpl, String id_pripat) throws BizException {
		IBdPriCalcService bdPriCalcService = ServiceFinder.find(IBdPriCalcService.class);
		Map<String, BlTplPriceDTO> map = null;
		if(EnValidator.isEmpty(id_pripat)){
			map = bdPriCalcService.batchCalcBlTplPrice(new String[]{idBltpl});
		}
		else{
			map = bdPriCalcService.batchCalcBlTplPriceByPripat(new String[]{idBltpl}, id_pripat);
		}
		if (map == null || map.get(idBltpl) == null || map.get(idBltpl).getPrice_std() == null)
			return;
		DecimalFormat df = new DecimalFormat("######0.00");
		if(map.get(idBltpl).getRate() != null){
			detailDTO.setBed_price(df.format(map.get(idBltpl).getPrice_std().multiply(map.get(idBltpl).getRate())));
		}else{
			detailDTO.setBed_price(df.format(map.get(idBltpl).getPrice_std()));
		}
	}

}
