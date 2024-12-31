package iih.bd.pp.hpdiexpenseself.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.i.IDiagcateMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 设置医保计划自费诊断计算字段值业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SetupDiExpenseSelfCalculateFieldsBp {

	public void exec(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		if (diExpenseSelfDOs == null || diExpenseSelfDOs.length <= 0) {
			return;
		}
		SetupCalculateFields(diExpenseSelfDOs);
	}

	/**
	 * 安装计算字段
	 * 
	 * @param diExpenseSelfDOs
	 * @throws BizException
	 */
	private void SetupCalculateFields(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		SetCdSysTp(diExpenseSelfDOs);
		SetDiStdCa(diExpenseSelfDOs);
	}

	/**
	 * 设置诊断体系名称
	 * 
	 * @param diExpenseSelfDOs
	 * @throws BizException
	 */
	private void SetCdSysTp(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		HashMap<String, UdidocDO> cdSysTpMap = GetCdSysTpMap(diExpenseSelfDOs);
		SetCdSysTp(diExpenseSelfDOs, cdSysTpMap);
	}

	/**
	 * 设置诊断分类名称
	 * 
	 * @param diExpenseSelfDOs
	 * @throws BizException
	 */
	private void SetDiStdCa(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		HashMap<String, DiagCateDO> diStdCaMap = GetDiStdCaMap(diExpenseSelfDOs);
		SetDiStdCa(diExpenseSelfDOs, diStdCaMap);
	}

	/**
	 * 获取诊断体系字典
	 * 
	 * @param diExpenseSelfDOs
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, UdidocDO> GetCdSysTpMap(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		UdidocDO[] result = FindCdSysTpList(diExpenseSelfDOs);
		HashMap<String, UdidocDO> diStdCaMap = BuildCdSysTpMap(result);
		return diStdCaMap;
	}

	/**
	 * 获取诊断分类字典
	 * 
	 * @param diExpenseSelfDOs
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, DiagCateDO> GetDiStdCaMap(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		DiagCateDO[] result = FindDiStdCaList(diExpenseSelfDOs);
		HashMap<String, DiagCateDO> diStdCaMap = BuildDiStdCaMap(result);
		return diStdCaMap;
	}

	/**
	 * 查询诊断体系列表
	 * 
	 * @param diExpenseSelfDOs
	 * @return
	 * @throws BizException
	 */
	private UdidocDO[] FindCdSysTpList(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		String[] cdSysTpIds = GetCdSysTpIds(diExpenseSelfDOs);
		String wherePart = SqlUtils.getInSqlByIds(UdidocDO.ID_UDIDOC, cdSysTpIds);

		IUdidocRService udidocRService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] result = udidocRService.find(wherePart, "", FBoolean.FALSE);
		return result;
	}

	/**
	 * 查询诊断分类列表
	 * 
	 * @param diExpenseSelfDOs
	 * @return
	 * @throws BizException
	 */
	private DiagCateDO[] FindDiStdCaList(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) throws BizException {
		String[] diStdCaIds = GetDiStdCaIds(diExpenseSelfDOs);
		String wherePart = SqlUtils.getInSqlByIds(DiagCateDO.ID_DICA, diStdCaIds);

		IDiagcateMDORService diagcateMDORService = ServiceFinder.find(IDiagcateMDORService.class);
		DiagCateDO[] result = diagcateMDORService.find(wherePart, "", FBoolean.FALSE);
		return result;
	}

	/**
	 * 获取诊断体系主键列表
	 * 
	 * @param diExpenseSelfDOs
	 * @return
	 */
	private String[] GetCdSysTpIds(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) {
		ArrayList<String> cdSysTpIdList = new ArrayList<String>();
		for (BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO : diExpenseSelfDOs) {
			if (!StringUtils.isEmpty(bdHpDiExpenseSelfDO.getId_cdsystp())) {
				cdSysTpIdList.add(bdHpDiExpenseSelfDO.getId_cdsystp());
			}
		}
		return cdSysTpIdList.toArray(new String[0]);
	}

	/**
	 * 获取诊断分类主键列表
	 * 
	 * @param diExpenseSelfDOs
	 * @return
	 */
	private String[] GetDiStdCaIds(BdHpDiExpenseSelfDO[] diExpenseSelfDOs) {
		ArrayList<String> diStdCaIdList = new ArrayList<String>();
		for (BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO : diExpenseSelfDOs) {
			if (!StringUtils.isEmpty(bdHpDiExpenseSelfDO.getId_distdca())) {
				diStdCaIdList.add(bdHpDiExpenseSelfDO.getId_distdca());
			}
		}
		return diStdCaIdList.toArray(new String[0]);
	}

	/**
	 * 构建诊断体系字典
	 * 
	 * @param result
	 * @return
	 */
	private HashMap<String, UdidocDO> BuildCdSysTpMap(UdidocDO[] result) {
		HashMap<String, UdidocDO> map = new HashMap<String, UdidocDO>();
		if (result != null) {
			for (UdidocDO udidocDO : result) {
				map.put(udidocDO.getId_udidoc(), udidocDO);
			}
		}
		return map;
	}

	/**
	 * 构建诊断体分类字典
	 * 
	 * @param result
	 * @return
	 */
	private HashMap<String, DiagCateDO> BuildDiStdCaMap(DiagCateDO[] result) {
		HashMap<String, DiagCateDO> map = new HashMap<String, DiagCateDO>();
		if (result != null) {
			for (DiagCateDO diagCateDO : result) {
				map.put(diagCateDO.getId_dica(), diagCateDO);
			}
		}

		return map;
	}

	/**
	 * 设置诊断体系名称
	 * 
	 * @param diExpenseSelfDOs
	 * @param cdSysTpMap
	 */
	private void SetCdSysTp(BdHpDiExpenseSelfDO[] diExpenseSelfDOs, HashMap<String, UdidocDO> cdSysTpMap) {
		for (BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO : diExpenseSelfDOs) {
			String diDefId = bdHpDiExpenseSelfDO.getId_didef();
			if (cdSysTpMap.containsKey(diDefId)) {
				bdHpDiExpenseSelfDO.setDidef_cdsystp(cdSysTpMap.get(diDefId).getName());
			}
		}
	}

	/**
	 * 设置诊断分类名称
	 * 
	 * @param diExpenseSelfDOs
	 * @param diStdCaMap
	 */
	private void SetDiStdCa(BdHpDiExpenseSelfDO[] diExpenseSelfDOs, HashMap<String, DiagCateDO> diStdCaMap) {
		for (BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO : diExpenseSelfDOs) {
			String diDefId = bdHpDiExpenseSelfDO.getId_didef();
			if (diStdCaMap.containsKey(diDefId)) {
				bdHpDiExpenseSelfDO.setDidef_cdsystp(diStdCaMap.get(diDefId).getName());
			}
		}
	}
}