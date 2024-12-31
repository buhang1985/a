package iih.ci.ord.outexecprint.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.ord.dto.outexecprintdto.d.OutExecPrintDTO;
import iih.ci.ord.outexecprint.s.bp.qry.GetOutExecPrintDTOsQry;

public class GetOutExecPrintDTOsBP {

	public GetOutExecPrintDTOsBP() {

	}

	public OutExecPrintDTO[] exec(String id_ents, String id_srvca,
			String sd_srvtp) throws BizException {
		GetOutExecPrintDTOsQry qry = new GetOutExecPrintDTOsQry(id_ents,
				id_srvca, sd_srvtp);
		OutExecPrintDTO[] dtos = (OutExecPrintDTO[]) AppFwUtil.getDORstWithDao(
				qry, OutExecPrintDTO.class);
		return dtos;
	}
}
