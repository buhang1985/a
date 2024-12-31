package iih.nmr.bp;

import java.util.List;

import iih.nmr.common.GetResultbysql;
import iih.nmr.javabean.EnDepDO;
import iih.nmr.javabean.EnDepTransInfoDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 查询就诊患者转科信息
 * 
 * @author jilx
 *
 */
public class GetDeptTransInfoBp {

	/**
	 * c程序主入口
	 * 
	 * @param id_ent
	 * @return
	 * @throws Exception
	 */
	public EnDepDO[] exec(String id_ent) throws Exception {

		// 1.参数校验
		if (StringUtil.isEmptyWithTrim(id_ent)) {
			throw new BizException("Id_ent为空");
		}
		EnDepDO endep = new EnDepDO();
		String str = getDepTransInfo(id_ent);
		if (str == null || str == "" || str == "null") {
			String name_ent = GetNameEnt(id_ent);
			endep.setEnt(name_ent);
		} else {
			endep.setEnt(str);
		}
		EnDepDO[] arr = new EnDepDO[1];
		arr[0] = endep;
		return arr;
	}

	private String GetNameEnt(String id_ent) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("select t.name as ent from bd_dep t	");
		strBuffer.append("left join en_ent a on t.id_dep=a.id_dep_phy	");
		strBuffer.append("where a.id_ent='" + id_ent + "'");
		GetResultbysql sqlutil = new GetResultbysql();
		EnDepDO endepdo = (EnDepDO) sqlutil.getResulttBySql(strBuffer.toString(), EnDepDO.class);
		return endepdo.getEnt();
	}

	private String getDepTransInfo(String id_ent) throws Exception {
		StringBuffer strBuffer = new StringBuffer();

		strBuffer.append(" select                                                             ");
		strBuffer.append(" endep.dt_e,                                                        ");
		strBuffer.append(" depfrom.name as name_dep_from,                                     ");
		strBuffer.append(" depto.name as name_dep_to                                          ");
		strBuffer.append(" from en_ent_dep  endep                                             ");
		strBuffer.append(" left join bd_dep depfrom on depfrom.id_dep=endep.id_dep_from       ");
		strBuffer.append(" left join bd_dep depto on depto.id_dep=endep.id_dep_to             ");
		strBuffer.append(" where id_ent = '" + id_ent + "'                       			  ");
		strBuffer.append(" and sd_entdeprole=2  order by dt_b                  				  ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<EnDepTransInfoDO> listTrans = (List<EnDepTransInfoDO>) sqlutil.getResultListBySql(strBuffer.toString(),
				EnDepTransInfoDO.class);
		StringBuffer trans = new StringBuffer();
		//String str1= listTrans.get(0).getName_dep_from();
		if (listTrans.size() == 0 || listTrans.get(0).getName_dep_from() == null
				|| listTrans.get(0).getName_dep_from() == "")
			return null;
		/*
		 * for (EnDepTransInfoDO enDepTransInfoDO : listTrans) { //
		 * trans.append(enDepTransInfoDO.getNa) trans.append(""); }
		 */
		for (int i = 0; i < listTrans.size(); i++) {
			if (i == 0) {
				trans.append(listTrans.get(i).getName_dep_from());
			}
			trans.append("-->");
			trans.append(listTrans.get(i).getName_dep_to());
		}
		return trans.toString();
	}

}
