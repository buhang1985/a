package iih.dg.ipdis.print;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.printmanage.dto.OrdPresDTO;
import iih.ci.ord.printmanage.dto.PresDrugDTO;
import iih.ci.ord.printmanage.srv.pres.CiorderPresPrintService;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院摆药查询节点打印处方
 * @author guoyang
 *
 */
public class PresPrintService {
	
	public List<OrdPresDTO> exec(String iddgipde) throws Exception {
		List<PresDrugDTO> presdrugquansum = getPresDrugQuanSum(iddgipde);
		if (presdrugquansum == null || presdrugquansum.size() <= 0) {
			return null;
		}
		StringBuilder idpres = new StringBuilder();
		Map<String, FDouble> map = new HashMap<String, FDouble>();
		for (int i = 0; i < presdrugquansum.size(); i++) {
			map.put(presdrugquansum.get(i).getId_pres() + presdrugquansum.get(i).getId_orsrv() + presdrugquansum.get(i).getId_mm(), presdrugquansum.get(i).getQuan_cur());
			if (i == 0) {
				idpres.append("'");
				idpres.append(presdrugquansum.get(i).getId_pres());
				idpres.append("'");
			}else{
				idpres.append(",");
				idpres.append("'");
				idpres.append(presdrugquansum.get(i).getId_pres());
				idpres.append("'");
			}
		}
		
		CiorderPresPrintService ciorderPresPrintService = new CiorderPresPrintService();
		List<OrdPresDTO> ordpres = ciorderPresPrintService.exec(idpres.toString());
		for (OrdPresDTO ordPresDTO : ordpres) {
			if (ordPresDTO == null || ordPresDTO.getPresDrugList() == null || ordPresDTO.getPresDrugList().size() <= 0) {
				continue;
			}
			for (PresDrugDTO presDrugDTO : ordPresDTO.getPresDrugList()) {
				presDrugDTO.setQuan_cur(map.get(presDrugDTO.getId_pres() + presDrugDTO.getId_orsrv() + presDrugDTO.getId_mm()));
			}
		}
		return ordpres;
	}

	private List<PresDrugDTO> getPresDrugQuanSum(String iddgipde) throws DAException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ORSRV.ID_PRES, ORSRV.ID_ORSRV, ");
		sb.append(" DT.ID_MM, SUM(QUAN_AP) QUAN_CUR ");
		sb.append(" FROM MP_DG_IP_APDE_DT DT ");
		sb.append(" LEFT JOIN CI_OR_SRV ORSRV ");
		sb.append(" ON DT.ID_ORSRV  = ORSRV.ID_ORSRV ");
		sb.append(" WHERE ID_DGIPDE = ? ");
		sb.append(" AND EN_OPDE = 1 ");
		sb.append(" GROUP BY ORSRV.ID_PRES,ORSRV.ID_ORSRV,DT.ID_MM ");
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(iddgipde);
		
		DAFacade daFacade = new DAFacade();
		List<PresDrugDTO> presdrugquansum = (List<PresDrugDTO>)daFacade.execQuery(sb.toString(), sqlParam, new BeanListHandler(PresDrugDTO.class));
		
		return presdrugquansum;
	}
}
