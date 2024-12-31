package iih.bd.pp.s.samppricnst.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.pp.samppricnst.d.SampPriChldCnstDO;
import iih.bd.pp.samppricnst.i.ISamppricnstCudService;
import iih.bd.pp.samppricnst.i.ISamppricnstRService;
import iih.bd.pp.samppricnstdto.d.SampPricnstDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
* @ClassName: SaveSamppricnstBP 
* @Description: 儿童采集费用对照存储或者更新
* @author zhy
* @date 2019年6月12日 上午11:03:17 
* @version:xuxing_迭代
*
 */
public class SaveSamppricnstBP {

	/**
	 * 主入口
	 * @param inParams
	 * @throws BizException
	 */
	public void exec(SampPricnstDTO[] inParams) throws BizException {

		//1、数据校验
		valadation(inParams);

		//2、获取编辑的费用对照
		HashMap<String, SampPriChldCnstDO> mapCnst = getExistCnst(inParams);

		//3、保存
		save(inParams, mapCnst);
	}

	/**
	 * 基础校验
	 * @param inParams
	 * @throws BizException
	 */
	private void valadation(SampPricnstDTO[] inParams) throws BizException {
		if (inParams == null || inParams.length < 1)
			throw new BizException("儿童采集费用对照: 对照信息不能为空");
	}

	/**
	 * 获取编辑的儿童费用对照
	 * @param inParams
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, SampPriChldCnstDO> getExistCnst(SampPricnstDTO[] inParams) throws BizException {
		HashMap<String, SampPriChldCnstDO> reMap = new HashMap<String, SampPriChldCnstDO>();
		if (inParams == null || inParams.length < 1)
			return reMap;
		List<String> listChldCnst = new ArrayList<String>();
		for (SampPricnstDTO param : inParams) {
			if (StringUtil.isEmptyWithTrim(param.getId_chld_cnst()))
				continue;
			if (!listChldCnst.contains(param.getId_chld_cnst()))
				listChldCnst.add(param.getId_chld_cnst());
		}
		if (listChldCnst.size() > 0) {
			SampPriChldCnstDO[] rtns = ServiceFinder.find(ISamppricnstRService.class).findByIds(listChldCnst.toArray(new String[0]), FBoolean.FALSE);
			if (rtns == null || rtns.length < 1)
				return reMap;
			for (SampPriChldCnstDO rtn : rtns) {
				reMap.put(rtn.getId_chld_cnst(), rtn);
			}
		}
		return reMap;
	}

	/**
	 * 保存
	 * @param inParams
	 * @param mapCnst
	 * @throws BizException
	 */
	private void save(SampPricnstDTO[] inParams, HashMap<String, SampPriChldCnstDO> mapCnst) throws BizException {
		if (inParams == null || inParams.length < 1)
			return;
		List<SampPriChldCnstDO> listSave = new ArrayList<SampPriChldCnstDO>();
		for (SampPricnstDTO param : inParams) {
			if (StringUtil.isEmptyWithTrim(param.getId_chld_cnst())) {
				if (StringUtil.isEmptyWithTrim(param.getContrast_id_srv()))
					continue;
				SampPriChldCnstDO cnst = new SampPriChldCnstDO();
				cnst.setId_org(Context.get().getOrgId());
				cnst.setId_grp(Context.get().getGroupId());
				cnst.setId_srv_base(param.getSamppri_id_srv());
				cnst.setId_srv(param.getContrast_id_srv());
				cnst.setStatus(DOStatus.NEW);
				listSave.add(cnst);
				continue;
			}
			SampPriChldCnstDO cnstUpdate = mapCnst.get(param.getId_chld_cnst());
			if (cnstUpdate == null)
				continue;
			cnstUpdate.setStatus(DOStatus.UPDATED);
			if (StringUtil.isEmptyWithTrim(param.getContrast_id_srv()))
				cnstUpdate.setStatus(DOStatus.DELETED);
			cnstUpdate.setId_srv(param.getContrast_id_srv());
			listSave.add(cnstUpdate);
		}
		if (listSave.size() > 0)
			ServiceFinder.find(ISamppricnstCudService.class).save(listSave.toArray(new SampPriChldCnstDO[0]));
	}
}
