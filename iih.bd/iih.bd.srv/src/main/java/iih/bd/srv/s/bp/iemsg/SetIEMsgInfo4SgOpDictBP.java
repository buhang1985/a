package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagdef.i.IDiagdefCudService;
import iih.bd.srv.diagdef.i.IDiagdefRService;
import iih.bd.srv.iemsg.d.IESgOpDictDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * MS004 ： 手术与操作字典</br>
 * 对应诊断定义中诊断定义中 ICD-9-CM-3
 * 
 * @author YANG
 *
 */
public class SetIEMsgInfo4SgOpDictBP {

	public void exec(IESgOpDictDTO[] dtos) throws BizException {
		if (dtos == null || dtos.length <= 0)
			return;
		ArrayList<DiagdefAggDO> defAggDOsInsert = new ArrayList<DiagdefAggDO>();
		Map<String, IESgOpDictDTO> mapIESgOpDictDTOs = new HashMap<String, IESgOpDictDTO>();
		String strCodeUpdate = "";
		String strCodeDelete = "";
		for (IESgOpDictDTO dto : dtos) {
			DiagDefDO defDO = new DiagDefDO();
			switch (dto.getAction()) {
			case IBdSrvIEEventConst.ACTION_INSERT:
				execInsert(defDO, dto);
				break;
			case IBdSrvIEEventConst.ACTION_UPDATE:
				strCodeUpdate += "'" + dto.getIcdcode() + "',";
				mapIESgOpDictDTOs.put(dto.getIcdcode(), dto);
				break;
			case IBdSrvIEEventConst.ACTION_DELETE:
				strCodeDelete += "'" + dto.getIcdcode() + "',";
				break;
			}
			DiagdefAggDO defAggDO = new DiagdefAggDO();
			defAggDO.setParentDO(defDO);
			defAggDOsInsert.add(defAggDO);
		}
		DiagdefAggDO[] defAggDOsUpdate = getDiagdefAggDOs(strCodeUpdate);
		DiagdefAggDO[] defAggDOsDelete = getDiagdefAggDOs(strCodeDelete);
		IDiagdefCudService service = ServiceFinder.find(IDiagdefCudService.class);
		if (defAggDOsUpdate != null && defAggDOsUpdate.length > 0) {
			execUpdate(defAggDOsUpdate, mapIESgOpDictDTOs);
			service.update(defAggDOsUpdate);
		}
		if (defAggDOsDelete != null && defAggDOsDelete.length > 0) {
			service.delete(defAggDOsDelete);
		}
		if (defAggDOsInsert != null && defAggDOsInsert.size() > 0) {
			service.save(defAggDOsInsert.toArray(new DiagdefAggDO[defAggDOsInsert.size()]));
		}
	}

	private void execInsert(DiagDefDO defDO, IESgOpDictDTO dto) {
		defDO.setId_grp("");
		defDO.setId_org("");
		defDO.setCode(dto.getIcdcode());
		defDO.setName(dto.getIcdname());
		defDO.setPycode(dto.getPycode());
		defDO.setWbcode("");
		defDO.setMnecode(dto.getCode());
		//		dto.getStandardflg();
		//		dto.setGraded("");
		//		dto.setCategory("");
		defDO.setFg_ur(FBoolean.FALSE);
		defDO.setFg_active(FBoolean.TRUE);
		defDO.setId_cdsys("0001Z7100000000GFT59");
		defDO.setSd_cdsys("ICD9");
		defDO.setId_cdsystp("0001AA10000000076SMO");
		defDO.setSd_cdsystp("14");
		defDO.setId_distdca("");
		defDO.setFg_ds(FBoolean.FALSE);
		defDO.setFg_chronic(FBoolean.FALSE);
		defDO.setFg_special(FBoolean.FALSE);
		defDO.setStatus(2);
	}

	private void execUpdate(DiagdefAggDO[] defAggDOsUpdate, Map<String, IESgOpDictDTO> mapIESgOpDictDTOs) {

		for (DiagdefAggDO defAggDO : defAggDOsUpdate) {
			defAggDO.getParentDO().setName(mapIESgOpDictDTOs.get(defAggDO.getParentDO().getCode()).getIcdname());
			defAggDO.getParentDO().setPycode(mapIESgOpDictDTOs.get(defAggDO.getParentDO().getCode()).getPycode());
			defAggDO.getParentDO().setMnecode(mapIESgOpDictDTOs.get(defAggDO.getParentDO().getCode()).getCode());
		}
	}

	private DiagdefAggDO[] getDiagdefAggDOs(String sqlQry) throws BizException {
		if (sqlQry.length() < 1)
			return null;
		IDiagdefRService service = ServiceFinder.find(IDiagdefRService.class);
		return service.find(" code in (" + sqlQry.substring(0, sqlQry.length() - 1) + ")", "", FBoolean.FALSE);
	}
}
