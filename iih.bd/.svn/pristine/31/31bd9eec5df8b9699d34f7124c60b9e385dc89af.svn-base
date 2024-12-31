package iih.bd.mm.autoreplenishconfigure.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.core.SqlUtils;
import iih.bd.mm.autoreplenishconfigure.bp.qry.GetExistConfDoSql;
import iih.bd.mm.autoreplenishconfigure.d.AutoReplenishConfigureDO;
import iih.bd.mm.autoreplenishconfigure.i.IAutoreplenishconfigureCudService;
import iih.bd.mm.autoreplenishdto.d.BatchReplenishDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class BatchAddBp {

	public void exec(BatchReplenishDTO[] dtos, String idWh) throws BizException {
		this.valid(dtos, idWh);
		List<BatchReplenishDTO> updateDtos = new ArrayList<BatchReplenishDTO>();
		List<BatchReplenishDTO> insertDtos = new ArrayList<BatchReplenishDTO>();
		//将已经新增过的物品区分出来，更新信息；其余为新增
		//返回的map用于给更新的DO赋ID
		Map<String, AutoReplenishConfigureDO> map = this.splitDtos(dtos, idWh, insertDtos, updateDtos);
		AutoReplenishConfigureDO[] updateDos = this.getUpdateConfDos(updateDtos, idWh, map);
		AutoReplenishConfigureDO[] insertDos = this.getInsertConfDos(insertDtos, idWh);
		IAutoreplenishconfigureCudService service = ServiceFinder.find(IAutoreplenishconfigureCudService.class);
		service.insert(insertDos);
		service.update(updateDos);
	}

	private void valid(BatchReplenishDTO[] dtos, String idWh) throws BizException {
		if(dtos == null || dtos.length <= 0) {
			throw new BizException("所选物品不能为空");
		}
		if(idWh == null) {
			throw new BizException("仓库不能为空");
		}
	}
	
	private Map<String, AutoReplenishConfigureDO> splitDtos(BatchReplenishDTO[] dtos, String idWh, List<BatchReplenishDTO> insertDtos,
			List<BatchReplenishDTO> updateDtos) throws BizException {
		List<String> idMms = new ArrayList<String>();
		for(BatchReplenishDTO dto : dtos) {
			idMms.add(dto.getId_mm());
		}
		String ids = SqlUtils.getInSqlByIds(" cfg.id_mm ", idMms);
		GetExistConfDoSql sql = new GetExistConfDoSql(ids, idWh);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<AutoReplenishConfigureDO> existList = (ArrayList<AutoReplenishConfigureDO>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(AutoReplenishConfigureDO.class));
		if(existList != null && existList.size() > 0) {
			Map<String, AutoReplenishConfigureDO> map = new HashMap<String, AutoReplenishConfigureDO>();
			for(AutoReplenishConfigureDO confDo : existList) {
				map.put(confDo.getId_mm(), confDo);
			}
			for(BatchReplenishDTO dto : dtos) {
				if(map.containsKey(dto.getId_mm())) {
					updateDtos.add(dto);
				}else {
					insertDtos.add(dto);
				}
			}
			return map;
		}else {
			for(BatchReplenishDTO dto : dtos) {
				insertDtos.add(dto);
			}
			return null;
		}
	}
	
	private AutoReplenishConfigureDO[] getInsertConfDos(List<BatchReplenishDTO> insertDtos, String idWh) throws BizException {
		List<AutoReplenishConfigureDO> list = new ArrayList<AutoReplenishConfigureDO>();
		String orgId = Context.get().getOrgId();
		String grpId = Context.get().getGroupId();
		for(BatchReplenishDTO dto : insertDtos) {
			AutoReplenishConfigureDO confDo = new AutoReplenishConfigureDO();
			confDo.setId_wh(idWh);
			confDo.setId_org(orgId);
			confDo.setId_group(grpId);
			confDo.setId_mm(dto.getId_mm());
			confDo.setMm_code(dto.getCode());
			confDo.setMm_name(dto.getName());
			confDo.setMm_spec(dto.getSpec());
			confDo.setMm_pycode(dto.getPycode());
			confDo.setName_unit_pkgsp(dto.getPkgu_name());
			confDo.setSup_name(dto.getSup_name());
			confDo.setId_reptp(dto.getId_reptp());
			confDo.setReptp_code(dto.getReptp_name());
			confDo.setReptp_name(dto.getReptp_name());
			confDo.setId_strategy(dto.getId_strategy());
			confDo.setStrategy_name(dto.getStrategy_name());
			confDo.setDt_rep(dto.getDt_rep());
			confDo.setStatus(DOStatus.NEW);
			list.add(confDo);
		}
		return list.toArray(new AutoReplenishConfigureDO[list.size()]);
	}
	
	private AutoReplenishConfigureDO[] getUpdateConfDos(List<BatchReplenishDTO> updateDtos, String idWh,
			Map<String, AutoReplenishConfigureDO> map) {
		List<AutoReplenishConfigureDO> list = new ArrayList<AutoReplenishConfigureDO>();
		String orgId = Context.get().getOrgId();
		String grpId = Context.get().getGroupId();
		for(BatchReplenishDTO dto : updateDtos) {
			AutoReplenishConfigureDO confDo = new AutoReplenishConfigureDO();
			confDo.setId_addstrec(map.get(dto.getId_mm()).getId_addstrec());
			confDo.setFg_active(map.get(dto.getId_mm()).getFg_active());
			confDo.setCreatedby(map.get(dto.getId_mm()).getCreatedby());
			confDo.setCreatedtime(map.get(dto.getId_mm()).getCreatedtime());
			confDo.setModifiedby(map.get(dto.getId_mm()).getModifiedby());
			confDo.setModifiedtime(map.get(dto.getId_mm()).getModifiedtime());
			confDo.setDs(map.get(dto.getId_mm()).getDs());
			confDo.setSv(map.get(dto.getId_mm()).getSv());
			confDo.setId_wh(idWh);
			confDo.setId_org(orgId);
			confDo.setId_group(grpId);
			confDo.setId_mm(dto.getId_mm());
			confDo.setMm_code(dto.getCode());
			confDo.setMm_name(dto.getName());
			confDo.setMm_spec(dto.getSpec());
			confDo.setMm_pycode(dto.getPycode());
			confDo.setName_unit_pkgsp(dto.getPkgu_name());
			confDo.setSup_name(dto.getSup_name());
			confDo.setId_reptp(dto.getId_reptp());
			confDo.setReptp_code(dto.getReptp_name());
			confDo.setReptp_name(dto.getReptp_name());
			confDo.setId_strategy(dto.getId_strategy());
			confDo.setStrategy_name(dto.getStrategy_name());
			confDo.setDt_rep(dto.getDt_rep());
			confDo.setStatus(DOStatus.UPDATED);
			list.add(confDo);
		}
		return list.toArray(new AutoReplenishConfigureDO[list.size()]);
	}
}
