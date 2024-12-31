package iih.bd.srv.empphydto.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.EmpPhyDO;
import xap.sys.bdfw.bbd.i.IEmpPhyDOCudService;
import xap.sys.bdfw.bbd.i.IEmpPhyDORService;

/**
 * 保存医生信息</br>
 * 只保存医师医保编码
 * 
 * @author hao_wu
 * @date 2020年3月13日
 *
 */
public class SaveEmpPhyDtoBp {

	public EmpphyDTO exec(EmpphyDTO empPhyDTO) throws BizException {

		IEmpPhyDORService empPhyDORService = ServiceFinder.find(IEmpPhyDORService.class);
		EmpPhyDO[] empPhyDOs = empPhyDORService.findByAttrValString(EmpPhyDO.ID_PSNDOC, empPhyDTO.getId_psndoc());
		if (ArrayUtils.isEmpty(empPhyDOs)) {
			String msg = String.format("根据人员主键\"%s\"未查询到医生属性信息", empPhyDTO.getId_psndoc());
			throw new BizException(msg);
		}

		EmpPhyDO empPhyDO = empPhyDOs[0];

		empPhyDO.setDrid(empPhyDTO.getDrid());
		empPhyDO.setStatus(DOStatus.UPDATED);

		IEmpPhyDOCudService empPhyDOCudService = ServiceFinder.find(IEmpPhyDOCudService.class);
		EmpPhyDO[] result = empPhyDOCudService.update(new EmpPhyDO[] { empPhyDO });
		if (ArrayUtils.isEmpty(result)) {
			throw new BizException("保存医生信息异常");
		}

		empPhyDTO.setStatus(DOStatus.UNCHANGED);
		return empPhyDTO;
	}

}
