package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;

/**
 * 根据药品类型生成处方<br>
 * 中草药处方（药品类型为中草药）
 * 
 * @author HUMS
 *
 */
public class PresBySdMmtpDrugChihe extends AbstractSinglePresRuleExecutor {

	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		if (IBdMmDictCodeConst.SD_MMTP_DRUG_CHIHE.equals(orderPresSplit.getSd_mmtp())) {
			return true;
		}
		return false;
	}
	
	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {
		
		return orderPresSplit.getId_or();
	}

	@Override
	protected void setPresAllowedSplit(CiOrPresSplitList ciOrPres) {
		List<OrderPresSplitDTO> preses = ciOrPres.getOrderList();
		if(preses!=null && preses.size() >0){
			String sd_herbpreparationtp = preses.get(0).getSd_herbpreparationtp();
			if(!StringUtils.isNullOrEmpty(sd_herbpreparationtp)){
				if("0".equals(sd_herbpreparationtp)){
					ciOrPres.setId_prestpword(ICiDictCodeConst.ID_PRESCRIPTION_FLAG_HERBAL);
					ciOrPres.setSd_prestpword(ICiDictCodeConst.SD_PRESCRIPTION_FLAG_HERBAL);
				}else if("1".equals(sd_herbpreparationtp)){
					ciOrPres.setId_prestpword(ICiDictCodeConst.ID_PRESCRIPTION_FLAG_GRANULES);
					ciOrPres.setSd_prestpword(ICiDictCodeConst.SD_PRESCRIPTION_FLAG_GRANULES);
				}
				return;
			}
		}
		super.setPresAllowedSplit(ciOrPres);
	}
	

}
