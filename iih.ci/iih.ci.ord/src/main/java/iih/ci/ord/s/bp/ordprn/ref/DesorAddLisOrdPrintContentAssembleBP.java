package iih.ci.ord.s.bp.ordprn.ref;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;

/**
 * @code 检验显示备注内容（无锡项目）
 * @author LiYue
 * @date 2020年4月17日,下午4:23:36
 */
public class DesorAddLisOrdPrintContentAssembleBP extends DefaultOrdPrintContentAssembleBP{
	@Override
	protected void setNotDrugInfo(OrdPrintDataDTO[] qryDTOs) throws Exception {
		// TODO Auto-generated method stub
		super.setNotDrugInfo(qryDTOs);
		
		for (OrdPrintDataDTO qryDTO : qryDTOs) {
			if(qryDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
				if(StringUtils.isNotEmpty(qryDTO.getContent_or().split("\\|")[3].split("&")[0])) {
					qryDTO.setName_srv(qryDTO.getName_srv()+" ("+qryDTO.getContent_or().split("\\|")[3].split("&")[0]+")");
				}
			}
		}
	}
}
