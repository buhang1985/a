package iih.ci.ord.s.bp.ordprn.ref;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;

/**
 * 武威医嘱单内容拼接
 * @author zhangwq
 *
 */
public class WuweiOrdPrintContentAssembleBP extends DefaultOrdPrintContentAssembleBP {

	@Override
	protected void assembleDes_or(OrdPrintDataDTO qryDTOs) {
	}

	@Override
	protected void setNotDrugInfo(OrdPrintDataDTO[] qryDTOs) throws Exception {
		// TODO Auto-generated method stub
		super.setNotDrugInfo(qryDTOs);
		
		for (OrdPrintDataDTO qryDTO : qryDTOs) {
			if (qryDTO.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_TREAT_XIYANG)) {
				qryDTO.setName_srv(qryDTO.getName_srv() + "  " + qryDTO.getQuan_medu() + qryDTO.getMedu_name());
			}
		}
	}
	
}
