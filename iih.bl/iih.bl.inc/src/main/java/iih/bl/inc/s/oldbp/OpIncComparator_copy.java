package iih.bl.inc.s.oldbp;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;

import java.util.Comparator;

/**
 * 门诊发票排序类
 * @author ly 2018/04/16
 *
 */
public class OpIncComparator_copy implements Comparator<BlIncItmVsTypeDTO> {

	@Override
	public int compare(BlIncItmVsTypeDTO o1, BlIncItmVsTypeDTO o2) {
		
		String stId1 = o1.getBlInvoiceHeadTailDTO().getId_stoep() + "";
		String stId2 = o2.getBlInvoiceHeadTailDTO().getId_stoep() + "";
		
		if(!stId1.equals(stId2)){
			return stId2.compareTo(stId1);
		}
		
		String incno1 = o1.getBlInvoiceHeadTailDTO().getIncno() + "";
		String incno2 = o2.getBlInvoiceHeadTailDTO().getIncno() + "";
		
		return incno2.compareTo(incno1);
	}

}
