package iih.mp.nr.wardprint;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.common.UdidocSearchUtils;
import iih.mp.nr.common.dto.UdidocDTO;
import iih.mp.nr.dto.CureListDTO;
import iih.mp.nr.dto.PatInfoDataDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import iih.mp.nr.dto.wardprint.d.CureCondDTO;
import iih.mp.nr.qry.GetCureExeListSql;
import sun.misc.Sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FType;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 兰陵治疗单
 * 
 * @author hjh
 *
 */
public class GetCureInfoBp {

	/**
	 * 主入口
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @param id_routes
	 * @param sd_srvtps
	 * @param fg_unfold
	 * @return
	 * @throws IOException
	 * @throws BizException
	 */
	public List<PatInfoDataDTO> exec(String param) throws BizException, IOException {

		// 1.参数解析
		CureCondDTO paramDTO = paramAnalyze(param);

		// 实例化分组数据
		CureListDTO[] cas = getCaInfo();

		// 2、用法处理
		String id_ents = paramDTO.getId_ents();
		String sd_srvtps = paramDTO.getSd_srvtps();
		String id_routes = paramDTO.getId_routes();
		String[] routes = null;
		if (!StringUtil.isEmptyWithTrim(id_routes))
			routes = id_routes.split(",");

		// 5、查询数据
		List<CureListDTO> list = queryData(id_ents, sd_srvtps, routes);

		// 6、分组
		LinkedHashMap<String, List<CureListDTO>> map = mapParam(list);

		// 7、数据处理
		List<CureListDTO> rtns = handleData(map);

		// 8、先按患者分组处理
		Map<String, List<CureListDTO>> entMap = getEntMapList(rtns);

		// 9、封装返回数据
		List<PatInfoDataDTO> rtnPatList = packageData(entMap, cas);

		return rtnPatList;
	}

	/**
	 * 
	 * @return
	 * @throws BizException
	 */
	private CureListDTO[] getCaInfo() throws BizException {
		List<CureListDTO> listDTOs = new ArrayList<CureListDTO>();
		// 查询档案
		List<UdidocDTO> udidocDOs = UdidocSearchUtils.findByUdidoclistCode( "CI.OR.1001");

		for (UdidocDTO udidocDO : udidocDOs) {
			CureListDTO listDTO = new CureListDTO();
			listDTO.setCode(udidocDO.getCode());
			listDTO.setContent_or("** " + udidocDO.getName() + " **");
			listDTO.setQuan_medu("剂量");
			listDTO.setName("途径");
			listDTO.setName_freq("频次");
			listDTO.setSd_srvtp(udidocDO.getCtrl1());// 服务类型
			listDTO.setId_route(udidocDO.getCtrl2());// 用法
			if (udidocDO.getSeqno() != null)
				listDTO.setSeqno(udidocDO.getSeqno().toString());// 医嘱分类
			listDTOs.add(listDTO);
		}

		return listDTOs.toArray(new CureListDTO[listDTOs.size()]);
	}

