package iih.ci.ord.s.ems.listener;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.custom.diseasedes.BaseDiseaseDesListener;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 产品版处理，查询患者的临床病症及体征
 * @author zhangwq
 *
 */
public class ProduceDiseaseDesListener extends BaseDiseaseDesListener {

	@Override
	public void doYourAction(String id_ent,FMap2 fmap2) throws BizException {
		IMrdocrefvalueRService mrdocservice = CiOrdAppUtils.getMrdocrefvalueRService();
		IPativisitRService pativisitRService = CiOrdAppUtils.getPativisitQryService();
		//根据就诊id获得就诊类型
		String code_entp = pativisitRService.findById(id_ent).getCode_entp();
		// 根据参数欧安段临床症状及体征显示内容
		String clinicalInfo = ParamsetQryUtil.getParaString(Context.get().getOrgId(),
				CiOrdUtils.isIpWf(code_entp) ? ICiOrdNSysParamConst.SYS_PARAM_ClinicalInfo_IP : ICiOrdNSysParamConst.SYS_PARAM_ClinicalInfo_OP);
		if (clinicalInfo == null) {// 未配置参数提取主诉和先病史

			// 改为只提取主诉和先病史
			String sql = String.format("id_ent='%s' and code_element in ('%s','%s')", id_ent,
					ICiDictCodeConst.CODE_ELEMENT_MAINSUIT, ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE);
			MrDocRefValueDO[] mrdocs = mrdocservice.find(sql, "", FBoolean.FALSE);
			if (CiOrdUtils.isEmpty(mrdocs))
				return;
			Map<String, MrDocRefValueDO> teamMr = new HashMap<String, MrDocRefValueDO>();
			for (MrDocRefValueDO value : mrdocs) {
				if (CiOrdUtils.isEmpty(value.getCode_element())) {
					continue;
				}
				teamMr.put(value.getCode_element(), value);
			}
			if (mrdocs != null && mrdocs.length > 0) {
				String clinial = "";
				MrDocRefValueDO item = teamMr.get(ICiDictCodeConst.CODE_ELEMENT_MAINSUIT);
				if (item != null) {
					clinial = String.format("以%s之主诉就诊。", item.getContent());
				}
				item = teamMr.get(ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE);
				if (item != null) {
					if (StringUtils.isEmpty(clinial)) {
						if (item.getContent() != "" && item.getContent() != null) {
							clinial = item.getContent();
						}
					} else {
						if (!StringUtils.isEmpty(item.getContent())) {
							clinial += (item.getContent() + "\r\n");
						}
					}

				}
				item = teamMr.get(ICiDictCodeConst.CODE_ELEMENT_TEST);
				if (item != null) {
					if (StringUtils.isEmpty(clinial)) {
						if (item.getContent() != "" && item.getContent() != null) {
							clinial = item.getContent();
						}
					} else {
						if (!StringUtils.isEmpty(item.getContent())) {
							clinial += (item.getContent() + "\r\n");
						}
					}
				}
				fmap2.put(BaseDiseaseDesListener.DiseaseDesListenerSourceId, clinial);
				return;
			}
		} else {// 根据参数获取内容
			clinicalInfo = clinicalInfo.replace(" ", "");
			clinicalInfo = clinicalInfo.replace("：", ":");
			clinicalInfo = clinicalInfo.replace("；", ";");
			String clinical = "";
			String[] split = clinicalInfo.split(";");
			String[] ElemCodes = new String[split.length];
			Map<String, String> contents = new HashMap<String, String>();
			// 根须序号排序
			TreeMap<String, String> num_elecode = new TreeMap<String, String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1);
				}
			});
			for (int i = 0; i < split.length; i++) {
				String elecode = split[i].substring(split[i].lastIndexOf(":") + 1);
				String num_content = split[i].substring(0, split[i].length() - elecode.length());
				String content = num_content.substring(2, num_content.length());
				String num = num_content.substring(0, num_content.indexOf(":"));
				ElemCodes[i] = elecode;
				contents.put(elecode, content);
				num_elecode.put(num, elecode);
			}
			ICiMrOutQryServices iCiMrOutQryServices = ServiceFinder.find(ICiMrOutQryServices.class);
			MrDocRefValueDO[] mrdocs = iCiMrOutQryServices.getCimrPhaseByElemCode(id_ent, ElemCodes);
			Map<String, MrDocRefValueDO> teamMr = new HashMap<String, MrDocRefValueDO>();
			for (MrDocRefValueDO value : mrdocs) {
				if (CiOrdUtils.isEmpty(value.getCode_element())) {
					continue;
				}
				teamMr.put(value.getCode_element(), value);
			}
			for (String keys : num_elecode.keySet()) {
				String key = num_elecode.get(keys);
				if (teamMr.containsKey(key) && teamMr.get(key) != null && teamMr.get(key).getContent() != null) {
					clinical = contents.get(key) + teamMr.get(key).getContent() + "." + clinical;
				}
			}
			fmap2.put(BaseDiseaseDesListener.DiseaseDesListenerSourceId, clinical);
			return;

		}
		return;
	}

}
