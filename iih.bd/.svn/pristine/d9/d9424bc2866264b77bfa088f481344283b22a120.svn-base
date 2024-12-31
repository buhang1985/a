package iih.bd.srv.diagdef.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import iih.bd.srv.diagdef.d.DiagCompDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全对照数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FillCompDataBp {

	public void exec(DiagdefAggDO result) throws BizException {
		if (result == null) {
			return;
		}

		DiagCompDO[] compArray = result.getDiagCompDO();
		FillCompData(compArray);
	}

	/**
	 * 填充对照数据
	 * 
	 * @param compArray
	 * @throws BizException
	 */
	private void FillCompData(DiagCompDO[] compArray) throws BizException {
		if (compArray == null || compArray.length <= 0) {
			return;
		}

		HashMap<String, DiagDefDO> diagdefMap = GetCompDiagDefMap(compArray);
		if (diagdefMap == null) {
			return;
		}

		for (DiagCompDO diagCompDO : compArray) {
			FillCompData(diagCompDO, diagdefMap);
		}
	}

	/**
	 * 获取关联诊断字典
	 * 
	 * @param compArray
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, DiagDefDO> GetCompDiagDefMap(DiagCompDO[] compArray) throws BizException {
		String[] diagdefIds = GetDiagdefIds(compArray);
		if (diagdefIds == null || diagdefIds.length <= 0) {
			return null;
		}
		IDiagdefMDORService diagdefMDORService = ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO[] result = diagdefMDORService.findByIds(diagdefIds, FBoolean.TRUE);
		HashMap<String, DiagDefDO> map = BuildDiagDefMap(result);
		return map;
	}

	/**
	 * 获取诊断对照信息中对照诊断id数组
	 * 
	 * @param compArray
	 * @return
	 */
	private String[] GetDiagdefIds(DiagCompDO[] compArray) {
		ArrayList<String> ids = new ArrayList<String>();
		if (compArray == null || compArray.length <= 0) {
			return ids.toArray(new String[0]);
		}
		for (DiagCompDO diagCompDO : compArray) {
			ids.add(diagCompDO.getId_didef_comp());
		}
		return ids.toArray(new String[0]);
	}

	/**
	 * 构建诊断字典
	 * 
	 * @param result
	 * @return
	 */
	private HashMap<String, DiagDefDO> BuildDiagDefMap(DiagDefDO[] result) {
		HashMap<String, DiagDefDO> map = new HashMap<String, DiagDefDO>();
		if (result == null || result.length <= 0) {
			return map;
		}

		for (DiagDefDO diagDefDO : result) {
			map.put(diagDefDO.getId_didef(), diagDefDO);
		}

		return map;
	}

	/**
	 * 填充对照数据
	 * 
	 * @param diagCompDO
	 */
	private void FillCompData(DiagCompDO diagCompDO, HashMap<String, DiagDefDO> diagdefMap) {
		if (diagCompDO != null) {
			String idDidefComp = diagCompDO.getId_didef_comp();
			if (idDidefComp != null && !idDidefComp.equals("") && diagdefMap.containsKey(idDidefComp)) {
				DiagDefDO diagDefDO = diagdefMap.get(idDidefComp);
				diagCompDO.setId_distd_comp(diagDefDO.getId_cdsys());
				diagCompDO.setDistd_comp_name(diagDefDO.getCdsys_name());
				diagCompDO.setDistd_comp_name(diagDefDO.getSys_name());
				diagCompDO.setCdsystp_name(diagDefDO.getCdsys_name());
			}
		}
	}

}
