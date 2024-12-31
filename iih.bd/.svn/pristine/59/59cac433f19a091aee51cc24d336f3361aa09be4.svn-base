package iih.bd.srv.empphydto.s.bp;

import java.util.LinkedList;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.EmpPhyDO;
import xap.sys.bdfw.bbd.i.IEmpPhyDOCudService;
import xap.sys.bdfw.bbd.i.IEmpPhyDORService;

/**
 * 更新人员处方权标志属性bp
 * 
 * @author guoyang
 *
 */
public class UpdatePresrtBp {

	public void exec(EmpphyDTO[] empphyDtos, FBoolean presrtFlag) throws BizException {
		if (FBoolean.TRUE.equals(presrtFlag)) {
			confirmPresrt(empphyDtos);
		} else if (FBoolean.FALSE.equals(presrtFlag)) {
			canclePresrt(empphyDtos);
		}
	}

	/**
	 * 医师属性表处方权字段fg_presrt字段置“Y” 如果人员基本信息在医师属性表中不存在，则新建保存
	 * 
	 * @param empphyDtos
	 * @param flag
	 * @throws BizException
	 */
	private void confirmPresrt(EmpphyDTO[] empphyDtos) throws BizException {

		String[] allIdpsndocs = getIdPsndocs(empphyDtos);
		EmpPhyDO[] empphy = queryByPsn(allIdpsndocs);
		String[] qryIdPsndocs = getIdPsndocs(empphy);
		if (qryIdPsndocs != null && qryIdPsndocs.length > 0) {
			for (EmpPhyDO empPhyDO : empphy) {
				empPhyDO.setFg_presrt(FBoolean.TRUE);
				empPhyDO.setStatus(DOStatus.UPDATED);
			}
			IEmpPhyDOCudService empPhyDOCudService = ServiceFinder.find(IEmpPhyDOCudService.class);
			empPhyDOCudService.update(empphy);
		}

		String[] unSaveIdpsndocs = substract(allIdpsndocs, qryIdPsndocs);
		saveEmpPhy(unSaveIdpsndocs);
	}

	/**
	 * 医师属性表处方权字段fg_presrt字段置“N”
	 * 
	 * @param empphyDtos
	 * @param flag
	 * @throws BizException
	 */
	private void canclePresrt(EmpphyDTO[] empphyDtos) throws BizException {
		String[] idPsndocs = getIdPsndocs(empphyDtos);
		EmpPhyDO[] empphy = queryByPsn(idPsndocs);
		for (EmpPhyDO empPhyDO : empphy) {
			empPhyDO.setFg_presrt(FBoolean.FALSE);
			empPhyDO.setStatus(DOStatus.UPDATED);
		}

		IEmpPhyDOCudService empPhyDOCudService = ServiceFinder.find(IEmpPhyDOCudService.class);
		empPhyDOCudService.update(empphy);
	}

	/**
	 * 查询在医师属性表中存在的人员信息
	 * 
	 * @param allidpsndocs
	 * @return
	 * @throws BizException
	 */
	private EmpPhyDO[] queryByPsn(String[] allidpsndocs) throws BizException {
		IEmpPhyDORService empPhyDORService = ServiceFinder.find(IEmpPhyDORService.class);
		EmpPhyDO[] empphy = empPhyDORService.findByAttrValStrings("Id_psndoc", allidpsndocs);
		return empphy;
	}

	/**
	 * 新增医师属性表
	 * 
	 * @param unSaveIdpsndocs
	 * @throws BizException
	 */
	private void saveEmpPhy(String[] unSaveIdpsndocs) throws BizException {

		if (unSaveIdpsndocs != null && unSaveIdpsndocs.length > 0) {
			IEmpPhyDOCudService empPhyDOCudService = ServiceFinder.find(IEmpPhyDOCudService.class);
			EmpPhyDO[] emPhyDOs = new EmpPhyDO[unSaveIdpsndocs.length];
			for (int i = 0; i < unSaveIdpsndocs.length; i++) {
				EmpPhyDO empPhyDO = new EmpPhyDO();
				empPhyDO.setId_psndoc(unSaveIdpsndocs[i]);
				empPhyDO.setFg_presrt(FBoolean.TRUE);
				emPhyDOs[i] = empPhyDO;
			}
			empPhyDOCudService.insert(emPhyDOs);
		}
	}

	/**
	 * 获取dto中的id_psndoc集合
	 * 
	 * @param empphyDtos
	 * @return
	 * @throws BizException
	 */
	private String[] getIdPsndocs(EmpphyDTO[] empphyDtos) throws BizException {
		if (empphyDtos == null || empphyDtos.length <= 0) {
			throw new BizException("未选择人员！");
		} else {
			String[] idpsndocs = new String[empphyDtos.length];
			for (int i = 0; i < empphyDtos.length; i++) {
				idpsndocs[i] = empphyDtos[i].getId_psndoc();
			}
			return idpsndocs;
		}
	}

	/**
	 * 获取医师属性EmpPhyDO中的id_psndoc集合
	 * 
	 * @param empphy
	 * @return
	 */
	private String[] getIdPsndocs(EmpPhyDO[] empphy) {
		if (empphy == null || empphy.length <= 0) {
			return null;
		} else {
			String[] idpsndocs = new String[empphy.length];
			for (int i = 0; i < empphy.length; i++) {
				idpsndocs[i] = empphy[i].getId_psndoc();
			}
			return idpsndocs;
		}
	}

	/**
	 * 取得数组1中去除数字2后的剩余数组
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public String[] substract(String[] arr1, String[] arr2) {
		if (arr1 == null || arr1.length <= 0) {
			return null;
		}
		if (arr2 == null || arr2.length <= 0) {
			return arr1;
		}
		LinkedList<String> list = new LinkedList<String>();
		for (String str : arr1) {
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		for (String str : arr2) {
			if (list.contains(str)) {
				list.remove(str);
			}
		}
		String[] result = {};
		return list.toArray(result);
	}
}
