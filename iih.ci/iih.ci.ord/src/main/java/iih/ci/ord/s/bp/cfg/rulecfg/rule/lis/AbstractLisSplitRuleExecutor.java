package iih.ci.ord.s.bp.cfg.rulecfg.rule.lis;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;
import iih.ci.ord.s.bp.cfg.rulecfg.rule.DefaultRuleExecutor;
import xap.mw.core.data.FArrayList2;

public abstract class AbstractLisSplitRuleExecutor extends DefaultRuleExecutor<List<CiLisOrSmsIoDTO>> {

	@Override
	public void setDefaultVal(List<CiLisOrSmsIoDTO> t) {

	}

	@Override
	public List<CiLisOrSmsIoDTO> executeRule(List<CiLisOrSmsIoDTO> ciLisOrSmsIoList) {

		List<CiLisOrSmsIoDTO> newCiLisOrSmsIoList = new Vector<CiLisOrSmsIoDTO>();

		for (CiLisOrSmsIoDTO ciLisOrSmsIo : ciLisOrSmsIoList) {

			// 允许进行分方，或者当前配置需要进行强制分方时调用分方
			List<CiLisOrSmsIoDTO> lisOrSmsList = this.executeRule(ciLisOrSmsIo);
			if (lisOrSmsList == null) {
				continue;
			}

			newCiLisOrSmsIoList.addAll(lisOrSmsList);
		}

		return newCiLisOrSmsIoList;
	}

	@Override
	protected boolean isExecuteNext() {

		return false;
	}

	/**
	 * 执行检验分单
	 * 
	 * @param ciLisOrSmsIo
	 * @return
	 */
	private List<CiLisOrSmsIoDTO> executeRule(CiLisOrSmsIoDTO ciLisOrSmsIo) {

		// 获取当前分单的子项
		FArrayList2 cilisorinfoList = ciLisOrSmsIo.getCilisorinfos();
		if (cilisorinfoList == null || cilisorinfoList.size() == 0) {
			return null;
		}

		// 返回结果（处方集合）
		List<CiLisOrSmsIoDTO> ciLisOrSmsIoList = new Vector<CiLisOrSmsIoDTO>();
		// 新检验分单子项集合
		Map<String, List<CiLisOrInfo4Sms>> ciLisOrMap = new ConcurrentHashMap<String, List<CiLisOrInfo4Sms>>();
		//
		Map<String, CiLisOrSmsIoDTO> ciLisOrSmsIoMap = new ConcurrentHashMap<String, CiLisOrSmsIoDTO>();

		// 是否允许执行分单
		if (isAllowedExecuteRule(ciLisOrSmsIo)) {

			for (Object obj : cilisorinfoList) {

				CiLisOrInfo4Sms ciLisOrInfo4Sms = (CiLisOrInfo4Sms) obj;

				// 获取拆分处方的唯一标识,作为map的key值，使用map结构因为存成组药，或按部门生成处方，一个规则会拆分出多个处方
				String presIdentification = this.getDefaultIdentification(ciLisOrInfo4Sms);
				if (!ciLisOrMap.containsKey(presIdentification)) {
					// 新处方的子项集合
					List<CiLisOrInfo4Sms> ciLisOrSmsIoChildren = new Vector<CiLisOrInfo4Sms>();
					ciLisOrMap.put(presIdentification, ciLisOrSmsIoChildren);

					CiLisOrSmsIoDTO newCiLisOrSmsIo = new CiLisOrSmsIoDTO();
					// 设置新对象的属性值
					this.setProperty(ciLisOrSmsIo, newCiLisOrSmsIo);
					ciLisOrSmsIoMap.put(presIdentification, newCiLisOrSmsIo);
				}

				// 当前处方允许拆分并且符合拆分规则 或者 需要强制拆分时在进行拆分
				if (isConformToTheRules(ciLisOrInfo4Sms)) {
					ciLisOrMap.get(presIdentification).add(ciLisOrInfo4Sms);
					this.setRuleVal(ciLisOrSmsIoMap.get(presIdentification), ciLisOrInfo4Sms);
				}
			}

			// 遍历新生成的处方map集合，构造新的处方对象，并添加到返回的处方集合中，同时删除原处方的子项
			ciLisOrSmsIoList = this.getCiLisOrSmsIoList(ciLisOrSmsIo, ciLisOrSmsIoMap, ciLisOrMap);

			// 设置新处方的默认值
			// this.setDefaultVal(newPresSplitList);
		}

		// 如果原处方中还有剩余的处方数据，作为一个新的处方
		if (ciLisOrSmsIo.getCilisorinfos().size() > 0) {
			ciLisOrSmsIoList.add(ciLisOrSmsIo);
		}

		return ciLisOrSmsIoList;
	}

