package iih.sc.apt.s.bp.oral;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.sc.apt.dto.d.AptPatDTO;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScSqlUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 保存口腔科预约患者信息BP
 * 
 * @author zhengcm
 * @date 2016-09-30 10:00:43
 *
 */
public class SaveOralAptPatInfoBP {

	/**
	 * 保存口腔科预约患者信息
	 *
	 * @param aptPatDTO 预约患者DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	public AptPatDTO exec(AptPatDTO aptPatDTO) throws BizException {
		if (null == aptPatDTO) {
			return aptPatDTO;
		}
		// 1、保存患者信息
		this.savePatInfo(aptPatDTO);

		// 2、保存患者标签信息
		this.savePatTagInfo(aptPatDTO);

		return aptPatDTO;
	}

	/**
	 * 保存患者信息
	 *
	 * @param aptPatDTO 预约患者DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePatInfo(AptPatDTO aptPatDTO) throws BizException {
		PatDO patDO = new PatDO();

		if (!StringUtil.isEmptyWithTrim(aptPatDTO.getId_pat())) {
			// 患者基本信息查询服务
			IPatiMDORService qryService = ServiceFinder.find(IPatiMDORService.class);
			patDO = qryService.findById(aptPatDTO.getId_pat());
			patDO.setStatus(DOStatus.UPDATED);
			// 患者标签信息查询服务

		} else {
			patDO.setStatus(DOStatus.NEW);
			patDO.setId_grp(ScContextUtils.getGrpId());
			patDO.setId_org(ScContextUtils.getOrgId());
			patDO.setCode(createCode(PatDODesc.CLASS_FULLNAME));
			patDO.setPycode(CnToPy.getPyFirstCode(aptPatDTO.getName_pat()));
			patDO.setWbcode(CnToWB.getWBCode(aptPatDTO.getName_pat()));
			patDO.setMnecode(patDO.getCode());
			String chisCode = patDO.getCode().length() > 2 ? patDO.getCode().substring(0,
					patDO.getCode().length() - 2) : patDO.getCode();
			patDO.setBarcode_chis(chisCode);// chis码
		}
		patDO.setName(aptPatDTO.getName_pat());
		patDO.setId_sex(aptPatDTO.getId_sex());
		patDO.setSd_sex(aptPatDTO.getSd_sex());
		patDO.setName_sex(aptPatDTO.getName_sex());
		patDO.setDt_birth(aptPatDTO.getD_brith());
		patDO.setId_marry(aptPatDTO.getId_mari());
		patDO.setSd_marry(aptPatDTO.getSd_mari());
		patDO.setId_idtp(aptPatDTO.getId_idtp());
		patDO.setSd_idtp(aptPatDTO.getSd_idtp());
		patDO.setId_code(aptPatDTO.getNo_id());
		patDO.setMob(aptPatDTO.getMobile());
		patDO.setId_paticate(aptPatDTO.getId_patca());
		patDO.setId_patcrettp(aptPatDTO.getId_patcredtp());
		patDO.setId_patpritp(aptPatDTO.getId_pripat());

		// 患者基本信息维护服务
		IPatiMDOCudService cmdService = ServiceFinder.find(IPatiMDOCudService.class);
		patDO = cmdService.save(new PatDO[] { patDO })[0];

		aptPatDTO.setId_pat(patDO.getId_pat());
	}

	/**
	 * 保存患者标签信息
	 *
	 * @param aptPatDTO 口腔预约患者信息DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePatTagInfo(AptPatDTO aptPatDTO) throws BizException {
		if (null == aptPatDTO) {
			return;
		}
		OralAptEP oralAptEP = new OralAptEP();
		List<String> tagIdList = new ArrayList<String>();
		PatTagDO[] tagDOs = null;
		if (!StringUtil.isEmptyWithTrim(aptPatDTO.getId_pat())) {
			// 查询患者已有的标签
			String where = String.format("id_pat = '%s'", aptPatDTO.getId_pat());
			tagDOs = oralAptEP.getPatTagByWhere(where);
			if (!ArrayUtil.isEmpty(tagDOs)) {
				for (PatTagDO tagDO : tagDOs) {
					tagIdList.add(tagDO.getId_pattagtp());
				}
			}
		}
		// 当前患者标签
		List<String> curTagIdList = this.getTagId(aptPatDTO);

		List<String> newTagIdList = new ArrayList<String>();// 新增的标签
		List<String> delTagIdList = new ArrayList<String>();// 删除的标签
		// 查找新增的标签
		if (!ListUtil.isEmpty(curTagIdList)) {
			for (String tagId : curTagIdList) {
				if (!tagIdList.contains(tagId)) {
					newTagIdList.add(tagId);
				}
			}
		}
		// 查找删除的标签
		if (!ListUtil.isEmpty(tagIdList)) {
			if (ListUtil.isEmpty(curTagIdList)) {
				for (String tagId : tagIdList) {
					delTagIdList.add(tagId);
				}
			} else {
				for (String tagId : tagIdList) {
					if (!curTagIdList.contains(tagId)) {
						delTagIdList.add(tagId);
					}
				}
			}
		}

		List<PatTagDO> patTagDOList = new ArrayList<PatTagDO>();

		// 记录新增的标签
		if (!ListUtil.isEmpty(newTagIdList)) {
			// 根据标签类型ID查询标签类型数据
			Map<String, String> docMap = this.getPatTagTP(newTagIdList);
			for (String newTagId : newTagIdList) {
				PatTagDO tagDO = new PatTagDO();
				tagDO.setStatus(DOStatus.NEW);
				tagDO.setId_pat(aptPatDTO.getId_pat());
				tagDO.setId_grp(ScContextUtils.getGrpId());
				tagDO.setId_org(ScContextUtils.getOrgId());
				tagDO.setId_pattagtp(newTagId);
				tagDO.setSd_pattagtp(docMap.get(newTagId));
				tagDO.setId_emp_tag(ScContextUtils.getPsnId());
				tagDO.setDt_tag(ScAppUtils.getServerDateTime());
				patTagDOList.add(tagDO);
			}
		}

		// 记录删除的标签
		if (!ListUtil.isEmpty(delTagIdList)) {
			for (PatTagDO tagDO : tagDOs) {
				if (delTagIdList.contains(tagDO.getId_pattagtp())) {
					tagDO.setStatus(DOStatus.DELETED);
					patTagDOList.add(tagDO);
				}
			}
		}

		// 保存患者标签
		if (!ListUtil.isEmpty(patTagDOList)) {
			oralAptEP.savePatTag(patTagDOList.toArray(new PatTagDO[0]));
		}
	}

	/**
	 * 获取患者标签id数组
	 *
	 * @param aptPatDTO 口腔预约患者信息DTO
	 * @return 患者标签类型id数组
	 * @throws BizException
	 * @author zhengcm
	 */
	private List<String> getTagId(AptPatDTO aptPatDTO) throws BizException {
		if (null == aptPatDTO || StringUtil.isEmptyWithTrim(aptPatDTO.getId_pattagtp())) {
			return null;
		}
		String[] tagIds = aptPatDTO.getId_pattagtp().split(",");
		if (ArrayUtil.isEmpty(tagIds)) {
			return null;
		}
		List<String> tagIdList = new ArrayList<String>();
		for (String tagId : tagIds) {
			tagIdList.add(tagId);
		}
		return tagIdList;
	}

	/**
	 * 根据患者标签类型id获取标签类型编码
	 *
	 * @param tagIdList 患者标签类型Id列表
	 * @return 患者标签类型Id和Code的Map
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, String> getPatTagTP(List<String> tagIdList) throws BizException {
		if (ListUtil.isEmpty(tagIdList)) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		String where = ScSqlUtils.getInSqlByIds("id_udidoc", tagIdList);
		// 自定义档案查询服务
		IUdidocRService qryService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] docDOs = qryService.find(where, null, FBoolean.FALSE);
		for (UdidocDO docDO : docDOs) {
			map.put(docDO.getId_udidoc(), docDO.getCode());
		}
		return map;
	}

	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @return
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}
}
