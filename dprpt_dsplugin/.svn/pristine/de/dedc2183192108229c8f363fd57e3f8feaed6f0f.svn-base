package iih.mp.nr.hdvrcd.bp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import iih.mp.nr.common.MpUtils;
import iih.mp.nr.hdvrcd.dto.HdvDTO;
import iih.mp.nr.hdvrcd.dto.HdvEntDTO;
import iih.mp.nr.hdvrcd.dto.HdvRcdSumDTO;
import iih.mp.nr.hdvrcd.dto.HdvRecoedDTO;
import iih.mp.nr.hdvrcd.qry.GetHdvEntSql;
import iih.mp.nr.hdvrcd.qry.GetHdvRcdSql;
import iih.mp.nr.hdvrcd.qry.GetHdvSumSql;
import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;

/**
 * 查询交班记录
 * 
 * @author zheng.yx
 * @version 2019年10月22日12:01:35
 */
public class GetHdvRcdBp {

	/**
	 * 主入口
	 * 
	 * @param id_dep
	 * @param dt_hdv
	 * @return
	 * @throws BizException
	 */
	public HdvDTO[] exec(String id_dep, String dt_hdv) throws BizException {

		HdvDTO hdvDTO = new HdvDTO();

		// 1、校验
		validation(id_dep, dt_hdv);

		// 2、查询交班记录
		HdvRecoedDTO[] hdvs = queryHdvRcd(id_dep, dt_hdv);
		if (hdvs == null || hdvs.length < 1)
			return new HdvDTO[] { hdvDTO };

		// 3、查询交班汇总信息
		HdvRcdSumDTO[] summs = queryHdvSum(hdvs);

		// 4.查询交接班患者信息
		HdvEntDTO[] ents = queryHdvEnt(hdvs);

		HdvDTO[] rtns = packageRtn(hdvs, summs, ents);

		return rtns;
	}

	/**
	 * 校验
	 * 
	 * @param id_dep
	 * @param dt_hdv
	 * @throws BizException
	 */
	private void validation(String id_dep, String dt_hdv) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_dep))
			throw new BizException("交班科室空异常！");
		if (dt_hdv == null)
			throw new BizException("交班时间空异常！");
	}

	/**
	 * 查询交班记录
	 * 
	 * @param id_dep
	 * @param dt_hdv
	 * @return
	 * @throws BizException
	 */
	private HdvRecoedDTO[] queryHdvRcd(String id_dep, String dt_hdv) throws BizException {
		GetHdvRcdSql sql = new GetHdvRcdSql(id_dep, dt_hdv);
		HdvRecoedDTO[] recordArr = RptQryUtil.qryRptBeansArr(sql, HdvRecoedDTO.class);
		return recordArr;
	}

	/**
	 * 查询交班汇总信息
	 * 
	 * @param res
	 * @throws BizException
	 */
	private HdvRcdSumDTO[] queryHdvSum(HdvRecoedDTO[] res) throws BizException {
		String[] id_hdvs = MpUtils.getAttrVal(res, "Id_hdv");
		GetHdvSumSql sql = new GetHdvSumSql(id_hdvs);
		return RptQryUtil.qryRptBeansArr(sql, HdvRcdSumDTO.class);
	}

	/**
	 * 查询交接班患者信息
	 * 
	 * @param res
	 * @throws BizException
	 */
	private HdvEntDTO[] queryHdvEnt(HdvRecoedDTO[] res) throws BizException {
		String[] id_hdvs = MpUtils.getAttrVal(res, "Id_hdv");
		GetHdvEntSql sql = new GetHdvEntSql(id_hdvs);
		HdvEntDTO[] hdvEntArr = RptQryUtil.qryRptBeansArr(sql, HdvEntDTO.class);
		HashMap<String, List<HdvEntDTO>> Map = MpUtils.groupBaseDO(hdvEntArr, "Id_hdv_ent");
		List<HdvEntDTO> entList = new ArrayList<HdvEntDTO>();
		for (String id_hdv_ent : Map.keySet()) {
			HdvEntDTO[] entDTOs = Map.get(id_hdv_ent).toArray(new HdvEntDTO[0]);
			String lable = "";
			for (int i = 0; i < entDTOs.length; i++) {
				if (entDTOs[i].getLablestr() != null)
					lable += (lable.length() == 0 ? "" : "\r\n") + entDTOs[i].getLablestr();
				if (i == entDTOs.length - 1) {
					entDTOs[i].setLablestr(lable);
					entList.add(entDTOs[i]);
				}
			}
		}
		// 按床号排序
		Collections.sort(entList, new Comparator<HdvEntDTO>() {
			@Override
			public int compare(HdvEntDTO dto1, HdvEntDTO dto2) {
				if (Integer.parseInt(dto1.getName_bed()) > Integer.parseInt(dto2.getName_bed())) {
					return 1;
				}
				if (Integer.parseInt(dto1.getName_bed()) == Integer.parseInt(dto2.getName_bed())) {
					return 0;
				}
				return -1;
			}
		});
		return entList.toArray(new HdvEntDTO[0]);
	}

	/**
	 * 组装返回值
	 * 
	 * @param hdvs
	 * @param summs
	 * @param ents
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private HdvDTO[] packageRtn(HdvRecoedDTO[] hdvs, HdvRcdSumDTO[] summs, HdvEntDTO[] ents) {
		HashMap<String, List<HdvRcdSumDTO>> mapSum = MpUtils.groupBaseDO(summs, "Id_hdv");
		HashMap<String, List<HdvEntDTO>> mapEnt = MpUtils.groupBaseDO(ents, "Id_hdv");
		HdvDTO rtn = new HdvDTO();
		int i = 1;
		for (HdvRecoedDTO hdv : hdvs) {
			if (i > 3)
				break;
			FArrayList arraySum = new FArrayList();
			List<HdvRcdSumDTO> listSum = mapSum.get(hdv.getId_hdv());
			if (listSum != null && listSum.size() > 0) {
				int blank_size = 3 - listSum.size() % 3;
				if (blank_size > 0) {
					for (int j = 0; j < blank_size; j++) {
						HdvRcdSumDTO blank = new HdvRcdSumDTO();
						listSum.add(blank);
					}
				}
				arraySum.addAll(listSum);
			}

			FArrayList arrayEnt = new FArrayList();
			List<HdvEntDTO> listEnt = mapEnt.get(hdv.getId_hdv());
			if (listEnt != null && listEnt.size() > 0) {
				arrayEnt.addAll(listEnt);
			}

			rtn.setAttrVal("Name_hdv_def" + i, hdv.getName_hdv_def());
			rtn.setAttrVal("Name_emp" + i, hdv.getName_emp_sign());
			rtn.setAttrVal("Arraysum" + i, arraySum);
			rtn.setAttrVal("Arraypat" + i, arrayEnt);
			i++;
		}
		rtn.setId_dep_hdv(hdvs[0].getId_dep_hdv());
		rtn.setName_dep_hdv(hdvs[0].getName_dep_hdv());
		rtn.setDt_hdv(hdvs[0].getDt_hdv());
		return new HdvDTO[] { rtn };
	}
}
