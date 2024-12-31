package iih.ei.std.s.v1.bp.mp.crisisvalue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ei.std.d.v1.mp.lisdata.d.LisCrisisParamDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LisDetail;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import iih.mp.nr.crisisval.d.CrisisValDO;
import iih.mp.nr.crisisval.d.CrisisValLisDO;
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
* @ClassName: UpdateCrisisValueBp
* @Description: 危急值回写
* @author zhy
* @date 2019年9月30日
*
 */
public class UpdateCrisisValueBp {
	
	/**
	 * 程序主入口
	 * @param param
	 * @throws BizException 
	 */
	public void exec(LisCrisisParamDTO param) throws BizException {
		
		// 0.时间格式处理
		formatDate(param);
		
		// 1.参数校验,并获取申请单号
		String[] applynos = valadition(param);
		
		// 2.根据申请单号查询医嘱信息
		CiOrderDO[] orderDOs = ServiceFinder.find(ICiorderMDORService.class).findByAttrValStrings(CiOrderDO.APPLYNO, applynos);
		
		// 3.数据转换胡写危急值表		
		handleData(param, orderDOs);
	}



	/**
	 * 时间格式处理
	 * @param param
	 * @throws BizException
	 */
	private void formatDate(LisCrisisParamDTO param) throws BizException {
		Object obj = null;
		try {
			if (param != null) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				obj = param.getAttrVal("Dt_alert");
				if (obj != null) {
					String dt = obj.toString().replace("/", "-");
					FDateTime dt_exe = new FDateTime(sf.parse(dt).getTime());
					param.setDt_alert(dt_exe + "");

				}
			}
		} catch (Exception e) {
			throw new BizException("医嘱执行状态更新：执行时间【" + obj + "】不合法");
		}
		
	}
	
	/**
	 * 参数校验,获取申请单号
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private String[] valadition(LisCrisisParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getNo_applyform())) {
			throw new BizException("申请单号为空！");
		}
		if (StringUtil.isEmptyWithTrim(param.getId_alert())) {
			throw new BizException("上班ID为空！");
		}
		if (StringUtil.isEmptyWithTrim(param.getCode_emp_alert())) {
			throw new BizException("上报人编码为空！");
		}
		String[] applynos = param.getNo_applyform().split(",");
		return applynos;
	}

	/**
	 * 数据转换回写危急值表
	 * @param param
	 * @param orderDOs
	 * @throws BizException 
	 */
	private void handleData(LisCrisisParamDTO param, CiOrderDO[] orderDOs) throws BizException {
		UdidocDO[] docs = MpnrUtils.getDocsByListCode(new String[] { "CI.OR.9000", "MP.BD.0135" });// Lis报告状态及严重级别档案
		HashMap<String, UdidocDO> docMap = MpnrUtils.mapBaseDO(docs, UdidocDO.CODE);
		CrisisvalAggDO aggDO = new CrisisvalAggDO();
		CrisisValDO crisisDO = new CrisisValDO();// 主表赋值
		crisisDO.setStatus(DOStatus.NEW);
		crisisDO.setId_org(Context.get().getOrgId());
		crisisDO.setId_grp(Context.get().getGroupId());
		crisisDO.setId_alert(param.getId_alert());
		if (null != param.getDt_alert()) {			
			crisisDO.setDt_report(new FDateTime(param.getDt_alert()));
		}
		crisisDO.setId_sirs_level(docMap.get(param.getCode_sirslevel()).getId_udidoc());
		crisisDO.setSd_sirs_level(param.getCode_sirslevel());
		crisisDO.setEu_hnd(EnumHnd.UNHND);
		crisisDO.setEu_doc(EnumHnd.UNHND);
		crisisDO.setEu_nur(EnumHnd.UNHND);
		if (!StringUtil.isEmptyWithTrim(param.getCode_emp_alert())) {
			PsnDocDO[] psndoc = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.CODE, param.getCode_emp_alert());
			if (psndoc != null && psndoc.length > 0)
				crisisDO.setId_emp_report(psndoc[0].getId_psndoc());
		}
		List<CrisisValLisDO> valLisDOs = new ArrayList<CrisisValLisDO>();
		if (orderDOs != null && orderDOs.length > 0) {
			crisisDO.setId_ent(orderDOs[0].getId_en());
			crisisDO.setId_pat(orderDOs[0].getId_pat());
			crisisDO.setId_entp(orderDOs[0].getId_entp());
			crisisDO.setCode_entp(orderDOs[0].getCode_entp());
			crisisDO.setId_srvtp(orderDOs[0].getId_srvtp());
			crisisDO.setSd_srvtp(orderDOs[0].getSd_srvtp());
			String id_ors = "";
			String no_applyforms = "";
			for (CiOrderDO ciOrderDO : orderDOs) {
				id_ors += StringUtil.isEmptyWithTrim(id_ors) ? ciOrderDO.getId_or() : "," + ciOrderDO.getId_or();
				no_applyforms += StringUtil.isEmptyWithTrim(no_applyforms) ? ciOrderDO.getApplyno() : "," + ciOrderDO.getApplyno();
			}
			List<LisDetail> lisDetails = param.getLisdetail();// 子表赋值
			MedSrvDO[] srvs = ServiceFinder.find(IMedsrvMDORService.class).findByAttrValStrings(MedSrvDO.CODE, MpnrUtils.getAttrVal(lisDetails, "Code_rptitm"));
			HashMap<String, MedSrvDO> srvMap = MpnrUtils.mapBaseDO(srvs, MedSrvDO.CODE);
			for (LisDetail lisDetail : lisDetails) {
				CrisisValLisDO lisDO = new CrisisValLisDO();
				lisDO.setStatus(DOStatus.NEW);
				lisDO.setId_or(id_ors);
				lisDO.setNo_applyform(no_applyforms);
				lisDO.setVal(lisDetail.getVal_rstrptlab());
				lisDO.setName_unit(lisDetail.getName_unit());
				if(srvMap.containsKey(lisDetail.getCode_rptitm())){
					lisDO.setId_srv(srvMap.get(lisDetail.getCode_rptitm()).getId_srv());
				}
				lisDO.setCode_srv(lisDetail.getCode_rptitm());
				lisDO.setName_srv(lisDetail.getName_rptitm());
				lisDO.setVal_ref(lisDetail.getVal_reference());
				lisDO.setId_deviate(docMap.get(lisDetail.getCode_deviate()).getId_udidoc());
				lisDO.setSd_deviate(lisDetail.getCode_deviate());
				lisDO.setDescriptions(lisDetail.getDescriptions());
				valLisDOs.add(lisDO);
			}

		}
		aggDO.setParent(crisisDO);
		if (valLisDOs.size() > 0)
			aggDO.setCrisisValLisDO(valLisDOs.toArray(new CrisisValLisDO[0]));
	    ServiceFinder.find(ICrisisvalCudService.class).save(new CrisisvalAggDO[] { aggDO });
	}

}
