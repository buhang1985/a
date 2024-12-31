package iih.bl.inc.s;

import java.util.List;

import xap.sys.jdbc.handler.BeanListHandler;

import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoInDTO;
import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoOutDTO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blinctransfer.d.BlIncTransferDTO;
import iih.bl.inc.dto.blecinctrasinfodto.d.BlecinctrasInfoDTO;
import iih.bl.inc.dto.blinctf.d.BlIncIssDTO;
import iih.bl.inc.dto.pcbillstatisdto.d.PcBillStatisDto;
import iih.bl.inc.i.IBlIncQryService;
import iih.bl.inc.s.bp.GetCurnoCancStatusBP;
import iih.bl.inc.s.bp.GetIncIssTfRecordBP;
import iih.bl.inc.s.bp.ecinc.FindBlecinctrasInfoBP;
import iih.bl.inc.s.bp.ecinc.GetPaperIncCurNOBP;
import iih.bl.inc.s.oldbp.GetReprintIncInfoBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 票据查询服务
 * 
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces = { IBlIncQryService.class }, binding = Binding.JSONRPC)
public class BlIncQryServiceImpl implements IBlIncQryService {
	private String inccaCode = "11";// 默认为住院发票

	@Override
	public PagingRtnData<PcBillStatisDto> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		BeanListHandler handler = new BeanListHandler(PcBillStatisDto.class);
		if ("15".equals(inccaCode)) {
			throw new BizException("预交金使用票据表(Bl_prepay_pat_rcpt)不存在！");
		}
		StringBuffer sqlContext = getSqlBf(whereStr, inccaCode);//

		StringBuffer sql = getSqlBf2(pg, whereStr, sqlContext, orderStr);
		DAFacade cade = new DAFacade();
		List<BlHpPatSpecDO> list = (List<BlHpPatSpecDO>) cade.execQuery(sql.toString(), handler);

		StringBuffer countSb = getSqlCount(sqlContext, whereStr);
		int count = (int) cade.execQuery(countSb.toString(), new ColumnHandler());
		pg.setPageCount(count / pg.getPageSize());
		pg.setRecordsCount(count);

