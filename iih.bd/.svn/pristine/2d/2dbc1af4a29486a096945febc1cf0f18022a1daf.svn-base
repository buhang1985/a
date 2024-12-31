package iih.bd.pp.baseprisrv.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.accountsrv.i.IAccountSrvMap;
import iih.bd.pp.accountsrv.i.IAccountsrvExtRService;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 启用基础价格服务
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class EnableBasePriSrvBp {

	public PriSrvDO[] exec(PriSrvDO[] priSrvDos) throws BizException {
		String[] srvIds = DoUtils.getAttrValArr(priSrvDos, PriSrvDO.ID_SRV, String.class);
		if (ArrayUtils.isEmpty(srvIds)) {
			return priSrvDos;
		}
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDos = medsrvMDORService.findByIds(srvIds, FBoolean.FALSE);

		checkAcc(medSrvDos);

		for (MedSrvDO medSrvDO : medSrvDos) {
			medSrvDO.setFg_active_bl(FBoolean.TRUE);
			medSrvDO.setStatus(DOStatus.UPDATED);
		}
		IMedsrvMDOCudService medsrvMDOCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		medSrvDos = medsrvMDOCudService.update(medSrvDos);

		for (int i = 0; i < priSrvDos.length; i++) {

			PriSrvDO priSrvDo = priSrvDos[i];
			MedSrvDO medSrvDo = medSrvDos[i];

			priSrvDo.setFg_active(medSrvDo.getFg_active_bl());
			priSrvDo.setModifiedby(medSrvDo.getModifiedby());
			priSrvDo.setModifiedtime(medSrvDo.getModifiedtime());
			priSrvDo.setSv(medSrvDo.getSv());
		}

		fireEvent(medSrvDos);

		return priSrvDos;
	}

	/**
	 * 发送事件
	 * 
	 * @param medSrvDos
	 * @throws BizException
	 */
	private void fireEvent(MedSrvDO[] medSrvDos) throws BizException {
		BasePriSrvEventHandler eventHandler = new BasePriSrvEventHandler();
		eventHandler.fireEvent(medSrvDos, IEventType.TYPE_INSERT_AFTER);
	}

	/**
	 * 检查核算体系
	 * 
	 * @param medSrvArr
	 * @throws BizException
	 */
	private void checkAcc(MedSrvDO[] medSrvArr) throws BizException {

		List<MedSrvDO> needCheckMedSrvList = new ArrayList<>();
		for (MedSrvDO medSrvDO : medSrvArr) {
			if (medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
					|| (IBdPrimdCodeConst.CODE_PRI_SRV.equals(medSrvDO.getSd_primd())
							&& FBoolean.TRUE.equals(medSrvDO.getFg_bl()))) {
				needCheckMedSrvList.add(medSrvDO);
			}
		}
		if (needCheckMedSrvList.size() <= 0) {
			return;
		}

		FBoolean useAccSys = BdPpParamUtils.getUseAccountSystemFlag();
		if (!FBoolean.TRUE.equals(useAccSys)) {
			return;
		}

		String[] accCaIds = getAccCaIds();

		String[] srvIds = DoUtils.getAttrValArr(needCheckMedSrvList.toArray(new MedSrvDO[0]), MedSrvDO.ID_SRV,
				String.class);

		IAccountSrvMap accSrvMap = getAccMap(srvIds);

		ArrayList<MedSrvDO> errSrvList = new ArrayList<>();
		for (MedSrvDO medSrvDO : needCheckMedSrvList) {
			for (String accCaId : accCaIds) {
				if (FBoolean.FALSE.equals(accSrvMap.contains(medSrvDO.getId_srv(), accCaId))) {
					errSrvList.add(medSrvDO);
					break;
				}
			}
		}

		if (errSrvList.size() > 0) {
			String[] srvNames = new String[errSrvList.size()];
			for (int i = 0; i < errSrvList.size(); i++) {
				srvNames[i] = String.format("%s【%s】", errSrvList.get(i).getName(), errSrvList.get(i).getCode());
			}

			String msg = String.format("%s以上项目未维护核算体系，不允许启用。", StringUtils.join(srvNames, ","));
			throw new BizException(msg);
		}
	}

	/**
	 * 获取核算体系字典
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private IAccountSrvMap getAccMap(String[] srvIds) throws BizException {
		IAccountsrvExtRService accountsrvExtRService = ServiceFinder.find(IAccountsrvExtRService.class);
		IAccountSrvMap accMap = accountsrvExtRService.getAccMapBySrvIds(srvIds);
		return accMap;
	}

	/**
	 * 获取核算体系分类主键集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private String[] getAccCaIds() throws BizException {
		FBoolean shareAccSystem = BdPpParamUtils.getShareAcountSystemFlag();
		if (FBoolean.TRUE.equals(shareAccSystem)) {
			return new String[] { IBdPpDictCodeConst.ID_ACCOUNT_GY };
		}
		return new String[] { IBdPpDictCodeConst.ID_ACCOUNT_MZ, IBdPpDictCodeConst.ID_ACCOUNT_ZY };
	}
}
