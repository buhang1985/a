package iih.en.pv.s.rule;

import iih.en.pv.dto.d.SupplyTicketRuleDTO;
import xap.sys.jdbc.facade.DAException;

public class RuleTest {

	public static void main(String[] args) {
		SupplyTicketRuleDTO SupplyTicketRuleDTO = new SupplyTicketRuleDTO();
		try {
			then(SupplyTicketRuleDTO);
		} catch (DAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static boolean then(SupplyTicketRuleDTO SupplyTicketRuleDTO) throws DAException{
		if (SupplyTicketRuleDTO == null
				|| SupplyTicketRuleDTO.getD_sch() == null
				|| SupplyTicketRuleDTO.getD_canc() == null 
				|| SupplyTicketRuleDTO.getT_e() == null) {
			return false;
		}
		if (SupplyTicketRuleDTO.getD_sch().isSameDate(SupplyTicketRuleDTO.getD_canc()) 
				&& SupplyTicketRuleDTO.getT_e().before(SupplyTicketRuleDTO.getDt_canc().getUFTime())) {
			return true;
		}
		return false;
	}
}
