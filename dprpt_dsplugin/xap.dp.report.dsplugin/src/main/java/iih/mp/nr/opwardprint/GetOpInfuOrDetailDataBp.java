package iih.mp.nr.opwardprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.dto.opinfulable.d.OpInfuLableDTO;
import iih.mp.nr.opreport.qry.getGrpNoInfosSql;
import iih.mp.nr.opwardprint.qry.GetOpInfuLableSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 门诊输液登记贴
 * 
 * @author fengjj
 */
public class GetOpInfuOrDetailDataBp {

	/**
	 * 主入口
	 * 
	 * @param idor
	 * @param id_ent
	 * @param dt_plan
	 * @return
	 * @throws BizException
	 */
	public List<OpInfuLableDTO> exec(String id_or_prstr) throws BizException {

		// 1、参数校验
		validate(id_or_prstr);

		// 2、拆分开执行计划ID
		String[] id_or_prs = id_or_prstr.split("\\,");

		// 3、查询数据
		List<OpInfuLableDTO> rtns = qryData(id_or_prs);

		// 4.设置组号
		setGrpInfo(rtns);

		// 5、组装返回值
		List<OpInfuLableDTO> reList = packageRtn(rtns);

		return reList;
	}

	/**
	 * 参数校验
	 * 
	 * @throws BizException
	 */
	private void validate(String id_or_prs) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_or_prs))
			throw new BizException("执行计划信息空异常！");
	}

	/**
	 * 查询数据
	 * 
	 * @param idor
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<OpInfuLableDTO> qryData(String[] id_or_prs) throws DAException {
		GetOpInfuLableSql sql = new GetOpInfuLableSql(id_or_prs);
		List<OpInfuLableDTO> recordList = (List<OpInfuLableDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(OpInfuLableDTO.class));
		return recordList;
	}

	/**
	 * 设置组号
	 * 
	 * @param listDatas
	 * @return
	 * @throws DAException
	 */
	private void setGrpInfo(List<OpInfuLableDTO> listDatas) throws DAException {
		if (listDatas == null || listDatas.size() <= 0)
			return;
		List<String> grp_nos = new ArrayList<>();
		for (OpInfuLableDTO opInfuLableDTO : listDatas) {
			String no_grp = opInfuLableDTO.getNo_grp();
			if (!grp_nos.contains(no_grp))
				grp_nos.add(no_grp);
		}
		if (grp_nos != null && grp_nos.size() > 0) {
			String inSqlStr = MpUtils.getInSqlStr(grp_nos.toArray(new String[0]));
			Map<String, String> map = getNoGrpInfo(inSqlStr);
			if (map != null && map.size() > 0) {
				for (OpInfuLableDTO dto : listDatas) {
					if (map.containsKey(dto.getNo_grp())) {
						dto.setName_grp(map.get(dto.getNo_grp()) + "-" + dto.getSortno());
						dto.setNo_grp(map.get(dto.getNo_grp()));
					} else {
						dto.setName_grp("1-1");
						dto.setNo_grp("1");
						dto.setSortno("1");
					}
				}
			} else {
				for (OpInfuLableDTO dto : listDatas) {
					dto.setName_grp("1-1");
					dto.setNo_grp("1");
					dto.setSortno("1");
				}
			}
		}
	}

	/**
	 * 获取no_grp和分组总数的对应关系
	 * 
	 * @param inSqlStr
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, String> getNoGrpInfo(String inSqlStr) throws DAException {
		Map<String, String> reMap = new HashMap<String, String>();
		getGrpNoInfosSql sql = new getGrpNoInfosSql(inSqlStr);
		List<Map<String, String>> list = (List<Map<String, String>>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new MapListHandler());
		if (!CollectionUtils.isEmpty(list)) {
			for (Map<String, String> map : list) {
				reMap.put(map.get("no_grp"), String.valueOf(map.get("num")));
			}
		}
		return reMap;
	}

	/**
	 * 组装返回值
	 * 
	 * @param reList
	 * @return
	 */
	private List<OpInfuLableDTO> packageRtn(List<OpInfuLableDTO> rtns) {
		List<OpInfuLableDTO> reList = new ArrayList<OpInfuLableDTO>();
		if (rtns == null || rtns.size() < 1)
			return null;
		HashMap<String, OpInfuLableDTO> mapLable = new HashMap<String, OpInfuLableDTO>();
		for (OpInfuLableDTO rtn : rtns) {
			// 主表体记录一条
			OpInfuLableDTO addItm = rtn;
			if (mapLable.containsKey(rtn.getId_or_pr()))
				addItm = mapLable.get(rtn.getId_or_pr());
			else
				mapLable.put(rtn.getId_or_pr(), rtn);
			List<OpInfuLableDTO> listDrugs = addItm.getDrugs();
			if (listDrugs == null) {
				listDrugs = new ArrayList<OpInfuLableDTO>();
				addItm.setDrugs(listDrugs);
			}
			listDrugs.add(rtn);
			if (!reList.contains(addItm))
				reList.add(addItm);
		}
		return reList;
	}
}
