package iih.bd.mm.autoreplenishconfigure.bp;

import java.util.ArrayList;

import iih.bd.mm.autoreplenishconfigure.bp.qry.FindAutoReplenishConfiguresSql;
import iih.bd.mm.autoreplenishconfigure.d.AutoReplenishConfigureDO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.constenum.DefaultConstEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindAutoReplenishConfiguresBp {

	public AutoReplenishConfigureDO[] exec(String whId, QryRootNodeDTO qryNode, MMCategoryDO mmcaDo) throws BizException {
		this.valid(whId, qryNode, mmcaDo);
		String wherePart = this.getWherePart(whId, qryNode, mmcaDo);
		AutoReplenishConfigureDO[] result = this.getAutoReplenishConfigureDOs(wherePart);
		return result;
	}

	private void valid(String whId, QryRootNodeDTO qryNode, MMCategoryDO mmcaDo) throws BizException {
		if(whId == null) {
			throw new BizException("仓库不能为空！");
		}
		if(qryNode == null && mmcaDo == null) {
			throw new BizException("查询模板和物品分类树不能同时为空！");
		}
	}

	private String getWherePart(String whId, QryRootNodeDTO qryNode, MMCategoryDO mmcaDo) throws BizException {
		StringBuilder wherePart = new StringBuilder();
		String where = String.format(" cfg.id_wh = '%s' ", whId);
		wherePart.append(where);
		if(qryNode != null) {
			IQrySQLGeneratorService iQrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			String qrycond = null;
			FArrayList cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "mm_code");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.code like '%%%s%%' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "mm_name");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.name like '%%%s%%' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "fg_active");
			if(cond != null && cond.size() > 0) {
				FBoolean fg_active = (FBoolean) cond.get(0);
				where = String.format(" and cfg.fg_active = '%s' ", fg_active.toString());
				wherePart.append(where);
			}
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
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "mm_pycode");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and mm.pycode like '%%%s%%' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "id_reptp");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and cfg.id_reptp = '%s' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "id_strategy");
			if(cond != null && cond.size() > 0) {
				qrycond = (String) cond.get(0);
				where = String.format(" and cfg.id_strategy = '%s' ", qrycond);
				wherePart.append(where);
			}
			cond = iQrySQLGeneratorService.getQueryFieldValue(qryNode, "dt_rep");
			if(cond != null && cond.size() > 0) {
				DefaultConstEnum dt_rep = (DefaultConstEnum) cond.get(0);
				FArrayList num = dt_rep.getValueDTO();
				where = String.format(" and cfg.dt_rep = %s ", num.get(0).toString());
				wherePart.append(where);
			}
		}
		else {
			where = String.format(" and mmca.innercode like '%s%%' ", mmcaDo.getInnercode());
			wherePart.append(where);
		}
		return wherePart.toString();
	}
	
	private AutoReplenishConfigureDO[] getAutoReplenishConfigureDOs(String wherePart) throws BizException {
		FindAutoReplenishConfiguresSql sql = new FindAutoReplenishConfiguresSql(wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<AutoReplenishConfigureDO> list = (ArrayList<AutoReplenishConfigureDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(AutoReplenishConfigureDO.class));
		if(list != null && list.size() > 0) {
			return list.toArray(new AutoReplenishConfigureDO[list.size()]);
		}else {
			return new AutoReplenishConfigureDO[0];
		}
		
	}
}
