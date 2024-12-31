package iih.ei.std.s.v1.bp.pe.pacsdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsCrisisDTO;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import iih.mp.nr.crisisval.d.CrisisValDO;
import iih.mp.nr.crisisval.d.CrisisValObsDO;
import iih.mp.nr.crisisval.d.CrisisvalAggDO;
import iih.mp.nr.crisisval.d.EnumHnd;
import iih.mp.nr.crisisval.i.ICrisisvalCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.xbd.udi.d.UdidocDO;
/**
 * 
* @ClassName: UpdateObsCrisisBp
* @Description: 检查危急值回写
* @author zhy
* @date 2019年9月30日
*
 */
public class UpdatePeObsCrisisBp {
	
	/**
	 * 程序入口
	 * @param param
	 * @throws BizException 
	 */
	public void exec(RptObsCrisisDTO param) throws BizException {
		
		// 1.参数校验,获取申请单号
		String[] applynos = valadition(param);
		
		// 2.根据申请单号查询医嘱信息
		CiOrderDO[] orderDOs = ServiceFinder.find(ICiorderMDORService.class).findByAttrValStrings(CiOrderDO.APPLYNO, applynos);

		// 3.数据转换回写危急值表
		handleData(param, orderDOs);
		
	}


	/**
	 * 参数校验,获取申请单号
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private String[] valadition(RptObsCrisisDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getNo_applyform()))
			throw new BizException("申请单号为空！");
		if (StringUtil.isEmptyWithTrim(param.getId_alert()))
			throw new BizException("上报ID为空！");
		if (StringUtil.isEmptyWithTrim(param.getCode_emp_alert()))
			throw new BizException("上报人编码为空！");
		String[] applynos = param.getNo_applyform().split(",");
		return applynos;
	}

	/**
	 * 数据转换回写危急值表
	 * @param param
	 * @param orderDOs
	 * @throws BizException 
	 */
	private void handleData(RptObsCrisisDTO param, CiOrderDO[] orderDOs) throws BizException {
		UdidocDO[] docs = MpnrUtils.getDocsByListCode(new String[] { "MP.BD.0135" });// 严重级别档案
		HashMap<String, UdidocDO> docMap = MpnrUtils.mapBaseDO(docs, UdidocDO.CODE);
		CrisisvalAggDO aggDO = new CrisisvalAggDO();
		CrisisValDO crisisDO = new CrisisValDO();
		crisisDO.setStatus(DOStatus.NEW);
		crisisDO.setId_org(Context.get().getOrgId());
		crisisDO.setId_grp(Context.get().getGroupId());
		crisisDO.setId_alert(param.getId_alert());
		if (null != param.getDt_alert()) {			
			crisisDO.setDt_report(new FDateTime(param.getDt_alert()));
		}
		crisisDO.setEu_hnd(EnumHnd.UNHND);
		crisisDO.setEu_doc(EnumHnd.UNHND);
		crisisDO.setEu_nur(EnumHnd.UNHND);
		if (!StringUtil.isEmptyWithTrim(param.getCode_emp_alert())) {
			PsnDocDO[] psndoc = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.CODE, param.getCode_emp_alert());
			if (psndoc != null && psndoc.length > 0)
				crisisDO.setId_emp_report(psndoc[0].getId_psndoc());
		}
		List<CrisisValObsDO> valObsDOs = new ArrayList<CrisisValObsDO>();
		if (orderDOs != null && orderDOs.length > 0) {
			crisisDO.setId_ent(orderDOs[0].getId_en());
			crisisDO.setId_pat(orderDOs[0].getId_pat());
			crisisDO.setId_entp(orderDOs[0].getId_entp());
			crisisDO.setCode_entp(orderDOs[0].getCode_entp());
			crisisDO.setId_srvtp(orderDOs[0].getId_srvtp());
			crisisDO.setSd_srvtp(orderDOs[0].getSd_srvtp());
			crisisDO.setId_sirs_level(docMap.get(param.getCode_sirslevel()).getId_udidoc());
			crisisDO.setSd_sirs_level(param.getCode_sirslevel());
			for (CiOrderDO ciOrderDO : orderDOs) {
				CrisisValObsDO obsDO = new CrisisValObsDO();
				obsDO.setStatus(DOStatus.NEW);
				obsDO.setId_or(ciOrderDO.getId_or());
				obsDO.setNo_applyform(ciOrderDO.getApplyno());
				obsDO.setVal(param.getVal_rstrptlab());
				obsDO.setContent(param.getContent());
				obsDO.setDescriptions(param.getDescriptions());
				valObsDOs.add(obsDO);
			}
		}
		aggDO.setParent(crisisDO);
		if (valObsDOs.size() > 0)
			aggDO.setCrisisValObsDO(valObsDOs.toArray(new CrisisValObsDO[0]));
		
		ServiceFinder.find(ICrisisvalCudService.class).save(new CrisisvalAggDO[] { aggDO });
		
	}
}
