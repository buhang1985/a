package iih.ci.mb.bp;

import iih.bd.base.utils.FileServerUtils;
import iih.ci.mb.dcmo.d.DoctorMemoFileDO;
import iih.ci.mb.dcmo.d.DoctormemoAggDO;
import iih.ci.mb.dcmo.i.IDoctormemoCudService;
import iih.ci.mb.dcmo.i.IDoctormemoRService;
import iih.ci.mb.i.DelDoctorMemorandumRequest;
import iih.ci.mb.i.DelDoctorMemorandumResponse;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除医生备忘录
 * 
 * @author wangwei
 * @since 2018-03-20
 *
 */
public class DelDoctorMemorandumListByMemoIDBP {

	public DelDoctorMemorandumResponse exec(DelDoctorMemorandumRequest request) throws BizException {
		DelDoctorMemorandumResponse rtn = new DelDoctorMemorandumResponse();

		// 1、基础校验
		if (!validation(request.getGUID()))
			return rtn;

		// 2、删数据
		DoctormemoAggDO[] doctormemoAggDOs2;
		DoctormemoAggDO docAggHad = ServiceFinder.find(IDoctormemoRService.class).findById(request.getGUID());
		if (docAggHad != null && docAggHad.getParentDO() != null) {
			try {
				DoctorMemoFileDO[] doctorMemoFiles = docAggHad.getDoctorMemoFileDO();
				if (doctorMemoFiles != null && doctorMemoFiles.length > 0) {
					for (DoctorMemoFileDO doctorMemoFile : doctorMemoFiles) {

						FileServerUtils.Delete(doctorMemoFile.getFilename(), true);
					}
				}
				doctormemoAggDOs2 = new DoctormemoAggDO[] { docAggHad };
				ServiceFinder.find(IDoctormemoCudService.class).delete(doctormemoAggDOs2);
				rtn.setDelDoctorMemorandumResult(1);
			} catch (Exception e) {

				rtn.setDelDoctorMemorandumResult(0);
			}

		}

		return rtn;

	}

	private boolean validation(String guid) {

		if (guid != null && guid != "")
			return true;
		return false;
	}

}
