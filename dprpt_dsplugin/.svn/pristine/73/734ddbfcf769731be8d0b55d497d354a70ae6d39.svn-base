package iih.cssd.dpus.dfpapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import iih.cssd.dpus.dfpapp.dto.DfpusAppListDTO;
import iih.cssd.dpus.dfpapp.qry.GetDfpusAppListSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 消毒包请领打印
 * @author fengjj
 *
 */
public class GetDfpusAppListBp {

	public List<DfpusAppListDTO> exec(String id_dfp_app) throws BizException {

		// 1.查询数据
		List<DfpusAppListDTO> dataList = queryData(id_dfp_app);

		// 2.组装数据
		return pkgData(dataList);
	}

	/**
	 * 查询数据
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @param id_app_dep
	 * @param id_app_emp
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<DfpusAppListDTO> queryData(String id_dfp_app) throws DAException {
		GetDfpusAppListSql sql = new GetDfpusAppListSql(id_dfp_app);
		List<DfpusAppListDTO> recordList = (List<DfpusAppListDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(DfpusAppListDTO.class));
		return recordList;
	}

	/**
	 * 组装数据
	 * 
	 * @param dataList
	 * @return
	 */
	private List<DfpusAppListDTO> pkgData(List<DfpusAppListDTO> dataList) {
		HashMap<String, DfpusAppListDTO> reMap = new HashMap<String, DfpusAppListDTO>();
		List<DfpusAppListDTO> rtn = new ArrayList<DfpusAppListDTO>();
		if (dataList == null || dataList.size() < 1)
			return rtn;
		List<String> listDfp = new ArrayList<String>();
		for (DfpusAppListDTO DfpusAppListDTO : dataList) {
			if (!reMap.containsKey(DfpusAppListDTO.getId_dfp_app())) {
				List<DfpusAppListDTO> list = new ArrayList<DfpusAppListDTO>();
				list.add(DfpusAppListDTO);
				DfpusAppListDTO.setDfp_app_itms(list);
				reMap.put(DfpusAppListDTO.getId_dfp_app(), DfpusAppListDTO);
			} else {
				reMap.get(DfpusAppListDTO.getId_dfp_app()).getDfp_app_itms().add(DfpusAppListDTO);
			}
		}
		Set<Entry<String, DfpusAppListDTO>> entrySet = reMap.entrySet();
		for (Entry<String, DfpusAppListDTO> entry : entrySet) {
			rtn.add(entry.getValue());
		}
		return rtn;
	}
}
