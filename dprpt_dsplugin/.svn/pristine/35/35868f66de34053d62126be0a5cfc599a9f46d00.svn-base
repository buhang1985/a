package iih.cssd.dpcq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import iih.cssd.dpcq.dto.d.DfpStzInfoDTO;
import iih.cssd.dpcq.qry.QryDfpStzInfosSql;
import iih.mp.nr.common.MpUtils;
import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 灭菌锅次信息查询
 * 
 * @author fengjj
 * @version:2020年1月13日14:37:46,创建
 *
 */
public class GetDfpStzInfosBp {
	/**
	 * 主入口
	 * 
	 * @param no_bars
	 * @return
	 * @throws BizException
	 */
	public List<DfpStzInfoDTO> exec(String no_bars) throws BizException {

		// 1.参数校验
		validate(no_bars);

		// 2.查询数据
		DfpStzInfoDTO[] qryData = qryData(no_bars);

		// 3.数据处理
		List<DfpStzInfoDTO> rtn = dataHandler(qryData);

		// 4.排序
		sortData(rtn);

		return rtn;
	}

	/**
	 * 参数校验
	 * 
	 * @param no_bars
	 * @throws BizException
	 */
	private void validate(String no_bars) throws BizException {
		if (no_bars == null || no_bars.length() < 1)
			throw new BizException("灭菌锅次码不能为空！请检查！");
	}

	/**
	 * 查询数据
	 * 
	 * @param no_bars
	 */
	private DfpStzInfoDTO[] qryData(String no_bars) {
		String[] no_bar = no_bars.split("\\,");
		if (no_bar == null || no_bar.length < 1)
			return null;
		QryDfpStzInfosSql sql = new QryDfpStzInfosSql(no_bar);
		DfpStzInfoDTO[] arr_records = RptQryUtil.qryRptBeansArr(sql.getQrySql(), sql.getSqlParams(), DfpStzInfoDTO.class);
		return arr_records;
	}

	/**
	 * 数据处理
	 * 
	 * @param qryData
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<DfpStzInfoDTO> dataHandler(DfpStzInfoDTO[] qryData) {
		List<DfpStzInfoDTO> rtn = new ArrayList<DfpStzInfoDTO>();
		if (qryData == null || qryData.length < 1)
			return rtn;
		HashMap<String, List<DfpStzInfoDTO>> map = MpUtils.groupBaseDO(qryData, "No_bar");
		if (map == null || map.size() < 1)
			return rtn;
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			List<DfpStzInfoDTO> list = map.get(key);
			if (list == null || list.size() < 1)
				continue;
			HashMap<String, List<DfpStzInfoDTO>> map2 = MpUtils.groupBaseDO(list.toArray(new DfpStzInfoDTO[0]), "Id_pkg");
			StringBuffer str = new StringBuffer();
			if (map2 != null && map2.size() > 0) {
				Set<String> keySet2 = map2.keySet();
				for (String key2 : keySet2) {
					DfpStzInfoDTO[] array = map2.get(key2).toArray(new DfpStzInfoDTO[0]);
					str.append(array[0].getName_pkg() + "(" + map2.get(key2).size() + ");");
				}
			}
			DfpStzInfoDTO dfpStzInfoDTO = list.get(0);
			FArrayList list2 = new FArrayList();
			list2.addAll(list);
			dfpStzInfoDTO.setDfpinfos(list2);
			dfpStzInfoDTO.setDfpstrs(str == null ? "" : str.toString());
			rtn.add(dfpStzInfoDTO);
		}
		return rtn;
	}

	/**
	 * 排序
	 * 
	 * @param rtn
	 */
	private void sortData(List<DfpStzInfoDTO> rtn) {
		Comparator<DfpStzInfoDTO> c = new Comparator<DfpStzInfoDTO>() {
			@Override
			public int compare(DfpStzInfoDTO dto1, DfpStzInfoDTO dto2) {
				return dto1.getSortno().compareTo(dto2.getSortno());
			}
		};
		Collections.sort(rtn, c);
	}
}
