package iih.ci.mr.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.mr.cimrpatsigns.d.PatDTO;
import iih.ci.mr.cimrpatsigns.d.Patparam;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enclin.i.IEntstateRService;
import iih.mp.nr.getnewtem.d.GetNewTemDTO;
import iih.mp.nr.getnewtem.d.HisDataDTO;
import iih.mp.nr.getnewtem.d.HisSignDataDTO;
/**
 * 
 * @author huang_junhao
 * 计算患者一天需要录几次体温数据，还有未录时显示任务标识
 */
public class CalculationRule {

	public static final String SD_ENSTATETP = "10";// 就诊状况类型为手术的编码
	public static final String ID_SRVVT = "0004DD3000000005YU59";// 体温的生命体征属性主键

	public PatDTO[] exec(PatDTO[] patDTOS, Patparam patparam) throws BizException {

		if (patDTOS == null || patDTOS.length <= 0) {
			return null;
		}

		List<PatDTO> patList = Arrays.asList(patDTOS);
		String id_ents = "";
		for (PatDTO patDTO : patList) {
			id_ents += (id_ents.length() == 0 ? "" : ",") + "'" + patDTO.getId_ent() + "'";
		}
		// 第一步 按最新体温确定录入次数
		patList = setFg_task(patList, patparam.getMeasuredate(), patparam.getId_mrtplvt(), id_ents);
		// 第二步 根据三天内的历史数据判断是否有高烧修改相应的录入次数
		patList = treeDaysAgo(patList, id_ents, patparam.getMeasuredate(), patparam.getId_mrtplvt());
		// 第三步 判断是否有手术来判断录入次数
		patList = isOperation(patList, patparam.getMeasuredate(), id_ents);
		// 第四步 计算已录次数和未录次数，判断任务标识是否显示
		patList = calculation(patList, id_ents, patparam.getMeasuredate(), patparam.getId_mrtplvt());

		return patList.toArray(new PatDTO[patList.size()]);
	}

	/***
	 * 按最新体温确定录入次数
	 * 
	 * @param pats
	 * @return
	 * @throws BizException
	 */
	private List<PatDTO> setFg_task(List<PatDTO> patList, FDate measuredate, String id_mrtplvt, String id_ents) throws BizException {

		GetNewTemperature newTemperature = new GetNewTemperature();
		GetNewTemDTO[] previewDTO = newTemperature.getNewTemperature(id_ents, new FDateTime(measuredate.getDateAfter(1), new FTime("00:00:00")));
		List<GetNewTemDTO> previewList = Arrays.asList(previewDTO);

		for (PatDTO patDTO : patList) {
			if (previewList != null && previewList.size() > 0) {
				for (GetNewTemDTO getNewTemDTO : previewList) {
					if (patDTO.getId_ent().equals(getNewTemDTO.getId_ent())) {

						double tem = 0;
						if (!StringUtil.isEmpty(getNewTemDTO.getValue())) {
							tem = Double.parseDouble(getNewTemDTO.getValue());
						}
						if (tem < 37.5) {
							patDTO.setTask_all(1);
						} else if (tem >= 38.5) {
							patDTO.setTask_all(6);
						} else {
							patDTO.setTask_all(3);
						}
						break;
					}
				}
			} else {
				patDTO.setTask_all(1);
			}

			if (patDTO.getTask_all() == null) {
				patDTO.setTask_all(1);
			}
		}
		return patList;
	}

