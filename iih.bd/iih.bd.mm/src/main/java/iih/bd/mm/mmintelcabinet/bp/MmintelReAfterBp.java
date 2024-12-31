package iih.bd.mm.mmintelcabinet.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.mmintelcabinet.d.MmIntelcabinetDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class MmintelReAfterBp {
	
	public void exec(MmIntelcabinetDO[] mmIntelCaDOS) throws BizException {
		
		if(mmIntelCaDOS == null || mmIntelCaDOS.length <= 0) {
			
			return;
		}
		
		// ■ 关联字段设置
		this.setRefName(mmIntelCaDOS);
	}

	private void setRefName(MmIntelcabinetDO[] mmIntelCaDOS) throws BizException {
		
		//部门获取
		Map<String, DeptDO> depMap = this.getDeptMap(mmIntelCaDOS);
		
		//医疗服务获取
		Map<String, MedSrvDO> medSrvMap = this.getMedSrvMap(mmIntelCaDOS);
		
		//关联字段设置
		this.setRefName(mmIntelCaDOS, depMap, medSrvMap);
	}

	private Map<String, DeptDO> getDeptMap(MmIntelcabinetDO[] mmIntelCaDOS) throws BizException {
		
		IDeptRService deptRSrv = ServiceFinder.find(IDeptRService.class);
		
		Map<String, DeptDO> result = new HashMap<String, DeptDO>();
		String[] deptIDs = this.getDeptIdList(mmIntelCaDOS);
		DeptDO[] deptDOS = deptRSrv.findByIds(deptIDs, FBoolean.TRUE);
		for(DeptDO deptDO : deptDOS) {
			
			result.put(deptDO.getId_dep(), deptDO);
		}
		
		return result;
	}

	private String[] getDeptIdList(MmIntelcabinetDO[] mmIntelCaDOS) {
		
		List<String> deptIDs = new ArrayList<String>();
		for(MmIntelcabinetDO mmIntelCaDO : mmIntelCaDOS) {
			
			deptIDs.add(mmIntelCaDO.getId_smcdep());
		}
		
		return deptIDs.toArray(new String[deptIDs.size()]);
	}
	
	private Map<String, MedSrvDO> getMedSrvMap(MmIntelcabinetDO[] mmIntelCaDOS) throws BizException {
		
		IMedsrvMDORService medSrvRSrv = ServiceFinder.find(IMedsrvMDORService.class);
		
		Map<String, MedSrvDO> result = new HashMap<String, MedSrvDO>();
		String[] srvIDs = this.getMedSrvIdList(mmIntelCaDOS);
		MedSrvDO[] medSrvDOS = 	medSrvRSrv.findByIds(srvIDs, FBoolean.TRUE);
		for(MedSrvDO medSrvDO : medSrvDOS) {
			
			result.put(medSrvDO.getId_srv(), medSrvDO);
		}
		
		return result;
	}

	private String[] getMedSrvIdList(MmIntelcabinetDO[] mmIntelCaDOS) {
		
		List<String> srvIDs = new ArrayList<String>();
		for(MmIntelcabinetDO mmIntelCaDO : mmIntelCaDOS) {
			
			srvIDs.add(mmIntelCaDO.getId_smcsrv());
		}
		
		return srvIDs.toArray(new String[srvIDs.size()]);
	}
	
	private void setRefName(MmIntelcabinetDO[] mmIntelCaDOS, Map<String, DeptDO> depMap, Map<String, MedSrvDO> medSrvMap) {
		
		for(MmIntelcabinetDO mmIntelCaDO : mmIntelCaDOS) {
			
			//部门
			DeptDO deptDO = depMap.get(mmIntelCaDO.getId_smcdep());
			mmIntelCaDO.setDep_name(deptDO.getName());
			//通用名称
			MedSrvDO medSrvDO = medSrvMap.get(mmIntelCaDO.getId_smcsrv());
			mmIntelCaDO.setSrv_name(medSrvDO.getName());
		}
	}
}