	/**
	 * 将分单后的结果构造成新的检验单数据<br>
	 * 并将新的子项从原检验单中排除
	 * 
	 * @param ciLisOrSmsIo
	 *            原检验申请单数据
	 * @param ciLisOrSmsIoMap
	 *            新检验申请单集合
	 * @param ciLisOrMap
	 *            新检验申请单子项集合
	 * @return
	 */
	protected List<CiLisOrSmsIoDTO> getCiLisOrSmsIoList(CiLisOrSmsIoDTO ciLisOrSmsIo,
			Map<String, CiLisOrSmsIoDTO> ciLisOrSmsIoMap, Map<String, List<CiLisOrInfo4Sms>> ciLisOrMap) {

		List<CiLisOrSmsIoDTO> ciLisOrSmsIoList = new Vector<CiLisOrSmsIoDTO>();
		for (String key : ciLisOrSmsIoMap.keySet()) {
			CiLisOrSmsIoDTO newCiLisOrSmsIo = ciLisOrSmsIoMap.get(key);
			List<CiLisOrInfo4Sms> ciLisOrInfo4SmsList = ciLisOrMap.get(key);
			ciLisOrSmsIo.getCilisorinfos().removeAll(ciLisOrInfo4SmsList);

			FArrayList2 fList = new FArrayList2();
			for (CiLisOrInfo4Sms ciLisOrInfo4Sms : ciLisOrInfo4SmsList) {
				fList.add(ciLisOrInfo4Sms);
			}
			if(fList != null && fList.size()>0){
				newCiLisOrSmsIo.setCilisorinfos(fList);
				ciLisOrSmsIoList.add(newCiLisOrSmsIo);
			}
		}

		return ciLisOrSmsIoList;
	}