		PagingRtnData<PcBillStatisDto> result = new PagingRtnData<PcBillStatisDto>();
		FArrayList pageData = new FArrayList();
		result.setPagingInfo(pg);
		pageData.addAll(list);
		result.setPageData(pageData);
		return result;
	}

	/**
	 * 获取查询内容sql
	 * 
	 * @param whereStr
	 * @return
	 */
	public StringBuffer getSqlBf(String whereStr, String inccaCode) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("(SELECT ");
		sbf.append(
				" bu.id_pc ,bu.name_pc, bu.id_incca ,bu.name_cca name_inc, bu.code_incpkg,bu.num_b ,bu.num_e ,bu.name_psn , MIN(bu.incno)||'-'||MAX(bu.incno) incno ");
		sbf.append("FROM ( ");
		StringBuffer baseSql = getSqlByInccaCode(inccaCode, whereStr);
		sbf.append(baseSql);
		sbf.append(
				") bu WHERE 1=1  GROUP BY bu.id_pc ,bu.name_pc , bu.id_incca ,bu.name_cca, bu.code_incpkg ,bu.num_b ,bu.num_e ,bu.name_psn");
		sbf.append(")");
		return sbf;
	}

	/**
	 * 根据票据分类获取查询sql
	 * 
	 * @param inccaCode
	 * @param whereStr
	 * @return
	 */
	private StringBuffer getSqlByInccaCode(String inccaCode, String whereStr) {
		StringBuffer sbf = null;
		switch (inccaCode) {
		case "11":// 门诊发票统计
			sbf = getIncOepsql(whereStr);
			break;
		case "12":// 住院发票统计
			sbf = getIncIpsql(whereStr);
			break;
		case "13":// 作废统计
			sbf = getIncCancSql(whereStr);
			break;
		case "14":// 患者专用款
			sbf = getSpclPatSql(whereStr);
			break;
		case "15":// 预交金使用票据
			break;
		default:
			sbf = getIncOepsql(whereStr);
			break;
		}
		return sbf;
	}

	/**
	 * 获取门诊发票sql
	 * 
	 * @param whereStr
	 * @return
	 */
	private StringBuffer getIncOepsql(String whereStr) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("pc.id_pc, ");
		sbf.append("pc.name name_pc ,");// 计算机名称
		sbf.append("a0.id_incca,");
		sbf.append("cca.name name_cca , ");// --分类名称
		sbf.append("a0.code_incpkg , ");// --票据包编号
		sbf.append("a0.incno , ");// --发票号码
		sbf.append("iss.incno_cur, ");// --发票号码
		sbf.append("iss.num_b,  ");// --票据起始号
		sbf.append("iss.num_e , ");// --票据结束号
		sbf.append("a0.id_emp_inc, ");// --发票开立人员
		sbf.append("psn.name name_psn ");// --发票开立人员姓名
		sbf.append("FROM BL_INC_OEP a0 ");
		sbf.append("RIGHT JOIN BD_PC pc ON PC.ID_PC = a0.id_pc ");// -- RIGHT
		sbf.append("LEFT JOIN BD_INCCA cca ON cca.id_incca = a0.id_incca ");
		sbf.append("LEFT JOIN BL_INC_ISS iss ON iss.code_incpkg = a0.code_incpkg ");
		sbf.append("LEFT JOIN BD_PSNDOC psn ON psn.id_psndoc = a0.id_emp_inc ");
		sbf.append("where ");
		whereStr = whereStr.replaceAll("a0.dt_iss ", "a0.dt_inc ");
		sbf.append(whereStr);
		sbf.append(" AND a0.id_incca is not null ");
		return sbf;
	}

	/**
	 * 住院发票统计
	 */
	private StringBuffer getIncIpsql(String whereStr) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("pc.id_pc, ");
		sbf.append("pc.name name_pc ,");// 计算机名称
		sbf.append("a0.id_incca,");
		sbf.append("cca.name name_cca , ");// --分类名称
		sbf.append("a0.code_incpkg , ");// --票据包编号
		sbf.append("a0.incno , ");// --发票号码
		sbf.append("iss.incno_cur, ");// --发票号码
		sbf.append("iss.num_b,  ");// --票据起始号
		sbf.append("iss.num_e , ");// --票据结束号
		sbf.append("a0.id_emp_inc, ");// --发票开立人员
		sbf.append("psn.name name_psn ");// --发票开立人员姓名
		sbf.append("FROM BL_INC_IP a0 ");
		sbf.append("RIGHT JOIN BD_PC pc ON pc.id_pc = a0.id_pc ");// -- RIGHT
		sbf.append("LEFT JOIN BD_INCCA cca ON cca.id_incca = a0.id_incca ");
		sbf.append("LEFT JOIN BL_INC_ISS iss ON iss.code_incpkg = a0.code_incpkg ");
		sbf.append("LEFT JOIN BD_PSNDOC psn ON psn.id_psndoc = a0.id_emp_inc ");
		sbf.append("where ");
		whereStr = whereStr.replaceAll("a0.dt_iss ", "a0.dt_inc ");
		sbf.append(whereStr);
		sbf.append(" AND a0.id_incca is not null ");
		return sbf;
	}

	/**
	 * 作废发票统计
	 * 
	 * @param whereStr
	 * @return
	 */
	private StringBuffer getIncCancSql(String whereStr) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("pc.id_pc, ");
		sbf.append("pc.name name_pc ,");// 计算机名称
		sbf.append("a0.id_incca,");
		sbf.append("cca.name name_cca , ");// --分类名称
		sbf.append("a0.code_incpkg , ");// --票据包编号
		sbf.append("a0.incno , ");// --发票号码
		sbf.append("iss.incno_cur, ");// --发票号码
		sbf.append("iss.num_b,  ");// --票据起始号
		sbf.append("iss.num_e , ");// --票据结束号
		sbf.append("a0.id_emp_canc id_emp_inc, ");// --发票作废人员
		sbf.append("psn.name name_psn ");// --发票开立人员姓名
		sbf.append("FROM BL_INC_CANC a0 ");
		sbf.append("RIGHT JOIN BD_PC pc ON pc.id_pc = a0.id_pc ");// -- RIGHT
		sbf.append("LEFT JOIN BD_INCCA cca ON cca.id_incca = a0.id_incca ");
		sbf.append("LEFT JOIN BL_INC_ISS iss ON iss.code_incpkg = a0.code_incpkg ");
		sbf.append("LEFT JOIN BD_PSNDOC psn ON psn.id_psndoc = a0.id_emp_canc ");
		sbf.append("where ");
		whereStr = whereStr.replaceAll("a0.dt_iss ", "a0.dt_canc ");
		sbf.append(whereStr);
		sbf.append(" AND a0.id_incca is not null ");
		return sbf;
	}

	/**
	 * 患者专用款统计
	 * 
	 * @param whereStr
	 * @return
	 */
	private StringBuffer getSpclPatSql(String whereStr) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("SELECT ");
		sbf.append("pc.id_pc, ");
		sbf.append("pc.name name_pc ,");// 计算机名称
		sbf.append("'pat' id_incca,");
		sbf.append("'患者专用款' name_cca , ");// --分类名称
		sbf.append("a0.code_incpkg , ");// --票据包编号
		sbf.append("a0.incno , ");// --发票号码
		sbf.append("iss.incno_cur, ");// --发票号码
		sbf.append("iss.num_b,  ");// --票据起始号
		sbf.append("iss.num_e , ");// --票据结束号
		sbf.append("a0.id_emp_oper id_emp_inc, ");// --发票作废人员
		sbf.append("psn.name name_psn ");// --发票开立人员姓名
		sbf.append("FROM BL_SPCL_PAT a0 ");
		sbf.append("RIGHT JOIN BD_PC pc ON pc.id_pc = a0.id_pc ");// -- RIGHT
		// sbf.append("LEFT JOIN BD_INCCA cca ON cca.id_incca = a0.id_incca ");
		sbf.append("LEFT JOIN BL_INC_ISS iss ON iss.code_incpkg = a0.code_incpkg ");
		sbf.append("LEFT JOIN BD_PSNDOC psn ON psn.id_psndoc = a0.id_emp_oper ");
		sbf.append("where ");
		whereStr = whereStr.replaceAll("a0.dt_iss ", "a0.dt_canc ");
		sbf.append(whereStr);
		sbf.append(" AND a0.incno is not null ");
		return sbf;
	}

	/**
	 * 获取查询分页sql
	 * 
	 * @param pg
	 * @param whereStr
	 * @param sql
	 * @param orderStr
	 * @return
	 */
	public StringBuffer getSqlBf2(PaginationInfo pg, String whereStr, StringBuffer sql, String orderStr) {
		int pageSize = pg.getPageSize();
		int pageIndex = pg.getPageIndex();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("( select * from ( ");
		sqlb.append("select rownum as rowno,a0.* from ");
		sqlb.append(sql);
		sqlb.append(String.format(" a0 where 1 = 1 and rownum <= %s ) a0", (pageIndex + 1) * pageSize));
		// whereStr == null ? "" : String.format("and %s", whereStr),
		sqlb.append(String.format(" where a0.rowno >= %s )", pageIndex * pageSize + 1));
		return sqlb;
	}

	/**
	 * 获取查询数量sql
	 */
	public StringBuffer getSqlCount(StringBuffer sql, String whereStr) {
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("select count(*) as rowcount from ( select * from  ");
		sqlb.append(sql);
		return sqlb.append(String.format(" a0 where 1 = 1 ) "));
	}

	/**
	 * 根据queryNode查询
	 */
	@Override
	public PagingRtnData<PcBillStatisDto> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = ser.getQueryStringWithoutDesc(qryRootNodeDTO);
		whereStr = getPageWhereStr(whereStr);
		return findByPageInfo(pg, whereStr, orderStr);
	}

	/**
	 * 把findByQCondAndPageInfo中获取的where条件转化一下
	 * 
	 * @param QwhereStr
	 * @param alias
	 * @return
	 */
	public String getPageWhereStr(String QwhereStr) {
		String key = "a0.incca_code";
		if (QwhereStr != null && QwhereStr.contains(key)) {
			inccaCode = getInccaCode(QwhereStr, key);
			QwhereStr = QwhereStr.replace(key, "'" + inccaCode + "'");
		}
		return QwhereStr;
	}

	/**
	 * 获取票据分类的值
	 * 
	 * @param QwhereStr
	 * @return
	 */
	public String getInccaCode(String QwhereStr, String key) {
		if (QwhereStr.contains("AND")) {
			String[] array1 = QwhereStr.split("AND");
			for (String array : array1) {
				if (array.contains(key)) {
					String[] array2 = array.split("=");
					return array2[1].replace(")", "").replace(" ", "").replace("'", "");
				}
			}
		} else {
			if (QwhereStr.contains(key)) {
				String[] array2 = QwhereStr.split("=");
				return array2[1].replace(")", "").replace(" ", "").replace("'", "");
			}
		}
		return null;
	}

	/**
	 * 获取住院患者可重打的发票信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author wq.li
	 */
	@Override
	public BlIncIpDO GetReprintIncInfo(String entId) throws BizException {
		// TODO Auto-generated method stub
		GetReprintIncInfoBp bp = new GetReprintIncInfoBp();
		return bp.exec(entId);
	}

	/**
	 * 获取当前票号是否作废
	 * 
	 * @param invoiceNo
	 *            票号
	 * @param strCodeIncca
	 *            票包编码
	 * @return
	 * @throws BizException
	 * @author LIM 2018-07-28
	 */
	@Override
	public FBoolean getCurnoCancStatus(String invoiceNo, String strCodeIncca) throws BizException {
		GetCurnoCancStatusBP bp = new GetCurnoCancStatusBP();
		return bp.exec(invoiceNo, strCodeIncca);
	}
	/**
	 * 查询票据领用记录(含转移信息)
	 * @param empId 人员id
	 * @param pcId 计算机id
	 * @return 票据记录
	 * @author ly 2019/02/19
	 * @throws BizException 
	 */
	@Override
	public BlIncIssDTO[] getIncIssWithTfRecord(String empId, String pcId,FBoolean leftorright) throws BizException {
		GetIncIssTfRecordBP bp = new GetIncIssTfRecordBP();
		return bp.exec(empId,pcId,leftorright);
	}


	/**
	 * 根据时间，就诊类型，患者来查找对应的信息
	 */
	@Override
	public PagingRtnData<BlecinctrasInfoDTO> findbBlecinctrasInfoDtos(QryRootNodeDTO qry,PaginationInfo pg) throws BizException {
		FindBlecinctrasInfoBP bp = new FindBlecinctrasInfoBP();
		return bp.exec(qry,pg);
		
	}

	 /**
     * 获取电子票当前纸质票当前号
     * @param dto
     * @return
     * @throws BizException
     * @author ly 2020/01/06
     */
    public BlEcIncCurPIncnoOutDTO getPaperIncCurNO(BlEcIncCurPIncnoInDTO dto) throws BizException{
    	GetPaperIncCurNOBP bp = new GetPaperIncCurNOBP();
    	return bp.exec(dto);
    }
}