	/**
	 * 根据三天内的历史数据判断是否有高烧修改相应的录入次数
	 * 
	 * @param patList
	 * @param id_ents
	 * @param measuredate
	 * @param id_mrtplvt
	 * @return
	 * @throws BizException
	 */
	private List<PatDTO> treeDaysAgo(List<PatDTO> patList, String id_ents, FDate measuredate, String id_mrtplvt) throws BizException {

		GetHisDataBp bp = new GetHisDataBp();
		FDateTime dt_vt = new FDateTime(measuredate.getDateAfter(1), new FTime("00:00:00"));
		FDateTime threedays = new FDateTime(measuredate.getDateAfter(-2), new FTime("00:00:00"));
		HisDataDTO[] hisdatas = bp.exc(id_ents, id_mrtplvt, threedays, dt_vt);
		List<HisDataDTO> hisDataList = Arrays.asList(hisdatas);
		List<HisDataDTO> calList = new ArrayList<HisDataDTO>();

		for (PatDTO patDTO : patList) {
			if (hisDataList != null && hisDataList.size() > 0) {
				for (HisDataDTO hisDataDTO : hisDataList) {
					double tem = 0;
					if(!StringUtil.isEmpty(hisDataDTO.getValue())){
						tem = Double.parseDouble(hisDataDTO.getValue());
					}
					if (patDTO.getId_ent().equals(hisDataDTO.getId_ent()) && tem>=37.5) {
						calList.add(hisDataDTO);
					}
				}
			}
			if (patDTO.getTask_all() == 1) {
				patDTO.setTask_all(calList.size() > 0 ? 3 : 1);
			}
			calList.clear();
		}
		return patList;
	}

	/**
	 * 判断是否有手术来判断录入次数
	 * 
	 * @param patList
	 * @param measuredate
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	private List<PatDTO> isOperation(List<PatDTO> patList, FDate measuredate, String id_ents) throws BizException {

		IEntstateRService entstateRService = ServiceFinder.find(IEntstateRService.class);
		FDateTime dt_occ = new FDateTime(measuredate.getDateAfter(1), new FTime("00:00:00"));
		FDateTime threedays = new FDateTime(measuredate.getDateAfter(-2), new FTime("00:00:00"));
		String sql = "a0.id_ent in ("+ id_ents+") and a0.dt_occ <'" + dt_occ + "' and a0.dt_occ>'" + threedays + "' and a0.sd_enstatetp='" + SD_ENSTATETP + "'";
		EntStateDO[] stateDos = entstateRService.find(sql, "", FBoolean.FALSE);
		List<EntStateDO> entStateDOList = Arrays.asList(stateDos);
		for (PatDTO patDTO : patList) {

			if (entStateDOList != null && entStateDOList.size() > 0) {
				for (EntStateDO entStateDO : entStateDOList) {
					if (patDTO.getId_ent().equals(entStateDO.getId_ent())) {
						patDTO.setTask_all(3);
					}
				}
			}
		}
		return patList;
	}

	/**
	 * 计算已录次数和未录次数，判断任务标识是否显示
	 * 
	 * @param patList
	 * @param id_ents
	 * @param measuredate
	 * @param id_mrtplvt
	 * @return
	 * @throws BizException
	 */
	private List<PatDTO> calculation(List<PatDTO> patList, String id_ents, FDate measuredate, String id_mrtplvt) throws BizException {

		HisSignDataBp bp = new HisSignDataBp();
		HisSignDataDTO[] hisDatas = bp.exec(id_ents, id_mrtplvt, measuredate.toString(),ID_SRVVT);
		List<HisSignDataDTO> hisDtoList = Arrays.asList(hisDatas);// 查询录入体征的历史数据；
		List<HisSignDataDTO> hisDataList = new ArrayList<HisSignDataDTO>();// 用来统计某个患者当天历史数据条数；

		for (PatDTO patDTO : patList) {

			if (hisDtoList != null && hisDtoList.size() > 0) {
				for (HisSignDataDTO ciMrHisDataDTO : hisDtoList) {

					if (ciMrHisDataDTO.getId_ent().equals(patDTO.getId_ent())) {
						hisDataList.add(ciMrHisDataDTO);
					}
				}
			}
			patDTO.setTask_ed(hisDataList.size());
			int n = patDTO.getTask_all() - patDTO.getTask_ed();
			patDTO.setTask_ing(n > 0 ? n : 0);
			patDTO.setFg_task(new FBoolean(n > 0));
			hisDataList.clear();
		}
		return patList;
	}

}
