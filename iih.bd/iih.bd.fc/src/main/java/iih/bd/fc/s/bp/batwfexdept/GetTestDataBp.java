package iih.bd.fc.s.bp.batwfexdept;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.GetOrExDeptMainBP;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetTestDataBp {

	@SuppressWarnings("unused")
	public void exec() throws BizException {

		String[] id_ors = new String[] { "1001Z7100000000GEC4N", "1001Z7100000000GA6VJ", "1001Z7100000000GEC33"};

		// String[] id_ors = new String[] { "1001Z7100000000GEC33"};

		OrWfExDeptParamDTO[] params = getParams(id_ors);

		long singleA = getNow();

		HashMap<String, String> singleMap = sigleExe(params);

		long singleB = getNow();

		//1
		long singleCost = singleB - singleA;

		HashMap<String, String> singleByMatchMap = singleByBatch(params);

		long batchC = getNow();

		//2
		long singleByMatchCost = batchC - singleB;
		
		HashMap<String, String> batchMap = batchExe(params);

		long batchD = getNow();

		//3
		long batchCost = batchD - batchC;

		String aa = "";

	}

	/**
	 * 单个
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, String> sigleExe(OrWfExDeptParamDTO[] params) throws BizException {

		HashMap<String, String> reMap = new HashMap<String, String>();

		if (params != null && params.length > 0) {

			GetOrExDeptMainBP bp = new GetOrExDeptMainBP();

			for (OrWfExDeptParamDTO param : params) {

				long singleB = getNow();
				OrWfExDeptDTO[] rtn = bp.exec(param);
				long singleE = getNow();

				String strDept = "";
				long cost = singleE - singleB;
				for (OrWfExDeptDTO dep : rtn) {

					strDept += (strDept.length() == 0 ? "" : ",") + dep.getName_dept() + "(" + dep.getEu_wftp() + ")";
				}

				reMap.put(getStr(cost + "ms") + " |"+ param.getReserv1() +"|"+ param.getReserv2(), strDept + "&");
			}
		}

		return reMap;
	}

	/**
	 * 批量
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, String> batchExe(OrWfExDeptParamDTO[] params) throws BizException {

		HashMap<String, String> reMap = new HashMap<String, String>();

		if (params != null && params.length > 0) {

			GetOrExDeptBatchBP bp = new GetOrExDeptBatchBP();

			OrWfExDeptParamDTO[] rtn = bp.exec(params);

			if (rtn != null && rtn.length > 0) {

				for (OrWfExDeptParamDTO param : rtn) {

					String strDept = "";

					if (param.getRes().size() > 0) {

						for (Object obj : param.getRes()) {

							OrWfExDeptDTO dep = (OrWfExDeptDTO) obj;
							strDept += (strDept.length() == 0 ? "" : ",") + dep.getName_dept() + "(" + dep.getEu_wftp() + ")&";
						}
					}

					reMap.put(param.getReserv2(), strDept);
				}
			}
		}
		return reMap;
	}

	/**
	 * 批量处理单个
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, String> singleByBatch(OrWfExDeptParamDTO[] params) throws BizException {

		HashMap<String, String> reMap = new HashMap<String, String>();

		for (OrWfExDeptParamDTO param : params) {

			long singleB = getNow();
			GetOrExDeptBatchBP bp = new GetOrExDeptBatchBP();
			OrWfExDeptParamDTO[] rtn = bp.exec(new OrWfExDeptParamDTO[] { param });
			long singleE = getNow();

			long cost = singleE - singleB;

			if (rtn != null && rtn.length > 0) {

				for (OrWfExDeptParamDTO re : rtn) {

					String strDept = "";

					if (re.getRes().size() > 0) {

						for (Object obj : re.getRes()) {

							OrWfExDeptDTO dep = (OrWfExDeptDTO) obj;
							strDept += (strDept.length() == 0 ? "" : ",") + dep.getName_dept() + "(" + dep.getEu_wftp() + ")";
						}
					}
					reMap.put(getStr(cost + "ms") + " |" + param.getReserv1() +"|" + param.getReserv2(), strDept + "&");
				}
			}
		}

		return reMap;
	}

	private String getStr(String str) {

		String reString = str.trim();

		for (int i = 0; i < 8 - reString.length(); i++) {
			reString += " ";
		}
		return reString;
	}

	private OrWfExDeptParamDTO[] getParams(String[] id_ors) throws DAException {

		String SqlStr = getSqlStr(id_ors);

		List<OrWfExDeptParamDTO> reList = (List<OrWfExDeptParamDTO>) new DAFacade().execQuery(SqlStr, null, new BeanListHandler(OrWfExDeptParamDTO.class));

		return reList.toArray(new OrWfExDeptParamDTO[reList.size()]);
	}

	private String getSqlStr(String[] id_ors) {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select                                                ");
		SqlStr.append(" orsrv.code_entp,                                      ");
		SqlStr.append(" orsrv.sd_srvtp,                                       ");
		SqlStr.append(" srv.id_srvca,                                         ");
		SqlStr.append(" orsrv.id_route as id_usage,                           ");
		SqlStr.append(" ord.fg_long as recurstr,                              ");
		SqlStr.append(" orsrv.id_srv,                                         ");
		SqlStr.append(" enent.id_dep_phy as id_dep_en,                        ");
		SqlStr.append(" enent.id_dep_nur as id_dept_ns,                       ");
		SqlStr.append(" ord.id_dep_or as id_dept_or,                          ");
		SqlStr.append(" ord.id_dep_mp as id_dept_ex,                          ");
		SqlStr.append(" 1 as eu_wftp,                                         ");
		SqlStr.append(" rownum as reserv1,                                    ");
		SqlStr.append(" Concat(orsrv.id_orsrv||'|',orsrv.name) as reserv2,    ");
		SqlStr.append(" dep.name as reserv3                                   ");
		SqlStr.append(" from ci_or_srv orsrv                                  ");
		SqlStr.append(" left join en_ent enent on orsrv.id_en=enent.id_ent    ");
		SqlStr.append(" left join ci_order ord on ord.id_or=orsrv.id_or       ");
		SqlStr.append(" left join bd_srv srv on orsrv.id_srv=srv.id_srv       ");
		SqlStr.append(" left join bd_dep dep on dep.id_dep=orsrv.id_dep_mp    ");
		SqlStr.append(" where 1=1                                             ");

		if (id_ors != null && id_ors.length > 0) {

			String whereStr = "";

			for (String id_or : id_ors) {

				whereStr += (whereStr.length() == 0 ? "" : ",") + "'" + id_or + "'";
			}
			SqlStr.append(" and orsrv.id_or in(" + whereStr + ")");

		} else {

			SqlStr.append(" and 1=2");
		}

		//SqlStr.append(" order by orsrv.sv desc ");
		return SqlStr.toString();
	}

	/**
	 * 获取系统时间戳
	 * 
	 * @return
	 */
	public long getNow() {

		Date date = new Date();
		return date.getTime();
	}

}
