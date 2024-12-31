package iih.ci.ord.s.bp.ordprn.ref;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 宁夏妇幼保健院嘱单内容拼接
 * @author daixb
 *
 */
public class NingfuyouOrdPrintContentAssembleBP extends DefaultOrdPrintContentAssembleBP {

	@Override
	protected void assembleDes_or(OrdPrintDataDTO qryDTOs) {
	}

	@Override
	protected void setNotDrugInfo(OrdPrintDataDTO[] qryDTOs) throws Exception {
		// TODO Auto-generated method stub
		super.setNotDrugInfo(qryDTOs);
		
		for (OrdPrintDataDTO qryDTO : qryDTOs) {
			if (qryDTO.getFg_ctm().equals(FBoolean.TRUE)) {
				if(qryDTO.getQuan_medu()!=null && qryDTO.getMedu_name()!=null){
					qryDTO.setName_srv(qryDTO.getName_srv() + "  " + qryDTO.getQuan_medu() + qryDTO.getMedu_name());
				}
				if(qryDTO.getRoute_name()!=null){
					qryDTO.setName_srv(qryDTO.getName_srv() + "  " + qryDTO.getRoute_name());
				}
			}
		}
	}
}
