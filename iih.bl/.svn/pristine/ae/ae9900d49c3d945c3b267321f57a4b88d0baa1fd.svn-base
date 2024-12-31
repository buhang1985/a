package iih.bl.inc.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import iih.bl.inc.dto.blelecbillcheckdto.d.BlecIncCheckDTO;
import iih.bl.params.BlParams;
import iih.ei.bl.ecinc.d.EcIncBillListDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FType;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 电子发票核对相关信息
 * @author Jiangdk
 *
 */
public class CheckElecBillBP {
	
	/**
	 * 发票领退管理模式
	 * 01:发票分发到个人 02:发票分发到计算机
	 */
	public static String blInc0012 = null;	
	public static final String SD_INC_PSON = "01";	//发票分发到个人
	public static final String SD_INC_PC = "02";	//发票分发到计算机

	public static final String SD_CHARGE = "1";	//收费
	public static final String SD_REFUND = "-1";	//退费
	public static final String SD_DIRECT_All = "2";	//全部
	
	public static String pointName = "";	//开票点名称(人员或计算机)
	public static String point = "";	//开票点编码(人员或计算机的具体编码)
	public static String dtIncBegin = "";	//起始日期
	public static String dtIncEnd = "";	//截止日期
	public static String euDirect = "";	//收退费
	/**
	 * 正常数据
	 */
	public final static String SD_NORMAL = "Y";
	/**
	 * 异常数据
	 */
	public final static String SD_ABNORMAL = "N";
	
	/**
	 * 电子发票平台数据存储的_临时表名称
	 */
	public final static String SD_TMPTABLE_TRID = "tmp_trid_bill_grid";
	/**
	 * IIH系统数据存储的_临时表名称
	 */
	public final static String SD_TMPTABLE_IIH = "tmp_iih_bill_grid";
	/**
	 * 获取参数值
	 */
	static {
		blInc0012 = BlParams.BLINC0012();
	}
	
