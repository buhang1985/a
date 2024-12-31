package iih.bd.srv.medsrv.s.rule;

import java.util.ArrayList;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.s.rule.bp.CalMedSrvSetItmChkNumBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.IRule;

/**
 * 计算医疗服务套临床必选项目数量规则</br>
 * 医疗服务保存后处理
 * 
 * @author hao_wu
 *
 */
@SuppressWarnings("rawtypes")
public class CalMedSrvSetItmChkNumRule implements IRule {

	@Override
	public void process(Object... arg0) throws BizException {
		if (arg0 == null || arg0.length <= 0) {
			return;
		}

		CalMedSrvSetItmChkNum(arg0);
	}

	/**
	 * 计算医疗服务套临床必选项目数量
	 * 
	 * @param objs
	 * @throws BizException
	 */
	private void CalMedSrvSetItmChkNum(Object[] objs) throws BizException {
		Object firstObj = objs[0];
		if (firstObj instanceof MedsrvAggDO) {
			CalMedSrvSetItmChkNumByMedSrvAggs((MedsrvAggDO[]) objs);
		} else if (firstObj instanceof MedSrvDO) {
			CalMedSrvSetItmChkNumByMedSrvs((MedSrvDO[]) objs);
		} else if (firstObj instanceof MedSrvSetItemDO) {
			CalMedSrvSetItmChkNumByMedSrvSetItems((MedSrvSetItemDO[]) objs);
		}
	}

	/**
	 * 根据医疗服务Agg计算医疗服务套临床必选项目数量
	 * 
	 * @param medSrvAggs
	 * @throws BizException
	 */
	private void CalMedSrvSetItmChkNumByMedSrvAggs(MedsrvAggDO[] medSrvAggs) throws BizException {
		String[] medSrvSetIds = GetMedSrvSetIds(medSrvAggs);
		CalMedSrvSetItmChkNumByMedSrvSetIds(medSrvSetIds);
	}

	/**
	 * 根据医疗服务计算医疗服务套临床必选项目数量
	 * 
	 * @param medSrvs
	 * @throws BizException
	 */
	private void CalMedSrvSetItmChkNumByMedSrvs(MedSrvDO[] medSrvs) throws BizException {
		String[] medSrvSetIds = GetMedSrvSetIds(medSrvs);
		CalMedSrvSetItmChkNumByMedSrvSetIds(medSrvSetIds);
	}

	/**
	 * 根据医疗服务套内项目计算医疗服务套临床必选项目数量
	 * 
	 * @param medSrvSetItems
	 * @throws BizException
	 */
	private void CalMedSrvSetItmChkNumByMedSrvSetItems(MedSrvSetItemDO[] medSrvSetItems) throws BizException {
		String[] medSrvSetIds = GetMedSrvSetIds(medSrvSetItems);
		CalMedSrvSetItmChkNumByMedSrvSetIds(medSrvSetIds);
	}

	/**
	 * 从医疗服务Agg中获取医疗服务套主键集合
	 * 
	 * @param medSrvAggs
	 * @return
	 */
	private String[] GetMedSrvSetIds(MedsrvAggDO[] medSrvAggs) {
		ArrayList<MedSrvDO> medSrvList = new ArrayList<MedSrvDO>();
		for (MedsrvAggDO medsrvAggDO : medSrvAggs) {
			if (medsrvAggDO != null) {
				medSrvList.add(medsrvAggDO.getParentDO());
			}
		}
		MedSrvDO[] medSrvs = medSrvList.toArray(new MedSrvDO[0]);
		return GetMedSrvSetIds(medSrvs);
	}

	/**
	 * 从医疗服务中获取医疗服务套主键集合
	 * 
	 * @param medSrvs
	 * @return
	 */
	private String[] GetMedSrvSetIds(MedSrvDO[] medSrvs) {
		ArrayList<String> medSrvIdList = new ArrayList<String>();
		for (MedSrvDO medSrvDO : medSrvs) {
			if (medSrvDO != null && FBoolean.TRUE.equals(medSrvDO.getFg_set())) {
				medSrvIdList.add(medSrvDO.getId_srv());
			}
		}
		return medSrvIdList.toArray(new String[0]);
	}

	/**
	 * 从医疗服务套内项目中获取医疗服务套主键集合
	 * 
	 * @param medSrvSetItems
	 * @return
	 */
	private String[] GetMedSrvSetIds(MedSrvSetItemDO[] medSrvSetItems) {
		ArrayList<String> medSrvIdList = new ArrayList<String>();
		for (MedSrvSetItemDO medSrvSetItemDO : medSrvSetItems) {
			if (medSrvSetItemDO != null && !medSrvIdList.contains(medSrvSetItemDO.getId_srv())) {
				medSrvIdList.add(medSrvSetItemDO.getId_srv());
			}
		}
		return medSrvIdList.toArray(new String[0]);
	}

	/**
	 * 根据医疗服务套主键集合计算医疗服务套临床必选项目数量
	 * 
	 * @param medSrvSetIds
	 * @throws BizException
	 */
	private void CalMedSrvSetItmChkNumByMedSrvSetIds(String[] medSrvSetIds) throws BizException {
		CalMedSrvSetItmChkNumBp bp = new CalMedSrvSetItmChkNumBp();
		bp.exec(medSrvSetIds);
	}
}
