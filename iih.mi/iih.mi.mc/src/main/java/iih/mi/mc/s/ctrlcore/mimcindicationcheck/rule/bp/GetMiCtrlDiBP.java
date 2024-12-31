package iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取服务诊断限制
 * @author LIM
 * @since 2019-09-29
 */
public class GetMiCtrlDiBP {
	/**
	 * 获取服务诊断限制
	 * 
	 * @param hpId
	 *            医保计划ID
	 * @param srvMap
	 *            对照服务map
	 * @param mmMap
	 *            对照药品map
	 * @return 服务诊断控制Map
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, List<BdHpSrvCtrDiDO>> exec(String hpId, List<String> srvIdList) throws BizException {
		
		Map<String, List<BdHpSrvCtrDiDO>> ctrMap = new HashMap<String, List<BdHpSrvCtrDiDO>>();
	
		// 查询字段
		String[] fields = new String[] { BdHpSrvCtrDiDO.ID_SRV, BdHpSrvCtrDiDO.ID_HP, BdHpSrvCtrDiDO.ID_DI_DEF };
		StringBuilder whereBuilder = new StringBuilder();
		whereBuilder.append("ID_HP=?");
		whereBuilder.append(" AND ");
		whereBuilder.append(SqlUtils.getInSqlByIds(BdHpSrvCtrDiDO.ID_SRV, srvIdList));

		SqlParam param = new SqlParam();
		param.addParam(hpId);

		List<BdHpSrvCtrDiDO> ctrList = (List<BdHpSrvCtrDiDO>) new DAFacade().findByCond(BdHpSrvCtrDiDO.class, whereBuilder.toString(), fields, param);
		if (ListUtil.isEmpty(ctrList)) {
			return null;
		}
		
		List<String> ids = new ArrayList<String>();
		for (BdHpSrvCtrDiDO ctrDi : ctrList) {
			ids.add(ctrDi.getId_di_def());
		}
		// 诊断map
		Map<String, DiagDefDO> diMap = new HashMap<String, DiagDefDO>();
		diMap = getDiMap(hpId, ids.toArray(new String[0]));

		for (BdHpSrvCtrDiDO ctrDi : ctrList) {
			List<BdHpSrvCtrDiDO> ctrDiList = ctrMap.get(ctrDi.getId_srv());
			if (ctrDiList == null) {
				ctrDiList = new ArrayList<BdHpSrvCtrDiDO>();
				ctrMap.put(ctrDi.getId_srv(), ctrDiList);
			}
			// 添加诊断信息
			ctrDi.setDi_def_code(diMap.get(ctrDi.getId_di_def()).getCode());
			ctrDi.setDi_def_name(diMap.get(ctrDi.getId_di_def()).getName());
			ctrDiList.add(ctrDi);
		}
		return ctrMap;
	}
	
	/**
	 * 获取诊断限制Map
	 * 
	 * @author LIM
	 * @return
	 */
	private Map<String, DiagDefDO> getDiMap(String hpId, String[] ids) throws BizException {
		Map<String, DiagDefDO> diMap = new HashMap<String, DiagDefDO>();
		IDiagdefMDORService diService = ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO[] diagDefDOArr = diService.findByIds(ids, FBoolean.FALSE);
		for (DiagDefDO di : diagDefDOArr) {
			diMap.put(di.getId_didef(), di);
		}
		return diMap;
	}
}