	/**
	 * 获取查询方案中的条件和value
	 * @param dto
	 * @throws BizException
	 */
	public static String processQryRootNode(QryRootNodeDTO dto) throws BizException {
		
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereSql = qrySQLGeneratorService.getQueryStringWithoutDesc(dto);
		String[] split = whereSql.split("AND");
		
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			
			if (SD_INC_PSON.equals(blInc0012)) {
				if (s.contains("ps.code")) {
					point = s.substring(s.indexOf("'") + 1, s.lastIndexOf("'"));
				}
				if (s.contains("pc.code")) {
					whereSql = whereSql.replace("AND "+s, "");
				}
			}else {
				if (s.contains("pc.code")) {
					point = s.substring(s.indexOf("'") + 1, s.lastIndexOf("'"));
				}
				if (s.contains("ps.code")) {
					String str= "AND "+s;
					whereSql = whereSql.replace(str, "");
				}
			}
			
			if (s.contains("inc.dt_inc")) {
				String[] dt = s.split("and ");
				for (int j = 0; j < dt.length; j++) {
					if (dt[j].contains(">")) {
						//起始日期
						dtIncBegin = dt[j].substring(dt[j].indexOf("'")+1, dt[j].lastIndexOf("'"));
					}else {
						dtIncEnd = dt[j].substring(dt[j].indexOf("'")+1, dt[j].lastIndexOf("'"));
					}
				}
				
			}
			
			if (s.contains("inc.eu_direct")) {
				euDirect = s.substring(s.indexOf("'") + 1, s.lastIndexOf("'"));
				if (SD_DIRECT_All.equals(euDirect)) {
					whereSql = whereSql.replace(s, s.replace("=", "in")
							.replace("'2'", "(1, -1)"));
				}
			}
		}
		return whereSql;
	}

	/**
	 * 根据编码获取名称
	 * @param pointCode
	 * @throws BizException 
	 */
	public static String qryPointName() throws BizException{
		if (StringUtil.isEmpty(point)) {
			//编码为空，即没有选择开票点的查询条件，默认查询所有开票点-全部
			return "全部";
		}
		String pointName = null;
		if (SD_INC_PSON.equals(blInc0012)) {
			//人员
			IPsndocMDORService docRSrv = ServiceFinder.find(IPsndocMDORService.class);
			String whrStr = String.format(" code = '%s' ", point);
			PsnDocDO[] psnDO = docRSrv.find(whrStr, "", FBoolean.TRUE);
			if (ArrayUtil.isEmpty(psnDO)) {
				return null;
			}
			pointName =  psnDO[0].getName();
		}else if (SD_INC_PC.equals(blInc0012)) {
			//计算机
			IWorkstationRService workstationService = ServiceFinder.find(IWorkstationRService.class);
			String wherePart = String.format(" code = '%s' ", blInc0012);
			WorkStationPcDO[] result = workstationService.find(wherePart, null, FBoolean.FALSE);
			pointName = result[0].getName();
		}
		return pointName;
	}
	
	/**
	 * 创建临时表，用来存储第三方数据
	 * @param tableName
	 * @param datas
	 */
	public static void saveTridDataToTmpTable(String tableName ,EcIncBillListDTO[] datas){
		if (ArrayUtil.isEmpty(datas)) {
			return;
		}
		//1.根据DTO获取平台临时表列名称
		EcIncBillListDTO dto = datas[0];
		String[] attrNames = dto.getAttrNames();
		List<String> attrList = new ArrayList<String>();
		for (String attrName : attrNames) {
			if (attrName.equals("relateBillBatchCode") || attrName.equals("relateBillNo")
				|| attrName.equals("busType") ||  attrName.equals("billname") ) {
				continue;
			}
			attrList.add(attrName);
		}
		attrNames = attrList.toArray(new String[attrList.size()]);
		//2.封装TamTableColumnDTO
		TamTableColumnDTO[] tableColumns = new TamTableColumnDTO[attrNames.length];
		for (int i = 0; i < attrNames.length; i++) {
			String colum = attrNames[i];
			if (colum.contains("busDate") || colum.contains("ivcDateTime")) {
				tableColumns[i].setColumn(colum);
				tableColumns[i].setColumntp("TIMESTAMP(3)");
				FArrayList Datatp = new FArrayList();
				Datatp.add(FType.FDateTime);
				tableColumns[i].setDatatp(Datatp);
			}else if (colum.contains("totalAmt")) {
				tableColumns[i].setColumn(colum);
				tableColumns[i].setColumntp("NUMBER(14,2)");
				FArrayList Datatp = new FArrayList();
				Datatp.add(FType.FDouble);
				tableColumns[i].setDatatp(Datatp);
			}else {
				tableColumns[i].setColumn(colum);
				tableColumns[i].setColumntp("VARCHAR2(50)");
				FArrayList Datatp = new FArrayList();
				Datatp.add(FType.String);
				tableColumns[i].setDatatp(Datatp);
			}
		}
		//3.创建表
		CreateTemTable createTemTable = new CreateTemTable();
		try {
			createTemTable.exec(tableName, tableColumns, datas);
		} catch (BizException e) {
			e.printStackTrace();
		}
	} 

	/**
	 * 创建临时表，用来存储IIH数据
	 * @param thridDataList
	 */
	public static void saveDataToTempTable(String tableName, BlecIncCheckDTO[] datas, String containStr) {
		
		if (ArrayUtil.isEmpty(datas)) {
			return;
		}
		//1.根据DTO获取平台临时表列名称
		String[] attrNames = getAttrNames(datas, containStr);
		
		//2.封装TamTableColumnDTO
		TamTableColumnDTO[] ColumnDTOs = getTamTableColumns(attrNames);
		
		//3.创建表
		CreateTemTable createTemTable = new CreateTemTable();
		try {
			createTemTable.exec(tableName, ColumnDTOs, datas);
		} catch (BizException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建临时表辅助类数组
	 * @param attrNames
	 * @return
	 */
	private static TamTableColumnDTO[] getTamTableColumns(String[] attrNames) {
		TamTableColumnDTO[] tableColumns = new TamTableColumnDTO[attrNames.length];
		for (int i = 0; i < attrNames.length; i++) {
			String colum = attrNames[i];
			if (colum.contains("trid_dtinc")) {
				tableColumns[i].setColumn(colum);
				tableColumns[i].setColumntp("TIMESTAMP(3)");
				FArrayList Datatp = new FArrayList();
				Datatp.add(FType.FDateTime);
				tableColumns[i].setDatatp(Datatp);
			}else if (colum.contains("trid_amt")) {
				tableColumns[i].setColumn(colum);
				tableColumns[i].setColumntp("NUMBER(14,2)");
				FArrayList Datatp = new FArrayList();
				Datatp.add(FType.FDouble);
				tableColumns[i].setDatatp(Datatp);
			}else {
				tableColumns[i].setColumn(colum);
				tableColumns[i].setColumntp("VARCHAR2(50)");
				FArrayList Datatp = new FArrayList();
				Datatp.add(FType.String);
				tableColumns[i].setDatatp(Datatp);
			}
		}
		return tableColumns;
	}

	/**
	 * 获取临时表-列名称
	 * 根据BlecIncCheckDTO的平台列属性，即包含trid_的属性
	 * @param datas 
	 * @return
	 */
	private static String[] getAttrNames(BlecIncCheckDTO[] datas, String containStr) {
		String captureName = captureName(containStr);
		BlecIncCheckDTO blecIncCheckDTO = datas[0];
		String[] attrNames = blecIncCheckDTO.getAttrNames();
		List<String> attrList = new ArrayList<String>();
		for (String attrName : attrNames) {
			//"trid_" 或 "iih_"  || "Trid_" 或 "Iih_"
			if (attrName.contains(containStr) || attrName.contains(captureName)) {
				attrList.add(attrName);
			}
		}
		return attrList.toArray(new String[attrList.size()]);
	}
	
	/**
     * 将字符串的首字母转大写
     * @param str 需要转换的字符串
     * @return
     */
    private static String captureName(String str) {
        char[] cs=str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    /**
     * 删除临时表
     * @throws DAException 
     */
	public static void deleteTempTable() throws DAException {
		try {
			SqlParam paramTrid = new SqlParam();
			SqlParam paramIih = new SqlParam();
			String deleteTrid = "DROP  TABLE ? ";
			String deleteIih = "DROP  TABLE ? ";
			paramTrid.addParam(SD_TMPTABLE_TRID);
			paramIih.addParam(SD_TMPTABLE_IIH);
			new DAFacade().execUpdate(deleteTrid, paramTrid);
			new DAFacade().execUpdate(deleteIih, paramIih);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 校验临时表是否存在（暂时不用）
	 * 删除表时直接try...catch
	 * @return
	 */
	public static Boolean tempTableIsExit() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