	/**
	 * 查询数据
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_long
	 * @param routes
	 * @return
	 */
	private List<CureListDTO> queryData(String id_ents, String sd_srvtps, String[] routes) {
		final String entStrs = id_ents;
		final String sdSrvtps = sd_srvtps;
		final GetCureExeListSql sql = new GetCureExeListSql(routes);
		try {
			return TransactionExecutor.executeNewTransaction(new TransactionalOperation<List<CureListDTO>>() {
				@SuppressWarnings("unchecked")
				@Override
				public List<CureListDTO> doInTransaction(TransactionStatus status) {
					try {
						String nameTable = createTempTable(entStrs, sdSrvtps);// 创建临时表
						sql.setTemTableName(nameTable);
						List<CureListDTO> reList = (List<CureListDTO>) new DAFacade().execQuery(sql.getSqlStr(), null, new BeanListHandler(CureListDTO.class));
						return reList;
					} catch (Exception e) {
						return null;
					}
				}
			});
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 创建临时表
	 * 
	 * @param id_ents
	 * @param idRoutes
	 * @param sdSrvtps
	 * @param sd_srvtps
	 * @return
	 * @throws BizException
	 */
	private String createTempTable(String id_ents, String sdSrvtps) throws BizException {
		TamTableColumnDTO[] columns = new TamTableColumnDTO[3];
		columns[0] = MpUtils.getTemtableColumn("Id_ent", "VARCHAR2(20)", FType.String);
		columns[1] = MpUtils.getTemtableColumn("Sd_srvtp", "VARCHAR2(50)", FType.String);
		columns[2] = MpUtils.getTemtableColumn("Id_route", "VARCHAR2(20)", FType.String);
		List<TamTableDataDTO> listData = new ArrayList<TamTableDataDTO>();
		String[] ents = id_ents.split("\\,");
		String[] sd_srvtps = sdSrvtps.split("\\,");
		// 服务类型去重
		String[] srvtps = remdup(sd_srvtps);
		int length = ents.length > srvtps.length ? ents.length : srvtps.length;// 两个数组中大的那个长度
		for (int i = 0; i < length; i++) {
			TamTableDataDTO param = new TamTableDataDTO();
			param.setColumn1("~");
			param.setColumn2("~");
			param.setColumn3("~");
			if (ents.length >= i + 1)
				param.setColumn1(ents[i]);
			if (srvtps.length >= i + 1)
				param.setColumn2(srvtps[i]);
			listData.add(param);
		}
		String tableName = "mp_rpt_or_temp";
		MpUtils.createTemTable(tableName, columns, listData.toArray(new TamTableDataDTO[listData.size()]));
		return tableName;
	}

	/**
	 * 服务类型去重
	 * 
	 * @param rtnsrvtps
	 * @return
	 */
	private String[] remdup(String[] rtnsrvtps) {
		List<String> rtnList = new ArrayList<String>();
		if (rtnsrvtps != null && rtnsrvtps.length > 0) {
			for (String sdsrvtp : rtnsrvtps) {
				if (rtnList.contains(sdsrvtp)) {
					continue;
				}
				rtnList.add(sdsrvtp);
			}
		}
		return rtnList.toArray(new String[rtnList.size()]);
	}

	/**
	 * 分组
	 * 
	 * @param listParam
	 * @param mapDtPlan
	 * @return
	 */
	private LinkedHashMap<String, List<CureListDTO>> mapParam(List<CureListDTO> listParam) {
		LinkedHashMap<String, List<CureListDTO>> reMap = new LinkedHashMap<String, List<CureListDTO>>();
		// 标记map
		if (listParam != null && listParam.size() > 0) {
			for (CureListDTO param : listParam) {
				InitDrugList(reMap, param);
			}
		}
		return reMap;
	}

	/**
	 * 获取药品列表
	 * 
	 * @param reMap
	 * @param param
	 */
	private void InitDrugList(LinkedHashMap<String, List<CureListDTO>> reMap, CureListDTO param) {
		if (reMap.containsKey(param.getId_or())) {
			reMap.get(param.getId_or()).add(param);
		} else {
			List<CureListDTO> list = new ArrayList<CureListDTO>();
			list.add(param);
			reMap.put(param.getId_or(), list);
		}
	}

	/**
	 * 结果处理
	 * 
	 * @param list
	 * @param cas
	 * @return
	 */
	private Map<String, List<CureListDTO>> getMapList(List<CureListDTO> list, CureListDTO[] cas) {
		Map<String, List<CureListDTO>> map = new LinkedHashMap<String, List<CureListDTO>>();
		if (list != null && list.size() > 0) {
			for (CureListDTO listCaDTO : cas) {
				List<CureListDTO> listDTOs;
				if (map.containsKey(listCaDTO.getCode())) {
					listDTOs = map.get(listCaDTO.getCode());
				} else {
					listDTOs = new ArrayList<CureListDTO>();
				}

				for (CureListDTO listDTO : list) {
					// 判断属于哪个分类
					if (isThisCa(listDTO, listCaDTO)) {
						listDTOs.add(listDTO);
					}
				}
				map.put(listCaDTO.getCode(), listDTOs);
			}
		}
		return map;
	}

	/**
	 * 数据分组处理
	 * 
	 * @param mapList
	 * @return
	 */
	private List<CureListDTO> groupData(Map<String, List<CureListDTO>> mapList, CureListDTO[] cas) {
		List<CureListDTO> rtnList = new ArrayList<CureListDTO>();
		for (CureListDTO caListDTO : cas) {
			if (mapList.containsKey(caListDTO.getCode())) {
				if (mapList.get(caListDTO.getCode()) == null || mapList.get(caListDTO.getCode()).size() < 1) {
					continue;
				}
				CureListDTO listDTO = new CureListDTO();
				listDTO.setContent_or(caListDTO.getContent_or());
				listDTO.setQuan_medu("剂量");
				listDTO.setName("途径");
				listDTO.setName_freq("频次");
				listDTO.setCode(caListDTO.getCode());// 分组编码
				listDTO.setSeqno(caListDTO.getSeqno());// 医嘱分类排序值
				listDTO.setChildList(mapList.get(caListDTO.getCode()));
				rtnList.add(listDTO);
			}
		}
		return rtnList;
	}

	/**
	 * 根据档案医嘱分类排序字段和编码进行排序显示
	 * 
	 * @param list
	 * @return
	 */
	private List<CureListDTO> sortList(List<CureListDTO> list) {
		if (list == null || list.size() < 1)
			return new ArrayList<CureListDTO>();
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				//档案维护数据为空时  校验
				if (StringUtil.isEmptyWithTrim(list.get(i).getSeqno()))
					list.get(i).setSeqno("");
				if (StringUtil.isEmptyWithTrim(list.get(j).getSeqno()))
					list.get(j).setSeqno("");
				int num = list.get(i).getSeqno().compareTo(list.get(j).getSeqno());
				if (num > 0) {
					if (StringUtil.isEmptyWithTrim(list.get(i).getSeqno()) || StringUtil.isEmptyWithTrim(list.get(j).getSeqno()))
						continue;
					CureListDTO dto = list.get(i);
					list.set(i, list.get(j));
					list.set(j, dto);
				} else if (num == 0) {// 序号相等 编码排序
					int numcode = list.get(i).getCode().compareTo(list.get(j).getCode());
					if (numcode > 0) {
						CureListDTO dto = list.get(i);
						list.set(i, list.get(j));
						list.set(j, dto);
					}
				} else if (num < 0) {
					if (StringUtil.isEmptyWithTrim(list.get(i).getSeqno()) || StringUtil.isEmptyWithTrim(list.get(j).getSeqno())) {
						CureListDTO dto = list.get(i);
						list.set(i, list.get(j));
						list.set(j, dto);
					}
				}
			}
		}
		return list;
	}

