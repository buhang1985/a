package iih.bd.pp.hpdiexpenseself.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.i.IHpdiexpenseselfRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案查询医保自费诊断分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataByQCondBp {

	public PagingRtnData<BdHpDiExpenseSelfDO> exec(HPDO hpdo, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		CheckParam(hpdo);
		return FindQryNodeData(hpdo, qryRootNodeDTO, orderStr, pg);
	}

	/**
	 * 检查参数
	 * 
	 * @param hpdo
	 * @throws BizException
	 */
	private void CheckParam(HPDO hpdo) throws BizException {
		if (hpdo == null) {
			throw new BizException("请选择医保计划。");
		}
	}

	/**
	 * 根据查询方案查询自费诊断信息
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpDiExpenseSelfDO> FindQryNodeData(HPDO hpdo, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		String wherePart = BuildWherePart(hpdo, qryRootNodeDTO);
		PagingRtnData<BdHpDiExpenseSelfDO> result = GetPagingData(wherePart, orderStr, pg);
		SetupCalculateFieldsValue(result);
		return result;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param hpdo
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String BuildWherePart(HPDO hpdo, QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = String.format(" AND id_hp = '%s'", hpdo.getId_hp());
		wherePartBuilder.append(wherePart);

		wherePart = BuildWherePartByQCond(qryRootNodeDTO);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 使用查询方案构建条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String BuildWherePartByQCond(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDTO,
				new BdHpDiExpenseSelfDO().getDODesc());
		return wherePart;
	}

	/**
	 * 查询分页数据
	 * 
	 * @param wherePart
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpDiExpenseSelfDO> GetPagingData(String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		IHpdiexpenseselfRService hpdiexpenseselfRService = ServiceFinder.find(IHpdiexpenseselfRService.class);
		PagingRtnData<BdHpDiExpenseSelfDO> result = hpdiexpenseselfRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

	/**
	 * 设置计算字段值
	 * 
	 * @param result
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void SetupCalculateFieldsValue(PagingRtnData<BdHpDiExpenseSelfDO> result) throws BizException {
		FArrayList dataList = result.getPageData();
		if (dataList == null || dataList.size() <= 0) {
			return;
		}
		SetupDiExpenseSelfCalculateFieldsBp bp = new SetupDiExpenseSelfCalculateFieldsBp();
		bp.exec((BdHpDiExpenseSelfDO[]) dataList.toArray(new BdHpDiExpenseSelfDO[0]));
		//
		// FArrayList list = result.getPageData();
		// ArrayList<String> cdsystpid = new ArrayList<>();
		// ArrayList<String> distdcaid = new ArrayList<>();
		// for (int i = 0; i < list.size(); i++) {
		// BdHpDiExpenseSelfDO selfDO = (BdHpDiExpenseSelfDO) list.get(i);
		// if (selfDO != null) {
		// if (selfDO.getId_cdsystp() != null &&
		// !"~".equals(selfDO.getId_cdsystp())) {
		// cdsystpid.add(selfDO.getId_cdsystp());
		// }
		// if (selfDO.getId_distdca() != null &&
		// !"~".equals(selfDO.getId_distdca())) {
		// distdcaid.add(selfDO.getId_cdsystp());
		// }
		// }
		// }
		// String whereInCdsystpid = SqlUtils.getInSqlByIds("ID_UDIDOC",
		// cdsystpid);
		// String whereInDistdcaid = SqlUtils.getInSqlByIds("ID_DICA",
		// distdcaid);
		//
		// IUdidocRService udidocRService =
		// ServiceFinder.find(IUdidocRService.class);
		// UdidocDO[] udidocDOs = udidocRService.find(whereInCdsystpid, "",
		// FBoolean.FALSE);
		//
		// IDiagcateMDORService diagcateMDORService =
		// ServiceFinder.find(IDiagcateMDORService.class);
		// DiagCateDO[] diagCateDOs = diagcateMDORService.find(whereInDistdcaid,
		// "", FBoolean.FALSE);
		//
		// for (int i = 0; i < list.size(); i++) {
		//
		// BdHpDiExpenseSelfDO selfDO = (BdHpDiExpenseSelfDO) list.get(i);
		//
		// if (udidocDOs != null) {
		// for (UdidocDO udidocDO : udidocDOs) {
		// if (udidocDO.getId_udidoc().equals(selfDO.getId_cdsystp())) {
		// selfDO.setDidef_cdsystp(udidocDO.getName());
		// break;
		// }
		// }
		// }
		//
		// if (diagCateDOs != null) {
		// for (DiagCateDO diagCateDO : diagCateDOs) {
		// if (diagCateDO.getId_dica().equals(selfDO.getId_distdca())) {
		// selfDO.setDidef_distdca(diagCateDO.getName());
		// break;
		// }
		// }
		// }
		//
		// }
		// return result;
	}
}
