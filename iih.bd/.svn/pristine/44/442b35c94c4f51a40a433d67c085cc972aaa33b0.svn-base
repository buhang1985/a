package iih.bd.pp.baseprisrv.s.bp;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.MapUtils;
import iih.bd.pp.baseprisrv.d.BaseprisrvAggDO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.pp.prisrv.i.IPrisrvCudService;
import iih.bd.pp.prisrv.i.IPrisrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 保存基础价格服务
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class SaveBasePriSrvAggBp {

	public BaseprisrvAggDO[] exec(BaseprisrvAggDO[] aggs) throws BizException {
		// 生成主键
		updateId(aggs);

		// 保存价格信息
		savePriList(aggs);

		// 保存价格服务
		savePriSrv(aggs);

		// 更新数据状态
		updateState(aggs);

		// 设置收费依据
		setChargeBasis(aggs);

		return aggs;
	}

	private void savePriSrv(BaseprisrvAggDO[] aggs) throws BizException {
		PriSrvDO[] priSrvDOs = new PriSrvDO[aggs.length];
		for (int i = 0; i < aggs.length; i++) {
			priSrvDOs[i] = aggs[i].getParentDO();
		}

		SavePriSrvBp bp = new SavePriSrvBp();
		bp.exec(priSrvDOs);
	}

	/**
	 * 设置收费依据
	 * 
	 * @param aggs
	 */
	private void setChargeBasis(BaseprisrvAggDO[] aggs) {
		FDateTime endDateTime = new FDateTime("2099-12-31 23:59:59");
		for (BaseprisrvAggDO baseprisrvAggDO : aggs) {
			PriSrvDO priSrvDO = baseprisrvAggDO.getParentDO();
			SrvPriDO[] priDos = baseprisrvAggDO.getSrvPriDO();
			if (ArrayUtils.isEmpty(priDos)) {
				continue;
			}
			for (SrvPriDO srvPriDo : priDos) {
				if (endDateTime.equals(srvPriDo.getDt_e())) {
					priSrvDO.setCharge_basis(srvPriDo.getDes());
					break;
				}
			}
		}

	}

	/**
	 * 更新服务主键</br>
	 * 先生成主键，保存所有子数据
	 * 
	 * @param aggs
	 */
	private void updateId(BaseprisrvAggDO[] aggs) {
		for (BaseprisrvAggDO baseprisrvAggDO : aggs) {
			PriSrvDO priSrvDo = baseprisrvAggDO.getParentDO();
			String srvId = priSrvDo.getId_srv();
			if (StringUtils.isBlank(srvId)) {
				srvId = new DBUtil().getOIDs(1)[0];
				priSrvDo.setId_srv(srvId);
			}

			SrvPriDO[] priDOs = baseprisrvAggDO.getSrvPriDO();
			if (ArrayUtils.isNotEmpty(priDOs)) {
				for (SrvPriDO priDo : priDOs) {
					priDo.setId_srv(srvId);
				}
			}
		}
	}

	/**
	 * 保存价格信息
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	private void savePriList(BaseprisrvAggDO[] aggs) throws BizException {

		// 只处理新增的，此处业务限制不允许修改
		ArrayList<SrvPriDO> savePriList = new ArrayList<SrvPriDO>();
		ArrayList<String> updateSrvPriIdList = new ArrayList<String>();
		for (BaseprisrvAggDO priSrvAggDo : aggs) {
			SrvPriDO[] srvPriDos = priSrvAggDo.getSrvPriDO();
			if (ArrayUtils.isEmpty(srvPriDos)) {
				continue;
			}
			for (SrvPriDO srvPriDO : srvPriDos) {
				if (srvPriDO.getStatus() == DOStatus.NEW || srvPriDO.getStatus() == DOStatus.UPDATED) {
					savePriList.add(srvPriDO);
					if (srvPriDO.getStatus() == DOStatus.UPDATED) {
						updateSrvPriIdList.add(srvPriDO.getId_srvpri());
					}
				}
			}
		}

		if (savePriList.size() <= 0) {
			return;
		}

		// 查询旧数据
		IPrisrvRService prisrvRService = ServiceFinder.find(IPrisrvRService.class);
		iih.bd.pp.prisrv.d.PriSrvDO[] oldPris = prisrvRService.findByIds(updateSrvPriIdList.toArray(new String[0]),
				FBoolean.FALSE);
		Map<String, iih.bd.pp.prisrv.d.PriSrvDO> oldPriMap = MapUtils.convertArrayToMap(oldPris,
				iih.bd.pp.prisrv.d.PriSrvDO.ID_PRISRV);

		// 构建数据
		iih.bd.pp.prisrv.d.PriSrvDO[] pris = new iih.bd.pp.prisrv.d.PriSrvDO[savePriList.size()];
		for (int i = 0; i < savePriList.size(); i++) {
			SrvPriDO srvPriDo = savePriList.get(i);
			if (srvPriDo.getStatus() == DOStatus.NEW) {
				iih.bd.pp.prisrv.d.PriSrvDO priSrvDo = new iih.bd.pp.prisrv.d.PriSrvDO();
				priSrvDo.setStatus(DOStatus.NEW);
				priSrvDo.setId_grp(srvPriDo.getId_grp());
				priSrvDo.setId_org(srvPriDo.getId_org());
				priSrvDo.setId_srv(srvPriDo.getId_srv());
				priSrvDo.setDt_b(srvPriDo.getDt_b());
				priSrvDo.setDt_e(srvPriDo.getDt_e());
				priSrvDo.setPrice(srvPriDo.getPrice());
				priSrvDo.setDes(srvPriDo.getDes());
				priSrvDo.setFg_active(FBoolean.TRUE);
				pris[i] = priSrvDo;
			} else if (srvPriDo.getStatus() == DOStatus.UPDATED) {
				iih.bd.pp.prisrv.d.PriSrvDO priSrvDo = oldPriMap.get(srvPriDo.getId_srvpri());
				priSrvDo.setStatus(DOStatus.UPDATED);
				priSrvDo.setDes(srvPriDo.getDes());
				pris[i] = priSrvDo;
			}
		}

		// 保存数据
		IPrisrvCudService prisrvCudService = ServiceFinder.find(IPrisrvCudService.class);
		pris = prisrvCudService.save(pris);

		for (int i = 0; i < pris.length; i++) {
			iih.bd.pp.prisrv.d.PriSrvDO newPriDo = pris[i];
			SrvPriDO oldPriDo = savePriList.get(i);

			oldPriDo.setId_srvpri(newPriDo.getId_prisrv());
			oldPriDo.setDs(newPriDo.getDs());
			oldPriDo.setCreatedby(newPriDo.getCreatedby());
			oldPriDo.setCreatedtime(newPriDo.getCreatedtime());
			oldPriDo.setModifiedby(newPriDo.getModifiedby());
			oldPriDo.setModifiedtime(newPriDo.getModifiedtime());
			oldPriDo.setSv(newPriDo.getSv());
		}
	}

	/**
	 * 更新状态为UNCHANGED
	 * 
	 * @param aggs
	 */
	private void updateState(BaseprisrvAggDO[] aggs) {
		for (BaseprisrvAggDO baseprisrvAggDO : aggs) {
			PriSrvDO priSrvDo = baseprisrvAggDO.getParentDO();
			priSrvDo.setStatus(DOStatus.UNCHANGED);

			SrvPriDO[] priDos = baseprisrvAggDO.getSrvPriDO();
			for (SrvPriDO priDo : priDos) {
				priDo.setStatus(DOStatus.UNCHANGED);
			}
		}
	}

}
