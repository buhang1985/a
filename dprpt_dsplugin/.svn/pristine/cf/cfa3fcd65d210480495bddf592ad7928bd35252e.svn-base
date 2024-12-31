package iih.dg.ord.printmanage.srv.pres;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.dg.ord.printmanage.srv.d.OrdPresDTO;

public class DiInfoPrintService {
	
	public List<OrdPresDTO> exec(String id_en) throws Exception{
		
		if (id_en == null || id_en.length() <= 0) {
			return null;
		}
		
		CiOrderPrintDiagService ciOrderPrintDiagService = new CiOrderPrintDiagService();
		OrdPresDTO ordPresDTO = new OrdPresDTO();
		ordPresDTO.setStr_name_di(ciOrderPrintDiagService.exec(id_en));
		List<OrdPresDTO> list = new ArrayList<OrdPresDTO>();
		list.add(ordPresDTO);
		return list;
	}

}