	/**
	 * 判断是不是此分类
	 * 
	 * @param listDTO
	 * @param cureCaDTO
	 */
	private boolean isThisCa(CureListDTO listDTO, CureListDTO cureCaDTO) {
		String[] sd_srvtps = cureCaDTO.getSd_srvtp().split(",");
		List<String> srvtpList = Arrays.asList(sd_srvtps);
		if (StringUtil.isEmptyWithTrim(cureCaDTO.getId_route())) {
			if (srvtpList.contains(listDTO.getSd_srvtp())) {
				return true;
			} else {
				return false;
			}
		}
		String[] id_routes = cureCaDTO.getId_route().split(",");
		List<String> routeIDList = Arrays.asList(id_routes);
		if (srvtpList.contains(listDTO.getSd_srvtp()) && routeIDList.contains(listDTO.getId_route())) {
			return true;
		}
		return false;
	}

	/**
	 * 结果处理
	 * 
	 * @param list
	 * @return
	 */
	private List<CureListDTO> handleData(LinkedHashMap<String, List<CureListDTO>> map) {
		List<CureListDTO> reList = new ArrayList<CureListDTO>();
		if (map != null && map.size() > 0) {
			for (String id_or : map.keySet()) {
				List<CureListDTO> listRtn = map.get(id_or);
				// 数据的行处理
				setSymbol(listRtn);
				reList.addAll(listRtn);
			}
		}
		return reList;
	}

