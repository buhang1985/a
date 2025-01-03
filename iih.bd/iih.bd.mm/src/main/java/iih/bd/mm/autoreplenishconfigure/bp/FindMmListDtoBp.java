package iih.bd.mm.autoreplenishconfigure.bp;

import java.util.ArrayList;

import iih.bd.mm.autoreplenishconfigure.bp.qry.FindMmListDtoSql;
import iih.bd.mm.autoreplenishdto.d.BatchReplenishDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindMmListDtoBp {

	public BatchReplenishDTO[] exec(String whId, QryRootNodeDTO qryNode) throws BizException {
		this.valid(whId);
		String where = this.getQrySql(whId, qryNode);
		BatchReplenishDTO[] rtn = this.getDtos(where);
		return rtn;
	}

	private void valid(String whId) throws BizException {
		if(whId == null) {
			throw new BizException("仓库不能为空！");
		}
	}
	
	private String getQrySql(String whId, QryRootNodeDTO qryNode) throws BizException {
		StringBuilder wherePart = new StringBuilder();
		String where = String.format(" and mmwh.id_wh = '%s' ", whId);
		wherePart.append(where);
		if(qryNode != null) {
			IQrySQLGeneratorService iQrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			String qrycond = null;
			FArrayList cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "code");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.code like '%%%s%%' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "name");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.name like '%%%s%%' ", qrycond);
				wherePart.append(where);
			}
			/*cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "fg_active");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.name like '%%s%%%' ", qrycond);
				wherePart.append(where);
			}*/
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "id_anti");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and drug.id_anti = '%s' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "id_pois");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and drug.id_pois = '%s' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "id_srv");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.id_srv = '%s' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "id_mmtp");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.id_mmtp = '%s' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "id_mmca");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mmca.innercode like '%s%%' ", qrycond);
				wherePart.append(where);
			}
		}
		return wherePart.toString();
	}

	private BatchReplenishDTO[] getDtos(String where) throws DAException {
		FindMmListDtoSql sql = new FindMmListDtoSql(where);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<BatchReplenishDTO> list = (ArrayList<BatchReplenishDTO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(BatchReplenishDTO.class));
		if(list != null) {
			BatchReplenishDTO[] rtn = list.toArray(new BatchReplenishDTO[list.size()]);
			return rtn;
		}else {
			return null;
		}
	}
}
