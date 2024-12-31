package iih.ci.preop.imp.utils;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.custom.diseasedes.BaseDiseaseDesListener;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class ImportPreUtils {
	/**
	 * 申请单号
	 * 
	 * @param CiEmsDTO
	 *            ciEms
	 * @return
	 * @throws BizException
	 */
	public static String getApplyNoCiEms(String sd_srvtp) throws BizException {

	    if (sd_srvtp == null || sd_srvtp.length() == 0)
            return "";
        // 医疗单类路径
        String classFullName = null;
        BaseDO vo=null;
        if (sd_srvtp.startsWith("02")) {// 检查

            if (sd_srvtp.startsWith("0207")) {// 病理
                classFullName = OrdApPathgyDODesc.CLASS_FULLNAME;
            } else {
                classFullName = OrdApObsDODesc.CLASS_FULLNAME;
            }

        } else if (sd_srvtp.startsWith("03")) {// 检验
            classFullName = OrdApLabDODesc.CLASS_FULLNAME;
            OrdApLabDO lab=new OrdApLabDO();
            lab.setId_dep_app(Context.get().getDeptId());
            vo=lab;

        } else if (sd_srvtp.startsWith("04")) {// 手术
            classFullName = OrdApOpDODesc.CLASS_FULLNAME;
        } else if (sd_srvtp.startsWith("140101")) {// 备血
            classFullName = OrdApBtDODesc.CLASS_FULLNAME;

        } else if (sd_srvtp.startsWith("140102")) {// 用血
            classFullName = OrdAppBtUseDODesc.CLASS_FULLNAME;
        }else if (sd_srvtp.startsWith("0902")) {//会诊
            classFullName = OrdApConsDODesc.CLASS_FULLNAME;
        }

        if (StringUtils.isNotBlank(classFullName)) {
            if(vo!=null) {
                return ServiceFinder.find(IBillcodeManage.class).getBillCode_RequiresNew(classFullName,vo);
            }else {
                return ServiceFinder.find(IBillcodeManage.class).getPreBillCode_RequiresNew(classFullName);
            }
            
        }
        return "";
	}
	
	/**
	 * 查询主诉现病史
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public static String DiseaseDescription(String id_ent) throws BizException {
		FMap2 fmap2 = new FMap2();
		Object[] params = new Object[]{id_ent,fmap2};
		fireBDEvent(BaseDiseaseDesListener.DiseaseDesListenerSourceId, IEventType.TYPE_UPDATE_AFTER, params);
		if(fmap2.containsKey(BaseDiseaseDesListener.DiseaseDesListenerSourceId)){
			return (String)fmap2.get(BaseDiseaseDesListener.DiseaseDesListenerSourceId);
		}
		return null;
	}
	
	/**
	 * 触发事件
	 * 
	 * @param sourceid
	 * @param eventType
	 * @param userObjs
	 * @throws BizException
	 */
	public static void fireBDEvent(String sourceid, String eventType, Object[] userObjs) throws BizException {
		// 触发事件
		BDCommonEvent event = new BDCommonEvent(sourceid, eventType, userObjs);
		EventDispatcher.fireEvent(event);
	}
	
	/**
	 * 
	 * 本次就诊的诊断信息
	 * 
	 * @param id_ent
	 * @return String[] diag; diag[0] = 急性阑尾炎&发热 诊断名称的拼接 diag[1]
	 *         =K35.902&R50.901 诊断编码的 拼接 diag[2] = 001A0000003&011A0000004
	 *         子项目id的拼接 diag[3] = 001A0000003 主诊断 id diag[4] = 主诊断 名称 diag[5] =
	 *         Bd中诊断定义id 遗留问题，后续业务确定使用定义诊断，还是使用业务中诊断 diag[6] = K35.902
	 *         慢性病标识，有慢性病是存的是慢性病的 编码，无慢性病时 是 null diag[7] = 001A0000003 主诊断的主项目
	 *         id
	 */
	public static String[] getDiag(String id_ent) throws BizException {
		ICidiagQryService service = ServiceFinder.find(ICidiagQryService.class);
		CidiagAggDO[] agg = service.getLastCiDiags(id_ent);
		String[] str = new String[8];
		if (agg != null && agg.length > 0) {
			String code = "";
			String name = "";
			String id_items = "";
			String id_didef = "";
			String id_item = ""; // 主诊断
			String name_item = ""; // 主诊断名称
			String name_syn_item = ""; // 主诊断症候
			String fg_chronic = null;// 慢性病标识
			String id_di = "";// 主项目ids
			for (CidiagAggDO aggdo : agg) {
				if (aggdo.getCiDiagItemDO() != null && aggdo.getCiDiagItemDO().length > 0) {

					for (CiDiagItemDO itemDO : aggdo.getCiDiagItemDO()) {
						if (itemDO.getFg_majdi().booleanValue()) {
							id_didef = itemDO.getId_didef();
							id_item = itemDO.getId_diitm();
							name_item = itemDO.getId_didef_name();
							//0180675: 【验证版】门急诊医生站，统一录超量开单的中医诊断，医疗单里的诊断，没有带入症候名称
//							name_syn_item = StringUtils.isEmpty(itemDO.getId_didef_syn_name()) ? ""
//									: "(" + itemDO.getId_didef_syn_name() + ")";
							id_di = itemDO.getId_di();
						}
						// 慢性病
						if (itemDO.getFg_chronic() != null && itemDO.getFg_chronic().booleanValue()) {
							fg_chronic += "&" + itemDO.getDidef_code();
						}

						id_items += "&" + itemDO.getId_diitm();
						// // 自定义诊断
						// if (itemDO.getFg_self() != null &&
						// itemDO.getFg_self().booleanValue()) {
						// code += "&" + itemDO.getId_didef_code();// 定义 0000
						// name += "&" + itemDO.getId_didef_name(); // 诊断说明是否拼接
						// }
						//
						// // 中西医诊断
						if (itemDO.getId_didef_name() != null) {
							code += "&" + itemDO.getId_didef_code();
							name += "&" + itemDO.getId_didef_name();

						}
						// 中医诊断证候
						if (itemDO.getId_didef_syn_code() != null) {
							code += "&" + itemDO.getId_didef_syn_code();
							name += "&" + itemDO.getId_didef_syn_name();
						}
						if (FBoolean.TRUE.equals(itemDO.getFg_suspdi())) {
							name += "?"; // 诊断说明是否拼接
						}
					}

				}
			}

			if (name != "" && name.length() > 1) {
				str[0] = name.substring(1);
			}
			if (code != "" && code.length() > 1) {
				str[1] = code.substring(1);
			}
			if (id_items != null && id_items.length() > 0) {
				str[2] = id_items.substring(1);
			}

			str[3] = id_item;
			str[4] = name_item + name_syn_item;
			str[5] = id_didef;

			if (fg_chronic != null) {
				str[6] = fg_chronic.substring(1);
			} else {
				str[6] = null;
			}
			str[7] = id_di;
		}
		return str;
	}
	
	/**
	 * 是否为空串判断
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isEmpty(String input) {

		return StringUtils.isBlank(input);
	}
	
	/**
	 * 医疗单的匹配
	 * 
	 * @return
	 */
	public static SrvMatchEmsRstDTO getFuncClassStr(CiEnContextDTO envinfo, MedSrvDO medSrvDO) throws BizException {
		SrvMatchEmsParamDTO paramDto = new SrvMatchEmsParamDTO();
		paramDto.setId_srv(medSrvDO.getId_srv());
		paramDto.setId_dept(envinfo.getId_dep_or());
		paramDto.setId_emp(envinfo.getId_emp_or());
		paramDto.setId_grp(envinfo.getId_grp());
		paramDto.setId_org(envinfo.getId_org());
		paramDto.setSd_srvtp(medSrvDO.getSd_srvtp());
		paramDto.setCode_entp(envinfo.getCode_entp());
		paramDto.setEmsappmode(envinfo.getEmsappmode());// 智慧版
		paramDto.setDt_or(ServiceFinder.find(TimeService.class).getUFDateTime());// 系统时间
		
//		EmsMatchRstDTO emsMatchRstDto = ServiceFinder.find(IBdSrvQryService.class).medSrvMatchEms(paramDto);
		FMap rstMap = ServiceFinder.find(IEmsManagementService.class).medSrvMatchEms(new SrvMatchEmsParamDTO[] { paramDto });
		// 进行匹配结果有效性验证
		if (null != rstMap && rstMap.size() > 0) {
			// 根据服务id获取医疗单匹配信息
			return (SrvMatchEmsRstDTO) rstMap.get(medSrvDO.getId_srv());
		}
		return null;
	}
}
