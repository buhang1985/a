package iih.mi.mibd.mioepordcostupload.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.mioepordcostupload.d.MiOepOrdCostUploadDTO;
import iih.mi.mibd.mioepordcostupload.s.bp.qry.OepOrdCostQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class QueryOepOrdCostUploadDatasBp {
	public MiOepOrdCostUploadDTO[] exec(QryRootNodeDTO queryNode) throws BizException{
		String wherePart = GetWherePartByQCond(queryNode);
		OepOrdCostQry qry = new OepOrdCostQry(wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<MiOepOrdCostUploadDTO> list = (ArrayList<MiOepOrdCostUploadDTO>) daFacade.execQuery(qry.getQrySQLStr(), new BeanListHandler(MiOepOrdCostUploadDTO.class));
		return list.toArray(new MiOepOrdCostUploadDTO[list.size()]);
	}
	
	/**
	 * 使用查询方案生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePartByQCond(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		if (qryRootNodeDTO != null) {
			String[] qryfiles=new String[]{"id_pat","dt_st_begin","dt_st_end","id_emp","fg_upload"};
			IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			FArrayList[] lists = qrySQLGeneratorService.getQueryFieldValues(qryRootNodeDTO, qryfiles);
			StringBuilder wherePart = new StringBuilder();
			if (lists[0]!=null) {
				wherePart.append(" and pat.id_pat='").append(lists[0].get(0)).append("'");
			}
			if (lists[1]!=null&&lists[2]!=null) {
				wherePart.append(" and stoep.dt_st between '").append(lists[1].get(0)).append("' and '").append(lists[2].get(0)).append("'");
			}else if (lists[1]!=null&&lists[2]==null) {
				wherePart.append(" and stoep.dt_st >= '").append(lists[1].get(0)).append("'");
			}else if (lists[1]==null&&lists[2]!=null) {
				wherePart.append(" and stoep.dt_st <= '").append(lists[2].get(0)).append("'");
			}
			if (lists[3]!=null && lists[3].size()>0) {
				wherePart.append(" and psn.id_psndoc='").append(lists[3].get(0)).append("'");
			}
			
			if (lists[4]!=null) {
				if ("Y".equals(lists[4].get(0).toString())) {
					wherePart.append(" and act.id_interfaceacttime!=null ");
				}else {
					wherePart.append(" and act.id_interfaceacttime is null ");
				}
			}
			
			return wherePart.toString();
		}
		return null;
	}
}
