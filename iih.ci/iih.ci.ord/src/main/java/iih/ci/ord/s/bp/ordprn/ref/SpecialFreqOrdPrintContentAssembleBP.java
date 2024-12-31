package iih.ci.ord.s.bp.ordprn.ref;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;

/**
 * 医嘱单内容拼接(频次只在药品行体现， 山东邹城市人民医院项目) 
 * @author zhangwq
 *
 */
public class SpecialFreqOrdPrintContentAssembleBP extends DefaultOrdPrintContentAssembleBP {

	@Override
	protected void assembleDes_or(OrdPrintDataDTO qryDTOs) {
	}

	@Override
	protected void setNotDrugInfo(OrdPrintDataDTO[] qryDTOs) throws Exception {
		// TODO Auto-generated method stub
		super.setNotDrugInfo(qryDTOs);
		
		for (OrdPrintDataDTO qryDTO : qryDTOs) {
			//频次只在药品行体现
			if (!qryDTO.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				qryDTO.setContent_or_prn_sub("");
			}
		}
	}
	
}
