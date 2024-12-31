package iih.bd.srv.medsrv.s.rule;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 医疗服务药品属性变更检查规则
 * 
 * @author hao_wu 2020-1-6
 *
 */
public class MedSrvDrugPropChangCheckRule implements ICompareRule<MedSrvDrugDO> {

	@SuppressWarnings("unchecked")
	@Override
	public void process(MedSrvDrugDO[] oldMedSrvDrugDos, MedSrvDrugDO[] newMedSrvDrugDos) throws BizException {
		String[] changedSrvIds = getMmTpChangedSrvIds(oldMedSrvDrugDos, newMedSrvDrugDos);
		if (changedSrvIds == null || changedSrvIds.length <= 0) {
			// 不存在物品类型变更的数据
			return;
		}

		String sql = String.format("select id_srv from bd_srv where sd_srvtp like '%s%%' and %s",
				IBdSrvDictCodeConst.SD_SRVTP_DRUG, SqlUtils.getInSqlByIds(MedSrvDO.ID_SRV, changedSrvIds));
		DAFacade daFacade = new DAFacade();
		List<String> drugSrvIdList = (List<String>) daFacade.execQuery(sql, new ColumnListHandler());
		if (drugSrvIdList == null || drugSrvIdList.size() <= 0) {
			// 物品类型变更的不是药品通用名
			return;
		}

		MeterialDO[] mmDos = findMmDoBySrvIds(drugSrvIdList.toArray(new String[0]));

		String[] srvCodes = DoUtils.getAttrValArrNotNull(mmDos, MeterialDO.SRV_CODE, String.class);
		if (srvCodes == null || srvCodes.length <= 0) {
			return;
		}

		String msg = String.format("药品通用名\"%s\"已维护药品信息，不允许修改药品类型。", StringUtils.join(srvCodes, ","));
		throw new BizException(msg);
	}

	/**
	 * 获取物品类型变更的服务主键集合
	 * 
	 * @param oldMedSrvDrugDos
	 * @param newMedSrvDrugDos
	 * @return
	 */
	private String[] getMmTpChangedSrvIds(MedSrvDrugDO[] oldMedSrvDrugDos, MedSrvDrugDO[] newMedSrvDrugDos) {
		ArrayList<String> srvIdList = new ArrayList<>();
		for (int i = 0; i < newMedSrvDrugDos.length; i++) {
			MedSrvDrugDO oldMedSrvDrugDo = oldMedSrvDrugDos[i];
			MedSrvDrugDO newMedSrvDrugDo = newMedSrvDrugDos[i];

			if (StringUtils.isBlank(oldMedSrvDrugDo.getId_mmtp())
					&& StringUtils.isBlank(newMedSrvDrugDo.getId_mmtp())) {
				continue;
			}

			if (StringUtils.isNotBlank(oldMedSrvDrugDo.getId_mmtp())
					&& StringUtils.isNotBlank(newMedSrvDrugDo.getId_mmtp())
					&& oldMedSrvDrugDo.getId_mmtp().equals(newMedSrvDrugDo.getId_mmtp())) {
				continue;
			}

			srvIdList.add(newMedSrvDrugDo.getId_srv());
		}
		return srvIdList.toArray(new String[0]);
	}

	/**
	 * 根据服务主键获取药品信息
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MeterialDO[] findMmDoBySrvIds(String[] srvIds) throws BizException {
		String sql = String.format(
				"select distinct srv.code as srv_code from bd_mm mm inner join bd_Srv srv on srv.id_Srv = mm.id_Srv where %s",
				SqlUtils.getInSqlByIds("srv.id_srv", srvIds));
		DAFacade daFacade = new DAFacade();
		List<MeterialDO> meterialDoList = (List<MeterialDO>) daFacade.execQuery(sql,
				new BeanListHandler(MeterialDO.class));
		if (meterialDoList == null) {
			return null;
		}
		return meterialDoList.toArray(new MeterialDO[0]);
	}

}
