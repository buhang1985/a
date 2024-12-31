package iih.ci.ord.s.ems.third.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
/**
 * 铜陵，打疫苗操作，患者注册，医嘱保存，分方一个流程
 * @author zhangwanqing
 *
 */
public class EmsSaveAction {
	public ThirdRstDTO[] exec(PatiVisitDO pat, ChargeForCiParamDTO[] params) throws BizException {
		if(pat==null){
			// 查询患者的信息
		    pat = this.getParInfo(params[0].getId_ent());
		}
		Map<String,DefaultCreateParam[]> teamParamMap = defaultCreateParamFrom(params);
		List<ThirdRstDTO> rsts = new ArrayList<ThirdRstDTO>();
		if(teamParamMap.containsKey("drug")){
			DrugSaveBP drugbp = new DrugSaveBP();
			rsts.addAll(drugbp.exec(pat, params, teamParamMap.get("drug")));
		}
		if(teamParamMap.containsKey("treat")){
			TreatSaveBP treatbp = new TreatSaveBP();
			rsts.addAll(treatbp.exec(pat, params, teamParamMap.get("treat")));
		}
		return rsts.toArray(new ThirdRstDTO[0]);
	}
	/**
	 * 生成默认医疗单时所需要的参数
	 * @param params
	 * @return
	 * @throws BizException
	 */
	protected Map<String,DefaultCreateParam[]> defaultCreateParamFrom(ChargeForCiParamDTO[] params) throws BizException {
		Map<String,DefaultCreateParam[]> teamMap = new HashMap<String,DefaultCreateParam[]>();
		List<DefaultCreateParam> defaultDrugsParams = new ArrayList<DefaultCreateParam>();
		List<DefaultCreateParam> defaultTreatParams = new ArrayList<DefaultCreateParam>();
		for (ChargeForCiParamDTO param : params) {
			String[] id_srvs = new String[] { param.getId_srv() };
			DefaultCreateParam defaultParma = null;
			if (!CiOrdUtils.isEmpty(param.getFg_mm()) && param.getFg_mm().equals("Y")) {
				String[] id_mms = new String[] { param.getId_mm() };
				defaultParma = new DefaultCreateParam(id_srvs, id_mms);
			} else {
				defaultParma = new DefaultCreateParam(id_srvs);
			}
			if(!CiOrdUtils.isEmpty(param.getFg_mm())&&param.getFg_mm().equals("Y")){
				defaultDrugsParams.add(defaultParma);
			}else{
				defaultTreatParams.add(defaultParma);
			}
		}
		if(defaultDrugsParams.size()>0){
			teamMap.put("drug", defaultDrugsParams.toArray(new DefaultCreateParam[0]));
		}
		if(defaultTreatParams.size()>0){
			teamMap.put("treat", defaultTreatParams.toArray(new DefaultCreateParam[0]));
		}
		return teamMap;

	}
	/**
	 * 获得患者信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	protected PatiVisitDO getParInfo(String id_ent) throws BizException{
		if(CiOrdUtils.isEmpty(id_ent))
			return null;
		return CiOrdAppUtils.getEnOutQryService().getEnInfo(id_ent);
	}
}
