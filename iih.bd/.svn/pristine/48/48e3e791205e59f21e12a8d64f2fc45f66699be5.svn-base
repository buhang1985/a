package iih.bd.srv.urgentsrv.s.bp;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.srv.medsrv.d.MedSrvAttrMaping;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.urgentsrv.d.UrgentSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除加急项目
 * 
 * @author hao_wu 2020-1-8
 *
 */
public class DeleteUrgentSrvBp {

	public void exec(EnTypeDO enTypeDo, UrgentSrvDTO[] urgentSrvDtos) throws BizException {

		Map<String, UrgentSrvDTO> urgentSrvDtoMap = MapUtils.convertArrayToMap(urgentSrvDtos, "Id_srv");

		String[] srvIds = DoUtils.getAttrValArrNotNull(urgentSrvDtos, "Id_srv", String.class);

		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDos = medsrvMDORService.findByIds(srvIds, FBoolean.FALSE);
		if (ArrayUtils.isEmpty(medSrvDos)) {
			return;
		}

		ArrayList<MedSrvDO> updateMedSrvDoList = new ArrayList<>();
		String urgentAttrName = MedSrvAttrMaping.getUrgentAttrName(enTypeDo.getCode());
		String defUrgentAttrName = MedSrvAttrMaping.getDefUrgentAttrName(enTypeDo.getCode());
		for (MedSrvDO medSrvDO : medSrvDos) {
			UrgentSrvDTO urgentSrvDTO = urgentSrvDtoMap.get(medSrvDO.getId_srv());
			FBoolean urgentFlag = (FBoolean) medSrvDO.getAttrVal(urgentAttrName);
			FBoolean defUrgentFlag = (FBoolean) medSrvDO.getAttrVal(defUrgentAttrName);
			if (this.equalsFBoolean(urgentFlag, FBoolean.FALSE)
					&& this.equalsFBoolean(defUrgentFlag, urgentSrvDTO.getFg_urgent_def())) {
				continue;
			}

			medSrvDO.setAttrVal(urgentAttrName, FBoolean.FALSE);
			medSrvDO.setAttrVal(defUrgentAttrName, FBoolean.FALSE);

			medSrvDO.setStatus(DOStatus.UPDATED);
			updateMedSrvDoList.add(medSrvDO);
		}

		if (updateMedSrvDoList.size() <= 0) {
			return;
		}

		IMedsrvMDOCudService medsrvMDOCudService = ServiceFinder.find(IMedsrvMDOCudService.class);
		medsrvMDOCudService.update(updateMedSrvDoList.toArray(new MedSrvDO[0]));
	}

	/**
	 * 判定两个FBoolean类型值是否相等
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	private boolean equalsFBoolean(FBoolean value1, FBoolean value2) {
		if (value1 != null && !value1.equals(value2)) {
			return false;
		}
		if (value2 != null && !value2.equals(value1)) {
			return false;
		}
		return true;
	}

}
