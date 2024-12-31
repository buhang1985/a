package iih.bd.fc.s.bp.orpltpmatch;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.IMpDictCodeConst;
import iih.bd.fc.orpltpmatch.d.EnumBool;
import iih.bd.fc.orpltpmatch.d.EnumOrpltpCtrl;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchAttrDO;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpmatch.d.OrpltpmatchAggDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchCudService;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchRService;
import iih.bd.fc.orwf.d.EnumAttr; 
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @Description:闭环匹配数据升级
 * @author tiancj
 * @version ：2019-12-23 10:14:15
 */
public class UpOrpltpMatchGradeBp {

	public void exec() throws BizException {

		// 1、查询闭环匹配所有数据
		OrpltpmatchAggDO[] aggs = queryAllData();
		if (aggs == null || aggs.length < 1)
			return;

		// 2、升级医疗服务数据
		upSrvData(aggs);

		// 3、升级药品退药数据
		upDdmdata(aggs);

		// 4、调用agg保存服务
		saveData(aggs);
	}

	/**
	 * 查询闭环匹配的数据
	 * 
	 * @return
	 * @throws BizException
	 */
	private OrpltpmatchAggDO[] queryAllData() throws BizException {
		return ServiceFinder.find(IOrpltpmatchRService.class).find(" 1=1 ", "", FBoolean.FALSE);
	}

	/**
	 * 升级医疗服务数据
	 * 
	 * @param aggs
	 * @return
	 * @throws BizException
	 */
	private void upSrvData(OrpltpmatchAggDO[] aggs) throws BizException {
		for (OrpltpmatchAggDO agg : aggs) {
			OrpltpMatchDO orpltpmatch = agg.getParentDO();
			OrpltpMatchAttrDO[] arrts = agg.getOrpltpMatchAttrDO();
			List<OrpltpMatchAttrDO> attrDO = new ArrayList<OrpltpMatchAttrDO>(); // 字表新增的数据（id_srv
			if (orpltpmatch == null)
				continue;
			if (!StringUtil.isEmptyWithTrim(orpltpmatch.getId_srv())) {
				// 排除 不限制是更新主表数据 判断是不是药品闭环
				if (EnumOrpltpCtrl.EXCLUDE.equals(orpltpmatch.getEu_srv()) || EnumOrpltpCtrl.NONE.equals(orpltpmatch.getEu_srv())) {
					orpltpmatch.setId_srv("~");
				} else {
					// 限制和 空数据 是 子表增加id_srv
					if (!EnumOrpltpCtrl.CTRL.equals(orpltpmatch.getEu_srv()))
						orpltpmatch.setEu_srv(EnumOrpltpCtrl.CTRL);
					if (arrts == null || arrts.length < 1) {
						copySonSrvData(orpltpmatch, attrDO);
						agg.setOrpltpMatchAttrDO(attrDO.toArray(new OrpltpMatchAttrDO[0]));
					} else {
						int i = 0;
						for (OrpltpMatchAttrDO attr : arrts) {
							if (!StringUtil.isEmptyWithTrim(attr.getId_srv()) && orpltpmatch.getId_srv().equals(attr.getId_srv())) {
								i++;
								continue;
							}
						}
						if (i == 0) {
							copySonSrvData(orpltpmatch, attrDO);
						}
						for (OrpltpMatchAttrDO attr : arrts) {
							attrDO.add(attr);
						}
						agg.setOrpltpMatchAttrDO(attrDO.toArray(new OrpltpMatchAttrDO[0]));
					}
					orpltpmatch.setId_srv("~");
				}
				orpltpmatch.setStatus(DOStatus.UPDATED);
			}
		}
	}

	/**
	 * 升级的药品数据
	 * 
	 * @param aggs
	 * @param srvData
	 */
	private void upDdmdata(OrpltpmatchAggDO[] aggs) {
		for (OrpltpmatchAggDO agg : aggs) {
			OrpltpMatchDO orpltpmatch = agg.getParentDO();
			if (orpltpmatch != null && !StringUtil.isEmptyWithTrim(orpltpmatch.getSd_srvtp())) {
				if (orpltpmatch.getSd_srvtp().startsWith("01") && !EnumBool.YES.equals(orpltpmatch.getEu_fg_back()) && !EnumBool.NO.equals(orpltpmatch.getEu_fg_back())) {
					updateFgBack(orpltpmatch,agg);
				}
			}
		}
	}

	/**
	 * 退药升级数据
	 * @param orpltpmatch
	 * @param agg
	 */
	private void updateFgBack(OrpltpMatchDO orpltpmatch,OrpltpmatchAggDO agg){
		orpltpmatch.setEu_fg_back(EnumBool.NO);
		orpltpmatch.setStatus(DOStatus.UPDATED);
		agg.setParentDO(orpltpmatch);
	}

	/**
	 * 为子表医疗服务数据赋值
	 * 
	 * @param orp1
	 * @param attr2
	 * @param orp2
	 */
	private void copySonSrvData(OrpltpMatchDO orp1, List<OrpltpMatchAttrDO> attr) {
		OrpltpMatchAttrDO attr1 = new OrpltpMatchAttrDO();
		attr1.setId_orpltp_match(orp1.getId_orpltp_match());
		attr1.setEu_attr(EnumAttr.SRV);
		attr1.setId_srv(orp1.getId_srv());
		attr1.setId_dep("~");
		attr1.setId_udiddm("~");
		attr1.setId_dep_phy("~");
		attr1.setId_dep_phy("~");
		attr1.setCode(orp1.getCode_srv());
		attr1.setStatus(DOStatus.NEW);
		attr.add(attr1);
	}

	/**
	 * 保存服务
	 * 
	 * @param srvData
	 * @throws BizException
	 */
	private void saveData(OrpltpmatchAggDO[] srvData) throws BizException {
		ServiceFinder.find(IOrpltpmatchCudService.class).save(srvData);
	}
}
