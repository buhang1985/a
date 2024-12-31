package iih.cssd.dfp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.cssd.dfp.dto.dfplable.d.DfpLableInfoDTO;
import iih.cssd.dfp.qry.GetDfpInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 消毒包生产打印报表
 * @author fengjj
 * @version 2019年7月11日15:12:55 添加注释
 *
 */
public class GetCssdDfpLableInfosBp {

	/**
	 * 主入口
	 * @param id_dfps
	 * @return
	 * @throws BizException
	 */
	public List<DfpLableInfoDTO> exec(String id_dfps) throws BizException {

		// 1、参数校验
		if (StringUtil.isEmptyWithTrim(id_dfps))
			return null;

		// 2、查询数据
		List<DfpLableInfoDTO> datas = queryData(id_dfps);

		// 3、组装数据
		List<DfpLableInfoDTO> rtns = pkgData(datas);

		return rtns;
	}

	/**
	 * 查询数据
	 * 
	 * @param id_dfps
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<DfpLableInfoDTO> queryData(String ids) throws DAException {
		String[] id_dfps = ids.split("\\,");
		if (id_dfps == null || id_dfps.length < 1)
			return null;
		GetDfpInfoSql sql = new GetDfpInfoSql(id_dfps);
		List<DfpLableInfoDTO> recordList = (List<DfpLableInfoDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(DfpLableInfoDTO.class));
		return recordList;

	}

	/**
	 * 组装数据
	 * 
	 * @param dataList
	 */
	private List<DfpLableInfoDTO> pkgData(List<DfpLableInfoDTO> rtns) {
		HashMap<String, DfpLableInfoDTO> reMap = new HashMap<String, DfpLableInfoDTO>();
		List<DfpLableInfoDTO> reList = new ArrayList<DfpLableInfoDTO>();
		if (rtns == null || rtns.size() < 1)
			return reList;
		for (DfpLableInfoDTO rtn : rtns) {
			if (!reMap.containsKey(rtn.getId_dfp())) {
				List<DfpLableInfoDTO> list = new ArrayList<DfpLableInfoDTO>();
				list.add(rtn);
				rtn.setDfpmminfos(list);
				reMap.put(rtn.getId_dfp(), rtn);
				reList.add(rtn);
			} else {
				reMap.get(rtn.getId_dfp()).getDfpmminfos().add(rtn);
			}
		}
		return reList;
	}
}
