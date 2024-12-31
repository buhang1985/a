package iih.ci.ord.s.bp.ordprn.ref;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;

/**
 * 郑州市第一人民医院港区新院医嘱单内容拼接
 * @author daixb
 *
 */
public class ZhengyiOrdPrintContentAssembleBP extends DefaultOrdPrintContentAssembleBP {

	@Override
	protected void assembleDes_or(OrdPrintDataDTO qryDTOs) {
	}

	@Override
	protected void setNotDrugInfo(OrdPrintDataDTO[] qryDTOs) throws Exception {
		// TODO Auto-generated method stub
		super.setNotDrugInfo(qryDTOs);
		
		for (OrdPrintDataDTO qryDTO : qryDTOs) {
			if(qryDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI) &&
					qryDTO.getQuan_medu()!=null && qryDTO.getMedu_name()!=null){
				qryDTO.setName_srv(qryDTO.getName_srv() + "  " + qryDTO.getQuan_medu() + qryDTO.getMedu_name());
			}
			if (qryDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT) ||
					qryDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI) ||
					qryDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE) ||
					qryDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)) {
				if(qryDTO.getRoute_name()!=null){
					qryDTO.setName_srv(qryDTO.getName_srv() + "  " + qryDTO.getRoute_name());
				}
				if(qryDTO.getDes_or() != null){
					qryDTO.setName_srv(qryDTO.getName_srv() + "  " + qryDTO.getDes_or());
				}
			}
		}
	}
}
