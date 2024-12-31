package iih.bd.fc.wf.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.i.IWfMDOCudService;
import iih.bd.fc.wf.i.IWfSrvtpDOCudService;
import iih.bd.fc.wf.i.IWfSrvtpDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * bd_wf保存bp
 * @author guoyang
 *
 */
public class WfSaveBp {

	public WfDO exec(WfDO wfDO) throws BizException {
		//1、验证服务类型
		validation(wfDO);
		
		// 2、构建服务类型
		List<WfSrvtpDO> saveList = buildSrvtp(wfDO);
		
		//3.服务类型叠加校验
		overLapValidation(wfDO, saveList);
		
		//4.保存bd_wf
		WfDO wf = saveWf(wfDO);
		
		//5.设置外键
		setPrimaryKey(saveList, wf);
		
		//6.保存服务类型
		saveWfSrvtp(saveList);
		
		//返回wfdo
		return wf;
	}
	
	/**
	 * 保存
	 * @param wfDO
	 * @throws BizException 
	 */
	private WfDO saveWf(WfDO wfDO) throws BizException {
		if(wfDO == null){
			return null;
		}
		IWfMDOCudService wfMDOCudService = ServiceFinder.find(IWfMDOCudService.class);
		WfDO wf = wfMDOCudService.save(new WfDO[]{wfDO})[0];
		wf.setId_srvtp(wfDO.getId_srvtp());
		wf.setName_srvtp(wfDO.getName_srvtp());
		wf.setCode_srvtp(wfDO.getCode_srvtp());
		return wf;
	}

	/**
	 * 服务类型叠加校验
	 * @param saveList 
	 * 
	 * @param AggDO
	 * @throws BizException
	 */
	private void overLapValidation(WfDO wfDO, List<WfSrvtpDO> saveList) throws BizException {

		WfValidationBp bp = new WfValidationBp();

		bp.exec(wfDO, saveList);
	}
	
	/**
	 * 构建服务类型
	 * @param wfDO
	 * @return 
	 * @throws BizException 
	 */
	private List<WfSrvtpDO> buildSrvtp(WfDO wfDO) throws BizException {
		List<WfSrvtpDO> saveList = new ArrayList<WfSrvtpDO>();

		InitDelete(wfDO, saveList);

		UdidocDO[] SrvtpDOS = getSrvtpDOS(wfDO);

		if (SrvtpDOS != null && SrvtpDOS.length > 0) {

			for (UdidocDO udidocDO : SrvtpDOS) {

				WfSrvtpDO srvtp = new WfSrvtpDO();
				srvtp.setId_wf(wfDO.getId_wf());
				srvtp.setId_srvtp(udidocDO.getId_udidoc());
				srvtp.setSd_srvtp(udidocDO.getCode());
				srvtp.setName(udidocDO.getName());
				srvtp.setStatus(DOStatus.NEW);
				saveList.add(srvtp);
			}
		}
		return saveList;
	}
	
	/**
	 * 外键赋值
	 * @param saveList 
	 * @param AggDO
	 */
	private void setPrimaryKey(List<WfSrvtpDO> saveList, WfDO wfDO) {

		if(saveList == null || saveList.size() <= 0){
			return;
		}
		for (WfSrvtpDO wfSrvtpDO : saveList) {
			if (wfSrvtpDO.getStatus() == DOStatus.NEW) {

				wfSrvtpDO.setAttrVal("Id_wf", wfDO.getId_wf());
			}
		}
		
	}
	
	/**
	 * 保存BD_WF_SRVTP
	 * @param saveList
	 * @throws BizException 
	 */
	private void saveWfSrvtp(List<WfSrvtpDO> saveList) throws BizException {
		if(saveList != null && saveList.size() > 0){
			IWfSrvtpDOCudService wfSrvtpDOCudService = ServiceFinder.find(IWfSrvtpDOCudService.class);
			wfSrvtpDOCudService.save(saveList.toArray(new WfSrvtpDO[saveList.size()]));
		}
	}

	/**
	 * 根据WFDO中的计算字段服务类型id获取相关集合
	 * @param wfDO
	 * @return
	 * @throws BizException 
	 */
	private UdidocDO[] getSrvtpDOS(WfDO wfDO) throws BizException {
		IUdidocRService findService = ServiceFinder.find(IUdidocRService.class);

		List<String> listSrvtp = new ArrayList<String>();

		for (String id_srvtp : wfDO.getId_srvtp().split(",")) {

			listSrvtp.add(id_srvtp);
		}

		return findService.findByIds(listSrvtp.toArray(new String[listSrvtp.size()]), FBoolean.FALSE);
	}

	/**
	 * 删除现有的服务类型
	 * @param wfDO
	 * @param saveList
	 * @throws BizException 
	 */
	private void InitDelete(WfDO wfDO, List<WfSrvtpDO> saveList) throws BizException {

		WfSrvtpDO[] srvtpDOS = getWfSrvtpDO(wfDO);

		if (srvtpDOS != null && srvtpDOS.length > 0) {

			for (WfSrvtpDO wfSrvtpDO : srvtpDOS) {

				wfSrvtpDO.setStatus(DOStatus.DELETED);
				saveList.add(wfSrvtpDO);
			}
		}
	}

	/**
	 * 获取BD_WF_SRVTP表中的数据
	 * @param wfDO
	 * @return
	 * @throws BizException 
	 */
	private WfSrvtpDO[] getWfSrvtpDO(WfDO wfDO) throws BizException {
		if(wfDO == null || wfDO.getId_wf() == null){
			return null;
		}
		IWfSrvtpDORService wfIWfSrvtpDORService = ServiceFinder.find(IWfSrvtpDORService.class);
		return wfIWfSrvtpDORService.findByAttrValString("Id_wf", wfDO.getId_wf());
	}

	/**
	 * 校验
	 * @param wfDO 
	 * @throws BizException 
	 */
	private void validation(WfDO wfDO) throws BizException {
		if(wfDO == null){
			return;
		}
		
		if(!StringUtil.isEmpty(wfDO.getId_srvtp())){
			return;
		}else{
			throw new BizException("医嘱流向配置保存，服类型不能为空！");
		}
	}

}
