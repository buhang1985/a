package iih.ci.ord.outexecprint.s;

import xap.mw.core.data.BizException;
import iih.ci.ord.dto.outexecprintdto.d.OutExecPrintDTO;
import iih.ci.ord.outexecprint.i.IOutExecPrintService;
import iih.ci.ord.outexecprint.s.bp.GetOutExecPrintDTOsBP;

public class OutExecPrintServiceImpl implements IOutExecPrintService {

	@Override
	public OutExecPrintDTO[] GetOutExecPrintDTOs(String id_ents,
			String id_srvca, String sd_srvtp) throws BizException {
		// TODO Auto-generated method stub
		GetOutExecPrintDTOsBP bp=new GetOutExecPrintDTOsBP();
		return bp.exec(id_ents, id_srvca, sd_srvtp);
	}

}