	/**
	 * 数据组装
	 * 
	 * @param entMap
	 * @param cas
	 * @param arr
	 * @return
	 */
	private List<PatInfoDataDTO> packageData(Map<String, List<CureListDTO>> entMap, CureListDTO[] cas) {
		List<PatInfoDataDTO> rtnPatList = new ArrayList<PatInfoDataDTO>();
		for (String id_ent : entMap.keySet()) {
			List<CureListDTO> entdataList = entMap.get(id_ent);
			PatInfoDataDTO entDataDTO = new PatInfoDataDTO();
			if (entdataList != null && entdataList.size() > 0) {
				entDataDTO.setId_ent(entdataList.get(0).getId_ent());
				entDataDTO.setName_bed(entdataList.get(0).getName_bed());
				entDataDTO.setName_pat(entdataList.get(0).getName_pat());
				entDataDTO.setCode_amr_ip(entdataList.get(0).getCode_amr_ip());
				entDataDTO.setName_sex(entdataList.get(0).getName_sex());
			}
			// 9、患者和单据类型分组
			Map<String, List<CureListDTO>> mapList = getMapList(entdataList, cas);
			List<CureListDTO> rtnList = groupData(mapList, cas);
			// 10、list 集合通过医嘱分类排序 和 医嘱分类编码进行排序
			List<CureListDTO> sortdata = sortList(rtnList);
			entDataDTO.setListDTO(sortdata);
			rtnPatList.add(entDataDTO);
		}
		return rtnPatList;
	}

	/**
	 * 按就诊ID分组
	 * 
	 * @param rtns
	 * @param arr
	 * @return
	 */
	private Map<String, List<CureListDTO>> getEntMapList(List<CureListDTO> rtns) {
		Map<String, List<CureListDTO>> map = new LinkedHashMap<String, List<CureListDTO>>();
		if (rtns != null && rtns.size() > 0) {
			for (CureListDTO cureListDTO : rtns) {
				if (map.containsKey(cureListDTO.getId_ent())) {
					map.get(cureListDTO.getId_ent()).add(cureListDTO);
				} else {
					List<CureListDTO> listDTOs = new ArrayList<CureListDTO>();
					listDTOs.add(cureListDTO);
					map.put(cureListDTO.getId_ent(), listDTOs);
				}
			}
		}
		return map;

	}

	/**
	 * 设置成组药符号 @param listRtn @param fg_unfold @throws
	 */
	private void setSymbol(List<CureListDTO> listRtn) {
		int index = 1;
		int length = listRtn.size();
		for (CureListDTO param : listRtn) {
			// 成组符号
			String symbolStr = " ";
			if (listRtn.size() == 2) {
				if (index == 1)
					symbolStr = "┏";
				if (index == 2)
					symbolStr = "┗";
			} else if (listRtn.size() > 2) {
				if (index == 1)
					symbolStr = "┏";
				else if (index == length)
					symbolStr = "┗";
				else
					symbolStr = "┃";
			}
			param.setName(symbolStr + param.getName());
			param.setContent_or(param.getName());
			// 医疗要求
			if (!StringUtil.isEmptyWithTrim(param.getDes_or()))
				param.setContent_or(param.getContent_or() + "(" + param.getDes_or() + ")");
			// 规格
			if (!StringUtil.isEmptyWithTrim(param.getSpec()))
				param.setContent_or(param.getContent_or() + "/" + param.getSpec());

			index++;
		}

	}

	/**
	 * 参数解析
	 * 
	 * @param param
	 * @throws BizException
	 * @throws IOException
	 */
	private CureCondDTO paramAnalyze(String param) throws BizException, IOException {
		if (param == null || param.length() <= 0)
			throw new BizException("报表参数不能为空!");
		CureCondDTO rtn = new CureCondDTO();
		rtn.deSerializeJson(param);
		return rtn;
	}
}