	/**
	 * 获取默认的处方标识
	 * 
	 * @param orderPresSplit
	 *            处方明细项
	 * @return 返回处方唯一标识，如果子类返回值为空，使用当前类名作为处方唯一标识
	 */
	private String getDefaultIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms) {

		String presIdentification = this.getIdentification(ciLisOrInfo4Sms);
		if (StringUtils.isEmpty(presIdentification)) {
			return this.getClass().getName();
		}
		return presIdentification;
	}

	/**
	 * 是否允许执行规则,当配置不允许拆分时，不进行拆分<br>
	 * 未配置isAllowedSplit 或 isAllowedSplit=true 都允许拆分
	 * 
	 * @param ciLisOrSmsIo
	 *            待拆分的检验申请单数据对象
	 * @return
	 */
	protected boolean isAllowedExecuteRule(CiLisOrSmsIoDTO ciLisOrSmsIo) {

		if("N".equals(ciLisOrSmsIo.getFg_apprule() )){
			return false;
		}
		return true;
	}

	/**
	 * 当前的服务标本类型是否与配置结果匹配
	 * 
	 * @param jsonObj 包含标本类型的配置结果
	 * @param sd_samptp 待校验的标本类型编码
	 * @return true 匹配， false 不匹配
	 */
	protected boolean isMatchedCfgSdSamptp(JSONObject jsonObj, String sd_samptp) {

		if (jsonObj == null || StringUtils.isEmpty(sd_samptp) || !jsonObj.containsKey(RuleCfgConstant.SD_SAMPTP)) {
			return true;
		}

		// 获取标本分类
		JSONObject samptpJson =  jsonObj.getJSONObject(RuleCfgConstant.SD_SAMPTP);
		return isMatchedCondition(samptpJson,sd_samptp);
	}
	
	/**
	 * 当前的服务分类与配置结果是否匹配
	 * 
	 * @param jsonObj 包含服务分类的配置结果
	 * @param srvca 待校验的服务分类
	 * @return true 匹配， false 不匹配
	 */
	protected boolean isMatchedCfgSrvca(JSONObject jsonObj, String srvca) {

		if (jsonObj == null || StringUtils.isEmpty(srvca) || !jsonObj.containsKey(RuleCfgConstant.CODE_SRVCA)) {
			return true;
		}

		JSONObject srvCaJsonObj = jsonObj.getJSONObject(RuleCfgConstant.CODE_SRVCA);
		return isMatchedCondition(srvCaJsonObj,srvca);
	}
	
	/**
	 * 判断当前值是否与配置的结果匹配
	 * @param jsonObj 当
	 * @param srvca
	 * @return
	 */
	private boolean isMatchedCondition(JSONObject jsonObj, String targetStr){
		
		
		// 判断是否存在start with
		if (jsonObj.containsKey(RuleCfgConstant.START_WITH)) {
			String startWithSrvca = jsonObj.getString(RuleCfgConstant.START_WITH);
			if (targetStr.startsWith(startWithSrvca)) {
				return true;
			}
		}

		// 判断targetStr是否在当前的in 对应的对象集合中
		if (jsonObj.containsKey(RuleCfgConstant.IN)) {
			String inStr = jsonObj.getString(RuleCfgConstant.IN);
			List<String> inList = Arrays.asList(inStr.split(","));
			if (inList.contains(targetStr)) {
				return true;
			}
		}

		// 判断targetStr是否在当前的not in 对应的对象集合中
		if (jsonObj.containsKey(RuleCfgConstant.NOT_IN)) {
			String notInStr = jsonObj.getString(RuleCfgConstant.NOT_IN);
			List<String> notInList = Arrays.asList(notInStr.split(","));
			if (!notInList.contains(targetStr)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 设置新检验对象的属性值
	 * @param source
	 * @param target
	 */
	private void setProperty(CiLisOrSmsIoDTO source, CiLisOrSmsIoDTO target){
		
		target.setId_or(source.getId_or());
		target.setId_srvca(source.getId_srvca());
		target.setCode_srvca(source.getCode_srvca()); // 服务分类编码
		target.setInnercode_srvca(source.getInnercode_srvca()); // 基本分类内码
		target.setId_dep_mp(source.getId_dep_mp()); // 执行科室
		target.setId_samptp(source.getId_samptp()); // 标本类型
		target.setSd_samptp(source.getSd_samptp()); // 标本类型编码
		target.setId_sampcoltime(source.getId_sampcoltime()); // 标本采集时间
		target.setLen_sampcoltime(source.getLen_sampcoltime()); // 标本采集时长
		target.setId_sampcollecttimetp(source.getId_sampcollecttimetp()); // 标本采集时间类型
		target.setSd_sampcollecttimetp(source.getSd_sampcollecttimetp()); // 标本采集时间类型编码
		target.setId_unit_sampcoltime(source.getId_unit_sampcoltime()); // 标本采集时长单位
		target.setAnnouncements(source.getAnnouncements()); // 注意事项
		target.setFg_hp(source.getFg_hp()); // 患者就诊医保标识
		target.setFg_orhp(source.getFg_orhp()); // 检验申请单是否为自费
		target.setFg_opspecial(source.getFg_opspecial()); // 门诊特需标识
		target.setFg_specill(source.getFg_specill());// 特殊病标识
		target.setDef1(source.getDef1()); // 客户扩展字段1
		target.setDef2(source.getDef2()); // 客户扩展字段2
		target.setDef3(source.getDef3()); // 客户扩展字段3
		target.setDef4(source.getDef4()); // 客户扩展字段4
		target.setDef5(source.getDef5()); // 客户扩展字段5
		target.setFg_apprule(source.getFg_apprule()); // 数据是否参与本次规则计算
	}

	/**
	 * 获取唯一标识，用于区分是否在一个单子中
	 * 
	 * @param orderPresSplit
	 * @return
	 */
	protected abstract String getIdentification(CiLisOrInfo4Sms ciLisOrInfo4Sms);

	/**
	 * 判断是否符合规则
	 * 
	 * @param ciLisOrSmsIo
	 *            检验申请单信息
	 * @return true 符合规则，false 不符合规则
	 */
	protected abstract boolean isConformToTheRules(CiLisOrInfo4Sms ciLisOrInfo4Sms);

	/**
	 * 将ciLisOrSmsIo中属性值赋值给ciLisOrInfo4Sms中对应属性
	 * 
	 * @param ciLisOrSmsIo
	 * @param ciLisOrInfo4Sms
	 */
	protected abstract void setRuleVal(CiLisOrSmsIoDTO ciLisOrSmsIo, CiLisOrInfo4Sms ciLisOrInfo4Sms);

}